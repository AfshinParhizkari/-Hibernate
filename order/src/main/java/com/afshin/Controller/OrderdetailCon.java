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

import com.afshin.Dao.OrderdetailsDao;
import com.afshin.Entity.Orderdetail;
import com.afshin.Entity.OrderdetailPK;
import com.afshin.General.GeneralFunc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderdetailAct", urlPatterns = {"/OrderdetailAct"})
public class OrderdetailCon extends HttpServlet {
    OrderdetailsDao dao = new OrderdetailsDao();
    List<Orderdetail> orderdetailList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
        orderdetailList.clear();
        String ordernumber = req.getParameter("ordnum");
        String productcode = req.getParameter("procode");
        String action = req.getParameter("crud");

        if (action.equals("read")) {
            if (ordernumber.isEmpty() || productcode.isEmpty())  orderdetailList = dao.findall();
            else {
                OrderdetailPK orderdetailPK = new OrderdetailPK();
                orderdetailPK.setOrderNumber(Integer.parseInt(ordernumber));
                orderdetailPK.setProductCode(productcode);
                orderdetailList.add(dao.findbyid(orderdetailPK));
            }
        }
        if (action.equals("add")){
            Orderdetail orderdetail = new Orderdetail();
            orderdetail.setOrderNumber(Integer.parseInt(req.getParameter("ordnum")));
            orderdetail.setProductCode(req.getParameter("procode"));
            orderdetail.setQuantityOrdered(Integer.parseInt(req.getParameter("qord")));
            orderdetail.setPriceEach(new BigDecimal(req.getParameter("pe")));
            orderdetail.setOrderLineNumber(Integer.parseInt(req.getParameter("oln")));
            dao.insert(orderdetail);
            orderdetailList.add(orderdetail);
        }
        if (action.equals("update")){
            OrderdetailPK orderdetailPK = new OrderdetailPK();
            orderdetailPK.setOrderNumber(Integer.parseInt(ordernumber));
            orderdetailPK.setProductCode(productcode);
            Orderdetail orderdetail = dao.findbyid(orderdetailPK);
            orderdetail.setQuantityOrdered(Integer.parseInt(req.getParameter("quanord")));
            orderdetail.setPriceEach(new BigDecimal(req.getParameter("peach")));
            orderdetail.setOrderLineNumber(Integer.parseInt(req.getParameter("ordlnum")));
            dao.update(orderdetail);
            dao.insert(orderdetail);
        }
        req.setAttribute("orderdetails", orderdetailList);
        req.getRequestDispatcher("WEB-INF/views/Orderdetail.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
        orderdetailList.clear();
        String ordernumber = req.getParameter("ordnum");
        String productcode = req.getParameter("procode");
        String action = req.getParameter("crud");

        if (action.equals("delete")){
            OrderdetailPK orderdetailPK = new OrderdetailPK();
            orderdetailPK.setOrderNumber(Integer.parseInt(ordernumber));
            orderdetailPK.setProductCode(productcode);
            Orderdetail orderdetail = dao.findbyid(orderdetailPK);
            dao.delete(orderdetail);
            req.getRequestDispatcher("/Orderdetail.jsp").forward(req, resp);
        }
        if (action.equals("edit")){
            OrderdetailPK orderdetailPK = new OrderdetailPK();
            orderdetailPK.setOrderNumber(Integer.parseInt(ordernumber));
            orderdetailPK.setProductCode(productcode);
            Orderdetail orderdetail = dao.findbyid(orderdetailPK);
            req.setAttribute("orderdetail", orderdetail);
            req.getRequestDispatcher("WEB-INF/views/OrderdetailMerge.jsp").forward(req, resp);
        }
    }
}