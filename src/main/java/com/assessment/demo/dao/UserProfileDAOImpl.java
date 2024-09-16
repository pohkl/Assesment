package com.assessment.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.assessment.demo.entity.UserProfileEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserProfileDAOImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public UserProfileEntity getUserProfileByEmail(String userEmail) {
		String queryString = "SELECT e FROM UserProfileEntity e WHERE e.userEmail = :userEmail ";

		List<UserProfileEntity> result = entityManager.createQuery(queryString, UserProfileEntity.class)
				.setParameter("userEmail", userEmail).getResultList();
		
		if(result!=null&&result.size()>0) {
			return result.get(0);
		} else {
			return null;
		}
	}

}
