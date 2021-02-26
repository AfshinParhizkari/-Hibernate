package com.afshin.Webservice;


import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class UserWsTest {

    @Test
    public void findallTest() {
        Client client = ClientBuilder.newClient();
        String entity = client.target("http://localhost:8080/order/rest/user/all")
                .request(MediaType.APPLICATION_JSON).header("some-header", "true").get(String.class);
        System.out.println(entity);
    }
}
