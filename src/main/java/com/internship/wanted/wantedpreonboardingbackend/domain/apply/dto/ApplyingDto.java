package com.internship.wanted.wantedpreonboardingbackend.domain.apply.dto;

import com.internship.wanted.wantedpreonboardingbackend.domain.apply.entity.Applying;
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
public class ApplyingDto {
	private Long id;
	private Long userId;
	private Long recruitmentId;

	public static ApplyingDto fromEntity(Applying applying) {
		return ApplyingDto.builder()
			.id(applying.getId())
			.userId(applying.getUserId())
			.recruitmentId(applying.getRecruitmentId())
			.build();
	}
}
