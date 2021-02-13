package com.afshin.Dao;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: Hibernate - HQL
 */
import com.afshin.Entity.Employee;
import com.afshin.General.GeneralFunc;
import com.afshin.General.Mysession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

//HQL method
public class EmployeeDao {
    Session neshast = Mysession.getsession();
    //ExecuteQuery
    public EmployeeDao() {}
    public List<Employee> findall(){
        try(Session localneshast=Mysession.getsession();) { //try with Resources
            List<Employee> employees= neshast.createQuery("from Employee").list();
            GeneralFunc.logger.info("{}.{}|Try: All are Fetched",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return employees;
        }catch (Exception e){
            GeneralFunc.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public Employee findbyid(Integer empnum){
        try {
            Employee employee= neshast.find(Employee.class, empnum);
            //Employee employee= neshast.get(Employee.class, empnum);
            //Employee employee= neshast.load(Employee.class, empnum);
            GeneralFunc.logger.info("{}.{}|Try: ID {} is Fetched",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),employee.getEmployeeNumber());
            return employee;
        }catch (Exception e){
            GeneralFunc.logger.error("{}.{}|Exception: {}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public List<Employee> joinedQuey(){
        return neshast.createNamedQuery("JoinEmployeeMitOffice").list();
    }
    public List<?> aggregation(){
        return neshast.createNamedQuery("CountGroup").list();
    }
    public List<Employee> parameterized(Integer inputnumber){
        return neshast.createNamedQuery("Selectedquery").setParameter("empnum",inputnumber).setMaxResults(10).list();
    }

    //ExecuteUpdate
    public void insert(Employee employee){
        try{
            Transaction tx=neshast.beginTransaction();
             neshast.persist(employee);
            tx.commit();
            GeneralFunc.logger.info("{}.{}|Try: Inserted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        }catch(Exception e){
            GeneralFunc.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
        }
    }
    public void update(Employee employee){
        try{
            Transaction tx=neshast.beginTransaction();
            neshast.merge(employee);
            tx.commit();
            GeneralFunc.logger.info("{}.{}|Try: Updated",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        }catch(Exception e){
            GeneralFunc.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
        }
    }
    public void delete(Employee employee){
        try{
            Transaction tx=neshast.beginTransaction();
            neshast.delete(employee);
            tx.commit();
            GeneralFunc.logger.info("{}.{}|Try: Deleted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        }catch(Exception e){
            GeneralFunc.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
        }
    }
}