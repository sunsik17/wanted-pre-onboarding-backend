package com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.repositoty;

import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {

}
