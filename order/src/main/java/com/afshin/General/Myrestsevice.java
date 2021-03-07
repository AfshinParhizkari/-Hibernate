package com.afshin.General;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2/26/21
 * @Time 2:59 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: Restful service
 */

import com.afshin.Webservice.LoginRst;
import com.afshin.Webservice.OfficeRst;
import com.afshin.Webservice.PaymentRst;
import com.afshin.Webservice.UserRst;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@ApplicationPath("/rest")
public class Myrestsevice extends Application {
    public Set<Class<?>> Myrestsevice() {
                return new HashSet<Class<?>>(Arrays.asList(UserRst.class, OfficeRst.class, PaymentRst.class, LoginRst.class));
    }
}