package com.afshin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class ProductlineDao {
	EntityManager entityManager=Myentitymanager.getEntityManager();

	public List<Productline> findall()
	{
		EntityManager entityManager=Myentitymanager.getEntityManager(); //manage entities : Session

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

	public List<Productline> someColumn(){
		EntityManager entityManager=Myentitymanager.getEntityManager();
		CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
		CriteriaQuery<Productline> criteriaQuery=criteriaBuilder.createQuery(Productline.class);
		Root<Productline> pl=criteriaQuery.from(Productline.class);
		criteriaQuery.multiselect(pl.get("productLine"),pl.get("textDescription"));
		Query q=entityManager.createQuery(criteriaQuery);
		List<Productline> productlines=q.getResultList();
		return productlines;
		//return entityManager.createQuery(criteriaQuery).getResultList();
	}
}