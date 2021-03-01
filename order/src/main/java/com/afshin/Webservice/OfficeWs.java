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
public class OfficeWs {
    OfficeDao dao = new OfficeDao();
    Security sec=new Security();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findall(@Context HttpHeaders headers){
        String encodUsrPwd=headers.getRequestHeader("Authorization").get(0).replaceFirst("Basic "," ");
        if(!sec.basicAuthCheck(encodUsrPwd))
            return Response.status(Response.Status.FORBIDDEN).entity("User or password is wrong").build();
        try{
            List<Office> officeList=dao.findall();
            FilterProvider filters=new SimpleFilterProvider().addFilter("OfficeFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept("officeCode", "city", "phone", "addressLine1", "addressLine2", "state", "country", "postalCode", "territory"));
            String officesJsoan=(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(officeList);
            Logback.logger.info("{}.{}|Try: Send all records to RESTful",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(officesJsoan).build();
        }catch (Exception e){
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/find/{officeCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("officeCode") String officeCode,@Context HttpHeaders headers){
        //Get encoded username and password
        String encodUsrPwd=headers.getRequestHeader("Authorization").get(0).replaceFirst("Basic ", " ");
        if(!sec.basicAuthCheck(encodUsrPwd))
         return Response.status(Response.Status.FORBIDDEN).entity("User or password is wrong").build();
        try {
            Office office=dao.findbyid(officeCode);
            FilterProvider filters = new SimpleFilterProvider().addFilter("OfficeFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept("officeCode", "city", "phone", "addressLine1", "addressLine2", "state", "country", "postalCode", "territory"));
            String officeJsoan = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(office);
            Logback.logger.info("{}.{}|Try: Send record to RESTful",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(officeJsoan).build();
        }catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Office office,@Context HttpHeaders headers){
        String encodUsrPwd=headers.getRequestHeader("Authorization").get(0).replaceFirst("Basic "," ");
        if(!sec.basicAuthCheck(encodUsrPwd))
            return Response.status(Response.Status.FORBIDDEN).entity("User or password is wrong").build();
        String status=dao.insert(office);
        Logback.logger.info("{}.{}|Try: record is Inserted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        return Response.status(Response.Status.OK).entity(status).build();
    }
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(Office office,@Context HttpHeaders headers) {
        String encodUsrPwd=headers.getRequestHeader("Authorization").get(0).replaceFirst("Basic "," ");
        if(!sec.basicAuthCheck(encodUsrPwd))
            return Response.status(Response.Status.FORBIDDEN).entity("User or password is wrong").build();
        Office updatedOffice=dao.findbyid(office.getOfficeCode());
        updatedOffice.setCity(office.getCity());
        updatedOffice.setPhone(office.getPhone());
        updatedOffice.setAddressLine1(office.getAddressLine1());
        updatedOffice.setAddressLine2(office.getAddressLine2());
        updatedOffice.setState(office.getState());
        updatedOffice.setCountry(office.getCountry());
        updatedOffice.setPostalCode(office.getPostalCode());
        updatedOffice.setTerritory(office.getTerritory());
        String status = dao.update(updatedOffice);
        Logback.logger.info("{}.{}|Try: record is Updated",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        return Response.status(Response.Status.OK).entity(status).build();
    }
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteeUser(@PathParam("id") String id,@Context HttpHeaders headers) {
        String encodUsrPwd=headers.getRequestHeader("Authorization").get(0).replaceFirst("Basic "," ");
        if(!sec.basicAuthCheck(encodUsrPwd))
            return Response.status(Response.Status.FORBIDDEN).entity("User or password is wrong").build();
        Integer status = dao.delete(dao.findbyid(id));
        Logback.logger.info("{}.{}|Try: record is Deleted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        return Response.status(Response.Status.OK).entity(status).build();
    }
}