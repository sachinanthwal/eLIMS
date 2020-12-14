package com.lims.controller;

import com.google.gson.Gson;
import com.lims.model.Materials;
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
@RequestMapping(value = "/materials")
public class MaterialsController {

	@Autowired
    com.lims.dao.MaterialsDAO MaterialsDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("materials");
	}
	
	@RequestMapping(value = "/getMaterialList")
	public String getMaterialList(HttpServletRequest request) throws IOException {
		
		String param = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(param);
		String mattype = jsonObj.get("mattype").toString();
		
		List<Materials> listItems = MaterialsDAO.getMaterialList(mattype);
		Gson gson = new Gson();
		String json = gson.toJson(listItems);
		return json;
	}

	@RequestMapping(value = "/AddMaterial")
	public void AddMaterial(HttpServletRequest request) throws IOException {
		String param = request.getParameter("request");
		JSONObject jsonObj = new JSONObject(param);
		String matcode = jsonObj.get("matcode").toString();
		String matname = jsonObj.get("matname").toString();
		String mattype = jsonObj.get("mattype").toString();
		MaterialsDAO.AddMaterial(matcode,matname,mattype);
	}
}
