package com.lims.model;

public class Materials {

	private int recid;
	private String matcode;
	private String matname;
	private String mattype;
	private String attributename;
	

	public String getAttributename() {
		return attributename;
	}
	public void setAttributename(String attributename) {
		this.attributename = attributename;
	}
	public int getRecid() {
		return recid;
	}
	public void setRecid(int recid) {
		this.recid = recid;
	}
	public String getMatcode() {
		return matcode;
	}
	public void setMatcode(String matcode) {
		this.matcode = matcode;
	}
	public String getMatname() {
		return matname;
	}
	public void setMatname(String matname) {
		this.matname = matname;
	}
	public String getMattype() {
		return mattype;
	}
	public void setMattype(String mattype) {
		this.mattype = mattype;
	}
	
	
}
