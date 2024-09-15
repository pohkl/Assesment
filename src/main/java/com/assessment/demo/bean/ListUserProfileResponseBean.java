package com.assessment.demo.bean;

import java.io.Serializable;
import java.util.List;

import com.assessment.demo.entity.UserProfileEntity;

public class ListUserProfileResponseBean implements Serializable {
	
	private static final long serialVersionUID = -8189423904798261435L;

	private List<UserProfileEntity> userProfiles;
	
	private int totalPages;

	public List<UserProfileEntity> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfileEntity> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
}
