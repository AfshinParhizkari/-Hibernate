package com.afshin;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class GenralDaoTest {


    @Test
    public void findall() {
        EmployeeDao dao=new EmployeeDao();
        List<Employee> List =dao.findall();

        for(Employee tmp:List)
        {
            System.out.println(tmp);
        }
    }


    @Test
    public void findbyid() {
        EmployeeDao dao=new EmployeeDao();
        Employee tmp =dao.findbyid(1143);
        System.out.println(tmp);
    }
    @Test
    public void namedquery() {
        EmployeeDao dao=new EmployeeDao();
        List<Employee> List =dao.besonderquey();

        for(Employee tmp:List)
        {
            System.out.println(tmp);
        }
    }
    @Test
    public void namedgroupby() {
        EmployeeDao dao = new EmployeeDao();
        List<?> list = dao.besonderGroupby();

        for (int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            System.out.println(row[0] + ", " + row[1]);
        }
    }
    @Test
    public void namedSelect() {
        EmployeeDao dao = new EmployeeDao();
        List<?> list = dao.besonderSelect(1143);

        for (int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            System.out.println(row[0] + "-> " + row[1]+" " + row[2]);
        }
    }
}