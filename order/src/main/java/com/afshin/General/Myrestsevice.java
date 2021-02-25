package com.afshin.General;

import com.afshin.Webservice.PaymentWs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@ApplicationPath("/rest")
public class Myrestsevice extends Application {
    public Set<Class<?>> Myrestsevice() {
        return new HashSet<Class<?>>(Arrays.asList(PaymentWs.class));
    }
}