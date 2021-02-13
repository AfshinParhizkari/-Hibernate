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
import com.afshin.General.GeneralFunc;
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
            GeneralFunc.logger.info("{}.{}|Try: All are Fetched",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return customers;
        }catch (Exception e){
            GeneralFunc.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public Customer findbyid(Integer input){
        try {
            Customer customer=entityManager.find(Customer.class,input);
            GeneralFunc.logger.info("{}.{}|Try: ID {} is Fetched",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),customer.getCustomerNumber());
            return customer;
        }catch (Exception e){
            GeneralFunc.logger.error("{}.{}|Exception: {}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
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
    public void insert(Customer customer){

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            GeneralFunc.logger.info("{}.{}|Try: Inserted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }

    }
    public void update(Customer customer){
        try{
            entityManager.getTransaction().begin();
            customer.setCustomerName(customer.getCustomerName());
            customer.setContactLastName(customer.getContactLastName());
            customer.setContactFirstName(customer.getContactFirstName());
            customer.setContactLastName(customer.getContactLastName());
            customer.setPhone(customer.getPhone());
            customer.setAddressLine1(customer.getAddressLine1());
            customer.setAddressLine2(customer.getAddressLine2());
            customer.setCity(customer.getCity());
            customer.setState(customer.getState());
            customer.setPostalCode(customer.getPostalCode());
            customer.setCountry(customer.getCountry());
            customer.setSalesRepEmployeeNumber(customer.getSalesRepEmployeeNumber());
            customer.setCreditLimit(customer.getCreditLimit());
            entityManager.getTransaction().commit();
        }catch(Exception e){
            GeneralFunc.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
        }
    }
    public void delete(Customer customer){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(customer);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            GeneralFunc.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
        }
    }
}
