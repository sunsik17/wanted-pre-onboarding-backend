package com.internship.wanted.wantedpreonboardingbackend.application.usecase;

import com.internship.wanted.wantedpreonboardingbackend.domain.apply.dto.ApplyingDto;
import com.internship.wanted.wantedpreonboardingbackend.domain.apply.service.ApplyingReadService;
import com.internship.wanted.wantedpreonboardingbackend.domain.user.dto.UserDto;
import com.internship.wanted.wantedpreonboardingbackend.domain.user.service.UserReadService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetApplyingUserUsecase {

	private final ApplyingReadService applyingReadService;
	private final UserReadService userReadService;

	public List<UserDto> execute(Long recruitmentId) {
		List<ApplyingDto> applyingUserList = applyingReadService.getApplyingUserList(recruitmentId);
		List<Long> applyingUserIds =
			applyingUserList.stream().map(ApplyingDto::getUserId).collect(Collectors.toList());

		return userReadService.getUsers(applyingUserIds);
	}

}
