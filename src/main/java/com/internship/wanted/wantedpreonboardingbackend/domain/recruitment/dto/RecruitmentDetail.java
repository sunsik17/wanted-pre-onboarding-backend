package com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.dto;

import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.entity.Recruitment;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//"채용공고_id": 채용공고_id,
//  "회사명":"원티드랩",
//  "국가":"한국",
//  "지역":"서울",
//  "채용포지션":"백엔드 주니어 개발자",
//  "채용보상금":1500000,
//  "사용기술":"Python",
//	"채용내용": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
//	"회사가올린다른채용공고":[채용공고_id, 채용공고_id, ..] # id List (선택사항 및 가산점요소).
public class RecruitmentDetail {
	private Long id;
	private String companyName;
	private String position;
	private Long compensation;
	private String skill;
	private LocalDate deadline;
	private String contents;
	private List<Long> otherRecruitmentIds;

	public static RecruitmentDetail fromEntity(Recruitment entity) {
		return RecruitmentDetail.builder()
			.companyName(entity.getCompanyName())
			.id(entity.getId())
			.position(entity.getPosition())
			.compensation(entity.getCompensation())
			.skill(entity.getSkill())
			.deadline(entity.getDeadline())
			.contents(entity.getContents())
			.build();
	}
}
