package com.airside.passport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.airside.passport.service.UnmarshallingPassportService;

@RestController
public class UnmarshallingPassportController {

	private UnmarshallingPassportService unmarshallingPassportService;

	@Autowired
	public UnmarshallingPassportController(UnmarshallingPassportService unmarshallingPassportService) {

		this.unmarshallingPassportService = unmarshallingPassportService;
	}

	/**
	 * @param passportBody
	 * @return
	 */
	@GetMapping("fullnameFromPassport")
	public String fullnameFromPassport(@PathVariable String passportBody) {

		return unmarshallingPassportService.mainUnmarshallingPassportService(passportBody);
	}
}

