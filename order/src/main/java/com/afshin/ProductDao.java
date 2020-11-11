package com.afshin;

import org.hibernate.Session;

import java.util.List;

public class ProductDao {

    public List<Product> findProducts(){

        try(Session neshast=Mysession.getsession();) {
            return neshast.createQuery("from Product ").list();
        }
    }
}
