package com.airside.passport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.airside.passport.constants.PassportConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GithubRquestService {

	private UnmarshallingPassportService unmarshallingPassportService;

	@Autowired
	public GithubRquestService(UnmarshallingPassportService unmarshallingPassportService) {

		this.unmarshallingPassportService = unmarshallingPassportService;

	}

	public String requestToGithubWithName(String fullname) {

		RestTemplate restTemplate = new RestTemplate();

		String uri = PassportConstants.GITHUB_USER_URL + fullname.replaceAll(" ", "+");

		String result = restTemplate.getForObject(uri, String.class);

		ObjectMapper mapper = new ObjectMapper();

		JsonNode stringToJson = null;

		try {

			stringToJson = mapper.readTree(result);

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		return result;
	}
}
