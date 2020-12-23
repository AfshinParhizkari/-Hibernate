package com.afshin;

import com.afshin.Dao.UserDao;
import com.afshin.Entity.Order;
import com.afshin.Entity.Orderdetails;
import com.afshin.Entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 23
 * @Time 11:45 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
public class UserDaoTest {
    UserDao dao=new UserDao();
    @Test
    public void findall() {
        List<User> list =dao.findall();
        for (User tempOrd : list){
            System.out.println(tempOrd);
        }
    }
    @Test
    public void findbyid() {
        User user = dao.findbyid(1);
        System.out.println(user);
    }
    @Test
    public void login() {
        User user = dao.login("admin");
        System.out.println(user);
    }

    @Test
    public void insert() {
        User user=new User();
        user.setEmployeeid(3);
        user.setUsername("helman");
        user.setPassword("123");
        user.setEmployeeid(1002);
        dao.insert(user);
    }
    @Test
    public void update() {
        User user= dao.findbyid(3);
        user.setUsername("newuser");
        user.setPassword("456");
        user.setEmployeeid(1002);
        dao.update(user);
    }
    @Test
    public void delete() {
        User user= dao.findbyid(3);
        dao.update(user);
    }
}