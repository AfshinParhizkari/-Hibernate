package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/20/21
 * @Time 2:16 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: http://localhost:8080/order/soap/orderdetail?
 */
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

import com.afshin.General.Log4j;
import com.afshin.General.Logback;
import com.afshin.Dao.OrderdetailsDao;
import com.afshin.Entity.Orderdetail;
import com.afshin.Entity.OrderdetailPK;
import javax.annotation.Resource;

@WebService(name = "OrderdetailInt",serviceName = "OrderdetailSrv")
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class OrderdetailSop {
    OrderdetailsDao dao=new OrderdetailsDao();
    Security sec=new Security();

    @Resource
    WebServiceContext wsctx;

    @WebMethod
    @WebResult(name = "Orderdetail")
    public Orderdetail find(@WebParam(name = "OrderNumber") Integer orderNum, @WebParam(name = "ProductCode") String ProductCod) {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd = http_headers.get("Authorization").toString().replaceFirst("Basic ", "")
                    .replaceFirst("\\[", "").replace("]", "");
            if (!sec.basicAuthCheck(encodUsrPwd)) return null;

            Orderdetail orderdetail = dao.findbyid(new OrderdetailPK(orderNum, ProductCod));
            Log4j.logger.info("{}.{}|Try: Send record to Soap", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return orderdetail;
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
/*<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <find xmlns="http://Webservice.afshin.com/">
            <OrderNumber xmlns="">10125</OrderNumber>
            <ProductCode xmlns="">S24_2887</ProductCode>
        </find>
    </Body>
</Envelope>*/
    @WebMethod
    @WebResult(name = "OrderdetailList")
    public Orderdetail[] all() {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd = http_headers.get("Authorization").toString().replaceFirst("Basic ", "")
                    .replaceFirst("\\[", "").replace("]", "");
            if (!sec.basicAuthCheck(encodUsrPwd)) return null;

            List<Orderdetail> orderdetails = dao.findall();
            Orderdetail[] itemsArray = new Orderdetail[orderdetails.size()];
            Log4j.logger.info("{}.{}|Try: Send records to Soap", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return orderdetails.toArray(itemsArray);
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
    public String delete(@WebParam(name = "OrderNumber") Integer orderNum, @WebParam(name = "ProductCode") String ProductCod) {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd = http_headers.get("Authorization").toString().replaceFirst("Basic ", "")
                    .replaceFirst("\\[", "").replace("]", "");
            if (!sec.basicAuthCheck(encodUsrPwd)) return null;

            Orderdetail orderdetail = dao.findbyid(new OrderdetailPK(orderNum, ProductCod));
            Integer returnStatus = dao.delete(orderdetail);
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
            <OrderNumber xmlns="">10125</OrderNumber>
            <ProductCode xmlns="">S24_2887</ProductCode>
        </delete>
    </Body>
</Envelope>
*/
    @WebMethod
    @WebResult(name="OrderdetailPK")
    public OrderdetailPK insert(@WebParam(name="Orderdetail") Orderdetail orderdetail) {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd = http_headers.get("Authorization").toString().replaceFirst("Basic ", "")
                    .replaceFirst("\\[", "").replace("]", "");
            if (!sec.basicAuthCheck(encodUsrPwd)) return null;

            OrderdetailPK orderdetailPK = dao.insert(orderdetail);
            Log4j.logger.info("{}.{}|Try: record is inserted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return orderdetailPK;
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
/*
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <insert xmlns="http://Webservice.afshin.com/">
            <Orderdetail  xmlns="">
	            <orderNumber xmlns="">10125</orderNumber>
	            <productCode xmlns="">S24_2887</productCode>
	            <quantityOrdered xmlns="">2</quantityOrdered>
	            <priceEach xmlns="">137.01</priceEach>
	            <orderLineNumber xmlns="">3</orderLineNumber>
            </Orderdetail>
        </insert>
    </Body>
</Envelope>
 */
    @WebMethod
    @WebResult(name="OrderdetailPK")
    public OrderdetailPK update(@WebParam(name="Orderdetail") Orderdetail orderdetail) {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd = http_headers.get("Authorization").toString().replaceFirst("Basic ", "")
                    .replaceFirst("\\[", "").replace("]", "");
            if (!sec.basicAuthCheck(encodUsrPwd)) return null;

            OrderdetailPK orderdetailPK = dao.update(orderdetail);
            Log4j.logger.info("{}.{}|Try: record is updated", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return orderdetailPK;
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
/*
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <update xmlns="http://Webservice.afshin.com/">
            <Orderdetail  xmlns="">
	            <orderNumber xmlns="">10125</orderNumber>
	            <productCode xmlns="">S24_2887</productCode>
	            <quantityOrdered xmlns="">5</quantityOrdered>
	            <priceEach xmlns="">120.05</priceEach>
	            <orderLineNumber xmlns="">8</orderLineNumber>
            </Orderdetail>
        </update>
    </Body>
</Envelope>
 */
}
