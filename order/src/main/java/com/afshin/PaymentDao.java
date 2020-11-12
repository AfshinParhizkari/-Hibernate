package com.afshin;

import org.hibernate.Session;

import java.util.List;

public class PaymentDao {
    public PaymentDao() {
    }

    public List<Payment> findall(){
        Session neshast = Mysession.getsession();
        return neshast.createQuery("from Payment ").list();
    }
}
