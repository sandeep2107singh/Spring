package com.over2cloud.request;

import java.sql.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="userDetails")
public class CRUDRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
   private Long id;
	@Column(name="name")
	private String name;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="fatherName")
	private String fatherName;
	
	@Column(name="cource")
	private String cource;
	
	@Column(name="rollno")
	private String rollno;
	
	@Column(name="birthDate")
	private ZonedDateTime birthDate;
	
	@Column(name="CollegeName")
	private String CollegeName;
	
	@Column(name="mobile")
	private String mobile;
	
	
	@PrePersist
	private void prePersist() {
		birthDate = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getCource() {
		return cource;
	}


	public void setCource(String cource) {
		this.cource = cource;
	}


	public String getRollno() {
		return rollno;
	}


	public void setRollno(String rollno) {
		this.rollno = rollno;
	}


	public ZonedDateTime getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(ZonedDateTime birthDate) {
		this.birthDate = birthDate;
	}


	public String getCollegeName() {
		return CollegeName;
	}


	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	
	
}
