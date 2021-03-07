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
import com.afshin.Entity.Orderdetail;
import com.afshin.Entity.OrderdetailPK;
import com.afshin.Entity.Product;
import com.afshin.General.Log4j;
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

    public List<Orderdetail> findall() {
        try {
            CriteriaQuery<Orderdetail> criteriaQuery = criteriaBuilder.createQuery(Orderdetail.class);
            Root<Orderdetail> od = criteriaQuery.from(Orderdetail.class);
            criteriaQuery.select(od);
            Query q = entityManager.createQuery(criteriaQuery);
            List<Orderdetail> orderdetails = q.getResultList();
            Log4j.logger.info("{}.{}|Try: All are Fetched", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return orderdetails;
        } catch (Exception e) {
            Log4j.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public Orderdetail findbyid(OrderdetailPK odPK) {
        try{
            Orderdetail orderdetail=entityManager.find(Orderdetail.class, odPK);
            Log4j.logger.info("{}.{}|Try: record is Fetched",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return orderdetail;
        }catch (Exception e){
            Log4j.logger.error("{}.{}|Exception: {}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public List<Object[]> someColumn() {
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<Orderdetail> od = criteriaQuery.from(Orderdetail.class);
        criteriaQuery.multiselect(od.get("orderNumber"), od.get("productCode"), od.get("quantityOrdered"), od.get("priceEach"));
        criteriaQuery.orderBy(criteriaBuilder.asc(od.get("orderNumber")), criteriaBuilder.asc(od.get("productCode")));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public List<Object[]> whereClause(int lessthan,int btwn1,int btwn2,int val1,int val2,int val3) {
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<Orderdetail> od = criteriaQuery.from(Orderdetail.class);
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
        Root<Orderdetail> od = criteriaQuery.from(Orderdetail.class);
        criteriaQuery.multiselect(od.get("orderNumber"), criteriaBuilder.sum(od.<Integer>get("quantityOrdered")),
                criteriaBuilder.sum(od.<BigDecimal>get("priceEach"))).groupBy(od.get("orderNumber"));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public List<Object[]> joinedQuery(){
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<Orderdetail> od = criteriaQuery.from(Orderdetail.class);
        Join<Orderdetail, Order> o=od.join("order");
        Join<Orderdetail, Product> p=od.join("product");
        criteriaQuery.multiselect(o.get("orderNumber"), o.get("status"),
                                  p.get("productName"), p.get("buyPrice"),
                                  od.get("quantityOrdered"), od.get("priceEach"));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }

    //ExecuteUpdate
    public OrderdetailPK insert(Orderdetail orderdetail){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(orderdetail);
            entityManager.getTransaction().commit();
            Log4j.logger.info("{}.{}|Try: Inserted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return new OrderdetailPK(orderdetail.getOrderNumber(),orderdetail.getProductCode());
        }catch(Exception e){
            Log4j.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public OrderdetailPK update(Orderdetail orderdetail){
        try {

            Orderdetail orderdetailupdate=findbyid(new OrderdetailPK(orderdetail.getOrderNumber(),orderdetail.getProductCode()));
            entityManager.getTransaction().begin();
            orderdetailupdate.setQuantityOrdered(orderdetail.getQuantityOrdered());
            orderdetailupdate.setPriceEach(orderdetail.getPriceEach());
            orderdetailupdate.setOrderLineNumber(orderdetail.getOrderLineNumber());
            entityManager.getTransaction().commit();
            Log4j.logger.info("{}.{}|Try: Updated",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return new OrderdetailPK(orderdetail.getOrderNumber(),orderdetail.getProductCode());
        }catch(Exception e){
            Log4j.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public Integer delete(Orderdetail orderdetail){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(orderdetail);
            entityManager.getTransaction().commit();
            Log4j.logger.info("{}.{}|Try: Deleted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return 1;
        }catch(Exception e){
            Log4j.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
}