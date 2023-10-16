package com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.repositoty;

import com.internship.wanted.wantedpreonboardingbackend.domain.company.entity.Company;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.entity.Recruitment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {

	List<Recruitment> findAllByCompany(Company company);
}
