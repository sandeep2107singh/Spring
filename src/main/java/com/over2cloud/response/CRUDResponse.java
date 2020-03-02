package com.over2cloud.response;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CRUDResponse {

	private boolean success;
	private String message;
	private Map<String, Object> result = new HashMap<String, Object>();
	private Long timestamp = Instant.now().toEpochMilli();

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public void setResponse(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	

}
