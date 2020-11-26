package com.afshin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;


public class ProductlineDao {
	EntityManager entityManager=Myentitymanager.getEntityManager();//manage entities : Session
	CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();

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
		criteriaQuery.orderBy(criteriaBuilder.desc(pl.get("productLine")));
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

	//Not working yet!
	public List<?> joinedQuery(){
		CriteriaQuery criteriaQuery=criteriaBuilder.createQuery();
		Root<Product> p=criteriaQuery.from(Product.class);
		Root<Productline> pl=criteriaQuery.from(Productline.class);
		//Join<Product,Productline> associate= p.join("ProductLine");


		criteriaQuery.multiselect(p.get("productCode"),p.get("productName"),p.get("productLine"),pl.get("productLine"));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
}