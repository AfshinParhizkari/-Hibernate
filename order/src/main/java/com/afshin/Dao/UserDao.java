package com.afshin.Dao;

import com.afshin.Entity.*;
import com.afshin.General.Myentitymanager;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 23
 * @Time 11:36 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
public class UserDao {
    public UserDao() {}

    EntityManager entityManager = Myentitymanager.getEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

    public List<User> findall() {
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> u = criteriaQuery.from(User.class);
        criteriaQuery.select(u);
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }
    public User findbyid(Integer userid) {
        return entityManager.find(User.class, userid);
    }
    public User login(String username) {
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> u = criteriaQuery.from(User.class);
        criteriaQuery.select(u).where(criteriaBuilder.equal(u.get("username"),username));
        Query q = entityManager.createQuery(criteriaQuery);
        return (User) q.getResultList().get(1);
    }

    //ExecuteUpdate
    public void insert(User user){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }
    public void update(User user){
        try {
            entityManager.getTransaction().begin();
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
            user.setEmployeeid(user.getEmployeeid());
            entityManager.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }
    public void delete(User user){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }

}
