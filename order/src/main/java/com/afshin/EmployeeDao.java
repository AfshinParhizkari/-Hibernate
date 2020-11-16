package com.afshin;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDao {
    public EmployeeDao() {}
    public List<Employee> findall(){
        Session neshast = Mysession.getsession();
        Query query = neshast.createQuery("from Employee");
        return query.list();
    }
    public Employee findbyid(Integer empnum){
        Session neshast = Mysession.getsession();
        return neshast.find(Employee.class, empnum);
        //return neshast.get(Employee.class, empnum);
        //return neshast.load(Employee.class, empnum);

    }

    public List<Employee> besonderquey(){
        Session neshast = Mysession.getsession();
        return neshast.createNamedQuery("JoinEmployeeMitOffice").list();
    }
    public List<?> besonderGroupby(){
        Session neshast = Mysession.getsession();
        return neshast.createNamedQuery("CountGroup").list();
    }
    public List<?> besonderSelect(Integer inputnumber){
        Session neshast = Mysession.getsession();
        return neshast.createNamedQuery("Selectedquery").setParameter("empnum",inputnumber).setMaxResults(10).list();
    }

}
