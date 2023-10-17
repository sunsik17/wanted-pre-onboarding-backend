package com.internship.wanted.wantedpreonboardingbackend.domain.apply.service;


import com.internship.wanted.wantedpreonboardingbackend.domain.apply.dto.ApplyingDto;
import com.internship.wanted.wantedpreonboardingbackend.domain.apply.repository.ApplyingRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyingReadService {

	private final ApplyingRepository applyingRepository;

	public List<ApplyingDto> getApplyingUserList(Long toRecruitmentId) {
		return applyingRepository.findAllByRecruitmentId(toRecruitmentId)
			.stream().map(ApplyingDto::fromEntity).collect(Collectors.toList());
	}
}
