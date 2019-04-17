package com.application.Sacco.service.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Sacco.entity.company.Company;
import com.application.Sacco.repository.company.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company addCompany(Company Company) {
		// TODO Auto-generated method stub
		return companyRepository.save(Company);
	}

	@Override
	public Company editCompany(Company Company) {
		// TODO Auto-generated method stub
		return companyRepository.saveAndFlush(Company);
	}

	@Override
	public Company getCompany(Long companyId) {
		// TODO Auto-generated method stub
		return companyRepository.findById(companyId).orElse(null);
	}

	@Override
	public List<Company> listAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public void deleteCompany(Long companyId) {
		// TODO Auto-generated method stub
		companyRepository.deleteById(companyId);
	}

	@Override
	public Company getCompanyByName(String companyName) {
		// TODO Auto-generated method stub
		return companyRepository.findByCompanyName(companyName);
	}

}
