package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/23/21
 * @Time 8:54 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:  http://localhost:8080/order/rest/employee/
 */
import com.afshin.Dao.EmployeeDao;
import com.afshin.Entity.Employee;
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


@Path("/employee")
public class EmployeeRst {
    EmployeeDao dao=new EmployeeDao();
    Security sec=new Security();
    // http://localhost:8080/order/rest/employee/find/1703
    @GET
    @Path("/find/{employeeNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("employeeNumber") Integer empNum, @Context HttpHeaders headers) {
        String token = headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if (!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            Employee employee = dao.findbyid(empNum);
            FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept(employee.getfilters()));
            String employeeJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(employee);
            Logback.logger.info("{}.{}|Try: Send record to RESTful", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(employeeJson).build();
        } catch (Exception e) {
            String UUID = java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), UUID, e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is" + UUID + e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/employee/all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findall(@Context HttpHeaders headers){
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            List<Employee> employeeList=dao.findall();
            Employee employee=new Employee();
            FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept(employee.getfilters()));
            String employeesJson =(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(employeeList);
            Logback.logger.info("{}.{}|Try: Send all records to RESTful",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(employeesJson).build();
        }catch (Exception e){
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/employee/delete/1705
    @DELETE
    @Path("/delete/{employeeNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("employeeNumber") Integer empNum, @Context HttpHeaders headers) {
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            Integer returnStatus=dao.delete(dao.findbyid(empNum));
            Logback.logger.info("{}.{}|Try: record is Deleted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(returnStatus).build();
        }catch (Exception e){
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/employee/insert
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(@Context HttpHeaders headers, Employee employee){
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            Integer returnStatus=dao.insert(employee);
            Logback.logger.info("{}.{}|Try: record is Inserted",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(returnStatus).build();
        }catch (Exception e){
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
/*
    {
            "employeeNumber": 1705,
            "lastName": "Parhizkari",
            "firstName": "Afshin",
            "extension": "x2542",
            "email": "Afshin.Parhizkari@gmail.com",
            "officeCode": "1",
            "reportsTo": 1002,
            "jobTitle": "Java Dev"
    }
*/
    //  http://localhost:8080/order/rest/employee/update
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Context HttpHeaders headers,Employee employee){
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            Integer returnstatus= dao.update(employee);
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
            "employeeNumber": 1705,
            "lastName": "Maraghi",
            "firstName": "Hadi",
            "extension": "x2543",
            "email": "Afshin.Parhizkari@unknown.com",
            "officeCode": "7",
            "reportsTo": 1501,
            "jobTitle": "Python Dev"
    }
*/