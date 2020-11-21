package com.afshin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class Myentitymanager {
    private static EntityManagerFactory entityManagerFactory = null;

    public static EntityManager getEntityManager() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("orderdbconfig");
            return entityManagerFactory.createEntityManager();
        }catch (Exception e) {
            System.out.print(e.toString());
        }
        return null;
    }

    public static CriteriaBuilder getCriteriaBuilder(){
        return getEntityManager().getCriteriaBuilder();
    }
}