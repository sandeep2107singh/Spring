package com.over2cloud.request;

import java.sql.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="userDetails")
public class CRUDRequest {

	@Id
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
		birthDate = ZonedDateTime.now(ZoneId.of("Africa/Lagos"));
	}

	
}
