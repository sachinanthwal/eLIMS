package com.lims.dao;

import com.lims.model.LabUnits;
import com.lims.model.Lookups;

import java.util.List;

public interface LabUnitsDAO {
	
	public List<LabUnits> getLabs();
	public List<LabUnits> getLabUnits(String labid);
	public List<LabUnits> getLabUnitUsers(String labid, String unit);
	public void addLab();
	public List<Lookups> getAvailableItem(String p1);
	public List<Lookups> getSelectedItem(String p1);
	
	public List<LabUnits> getAvailableUsers(String labid, String unitcode);
	public List<LabUnits> getSelectedUsers(String labid, String unitcode);
	
	public void editUnit(String Units, String Lab);
	public void editUnitUsers(String Users, String labid, String unitcode);
}
