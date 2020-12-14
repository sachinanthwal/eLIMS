package com.lims.model;

public class LabUnits {

	//This is model for Labs, LabUnits, LabUnitUsers tables;
	
	private int recid;
	private String labid;
	private String labname;
	private String labnoprefix;
	private String unitcode;
	private String unitname;
	private Boolean autoapproval;
	private String username;
	private String fullname;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUnitcode() {
		return unitcode;
	}
	public void setUnitcode(String unitcode) {
		this.unitcode = unitcode;
	}
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public Boolean getAutoapproval() {
		return autoapproval;
	}
	public void setAutoapproval(Boolean autoapproval) {
		this.autoapproval = autoapproval;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRecid() {
		return recid;
	}
	public void setRecid(int recid) {
		this.recid = recid;
	}
	public String getLabid() {
		return labid;
	}
	public void setLabid(String labid) {
		this.labid = labid;
	}
	public String getLabname() {
		return labname;
	}
	public void setLabname(String labname) {
		this.labname = labname;
	}
	public String getLabnoprefix() {
		return labnoprefix;
	}
	public void setLabnoprefix(String labnoprefix) {
		this.labnoprefix = labnoprefix;
	}
	
	
}
