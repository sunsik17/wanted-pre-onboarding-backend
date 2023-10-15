package com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.entity;

import com.internship.wanted.wantedpreonboardingbackend.domain.BaseEntity;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recruitment extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Long companyId;
	private String companyName;
	private String position;
	private String contents;
	private Long compensation;
	private String skill;
	private LocalDate deadline;
}
