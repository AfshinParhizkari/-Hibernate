package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2/28/21
 * @Time 3:28 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:Simple JAX-RS CRUD RESTful with Basic Authentication
 */
import com.afshin.Dao.OfficeDao;
import com.afshin.Entity.Office;
import com.afshin.General.Logback;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/office")
public class OfficeRst {
    OfficeDao dao = new OfficeDao();
    Security sec=new Security();
    //  http://localhost:8080/order/rest/office/find/8
    @GET
    @Path("/find/{officeCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("officeCode") String officeCode,@Context HttpHeaders headers){
        //Get encoded username and password
        String encodUsrPwd=headers.getRequestHeader("Authorization").get(0).replaceFirst("Basic ", "");
        if(!sec.basicAuthCheck(encodUsrPwd)) return Response.status(Response.Status.UNAUTHORIZED).entity("User or password is wrong").build();

        try {
            Office office=dao.findbyid(officeCode);
            FilterProvider filters = new SimpleFilterProvider().addFilter("OfficeFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept(office.getfilters()));
            String officeJsoan = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(office);
            Logback.logger.info("{}.{}|Try: Send record to RESTful",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(officeJsoan).build();
        }catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|Exception:UUID-{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/office/all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response all(@Context HttpHeaders headers){
        String encodUsrPwd=headers.getRequestHeader("Authorization").get(0).replaceFirst("Basic ","");
        if(!sec.basicAuthCheck(encodUsrPwd)) return Response.status(Response.Status.UNAUTHORIZED).entity("User or password is wrong").build();

        try{
            List<Office> officeList=dao.findall();
            Office office=new Office();
            FilterProvider filters=new SimpleFilterProvider().addFilter("OfficeFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept(office.getfilters()));
            String officesJsoan=(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(officeList);
            Logback.logger.info("{}.{}|Try: Send all records to RESTful",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(officesJsoan).build();
        }catch (Exception e){
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|Exception:UUID-{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/office/delete/8
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id,@Context HttpHeaders headers) {
        String encodUsrPwd=headers.getRequestHeader("Authorization").get(0).replaceFirst("Basic "," ");
        if(!sec.basicAuthCheck(encodUsrPwd)) return Response.status(Response.Status.UNAUTHORIZED).entity("User or password is wrong").build();

        Integer status = dao.delete(dao.findbyid(id));
        Logback.logger.info("{}.{}|Try: record is Deleted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        return Response.status(Response.Status.OK).entity(status).build();
    }
    //  http://localhost:8080/order/rest/office/insert
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Office office,@Context HttpHeaders headers){
        String encodUsrPwd=headers.getRequestHeader("Authorization").get(0).replaceFirst("Basic "," ");
        if(!sec.basicAuthCheck(encodUsrPwd)) return Response.status(Response.Status.UNAUTHORIZED).entity("User or password is wrong").build();

        String status=dao.insert(office);
        Logback.logger.info("{}.{}|Try: record is Inserted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        return Response.status(Response.Status.OK).entity(status).build();
    }
    //  http://localhost:8080/order/rest/office/update
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Office office,@Context HttpHeaders headers) {
        String encodUsrPwd=headers.getRequestHeader("Authorization").get(0).replaceFirst("Basic "," ");
        if(!sec.basicAuthCheck(encodUsrPwd)) return Response.status(Response.Status.UNAUTHORIZED).entity("User or password is wrong").build();

        String status = dao.update(office);
        Logback.logger.info("{}.{}|Try: record is Updated",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        return Response.status(Response.Status.OK).entity(status).build();
    }
}
/*
    {
            "officeCode": "8",
            "city": "tehran",
            "phone": "+989032430637",
            "addressLine1": "Just come here 1",
            "addressLine2": "und the here 2",
            "state": "Teh",
            "country": "Iran",
            "postalCode": "0123456789",
            "territory": "Persian"
    }
*/
/*
    {
            "officeCode": "8",
            "city": "qazvin",
            "phone": "09032430637",
            "addressLine1": "JNew Just come here 1",
            "addressLine2": "New und the here 2",
            "state": "Qaz",
            "country": "IRR",
            "postalCode": "9876543210",
            "territory": "Fars"
    }
*/