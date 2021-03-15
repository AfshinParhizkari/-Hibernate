package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/6/21
 * @Time 7:52 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: http://localhost:8080/order/soap/product
 */
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class ProductSop {
    public ProductSop() {}

    @WebMethod
    //@WebResult(name="product")
    public String helloworld(String name) {
        return "Hello World JAX-WS " + name;
    }
}
