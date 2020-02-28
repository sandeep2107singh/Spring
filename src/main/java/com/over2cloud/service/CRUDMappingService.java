package com.over2cloud.service;

import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.over2cloud.request.CRUDRequest;
import com.over2cloud.response.CRUDResponse;

@Service
public class CRUDMappingService {

	final Logger logger = Logger.getLogger(CRUDMappingService.class);
	@Autowired
	CRUDService service;

	public CRUDResponse create(JSONObject requestJson) {
		CRUDResponse response = new CRUDResponse();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (validateCreate(requestJson)) {
				String mobile = requestJson.optString("mobile");
				if (mobile.length() >= 10) {
					mobile = mobile.substring(mobile.length() - 10, mobile.length());
					// CRUDRequest request=service.findByMobile(mobile);
					/*
					 * if(request!=null) { response.setSuccess(false);
					 * response.setMessage("this mobile already insert"); response. }
					 */
					CRUDRequest ss = new CRUDRequest();
					// ss.setName
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public boolean validateCreate(JSONObject requestJson) {
		if (requestJson.has("name") && requestJson.has("lastname") && requestJson.has("fatherName")
				&& requestJson.has("cource") && requestJson.has("rollno") && requestJson.has("birthDate")
				&& requestJson.has("CollegeName") && requestJson.has("mobile"))
			return true;

		return false;
	}
}
