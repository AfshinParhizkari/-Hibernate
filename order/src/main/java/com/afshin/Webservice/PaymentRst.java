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

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/payment")
public class PaymentRst {
    PaymentDao dao = new PaymentDao();
    Security sec=new Security();

    //  http://localhost:8080/order/rest/payment/find/103/HQ336336
    @GET
    @Path("/find/{customerNumber}/{checkNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("customerNumber") Integer custNum, @PathParam("checkNumber") String chkNum, @Context HttpHeaders headers) {
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            //PaymentPK paymentPK=new PaymentPK(custNum,chkNum);
            Payment payment = dao.findbyid(custNum, chkNum);
            FilterProvider filters = new SimpleFilterProvider().addFilter("PaymentFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept(payment.getfilters()));
            String paymentJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(payment);
            Logback.logger.info("{}.{}|Try: Send record to RESTful", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(paymentJson).build();
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/payment/all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findall(@Context HttpHeaders headers){
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            List<Payment> paymentList=dao.findall();
            FilterProvider filters=new SimpleFilterProvider().addFilter("PaymentFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept("customerNumber", "checkNumber", "paymentDate", "amount"));
            String paymensJson =(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(paymentList);
            Logback.logger.info("{}.{}|Try: Send all records to RESTful",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(paymensJson).build();
        }catch (Exception e){
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/payment/delete/496/FN155234
    @DELETE
    @Path("/delete/{customerNumber}/{checkNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("customerNumber") Integer custNum, @PathParam("checkNumber") String chkNum, @Context HttpHeaders headers){
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
         try {
             Integer returnStatus=dao.delete(dao.findbyid(custNum,chkNum));
             Logback.logger.info("{}.{}|Try: record is Deleted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
             return Response.status(Response.Status.OK).entity(returnStatus).build();
         }catch (Exception e){
             String UUID= java.util.UUID.randomUUID().toString();
             Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
             e.printStackTrace();
             return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
         }
    }
    //  http://localhost:8080/order/rest/payment/insert
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(@Context HttpHeaders headers, Payment payment){
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            Integer returnStatus=dao.insert(payment);
            Logback.logger.info("{}.{}|Try: record is Inserted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(returnStatus).build();
        }catch (Exception e){
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/payment/update
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Context HttpHeaders headers,Payment payment){
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            Integer returnstatus= dao.update(payment);
            Logback.logger.info("{}.{}|Try: record is Updated",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(returnstatus).build();
        }catch (Exception e){
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
}
/*
    {
            "customerNumber": 496,
            "checkNumber": "FN155234",
            "paymentDate": "2020-11-24T23:28:56.782Z",
            "amount": "10000.50"
    }
*/
