package com.assessment.demo.service;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdPartyService {

	private final RestTemplate restTemplate;

    public ThirdPartyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getRandomUserProfile() {
        String url = "https://randomuser.me/api/";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

       
        
        return response.getBody();
    }
	
}
