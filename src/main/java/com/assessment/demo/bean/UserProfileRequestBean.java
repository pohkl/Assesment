package com.assessment.demo.bean;

import java.io.Serializable;

import jakarta.validation.constraints.Email;

public class UserProfileRequestBean implements Serializable {
	
	private static final long serialVersionUID = -7264937257965193025L;
	
	private int profileId = 0;
	
    private String userFullName;
    
    @Email(message = "Please provide a valid email address")
    private String userEmail;
    
    private String userPhoneNumber;
    
    private int gender;

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
    
}
