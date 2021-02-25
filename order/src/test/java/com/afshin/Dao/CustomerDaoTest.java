package com.afshin.Dao;

import com.afshin.Dao.CustomerDao;
import com.afshin.Entity.Customer;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 30
 * @Time 3:02 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
public class CustomerDaoTest {
    CustomerDao dao=new CustomerDao();
    //ExecuteQuery
    @Test
    public void findallTest() {
        List<Customer> customers=dao.findall();
        for(Customer customer:customers)
            System.out.println(customer);
    }
    @Test
    public void findbyidTest() {
        Customer customer=dao.findbyid(103);
        System.out.println(customer);
    }
    @Test
    public void joinedQueyTest() {
        List<Object[]> objects=dao.joinedQuey();
        for (int i=0;i<objects.size();i++)
            System.out.println("C.Customer: "+objects.get(i)[0]+", Country: "+objects.get(i)[1]+
                    ", O.Customer: "+objects.get(i)[2]+ ", Status: " + objects.get(i)[3]);
    }
    @Test
    public void aggregationTest() {
        List<Object[]> objects=dao.aggregation();
        for (int i=0;i<objects.size();i++)
            System.out.println("Country: "+objects.get(i)[0] + ", Count: " + objects.get(i)[1]+ ", Sum: " + objects.get(i)[2] +
                    ", Avg: " + objects.get(i)[3]+", Min: "+objects.get(i)[4] + ", Max: " + objects.get(i)[5]);
    }
    @Test
    public void parameterizedTest() {
        List<Object[]> objects=dao.parameterized("Atelier graphique");
        for (int i=0;i<objects.size();i++)
            System.out.println("customerNumber: "+objects.get(i)[0] + ", customerName: " + objects.get(i)[1]+
                    ", City: " + objects.get(i)[2]);
    }

    //ExecuteUpdate
    @Test
    public void insertTest(){
        Customer c=new Customer();
        c.setCustomerNumber(497);
        c.setCustomerName("Afshin Parhizkari");
        c.setContactLastName("Kitty");
        c.setContactFirstName("Helman");
        c.setPhone("+989032430637");
        c.setAddressLine1("Iran Tehran 1");
        c.setAddressLine2(" Allay and Paque");
        c.setCity("Tehran");
        c.setState("Th");
        c.setPostalCode("123456789");
        c.setCountry("Iran");
        c.setSalesRepEmployeeNumber(1612);
        c.setCreditLimit(new BigDecimal(150000));
        dao.insert(c);
        System.out.println(dao.findbyid(497));
    }
    @Test
    public void updateTest(){
        Customer c=dao.findbyid(497);
        c.setCustomerName("Helman Kitty");
        c.setContactLastName("Parhizkari");
        c.setContactFirstName("Afshin");
        c.setPhone("+9030000000");
        c.setAddressLine1("Persian Qazvin 1");
        c.setAddressLine2(" Street and Building");
        c.setCity("Qazvin");
        c.setState("Qa");
        c.setPostalCode("987654321");
        c.setCountry("Persian");
        c.setSalesRepEmployeeNumber(1188);
        c.setCreditLimit(new BigDecimal(100000));
        dao.update(c);
        System.out.println(dao.findbyid(497));
    }
    @Test
    public void deleteTest(){
        Customer customer=dao.findbyid(497);
        dao.delete(customer);
    }
}