package com.assessment.demo.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.assessment.demo.bean.ListUserProfileRequestBean;
import com.assessment.demo.bean.ListUserProfileResponseBean;
import com.assessment.demo.bean.UserProfileRequestBean;
import com.assessment.demo.entity.GenderEntity;
import com.assessment.demo.entity.UserProfileEntity;
import com.assessment.demo.repositories.GenderRepository;
import com.assessment.demo.repositories.UserProfileRepository;

import jakarta.transaction.Transactional;

@Service
public class UserProfileService {

	@Autowired
	GenderRepository genderRepo;
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	ThirdPartyService thirdPartyService;
	
	public List<GenderEntity> getAllGenders() {
        return genderRepo.findAll();
    }

	@Transactional
	public UserProfileEntity addUserProfile(UserProfileRequestBean requestBean) {
		
		UserProfileEntity e = new UserProfileEntity();
		e.setUserFullName(requestBean.getUserFullName());
		e.setUserEmail(requestBean.getUserEmail());
		e.setUserPhoneNumber(requestBean.getUserPhoneNumber());
		e.setGenderId(requestBean.getGender());
		
		userProfileRepository.save(e);
		
		return e;
	}

	public UserProfileEntity getUserProfileById(Integer profileId) {
		
		UserProfileEntity e = null;
		
		e = userProfileRepository.findById(profileId)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "User Profile does not exist."));
		
		return e;
	}

	@Transactional
	public UserProfileEntity updateUserProfileById(UserProfileRequestBean requestBean) {

		UserProfileEntity e = getUserProfileById(requestBean.getProfileId());
		
		e.setUserFullName(requestBean.getUserFullName());
		e.setUserEmail(requestBean.getUserEmail());
		e.setUserPhoneNumber(requestBean.getUserPhoneNumber());
		e.setGenderId(requestBean.getGender());
		
		userProfileRepository.save(e);
		
		return e;
	}

	public void deleteUserProfileById(int profileId) {
		userProfileRepository.deleteById(profileId);
	}

	public ListUserProfileResponseBean listUserProfile(ListUserProfileRequestBean requestBean) {
		
		Sort sort = null;
		if(Sort.Direction.ASC.name().equalsIgnoreCase(requestBean.getSortDir())) {
			sort = Sort.by(requestBean.getSortBy()).ascending();
		} else {
			sort = Sort.by(requestBean.getSortBy()).descending();
		}
		
        Pageable pageable = PageRequest.of(requestBean.getPage()-1, requestBean.getPageSize(), sort);
        
        Page<UserProfileEntity> userProfilePage = userProfileRepository.findAll(pageable);
        
        ListUserProfileResponseBean response = new ListUserProfileResponseBean();
        response.setUserProfiles(userProfilePage.toList());
        response.setTotalPages(userProfilePage.getTotalPages());
        
		return response;
	}
	
	public UserProfileEntity insertRandomUserProfile() {

		// Call third party API to get random user profile
		String response = thirdPartyService.getRandomUserProfile();

		JSONObject json = new JSONObject(response);
		JSONObject result = (JSONObject) json.getJSONArray("results").get(0);
		JSONObject nameObj = result.getJSONObject("name");
		String fullname = nameObj.getString("first")+" "+nameObj.getString("last");
		String email = result.getString("email").toString();
		String phone = result.getString("phone").toString();
		String gender = result.getString("gender");
		
		UserProfileEntity e = new UserProfileEntity();
		e.setUserFullName(fullname);
		e.setUserEmail(email);
		e.setGenderId(getGenderIdByName(gender));
		e.setUserPhoneNumber(phone);

		userProfileRepository.save(e);
		
		return e;
	}

	private Integer getGenderIdByName(String gender) {
		return genderRepo.findIdByGenderName(gender);
	}
	
}
