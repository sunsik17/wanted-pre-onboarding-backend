package com.internship.wanted.wantedpreonboardingbackend.application.usecase;

import com.internship.wanted.wantedpreonboardingbackend.domain.apply.service.ApplyingWriteService;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.service.RecruitmentWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteRecruitmentUsecase {

	private final RecruitmentWriteService recruitmentWriteService;
	private final ApplyingWriteService applyingWriteService;

	public void execute(Long recruitmentId) {
		recruitmentWriteService.deleteRecruitment(recruitmentId);
		applyingWriteService.deleteApplying(recruitmentId);
	}
}
