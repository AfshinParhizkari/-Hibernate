package com.afshin.General;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class Myentitymanager {
    private static EntityManagerFactory entityManagerFactory = null;

    public static EntityManager getEntityManager() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("orderdbconfig");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Log4j.logger.info("Myentitymanager.{}|Try: Assigned", Thread.currentThread().getStackTrace()[1].getMethodName());
            return entityManager;
        } catch (Exception e) {
            Log4j.logger.error("Myentitymanager.{}|Exception:{}", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static CriteriaBuilder getCriteriaBuilder() {
        try {
            CriteriaBuilder criteriaBuilder=getEntityManager().getCriteriaBuilder();
            Log4j.logger.info("Myentitymanager.{}|Try: Assigned", Thread.currentThread().getStackTrace()[1].getMethodName());
            return criteriaBuilder;
        } catch (Exception e) {
            Log4j.logger.error("Myentitymanager.{}|Exception:{}", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}