package com.lims.dao;

import com.lims.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RolesDAOImpl implements RolesDAO {

	
	@Autowired
	private JdbcOperations jdbc;

	@Override
	public List<Roles> RolesList() {
		String sql = "select recid,roleid,role,is_active from roles";
		List<Roles> listReturn = jdbc.query(sql, new RowMapper<Roles>() {
			@Override
			public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
				Roles rows = new Roles();

				rows.setRecid(rs.getInt("recid"));
				rows.setRoleid(rs.getString("roleid"));
				rows.setRole(rs.getString("role"));
				rows.setIs_active(rs.getString("is_active"));
				return rows;
			}
		});
		return listReturn;
	}

	@Override
	public void delete(String recid) {
		String sql = "DELETE FROM roles WHERE recid in(" + recid + ")";
		jdbc.update(sql);
	}

	@Override
	public void insert() {
		String sql = "insert into roles(roleid) values('')";
		jdbc.update(sql);
	}

}
