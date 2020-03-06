package com.over2cloud.service;

import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.over2cloud.request.LoginDetails;
import com.over2cloud.response.CRUDResponse;

@Service
public class LoginMappingService {

	final Logger logger = Logger.getLogger(LoginMappingService.class);
	@Autowired
	Loginservice service;

	public CRUDResponse login(JSONObject requestJson) {
		CRUDResponse response = new CRUDResponse();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (validateLogin(requestJson)) {
				String username = requestJson.optString("username");
				String password = requestJson.optString("password");
				LoginDetails verifyUser = service.findByUsernameAndPasswordAndStatus(username, password);
				if (verifyUser != null) {
                  logger.info("valid username and password");
                  
                  response.setSuccess(true);
                  response.setMessage("login successfully");
                  result.put("username",username);
                  result.put("password",password);
                  response.setResult(result);
				}else {
					  logger.info("invalid username and password");
	                  response.setSuccess(false);
	                  response.setMessage("invalid username and password");
				}
				
			}else {
				logger.info("request body incorrect");
				 response.setSuccess(false);
                response.setMessage("request body incorrect");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public CRUDResponse registration(JSONObject requestJson) {
		CRUDResponse response = new CRUDResponse();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (validateRegistration(requestJson)) {
				String mobile = requestJson.optString("mobile");
				if (mobile.length() <= 12) {
					LoginDetails checkDupicate = service.findByMobile(mobile);
					if (checkDupicate != null) {
						 response.setSuccess(false);
						response.setMessage("this mobile number already available");
						response.setResult(result);
					} else {
						LoginDetails details = new LoginDetails();
						details.setUsername(requestJson.optString("username"));
						details.setPassword(requestJson.optString("password"));
						details.setEmail_id(requestJson.optString("email_id"));
						details.setMobile(mobile);
						details.setStatus(requestJson.optString("status"));
						details = service.save(details);

						logger.info("data add successfully===" + mobile);
						response.setSuccess(true);
						response.setMessage("data add successfully");
						result.put("username", requestJson.optString("username"));
						result.put("password", requestJson.optString("password"));
						response.setResult(result);
					}
				} else {
					logger.info("mobile number incorrect");
					 response.setSuccess(false);
					response.setMessage("mobile number incorrect");
					response.setResult(result);
				}
			} else {
				logger.info("request body incorrect");
				 response.setSuccess(false);
				response.setMessage("request body incorrect");
				response.setResult(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public boolean validateRegistration(JSONObject requestJson) {
		if (requestJson.has("username") && requestJson.has("password") && requestJson.has("email_id")
				&& requestJson.has("status") && requestJson.has("mobile")) {
			return true;
		}
		return false;
	}

	public boolean validateLogin(JSONObject requestJson) {
		if (requestJson.has("username") && requestJson.has("password")) {
			return true;
		}
		return false;
	}
}
