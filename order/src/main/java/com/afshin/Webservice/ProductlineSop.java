package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/23/21
 * @Time 2:18 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description: 	http://localhost:8080/order/soap/productline
 * In the future i add SAML2.0 Bearer Assertion(token) to this service but now it is Basic Aurh
 */
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

import com.afshin.General.Log4j;
import com.afshin.Dao.ProductlineDao;
import com.afshin.Entity.Productline;

@WebService(name = "ProductlineInt",serviceName = "ProductlineSrv")
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class ProductlineSop {
    ProductlineDao dao=new ProductlineDao();
    Security sec=new Security();

    @Resource
    WebServiceContext wsctx;

    @WebMethod
    @WebResult(name="Productline")
    public Productline find(@WebParam(name="ProductlineNumber")  String Prodline) {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd = http_headers.get("Authorization").toString().replaceFirst("Basic ", "")
                    .replaceFirst("\\[", "").replace("]", "");
            if (!sec.basicAuthCheck(encodUsrPwd)) return null;

            Productline Productline = dao.findbyid(Prodline);
            Log4j.logger.info("{}.{}|Try: Send record to Soap", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return Productline;
        } catch (Exception e) {
            Log4j.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    /* Wizdler extention in chrome. xmlns=""
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
            <find xmlns="http://Webservice.afshin.com/">
                <ProductlineNumber xmlns="">dbmodel</ProductlineNumber>
            </find>
        </Body>
    </Envelope>
     */
    @WebMethod
    @WebResult(name="Productlines")
    public Productline[] all() {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd = http_headers.get("Authorization").toString().replaceFirst("Basic ", "")
                    .replaceFirst("\\[", "").replace("]", "");
            if (!sec.basicAuthCheck(encodUsrPwd)) return null;

            List<Productline> ProductlineList = dao.findall();
            Productline[] itemsArray = new Productline[ProductlineList.size()];
            Log4j.logger.info("{}.{}|Try: Send records to Soap", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return ProductlineList.toArray(itemsArray);
        } catch (Exception e) {
            Log4j.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    /*
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
            <all xmlns="http://Webservice.afshin.com/"/>
        </Body>
    </Envelope>
     */
    @WebMethod
    @WebResult(name="ReturnStatus")
    public String delete(@WebParam(name="ProductlineNumber") String Prodline) {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd = http_headers.get("Authorization").toString().replaceFirst("Basic ", "")
                    .replaceFirst("\\[", "").replace("]", "");
            if (!sec.basicAuthCheck(encodUsrPwd)) return null;

            Integer returnStatus = dao.delete(dao.findbyid(Prodline));
            Log4j.logger.info("{}.{}|Try: record is deleted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return returnStatus.toString();
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Log4j.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return "Your Trace number is"+UUID+e.toString();
        }
    }
    /*
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
            <delete xmlns="http://Webservice.afshin.com/">
                <ProductlineNumber xmlns="">dbmodel</ProductlineNumber>
            </delete>
        </Body>
    </Envelope>
    */
    @WebMethod
    @WebResult(name="ReturnStatus")
    public String insert(@WebParam(name="Productline") Productline Productline) {
        try{
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd = http_headers.get("Authorization").toString().replaceFirst("Basic ", "")
                    .replaceFirst("\\[", "").replace("]", "");
            if (!sec.basicAuthCheck(encodUsrPwd)) return null;

            String returnStatus = dao.insert(Productline);
            Log4j.logger.info("{}.{}|Try: record is inserted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return  returnStatus;
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Log4j.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return "Your Trace number is"+UUID+e.toString();
        }
    }
    /*
        <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
            <insert xmlns="http://Webservice.afshin.com/">
                <Productline xmlns="">
                    <productLine xmlns="">dbmodel</productLine>
                    <textDescription xmlns="">order database model in graphic's way</textDescription>
                    <htmlDescription xmlns="">https://github.com/AfshinParhizkari</htmlDescription>
                    <image xmlns=""></image>
                </Productline>
             </insert>
        </Body>
    </Envelope>
    */
    @WebMethod
    @WebResult(name="ReturnStatus")
    public String update(@WebParam(name="Productline") Productline Productline) {
        try {
            Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
            String encodUsrPwd = http_headers.get("Authorization").toString().replaceFirst("Basic ", "")
                    .replaceFirst("\\[", "").replace("]", "");
            if (!sec.basicAuthCheck(encodUsrPwd)) return null;

            String returnStatus = dao.update(Productline);
            Log4j.logger.info("{}.{}|Try: record is updated", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return returnStatus.toString();
        } catch (Exception e) {
            String UUID = java.util.UUID.randomUUID().toString();
            Log4j.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return "Your Trace number is" + UUID + e.toString();
        }
    }
/*
        <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
        <Body>
            <update xmlns="http://Webservice.afshin.com/">
                <Productline xmlns="">
                    <productLine xmlns="">dbmodel</productLine>
                    <textDescription xmlns="">just update order database modely</textDescription>
                    <htmlDescription xmlns="">https://www.linkedin.com/in/afshin-parhizkari/</htmlDescription>
                    <image xmlns=""></image>
                </Productline>
             </update>
        </Body>
    </Envelope>
*/
}