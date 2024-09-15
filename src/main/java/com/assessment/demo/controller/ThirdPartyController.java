package com.assessment.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.demo.service.ThirdPartyService;
import com.assessment.demo.service.UserProfileService;

@RestController
@RequestMapping("/api/external")
@Validated
public class ThirdPartyController {

	@Autowired
    private UserProfileService userProfileService;
    
	@Autowired
    private ThirdPartyService thirdPartyService;
	
    @GetMapping(value="/getRandomUserProfile", produces = "application/json")
    public String listGender() {
    	
        return thirdPartyService.getRandomUserProfile();
    }
    
}
