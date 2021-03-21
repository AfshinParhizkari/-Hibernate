package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/20/21
 * @Time 3:46 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Webservice.stub.orderdetail.*;
import org.junit.Test;

import javax.xml.ws.WebServiceClient;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;

@WebServiceClient(name = "OrderDetailSrvClient",
        wsdlLocation = "http://localhost:8080/order/soap/orderdetail")
public class OrderdetailSopTest {
    final String soapServicePath="http://localhost:8080/order/soap/orderdetail";
    URL url=new URL(soapServicePath);
    OrderdetailSrv OSrv =new OrderdetailSrv(url);
    OrderdetailInt OInt = OSrv.getOrderdetailIntPort();
    Integer objID1=10125;
    String objID2="S24_2887";

    public OrderdetailSopTest() throws MalformedURLException {
    }
    public String toString(Orderdetail orderdetail) {
        return "Orderdetails{" +
                "orderNumber=" + orderdetail.getOrderNumber() +
                ", productCode=" + orderdetail.getProductCode() +
                ", quantityOrdered=" + orderdetail.getQuantityOrdered() +
                ", priceEach=" + orderdetail.getPriceEach() +
                ", orderLineNumber=" + orderdetail.getOrderLineNumber() +
                '}';
    }

    @Test
    public void find() throws MalformedURLException {
        Orderdetail orderdetail= OInt.find(objID1,objID2);
        System.out.println(toString(orderdetail));
    }
    @Test
    public void all() throws MalformedURLException {
        OrderdetailArray orderdetailArray=OInt.all();
        List<Orderdetail> orderdetails=orderdetailArray.getItem();
        for(Orderdetail orderdetail:orderdetails)
            System.out.println(toString(orderdetail));
    }

    @Test
    public void delete() throws MalformedURLException {
        String returnStatus = OInt.delete(objID1,objID2);
        System.out.println(returnStatus);
    }

    @Test
    public void insert() throws MalformedURLException {
        Orderdetail od=new Orderdetail();
        od.setOrderNumber(objID1);
        od.setProductCode(objID2);
        od.setQuantityOrdered(2);
        od.setPriceEach(new BigDecimal("137.01"));
        od.setOrderLineNumber(3);
        OrderdetailPK orderdetailPK = OInt.insert(od);
        System.out.println(orderdetailPK.getOrderNumber()+" "+orderdetailPK.getProductCode());
    }

    @Test
    public void update() throws MalformedURLException {
        Orderdetail od=new Orderdetail();
        od.setOrderNumber(objID1);
        od.setProductCode(objID2);
        od.setQuantityOrdered(5);
        od.setPriceEach(new BigDecimal("120.05"));
        od.setOrderLineNumber(8);
        OrderdetailPK orderdetailPK = OInt.update(od);
        System.out.println(orderdetailPK.getOrderNumber()+" "+orderdetailPK.getProductCode());
    }

}