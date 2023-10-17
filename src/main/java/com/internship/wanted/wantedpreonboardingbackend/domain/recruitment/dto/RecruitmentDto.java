package com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.dto;

import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.entity.Recruitment;
import java.time.LocalDate;
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
public class RecruitmentDto {
	private Long recruitmentId;
	private String companyName;
	private LocalDate deadline;

	public static RecruitmentDto fromEntity(Recruitment recruitment) {
		return RecruitmentDto.builder()
			.recruitmentId(recruitment.getId())
			.companyName(recruitment.getCompanyName())
			.deadline(recruitment.getDeadline())
			.build();
	}
}
