package com.afshin;

import java.util.List;

import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Mysession {

    private static final SessionFactory mysession;
    static {
         try {
             mysession=new Configuration().configure("hibernate.cfg.xml")
                     //.addAnnotatedClass(Suppliers.class)
                     .buildSessionFactory();
         }catch (Throwable e){
             throw new ExceptionInInitializerError(e);
         }
    }

    public static Session getsession() throws HibernateException {
        return mysession.openSession();
    }

}
