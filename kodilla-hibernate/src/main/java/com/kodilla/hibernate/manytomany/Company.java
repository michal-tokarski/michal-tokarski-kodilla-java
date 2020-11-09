package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@NamedNativeQuery(
    name = "Company.searchCompaniesByName_BeginningWith_Given3Characters",
    query = "SELECT * FROM COMPANIES WHERE LEFT(company_name, 3) = :SEARCHPARAM",
    resultClass = Company.class
)

@NamedNativeQuery(
    name = "Company.searchCompaniesByName_Containing_GivenString",
    query = "SELECT * FROM COMPANIES WHERE company_name LIKE CONCAT ('%', :SEARCHPARAM, '%')",
    resultClass = Company.class
)


@Entity
@Table(name = "COMPANIES")
public class Company {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    @ManyToMany (cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "[id=" + id + "] " + name + ";";
    }
}
