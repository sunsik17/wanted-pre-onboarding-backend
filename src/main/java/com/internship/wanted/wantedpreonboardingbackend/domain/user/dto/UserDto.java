package com.internship.wanted.wantedpreonboardingbackend.domain.user.dto;

import com.internship.wanted.wantedpreonboardingbackend.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long userId;

	public static UserDto fromEntity(User entity) {
		return UserDto.builder()
			.userId(entity.getId())
			.build();
	}
}
