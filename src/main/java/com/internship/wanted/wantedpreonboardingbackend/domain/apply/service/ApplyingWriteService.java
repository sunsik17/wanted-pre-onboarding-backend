package com.internship.wanted.wantedpreonboardingbackend.domain.apply.service;

import com.internship.wanted.wantedpreonboardingbackend.domain.apply.dto.ApplyingDto;
import com.internship.wanted.wantedpreonboardingbackend.domain.apply.entity.Applying;
import com.internship.wanted.wantedpreonboardingbackend.domain.apply.repository.ApplyingRepository;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.dto.RecruitmentDto;
import com.internship.wanted.wantedpreonboardingbackend.domain.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyingWriteService {

	private final ApplyingRepository applyingRepository;

	public ApplyingDto applying(RecruitmentDto recruitmentDto, UserDto userDto) {
		Long recruitmentId = recruitmentDto.getRecruitmentId();
		Long userId = userDto.getUserId();
		validApplying(recruitmentId, userId);

		return ApplyingDto.fromEntity(applyingRepository.save(
			Applying.builder()
				.toRecruitmentId(recruitmentId)
				.fromUserId(userId)
				.build()));
	}

	private void validApplying(Long recruitmentId, Long userId) {
		if (applyingRepository.findByToRecruitmentIdAndFromUserId(recruitmentId, userId).isPresent()) {
			throw new RuntimeException("공고 하나에 한번만 지원할 수 있습니다.");
		}
	}
}
