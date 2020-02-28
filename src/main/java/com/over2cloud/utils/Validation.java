package com.over2cloud.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class Validation {
	public static boolean validateBody(JSONObject requestJson) {
       try {
    	   for(String key:requestJson.keySet()) {
    		   if(isEmptyOrNull(requestJson,key)) {
    			   return false;
    		   }
    	   }
    		   
       }catch(JSONException e) {
    	   e.printStackTrace();
       }
       return true;
	}
	
	public static boolean isEmptyOrNull(JSONObject requestJson, String key) {
		String value = (requestJson.get(key)+"").trim();
		if(value.equals("null") || value.equals(""))
			return true;
					
		return false;			
	}
}
