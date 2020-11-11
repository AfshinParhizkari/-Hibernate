package com.afshin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Mysession {

    private static final SessionFactory session;

    static {
        try {
            session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).addAnnotatedClass(Productline.class).buildSessionFactory();
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
}
