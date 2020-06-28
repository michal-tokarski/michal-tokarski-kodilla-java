package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyEmployeeDaoTestSuite {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void test_SearchCompaniesByNameThatBeginsWith(){

        //Given
        // Create objects
        Company company1 = new Company("Bank Zachodni");
        Company company2 = new Company("Banca Intaliano");
        Company company3 = new Company("Polski Bank Rozwoju");
        Company company4 = new Company("Bank Handlowy");
        Company company5 = new Company("Bank Rozwoju Exportu");

        // Save records to database
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        companyDao.save(company4);
        companyDao.save(company5);

        // Retrieve records ID's from database
        int retrievedCompanyID1 = company1.getId();
        int retrievedCompanyID2 = company2.getId();
        int retrievedCompanyID3 = company3.getId();
        int retrievedCompanyID4 = company4.getId();
        int retrievedCompanyID5 = company5.getId();

        // When
        String searchParam1 = "Ban";
        String searchParam2 = "Ben";
        List<Company> resultList1 = companyDao.searchCompaniesByNameThatBeginsWith(searchParam1);
        List<Company> resultList2 = companyDao.searchCompaniesByNameThatBeginsWith(searchParam2);

        // Then
        System.out.println("Test Results :");
        System.out.println("---------------");
        System.out.println("Search parameter : " + searchParam1);
        System.out.println("Returned records : " + resultList1.toString());
        System.out.println("Search parameter : " + searchParam2);
        System.out.println("Returned records : " + resultList2.toString());

        Assert.assertEquals(4, resultList1.size());
        Assert.assertEquals(0, resultList2.size());

        // CleanUp
        try {
            companyDao.deleteById(retrievedCompanyID1);
            companyDao.deleteById(retrievedCompanyID2);
            companyDao.deleteById(retrievedCompanyID3);
            companyDao.deleteById(retrievedCompanyID4);
            companyDao.deleteById(retrievedCompanyID5);

        } catch (Exception e) {
            //do nothing
        }

    }

    @Test
    public void test_SearchEmployeesByLastnameThatEquals(){

        // Given
        // Create objects
        Employee employee1 = new Employee("Roman","Malinowski");
        Employee employee2 = new Employee("Adam","Nowak");
        Employee employee3 = new Employee("Artur","Malinowski");
        Employee employee4 = new Employee("Beata","Nowak");
        Employee employee5 = new Employee("Ewa","Nowak");

        // Save records to database
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        employeeDao.save(employee4);
        employeeDao.save(employee5);

        // Retrieve records ID's from database
        int retrievedEmployeeID1 = employee1.getId();
        int retrievedEmployeeID2 = employee2.getId();
        int retrievedEmployeeID3 = employee3.getId();
        int retrievedEmployeeID4 = employee4.getId();
        int retrievedEmployeeID5 = employee5.getId();

        // When
        String searchParam1 = "Malinowski";
        String searchParam2 = "Nowakowski";
        List<Employee> resultList1 = employeeDao.searchEmployeesByLastnameThatEquals(searchParam1);
        List<Employee> resultList2 = employeeDao.searchEmployeesByLastnameThatEquals(searchParam2);

        // Then
        System.out.println("Test Results :");
        System.out.println("---------------");
        System.out.println("Search parameter : " + searchParam1);
        System.out.println("Returned records : " + resultList1.toString());
        System.out.println("Search parameter : " + searchParam2);
        System.out.println("Returned records : " + resultList2.toString());

        Assert.assertEquals(2, resultList1.size());
        Assert.assertEquals(0, resultList2.size());

        // CleanUp
        try {
            employeeDao.deleteById(retrievedEmployeeID1);
            employeeDao.deleteById(retrievedEmployeeID2);
            employeeDao.deleteById(retrievedEmployeeID3);
            employeeDao.deleteById(retrievedEmployeeID4);
            employeeDao.deleteById(retrievedEmployeeID5);

        } catch (Exception e) {
            //do nothing
        }

    }


}

