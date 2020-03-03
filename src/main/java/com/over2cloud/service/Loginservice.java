package com.over2cloud.service;

import com.over2cloud.request.LoginDetails;

public interface Loginservice {
	public LoginDetails findByMobile(String mobile);
	public LoginDetails save(LoginDetails details);
	public LoginDetails findByUsernameAndPasswordAndStatus(String username,String password);
}
