package com.lims.dao;

import com.lims.model.Applications;

import java.util.List;


public interface ApplicationsDAO {
	
	public List<Applications> getApplications();
	public List<Applications> getApplicationRoles(String appid);
	public List<Applications> getmenugroup();
	public List<Applications> getmenuitems(String groupName);
	public List<String> getUserLoginInfo(String username);
}
