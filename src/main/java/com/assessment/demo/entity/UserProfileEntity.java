package com.assessment.demo.entity;

import java.util.Date;

import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_profile", schema = "common")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserProfileEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Integer profileId;

    @Column(name = "user_fullname")
    private String userFullName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_phonenumber")
    private String userPhoneNumber;

    @Column(name = "gender_id")
    private Integer genderId;

    @Column(name = "create_dt")
    private Date createDt;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "modify_dt")
    private Date modifyDt;

    @Column(name = "modify_by")
    private String modifyBy;

    @PrePersist
    protected void onCreate() {
        this.createDt = new Date();
        this.createBy = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifyDt = new Date();
        this.modifyBy = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
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

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getModifyDt() {
		return modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
    
}
