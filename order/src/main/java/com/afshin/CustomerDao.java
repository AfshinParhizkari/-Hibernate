package com.afshin;

import com.afshin.Customer;
import com.afshin.Mysession;
import org.hibernate.Session;

import java.util.List;

public class CustomerDao {
    public CustomerDao() {
    }

    public List<Customer> findall() {
        Session neshast = Mysession.getsession();
        return neshast.createQuery("from Customer ").list();
    }
}
