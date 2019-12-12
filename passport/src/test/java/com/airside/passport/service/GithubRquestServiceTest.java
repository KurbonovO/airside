package com.airside.passport.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GithubRquestServiceTest {

	public static final String CORRECT_NAME = "MICHAEL ROGGER";
	public static final String RANDOM_STRING = "blah";

	@Mock
	public GithubRquestService githubRquestService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void perfectPathTest() {

		githubRquestService.requestToGithubWithName(CORRECT_NAME);
	}

	@Test
	public void RandomWordTest() {

		githubRquestService.requestToGithubWithName(RANDOM_STRING);
	}

	@Test
	public void emptyWordTest() {

		githubRquestService.requestToGithubWithName("");
	}

	@Test
	public void nullWordTest() {

		githubRquestService.requestToGithubWithName(null);
	}

}
