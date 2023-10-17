package com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.service;

import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.dto.RecruitmentDetail;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.dto.RecruitmentDto;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.entity.Recruitment;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.repositoty.RecruitmentRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentReadService {

	private final RecruitmentRepository recruitmentRepository;

	public RecruitmentDetail getDetailByRecruitmentId(Long id) {
		Recruitment recruitment = recruitmentRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("공고를 찾을 수 없습니다."));

		RecruitmentDetail recruitmentDetail =
			RecruitmentDetail.fromEntity(recruitment);

		recruitmentDetail.setOtherRecruitmentIds(
			recruitmentRepository
				.findAllByCompany(recruitment.getCompany())
				.stream().map(Recruitment::getId).collect(Collectors.toList())
		);

		return recruitmentDetail;
	}

	public RecruitmentDto getRecruitment(Long recruitmentId) {
		return RecruitmentDto.fromEntity(recruitmentRepository.findById(recruitmentId)
			.orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다.")));
	}

}
