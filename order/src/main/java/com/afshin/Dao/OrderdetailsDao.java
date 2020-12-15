package com.afshin.Dao;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: JPA - Criteria
 */
import com.afshin.Entity.Order;
import com.afshin.Entity.Orderdetails;
import com.afshin.Entity.OrderdetailsPK;
import com.afshin.Entity.Product;
import com.afshin.General.Myentitymanager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;


public class OrderdetailsDao {
    public OrderdetailsDao() {}
    EntityManager entityManager = Myentitymanager.getEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

    public List<Orderdetails> findall() {
        CriteriaQuery<Orderdetails> criteriaQuery = criteriaBuilder.createQuery(Orderdetails.class);
        Root<Orderdetails> od = criteriaQuery.from(Orderdetails.class);
        criteriaQuery.select(od);
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public Orderdetails findbyid(OrderdetailsPK odPK) {
        return entityManager.find(Orderdetails.class, odPK);
    }
    public List<Object[]> someColumn() {
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<Orderdetails> od = criteriaQuery.from(Orderdetails.class);
        criteriaQuery.multiselect(od.get("orderNumber"), od.get("productCode"), od.get("quantityOrdered"), od.get("priceEach"));
        criteriaQuery.orderBy(criteriaBuilder.asc(od.get("orderNumber")), criteriaBuilder.asc(od.get("productCode")));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public List<Object[]> whereClause(int lessthan,int btwn1,int btwn2,int val1,int val2,int val3) {
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<Orderdetails> od = criteriaQuery.from(Orderdetails.class);
        criteriaQuery.multiselect(od.get("orderNumber"), od.get("productCode"), od.get("quantityOrdered"), od.get("priceEach"));
        //WhereClause with Predicates : مبتنی بر
        Predicate lt = criteriaBuilder.lessThan((od.<Integer>get("quantityOrdered")), lessthan);
        Predicate btwn = criteriaBuilder.between((od.<Integer>get("quantityOrdered")), btwn1, btwn2);
        Predicate in = criteriaBuilder.in((od.<Integer>get("orderLineNumber"))).value(val1).value(val2).value(val3);
        Predicate or = criteriaBuilder.or(lt, btwn);
        Predicate whereclause = criteriaBuilder.and(or, in);
        criteriaQuery.where(whereclause);
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public List<Object[]> aggregation() {
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<Orderdetails> od = criteriaQuery.from(Orderdetails.class);
        criteriaQuery.multiselect(od.get("orderNumber"), criteriaBuilder.sum(od.<Integer>get("quantityOrdered")),
                criteriaBuilder.sum(od.<BigDecimal>get("priceEach"))).groupBy(od.get("orderNumber"));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public List<Object[]> joinedQuery(){
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<Orderdetails> od = criteriaQuery.from(Orderdetails.class);
        Join<Orderdetails, Order> o=od.join("order");
        Join<Orderdetails, Product> p=od.join("product");
        criteriaQuery.multiselect(o.get("orderNumber"), o.get("status"),
                                  p.get("productName"), p.get("buyPrice"),
                                  od.get("quantityOrdered"), od.get("priceEach"));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }

    //ExecuteUpdate
    public void insert(Orderdetails orderdetails){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(orderdetails);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }
    public void update(Orderdetails orderdetails){
        try {
            entityManager.getTransaction().begin();
            orderdetails.setQuantityOrdered(orderdetails.getQuantityOrdered());
            orderdetails.setPriceEach(orderdetails.getPriceEach());
            orderdetails.setOrderLineNumber(orderdetails.getOrderLineNumber());
            entityManager.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }
    public void delete(Orderdetails orderdetails){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(orderdetails);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }
}
