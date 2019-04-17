package com.application.Sacco.service.company;

import java.util.List;

import com.application.Sacco.entity.company.Company;

public interface CompanyService {
	
	Company addCompany(Company Company);
	
	Company editCompany(Company Company);
	
	Company getCompany(Long companyId);
	
	Company getCompanyByName(String companyName);
	
	List<Company> listAllCompanies();
	
	void deleteCompany(Long companyId);

}
