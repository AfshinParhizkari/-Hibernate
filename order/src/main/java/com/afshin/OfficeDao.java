package com.afshin;

import org.hibernate.Session;

import java.util.List;

public class OfficeDao {

    public List<Office> findall(){
        Session neshast =Mysession.getsession();
        return neshast.createQuery("from Office ").list();
    }
}
