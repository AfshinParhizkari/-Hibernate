package com.afshin;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: JPA - Criteria
 */
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductDao {
    public ProductDao() {}
    EntityManager entityManager=Myentitymanager.getEntityManager();
    CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
    //ExecuteQuery : Criteria
    public List<Product> findall(){
        CriteriaQuery<Product> criteriaQuery=entityManager.getCriteriaBuilder().createQuery(Product.class);
        Root<Product> p=criteriaQuery.from(Product.class);
        Query q=entityManager.createQuery(criteriaQuery.select(p));
        return q.getResultList();
    }
    public Product findbyid(String productCode){
        return entityManager.find(Product.class,productCode);
    }
    public List<Object[]> someColumn(){
        CriteriaQuery<?> criteriaQuery=criteriaBuilder.createQuery();
        Root<?> p=criteriaQuery.from(Product.class);
        criteriaQuery.orderBy(criteriaBuilder.asc(p.get("productCode")));
        criteriaQuery.multiselect(p.get("productCode"),p.get("productName"),p.get("productLine"));
        Query q=entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public List<Object[]> whereClause(String pName){
        CriteriaQuery<?> criteriaQuery=criteriaBuilder.createQuery();
        Root<?> p=criteriaQuery.from(Product.class);
        criteriaQuery.multiselect(p.get("productCode"),p.get("productName"),p.get("productLine"));
        criteriaQuery.where(criteriaBuilder.like(p.<String>get("productName"),"%"+pName+"%"));
        Query query=entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    public List<Object[]> aggregation(){
        CriteriaQuery<?> criteriaQuery=criteriaBuilder.createQuery();
        Root<?> p=criteriaQuery.from(Product.class);
        criteriaQuery.multiselect(p.get("productLine"),criteriaBuilder.count(p),criteriaBuilder.sum(p.<Number>get("buyPrice"))).groupBy(p.get("productLine"));
        Query q=entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public List<Object[]> joinedQuery(){
        CriteriaQuery criteriaQuery=criteriaBuilder.createQuery();
        Root<?> p=criteriaQuery.from(Product.class);
        Join<Product,Productline> pl=p.join("productline");
        criteriaQuery.multiselect(p.get("productCode"),pl.get("productLine"),pl.get("productLine"));
        Query q=entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }

    //ExecuteUpdate : JPA
    public void insert(Product product){
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }
    public void update(Product product){
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
    }
    public void delete(Product product){
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }

}