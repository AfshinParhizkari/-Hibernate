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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employeeList =new ArrayList<>();
        String employeeid= req.getParameter("empNum");
        if(employeeid.isEmpty())
            employeeList=dao.findall();
        else
            employeeList.add(dao.findbyid(Integer.parseInt(employeeid)));
        req.setAttribute("employees",employeeList);
        req.getRequestDispatcher("/Employee.jsp").forward(req,resp);

    }
}
