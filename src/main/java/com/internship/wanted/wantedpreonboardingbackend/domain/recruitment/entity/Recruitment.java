package com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.entity;

import com.internship.wanted.wantedpreonboardingbackend.domain.BaseEntity;
import com.internship.wanted.wantedpreonboardingbackend.domain.company.entity.Company;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String region;
	private String country;
	private String companyName;
	private String position;
	private String contents;
	private Long compensation;
	private String skill;
	private LocalDate deadline;
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
}
