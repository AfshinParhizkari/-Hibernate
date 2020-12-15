package com.afshin.Controller;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 05
 * @Time 1:10 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Dao.EmployeeDao;
import com.afshin.Entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeAct",urlPatterns = {"/EmployeeAct"})
public class EmployeeCon extends HttpServlet {
    EmployeeDao dao =new EmployeeDao();
    List<Employee> employeeList =new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        employeeList.clear();
        String action=req.getParameter("crud");
        if(action.equals("read")){
            String employeeid= req.getParameter("empNum");
            if(employeeid.isEmpty()) employeeList=dao.findall();
            else employeeList.add(dao.findbyid(Integer.parseInt(employeeid)));
            req.setAttribute("employees",employeeList);
        }
        if(action.equals("add")) {
            Employee employee=new Employee();
            employee.setEmployeeNumber(Integer.parseInt(req.getParameter("empnum")));
            employee.setLastName(req.getParameter("lname"));
            employee.setFirstName(req.getParameter("fname"));
            employee.setExtension(req.getParameter("exten"));
            employee.setEmail(req.getParameter("email"));
            employee.setOfficeCode(req.getParameter("offcode"));
            employee.setReportsTo(Integer.parseInt(req.getParameter("repto")));
            employee.setJobTitle(req.getParameter("jobtit"));
            dao.insert(employee);
            employeeList.add(employee);
            req.setAttribute("employees", employeeList);
        }
        if(action.equals("update")) {
            Employee employee=new Employee();
            employee.setEmployeeNumber(Integer.parseInt(req.getParameter("empnum")));
            employee.setLastName(req.getParameter("lname"));
            employee.setFirstName(req.getParameter("fname"));
            employee.setExtension(req.getParameter("exten"));
            employee.setEmail(req.getParameter("email"));
            employee.setOfficeCode(req.getParameter("offcode"));
            employee.setReportsTo(Integer.parseInt(req.getParameter("repto")));
            employee.setJobTitle(req.getParameter("jobtit"));
            dao.update(employee);
            employeeList.add(employee);
            req.setAttribute("employees", employeeList);
        }
        req.getRequestDispatcher("WEB-INF/views/Employee.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        employeeList.clear();
        String action=req.getParameter("crud");
        if(action.equals("delete")) {
            Employee employee= dao.findbyid(Integer.parseInt(req.getParameter("employeenum")));
            dao.delete(employee);
            req.setAttribute("message","record is deleted");
            req.getRequestDispatcher("WEB-INF/views/Employee.jsp").forward(req,resp);
        }
        if(action.equals("edit")) {
            Employee employee= dao.findbyid(Integer.parseInt(req.getParameter("employeenum")));
            req.setAttribute("employee",employee);
            req.getRequestDispatcher("WEB-INF/views/EmployeeMerge.jsp").forward(req,resp);

        }
        if(action.equals("mngof")) {
            employeeList= dao.parameterized(Integer.parseInt(req.getParameter("manageof")));
            req.setAttribute("employees", employeeList);
            req.getRequestDispatcher("WEB-INF/views/Employee.jsp").forward(req,resp);
        }
        if(action.equals("mngby")) {
            Employee employee= dao.findbyid(Integer.parseInt(req.getParameter("manageby")));
            employeeList.add(employee);
            req.setAttribute("employees", employeeList);
            req.getRequestDispatcher("WEB-INF/views/Employee.jsp").forward(req,resp);
        }
    }
}
