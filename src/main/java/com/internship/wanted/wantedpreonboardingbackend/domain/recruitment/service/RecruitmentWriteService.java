package com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.service;

import com.internship.wanted.wantedpreonboardingbackend.domain.company.entity.Company;
import com.internship.wanted.wantedpreonboardingbackend.domain.company.repository.CompanyRepository;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.dto.RecruitmentForm;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.entity.Recruitment;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.repositoty.RecruitmentRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentWriteService {

	private final RecruitmentRepository recruitmentRepository;
	private final CompanyRepository companyRepository;

	/*
	 * request form
	 * 회사 id, 회사 이름, 제목, 포지션, 채용보상금, 내용, 기술, 마감기한
	 */
	public RecruitmentForm.Response registration(RecruitmentForm.Request request) {
		Company company = companyRepository.findById(request.getCompanyId())
			.orElseThrow(() -> new RuntimeException("회사를 찾을 수 없습니다."));

		validateDeadline(request.getDeadline());

		Recruitment recruitment = recruitmentRepository.save(
			Recruitment.builder()
				.companyName(company.getCompanyName())
				.companyId(company.getId())
				.compensation(request.getCompensation())
				.contents(request.getContents())
				.title(request.getTitle())
				.skill(request.getSkill())
				.deadline(request.getDeadline())
				.position(request.getPosition())
				.build());

		return RecruitmentForm.Response.fromEntity(recruitment);
	}

	private void validateDeadline(LocalDate deadline) {
		if (!deadline.isAfter(LocalDate.now())) {
			throw new RuntimeException("마감기한은 현재보다 이전일 수 없습니다.");
		}
	}
}
