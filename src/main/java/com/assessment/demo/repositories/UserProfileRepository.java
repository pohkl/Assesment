package com.assessment.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.demo.entity.UserProfileEntity;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Integer> {
	
	boolean existsByUserEmail(String userEmail);
	
}
