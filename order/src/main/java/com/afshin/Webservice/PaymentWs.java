package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/2/21
 * @Time 8:57 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:Simple JAX-RS CRUD RESTful with Token nimbus-jose-jwt Authentication
 */
import com.afshin.Dao.PaymentDao;
import com.afshin.Entity.Payment;
import com.afshin.General.Logback;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/payment")
public class PaymentWs {
    PaymentDao dao = new PaymentDao();
    Security sec=new Security();

    //http://localhost:8080/order/rest/payment/find/103/HQ336336
    @GET
    @Path("/find/{customerNumber}/{checkNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("customerNumber") Integer custNum, @PathParam("checkNumber") String chkNum, @Context HttpHeaders headers) {
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            //PaymentPK paymentPK=new PaymentPK(custNum,chkNum);
            Payment payment = dao.findbyid(custNum, chkNum);
            FilterProvider filters = new SimpleFilterProvider().addFilter("PaymentFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept("customerNumber", "checkNumber", "paymentDate", "amount"));
            String paymentJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(payment);
            Logback.logger.info("{}.{}|Try: Send record to RESTful", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(paymentJson).build();
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

}
