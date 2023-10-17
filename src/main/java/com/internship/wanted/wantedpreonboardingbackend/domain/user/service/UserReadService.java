package com.internship.wanted.wantedpreonboardingbackend.domain.user.service;

import com.internship.wanted.wantedpreonboardingbackend.domain.user.dto.UserDto;
import com.internship.wanted.wantedpreonboardingbackend.domain.user.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserReadService {

	private final UserRepository userRepository;

	public UserDto getUser(Long userId) {
		return UserDto.fromEntity(userRepository.findById(userId)
			.orElseThrow(() -> new RuntimeException("해당 유저가 없습니다.")));
	}
	public List<UserDto> getUsers(List<Long> userIds) {
		return userRepository.findAllByIdIn(userIds)
			.stream().map(UserDto::fromEntity).collect(Collectors.toList());
	}
}
