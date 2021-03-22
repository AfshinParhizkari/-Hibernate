package com.afshin.Controller;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 16
 * @Time 1:10 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Dao.JRsqlFunc;
import com.afshin.Dao.PaymentDao;
import com.afshin.Entity.Payment;
import com.afshin.General.Logback;
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

@WebServlet(name = "PaymentAct", urlPatterns = {"/api/PaymentAct"})
public class PaymentCon extends HttpServlet {
    PaymentDao dao = new PaymentDao();
    List<Payment> paymentList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!SecurityAPI.isLogin(req)) {req.getRequestDispatcher("/index.jsp").forward(req, resp); return;}
            paymentList.clear();
            String action = req.getParameter("crud");
            if (action.equals("read")) {
                String custnumber = req.getParameter("custnum");
                String checkname = req.getParameter("checknum");
                if (custnumber.isEmpty() || checkname.isEmpty()) paymentList = dao.findall();
                else paymentList.add(dao.findbyid(Integer.parseInt(custnumber), checkname));
                if(paymentList.isEmpty() || paymentList.get(0)==null)
                    req.setAttribute("message", "There is no record");
                else
                    req.setAttribute("message", "record(s) is fetched");
            }
            if (action.equals("add")) {
                Payment payment = new Payment();
                payment.setCustomerNumber(Integer.parseInt(req.getParameter("custNum")));
                payment.setCheckNumber(req.getParameter("checkNum"));
                payment.setAmount(new BigDecimal(req.getParameter("turnOver")));
                String shamsidate = req.getParameter("payDate");
                payment.setPaymentDate(GregorianDate.picker2miladi(shamsidate));
                Integer status=dao.insert(payment);
                if(status>0) req.setAttribute("message", "record is Added");
                else req.setAttribute("message", "record is not Added");
                paymentList.add(dao.findbyid(payment.getCustomerNumber(),payment.getCheckNumber()));
            }
            if (action.equals("update")) {
                String custnumber = req.getParameter("custNum");
                String checkname = req.getParameter("checkNum");
                Payment payment = dao.findbyid(Integer.parseInt(custnumber), checkname);
                payment.setAmount(new BigDecimal(req.getParameter("turnOver")));
                String shamsidate = req.getParameter("payDate");
                payment.setPaymentDate(GregorianDate.picker2miladi(shamsidate));
                Integer status=dao.update(payment);
                if(status>0) req.setAttribute("message", "record is Updated");
                else req.setAttribute("message", "record is not Updated");
                paymentList.add(dao.findbyid(payment.getCustomerNumber(),payment.getCheckNumber()));
            }
            req.setAttribute("payments", paymentList);
            req.getRequestDispatcher("/WEB-INF/views/Payment.jsp").forward(req, resp);
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            req.setAttribute("ErrorKey", UUID);
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (!SecurityAPI.isLogin(req)) {req.getRequestDispatcher("/index.jsp").forward(req, resp); return;}
            paymentList.clear();
            String action = req.getParameter("crud");
            String custnumber = req.getParameter("custnum");
            String checknumber = req.getParameter("checknum");
            if (action.equals("delete")) {
                Payment payment = dao.findbyid(Integer.parseInt(custnumber), checknumber);
                Integer status = dao.delete(payment);
                if(status==1) {
                    req.setAttribute("message", "record is deleted");
                    req.getRequestDispatcher("WEB-INF/views/Payment.jsp").forward(req, resp);
                }else{
                    req.setAttribute("message", "record is not deleted");
                    req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
                }
            }
            if (action.equals("edit")) {
                Payment payment = dao.findbyid(Integer.parseInt(custnumber), checknumber);
                req.setAttribute("payment", payment);
                req.getRequestDispatcher("/WEB-INF/views/PaymentMerge.jsp").forward(req, resp);
            }
            if (action.equals("report")) {
                String path = req.getSession().getServletContext().getRealPath("/WEB-INF/reports/Payment.jrxml");
                Map<String, Object> parameters = new HashMap<String, Object>();
                try {
                    parameters.put("Fdate", new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fdate")));
                    parameters.put("Tdate", new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("tdate")));
                } catch (ParseException e) {
                    String UUID= java.util.UUID.randomUUID().toString();
                    Logback.logger.error("{}.{}|Exception:UUID-{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
                    e.printStackTrace();
                    req.setAttribute("ErrorKey", UUID);
                    req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
                }
                JRsqlFunc.viewReport(path, parameters, req.getParameter("exporttype"));
                req.getRequestDispatcher("/WEB-INF/views/PaymentRep.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            req.setAttribute("ErrorKey", UUID);
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
        }
    }
}
