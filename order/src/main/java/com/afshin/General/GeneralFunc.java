package com.afshin.General;

import com.afshin.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2021 - 01 - 09
 * @Time 12:01 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
public class GeneralFunc {

    public static final Logger logger  = LoggerFactory.getLogger("");


    public static boolean login(HttpServletRequest req){
        logger.trace("GeneralFunc.login : Enter to method");
        User user=(User)req.getSession(true).getAttribute("sessionUser");
        if(user !=null ) {
            logger.info("GeneralFunc.login : User {} is Detected",user.getUsername());
            return true;
        }
        else {
            logger.warn("login : User is not Detected");
            return false;
        }
    }
}
