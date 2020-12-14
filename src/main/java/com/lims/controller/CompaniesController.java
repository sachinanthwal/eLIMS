package com.lims.controller;

import com.google.gson.Gson;
import com.lims.model.Companies;
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
@RequestMapping(value = "/companies")
public class CompaniesController {

	@Autowired
    com.lims.dao.CompaniesDAO CompaniesDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView rolemanager() {
		return new ModelAndView("companies");
	}

	@RequestMapping(value = "/getCompanies")
	public String getCompanies(HttpServletRequest request) throws IOException {
		List<Companies> listCompanies = CompaniesDAO.getCompaniesList();
		Gson gson = new Gson();
		String json = gson.toJson(listCompanies);
		return json;

	}

	@RequestMapping(value = "/saveCompanyDetails")
	public ModelAndView saveCompanyDetails(HttpServletRequest request)
			throws IOException {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		CompaniesDAO.saveCompanyDetails(jsonObj.get("record").toString());
		return null;
	}
	
	@RequestMapping(value = "/getCompanyContacts")
	public String getCompanyContacts(HttpServletRequest request) throws IOException {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		List<Companies> listCompanies = CompaniesDAO.getCompanyContacts(jsonObj.get("compid").toString());
		Gson gson = new Gson();
		String json = gson.toJson(listCompanies);
		return json;

	}
	
	@RequestMapping(value = "/getCompanyDocuments")
	public String getCompanyDocuments(HttpServletRequest request) throws IOException {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		List<Companies> listCompanies = CompaniesDAO.getCompanyDocuments(jsonObj.get("compid").toString());
		Gson gson = new Gson();
		String json = gson.toJson(listCompanies);
		return json;
	}
	
	
	@RequestMapping(value = "/addNewCompany", method = RequestMethod.GET)
	public ModelAndView insert(HttpServletRequest request) throws IOException {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		CompaniesDAO.addNewCompany(jsonObj.get("compid").toString());
		return null;
	}
	
	@RequestMapping(value = "/addNewContact", method = RequestMethod.GET)
	public ModelAndView addNewContact(HttpServletRequest request) throws IOException {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		CompaniesDAO.addNewContact(jsonObj.get("compid").toString());
		return null;
	}
}
