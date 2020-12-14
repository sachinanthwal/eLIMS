package com.lims.dao;

import com.lims.model.Companies;

import java.util.List;

public interface CompaniesDAO {

	public List<Companies> getCompaniesList();
	public void saveCompanyDetails(String data);
	public List<Companies> getCompanyContacts(String compid);
	public List<Companies> getCompanyDocuments(String compid);
	public void addNewCompany(String compid);
	public void addNewContact(String compid);
}
