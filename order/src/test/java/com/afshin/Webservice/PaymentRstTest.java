package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/5/21
 * @Time 6:26 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
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
import com.afshin.Entity.Payment;

public class PaymentRstTest {
    final String restServicePath = "http://localhost:8080/order/rest/payment";
    String objID1 = "496";
    String objID2 = "FN155234";

    @Test
    public void findall() throws IOException {
        Client client = ClientBuilder.newClient();
        String token = SecurityTest.getToken(client,"admin", "123");
        if (token.equals("0")) return;

        WebTarget webTarget = client.target(restServicePath).path("all");
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.header(HttpHeaders.AUTHORIZATION, token).get();
        // MAP JSON to List of Office
        ObjectMapper mapper = new ObjectMapper();
        List<Payment> list = mapper.readValue(response.readEntity(String.class), new TypeReference<List<Payment>>() {
        });
        //System.out.println(response.readEntity(String.class));
        System.out.println(response.getStatusInfo() + "->" + response.getStatus());
        if (response.getStatus() == 200) for (Payment temp : list) System.out.println(temp);
    }

    @Test
    public void find() throws IOException {
        Client client = ClientBuilder.newClient();
        String token = SecurityTest.getToken(client,"admin", "123");
        if (token.equals("0")) return;

        WebTarget webTarget = client.target(restServicePath).path("find").path(objID1).path(objID2);
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.header(HttpHeaders.AUTHORIZATION, token).get();
        Payment payment = (new ObjectMapper()).readValue(response.readEntity(String.class), new TypeReference<Payment>() {});
        System.out.println(response.getStatusInfo() + "->" + response.getStatus());
        if (response.getStatus() == 200) System.out.println(payment);
    }

    @Test
    public void delete() throws IOException {
        Client client = ClientBuilder.newClient();
        String token = SecurityTest.getToken(client,"admin", "123");
        if (token.equals("0")) return;

        WebTarget webTarget = client.target(restServicePath).path("delete").path(objID1).path(objID2);
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.header(HttpHeaders.AUTHORIZATION, token).delete();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    @Test
    public void insert() throws IOException, ParseException {
        Client client = ClientBuilder.newClient();
        String token = SecurityTest.getToken(client,"admin", "123");
        if (token.equals("0")) return;

        WebTarget webTarget=client.target(restServicePath).path("insert");
        Invocation.Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
        Payment payment=new Payment();
        payment.setCustomerNumber(496);
        payment.setCheckNumber("FN155234");
        payment.setPaymentDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2020-11-24T23:28:56.330Z"));
        payment.setAmount(new BigDecimal("10000.50"));
        FilterProvider filters = new SimpleFilterProvider().addFilter("PaymentFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept(payment.getfilters()));
        String paymentJson=(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(payment);
        Response response=builder.header(HttpHeaders.AUTHORIZATION,token).post(Entity.json(paymentJson));
        System.out.println(response.getStatus());
        if (response.getStatus() == 200) System.out.println(response.readEntity(String.class));
    }
    @Test
    public void update() throws IOException, ParseException {
        Client client = ClientBuilder.newClient();
        String token = SecurityTest.getToken(client,"admin", "123");
        if (token.equals("0")) return;

        WebTarget webTarget=client.target(restServicePath).path("update");
        Invocation.Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
        Payment payment=new Payment();
        payment.setCustomerNumber(496);
        payment.setCheckNumber("FN155234");
        payment.setPaymentDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2019-12-18T17:10:00.430Z"));
        payment.setAmount(new BigDecimal("20000.50"));
        FilterProvider filters = new SimpleFilterProvider().addFilter("PaymentFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept(payment.getfilters()));
        String paymentJson=(new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(payment);
        Response response=builder.header(HttpHeaders.AUTHORIZATION,token).put(Entity.json(paymentJson));
        System.out.println(response.getStatus());
        if (response.getStatus() == 200) System.out.println(response.readEntity(String.class));
    }
}