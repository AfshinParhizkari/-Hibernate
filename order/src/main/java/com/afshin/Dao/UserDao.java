package com.afshin.Dao;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 23
 * @Time 11:36 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Entity.*;
import com.afshin.General.Logback;
import com.afshin.General.Myentitymanager;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class UserDao {
    public UserDao() {}

    EntityManager entityManager = Myentitymanager.getEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

    public List<User> findall() {
        try {
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> u = criteriaQuery.from(User.class);
            criteriaQuery.select(u);
            Query q = entityManager.createQuery(criteriaQuery);
            List<User> users=q.getResultList();
            Logback.logger.info("{}.{}|Try: All are Fetched",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return users;
        }catch (Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public User findbyid(Integer userid) {
        try {
            User user=entityManager.find(User.class, userid);
            Logback.logger.info("{}.{}|Try: record is Fetched",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return user;
        }catch (Exception e){
            Logback.logger.error("{}.{}|Exception: {}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }    }
    public User login(String userName) {
        try {
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> u = criteriaQuery.from(User.class);
            criteriaQuery.select(u);
            criteriaQuery.where(criteriaBuilder.equal(u.get("username"),userName));
            Query q = entityManager.createQuery(criteriaQuery);
            List<User> users = q.getResultList();
            if(users ==null || users.size()==0) return null;
            else {
                User user = users.get(0);
                Logback.logger.info("{}.{}|Try: record is Fetched", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
                return user;
            }
        }catch (Exception e){
            Logback.logger.error("{}.{}|Exception: {}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //ExecuteUpdate
    public Integer insert(User user){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            Logback.logger.info("{}.{}|Try: Inserted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return user.getIdusers();
        }catch(Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
    public Integer update(User user){
        try {
            entityManager.getTransaction().begin();
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
            user.setEmployeeid(user.getEmployeeid());
            entityManager.getTransaction().commit();
            Logback.logger.info("{}.{}|Try: Updated",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return user.getIdusers();
        }catch(Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
    public Integer delete(User user){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
            Logback.logger.info("{}.{}|Try: Deleted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return 1;
        }catch(Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
}
