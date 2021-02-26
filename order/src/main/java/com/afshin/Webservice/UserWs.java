package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2/26/21
 * @Time 3:14 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Dao.UserDao;
import com.afshin.Entity.User;
import com.afshin.General.Logback;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/user")
public class UserWs {

    private UserDao dao = new UserDao();
    private List<User> userList = new ArrayList<>();
    //http://localhost:8080/order/rest/user/all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findall() {
        userList.clear();
        userList = dao.findall();
        try {
            FilterProvider filters = new SimpleFilterProvider().addFilter(
                    "Userfilter", SimpleBeanPropertyFilter.filterOutAllExcept("idusers","username","password","employeeid"));
            String userJson=(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(userList);
            Logback.logger.info("{}.{}|Try: Send all records to RESTful",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(userJson).build();
        } catch (JsonProcessingException e) {
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).entity("").build();
        }
    }
    //http://localhost:8080/order/rest/user/find/3
    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Integer id) {
        User user=dao.findbyid(id);
        //return user;
        try {
            //filter attribute to create JSON
            FilterProvider filters = new SimpleFilterProvider().addFilter(
                    "Userfilter", SimpleBeanPropertyFilter.filterOutAllExcept("idusers","username","password","employeeid"));
            // Map Object -> String
            String userJson=(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(user);
            // http response to program that call me
            Logback.logger.info("{}.{}|Try: Send record to RESTful",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(userJson).build();
        } catch (JsonProcessingException e) {
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).entity("").build();
        }
    }
    //http://localhost:8080/order/rest/user/get/3
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetById(@PathParam("id") Integer id) {
        User user = dao.findbyid(id);
        //return user;
        Logback.logger.info("{}.{}|Try: Send record to RESTful",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        return ToStringBuilder.reflectionToString(user, ToStringStyle.JSON_STYLE);
    }
    /* Method:POST http://localhost:8080/order/rest/user/insert
       Content-Type:application/json
       Body:
            {
            "idusers": 4,
            "username": "helman_4",
            "password": "456",
            "employeeid": 1056
             }
    */
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer insert(User user) {
        Integer status = dao.insert(user);
        Logback.logger.info("{}.{}|Try: record is Inserted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        return status;
    }
    //Method:PUT http://localhost:8080/order/rest/user/update
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer updateUser(User user) {
        User updatedUser=dao.findbyid(user.getIdusers());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setEmployeeid(user.getEmployeeid());
        Integer status=dao.update(updatedUser);
        Logback.logger.info("{}.{}|Try: record is Updated",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        return status;
    }
    //Method:DELETE http://localhost:8080/order/rest/user/4
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer deleteeUser(@PathParam("id") Integer id) {
        Integer status = dao.delete(dao.findbyid(id));
        Logback.logger.info("{}.{}|Try: record is Deleted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
        return status;
    }
}