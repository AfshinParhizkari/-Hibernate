package com.afshin.Webservice;


import jakarta.jws.WebMethod;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceProvider;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/6/21
 * @Time 7:52 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: http://localhost:8080/order/soap/product
 */

@WebService(name = "productSoap",serviceName = "productSoap",portName = "productPort"
        ,targetNamespace = "http://afshin.com/product"
        //,wsdlLocation = "/soap/product?wsdl"
)
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class ProductSop {
    @WebMethod
    @WebResult(name="product")
    public String helloworld(String name) {
        return "Hello World JAX-WS " + name;
    }
}
