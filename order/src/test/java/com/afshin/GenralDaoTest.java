package com.afshin;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class GenralDaoTest {


    @Test
    public void findall() {
        OrderdetailsDao dao=new OrderdetailsDao();
        List<Orderdetails> List =dao.findall();

        for(Orderdetails tmp:List)
        {
            System.out.println(tmp);
        }
    }
}