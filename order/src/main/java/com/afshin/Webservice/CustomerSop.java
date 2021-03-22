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
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;
import com.afshin.General.Log4j;
import com.afshin.General.Logback;
import com.afshin.Dao.CustomerDao;
import com.afshin.Entity.Customer;

@WebService(name = "CustomerInt",serviceName = "CustomerSrv")
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class CustomerSop {
    CustomerDao dao=new CustomerDao();

    @WebMethod
    @WebResult(name="Customer")
    public Customer find(@WebParam(name="customerNumber")  Integer Custnum) {
        try {
            Customer customer = dao.findbyid(Custnum);
            Log4j.logger.info("{}.{}|Try: Send record to Soap", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return customer;
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return null;
        }
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
        try {
            List<Customer> customerList = dao.findall();
            Customer[] itemsArray = new Customer[customerList.size()];
            Log4j.logger.info("{}.{}|Try: Send records to Soap", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return customerList.toArray(itemsArray);
        } catch (Exception e) {
            Logback.logger.error("{}.{}|Exception:{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
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
    public String delete(@WebParam(name="customerNumber") Integer Custnum) {
        try {
            Integer returnStatus = dao.delete(dao.findbyid(Custnum));
            Log4j.logger.info("{}.{}|Try: record is deleted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return returnStatus.toString();
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return "Your Trace number is"+UUID+e.toString();
        }
    }

    @WebMethod
    @WebResult(name="ReturnStatus")
    public String insert(@WebParam(name="customer") Customer customer) {
        try{
        Integer returnStatus = dao.insert(customer);
        Log4j.logger.info("{}.{}|Try: record is inserted", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        return  returnStatus.toString();
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return "Your Trace number is"+UUID+e.toString();
        }
    }
/*
    <Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <insert xmlns="http://Webservice.afshin.com/">
        	<customer xmlns="">
	            <customerNumber xmlns="">497</customerNumber>
	            <customerName xmlns="">Helman Kitty</customerName>
	            <contactLastName xmlns="">Parhizkari</contactLastName>
	            <contactFirstName xmlns="">Afshin</contactFirstName>
	            <phone xmlns="">+9030000000</phone>
	            <addressLine1 xmlns="">Persian Qazvin 1</addressLine1>
	            <addressLine2 xmlns="">Street and Building</addressLine2>
	            <city xmlns="">Qazvin</city>
	            <state xmlns="">Qa</state>
	            <postalCode xmlns="">987654321</postalCode>
	            <country xmlns="">Persian</country>
	            <salesRepEmployeeNumber xmlns="">1188</salesRepEmployeeNumber>
	            <creditLimit xmlns="">100000</creditLimit>
	        </customer>
         </insert>
    </Body>
</Envelope>
*/
    @WebMethod
    @WebResult(name="ReturnStatus")
    public String update(@WebParam(name="customer") Customer customer) {
        try {
            Integer returnStatus = dao.update(customer);
            Log4j.logger.info("{}.{}|Try: record is updated", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return returnStatus.toString();
        } catch (Exception e) {
            String UUID = java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|UUID:{} - Exception: {}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(),UUID, e.getMessage());
            e.printStackTrace();
            return "Your Trace number is" + UUID + e.toString();
        }
    }
/*
    <Envelope xmlns="http://schemas.xm            Logback.logger.error("{}.{}|Exception:UUID-{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
lsoap.org/soap/envelope/">
    <Body>
        <update xmlns="http://Webservice.afshin.com/">
        	<customer xmlns="">
	            <customerNumber xmlns="">497</customerNumber>
	            <customerName xmlns="">Afshin Parhizkari</customerName>
	            <contactLastName xmlns="">Kitty</contactLastName>
	            <contactFirstName xmlns="">Helman</contactFirstName>
	            <phone xmlns="">+989032430637</phone>
	            <addressLine1 xmlns="">Iran Tehran 1</addressLine1>
	            <addressLine2 xmlns="">Iran Tehran 1</addressLine2>
	            <city xmlns="">Tehran</city>
	            <state xmlns="">Th</state>
	            <postalCode xmlns="">123456789</postalCode>
	            <country xmlns="">Iran</country>
	            <salesRepEmployeeNumber xmlns="">1612</salesRepEmployeeNumber>
	            <creditLimit xmlns="">150000</creditLimit>
	        </customer>
         </update>
    </Body>
</Envelope>
*/
}