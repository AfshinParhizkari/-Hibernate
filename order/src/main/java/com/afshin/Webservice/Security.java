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
import org.bouncycastle.util.encoders.Base64;
import java.util.StringTokenizer;

public class Security {
    UserDao dao = new UserDao();

    protected boolean basicAuthCheck(String encodedUserPassword) {
        Logback.logger.trace("GeneralFunc.login : Enter to method");
        try {
            //Decode username and password
            String credential = new String(Base64.decode(encodedUserPassword));
            if (credential == null || credential.isEmpty() || credential.trim().equals(":")) return false;
            else {
                // Split username and password tokens
/*                 StringTokenizer tokenizer = new StringTokenizer(credential, ":");
                 String username = tokenizer.nextToken();
                 String password = tokenizer.nextToken();*/
                String username = credential.substring(0,credential.indexOf(":"));
                String password = credential.substring(credential.indexOf(":")+1);
                User user = dao.login(username);
                if (user == null || !password.equals(user.getPassword())) {
                    Logback.logger.warn("login : User is not Detected");
                    return false;
                } else {
                    Logback.logger.info("login : User {} is Detected", user.getUsername());
                    return true;
                }
            }
        } catch (Exception e) {
            Logback.logger.error("{}.basicAuthCheck|Exception:{}", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}