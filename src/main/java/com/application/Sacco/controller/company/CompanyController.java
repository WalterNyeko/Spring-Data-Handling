package com.application.Sacco.controller.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.Sacco.entity.company.Company;
import com.application.Sacco.exception.company.CompanyNotFoundException;
import com.application.Sacco.service.company.CompanyService;

@RestController
@RequestMapping("/api/v1/")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("company")
	public Company addNewCompany(@RequestBody Company Company) {
		return companyService.addCompany(Company);
	}
	
	@GetMapping("companies")
	public List<Company> getAllCompanies(){
		return companyService.listAllCompanies();
	}
	
	@GetMapping("company/{company_id}")
	public Company getCompanyById(@PathVariable(name = "company_id") Long companyId) {
		return companyService.getCompany(companyId);
	}
	
	@GetMapping("company")
	public Company getCompanyByName(@RequestParam(name = "company_name") String companyName) {
		return companyService.getCompanyByName(companyName);
	}
	
	@DeleteMapping("company/{company_id}")
	public void deleteCompany(@PathVariable(name = "company_id") Long companyId) {
		companyService.deleteCompany(companyId);
	}
	
	@PutMapping("company/{company_id}")
	public Company updateCompanyInfo(@PathVariable(name = "company_id") Long companyId, @RequestBody Company Company) {
		
		Company company = companyService.getCompany(companyId);
		
		if( company == null ) {
			throw new CompanyNotFoundException("Company is not found");
		}else {
			
			company.setCompanyName(Company.getCompanyName());
			return companyService.editCompany(company);
			
		}
	}

}
