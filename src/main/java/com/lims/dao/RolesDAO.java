package com.lims.dao;

import com.lims.model.Roles;

import java.util.List;


public interface RolesDAO {

	public List<Roles> RolesList();
	
	public void delete(String recid);
	
	public void insert();
	
}
