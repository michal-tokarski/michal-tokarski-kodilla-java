package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacadeRetriever {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> retrieveCompanies_Containing_GivenString(String searchParam) {
        return companyDao.searchCompaniesByName_Containing_GivenString(searchParam);
    }

    public List<Employee> retrieveEmployees_Containing_GivenString(String searchParam){
        return employeeDao.searchEmployeesByLastname_Containing_GivenString(searchParam);
    }

    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public void saveCompany(Company company) {
        companyDao.save(company);
    }

    public void deleteEmployee(Employee employee) {
        employeeDao.delete(employee);
    }

    public void deleteCompany(Company company) {
        companyDao.delete(company);
    }

    public CompanyDao getCompanyDao() {
        return companyDao;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

}
