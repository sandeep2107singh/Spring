package com.over2cloud.request;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="login_details")
public class LoginDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="id")
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email_id")
	private String email_id;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_date")
	private ZonedDateTime created_date;
	
	/*
	 * @Column(name="modified_date") private ZonedDateTime modified_date;
	 */
	
	@PrePersist
	private void prePersist() {
		created_date = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ZonedDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(ZonedDateTime created_date) {
		this.created_date = created_date;
	}
	
	
	
	
}
