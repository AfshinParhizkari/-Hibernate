package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/9/21
 * @Time 5:20 AM
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
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.Test;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import com.afshin.Entity.Product;


public class ProductRstTest {
    String restServicePath = "http://localhost:8080/order/rest/product";
    String objID1 = "S72_3213";
    @Test
    public void find() throws IOException {
        Client client = ClientBuilder.newClient();
        String token = SecurityTest.getToken(client, "admin", "123");
        if (token.equals("0")) return;

        WebTarget webTarget = client.target(restServicePath).path("find").path(objID1);
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.header(HttpHeaders.AUTHORIZATION, token).get();
        Product product = (new ObjectMapper()).readValue(response.readEntity(String.class), new TypeReference<Product>() {});
        System.out.println(response.getStatusInfo() + "->" + response.getStatus());
        if (response.getStatus() == 200) System.out.println(product);
    }
    @Test
    public void findall() throws IOException {
        Client client=ClientBuilder.newClient();
        String token=SecurityTest.getToken(client,"admin","123");
        if(token.equals("0")) return;
        WebTarget webTarget=client.target(restServicePath).path("all");
        Invocation.Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
        Response response=builder.header(HttpHeaders.AUTHORIZATION,token).get();
        List<Product> list= (new ObjectMapper()).readValue(response.readEntity(String.class),new TypeReference<List<Product>>(){});
        System.out.println(response.getStatusInfo() + "->" + response.getStatus());
        if (response.getStatus() == 200) for (Product temp : list) System.out.println(temp);
    }

    @Test
    public void delete() {
        Client client=ClientBuilder.newClient();
        String token = SecurityTest.getToken(client,"admin","123");
        if (token.equals("0")) return;
        WebTarget webTarget=client.target(restServicePath).path("delete").path(objID1);
        Invocation.Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
        Response response=builder.header(HttpHeaders.AUTHORIZATION,token).delete();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    @Test
    public void insert() throws JsonProcessingException {
        Client client=ClientBuilder.newClient();
        String token=SecurityTest.getToken(client,"admin","123");
        if (token.equals("0")) return;
        WebTarget webTarget=client.target(restServicePath).path("insert");
        Invocation.Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
        Product product=new Product();
        product.setProductCode("S72_3213");
        product.setProductName("1950 Paykan IKCO");
        product.setProductLine("Classic Cars");
        product.setProductScale("1:72");
        product.setProductVendor("Iran Musium Car vendor");
        product.setProductDescription("nicht besonders");
        product.setQuantityInStock(321);
        product.setBuyPrice(new BigDecimal("23.12"));
        product.setMSRP(new BigDecimal("30.41"));
        FilterProvider filters=new SimpleFilterProvider().addFilter("ProductFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept(product.getfilters()));
        String productJson=(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(product);
        Response response=builder.header(HttpHeaders.AUTHORIZATION,token).post(Entity.json(productJson));
        System.out.println(response.getStatus());
        if (response.getStatus() == 200) System.out.println(response.readEntity(String.class));
    }

    @Test
    public void update() throws JsonProcessingException {
        Client client=ClientBuilder.newClient();
        String token=SecurityTest.getToken(client,"admin","123");
        if (token.equals("0")) return;
        WebTarget webTarget=client.target(restServicePath).path("update");
        Invocation.Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
        Product product=new Product();
        product.setProductCode("S72_3213");
        product.setProductName("1970 peyote  GLX");
        product.setProductLine("Classic Cars");
        product.setProductScale("1:72");
        product.setProductVendor("Qazvin Musium Car vendor");
        product.setProductDescription("update fur nicht besonders");
        product.setQuantityInStock(123);
        product.setBuyPrice(new BigDecimal("12.23"));
        product.setMSRP(new BigDecimal("41.30"));
        FilterProvider filters=new SimpleFilterProvider().addFilter("ProductFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept(product.getfilters()));
        String productJson=(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(product);
        Response response=builder.header(HttpHeaders.AUTHORIZATION,token).put(Entity.json(productJson));
        System.out.println(response.getStatus());
        if (response.getStatus() == 200) System.out.println(response.readEntity(String.class));
    }
}