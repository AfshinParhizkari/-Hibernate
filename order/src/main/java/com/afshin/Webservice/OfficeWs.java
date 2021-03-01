package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2/28/21
 * @Time 3:28 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Dao.OfficeDao;
import com.afshin.Entity.Office;
import com.afshin.General.Logback;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/office")
public class OfficeWs {
    OfficeDao dao = new OfficeDao();
    Security sec=new Security();
    @GET
    @Path("/find/{officeCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("officeCode") String officeCode,@Context HttpHeaders headers){
        //Get encoded username and password
        String encodedUserPassword=headers.getRequestHeader("Authorization").get(0).replaceFirst("Basic ", " ");
        if(!sec.basicAuthCheck(encodedUserPassword))
         return Response.status(Response.Status.FORBIDDEN).entity("User or password is wrong").build();
        try {
            Office office=dao.findbyid(officeCode);
            FilterProvider filters = new SimpleFilterProvider().addFilter("officeFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept("officeCode", "city", "phone", "addressLine1", "addressLine2", "state", "country", "postalCode", "territory"));
            String officeJsoan = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(office);
            Logback.logger.info("{}.{}|Try: Send record to RESTful",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(officeJsoan).build();
        }catch (JsonProcessingException e) {
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}