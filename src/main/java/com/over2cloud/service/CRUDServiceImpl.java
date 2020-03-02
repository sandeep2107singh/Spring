package com.over2cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.over2cloud.repository.CRUDRepository;
import com.over2cloud.request.CRUDRequest;

@Service
@Transactional
public class CRUDServiceImpl implements CRUDService{

	@SuppressWarnings("rawtypes")
	@Autowired
	CRUDRepository repository;

	@Override
	public CRUDRequest findByMobile(String mobile) {
		return repository.findByMobile(mobile);
	}

	@Override
	public CRUDRequest save(CRUDRequest crud) {
		return repository.save(crud);
	}
	
	@Override
	public int deleteByMobile(String mobile) {
		return repository.deleteByMobile(mobile);
	}
	
	public List findAll()
	{
		return repository.findAll();
	}
}
