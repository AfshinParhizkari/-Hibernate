package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/22/21
 * @Time 9:03 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.General.GregorianDate;
import com.afshin.Webservice.stub.order.Order;
import com.afshin.Webservice.stub.order.OrderArray;
import com.afshin.Webservice.stub.order.OrderInt;
import com.afshin.Webservice.stub.order.OrderSrv;
import com.afshin.Webservice.stub.orderdetail.Orderdetail;
import com.afshin.Webservice.stub.orderdetail.OrderdetailArray;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@WebServiceClient(name = "OrderSrvClient",
        wsdlLocation = "http://localhost:8080/order/soap/order")
public class OrderSopTest {
    URL url=new URL("http://localhost:8080/order/soap/order");
    OrderSrv OSrv =new OrderSrv(url);
    OrderInt OInt = OSrv.getOrderIntPort();
    Integer objID1=10426;

    public OrderSopTest() throws MalformedURLException {}
    public String toString(Order order) {
        return "Order{" +
                "orderNumber=" + order.getOrderNumber() +
                ", orderDate=" + order.getOrderDate() +
                ", requiredDate=" + order.getRequiredDate() +
                ", shippedDate=" +order.getShippedDate()+
                ", status='" + order.getStatus() +
                ", comments='" + order.getComments() +
                ", customerNumber=" + order.getCustomerNumber() +
                '}';
    }

    @Test
    public void find() throws MalformedURLException  {
        Map<String, Object> req_ctx = ((BindingProvider)OInt).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        String credential= "Basic "+ new String(Base64.encode("admin:123".getBytes()));
        headers.put("Authorization", Collections.singletonList(credential));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        Order order=OInt.find(objID1);
        System.out.println(toString(order));
    }

    @Test
    public void all() throws MalformedURLException  {
        Map<String, Object> req_ctx = ((BindingProvider)OInt).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        String credential= "Basic "+ new String(Base64.encode("admin:123".getBytes()));
        headers.put("Authorization", Collections.singletonList(credential));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        OrderArray orderArray=OInt.all();
        List<Order> orders=orderArray.getItem();
        for(Order order:orders)
            System.out.println(toString(order));
    }

    @Test
    public void delete() throws MalformedURLException  {
        Map<String, Object> req_ctx = ((BindingProvider)OInt).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        String credential= "Basic "+ new String(Base64.encode("admin:123".getBytes()));
        headers.put("Authorization", Collections.singletonList(credential));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        String returnStatus = OInt.delete(objID1);
        System.out.println(returnStatus);
    }

    @Test
    public void insert() throws MalformedURLException, ParseException {
        Map<String, Object> req_ctx = ((BindingProvider)OInt).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        String credential= "Basic "+ new String(Base64.encode("admin:123".getBytes()));
        headers.put("Authorization", Collections.singletonList(credential));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        Order order = new Order();
        order.setOrderNumber(10426);
        order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2020-11-24T23:28:56.330Z"));
        order.setRequiredDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2020-11-24T23:28:56.330Z"));
        order.setShippedDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2020-11-24T23:28:56.330Z"));
        order.setStatus("Cancelled");
        order.setComments("We must pay it soon");
        order.setCustomerNumber(481);

        String returnStatus = OInt.insert(order);
        System.out.println(returnStatus);
    }

    @Test
    public void update() throws MalformedURLException, ParseException {
        Map<String, Object> req_ctx = ((BindingProvider)OInt).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        String credential= "Basic "+ new String(Base64.encode("admin:123".getBytes()));
        headers.put("Authorization", Collections.singletonList(credential));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        Order order = new Order();
        order.setOrderNumber(10426);
        order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2017-07-17T23:28:56.330Z"));
        order.setRequiredDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2018-08-18T23:28:56.330Z"));
        order.setShippedDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2019-09-19T23:28:56.330Z"));
        order.setStatus("Shipped");
        order.setComments("We can't pay it soon");
        order.setCustomerNumber(496);

        String returnStatus = OInt.update(order);
        System.out.println(returnStatus);
    }
}