package com.over2cloud.service;

import java.util.List;

import com.over2cloud.request.CRUDRequest;
import com.over2cloud.request.LoginDetails;

public interface CRUDService {
   
	public CRUDRequest findByMobile(String mobile);
	public CRUDRequest save(CRUDRequest crud);
	public int deleteByMobile(String mobile);
	public List findAll();
	
}
