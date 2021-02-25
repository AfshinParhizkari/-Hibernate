package com.afshin.Webservice;

import com.afshin.Dao.PaymentDao;
import com.afshin.Entity.Payment;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/payment")
public class PaymentWs {
    private PaymentDao dao = new PaymentDao();
    private List<Payment> paymentList = new ArrayList<>();

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> findall() {
        paymentList.clear();
        paymentList = dao.findall();
        return paymentList;
    }
}