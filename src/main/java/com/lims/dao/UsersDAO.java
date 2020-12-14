package com.lims.dao;

import com.lims.model.Users;

import java.util.List;

public interface UsersDAO {
	
	public List<Users> UsersList();
	
	public void delete(String recid);
	
	public void saveOrUpdate(int recid,String field);
	
	public String insert(String data);
	
	public void SaveForm(String formData);

	public Users findByUserName(String userName);

	public void save(Users user);
}
