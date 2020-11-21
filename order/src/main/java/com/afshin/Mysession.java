package com.afshin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Mysession {

    private static final SessionFactory session;
    private static EntityManagerFactory entityManagerFactory = null;

    static {
        try {
            session = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Productline.class)
                    .addAnnotatedClass(Office.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Payment.class)
                    .addAnnotatedClass(PaymentPK.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(Orderdetails.class)
                    .buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getsession() {
        return session.openSession();
    }

    public static void closesession() {
        session.getCurrentSession().close();
    }

    public static EntityManager getEntityManager() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("persistenceorder");
            return entityManagerFactory.createEntityManager();
        }catch (Exception e) {
            System.out.print(e.toString());
            // TODO: handle exception
        }
        finally {
            return null;
        }
    }


}
