package com.afshin.Dao;

import com.afshin.Entity.Order;
import com.afshin.General.GregorianDate;
import org.junit.Test;

import java.util.List;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 03
 * @Time 6:59 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
public class OrderDaoTest {
    OrderDao dao=new OrderDao();
    //ExecuteQuery
    @Test
    public void findAllTest() {
        List<Order> list =dao.findAll();
        for (Order tempOrd : list){
            System.out.println(tempOrd);
        }
    }
    @Test
    public void findByIdTest() {
        Order order = dao.findById(10426);
        System.out.println(order);
    }
    @Test
    public void someColumn() {
        List<?> list = dao.someColumn();
        for (int i=0; i<list.size(); i++){
            Object[] row = (Object[]) list.get(i);
            System.out.println(row[0]+","+row[1]+","+row[2]);
        }
    }
    @Test
    public void whereClause() {
        List<Order> list = dao.whereClause("Cancelled");
        for (Order temo : list){
            System.out.println(temo);
        }
    }
    @Test
    public void aggregation() {
        List<?> list = dao.aggregation();
        for (int i=0; i<list.size(); i++){
            Object[] row = (Object[]) list.get(i);
            System.out.println(row[0]+","+row[1]+","+row[2]);
        }
    }
    @Test
    public void joinedQuery() {
        List<?> list = dao.joinedQuery();
        for (int i =0; i<list.size(); i++){
            Object[] row = (Object[]) list.get(i);
            System.out.println(row[0]+","+row[1]+","+row[2]);
        }
    }
    //Execute update
    @Test
    public void insert() {
        Order order = new Order();
        order.setOrderNumber(10426);
        order.setOrderDate(GregorianDate.shamsi2miladi(1399,9-1,13));
        order.setRequiredDate(GregorianDate.shamsi2miladi(1384,1-1,2));
        order.setShippedDate(GregorianDate.shamsi2miladi(1399,12-1,23));
        order.setStatus("Cancelled");
        order.setComments("We must pay it soon");
        order.setCustomerNumber(481);
        dao.insert(order);
    }
    @Test
    public void update() {
        Order order = dao.findById(10426);
        order.setOrderDate(GregorianDate.shamsi2miladi(1397,9-1,11));
        order.setRequiredDate(GregorianDate.shamsi2miladi(1398,8-1,2));
        order.setShippedDate(GregorianDate.shamsi2miladi(1398,7-1,24));
        order.setStatus("Shipped");
        order.setComments("We can't pay it soon");
        order.setCustomerNumber(496);
        dao.update(order);
    }
    @Test
    public void delete() {
        Order order = dao.findById(10426);
        dao.delete(order);

    }
}