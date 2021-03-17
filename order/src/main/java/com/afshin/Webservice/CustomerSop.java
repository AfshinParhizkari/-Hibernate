package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/16/21
 * @Time 7:58 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:  http://localhost:8080/order/soap/customer
 */
import com.afshin.Dao.CustomerDao;
import com.afshin.Entity.Customer;
import com.afshin.General.Log4j;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class CustomerSop {
    CustomerDao dao=new CustomerDao();
    Security sec=new Security();

    @WebMethod
    @WebResult(name="Customer")
    public Customer find(@WebParam(name="customerNumber") Integer Custnum) {
        Customer customer=dao.findbyid(Custnum) ;
        Log4j.logger.info("{}.{}|Try: Send record to Soap", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return customer;
    }
/* Wizdler extention in chrome. xmlns=""
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <find xmlns="http://Webservice.afshin.com/">
            <customerNumber xmlns="">103</customerNumber>
        </find>
    </Body>
</Envelope>
 */
    @WebMethod
    @WebResult(name="Customers")
    public Customer[] all() {
        List<Customer> customerList = dao.findall();
        Customer[] itemsArray = new Customer[customerList.size()];
        Log4j.logger.info("{}.{}|Try: Send records to Soap", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return customerList.toArray(itemsArray);
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
    public Integer Delete(@WebParam(name="customerNumber") Integer Custnum) {
       Integer returnStatus = dao.delete(dao.findbyid(Custnum));
        Log4j.logger.info("{}.{}|Try: Delete record", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return 1;
    }

}