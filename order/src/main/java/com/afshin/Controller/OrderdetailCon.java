package com.afshin.Controller;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 31
 * @Time 6:20 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */

import com.afshin.Dao.*;
import com.afshin.Entity.Order;
import com.afshin.Entity.Orderdetail;
import com.afshin.Entity.OrderdetailPK;
import com.afshin.General.GregorianDate;
import com.afshin.General.Logback;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderdetailAct", urlPatterns = {"/OrderdetailAct"})
public class OrderdetailCon extends HttpServlet {
    OrderdetailsDao dao = new OrderdetailsDao();
    List<Orderdetail> orderdetailList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!SecurityCon.isLogin(req)) {
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                return;
            }
            orderdetailList.clear();
            String ordernumber = req.getParameter("ordnum");
            String productcode = req.getParameter("procode");
            String action = req.getParameter("crud");

            if (action.equals("read")) {
                if (ordernumber.isEmpty() || productcode.isEmpty()) orderdetailList = dao.findall();
                else {
                    OrderdetailPK orderdetailPK = new OrderdetailPK();
                    orderdetailPK.setOrderNumber(Integer.parseInt(ordernumber));
                    orderdetailPK.setProductCode(productcode);
                    orderdetailList.add(dao.findbyid(orderdetailPK));
                }
                if(orderdetailList.isEmpty() || orderdetailList.get(0)==null)
                    req.setAttribute("message", "There is no record");
                else
                    req.setAttribute("message", "record(s) is fetched");
            }
            if (action.equals("add")) {
                Orderdetail orderdetail = new Orderdetail();
                orderdetail.setOrderNumber(Integer.parseInt(req.getParameter("ordnum")));
                orderdetail.setProductCode(req.getParameter("procode"));
                orderdetail.setQuantityOrdered(Integer.parseInt(req.getParameter("qord")));
                orderdetail.setPriceEach(new BigDecimal(req.getParameter("pe")));
                orderdetail.setOrderLineNumber(Integer.parseInt(req.getParameter("oln")));
                OrderdetailPK orderdetailPK = dao.insert(orderdetail);
                if(orderdetailPK!=null) req.setAttribute("message", "record is Added");
                else req.setAttribute("message", "record is not Added");
                orderdetailList.add(dao.findbyid(orderdetailPK));
            }
            if (action.equals("update")) {
                OrderdetailPK orderdetailPK = new OrderdetailPK();
                orderdetailPK.setOrderNumber(Integer.parseInt(ordernumber));
                orderdetailPK.setProductCode(productcode);
                Orderdetail orderdetail = dao.findbyid(orderdetailPK);
                orderdetail.setQuantityOrdered(Integer.parseInt(req.getParameter("quanord")));
                orderdetail.setPriceEach(new BigDecimal(req.getParameter("peach")));
                orderdetail.setOrderLineNumber(Integer.parseInt(req.getParameter("ordlnum")));
                orderdetailPK = dao.update(orderdetail);
                if(orderdetailPK!=null) req.setAttribute("message", "record is Updated");
                else req.setAttribute("message", "record is not Updated");
                orderdetailList.add(dao.findbyid(orderdetailPK));
            }
            req.setAttribute("orderdetails", orderdetailList);
            req.getRequestDispatcher("WEB-INF/views/Orderdetail.jsp").forward(req, resp);
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!SecurityCon.isLogin(req)) {
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                return;
            }
            orderdetailList.clear();
            String ordernumber = req.getParameter("ordnum");
            String productcode = req.getParameter("procode");
            String action = req.getParameter("crud");

            if (action.equals("delete")) {
                OrderdetailPK orderdetailPK = new OrderdetailPK();
                orderdetailPK.setOrderNumber(Integer.parseInt(ordernumber));
                orderdetailPK.setProductCode(productcode);
                Orderdetail orderdetail = dao.findbyid(orderdetailPK);
                Integer status = dao.delete(orderdetail);
                if(status==1) {
                    req.setAttribute("message", "record is deleted");
                    req.getRequestDispatcher("WEB-INF/views/Orderdetail.jsp").forward(req, resp);
                }else{
                    req.setAttribute("message", "record is not deleted");
                    req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
                }
                req.getRequestDispatcher("/Orderdetail.jsp").forward(req, resp);
            }
            if (action.equals("edit")) {
                OrderdetailPK orderdetailPK = new OrderdetailPK();
                orderdetailPK.setOrderNumber(Integer.parseInt(ordernumber));
                orderdetailPK.setProductCode(productcode);
                Orderdetail orderdetail = dao.findbyid(orderdetailPK);
                req.setAttribute("orderdetail", orderdetail);
                req.getRequestDispatcher("WEB-INF/views/OrderdetailMerge.jsp").forward(req, resp);
            }
            if (action.equals("factor")) {
            /*Grandtotal variable properties:
            Calculation: SUM
            Experesion: $V{totalprice}
            Initial value experesion: 0
            Reset type: Group

            Report Properties:
            Float Column footer: True
             */
                String path = req.getSession().getServletContext().getRealPath("/WEB-INF/reports/Factor.jrxml");
                OrderDao orderDao = new OrderDao();
                Order order = orderDao.findById(Integer.parseInt(req.getParameter("ordernum")));
                String orderDate = GregorianDate.shamsiStr(GregorianDate.miladi2shamsi(order.getOrderDate()));
                String customername = order.getCustomer().getCustomerName();
                String employeename = order.getCustomer().getEmployee().getFirstName() + " " + order.getCustomer().getEmployee().getLastName();

                Map<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("ordernumber", order.getOrderNumber());
                parameters.put("CustomerName", customername);
                parameters.put("EmployeeName", employeename);
                parameters.put("OrderDate", orderDate);

                JRsqlFunc.viewReport(path, parameters, "web");
                req.getRequestDispatcher("WEB-INF/views/Order.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
        }
    }
}