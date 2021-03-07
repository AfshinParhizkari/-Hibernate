package com.afshin.Controller;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 31
 * @Time 6:19 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Dao.OrderDao;
import com.afshin.Entity.Order;
import com.afshin.General.Logback;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderAct", urlPatterns = {"/OrderAct"})
public class OrderCon extends HttpServlet {
    OrderDao dao = new OrderDao();
    List<Order> orderList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!SecurityAPI.isLogin(req)) {req.getRequestDispatcher("index.jsp").forward(req, resp); return;}
            orderList.clear();
            String action = req.getParameter("crud");
            String ordernumber = req.getParameter("ordnum");
            if (action.equals("read")) {
                if (ordernumber == null || ordernumber.isEmpty()) orderList = dao.findAll();
                else orderList.add(dao.findById(Integer.parseInt(ordernumber)));
                if(orderList.isEmpty() || orderList.get(0)==null)
                    req.setAttribute("message", "There is no record");
                else
                    req.setAttribute("message", "record(s) is fetched");
            }
            if (action.equals("add")) {
                Order order = new Order();
                order.setOrderNumber(Integer.parseInt(req.getParameter("onum")));
                try {
                    order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("odate")));
                    order.setRequiredDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("rdate")));
                    order.setShippedDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("sdate")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                order.setStatus(req.getParameter("status"));
                order.setComments(req.getParameter("com"));
                order.setCustomerNumber(Integer.parseInt(req.getParameter("custnum")));
                Integer status = dao.insert(order);
                if(status==order.getOrderNumber()) req.setAttribute("message", "record is Added");
                else req.setAttribute("message", "record is not Added");
                orderList.add(dao.findById(status));
            }
            if (action.equals("update")) {
                Order order = new Order();
                order.setOrderNumber(Integer.parseInt(req.getParameter("ordernum")));
                try {
                    order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("odate")));
                    order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("rdate")));
                    order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("sdate")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                order.setStatus(req.getParameter("status"));
                order.setComments(req.getParameter("com"));
                order.setCustomerNumber(Integer.parseInt(req.getParameter("cusnum")));
                Integer status = dao.update(order);
                if(status==order.getOrderNumber()) req.setAttribute("message", "record is Updated");
                else req.setAttribute("message", "record is not Updated");
                orderList.add(dao.findById(status));
            }
            req.setAttribute("orders", orderList);
            req.getRequestDispatcher("WEB-INF/views/Order.jsp").forward(req, resp);
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!SecurityAPI.isLogin(req)) {
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                return;
            }
            orderList.clear();
            String action = req.getParameter("crud");
            if (action.equals("delete")) {
                Integer status = dao.delete(dao.findById(Integer.parseInt(req.getParameter("onum"))));
                if(status==1) {
                    req.setAttribute("message", "record is deleted");
                    req.getRequestDispatcher("WEB-INF/views/Order.jsp").forward(req, resp);
                }else{
                    req.setAttribute("message", "record is not deleted");
                    req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
                }
            }
            if (action.equals("edit")) {
                Order order = dao.findById(Integer.parseInt(req.getParameter("onum")));
                req.setAttribute("order", order);
                req.getRequestDispatcher("WEB-INF/views/OrderMerge.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            req.getRequestDispatcher("WEB-INF/views/error.jsp").forward(req, resp);
        }
    }
}
