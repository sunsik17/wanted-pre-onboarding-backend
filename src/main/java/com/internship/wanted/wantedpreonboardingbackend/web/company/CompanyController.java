package com.internship.wanted.wantedpreonboardingbackend.web.company;

import com.internship.wanted.wantedpreonboardingbackend.domain.company.service.CompanyWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

	private final CompanyWriteService companyWriteService;

	@PostMapping("/registration")
	public ResponseEntity<?> registration (){
		companyWriteService.save();
		return ResponseEntity.ok().body("성공");
	}

}
