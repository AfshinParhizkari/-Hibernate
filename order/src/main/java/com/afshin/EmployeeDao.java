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
}
