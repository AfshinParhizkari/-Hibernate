package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/23/21
 * @Time 9:36 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Entity.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;


public class EmployeeRstTest {
    String restServicePath = "http://localhost:8080/order/rest/employee";
    String objID = "1705";
    @Test
    public void find()  throws IOException {
        Client client = ClientBuilder.newClient();
        String token = SecurityTest.getToken(client,"admin", "123");
        if (token.equals("0")) return;

        WebTarget webTarget = client.target(restServicePath).path("find").path(objID);
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.header(HttpHeaders.AUTHORIZATION, token).get();
        Employee employee = (new ObjectMapper()).readValue(response.readEntity(String.class), new TypeReference<Employee>() {});
        System.out.println(response.getStatusInfo() + "->" + response.getStatus());
        if (response.getStatus() == 200) System.out.println(employee);
    }

    @Test
    public void findall() throws IOException {
            Client client = ClientBuilder.newClient();
            String token = SecurityTest.getToken(client,"admin", "123");
            if (token.equals("0")) return;

            WebTarget webTarget = client.target(restServicePath).path("all");
            Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
            Response response = builder.header(HttpHeaders.AUTHORIZATION, token).get();
            ObjectMapper mapper = new ObjectMapper();
            List<Employee> list = mapper.readValue(response.readEntity(String.class), new TypeReference<List<Employee>>() {});
            //System.out.println(response.readEntity(String.class));
            System.out.println(response.getStatusInfo() + "->" + response.getStatus());
            if (response.getStatus() == 200) for (Employee temp : list) System.out.println(temp);}

    @Test
    public void delete() throws IOException {
        Client client = ClientBuilder.newClient();
        String token = SecurityTest.getToken(client,"admin", "123");
        if (token.equals("0")) return;

        WebTarget webTarget = client.target(restServicePath).path("delete").path(objID);
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.header(HttpHeaders.AUTHORIZATION, token).delete();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    @Test
    public void insert() throws IOException {
        Client client = ClientBuilder.newClient();
        String token = SecurityTest.getToken(client,"admin", "123");
        if (token.equals("0")) return;

        WebTarget webTarget=client.target(restServicePath).path("insert");
        Invocation.Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
        Employee e=new Employee();
        e.setEmployeeNumber(1705);
        e.setLastName("Parhizkari");
        e.setFirstName("Afshin");
        e.setEmail("Afshin.Parhizkari@gmail.com");
        e.setExtension("x2542");
        e.setOfficeCode("1");
        e.setReportsTo(1002);
        e.setJobTitle("Java Dev");
        FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept(e.getfilters()));
        String employeeJson=(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(e);
        Response response=builder.header(HttpHeaders.AUTHORIZATION,token).post(Entity.json(employeeJson));
        System.out.println(response.getStatus());
        if (response.getStatus() == 200) System.out.println(response.readEntity(String.class));
    }

    @Test
    public void update() throws IOException {
        Client client = ClientBuilder.newClient();
        String token = SecurityTest.getToken(client,"admin", "123");
        if (token.equals("0")) return;

        WebTarget webTarget=client.target(restServicePath).path("update");
        Invocation.Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
        Employee e=new Employee();
        e.setEmployeeNumber(1705);
        e.setLastName("Maraghi");
        e.setFirstName("Hadi");
        e.setEmail("Afshin.Parhizkari@unknown.com");
        e.setExtension("x2543");
        e.setOfficeCode("7");
        e.setReportsTo(1501);
        e.setJobTitle("Python Dev");
        FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept(e.getfilters()));
        String employeeJson=(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(e);
        Response response=builder.header(HttpHeaders.AUTHORIZATION,token).put(Entity.json(employeeJson));
        System.out.println(response.getStatus());
        if (response.getStatus() == 200) System.out.println(response.readEntity(String.class));
    }
}