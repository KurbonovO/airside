package com.airside.passport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airside.passport.service.GithubRquestService;
import com.airside.passport.service.UnmarshallingPassportService;

@RestController
public class UnmarshallingPassportController {

	private UnmarshallingPassportService unmarshallingPassportService;
	private GithubRquestService githubRquestService;

	@Autowired
	public UnmarshallingPassportController(UnmarshallingPassportService unmarshallingPassportService,
			GithubRquestService githubRquestService) {

		this.unmarshallingPassportService = unmarshallingPassportService;
		this.githubRquestService = githubRquestService;
	}

	/**
	 * We use this endpoint for when we want to get the name from passport.
	 * ex:fullnameFromPassport/P<USAROGGER<<MICHAEL<<<<<<<<<<<<<<<<<<<<<<<<YA11164461USA8502201M2001023<<<<<<<<<<<<<<00
	 * returns: MICHAEL ROGGER 
	 *
	 * see img 1.JPG located in airside\passport\src\main\resources
	 * 
	 * @param passportBody
	 * @return String value of name
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/fullnameFromPassport/{passportBody}")
	public String fullnameFromPassport(@PathVariable String passportBody) {

		return unmarshallingPassportService.mainUnmarshallingPassportService(passportBody);
	}

	/**
	 * We use this endpoint when we have the name already and just want to get the
	 * github response back. 
	 *
	 * see img 2.JPG located in airside\passport\src\main\resources
	 * 
	 * @param fullname
	 * @return String format of the json returned from github
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/fullnameToGithub/{fullname}")
	public String fullnameToGithub(@PathVariable String fullname) {

		return githubRquestService.requestToGithubWithName(fullname);
	}

	/**
	 * We use this endpoint when we just want to pass the passport body and then
	 * just return the github infomation
	 *
	 * see img 3.JPG located in airside\passport\src\main\resources
	 * 
	 * @param passportBody
	 * @return String format of the json returned from github
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/passportToGithub/{passportBody}")
	public String passportToGithub(@PathVariable String passportBody) {

		String fullname = unmarshallingPassportService.mainUnmarshallingPassportService(passportBody);

		return githubRquestService.requestToGithubWithName(fullname);
	}
}
