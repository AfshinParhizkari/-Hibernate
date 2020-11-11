package com.afshin;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductlineDaoTest {

    @Test
    public void findall() {
        ProductlineDao productlineDao=new ProductlineDao();
        List<Productline> productList =productlineDao.findall();

        for(Productline productline:productList)
        {
            System.out.println(productline);
        }
    }
}