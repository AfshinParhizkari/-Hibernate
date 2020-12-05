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
import com.afshin.General.Myentitymanager;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDao {
    EntityManager entityManager= Myentitymanager.getEntityManager();
    public CustomerDao() {}
    //ExecuteQuery
    public List<Customer> findall(){
        return entityManager.createQuery("select c from Customer c").getResultList();
    }
    public Customer findbyid(Integer input){
        return entityManager.find(Customer.class,input);
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
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }
    public void update(Customer customer){
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
    }
    public void delete(Customer customer){
        entityManager.getTransaction().begin();
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
    }
}
