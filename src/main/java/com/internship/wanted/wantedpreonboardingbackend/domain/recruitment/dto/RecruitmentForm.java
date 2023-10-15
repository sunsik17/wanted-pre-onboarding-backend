package com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.dto;

import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.entity.Recruitment;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RecruitmentForm {
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Request {
		private Long companyId;
		private String title; // 제목
		private String position; // 포지션
		private Long compensation; // 채용보상금
		private String contents; // 내용
		private String skill; // 기술
		private LocalDate deadline; // 마감기한
	}
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Response {
		private Long companyId;
		private String title;
		private String companyName;
		private String position;
		private Long compensation;
		private String contents;
		private String skill;
		private LocalDate deadline;

		public static Response fromEntity(Recruitment entity) {
			return Response.builder()
				.companyId(entity.getCompanyId())
				.compensation(entity.getCompensation())
				.companyName(entity.getCompanyName())
				.position(entity.getPosition())
				.contents(entity.getContents())
				.skill(entity.getSkill())
				.build();
		}
	}

}
