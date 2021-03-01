package com.afshin.Webservice;

import com.afshin.Entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.Test;
import java.util.List;

public class UserWsTest {

    @Test
    public void all() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/order/rest").path("user").path("all");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        // MAP JSON to List of User
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = mapper.readValue(response.readEntity(String.class), new TypeReference<List<User>>() {
        });
        //System.out.println(response.readEntity(String.class));
        System.out.println(response.getStatusInfo() + "->" + response.getStatus());
        if (response.getStatus() == 200) for (User tempOrd : list) System.out.println(tempOrd);
    }


    @Test
    public void find() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/order/rest").path("user").path("find").path("3");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        // MAP JSON to User
        ObjectMapper mapper = new ObjectMapper();
        User obj = mapper.readValue(response.readEntity(String.class), new TypeReference<User>() {});
        //System.out.println(response.readEntity(String.class));
        System.out.println(response.getStatusInfo() + "->" + response.getStatus());
        if (response.getStatus() == 200) System.out.println(obj);
    }

    @Test
    public void insert() throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/order/rest").path("user").path("insert");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        User user = new User();
        user.setIdusers(5);
        user.setUsername("mahjoob");
        user.setPassword("123");
        user.setEmployeeid(1056);
        //filter attribute to create JSON
        FilterProvider filters = new SimpleFilterProvider().addFilter(
                "UserFilter", SimpleBeanPropertyFilter.filterOutAllExcept("idusers", "username", "password", "employeeid"));
        // Map Object -> String
        String userJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(userJson);
        //JSON String:
/*        userJson = "{\n" +
                "  \"idusers\" : 6,\n" +
                "  \"username\" : \"Homa\",\n" +
                "  \"password\" : \"789\",\n" +
                "  \"employeeid\" : 1056\n" +
                "}";*/
        Response response = invocationBuilder.post(Entity.json(userJson));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    @Test
    public void updateUser() throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/order/rest").path("user").path("update");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        User user = new User();
        user.setIdusers(6);
        user.setUsername("Forough");
        user.setPassword("147");
        user.setEmployeeid(1076);
        //filter attribute to create JSON
        FilterProvider filters = new SimpleFilterProvider().addFilter(
                "UserFilter", SimpleBeanPropertyFilter.filterOutAllExcept("idusers", "username", "password", "employeeid"));
        // Map Object -> String
        String userJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(userJson);
        //JSON String:
/*        userJson = "{\n" +
                "  \"idusers\" : 6,\n" +
                "  \"username\" : \"Forough\",\n" +
                "  \"password\" : \"147\",\n" +
                "  \"employeeid\" : 1076\n" +
                "}";*/
        Response response = invocationBuilder.put(Entity.json(userJson));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    @Test
    public void deleteeUser() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/order/rest").path("user").path("6");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.delete();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
}