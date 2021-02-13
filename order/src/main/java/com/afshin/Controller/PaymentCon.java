package com.afshin.Controller;

import com.afshin.Dao.JRsqlFunc;
import com.afshin.Dao.PaymentDao;
import com.afshin.Entity.Payment;
import com.afshin.General.GeneralFunc;
import com.afshin.General.GregorianDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 16
 * @Time 1:10 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
@WebServlet(name = "PaymentAct", urlPatterns = {"/PaymentAct"})
public class PaymentCon extends HttpServlet {
    PaymentDao dao = new PaymentDao();
    List<Payment> paymentList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
            paymentList.clear();
            String action = req.getParameter("crud");
            if (action.equals("read")) {
                String custnumber = req.getParameter("custnum");
                String checkname = req.getParameter("checknum");
                if (custnumber.isEmpty() || checkname.isEmpty()) paymentList = dao.findall();
                else paymentList.add(dao.findbyid(Integer.parseInt(custnumber), checkname));
            }
            if (action.equals("add")) {
                Payment payment = new Payment();
                payment.setCustomerNumber(Integer.parseInt(req.getParameter("custNum")));
                payment.setCheckNumber(req.getParameter("checkNum"));
                payment.setAmount(new BigDecimal(req.getParameter("turnOver")));
                String shamsidate = req.getParameter("payDate");
                payment.setPaymentDate(GregorianDate.picker2miladi(shamsidate));
                dao.insert(payment);
                paymentList.add(payment);
            }
            if (action.equals("update")) {
                String custnumber = req.getParameter("custNum");
                String checkname = req.getParameter("checkNum");
                Payment payment = dao.findbyid(Integer.parseInt(custnumber), checkname);
                payment.setAmount(new BigDecimal(req.getParameter("turnOver")));
                String shamsidate = req.getParameter("payDate");
                payment.setPaymentDate(GregorianDate.picker2miladi(shamsidate));
                dao.update(payment);
                paymentList.add(payment);
            }
            req.setAttribute("payments", paymentList);
            req.getRequestDispatcher("WEB-INF/views/Payment.jsp").forward(req, resp);
        } catch (Exception e) {
            GeneralFunc.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!GeneralFunc.login(req)) req.getRequestDispatcher("index.jsp").forward(req, resp);
            paymentList.clear();
            String action = req.getParameter("crud");
            String custnumber = req.getParameter("custnum");
            String checknumber = req.getParameter("checknum");
            if (action.equals("delete")) {
                Payment payment = dao.findbyid(Integer.parseInt(custnumber), checknumber);
                dao.delete(payment);
                req.setAttribute("message", "record was deleted");
                req.getRequestDispatcher("WEB-INF/views/Payment.jsp").forward(req, resp);
            }
            if (action.equals("edit")) {
                Payment payment = dao.findbyid(Integer.parseInt(custnumber), checknumber);
                req.setAttribute("payment", payment);
                req.getRequestDispatcher("WEB-INF/views/PaymentMerge.jsp").forward(req, resp);
            }
            if (action.equals("report")) {
                String path = req.getSession().getServletContext().getRealPath("/WEB-INF/reports/Payment.jrxml");
                Map<String, Object> parameters = new HashMap<String, Object>();
                try {
                    parameters.put("Fdate", new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fdate")));
                    parameters.put("Tdate", new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("tdate")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                JRsqlFunc.viewReport(path, parameters, req.getParameter("exporttype"));
                req.getRequestDispatcher("WEB-INF/views/PaymentRep.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            GeneralFunc.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
        }
    }
}
