package com.afshin;

import org.hibernate.Session;

import java.util.List;

public class EmployeeDao {
    public EmployeeDao() {
    }
    public List<Employee> findall(){
        Session neshast = Mysession.getsession();
        return neshast.createQuery("from Employee ").list();
    }

    public Employee findbyid(){
        Session neshast = Mysession.getsession();
        return neshast.find(Employee.class,1143);
    }
}
