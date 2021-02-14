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
            Log4j.logger.info("Mysession.{}|Try: Created", Thread.currentThread().getStackTrace()[1].getMethodName());
        } catch (Exception e) {
            Log4j.logger.error("Mysession.{}|Exception:{}", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getsession() {
        try {
            Session sessiontmp = session.openSession();
            Log4j.logger.info("Mysession.{}|Try: Opened", Thread.currentThread().getStackTrace()[1].getMethodName());
            return sessiontmp;
            //return session.getCurrentSession();
        } catch (Exception e) {
            Log4j.logger.error("Mysession.{}|Exception:{}", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void closesession() {
        try {
            session.getCurrentSession().close();
            Log4j.logger.info("Mysession.{}|Try: Closed", Thread.currentThread().getStackTrace()[1].getMethodName());
        } catch (Exception e) {
            Log4j.logger.error("Mysession.{}|Exception:{}", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getconnection() {
        try {
            final Connection[] con = new Connection[1];
            getsession().doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    con[0] = connection;
                }
            });
            Log4j.logger.info("Mysession.{}|Try: Assigned", Thread.currentThread().getStackTrace()[1].getMethodName());
            return con[0];
        } catch (Exception e) {
            Log4j.logger.error("Mysession.{}|Exception:{}", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
