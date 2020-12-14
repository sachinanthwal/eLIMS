package com.lims.dao;

import com.lims.model.Users;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	private JdbcOperations jdbc;

	@Override
	public List<Users> UsersList() {
		String sql = "select recid,address,dob,im,email,fullname,gender,job_title,password,prof_id,prof_image,pwd_expiry,remark,status,username from users";
		List<Users> listUsers = jdbc.query(sql, new RowMapper<Users>() {
			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users aUsers = new Users();
				aUsers.setRecid(rs.getInt("recid"));
				aUsers.setAddress(rs.getString("address"));
				aUsers.setDob(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("dob")));
				aUsers.setIm(rs.getString("im"));
				aUsers.setEmail(rs.getString("email"));
				aUsers.setFullname(rs.getString("fullname"));
				aUsers.setGender(rs.getString("gender"));
				aUsers.setJob_title(rs.getString("job_title"));
				aUsers.setPassword(rs.getString("password"));
				aUsers.setProf_id(rs.getString("prof_id"));
				aUsers.setProf_image(rs.getString("prof_image"));
				aUsers.setPwd_expiry(rs.getDate("pwd_expiry"));
				aUsers.setRemark(rs.getString("remark"));
				aUsers.setStatus(rs.getString("status"));
				aUsers.setUsername(rs.getString("username"));
				return aUsers;
			}
		});
		return listUsers;
	}

	@Override
	public void delete(String recid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrUpdate(int recid, String field) {
		// TODO Auto-generated method stub

	}

	@Override
	public String insert(String data) {
		String RetValue = "";
		try {
			JSONObject json = new JSONObject(data);
			JSONObject formdata = json.getJSONObject("record");
			String username = formdata.getString("username");
			String fullname = formdata.getString("fullname");
			Date dob = new SimpleDateFormat("dd-MM-yyyy").parse(formdata.getString("dob"));
			String datedob = new SimpleDateFormat("yyyy-MM-dd").format(dob);
			String gender = formdata.getJSONObject("gender").getString("id");

			
			String sql = "select count(*) from users where username='"
					+ username + "'";
			int exists = jdbc.queryForObject(sql, Integer.class);

			if (exists > 0) {
				RetValue = "{\"message\" : \"User Already Exists\"}";
			} else {
				String sqlins = "insert into users(username,fullname,status,dob,gender,password,pwd_expiry,prof_id) "
						+ "values('"+ username + "','" + fullname + "','Draft','"+datedob+"','"+gender+"','LIMS','2019-01-01','')";
				jdbc.update(sqlins);

				RetValue = "{\"message\": \"User Added Successfully\"}";
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return RetValue;
	}

	@Override
	public void SaveForm(String formData) {
		try {
			JSONObject jsonObj = new JSONObject(formData);
			JSONObject oFormData = new JSONObject(jsonObj.get("formdata").toString());
			int recid = oFormData.getInt("recid");
			String password = oFormData.getString("password");
			String fullname = oFormData.getString("fullname");
			String gender = oFormData.getJSONObject("gender").getString("id");
			Date dob = new SimpleDateFormat("dd-MM-yyyy").parse(oFormData
					.getString("dob"));
			// System.out.println(dob);
			String datedob = new SimpleDateFormat("yyyy-MM-dd").format(dob);
			// System.out.println(datedob);
			String pwd_expiry = oFormData.getString("pwd_expiry");
			String status = oFormData.getJSONObject("status").getString("id");
			String prof_id = oFormData.getString("prof_id");
			String job_title = oFormData.getJSONObject("job_title").getString(
					"id");
			String email = oFormData.getString("email");
			String im = oFormData.getString("im");
			String address = oFormData.getString("address");

			String sql = "update users set password='" + password
					+ "',fullname='" + fullname + "',gender='" + gender
					+ "',status='" + status + "',prof_id='" + prof_id
					+ "',job_title='" + job_title + "',email='" + email
					+ "',im='" + im + "',address='" + address + "',dob='"
					+ datedob + "'" + " where recid=" + recid;
			// System.out.print(sql);
			jdbc.update(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Users findByUserName(String userName) {
		String sql = "select username, password from testuser where username ='"+userName+"'";
		Users user = jdbc.queryForObject(sql, new RowMapper<Users>() {
			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users user = new Users();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		return user;

	}

	@Override
	public void save(Users user) {
		String sql = "insert into TestUser (username,password) values('"+user.getUsername()+"','"+user.getPassword()+"')";
		jdbc.update(sql);
	}
}
