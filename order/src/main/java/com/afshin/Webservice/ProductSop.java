package com.afshin.Webservice;

import jakarta.jws.WebMethod;
import jakarta.xml.ws.WebServiceProvider;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/6/21
 * @Time 7:52 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
/*(@WebServicename = "SoapEmpl"
        ,targetNamespace = "helloworld"
        ,serviceName = "echo"
        ,portName = "echoPort"
        ,endpointInterface = "com.afshin.Webservice.ProductSop")
@SOAPBinding(style = SOAPBinding.Style.RPC,use = SOAPBinding.Use.LITERAL)*/
@WebServiceProvider
public class ProductSop {

    @WebMethod
    //@WebResult(name="helloworld")
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }
}
