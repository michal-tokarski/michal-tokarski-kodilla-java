package com.kodilla.hibernate.manytomany.facade;

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
public class FacadeRetriever_TestSuite {

    @Autowired
    private FacadeRetriever facadeRetriever;

    @Test
    public void test_RetrieveCompanies_Containing_GivenString() {

        // Given
        // Create objects
        Company company1 = new Company("Bank Zachodni");
        Company company2 = new Company("Banca Intaliano");
        Company company3 = new Company("Polski Bank Rozwoju");
        Company company4 = new Company("Bank Handlowy");
        Company company5 = new Company("Bank Rozwoju Exportu");

        // Save records to database
        facadeRetriever.saveCompany(company1);
        facadeRetriever.saveCompany(company2);
        facadeRetriever.saveCompany(company3);
        facadeRetriever.saveCompany(company4);
        facadeRetriever.saveCompany(company5);

        /*
        // not necessary here
        // Retrieve records ID's from database
        int retrievedCompanyID1 = company1.getId();
        int retrievedCompanyID2 = company2.getId();
        int retrievedCompanyID3 = company3.getId();
        int retrievedCompanyID4 = company4.getId();
        int retrievedCompanyID5 = company5.getId();
        */

        // When
        String searchParam0 = "%"; // All
        String searchParam1 = "Ban";
        String searchParam2 = "Rozwoju";
        List<Company> resultList0 = facadeRetriever.retrieveCompanies_Containing_GivenString(searchParam0); // All
        List<Company> resultList1 = facadeRetriever.retrieveCompanies_Containing_GivenString(searchParam1);
        List<Company> resultList2 = facadeRetriever.retrieveCompanies_Containing_GivenString(searchParam2);

        // Then
        System.out.println("==================================================");
        System.out.println("test_RetrieveCompanies_Containing_GivenString :");
        System.out.println("==================================================");
        System.out.println("Search parameter As-Is : " + searchParam0);
        System.out.println("Retrieved objects As-Is : " + resultList0.toString());
        System.out.println("No. of objects As-Is : " + resultList0.size());
        System.out.println("-------------------------------------------------");
        System.out.println("Search parameter 1 : " + searchParam1);
        System.out.println("Retrieved objects 1 : " + resultList1.toString());
        System.out.println("No. of objects 1 : " + resultList1.size());
        System.out.println("-------------------------------------------------");
        System.out.println("Search parameter 2 : " + searchParam2);
        System.out.println("Retrieved objects 2 : " + resultList2.toString());
        System.out.println("No. of objects 2 : " + resultList2.size());
        System.out.println("==================================================");


        Assert.assertEquals(5, resultList1.size());
        Assert.assertEquals(2, resultList2.size());

        // CleanUp
        try {
            facadeRetriever.deleteCompany(company1);
            facadeRetriever.deleteCompany(company2);
            facadeRetriever.deleteCompany(company3);
            facadeRetriever.deleteCompany(company4);
            facadeRetriever.deleteCompany(company5);

        } catch (Exception e) {
            // do nothing
        }

    }

    @Test
    public void test_RetrieveEmployees_Containing_GivenString() {

        // Given
        // Create objects
        Employee employee1 = new Employee("Roman","Malinowski");
        Employee employee2 = new Employee("Adam","Ciepielak");
        Employee employee3 = new Employee("Artur","Malinowski");
        Employee employee4 = new Employee("Beata","Nowak");
        Employee employee5 = new Employee("Ewa","Nowak");

        // Save records to database
        facadeRetriever.saveEmployee(employee1);
        facadeRetriever.saveEmployee(employee2);
        facadeRetriever.saveEmployee(employee3);
        facadeRetriever.saveEmployee(employee4);
        facadeRetriever.saveEmployee(employee5);

        /*
        // not necessary here
        // Retrieve records ID's from database
        int retrievedEmployeeID1 = employee1.getId();
        int retrievedEmployeeID2 = employee2.getId();
        int retrievedEmployeeID3 = employee3.getId();
        int retrievedEmployeeID4 = employee4.getId();
        int retrievedEmployeeID5 = employee5.getId();
         */

        // When
        String searchParam0 = "%"; // All
        String searchParam1 = "Malinowski";
        String searchParam2 = "ak";
        List<Employee> resultList0 = facadeRetriever.retrieveEmployees_Containing_GivenString(searchParam0); // All
        List<Employee> resultList1 = facadeRetriever.retrieveEmployees_Containing_GivenString(searchParam1);
        List<Employee> resultList2 = facadeRetriever.retrieveEmployees_Containing_GivenString(searchParam2);

        // Then
        System.out.println("==================================================");
        System.out.println("test_RetrieveEmployees_Containing_GivenString() :");
        System.out.println("==================================================");
        System.out.println("Search parameter As-Is : " + searchParam0);
        System.out.println("Retrieved objects As-Is : " + resultList0.toString());
        System.out.println("No. of objects As-Is : " + resultList0.size());
        System.out.println("-------------------------------------------------");
        System.out.println("Search parameter 1 : " + searchParam1);
        System.out.println("Retrieved objects 1 : " + resultList1.toString());
        System.out.println("No. of objects 1 : " + resultList1.size());
        System.out.println("-------------------------------------------------");
        System.out.println("Search parameter 2 : " + searchParam2);
        System.out.println("Retrieved objects 2 : " + resultList2.toString());
        System.out.println("No. of objects 2 : " + resultList2.size());
        System.out.println("==================================================");

        Assert.assertEquals(2, resultList1.size());
        Assert.assertEquals(3, resultList2.size());

        // CleanUp
        try {
            facadeRetriever.deleteEmployee(employee1);
            facadeRetriever.deleteEmployee(employee2);
            facadeRetriever.deleteEmployee(employee3);
            facadeRetriever.deleteEmployee(employee4);
            facadeRetriever.deleteEmployee(employee5);

        } catch (Exception e) {
            // do nothing
        }

    }

}


