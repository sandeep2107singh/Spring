package com.over2cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.over2cloud.request.LoginDetails;

public interface LoginRepository extends JpaRepository<LoginDetails,Long>{
	public LoginDetails findByMobile(String mobile);
	public LoginDetails findByUsernameAndPasswordAndStatus(String username, String password,String status);
}
