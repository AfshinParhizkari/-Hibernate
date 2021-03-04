package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/3/21
 * @Time 1:39 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.General.Logback;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.bouncycastle.util.encoders.Base64;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Date;

@Path("/login")
public class LoginWs {
    Security sec=new Security();
    //  http://localhost:8080/order/rest/login/check
    @GET
    @Path("/check")
    public Response echo(@Context HttpHeaders headers) {
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        return Response.status(Response.Status.UNAUTHORIZED).entity("token is valid").build();
    }
    //  http://localhost:8080/order/rest/login/token
    @POST
    @Path("/token")
    public Response getToken(@Context HttpHeaders headers){
        //Get encoded username and password
        String encodUsrPwd=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).replaceFirst("Basic ", " ");
        if(!sec.basicAuthCheck(encodUsrPwd))
            return Response.status(Response.Status.UNAUTHORIZED).entity("User or password is wrong").build();
        try {
            String credential = new String(Base64.decode(encodUsrPwd));
            String login = credential.substring(0,credential.indexOf(":"));

            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.MINUTE, +1);

            String jwtToken = Jwts.builder().setSubject(login).setIssuedAt(new Date()).setExpiration(cal.getTime())
                    .setIssuer("https://github.com/AfshinParhizkari/Hibernate")
                    .signWith(SignatureAlgorithm.HS512,"sharekeyisafshin").compact();
            //System.out.println(jwtToken);
            Logback.logger.info("{}.{}|Try: Return Token to Invoker",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken).build();
        }catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(),e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }
}