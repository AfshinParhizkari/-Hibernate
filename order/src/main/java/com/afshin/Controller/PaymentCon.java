package com.afshin.Controller;

import com.afshin.Dao.PaymentDao;
import com.afshin.Entity.Payment;
import com.afshin.Entity.Productline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 16
 * @Time 1:10 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
@WebServlet(name = "PaymentAct", urlPatterns = {"/PatmentAct"})
public class PaymentCon extends HttpServlet {
    PaymentDao dao=new PaymentDao();
    List<Payment> paymentList=new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        paymentList.clear();
        String action=req.getParameter("crud");
        if(action.equals("read")) {
            String custnumber = req.getParameter("custnum");
            String checkname = req.getParameter("checknum");
            if (custnumber.isEmpty() || checkname.isEmpty()) paymentList = dao.findall();
            else paymentList.add(dao.findbyid(Integer.parseInt(custnumber),checkname));
        }
        req.setAttribute("payments", paymentList);
        req.getRequestDispatcher("WEB-INF/views/Payment.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        paymentList.clear();
        String action=req.getParameter("crud");
        String custnumber = req.getParameter("custnum");
        String checkname = req.getParameter("checknum");
        if(action.equals("delete")) {
            Payment payment= dao.findbyid(Integer.parseInt(custnumber),checkname);
            dao.delete(payment);
            req.setAttribute("message","record was deleted");
            req.getRequestDispatcher("WEB-INF/views/Payment.jsp").forward(req,resp);
        }

    }
}
