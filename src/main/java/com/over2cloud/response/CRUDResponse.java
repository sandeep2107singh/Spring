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

}
