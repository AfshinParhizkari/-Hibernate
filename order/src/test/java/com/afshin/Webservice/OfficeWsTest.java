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
import com.afshin.Entity.Office;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.Test;

public class OfficeWsTest {

    @Test
    public void find() throws Exception {
        Client client = ClientBuilder.newClient();
        //Basic Authentication :
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "123");
        client.register(feature);
        //
        WebTarget webTarget = client.target("http://localhost:8080/order/rest").path("office").path("find").path("3");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        //MAP JSON to User object
        ObjectMapper mapper = new ObjectMapper();
        Office obj = mapper.readValue(response.readEntity(String.class), new TypeReference<Office>() {});
        //System.out.println(response.readEntity(String.class));
        System.out.println(response.getStatusInfo() + "->" + response.getStatus());
        if (response.getStatus() == 200) System.out.println(obj);
    }
}