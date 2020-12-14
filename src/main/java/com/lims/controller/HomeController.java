package com.lims.controller;

import com.google.gson.Gson;
import com.lims.model.Applications;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class HomeController {
	
	@Autowired
	private com.lims.dao.ApplicationsDAO ApplicationsDAO;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		return new ModelAndView("index", "hello", "hello me");
	}
	
	@RequestMapping(value = "/home")
	public ModelAndView Home(HttpServletRequest request) {
		return new ModelAndView("home", "hello", "hello me");
	}
	
	@RequestMapping(value = "/getUserLoginInfo", method = RequestMethod.GET)
	public String getUserLoginInfo(HttpServletRequest request) throws IOException {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		System.out.println(jsonObj.get("username").toString());
		List<String> listUserInfo = ApplicationsDAO.getUserLoginInfo(jsonObj.get("username").toString());
		Gson gson = new Gson();
		String json = gson.toJson(listUserInfo);
		//System.out.println(json);
		return json;
	}
	
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		return new ModelAndView("dashboard", "hello", "hello me");
	}
	
	@RequestMapping(value = "/underconstruction", method = RequestMethod.GET)
	public ModelAndView underconstruction() {
		return new ModelAndView("underconstruction");
	}
	
	@RequestMapping(value = "/getmenugroup", method = RequestMethod.GET)
	public String getmenugroup() {	
		List<Applications> listApplication = ApplicationsDAO.getmenugroup();
		Gson gson = new Gson();
		String json = gson.toJson(listApplication);
		return json;
	
	}

	@RequestMapping(value = "/getmenuitem", method = RequestMethod.GET)
	public String getmenuitem(HttpServletRequest request) {
		// System.out.println(request.getParameter("menugroup"));
		List<Applications> listApplication = ApplicationsDAO.getmenuitems(request.getParameter("menugroup"));
		Gson gson = new Gson();
		String json = gson.toJson(listApplication);
		return json;
	}
}
