package com.afshin.Webservice;

import com.afshin.Dao.OrderDao;
import com.afshin.Entity.Customer;
import com.afshin.Entity.Order;
import com.afshin.General.Log4j;
import com.afshin.General.Logback;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/22/21
 * @Time 7:28 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:   http://localhost:8080/order/soap/order
 */
@WebService(name = "OrderInt",serviceName = "OrderSrv")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class OrderSop {
    OrderDao dao=new OrderDao();
    Security sec=new Security();
    @Resource
    WebServiceContext wsctx;

    @WebMethod
    @WebResult(name = "Order")
    public Order find(@WebParam(name = "orderNumber") Integer orderNum){
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd=http_headers.get("Authorization").toString().replaceFirst("Basic ","")
                    .replaceFirst("\\[","").replace("]","");
            if(!sec.basicAuthCheck(encodUsrPwd)) return null;

            Order order = dao.findById(orderNum);
            Log4j.logger.info("{}.{}|Try: Send record to Soap", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return order;
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
/*
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <find xmlns="http://Webservice.afshin.com/">
            <orderNumber xmlns="">10426</orderNumber>
        </find>
    </Body>
</Envelope>
*/
    @WebMethod
    @WebResult(name = "Orders")
    public Order[] all() {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd=http_headers.get("Authorization").toString().replaceFirst("Basic ","")
                    .replaceFirst("\\[","").replace("]","");
            if(!sec.basicAuthCheck(encodUsrPwd)) return null;

            List<Order> oreders = dao.findAll();
            Order[] itemsArray = new Order[oreders.size()];
            Log4j.logger.info("{}.{}|Try: Send records to Soap", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return oreders.toArray(itemsArray);
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
/*<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <all xmlns="http://Webservice.afshin.com/"/>
    </Body>
</Envelope>*/
    @WebMethod
    @WebResult(name = "returnStatus")
    public String delete(@WebParam(name = "orderNumber") Integer orderNum) {
        try {
            Map http_headers= (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
                    String encodUsrPwd=http_headers.get("Authorization").toString().replaceFirst("Basic ","")
                            .replaceFirst("\\[","").replace("]","");
            if(!sec.basicAuthCheck(encodUsrPwd)) return null;

            Integer returnStatus = dao.delete(dao.findById(orderNum));
            Log4j.logger.info("{}.{}|Try: record is deleted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return returnStatus.toString();
        } catch (Exception e) {
            String UUID = java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return "Your Trace number is" + UUID + e.toString();
        }
    }
/*
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <delete xmlns="http://Webservice.afshin.com/">
            <orderNumber xmlns="">10426</orderNumber>
        </delete>
    </Body>
</Envelope>
*/
    @WebMethod
    @WebResult(name = "returnStatus")
    public String insert(@WebParam(name = "Order") Order order) {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd=http_headers.get("Authorization").toString().replaceFirst("Basic ","")
                    .replaceFirst("\\[","").replace("]","");
            if(!sec.basicAuthCheck(encodUsrPwd)) return null;

            Integer returnStatus = dao.insert(order);
            Log4j.logger.info("{}.{}|Try: record is inserted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return returnStatus.toString();
        } catch (Exception e) {
            String UUID = java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return "Your Trace number is" + UUID + e.toString();
        }
    }
/*
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <insert xmlns="http://Webservice.afshin.com/">
            <Order xmlns="">
	            <orderNumber xmlns="">10426</orderNumber>
	            <orderDate xmlns="">2020-10-15T23:28:56.782Z</orderDate>
	            <requiredDate xmlns="">2021-11-16T23:28:56.782Z</requiredDate>
	            <shippedDate xmlns="">2022-12-17T23:28:56.782Z</shippedDate>
	            <status xmlns="">Cancelled</status>
	            <comments xmlns="">We must pay it soon</comments>
	            <customerNumber xmlns="">481</customerNumber>
            </Order>
        </insert>
    </Body>
</Envelope>
*/
    @WebMethod
    @WebResult(name = "returnStatus")
    public String update(@WebParam(name = "Order") Order order) {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd=http_headers.get("Authorization").toString().replaceFirst("Basic ","")
                    .replaceFirst("\\[","").replace("]","");
            if(!sec.basicAuthCheck(encodUsrPwd)) return null;

            Integer returnStatus = dao.update(order);
            Log4j.logger.info("{}.{}|Try: record is updated", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return returnStatus.toString();
        } catch (Exception e) {
            String UUID = java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), UUID, e.getMessage());
            e.printStackTrace();
            return "Your Trace number is" + UUID + e.toString();
        }
    }
/*
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <update xmlns="http://Webservice.afshin.com/">
            <Order xmlns="">
	            <orderNumber xmlns="">10426</orderNumber>
	            <orderDate xmlns="">2017-07-07T23:28:56.782Z</orderDate>
	            <requiredDate xmlns="">2018-08-08T23:28:56.782Z</requiredDate>
	            <shippedDate xmlns="">2019-09-09T23:28:56.782Z</shippedDate>
	            <status xmlns="">Shipped</status>
	            <comments xmlns="">We can't pay it soon</comments>
	            <customerNumber xmlns="">496</customerNumber>
            </Order>
        </update>
    </Body>
</Envelope>
 */
}
