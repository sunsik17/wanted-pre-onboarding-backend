package com.internship.wanted.wantedpreonboardingbackend.domain.user.dto;


import com.internship.wanted.wantedpreonboardingbackend.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

public class UserForm {
	@Getter
	@Builder
	public static class Request {
		private Long userId;
	}
	@Getter
	@Builder
	public static class Response {
		private Long userId;
		public static Response fromEntity(User user) {
			return Response.builder()
				.userId(user.getId())
				.build();
		}
	}
}
