package com.assessment.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.demo.bean.ListUserProfileRequestBean;
import com.assessment.demo.bean.ListUserProfileResponseBean;
import com.assessment.demo.bean.UserProfileRequestBean;
import com.assessment.demo.entity.UserProfileEntity;
import com.assessment.demo.service.UserProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@Validated
public class UserProfileController {

	@Autowired
    private UserProfileService userProfileService;
    
    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public UserProfileEntity listGender(@Valid @RequestBody UserProfileRequestBean requestBean) {
    	
    	UserProfileEntity e = userProfileService.addUserProfile(requestBean);
    	
        return e;
    }
    
	@GetMapping(value = "/list", produces = "application/json")
	public ListUserProfileResponseBean listUserProfile(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "profileId") String sortBy,
			@RequestParam(defaultValue = "ASC") String sortDir) {
    	
    	ListUserProfileRequestBean requestBean = new ListUserProfileRequestBean();
    	requestBean.setPage(page);
    	requestBean.setPageSize(pageSize);
    	requestBean.setSortBy(sortBy);
    	requestBean.setSortDir(sortDir);
    	
    	ListUserProfileResponseBean e = userProfileService.listUserProfile(requestBean);
    	
        return e;
    }
    
    @PostMapping(value = "/retrieve", consumes = "application/json", produces = "application/json")
    public UserProfileEntity retrieveUserProfile(@RequestBody UserProfileRequestBean requestBean) {
    	
    	UserProfileEntity e = userProfileService.getUserProfileById(requestBean.getProfileId());
    	
        return e;
    }
    
    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public UserProfileEntity updateUserProfile(@Valid @RequestBody UserProfileRequestBean requestBean) {
    	
    	UserProfileEntity e = userProfileService.updateUserProfileById(requestBean);
    	
        return e;
    }
    
    @PostMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> deleteUserProfile(@RequestBody UserProfileRequestBean requestBean) {
    	
    	userProfileService.deleteUserProfileById(requestBean.getProfileId());
    	
        return ResponseEntity.ok().build();
    }
    
    @GetMapping(value = "/insertRandomUserProfile", produces = "application/json")
    public UserProfileEntity insertRandomUserProfile() {
    	
    	return userProfileService.insertRandomUserProfile();
    	
    }
    
}
