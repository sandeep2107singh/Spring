package com.over2cloud.controller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.over2cloud.response.CRUDResponse;
import com.over2cloud.service.CRUDMappingService;
import com.over2cloud.utils.Validation;


@RestController
@ComponentScan({ "com.over2cloud" })
@RequestMapping(value = "/crud")
public class CRUDController {

	@Autowired
	CRUDMappingService service;

	final Logger logger = Logger.getLogger(CRUDController.class);
	
	@GetMapping(value="/fetch")
	public List fetchList() {
		List list=new ArrayList();
		try {
			
			return service.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@PostMapping(value = "/create")
	public CRUDResponse create(@RequestBody String requestBody) {
		CRUDResponse response = new CRUDResponse();
		JSONObject requestJson = null;
		try {
			requestJson = new JSONObject(requestBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (requestJson != null && Validation.validateBody(requestJson)) {
			return service.create(requestJson);
		}
		return response;

	}

	@PutMapping(value = "/update")
	public CRUDResponse update(@RequestBody String requestBody) {
		CRUDResponse response = new CRUDResponse();
		JSONObject requestJson = null;
		try {
			requestJson = new JSONObject(requestBody);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (requestJson != null && Validation.validateBody(requestJson)) {
			return service.update(requestJson);
		}
		return response;
	}
	
	@DeleteMapping(value="/delete")
	public CRUDResponse delete(@RequestBody String requestBody) {
		CRUDResponse response=new CRUDResponse();
		JSONObject requestJson=null;
		try {
			requestJson=new JSONObject(requestBody);
		}catch(JSONException e) {
			e.printStackTrace();
		}
		if(requestJson!=null && Validation.validateBody(requestJson)) {
			return service.delete(requestJson);
		}
		return response;
	}

}
