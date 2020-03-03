package com.over2cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.over2cloud.repository.LoginRepository;
import com.over2cloud.request.LoginDetails;

@Service
public class LoginServiceImpl implements Loginservice{
	@Autowired
	public LoginRepository repository;
	
	@Override
	public LoginDetails findByMobile(String mobile) {
		return repository.findByMobile(mobile);
	}
	
	public LoginDetails save(LoginDetails details)
	{
		return repository.save(details);
	}

	@Override
	public LoginDetails findByUsernameAndPasswordAndStatus(String username, String password) {
		return repository.findByUsernameAndPasswordAndStatus(username,password,"Active");
	}
}
