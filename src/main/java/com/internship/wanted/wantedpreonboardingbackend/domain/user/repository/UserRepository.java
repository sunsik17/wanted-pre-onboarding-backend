package com.internship.wanted.wantedpreonboardingbackend.domain.user.repository;

import com.internship.wanted.wantedpreonboardingbackend.domain.user.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAllByIdIn(List<Long> userIds);
}
