package com.afshin;

import com.afshin.Entity.Orderdetails;
import com.afshin.Dao.OrderdetailsDao;
import com.afshin.Entity.OrderdetailsPK;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 04
 * @Time 2:30 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
public class OrderdetailsDaoTest {
    OrderdetailsDao dao=new OrderdetailsDao();
    @Test
    public void findAllTest() {
        List<Orderdetails> list =dao.findall();
        for (Orderdetails tempOrd : list){
            System.out.println(tempOrd);
        }
    }
    @Test
    public void findbyid() {
        OrderdetailsPK orderdetailsPK=new OrderdetailsPK();
        orderdetailsPK.setOrderNumber(10100);
        orderdetailsPK.setProductCode("S18_1749");
        System.out.println(dao.findbyid(orderdetailsPK));
    }
    @Test
    public void someColumnTest() {
        List<Object[]> list= dao.someColumn();
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i)[0] + ", " + list.get(i)[1]+ ", " + list.get(i)[2]+ ", " + list.get(i)[3] );
    }
    @Test
    public void whereClauseTest() {
        List<Object[]> list= dao.whereClause(12,15,19,1,2,3);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i)[0] + ", " + list.get(i)[1]+ ", " + list.get(i)[2]+ ", " + list.get(i)[3] );
    }
    @Test
    public void aggregationTest() {
        List<Object[]> list= dao.aggregation();
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i)[0] + ", " + list.get(i)[1]+ ", " + list.get(i)[2]);
    }
    @Test
    public void joinedQueryTest() {
        List<Object[]> list= dao.joinedQuery();
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i)[0]+", "+list.get(i)[1]+", "+list.get(i)[2]+", "+list.get(i)[3]+", "+list.get(i)[4]
                    + ", " + list.get(i)[5]
            );
    }

    @Test
    public void insertTest(){
        Orderdetails od=new Orderdetails();
        od.setOrderNumber(10125);
        od.setProductCode("S24_2887");
        od.setQuantityOrdered(2);
        od.setPriceEach(new BigDecimal("137.01"));
        od.setOrderLineNumber(3);
        dao.insert(od);

        OrderdetailsPK odpk=new OrderdetailsPK();
        odpk.setOrderNumber(od.getOrderNumber());
        odpk.setProductCode(od.getProductCode());
        System.out.println(dao.findbyid(odpk));
    }
    @Test
    public void updateTest(){
        OrderdetailsPK odpk=new OrderdetailsPK();
        odpk.setOrderNumber(10125);
        odpk.setProductCode("S24_2887");
        Orderdetails od=dao.findbyid(odpk);

        od.setQuantityOrdered(5);
        od.setPriceEach(new BigDecimal("120.05"));
        od.setOrderLineNumber(8);
        dao.update(od);
        System.out.println(dao.findbyid(odpk));
    }
    @Test
    public void deleteTest(){
        OrderdetailsPK odpk=new OrderdetailsPK();
        odpk.setOrderNumber(10125);
        odpk.setProductCode("S24_2887");
        Orderdetails od=dao.findbyid(odpk);
        dao.delete(od);
    }
}