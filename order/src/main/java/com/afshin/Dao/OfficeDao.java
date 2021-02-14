package com.afshin.Dao;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: Hibernate - Criteria(discontinue)
 */
import com.afshin.Entity.Office;
import com.afshin.General.Logback;
import com.afshin.General.Mysession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;
import org.hibernate.criterion.Order;
import java.util.ArrayList;
import java.util.List;

public class OfficeDao {
    Session neshast= Mysession.getsession();
    //ExecuteQuery
    public List<Office> findall(){
        List<Office> offices=new ArrayList<>();
        try {
            Criteria criteria=neshast.createCriteria(Office.class,"o");
            criteria.addOrder(Order.desc("officeCode"));
            Logback.logger.info("{}.{}|Try: All are Fetched",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return criteria.list();
        }catch (Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }

    }
    public Office findbyid(String inputValue){
        try {
            Criteria criteria=neshast.createCriteria(Office.class,"o");
            criteria.add(Restrictions.eq("officeCode",inputValue));
            Office office=(Office) criteria.uniqueResult();
            Logback.logger.info("{}.{}|Try: Id {} is Fetched",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),office.getOfficeCode());
            return office;
        }catch (Exception e){
            Logback.logger.error("{}.{}|Exception: {}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public List<Object[]> someColumn(String countryName,String mobile){
        Criteria criteria=neshast.createCriteria(Office.class,"o");
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("officeCode"),"Officecode")
                .add(Projections.property("country"))
                .add(Projections.property("state"))
                .add(Projections.property("city"))
                .add(Projections.property("phone"))
        );
        Criterion countryeq =Restrictions.eq("country",countryName);
        Criterion mobilelike=Restrictions.like("phone",mobile,MatchMode.ANYWHERE);
        LogicalExpression orExp=Restrictions.or(countryeq,mobilelike);
        criteria.add(orExp);
        return criteria.list();

    }
    public List<?> aggregation(){
        Criteria criteria=neshast.createCriteria(Office.class,"o");
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.groupProperty("country"));
        projList.add(Projections.count("country"));
        criteria.setProjection(projList);
        return criteria.list();
    }

    //ExecuteUpdate
    public void insert(Office office){
        try{
            Transaction tx=neshast.beginTransaction();
            neshast.persist(office);
            tx.commit();
            Logback.logger.info("{}.{}|Try: Inserted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        }catch(Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
        }
    }
    public void update(Office office){
        try{
            Transaction tx=neshast.beginTransaction();
            neshast.merge(office);
            tx.commit();
            Logback.logger.info("{}.{}|Try: Updated",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        }catch(Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
        }
    }
    public void delete(Office office){
        try{
            Transaction tx=neshast.beginTransaction();
            neshast.delete(office);
            tx.commit();
            Logback.logger.info("{}.{}|Try: Deleted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        }catch(Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
        }
    }
}