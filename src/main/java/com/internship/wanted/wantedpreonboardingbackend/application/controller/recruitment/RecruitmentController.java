package com.internship.wanted.wantedpreonboardingbackend.application.controller.recruitment;

import com.internship.wanted.wantedpreonboardingbackend.application.usecase.DeleteRecruitmentUsecase;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.dto.RecruitmentForm;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.service.RecruitmentReadService;
import com.internship.wanted.wantedpreonboardingbackend.domain.recruitment.service.RecruitmentWriteService;
import javax.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recruitments")
@RequiredArgsConstructor
public class RecruitmentController {

	private final RecruitmentWriteService recruitmentWriteService;
	private final RecruitmentReadService recruitmentReadService;
	private final DeleteRecruitmentUsecase deleteRecruitmentUsecase;

	@PostMapping("/registration")
	public ResponseEntity<?> registration(@RequestBody RecruitmentForm.Request request) {
		return ResponseEntity.ok().body(recruitmentWriteService.registration(request));
	}

	@GetMapping("/{id}/detail")
	public ResponseEntity<?> getDetailByRecruitmentId(@PathVariable Long id) {
		return ResponseEntity.ok().body(recruitmentReadService.getDetailByRecruitmentId(id));
	}

	@PutMapping("/{id}/modify")
	public ResponseEntity<?> updateRecruitment(
		@PathVariable Long id,
		@RequestBody RecruitmentForm.Request request) {
		return ResponseEntity.ok().body(recruitmentWriteService.updateRecruitmentDetail(id, request));
	}

	@DeleteMapping("/delete/{recruitmentId}")
	public ResponseEntity<?> deleteRecruitment(@PathVariable Long recruitmentId) {
		deleteRecruitmentUsecase.execute(recruitmentId);
		return ResponseEntity.ok().body(true);
	}

	@GetMapping("/page=?")
	public ResponseEntity<?> getRecruitments(@RequestParam @Min(1) Long num) {
		return ResponseEntity.ok().body(recruitmentReadService.getRecruitments(num));
	}
}
