package com.afshin;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class ProductDaoTest {

    @Test
    public void findProducts() {
        ProductDao productDao=new ProductDao();
        List<Product> productList=productDao.findProducts();
        for(Product product:productList)
        {
            System.out.println(product);
        }
    }
}