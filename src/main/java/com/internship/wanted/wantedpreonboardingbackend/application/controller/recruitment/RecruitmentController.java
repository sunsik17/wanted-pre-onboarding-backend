package com.internship.wanted.wantedpreonboardingbackend.application.controller.recruitment;

import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.dto.RecruitmentForm;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.service.RecruitmentWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recruitments")
@RequiredArgsConstructor
public class RecruitmentController {

	private final RecruitmentWriteService recruitmentWriteService;

	@PostMapping("/registration")
	public ResponseEntity<?> registration(@RequestBody RecruitmentForm.Request request) {
		return ResponseEntity.ok().body(recruitmentWriteService.registration(request));
	}
}
