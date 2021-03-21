package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/1/21
 * @Time 1:02 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Dao.UserDao;
import com.afshin.Entity.User;
import com.afshin.General.Logback;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.bouncycastle.util.encoders.Base64;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class Security {

    protected boolean basicAuthCheck(String encodedUserPassword) {
        try {
            //Decode username and password
            String credential = new String(Base64.decode(encodedUserPassword));
            if (credential == null || credential.isEmpty() || credential.trim().equals(":")) return false;
            else {
/*                           Split username and password tokens
                 StringTokenizer tokenizer = new StringTokenizer(credential, ":");
                 String username = tokenizer.nextToken();
                 String password = tokenizer.nextToken();*/
                String username = credential.substring(0, credential.indexOf(":"));
                String password = credential.substring(credential.indexOf(":") + 1);
                UserDao dao = new UserDao();
                User user = dao.login(username);
                if (user == null || !password.equals(user.getPassword())) {
                    Logback.logger.info("{}.{}| User or Password are not correct",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
                    return false;
                } else {
                    Logback.logger.info("{}.{}| User {} and password are correct",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName(), user.getUsername());
                    return true;
                }
            }
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    protected boolean tokenAuthCheck(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey("sharekeyisafshin").parseClaimsJws(token).getBody();
            Logback.logger.info(String.valueOf(claims));
            Logback.logger.info("{}.{}| Token is correct",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return true;
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}",this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            //e.printStackTrace();
            return false;
        }

    }

}