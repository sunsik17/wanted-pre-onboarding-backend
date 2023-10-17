package com.internship.wanted.wantedpreonboardingbackend.domain.apply.repository;

import com.internship.wanted.wantedpreonboardingbackend.domain.apply.entity.Applying;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyingRepository extends JpaRepository<Applying, Long> {
	Optional<Applying> findByToRecruitmentIdAndFromUserId(Long companyId, Long userId);
	List<Applying> findAllByToRecruitmentId(Long toRecruitmentId);
	void deleteAllByToRecruitmentId(Long toRecruitmentId);
}
