package com.lims.dao;

import com.lims.model.Materials;

import java.util.List;

public interface MaterialsDAO {

	public List<Materials> getMaterialList(String mattype);
	public void AddMaterial(String matcode,String matname, String mattype);
	
}
