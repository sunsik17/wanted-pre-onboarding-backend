package com.internship.wanted.wantedpreonboardingbackend.application.usecase;

import com.internship.wanted.wantedpreonboardingbackend.domain.apply.dto.ApplyingDto;
import com.internship.wanted.wantedpreonboardingbackend.domain.apply.service.ApplyingWriteService;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.dto.RecruitmentDto;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.service.RecruitmentReadService;
import com.internship.wanted.wantedpreonboardingbackend.domain.user.dto.UserDto;
import com.internship.wanted.wantedpreonboardingbackend.domain.user.service.UserReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyingToRecruitmentUsercase {

	private final UserReadService userReadService;
	private final RecruitmentReadService recruitmentReadService;
	private final ApplyingWriteService applyingWriteService;

	public ApplyingDto execute(Long toRecruitmentId, Long fromUserId) {

		RecruitmentDto toRecruitment = recruitmentReadService.getRecruitment(toRecruitmentId);
		UserDto fromUser = userReadService.getUser(fromUserId);

		return applyingWriteService.applying(toRecruitment, fromUser);
	}
}
