package com.afshin.Webservice;

import com.afshin.Dao.PaymentDao;
import com.afshin.Entity.Payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/payment")
public class PaymentWs {
    private PaymentDao dao = new PaymentDao();
    private List<Payment> paymentList = new ArrayList<>();

/*
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hi, REST!";
    }
*/
/*    @GET
    @Path("/home")
    public void index(
            @Context HttpServletRequest request,
            @Context HttpServletResponse response) throws Exception
    {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }*/
    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> findall() {
        paymentList.clear();
        paymentList = dao.findall();
        return paymentList;
    }
}