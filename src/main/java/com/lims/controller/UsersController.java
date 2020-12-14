package com.lims.controller;

import com.google.gson.Gson;
import com.lims.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UsersController {
	
	@Autowired
    com.lims.dao.UsersDAO UsersDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView rolemanager() {
		return new ModelAndView("users");
	}
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public String select(HttpServletRequest request) throws IOException {
		List<Users> listUsers = UsersDAO.UsersList();
		Gson gson = new Gson();
		String json = gson.toJson(listUsers);
		//System.out.println(json);
		return json;
	}
	@RequestMapping(value = "/addnewuser", method = RequestMethod.POST)
	public String addnewuser(HttpServletRequest request) throws IOException {
		String data = request.getParameter("request");
		String resp = UsersDAO.insert(data);
		return resp;
	}
	@RequestMapping(value = "/btnSaveForm", method = RequestMethod.GET)
	public ModelAndView SaveForm(HttpServletRequest request) throws IOException {
		String data = request.getParameter("request");
		UsersDAO.SaveForm(data);
		return null;
	}
}
