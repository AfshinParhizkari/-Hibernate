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
import com.afshin.Entity.Product;
import com.afshin.Entity.Productline;
import com.afshin.General.Log4j;
import com.afshin.General.Myentitymanager;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;

public class ProductlineDao {
	EntityManager entityManager = Myentitymanager.getEntityManager();//manage entities : Session created by factory
	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder(); // Build contract template

	//ExecuteQuery : Criteria
	public List<Productline> findall() {
		try {
			CriteriaQuery<Productline> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Productline.class); // recognize Entity
			Root<Productline> pl = criteriaQuery.from(Productline.class); //alias from Entity(in HQL : from productline pl)
			criteriaQuery.select(pl); // in HQL select pl
			criteriaQuery.orderBy(criteriaBuilder.desc(pl.get("productLine")));
			Query q = entityManager.createQuery(criteriaQuery);//select pl from Productline pl
			List<Productline> productlines = q.getResultList();
			Log4j.logger.info("{}.{}|Try: All are Fetched", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
			return productlines;
			//return entityManager.createQuery(myselect).getResultList();
		} catch (Exception e) {
			Log4j.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Productline findbyid(String userInput) {
		try {
			Productline productline = entityManager.find(Productline.class, userInput);
			Log4j.logger.info("{}.{}|Try: record is Fetched", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
			return productline;
		} catch (Exception e) {
			Log4j.logger.error("{}.{}|Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public List<?> someColumn() {
		CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
		Root<?> pl = criteriaQuery.from(Productline.class);
		criteriaQuery.multiselect(pl.get("productLine"), pl.get("textDescription"));
		Query q = entityManager.createQuery(criteriaQuery);
		List<?> list = q.getResultList();
		return list;
		//return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public List<?> whereClause(String input) {
		CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
		Root<?> pl = criteriaQuery.from(Productline.class);
		criteriaQuery.where(criteriaBuilder.equal(pl.get("productLine"), input)); //where pl.productLine=input
		criteriaQuery.multiselect(pl.get("productLine"), pl.get("textDescription"));
		Query q = entityManager.createQuery(criteriaQuery);
		List<?> list = q.getResultList();
		return list;
		//return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public List<?> aggregation() {
		CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
		Root<?> pl = criteriaQuery.from(Productline.class); // from Productline pl
		criteriaQuery.multiselect(pl.get("productLine"), criteriaBuilder.count(pl)).groupBy(pl.get("productLine"));
		//select pl.productLine,count(pl) ..... group by pl.productLine
		Query q = entityManager.createQuery(criteriaQuery);
		return q.getResultList();
	}

	public List<?> joinedQuery() {
		CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery();
		Root<Productline> pl = criteriaQuery.from(Productline.class); //Root Class
		Join<Productline, Product> product = pl.join("products"); // inner join : OneToManyAttribute existed in Productline class
		criteriaQuery.multiselect(product.get("productCode"), product.get("productName"),
				product.get("productLine"), pl.get("productLine"));
		// on Product.productLine= pl.productLine
		Query q = entityManager.createQuery(criteriaQuery);
		return q.getResultList();
	}

	//ExecuteUpdate : JPA
	public String insert(Productline productline) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(productline);
			entityManager.getTransaction().commit();
			Log4j.logger.info("{}.{}|Try: Inserted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
			return productline.getProductLine();
		} catch (Exception e) {
			Log4j.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
			e.printStackTrace();
			return "-1";
		}
	}

	public String update(Productline productline) {
		try {
			Productline productlineupdate=findbyid(productline.getProductLine());
			entityManager.getTransaction().begin();
			productlineupdate.setTextDescription(productline.getTextDescription());
			productlineupdate.setHtmlDescription(productline.getHtmlDescription());
			productlineupdate.setImage(productline.getImage());
			entityManager.getTransaction().commit();
			Log4j.logger.info("{}.{}|Try: Updated", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
			return productline.getProductLine();
		} catch (Exception e) {
			Log4j.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
			e.printStackTrace();
			return "-1";
		}
	}

	public Integer delete(Productline productline) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(productline);
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