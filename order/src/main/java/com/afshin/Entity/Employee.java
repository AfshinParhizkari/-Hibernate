package com.afshin.Entity;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(name = "JoinEmployeeMitOffice",query = "Select e from Employee e inner join fetch e.customers c" +
                " where e.employeeNumber=c.salesRepEmployeeNumber"),
        @NamedQuery(name = "CountGroup",query = "Select e.officeCode, count(e.employeeNumber) from Employee e " +
                "group by e.officeCode order by e.officeCode"),
        //parameterized query: named parameter
        @NamedQuery(name = "Selectedquery",query = "select e from Employee e where e.reportsTo=:empnum"
        )
})
public class Employee {

    public Employee() {
    }

    @Transient
        private Integer count;

    @Id
    @Column(name = "employeeNumber")
    private Integer employeeNumber;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @Column(name = "officeCode")
    private String officeCode;

    @Column(name = "reportsTo")
    private Integer reportsTo;

    @Column(name = "jobTitle")
    private String jobTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officeCode",insertable = false,updatable = false)
    private Office office;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
    private List<Customer> customers;

    @OneToMany(mappedBy = "manager",fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsTo",referencedColumnName = "employeeNumber",insertable = false,updatable = false)
    private Employee manager;

/*    @OneToMany(mappedBy = "employee")
    List<User> users;*/

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public List<Customer> getCustomers() {return customers;}
     public void setCustomers(List<Customer> customers) {this.customers = customers;}

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    //public List<User> getUsers() {return users;}
    //public void setUsers(List<User> users) {this.users = users;}

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", officeCode='" + officeCode + '\'' +
                ", reportsTo=" + reportsTo +
                ", jobTitle='" + jobTitle + '\'' +
//                "\n, office=" + office +
                "\n, customers=" + customers +
//               "\n, employeeList=" + employeeList +
//                "\n, manager=" + manager +
                '}';
    }
}