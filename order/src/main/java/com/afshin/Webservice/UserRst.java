package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2021 - 02 -26
 * @Time 3:14 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: Simple JAX-RS CRUD RESTful without Authentication
 */
import com.afshin.Dao.UserDao;
import com.afshin.Entity.User;
import com.afshin.General.Logback;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UserRst {
    private UserDao dao = new UserDao();

    //http://localhost:8080/order/rest/user/find/3
    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") Integer id) {
        try {
            //return user;
            User user = dao.findbyid(id);
            //filter attribute to create JSON
            FilterProvider filters = new SimpleFilterProvider().addFilter(
                    "UserFilter", SimpleBeanPropertyFilter.filterOutAllExcept(user.getfilters()));
            // Map Object -> String
            String userJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(user);
            // http response to program that call me
            Logback.logger.info("{}.{}|Try: Send record to RESTful", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(userJson).build();
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    //http://localhost:8080/order/rest/user/all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {
        try {
            List<User> userList = dao.findall();
            User user = new User();
            FilterProvider filters = new SimpleFilterProvider().addFilter(
                    "UserFilter", SimpleBeanPropertyFilter.filterOutAllExcept(user.getfilters()));
            String usersJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(userList);
            Logback.logger.info("{}.{}|Try: Send all records to RESTful", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(usersJson).build();
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    //Method:DELETE http://localhost:8080/order/rest/user/4
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {
        Integer status = dao.delete(dao.findbyid(id));
        Logback.logger.info("{}.{}|Try: record is Deleted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return Response.status(Response.Status.OK).entity(status).build();
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
    public Response insert(User user) {
        Integer status = dao.insert(user);
        Logback.logger.info("{}.{}|Try: record is Inserted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return Response.status(Response.Status.OK).entity(status).build();
    }

    //Method:PUT http://localhost:8080/order/rest/user/update
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(User user) {
        Integer status = dao.update(user);
        Logback.logger.info("{}.{}|Try: record is Updated", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return Response.status(Response.Status.OK).entity(status).build();
    }
}