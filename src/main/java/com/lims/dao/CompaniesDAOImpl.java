package com.lims.dao;

import com.lims.model.Companies;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CompaniesDAOImpl implements CompaniesDAO {

	@Autowired
	private JdbcOperations jdbc;

	@Override
	public List<Companies> getCompaniesList() {

		String sql = "select recid,compid,compname,address,city,state,country,phone,fax,email,website,category,postcode,contactname,mobile from companies";
		List<Companies> retValue = jdbc.query(sql, new RowMapper<Companies>() {
			@Override
			public Companies mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Companies rows = new Companies();

				rows.setRecid(rs.getInt("recid"));
				rows.setCompid(rs.getString("compid"));
				rows.setCompname(rs.getString("compname"));
				rows.setAddress(rs.getString("address"));
				rows.setCity(rs.getString("city"));
				rows.setState(rs.getString("state"));
				rows.setCountry(rs.getString("country"));
				rows.setPhone(rs.getString("phone"));
				rows.setFax(rs.getString("fax"));
				rows.setEmail(rs.getString("email"));
				rows.setWebsite(rs.getString("website"));
				rows.setCategory(rs.getString("category"));
				rows.setPostcode(rs.getString("postcode"));
				rows.setContactname(rs.getString("contactname"));
				rows.setMobile(rs.getString("mobile"));
				return rows;
			}
		});
		return retValue;
	}

	@Override
	public void saveCompanyDetails(String formData) {
		JSONObject oFormData = new JSONObject(formData);
		int recid = oFormData.getInt("recid");
		String compname = oFormData.getString("compname");
		String address = oFormData.getString("address");
		String city = oFormData.getString("city");
		String state = oFormData.getString("state");
		String phone = oFormData.getString("phone");
		String fax = oFormData.getString("fax");
		String email = oFormData.getString("email");
		String website = oFormData.getString("website");
		String category = oFormData.getJSONObject("category").getString("id");
		String postcode = oFormData.getString("postcode");
		String contactname = oFormData.getString("contactname");
		String mobile = oFormData.getString("mobile");
		String sql = "update companies set compname='" + compname
				+ "',address='" + address + "',city='" + city + "',"
				+ "state='" + state + "',phone='" + phone + "',fax='" + fax
				+ "',email='" + email + "'," + "website='" + website
				+ "',category='" + category + "',postcode='" + postcode + "',"
				+ "contactname='" + contactname + "',mobile='" + mobile
				+ "' where recid=" + recid;
		jdbc.update(sql);
	}

	@Override
	public List<Companies> getCompanyContacts(String compid) {

		String sql = "select recid,compid,name,email,position,notify from company_contacts where compid='"
				+ compid + "'";
		List<Companies> retValue = jdbc.query(sql, new RowMapper<Companies>() {
			@Override
			public Companies mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Companies rows = new Companies();

				rows.setRecid(rs.getInt("recid"));
				rows.setCompid(rs.getString("compid"));
				rows.setName(rs.getString("name"));
				rows.setEmail(rs.getString("email"));
				rows.setPosition(rs.getString("position"));
				rows.setNotify(rs.getString("notify"));

				return rows;
			}
		});
		return retValue;
	}

	@Override
	public void addNewCompany(String compid) {
		String sql = "insert into companies(compid) values('" + compid + "')";
		jdbc.update(sql);
	}

	@Override
	public void addNewContact(String compid) {
		String sql = "insert into company_contacts(compid) values('" + compid + "')";
		jdbc.update(sql);
	}

	@Override
	public List<Companies> getCompanyDocuments(String compid) {
		String sql = "select recid,compid,title,filename,url from company_documents where compid='"
				+ compid + "'";
		List<Companies> retValue = jdbc.query(sql, new RowMapper<Companies>() {
			@Override
			public Companies mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Companies rows = new Companies();

				rows.setRecid(rs.getInt("recid"));
				rows.setCompid(rs.getString("compid"));
				rows.setTitle(rs.getString("title"));
				rows.setFilename(rs.getString("filename"));
				rows.setUrl(rs.getString("url"));

				return rows;
			}
		});
		return retValue;
	}

	
}
