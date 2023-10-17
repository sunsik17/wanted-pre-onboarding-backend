package com.internship.wanted.wantedpreonboardingbackend.application.controller.applying;


import com.internship.wanted.wantedpreonboardingbackend.application.usecase.ApplyingToRecruitmentUsecase;
import com.internship.wanted.wantedpreonboardingbackend.application.usecase.GetApplyingUserUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/applying")
public class ApplyingController {

	private final ApplyingToRecruitmentUsecase applyingToRecruitmentUsecase;
	private final GetApplyingUserUsecase getApplyingUserUsecase;

	@PostMapping("/{toRecruitmentId}/{fromUserId}")
	public ResponseEntity<?> applying(@PathVariable Long toRecruitmentId,
		@PathVariable Long fromUserId) {
		return ResponseEntity.ok()
			.body(applyingToRecruitmentUsecase.execute(toRecruitmentId, fromUserId));
	}

	@GetMapping("/users/{fromRecruitmentId}")
	public ResponseEntity<?> getApplyingUserList(@PathVariable Long fromRecruitmentId) {
		return ResponseEntity.ok()
			.body(getApplyingUserUsecase.execute(fromRecruitmentId));
	}

}
