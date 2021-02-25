package com.afshin.Webservice;

import com.afshin.Entity.Payment;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@ApplicationPath("/rest")
public class MyApplication extends Application {
    public Set<Class<?>> MyApplication() {
        return new HashSet<Class<?>>(Arrays.asList(PaymentWs.class));
    }

}
