package com.lims.dao;

public interface GenericDAO {

	public void saveGrid(int recid, String field, String tablename);

	public void deleteRow(int recid, String tablename);

	public void saveForm(String formdata, String tablename,String id);

	public String getCalcode(int recid,String tname);
	
	public void setCalcode(String calc,int recid,String tname);
	
}
