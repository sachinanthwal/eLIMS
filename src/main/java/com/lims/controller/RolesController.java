package com.lims.controller;

import com.google.gson.Gson;
import com.lims.model.Roles;
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
@RequestMapping(value = "/roles")
public class RolesController {

	@Autowired
	private com.lims.dao.RolesDAO RolesDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView rolemanager() {
		return new ModelAndView("roles");
	}

	@RequestMapping(value = "/select", method = RequestMethod.POST)
	public String select(HttpServletRequest request) throws IOException {
		// System.out.println(request.getParameter("request"));
		// String marshalledXml =
		// org.apache.commons.io.IOUtils.toString(request.getInputStream());
		// System.out.print(marshalledXml);
		List<Roles> listRoles = RolesDAO.RolesList();
		Gson gson = new Gson();
		String json = gson.toJson(listRoles);
		System.out.println(json);
		return json;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request) throws IOException {
		// System.out.println(request.getParameter("data"));
		String data = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(data);
		String recid = jsonObj.get("recid").toString().replace("[", "").replace("]", "");
		RolesDAO.delete(recid);
		return null;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insert(HttpServletRequest request) throws IOException {
		RolesDAO.insert();
		return null;
	}
}
