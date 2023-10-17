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
		private String region; // 지역
		private String country; // 국가
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

		private String title;
		private String companyName;
		private String region;
		private String country;
		private String position;
		private Long compensation;
		private String skill;
		private LocalDate deadline;

		public static Response fromEntity(Recruitment entity) {
			return Response.builder()
				.title(entity.getTitle())
				.companyName(entity.getCompanyName())
				.compensation(entity.getCompensation())
				.region(entity.getRegion())
				.country(entity.getCountry())
				.companyName(entity.getCompanyName())
				.position(entity.getPosition())
				.skill(entity.getSkill())
				.deadline(entity.getDeadline())
				.build();
		}
	}

}
