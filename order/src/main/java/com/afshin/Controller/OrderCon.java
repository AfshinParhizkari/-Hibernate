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
import com.afshin.General.GeneralFunc;

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
        if(!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
        orderList.clear();
        String ordernumber = req.getParameter("ordnum");
        String action = req.getParameter("crud");

        if (action.equals("read")) {
            if (ordernumber == null || ordernumber.isEmpty()) orderList = dao.findAll();
            else  orderList.add(dao.findById(Integer.parseInt(ordernumber)));
        }
        if (action.equals("add")){
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
            dao.insert(order);
            orderList.add(order);
        }
        if (action.equals("update")){
            Order order = dao.findById(Integer.parseInt(req.getParameter("ordernum")));
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
            dao.update(order);
            orderList.add(order);
        }
        req.setAttribute("orders", orderList);
        req.getRequestDispatcher("WEB-INF/views/Order.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
        orderList.clear();
        String action = req.getParameter("crud");
        if (action.equals("delete")){
            dao.delete(dao.findById(Integer.parseInt(req.getParameter("onum"))));
            req.getRequestDispatcher("WEB-INF/views/Order.jsp").forward(req, resp);
        }
        if (action.equals("edit")){
            Order order = dao.findById(Integer.parseInt(req.getParameter("onum")));
            req.setAttribute("order",order);
            req.getRequestDispatcher("WEB-INF/views/OrderMerge.jsp").forward(req,resp);
        }
    }
}
