package com.afshin;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 28
 * @Time 5:13 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: Hibernate - Criteria(discontinue)
 */
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OfficeDaoTest {
    OfficeDao dao=new OfficeDao();
    //ExecuteQuery
    @Test
    public void findallTest() {
        List<Office> List =dao.findall();
        for(Office tmp:List)
        {System.out.println(tmp);}
    }
    @Test
    public void findbyidTest() {
        Office tmp =dao.findbyid("6");
        System.out.println(tmp);
    }
    @Test
    public void somecolumnTest() {
        List<Object[]> list = dao.someColumn("USA","44");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0] +", "+ list.get(i)[1]+", "+ list.get(i)[2]+", "+ list.get(i)[3]+", "+ list.get(i)[4]);
        }
    }
    @Test
    public void aggregationTest() {
        List<?> list = dao.aggregation();
        for (int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            System.out.println(row[0] + ", " + row[1]);
        }
    }

    //ExecuteUpdate
    @Test
    public void insertTest(){
        Office o=new Office();
        o.setOfficeCode("8");
        o.setCity("tehran");
        o.setPhone("+989032430637");
        o.setAddressLine1("Just come here 1");
        o.setAddressLine2("und the here 2");
        o.setState("Teh");
        o.setCountry("Iran");
        o.setPostalCode("0123456789");
        o.setTerritory("Persian");
        dao.insert(o);
    }
    @Test
    public void updateTest(){
        Office o=dao.findbyid("8");
        o.setCity("qazvin");
        o.setPhone("09032430637");
        o.setAddressLine1("New Just come here 1");
        o.setAddressLine2("New und the here 2");
        o.setState("Qaz");
        o.setCountry("IRR");
        o.setPostalCode("9876543210");
        o.setTerritory("Fars");
        dao.update(o);
    }
    @Test
    public void deleteTest(){
        Office o=dao.findbyid("8");
        dao.delete(o);
    }
}