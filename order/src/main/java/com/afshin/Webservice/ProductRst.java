package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/8/21
 * @Time 5:07 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import com.afshin.General.Logback;
import com.afshin.Dao.ProductDao;
import com.afshin.Entity.Product;
@Path("/product")
public class ProductRst {
    ProductDao dao = new ProductDao();
    Security sec = new Security();
    //  http://localhost:8080/order/rest/product/find/S72_3213
    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") String prdCod, @Context HttpHeaders headers) {
        String token = headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if (!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            Product product = dao.findbyid(prdCod);
            FilterProvider filters = new SimpleFilterProvider().addFilter("ProductFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept(product.getfilters()));
            String productJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(product);
            Logback.logger.info("{}.{}|Try: Send record to RESTful", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(productJson).build();
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|Exception:UUID-{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/product/all
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findall(@Context HttpHeaders headers) {
        String token = headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if (!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.OK).entity("token not valid").build();
        try {
            Product product = new Product();
            List<Product> productList = dao.findall();
            FilterProvider filters = new SimpleFilterProvider().addFilter("ProductFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept(product.getfilters()));
            String productsJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(productList);
            Logback.logger.info("{}.{}|Try: Send record to RESTful", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(productsJson).build();
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|Exception:UUID-{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/product/delete/S72_3213
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String prodCon, @Context HttpHeaders headers) {
        String token = headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if (!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.OK).entity("token not valid").build();
        try {
            Integer returnstatus=dao.delete(dao.findbyid(prodCon));
            Logback.logger.info("{}.{}|Try: Send record to RESTful", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(returnstatus).build();
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|Exception:UUID-{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/product/insert
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Product product,@Context HttpHeaders headers){
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            String returnstatus=dao.insert(product);
            Logback.logger.info("{}.{}|Try: Send record to RESTful", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(returnstatus).build();
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|Exception:UUID-{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
    //  http://localhost:8080/order/rest/product/update
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Product product,@Context HttpHeaders headers){
        String token=headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0).substring("Bearer ".length()).trim();
        if(!sec.tokenAuthCheck(token))
            return Response.status(Response.Status.UNAUTHORIZED).entity("token not valid").build();
        try {
            String returnstatus=dao.update(product);
            Logback.logger.info("{}.{}|Try: record is Updated",this.getClass().getSimpleName(),Thread.currentThread().getStackTrace()[1].getMethodName());
            return Response.status(Response.Status.OK).entity(returnstatus).build();
        }catch (Exception e){
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|Exception:UUID-{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("Your Trace number is"+UUID+e.toString()).build();
        }
    }
}
/*
    {
            "productCode": "S72_3213",
            "productName": "1950 Paykan IKCO",
            "productLine": "Classic Cars",
            "productScale": "1:70",
            "productVendor": "Iran Musium Car vendor",
            "productDescription": "nicht besonders",
            "quantityInStock": 321,
            "buyPrice": "23.12",
            "MSRP": "30.41"
    }
*/
/*
    {
            "productCode": "S72_3213",
            "productName": "1970 peyote  GLX",
            "productLine": "Classic Cars",
            "productScale": "1:72",
            "productVendor": "Qazvin Musium Car vendor",
            "productDescription": "update fur nicht besonders",
            "quantityInStock": 123,
            "buyPrice": "12.23",
            "MSRP": "41.30"
    }
*/