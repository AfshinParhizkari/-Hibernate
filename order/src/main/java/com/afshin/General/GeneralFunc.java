package com.afshin.General;

import com.afshin.Entity.User;
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
    public static boolean login(HttpServletRequest req){
        User user=(User)req.getSession(true).getAttribute("sessionUser");
        if(user !=null ) return true;
        else return false;
    }
}
