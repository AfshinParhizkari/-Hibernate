package com.afshin;

import org.hibernate.Session;

import java.util.List;

public class OrderdetailsDao {
    public OrderdetailsDao() {
    }
    public List<Orderdetails> findall(){
        Session neshast =Mysession.getsession();
        return neshast.createQuery("from Orderdetails ").list();
    }

}
