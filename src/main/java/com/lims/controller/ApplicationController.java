package com.lims.controller;

import com.google.gson.Gson;
import com.lims.model.Applications;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/applications")
public class ApplicationController {

	@Autowired
    com.lims.dao.ApplicationsDAO ApplicationsDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView applications() {
		return new ModelAndView("applications");
	}
	
	@RequestMapping(value = "/getApplications")
	public String getAttributesName(HttpServletRequest request) throws IOException {
		List<Applications> listApps = ApplicationsDAO.getApplications();
		Gson gson = new Gson();
		String json = gson.toJson(listApps);
		return json;
	}
	@RequestMapping(value = "/getApplicationRoles")
	public String getApplicationRoles(HttpServletRequest request) throws IOException {
		String param = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(param);
		String appid = jsonObj.get("appid").toString();
		List<Applications> listApps = ApplicationsDAO.getApplicationRoles(appid);
		Gson gson = new Gson();
		String json = gson.toJson(listApps);
		return json;
	}
}
