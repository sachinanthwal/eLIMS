package com.lims.util;

import org.json.JSONArray;

public class util {

	public static String BuildINString(String data, String field,
			String fieldtype) {
		JSONArray jsonArray = new JSONArray(data);
		String retvalue = "";
		for (int i = 0; i < jsonArray.length(); i++) {
			if (fieldtype.equals("int")) {
				retvalue += ","	+ jsonArray.getJSONObject(i).get(field).toString();
			}
			else
			{
				retvalue += ",'"	+ jsonArray.getJSONObject(i).get(field).toString()+"'";	
			}
		}
		return retvalue.substring(1);
	}

}
