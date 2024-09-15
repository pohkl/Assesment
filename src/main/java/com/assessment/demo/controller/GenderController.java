package com.assessment.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.demo.entity.GenderEntity;
import com.assessment.demo.service.UserProfileService;

@RestController
@RequestMapping("/api/gender")
@Validated
public class GenderController {

	@Autowired
    private UserProfileService userProfileService;
    
    @GetMapping("/list")
    public List<GenderEntity> listGender() {
        return userProfileService.getAllGenders();
    }
    
}
