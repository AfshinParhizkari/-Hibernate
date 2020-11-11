package com.afshin;

import org.hibernate.Session;

import java.util.List;

public class ProductlineDao {
    public ProductlineDao() {
    }

    public List<Productline> findall(){
        Session neshast =Mysession.getsession();
        return neshast.createQuery("from Productline").list();
    }
}
