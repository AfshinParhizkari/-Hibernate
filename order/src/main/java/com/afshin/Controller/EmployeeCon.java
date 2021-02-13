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
import com.afshin.General.GeneralFunc;
import com.afshin.Dao.JRsqlFunc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeAct",urlPatterns = {"/EmployeeAct"})
public class EmployeeCon extends HttpServlet {
    EmployeeDao dao =new EmployeeDao();
    List<Employee> employeeList =new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      try {
          if (!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
          employeeList.clear();
          String action = req.getParameter("crud");
          if (action.equals("read")) {
              GeneralFunc.logger.trace("{}.{}|read: Enter to IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
              String employeeid = req.getParameter("empNum");
              if (employeeid.isEmpty()) employeeList = dao.findall();
              else employeeList.add(dao.findbyid(Integer.parseInt(employeeid)));
              req.setAttribute("employees", employeeList);
              GeneralFunc.logger.trace("{}.{}|read: Exit from IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
          }
          if (action.equals("add")) {
              GeneralFunc.logger.trace("{}.{}|add: Enter to IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
              Employee employee = new Employee();
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
              GeneralFunc.logger.trace("{}.{}|read: Exit from IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());

          }
          if (action.equals("update")) {
              GeneralFunc.logger.trace("{}.{}|update: Enter to IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
              Employee employee = new Employee();
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
              GeneralFunc.logger.trace("{}.{}|update: Exit to IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
          }
          req.getRequestDispatcher("WEB-INF/views/Employee.jsp").forward(req, resp);
      }catch (Exception e){
          GeneralFunc.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
          e.printStackTrace();
      }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
            employeeList.clear();
            String action = req.getParameter("crud");
            if (action.equals("delete")) {
                GeneralFunc.logger.trace("{}.{}|delete: Enter to IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
                Employee employee = dao.findbyid(Integer.parseInt(req.getParameter("employeenum")));
                dao.delete(employee);
                req.setAttribute("message", "record is deleted");
                GeneralFunc.logger.trace("{}.{}|delete: Exit from IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
                req.getRequestDispatcher("WEB-INF/views/Employee.jsp").forward(req, resp);
            }
            if (action.equals("edit")) {
                GeneralFunc.logger.trace("{}.{}|edit: Enter to IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
                Employee employee = dao.findbyid(Integer.parseInt(req.getParameter("employeenum")));
                req.setAttribute("employee", employee);
                GeneralFunc.logger.trace("{}.{}|edit: Exit from IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
                req.getRequestDispatcher("WEB-INF/views/EmployeeMerge.jsp").forward(req, resp);

            }
            if (action.equals("mngof")) {
                GeneralFunc.logger.trace("{}.{}|manageFrom: Enter to IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
                employeeList = dao.parameterized(Integer.parseInt(req.getParameter("manageof")));
                req.setAttribute("employees", employeeList);
                GeneralFunc.logger.trace("{}.{}|manageFrom: Exit from IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
                req.getRequestDispatcher("WEB-INF/views/Employee.jsp").forward(req, resp);
            }
            if (action.equals("mngby")) {
                GeneralFunc.logger.trace("{}.{}|manageBy: Enter to IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
                Employee employee = dao.findbyid(Integer.parseInt(req.getParameter("manageby")));
                employeeList.add(employee);
                req.setAttribute("employees", employeeList);
                GeneralFunc.logger.trace("{}.{}|manageBy: Exit from IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
                req.getRequestDispatcher("WEB-INF/views/Employee.jsp").forward(req, resp);
            }
            if (action.equals("report")) {
                GeneralFunc.logger.trace("{}.{}|report: Enter to IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
                String path = req.getSession().getServletContext().getRealPath("/WEB-INF/reports/Employee.jrxml");
                Map<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("emp_num", Integer.parseInt(req.getParameter("empNum")));
                JRsqlFunc.viewReport(path, parameters, "web");
                GeneralFunc.logger.trace("{}.{}|report: Exit from IF!",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
                req.getRequestDispatcher("WEB-INF/views/Employee.jsp").forward(req, resp);
            }
        }catch (Exception e){
            GeneralFunc.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
        }
    }
}