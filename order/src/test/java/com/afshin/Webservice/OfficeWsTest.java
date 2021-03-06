package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2/28/21
 * @Time 6:55 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.Test;
import java.util.List;
import com.afshin.Entity.Office;

public class OfficeWsTest {
    final String restServicePath="http://localhost:8080/order/rest/office";
    String objID="3";
    @Test
    public void all() throws Exception {
        Client client = ClientBuilder.newClient();
        //Basic Authentication :
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "123");
        client.register(feature);
        //
        WebTarget webTarget = client.target(restServicePath).path("all");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        // MAP JSON to List of Office
        ObjectMapper mapper = new ObjectMapper();
        List<Office> list = mapper.readValue(response.readEntity(String.class), new TypeReference<List<Office>>() {});
        //System.out.println(response.readEntity(String.class));
        System.out.println(response.getStatusInfo() + "->" + response.getStatus());
        if (response.getStatus() == 200) for (Office temp : list) System.out.println(temp);
    }

    @Test
    public void find() throws Exception {
        Client client = ClientBuilder.newClient();
        //Basic Authentication :
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "123");
        client.register(feature);
        //
        WebTarget webTarget = client.target(restServicePath).path("find").path(objID);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        System.out.println(response.getStatusInfo() + "->" + response.getStatus());
        if (response.getStatus() == 200) {
            //MAP JSON to User object
            ObjectMapper mapper = new ObjectMapper();
            Office obj = mapper.readValue(response.readEntity(String.class), new TypeReference<Office>() {
            });
            //System.out.println(response.readEntity(String.class));
            System.out.println(obj);
        }
    }

    @Test
    public void delete() throws Exception {
        Client client = ClientBuilder.newClient();
        //Basic Authentication :
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "123");
        client.register(feature);
        //
        WebTarget webTarget = client.target(restServicePath).path("/delete").path(objID);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.delete();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    @Test
    public void insert() throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        //Basic Authentication :
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "123");
        client.register(feature);
        //
        WebTarget webTarget = client.target(restServicePath).path("insert");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Office o=new Office();
        o.setOfficeCode("8");
        o.setCity("tehran");
        o.setPhone("+989032430637");
        o.setAddressLine1("Just come here 1");
        o.setAddressLine2("und the here 2");
        o.setState("Teh");
        o.setCountry("Iran");
        o.setPostalCode("0123456789");
        o.setTerritory("Persian");
        //filter attribute to create JSON
        FilterProvider filters = new SimpleFilterProvider().addFilter("OfficeFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept("officeCode", "city", "phone", "addressLine1", "addressLine2", "state", "country", "postalCode", "territory"));
        // Map Object -> String
        String officeJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(o);
        Response response = invocationBuilder.post(Entity.json(officeJson));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    @Test
    public void update() throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        //Basic Authentication :
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "123");
        client.register(feature);
        //
        WebTarget webTarget = client.target(restServicePath).path("update");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Office o=new Office();
        o.setOfficeCode("8");
        o.setCity("qazvin");
        o.setPhone("09032430637");
        o.setAddressLine1("New Just come here 1");
        o.setAddressLine2("New und the here 2");
        o.setState("Qaz");
        o.setCountry("IRR");
        o.setPostalCode("9876543210");
        o.setTerritory("Fars");
        //filter attribute to create JSON
        FilterProvider filters = new SimpleFilterProvider().addFilter("OfficeFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept("officeCode", "city", "phone", "addressLine1", "addressLine2", "state", "country", "postalCode", "territory"));
        // Map Object -> String
        String officeJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(o);
        Response response = invocationBuilder.put(Entity.json(officeJson));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
}