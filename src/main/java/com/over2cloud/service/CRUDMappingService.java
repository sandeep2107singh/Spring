package com.over2cloud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	

	public List findAll() {
		CRUDResponse response = new CRUDResponse();
		List list = new ArrayList();
		try {
			list = service.findAll();
			response.setResponse(true);
			response.setMessage("List");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public CRUDResponse create(JSONObject requestJson) {
		CRUDResponse response = new CRUDResponse();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (validate(requestJson)) {
				String mobile = requestJson.optString("mobile");
				if (mobile.length() <= 10) {
					mobile = mobile.substring(mobile.length() - 10, mobile.length());
					CRUDRequest request = service.findByMobile(mobile);

					if (request != null) {
						response.setResponse(false);
						response.setMessage("this mobile number already insert");
					} else {
						CRUDRequest crud = new CRUDRequest();
						crud.setName(requestJson.optString("name"));
						crud.setLastName(requestJson.optString("lastName"));
						crud.setFatherName(requestJson.optString("fatherName"));
						crud.setCource(requestJson.optString("cource"));
						crud.setRollno(requestJson.optString("rollno"));
						crud.setCollegeName(requestJson.optString("CollegeName"));
						crud.setMobile(requestJson.optString("mobile"));
						crud = service.save(crud);

						logger.info("done");
						response.setMessage("data insert successfully");
						response.setResponse(true);
						response.setResult(result);
					}
				} else {
					logger.info("mobile number incorrect");
					response.setResponse(false);
					response.setMessage("mobile number incorrect");
					response.setResult(result);
				}
			} else {
				logger.info("request body incorrect");
				response.setMessage("request body incorrect");
				response.setResponse(false);
				response.setResult(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public CRUDResponse update(JSONObject requestJson) {
		CRUDResponse response = new CRUDResponse();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (validate(requestJson)) {
				String mobile = requestJson.optString("mobile");
				if (mobile.length() <= 12) {
					mobile = mobile.substring(mobile.length() - 10, mobile.length());
					CRUDRequest finddata = service.findByMobile(mobile);
					if (finddata != null) {
						finddata.setName(requestJson.optString("name"));
						finddata.setLastName(requestJson.optString("lastName"));
						finddata.setFatherName(requestJson.optString("fatherName"));
						finddata.setCource(requestJson.optString("cource"));
						finddata.setRollno(requestJson.optString("rollno"));
						finddata.setCollegeName(requestJson.optString("CollegeName"));
						finddata.setMobile(mobile);
						finddata = service.save(finddata);

						logger.info("data update successfully");
						response.setMessage("data update successfully");
						response.setResponse(true);
						result.put("mobile", mobile);
						response.setResult(result);
					} else {
						logger.info("this mobile number not exit's in table");
						response.setResponse(false);
						response.setMessage("this mobile number not exit's in table");
						response.setResult(result);
					}
				} else {
					logger.info("mobile number incorrect");
					response.setResponse(false);
					response.setMessage("mobile number incorrect");
					response.setResult(result);
				}
			} else {
				logger.info("request body incorrect");
				response.setMessage("request body incorrect");
				response.setResponse(false);
				response.setResult(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public CRUDResponse delete(JSONObject requestJson) {
		CRUDResponse response = new CRUDResponse();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (validateDelete(requestJson)) {
				String mobile = requestJson.optString("mobile");
				if (mobile.length() <= 12) {
					int deletedata = service.deleteByMobile(mobile);
					if (deletedata != 0) {
						logger.info("data delete successfully");
						response.setResponse(true);
						response.setMessage("data delete successfully");
					} else {
						logger.info("this mobile number not exit's in table");
						response.setResponse(false);
						response.setMessage("this mobile number not exit's in table");
						response.setResult(result);
					}
				} else {
					logger.info("mobile number incorrect");
					response.setResponse(false);
					response.setMessage("mobile number incorrect");
					response.setResult(result);
				}
			} else {
				logger.info("request body incorrect");
				response.setMessage("request body incorrect");
				response.setResponse(false);
				response.setResult(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public boolean validate(JSONObject requestJson) {
		if (requestJson.has("name") && requestJson.has("lastName") && requestJson.has("fatherName")
				&& requestJson.has("cource") && requestJson.has("rollno") && requestJson.has("CollegeName")
				&& requestJson.has("mobile")) {
			return true;
		}

		return false;
	}

	public boolean validateDelete(JSONObject requestJson) {
		if (requestJson.has("mobile")) {
			return true;
		}
		return false;
	}

	

}
