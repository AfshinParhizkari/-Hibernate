package com.afshin.Dao;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: JPA - JPQL
 */
import com.afshin.Entity.Customer;
import com.afshin.General.Logback;
import com.afshin.General.Myentitymanager;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDao {
    EntityManager entityManager= Myentitymanager.getEntityManager();
    public CustomerDao() {}
    //ExecuteQuery
    public List<Customer> findall(){
        try {
            List<Customer> customers=entityManager.createQuery("select c from Customer c").getResultList();
            Logback.logger.info("{}.{}|Try: All are Fetched",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return customers;
        }catch (Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public Customer findbyid(Integer input){
        try {
            Customer customer=entityManager.find(Customer.class,input);
            Logback.logger.info("{}.{}|Try: record is Fetched",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return customer;
        }catch (Exception e){
            Logback.logger.error("{}.{}|Exception: {}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public List<Object[]> joinedQuey(){
        return  entityManager.createNamedQuery("JoinCustomerMitOrder").getResultList();
    }
    public List<Object[]> aggregation(){
        return  entityManager.createNamedQuery("AggrigateCustCountry").getResultList();
    }
    public List<Object[]> parameterized(String customername){
        return  entityManager.createNamedQuery("Multiselect").setParameter("custname",customername).getResultList();
    }
    //ExecuteUpdate : JPA
    public Integer insert(Customer customer){

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            Logback.logger.info("{}.{}|Try: Inserted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return customer.getCustomerNumber();
        }catch(Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return -1;
        }

    }
    public Integer update(Customer customer){
        try{
            Customer customerUpdate=findbyid(customer.getCustomerNumber());
            entityManager.getTransaction().begin();
            customerUpdate.setCustomerName(customer.getCustomerName());
            customerUpdate.setContactLastName(customer.getContactLastName());
            customerUpdate.setContactFirstName(customer.getContactFirstName());
            customerUpdate.setContactLastName(customer.getContactLastName());
            customerUpdate.setPhone(customer.getPhone());
            customerUpdate.setAddressLine1(customer.getAddressLine1());
            customerUpdate.setAddressLine2(customer.getAddressLine2());
            customerUpdate.setCity(customer.getCity());
            customerUpdate.setState(customer.getState());
            customerUpdate.setPostalCode(customer.getPostalCode());
            customerUpdate.setCountry(customer.getCountry());
            customerUpdate.setSalesRepEmployeeNumber(customer.getSalesRepEmployeeNumber());
            customerUpdate.setCreditLimit(customer.getCreditLimit());
            entityManager.getTransaction().commit();
            Logback.logger.info("{}.{}|Try: Updated",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return customer.getCustomerNumber();
        }catch(Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
    public Integer delete(Customer customer){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(customer);
            entityManager.getTransaction().commit();
            Logback.logger.info("{}.{}|Try: Deleted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return 1;
        }catch(Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
}
