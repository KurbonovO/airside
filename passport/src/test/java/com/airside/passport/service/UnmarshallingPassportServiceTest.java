package com.airside.passport.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UnmarshallingPassportServiceTest {

	public static final String CORRECT_PASSPORT_BODY = "P<USAROGGER<<MICHAEL<<<<<<<<<<<<<<<<<<<<<<<<YA11164461USA8502201M2001023<<<<<<<<<<<<<<00";
	public static final String RANDOM_STRING = "blah";

	@Mock
	public UnmarshallingPassportService unmarshallingPassportService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void perfectPathTest() {

		unmarshallingPassportService.mainUnmarshallingPassportService(CORRECT_PASSPORT_BODY);
	}

	@Test
	public void randomWordTest() {

		unmarshallingPassportService.mainUnmarshallingPassportService(RANDOM_STRING);
	}

	@Test
	public void emptyWordTest() {

		unmarshallingPassportService.mainUnmarshallingPassportService("");
	}

	@Test
	public void nullWordTest() {

		unmarshallingPassportService.mainUnmarshallingPassportService(null);
	}

}
