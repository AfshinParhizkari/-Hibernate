package com.afshin;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

//HQL method
public class EmployeeDao {
    Session neshast = Mysession.getsession();
    //ExecuteQuery
    public EmployeeDao() {}
    public List<Employee> findall(){
        try(Session localneshast=Mysession.getsession();) { //try with Resources
            return neshast.createQuery("from Employee").list();
        }
    }
    public Employee findbyid(Integer empnum){
        return neshast.find(Employee.class, empnum);
        //return neshast.get(Employee.class, empnum);
        //return neshast.load(Employee.class, empnum);
    }
    public List<Employee> joinedQuey(){
        return neshast.createNamedQuery("JoinEmployeeMitOffice").list();
    }
    public List<?> aggregation(){
        return neshast.createNamedQuery("CountGroup").list();
    }
    public List<?> parameterized(Integer inputnumber){
        return neshast.createNamedQuery("Selectedquery").setParameter("empnum",inputnumber).setMaxResults(10).list();
    }

    //ExecuteUpdate
    public void insert(Employee employee){
        Transaction tx=neshast.beginTransaction();
         neshast.persist(employee);
        tx.commit();
    }
    public void update(Employee employee){
        Transaction tx=neshast.beginTransaction();
        neshast.update(employee);
        tx.commit();
    }
    public void delete(Employee employee){
        Transaction tx=neshast.beginTransaction();
        neshast.delete(employee);
        tx.commit();
    }
}