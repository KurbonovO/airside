package com.airside.passport.service;

import org.junit.jupiter.api.Test;

public class UnmarshallingPassportServiceTest {

	private UnmarshallingPassportService unmarshallingPassportService = new UnmarshallingPassportService();

	@Test
	public void test1() {

		System.out.println(unmarshallingPassportService.mainUnmarshallingPassportService(
				"P<USAROGGER<<MICHAEL<<<<<<<<<<<<<<<<<<<<<<<<YA11164461USA8502201M2001023<<<<<<<<<<<<<<00"));

	}

}
