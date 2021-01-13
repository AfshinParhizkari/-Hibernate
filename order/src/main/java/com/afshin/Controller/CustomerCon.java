package com.afshin.Controller;

import com.afshin.Dao.CustomerDao;
import com.afshin.Entity.Customer;
import com.afshin.General.GeneralFunc;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 31
 * @Time 6:20 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
@WebServlet(name = "CustomerAct", urlPatterns = {"/CustomerAct"})
public class CustomerCon extends HttpServlet {
    CustomerDao dao = new CustomerDao();
    List<Customer> customerList = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customerList.clear();
        String action = req.getParameter("crud");
        if(action.equals("read")) {
            String customerNum = req.getParameter("custnum");
            if (customerNum == null || customerNum.isEmpty()) customerList = dao.findall();
            else     customerList.add(dao.findbyid(Integer.parseInt(customerNum)));
        }
        if (action.equals("add")){
            Customer customer = new Customer();
            customer.setCustomerNumber(Integer.parseInt(req.getParameter("custnum")));
            customer.setCustomerName(req.getParameter("custname"));
            customer.setContactLastName(req.getParameter("conlname"));
            customer.setContactFirstName(req.getParameter("confname"));
            customer.setPhone(req.getParameter("phone"));
            customer.setAddressLine1(req.getParameter("addl1"));
            customer.setAddressLine2(req.getParameter("addl2"));
            customer.setCity(req.getParameter("city"));
            customer.setState(req.getParameter("state"));
            customer.setPostalCode(req.getParameter("poscode"));
            customer.setCountry(req.getParameter("count"));
            customer.setSalesRepEmployeeNumber(Integer.parseInt(req.getParameter("srempnum")));
            customer.setCreditLimit(new BigDecimal(req.getParameter("credlim")));
            dao.insert(customer);
            customerList.add(customer);
        }
        if (action.equals("update")){
            Customer customer = dao.findbyid(Integer.parseInt(req.getParameter("custnum")));
            customer.setCustomerName(req.getParameter("custname"));
            customer.setContactLastName(req.getParameter("conlname"));
            customer.setContactFirstName(req.getParameter("confname"));
            customer.setPhone(req.getParameter("phone"));
            customer.setAddressLine1(req.getParameter("addl1"));
            customer.setAddressLine2(req.getParameter("addl2"));
            customer.setCity(req.getParameter("city"));
            customer.setState(req.getParameter("state"));
            customer.setPostalCode(req.getParameter("poscode"));
            customer.setCountry(req.getParameter("count"));
            customer.setSalesRepEmployeeNumber(Integer.parseInt(req.getParameter("srempnum")));
            customer.setCreditLimit(new BigDecimal(req.getParameter("credlim")));
            dao.update(customer);
            customerList.add(customer);
        }
        req.setAttribute("customers", customerList);
        req.getRequestDispatcher("WEB-INF/views/Customer.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customerList.clear();
        String action = req.getParameter("crud");
        if(action.equals("delete")) {
            dao.delete(dao.findbyid(Integer.parseInt(req.getParameter("custnum"))));
            req.getRequestDispatcher("WEB-INF/views/Customer.jsp").forward(req, resp);

        }
        if (action.equals("edit")) {
            Customer customer = dao.findbyid(Integer.parseInt(req.getParameter("custnum")));
            req.setAttribute("customer", customer);
            req.getRequestDispatcher("WEB-INF/views/CustomerMerge.jsp").forward(req, resp);
        }
        if (action.equals("report")) {
                try {
                    /*Remove all below tags in Reports
                    <fieldDescription><![CDATA[]]></fieldDescription>*/
                    String path="/home/afshin/myprojects/github/afshin/Hibernate/order/src/main/webapp/WEB-INF/reports/Customer.jrxml";
                    //String path="WEB-INF/reports/Customer.jrxml"
                    JasperReport jreport = JasperCompileManager.compileReport(path);
                    // The data source to use to create the report
                    JRBeanCollectionDataSource jcs = new JRBeanCollectionDataSource(dao.findall());
                    JasperPrint jprint = JasperFillManager.fillReport(jreport, null, jcs);
                    // Viewing the report
                    JasperViewer.viewReport(jprint, false);
                    req.getRequestDispatcher("WEB-INF/views/Customer.jsp").forward(req, resp);
                } catch (JRException e) {
                    e.printStackTrace();
                }
        }
    }
}