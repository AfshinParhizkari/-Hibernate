package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/23/21
 * @Time 8:04 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Webservice.stub.orderdetail.*;
import com.afshin.Webservice.stub.productline.Productline;
import com.afshin.Webservice.stub.productline.ProductlineArray;
import com.afshin.Webservice.stub.productline.ProductlineInt;
import com.afshin.Webservice.stub.productline.ProductlineSrv;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.handler.MessageContext;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


@WebServiceClient(name = "ProductlineSrvClient",
        wsdlLocation = "http://localhost:8080/order/soap/productline")
public class ProductlineSopTest {
    String soapServicePath="http://localhost:8080/order/soap/productline";
    URL url=new URL(soapServicePath);
    ProductlineSrv OSrv =new ProductlineSrv(url);
   ProductlineInt OInt = OSrv.getProductlineIntPort();
    String objID1="dbmodel";

    public ProductlineSopTest() throws MalformedURLException {}
    public String toString(Productline productline) {
        return "Productline{" +
                "productLine='" + productline.getProductLine() +
                ", textDescription='" + productline.getTextDescription() +
                ", htmlDescription='" + productline.getHtmlDescription() +
                '}';
    }


    @Test
    public void find() throws MalformedURLException{
        Map<String, Object> req_ctx = ((BindingProvider)OInt).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        String credential= "Basic "+ new String(Base64.encode("admin:123".getBytes()));
        headers.put("Authorization", Collections.singletonList(credential));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        Productline productline= OInt.find(objID1);
        System.out.println(toString(productline));
    }
    @Test
    public void all() throws MalformedURLException{
        Map<String, Object> req_ctx = ((BindingProvider)OInt).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        String credential= "Basic "+ new String(Base64.encode("admin:123".getBytes()));
        headers.put("Authorization", Collections.singletonList(credential));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        ProductlineArray productlineArray=OInt.all();
        List<Productline> productlines=productlineArray.getItem();
        for(Productline productline:productlines)
            System.out.println(toString(productline));
    }
    @Test
    public void delete() throws MalformedURLException{
        Map<String, Object> req_ctx = ((BindingProvider)OInt).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        String credential= "Basic "+ new String(Base64.encode("admin:123".getBytes()));
        headers.put("Authorization", Collections.singletonList(credential));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        String returnStatus = OInt.delete(objID1);
        System.out.println(returnStatus);
    }
    @Test
    public void insert() throws MalformedURLException{
        Map<String, Object> req_ctx = ((BindingProvider)OInt).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        String credential= "Basic "+ new String(Base64.encode("admin:123".getBytes()));
        headers.put("Authorization", Collections.singletonList(credential));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        Productline pl=new Productline();
        pl.setProductLine("dbmodel");
        pl.setTextDescription("order database model in graphic's way");
        pl.setHtmlDescription("https://github.com/AfshinParhizkari");
        try{
            //System.out.println(Paths.get("").toAbsolutePath().toString());
            System.out.println(Paths.get("","/main/webapp/statics/images/","b52.jpeg"));
            pl.setImage(Files.readAllBytes(Paths.get(System.getProperty("user.dir"),"/src/main/webapp/statics/images/","b52.jpeg")));
        }catch (Exception e) {
            System.out.println(e.toString());
        }

        String returnStatus = OInt.insert(pl);
        System.out.println(returnStatus);
    }
    @Test
    public void update() throws MalformedURLException{
        Map<String, Object> req_ctx = ((BindingProvider)OInt).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        String credential= "Basic "+ new String(Base64.encode("admin:123".getBytes()));
        headers.put("Authorization", Collections.singletonList(credential));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        Productline pl=OInt.find("dbmodel");
        pl.setTextDescription("just update order database model");
        pl.setHtmlDescription("https://www.linkedin.com/in/afshin-parhizkari/");
        try{pl.setImage(Files.readAllBytes(Paths.get(System.getProperty("user.dir"),"/src/main/webapp/statics/images/","b52changed.jpg")));}
        catch (Exception e) {
            System.out.println(e.toString());
        }

        String returnStatus = OInt.update(pl);
        System.out.println(returnStatus);
    }
}