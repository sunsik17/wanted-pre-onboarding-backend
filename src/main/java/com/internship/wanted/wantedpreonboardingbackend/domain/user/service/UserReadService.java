package com.internship.wanted.wantedpreonboardingbackend.domain.user.service;

import com.internship.wanted.wantedpreonboardingbackend.domain.user.dto.UserForm;
import com.internship.wanted.wantedpreonboardingbackend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserReadService {

	private final UserRepository userRepository;

	public UserForm.Response getUser(UserForm.Request request) {
		return UserForm.Response
			.fromEntity(userRepository.findById(request.getUserId())
			.orElseThrow(() -> new RuntimeException("해당 유저가 없습니다.")));
	}
}
