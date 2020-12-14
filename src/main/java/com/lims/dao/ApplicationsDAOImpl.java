package com.lims.dao;

import com.lims.model.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ApplicationsDAOImpl implements ApplicationsDAO {

	@Autowired
	private JdbcOperations jdbc;

	@Override
	public List<Applications> getmenugroup() {

		String sql = "select distinct a.app_group,grpicon from applications a join application_roles b on a.appid = b.appid where b.roleid='X' order by app_group";
		List<Applications> listApps = jdbc.query(sql,
				new RowMapper<Applications>() {
					@Override
					public Applications mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Applications aApps = new Applications();

						aApps.setApp_group(rs.getString("app_group"));
						return aApps;
					}
				});
		return listApps;
	}

	@Override
	public List<String> getUserLoginInfo(String username) {
		List<String> RetValue = new ArrayList<String>();
		
		String sql = "select r.role from user_roles ur inner join  roles r on ur.roleid=r.roleid where ur.username='"
				+ username + "'";
		List<String> site = jdbc.query(sql, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
		List<String> role = new ArrayList<String>();
		role.add("Site1");
		role.add("Site2");
		RetValue.addAll(site);
		RetValue.addAll(role);
		return RetValue;
	}

	@Override
	public List<Applications> getmenuitems(String groupName) {
		String sql = "select a.caption, a.url, a.helpurl, a.imageurl, a.app_parameter, a.app_group from applications a join application_roles b on a.appid = b.appid where b.roleid='X' and a.app_group='"
				+ groupName + "' order by app_group,sorter";
		List<Applications> listApps = jdbc.query(sql,
				new RowMapper<Applications>() {
					@Override
					public Applications mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Applications aApps = new Applications();

						aApps.setCaption(rs.getString("caption"));
						aApps.setUrl(rs.getString("url"));
						aApps.setImageurl(rs.getString("imageurl"));
						aApps.setApp_group(rs.getString("app_group"));

						return aApps;
					}
				});
		return listApps;
	}

	@Override
	public List<Applications> getApplications() {
		String sql = "select recid,appid,caption, url, helpurl, imageurl, app_parameter, app_group,grpicon,sorter from applications";
		List<Applications> listApps = jdbc.query(sql,
				new RowMapper<Applications>() {
					@Override
					public Applications mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Applications aApps = new Applications();
						aApps.setRecid(rs.getInt("recid"));
						aApps.setAppid(rs.getString("appid"));
						aApps.setCaption(rs.getString("caption"));
						aApps.setUrl(rs.getString("url"));
						aApps.setHelpurl(rs.getString("helpurl"));
						aApps.setImageurl(rs.getString("imageurl"));
						aApps.setApp_parameter(rs.getString("app_parameter"));
						aApps.setApp_group(rs.getString("app_group"));
						aApps.setGrpicon(rs.getString("grpicon"));
						aApps.setSorter(rs.getInt("sorter"));

						return aApps;
					}
				});
		return listApps;
	}

	@Override
	public List<Applications> getApplicationRoles(String appid) {
		String sql = "select recid,appid,roleid,al_create,al_read,al_update,al_print,al_delete from application_roles where appid='"
				+ appid + "'";
		List<Applications> RetValue = jdbc.query(sql,
				new RowMapper<Applications>() {
					@Override
					public Applications mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Applications rows = new Applications();
						rows.setRecid(rs.getInt("recid"));
						rows.setRoleid(rs.getString("roleid"));
						rows.setAl_create(rs.getBoolean("al_create"));
						rows.setAl_delete(rs.getBoolean("al_delete"));
						rows.setAl_print(rs.getBoolean("al_print"));
						rows.setAl_read(rs.getBoolean("al_read"));
						rows.setAl_update(rs.getBoolean("al_update"));
						return rows;
					}
				});
		return RetValue;
	}

}
