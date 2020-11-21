package com.afshin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;


public class ProductlineDao {
	
	public void findall()
	{
		EntityManager neshast=Mysession.getEntityManager();
		   CriteriaBuilder criteriaBuilder = neshast.getCriteriaBuilder();
		   javax.persistence.criteria.CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		   Root<Productline> from = criteriaQuery.from(Productline.class);
		   javax.persistence.criteria.CriteriaQuery<Object> select = criteriaQuery.select(from);
		   TypedQuery<Object> typedQuery = neshast.createQuery(select);
		   List<Object> resultlist = typedQuery.getResultList();
		    
		   for(Object o:resultlist) {
			   Productline e = (Productline)o;
			      System.out.println(e);
			   }
		
	}
}
