package com.assessment.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.demo.entity.GenderEntity;

public interface GenderRepository extends JpaRepository<GenderEntity, Integer> {

	@Query("SELECT g.genderId FROM GenderEntity g WHERE g.genderName = :genderName")
    Integer findIdByGenderName(@Param("genderName") String genderName);
	
}
