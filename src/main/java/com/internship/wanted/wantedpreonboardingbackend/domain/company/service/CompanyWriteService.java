package com.internship.wanted.wantedpreonboardingbackend.domain.company.service;

import com.internship.wanted.wantedpreonboardingbackend.domain.company.entity.Company;
import com.internship.wanted.wantedpreonboardingbackend.domain.company.repository.CompanyRepository;
import java.io.IOException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyWriteService {

	private static final String STATIC_SCRAP_URL = "https://www.saramin.co.kr/zf_user/jobs/list/industry?ind_key=30118";
	private static final String PRODUCT_PREFIX = "sri_section";
	private static final String DIV_CORP_PREFIX = "corp";
	private static final String HREF_CLASS_PREFIX = "str_tit";

	private final CompanyRepository companyRepository;

	public void save() {
		try {
			Connection connection = Jsoup.connect(STATIC_SCRAP_URL);
			Document document = connection.get();

			Elements elements = Objects.requireNonNull(document.getElementById(PRODUCT_PREFIX))
				.children();

			for (Element e : elements) {
				String[] companies = e.getElementsByClass(DIV_CORP_PREFIX).text().split(" ");
				companiesRoofSave(companies);
				companies = e.getElementsByClass(HREF_CLASS_PREFIX).text().split(" ");
				companiesRoofSave(companies);
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void companiesRoofSave(String[] companyNames) {
		for (String companyName : companyNames) {
			try {
				companyRepository.save(Company.builder()
					.companyName(companyName)
					.build());
			} catch (Exception exception) {
				exception.getStackTrace();
			}
		}
	}
}
