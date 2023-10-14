package com.internship.wanted.wantedpreonboardingbackend.domain;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@MappedSuperclass
public class BaseEntity {
	@CreatedDate
	private LocalDateTime createDateTime;
	@LastModifiedDate
	private LocalDateTime updateDateTime;
}
