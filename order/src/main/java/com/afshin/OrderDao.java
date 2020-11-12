package com.afshin;

import org.hibernate.Session;
import java.util.List;

public class OrderDao {
    public OrderDao() {
    }

    public List<Order> findall(){
        Session neshast = Mysession.getsession();
        return neshast.createQuery("from Order ").list();
    }


}
