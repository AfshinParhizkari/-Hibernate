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
import com.afshin.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

import java.sql.Connection;
import java.sql.SQLException;

public class Mysession {
    private static final SessionFactory session;

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
                    .addAnnotatedClass(Orderdetail.class)
                    .buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getsession() {
        return session.openSession();
        //return session.getCurrentSession();
    }
    public static void closesession() {
        session.getCurrentSession().close();
    }

    public static Connection getconnection() {
        final Connection[] con = new Connection[1];
        getsession().doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                con[0] =connection;
            }
        });
        return con[0];
    }
}
