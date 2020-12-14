package com.lims.dao;

import com.lims.model.Materials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MaterialsDAOImpl implements MaterialsDAO {

	@Autowired
	private JdbcOperations jdbc;

	@Override
	public List<Materials> getMaterialList(String mattype) {
		String sql = "select recid,matcode,matname,mattype,attributename,quantity,unit from materials";
		List<Materials> listMaterials = jdbc.query(sql, new RowMapper<Materials>() {
			@Override
			public Materials mapRow(ResultSet rs, int rowNum) throws SQLException {
				Materials aMaterials = new Materials();

				aMaterials.setRecid(rs.getInt("recid"));
				aMaterials.setMatcode(rs.getString("matcode"));
				aMaterials.setMatname(rs.getString("matname"));
				aMaterials.setMattype(rs.getString("mattype"));
				aMaterials.setAttributename(rs.getString("attributename"));
				return aMaterials;
			}
		});
		return listMaterials;
	}

	@Override
	public void AddMaterial(String matcode, String matname, String mattype) {
		String sql = "insert into materials(matcode,matname,mattype) values('"+matcode+"','"+matname+"','"+mattype+"')";	
		jdbc.update(sql);
	}
	
	
}
