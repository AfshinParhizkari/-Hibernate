package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/6/21
 * @Time 12:02 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SecurityTest {
    static String restServicePath = "http://localhost:8080/order/rest/login";
    protected static String getToken(Client client,String usr,String pass) {
        try {
            String token = Files.readString(Paths.get(System.getProperty("user.dir"), "/src/main/webapp/statics/", "token.tkn"));
            if (token == null || token.isEmpty()) return "0";
            WebTarget webTarget = client.target(restServicePath).path("check");
            Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
            Response response = builder.header(HttpHeaders.AUTHORIZATION, token).get();
            System.out.println(response.getStatus()+ response.readEntity(String.class));
            if (response.getStatus() == 200) return token;
            else {
                HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(usr, pass);
                webTarget = client.register(feature).target(restServicePath).path("token");
                builder = webTarget.request();
                response = builder.get();
                token = response.getHeaderString(HttpHeaders.AUTHORIZATION);
                Files.writeString(Paths.get(System.getProperty("user.dir"), "/src/main/webapp/statics/", "token.tkn"), token);
                System.out.println("New Token is stored in file");
                return token;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "0";
        }
    }
}