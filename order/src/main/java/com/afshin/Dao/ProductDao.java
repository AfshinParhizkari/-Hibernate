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
import com.afshin.Entity.Orderdetail;
import com.afshin.Entity.Product;
import com.afshin.Entity.Productline;
import com.afshin.General.Log4j;
import com.afshin.General.Myentitymanager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class ProductDao {
    public ProductDao() {
    }

    EntityManager entityManager = Myentitymanager.getEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

    //ExecuteQuery : Criteria
    public List<Product> findall() {
        try {
            CriteriaQuery<Product> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Product.class);
            Root<Product> p = criteriaQuery.from(Product.class);
            Query q = entityManager.createQuery(criteriaQuery.select(p));
            List<Product> products = q.getResultList();
            Log4j.logger.info("{}.{}|Try: All are Fetched", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return products;
        } catch (Exception e) {
            Log4j.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Product findbyid(String productCode) {
        try {
            Product product = entityManager.find(Product.class, productCode);
            Log4j.logger.info("{}.{}|Try: record is Fetched", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return product;
        } catch (Exception e) {
            Log4j.logger.error("{}.{}|Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Object[]> someColumn() {
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<?> p = criteriaQuery.from(Product.class);
        criteriaQuery.orderBy(criteriaBuilder.asc(p.get("productCode")));
        criteriaQuery.multiselect(p.get("productCode"), p.get("productName"), p.get("productLine"));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }

    public List<Object[]> whereClause(String pName) {
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<?> p = criteriaQuery.from(Product.class);
        criteriaQuery.multiselect(p.get("productCode"), p.get("productName"), p.get("productLine"));
        criteriaQuery.where(criteriaBuilder.like(p.<String>get("productName"), "%" + pName + "%"));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Object[]> aggregation() {
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
        Root<?> p = criteriaQuery.from(Product.class);
        criteriaQuery.multiselect(p.get("productLine"), criteriaBuilder.count(p), criteriaBuilder.sum(p.<Number>get("buyPrice"))).groupBy(p.get("productLine"));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }

    public List<Object[]> joinedQuery() {
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<?> p = criteriaQuery.from(Product.class);
        Join<Product, Productline> pl = p.join("productline");
        criteriaQuery.multiselect(p.get("productCode"), pl.get("productLine"), pl.get("productLine"));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }

    public List<Product> subQuery() {
        //SELECT * FROM products p where p.productCode not in (select od.productCode from orderdetails od);
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        //from products p
        Root<Product> p = criteriaQuery.from(Product.class);
        //SubQuery: (select od.productCode from orderdetails od)
        Subquery<String> subquery = criteriaQuery.subquery(String.class);
        Root<Orderdetail> od = subquery.from(Orderdetail.class);
        subquery.select(od.<String>get("productCode")).distinct(true);
        //Select p .... WhereClause on Subquery: where p.productCode not in
        criteriaQuery.select(p).where(criteriaBuilder.not(p.get("productCode").in(subquery)));
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }

    //ExecuteUpdate : JPA
    public String insert(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            Log4j.logger.info("{}.{}|Try: Inserted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return product.getProductCode();
        } catch (Exception e) {
            Log4j.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return "-1";
        }
    }
    public String update(Product product) {
        try {
            entityManager.getTransaction().begin();
            product.setProductName(product.getProductName());
            product.setProductLine(product.getProductLine());
            product.setProductScale(product.getProductScale());
            product.setProductVendor(product.getProductVendor());
            product.setProductDescription(product.getProductDescription());
            product.setQuantityInStock(product.getQuantityInStock());
            product.setBuyPrice(product.getBuyPrice());
            product.setMSRP(product.getMSRP());
            entityManager.getTransaction().commit();
            Log4j.logger.info("{}.{}|Try: Updated", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return product.getProductCode();
        } catch (Exception e) {
            Log4j.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return "-1";
        }
    }
    public Integer delete(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.getTransaction().commit();
            Log4j.logger.info("{}.{}|Try: Deleted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return 1;
        } catch (Exception e) {
            Log4j.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

}