package com.lims.dao;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDAOImpl implements GenericDAO {

	@Autowired
	private JdbcOperations jdbc;

	@Override
	public void saveGrid(int recid, String field, String tablename) {
		String sql = "update " + tablename + " set " + field + "  where recid=" + recid;
		jdbc.update(sql);
	}

	@Override
	public void deleteRow(int recid, String tablename) {
		String sql = "delete from " + tablename + " where recid=" + recid;
		jdbc.update(sql);

	}

	@Override
	public void saveForm(String formdata, String tablename, String id) {
		JSONObject oFormData = new JSONObject(formdata);
		String[] keys = JSONObject.getNames(oFormData);
		for (String key : keys) {
			Object value = oFormData.get(key);
			String sql = "update " + tablename + " set " + key + "='" + value + "' where sampleid='" + id + "'";
			jdbc.update(sql);
		}
	}

	@Override
	public String getCalcode(int recid, String tname) {
		String sql = "select calcode from "+tname+" where recid="+recid;
		String calcode = (String) jdbc.queryForObject(sql, null, String.class);
		return calcode;
		
	}

	@Override
	public void setCalcode(String calc, int recid, String tname) {
		String sql = "update " + tname + " set calcode='" + calc + "' where recid=" + recid;
		jdbc.update(sql);
	}

	
	
}
