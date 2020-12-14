package com.lims.controller;

import com.google.gson.Gson;
import com.lims.model.LabUnits;
import com.lims.model.Lookups;
import com.lims.util.util;
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
@RequestMapping(value = "/labunits")
public class LabunitsController {

	@Autowired
    com.lims.dao.LabUnitsDAO LabUnitsDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView rolemanager() {
		return new ModelAndView("labunits");
	}

	@RequestMapping(value = "/getLabs")
	public String getLookupName(HttpServletRequest request) throws IOException {
		List<LabUnits> listLabs = LabUnitsDAO.getLabs();
		Gson gson = new Gson();
		String json = gson.toJson(listLabs);
		return json;
	}

	@RequestMapping(value = "/getLabUnits")
	public String getLabUnits(HttpServletRequest request) throws IOException {
		String param = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(param);
		String labid = jsonObj.get("labid").toString();
		List<LabUnits> listLabs = LabUnitsDAO.getLabUnits(labid);
		Gson gson = new Gson();
		String json = gson.toJson(listLabs);
		return json;
	}

	@RequestMapping(value = "/getLabUnitUsers")
	public String getLabUnitUsers(HttpServletRequest request)
			throws IOException {
		String param = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(param);
		String labid = jsonObj.get("labid").toString();
		String unit = jsonObj.get("unitcode").toString();
		List<LabUnits> listLabs = LabUnitsDAO.getLabUnitUsers(labid, unit);
		Gson gson = new Gson();
		String json = gson.toJson(listLabs);
		return json;
	}

	@RequestMapping(value = "/addLab", method = RequestMethod.GET)
	public ModelAndView insert(HttpServletRequest request) throws IOException {
		LabUnitsDAO.addLab();
		return null;
	}

	@RequestMapping(value = "/getAvailableItem", method = RequestMethod.POST)
	public String getAvailableList(HttpServletRequest request) {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		List<Lookups> listLabs = LabUnitsDAO.getAvailableItem(jsonObj.get("labid").toString());
		Gson gson = new Gson();
		String json = gson.toJson(listLabs);
		return json;
	}

	@RequestMapping(value = "/getSelectedItem", method = RequestMethod.POST)
	public String getSelectedList(HttpServletRequest request) {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		List<Lookups> listLabs = LabUnitsDAO.getSelectedItem(jsonObj.get("labid").toString());
		Gson gson = new Gson();
		String json = gson.toJson(listLabs);
		return json;
	}

	@RequestMapping(value = "/getAvailableUsers", method = RequestMethod.POST)
	public String getAvailableUsers(HttpServletRequest request) {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		String labid = jsonObj.get("labid").toString();
		String unitcode = jsonObj.get("unitcode").toString();
		List<LabUnits> listLabs = LabUnitsDAO.getAvailableUsers(labid,unitcode);
		Gson gson = new Gson();
		String json = gson.toJson(listLabs);
		return json;
	}

	@RequestMapping(value = "/getSelectedUsers", method = RequestMethod.POST)
	public String getSelectedUsers(HttpServletRequest request) {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		String labid = jsonObj.get("labid").toString();
		String unitcode = jsonObj.get("unitcode").toString();
		List<LabUnits> listLabs = LabUnitsDAO.getSelectedUsers(labid,unitcode);
		Gson gson = new Gson();
		String json = gson.toJson(listLabs);
		return json;
	}
	
	@RequestMapping(value = "/editLabUnitList", method = RequestMethod.GET)
	public ModelAndView editLabUnitList(HttpServletRequest request) throws IOException {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		String Units = util.BuildINString(jsonObj.get("records").toString(), "lvalue","String");
		LabUnitsDAO.editUnit(Units, jsonObj.get("labid").toString());
		return null;
	}


	@RequestMapping(value = "/editLabUnitUserList", method = RequestMethod.GET)
	public ModelAndView editLabUnitUserList(HttpServletRequest request) throws IOException {
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		String Users = util.BuildINString(jsonObj.get("records").toString(), "username","String");
		LabUnitsDAO.editUnitUsers(Users, jsonObj.get("labid").toString(),jsonObj.get("unitcode").toString());
		return null;
	}
	
}
