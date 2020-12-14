package com.lims.dao;

import com.lims.model.LabUnits;
import com.lims.model.Lookups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LabUnitsDAOImpl implements LabUnitsDAO {

	@Autowired
	private JdbcOperations jdbc;

	@Override
	public List<LabUnits> getLabs() {
		String sql = "select recid,labid,labname,labnoprefix from labs";
		List<LabUnits> listLabs = jdbc.query(sql, new RowMapper<LabUnits>() {
			@Override
			public LabUnits mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				LabUnits aLabs = new LabUnits();
				aLabs.setRecid(rs.getInt("recid"));
				aLabs.setLabid(rs.getString("labid"));
				aLabs.setLabname(rs.getString("labname"));
				aLabs.setLabnoprefix(rs.getString("labnoprefix"));
				return aLabs;
			}
		});
		return listLabs;
	}

	@Override
	public List<LabUnits> getLabUnits(String labid) {
		String sql = "select recid,labid,unitcode,unitname,autoapproval from labunits where labid='"
				+ labid + "'";
		List<LabUnits> listLabUnits = jdbc.query(sql,
				new RowMapper<LabUnits>() {
					@Override
					public LabUnits mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						LabUnits aLabUnits = new LabUnits();
						aLabUnits.setRecid(rs.getInt("recid"));
						aLabUnits.setLabid(rs.getString("labid"));
						aLabUnits.setUnitcode(rs.getString("unitcode"));
						aLabUnits.setUnitname(rs.getString("unitname"));
						aLabUnits.setAutoapproval(rs.getBoolean("autoapproval"));
						return aLabUnits;
					}
				});
		return listLabUnits;
	}

	@Override
	public List<LabUnits> getLabUnitUsers(String labid, String unit) {
		String sql = "select a.recid,a.labid,a.unitcode,a.username,b.fullname from labunitusers a, users b where a.username=b.username and labid='" + labid + "' and unitcode='" + unit + "'";
		List<LabUnits> listLabUnitUsers = jdbc.query(sql,new RowMapper<LabUnits>() {
					@Override
					public LabUnits mapRow(ResultSet rs, int rowNum) throws SQLException {
						LabUnits aLabUnitUsers = new LabUnits();
						aLabUnitUsers.setRecid(rs.getInt("recid"));
						aLabUnitUsers.setLabid(rs.getString("labid"));
						aLabUnitUsers.setUnitcode(rs.getString("unitcode"));
						aLabUnitUsers.setUsername(rs.getString("username"));
						aLabUnitUsers.setFullname(rs.getString("fullname"));
						return aLabUnitUsers;
					}
				});
		return listLabUnitUsers;
	}

	@Override
	public void addLab() {
		String sql = "insert into labs(labid) values('')";
		jdbc.update(sql);	
	}

	@Override
	public List<Lookups> getAvailableItem(String labid) {
		String sql = "select recid,ltext,lvalue from lookup_values where lname='Labs' and lvalue not in(select unitcode from labunits where labid='"+labid+"')";
		List<Lookups> listLookupValue = jdbc.query(sql,
				new RowMapper<Lookups>() {
					@Override
					public Lookups mapRow(ResultSet rs, int rowNum)	throws SQLException {
						Lookups aLookups = new Lookups();
						aLookups.setRecid(rs.getInt("recid"));
						aLookups.setLtext(rs.getString("ltext"));
						aLookups.setLvalue(rs.getString("lvalue"));
						return aLookups;
					}
				});
		return listLookupValue;
	}


	@Override
	public List<Lookups> getSelectedItem(String labid) {
		String sql = "select recid,unitcode,unitname from labunits where labid='"+labid+"'";
		List<Lookups> listLookupValue = jdbc.query(sql,
				new RowMapper<Lookups>() {
					@Override
					public Lookups mapRow(ResultSet rs, int rowNum)	throws SQLException {
						Lookups aLookups = new Lookups();
						aLookups.setRecid(rs.getInt("recid"));
						aLookups.setLtext(rs.getString("unitcode"));
						aLookups.setLvalue(rs.getString("unitname"));
						return aLookups;
					}
				});
		return listLookupValue;
	}

	@Override
	public void editUnit(String Units, String labid) {
		String sqldel = "delete from labunits where unitcode not in("+Units+") and labid='"+labid+"'";
		jdbc.update(sqldel);
		String sql = "insert into labunits(labid,unitcode,unitname,autoapproval) select '"+labid+"',lvalue,ltext,1 from lookup_values where lname='Labs' and lvalue not in(select unitcode from labunits where labid='"+labid+"') and lvalue in("+Units+")";
		jdbc.update(sql);
	}

	@Override
	public List<LabUnits> getAvailableUsers(String labid, String unitcode) {
		String sql = "select recid,username,fullname from users where username not in(select username from labunitusers where labid='"+labid+"' and unitcode='"+unitcode+"')";
		List<LabUnits> listUsers = jdbc.query(sql,new RowMapper<LabUnits>() {
					@Override
					public LabUnits mapRow(ResultSet rs, int rowNum)	throws SQLException {
						LabUnits aUnitUsers = new LabUnits();
						aUnitUsers.setRecid(rs.getInt("recid"));
						aUnitUsers.setUsername(rs.getString("username"));
						aUnitUsers.setFullname(rs.getString("fullname"));
						return aUnitUsers;
					}
				});
		return listUsers;
	}

	@Override
	public List<LabUnits> getSelectedUsers(String labid, String unitcode) {
		String sql = "select recid,labid,unitcode,username from labunitusers "
					+ "where labid='"+labid+"' and unitcode='"+unitcode+"'";
		List<LabUnits> listUsers = jdbc.query(sql,new RowMapper<LabUnits>() {
					@Override
					public LabUnits mapRow(ResultSet rs, int rowNum) throws SQLException {
						LabUnits aUnitUsers = new LabUnits();
						aUnitUsers.setRecid(rs.getInt("recid"));
						aUnitUsers.setLabid(rs.getString("labid"));
						aUnitUsers.setUnitcode(rs.getString("unitcode"));
						aUnitUsers.setUsername(rs.getString("username"));
						return aUnitUsers;
					}
				});
		return listUsers;
	}

	@Override
	public void editUnitUsers(String Users, String labid, String unitcode) {
		String sqldel = "delete from labunitusers where unitcode not in("+Users+") "
					+ "and labid='"+labid+"' and unitcode='"+unitcode+"'";
		jdbc.update(sqldel);
		String sql = "insert into labunitusers(labid,unitcode,username) "
				+ "select '"+labid+"','"+unitcode+"',username from users "
				+ "where username not in(select username from labunitusers "
				+ "where labid='"+labid+"' and unitcode='"+unitcode+"') and "
						+ "username in("+Users+")";
		jdbc.update(sql);
		
	}

	
	
	
	

}
