package com.afshin;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SuppliersservTest {
    Suppliersserv suppliersserv=new Suppliersserv();

    @Test
    public void findall() {
        List<Suppliers> suppliersList= suppliersserv.findall();
        for(Suppliers supplier:suppliersList){
            System.out.println(supplier);
        }
        Assert.assertEquals("Incorect Size" ,suppliersList.size()==30,true);
    }
}