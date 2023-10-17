package com.internship.wanted.wantedpreonboardingbackend.domain.apply.repository;

import com.internship.wanted.wantedpreonboardingbackend.domain.apply.entity.Applying;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyingRepository extends JpaRepository<Applying, Long> {

	Optional<Applying> findByRecruitmentIdAndUserId(Long recruitmentId, Long userId);

	List<Applying> findAllByRecruitmentId(Long recruitmentId);

	void deleteAllByRecruitmentId(Long recruitmentId);
}
