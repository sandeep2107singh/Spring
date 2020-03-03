package com.over2cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.over2cloud.request.CRUDRequest;

public interface CRUDRepository extends JpaRepository<CRUDRequest, Long>{

	public CRUDRequest findByMobile(String mobile);
	public int deleteByMobile(String mobile);
	
	
}
