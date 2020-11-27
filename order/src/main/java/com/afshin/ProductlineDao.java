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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;

public class ProductlineDao {
	EntityManager entityManager=Myentitymanager.getEntityManager();//manage entities : Session created by factory
	CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder(); // Build contract template
	//ExecuteQuery : Criteria
	public List<Productline> findall()	{
		CriteriaQuery<Productline> cq =entityManager.getCriteriaBuilder().createQuery(Productline.class); // recognize Entity
		Root<Productline> pl=cq.from(Productline.class); //alias from Entity(in HQL : from productline pl)
		CriteriaQuery<Productline> myselect=cq.select(pl); // in HQL select pl
		/*
			Query q=entityManager.createQuery(myselect);
			List<Productline> productlines=q.getResultList();
			return productlines;
		 */
		return entityManager.createQuery(myselect).getResultList();
	}
	public Productline findbyid(String userInput){
		return entityManager.find(Productline.class,userInput);
	}
	public List<?> someColumn(){
		CriteriaQuery<?> criteriaQuery=criteriaBuilder.createQuery();
		Root<?> pl=criteriaQuery.from(Productline.class);
		CriteriaQuery<?> myselect= criteriaQuery.multiselect(pl.get("productLine"),pl.get("textDescription"));
		Query q=entityManager.createQuery(myselect);
		List<?> list=q.getResultList();
		return list;
		//return entityManager.createQuery(criteriaQuery).getResultList();
	}
	public List<?> whereClause(String input){
		CriteriaQuery<?> criteriaQuery=criteriaBuilder.createQuery();
		Root<?> pl=criteriaQuery.from(Productline.class);
		//criteriaQuery.orderBy(criteriaBuilder.desc(pl.get("productLine")));
		criteriaQuery.where(criteriaBuilder.equal(pl.get("productLine"),input));
		criteriaQuery.multiselect(pl.get("productLine"),pl.get("textDescription"));
		Query q=entityManager.createQuery(criteriaQuery);
		List<?> list=q.getResultList();
		return list;
		//return entityManager.createQuery(criteriaQuery).getResultList();
	}
	public List<?> aggregation(){
		CriteriaQuery<?> criteriaQuery=criteriaBuilder.createQuery();
		Root<?> pl=criteriaQuery.from(Productline.class);
		criteriaQuery.multiselect(pl.get("productLine"),criteriaBuilder.count(pl)).groupBy(pl.get("productLine"));
		Query q=entityManager.createQuery(criteriaQuery);
		return q.getResultList();
	}
	public List<?> joinedQuery(){
		CriteriaQuery criteriaQuery=criteriaBuilder.createQuery();
		//Root<Product> p=criteriaQuery.from(Product.class);
		Root<Productline> pl=criteriaQuery.from(Productline.class); //Root Class
		Join<Productline,Product> product= pl.join("products"); // inner join : OneToManyAttribute existed in Productline class
		criteriaQuery.multiselect(product.get("productCode"),product.get("productName"),
				product.get("productLine"),pl.get("productLine"));
		criteriaQuery.where(criteriaBuilder.equal(product.get("productLine"),pl.get("productLine"))); // on Product.productLine= pl.productLine
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	//ExecuteUpdate : JPA
	public void insert(Productline productline){
		entityManager.getTransaction().begin();
		entityManager.persist(productline);
		entityManager.getTransaction().commit();
	}
	public void update(Productline pl){
		entityManager.getTransaction().begin();
		pl.setTextDescription(pl.getTextDescription());
		pl.setHtmlDescription(pl.getHtmlDescription());
		entityManager.getTransaction().commit();
	}
	public void delete(Productline productline){
		entityManager.getTransaction().begin();
		entityManager.remove(productline);
		entityManager.getTransaction().commit();
	}
}