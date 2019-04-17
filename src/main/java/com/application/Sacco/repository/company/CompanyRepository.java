package com.application.Sacco.repository.company;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.Sacco.entity.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	public Company findByCompanyName(String companyName);

}
