package com.over2cloud.controller;

import org.jboss.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.over2cloud.response.CRUDResponse;
import com.over2cloud.service.LoginMappingService;
import com.over2cloud.utils.Validation;

@RestController
@ComponentScan({ "com.over2cloud" })
@RequestMapping(value = "/user")
public class LoginController {

	@Autowired
	LoginMappingService service;
	final Logger logger = Logger.getLogger(LoginController.class);
	
	@PostMapping(value="/login")
	public CRUDResponse login(@RequestBody String requestBody) {
		CRUDResponse response=new CRUDResponse();
		JSONObject requestJson=null;
		try {
			requestJson=new JSONObject(requestBody);
		}catch(JSONException e) {
			e.printStackTrace();
		}
		if(requestJson!=null && Validation.validateBody(requestJson)) {
			return service.login(requestJson);
		}
	   return response;							
	}
	
	@PostMapping(value="/registration")
	public CRUDResponse registration(@RequestBody String requestBody) {
		CRUDResponse response=new CRUDResponse();
		JSONObject requestJson=null;
		try {
			requestJson=new JSONObject(requestBody);
		}catch(JSONException e) {
			e.printStackTrace();
		}
		if(requestJson!=null && Validation.validateBody(requestJson)) {
			return service.registration(requestJson);
		}
		return response;
	}
}
