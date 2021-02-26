package com.afshin.Webservice;

import com.afshin.Dao.ProductDao;
import com.afshin.Entity.Product;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/product")
public class ProductWs {
    private ProductDao dao = new ProductDao();
    private List<Product> productList = new ArrayList<>();

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findall() {
        productList.clear();
        productList = dao.findall();
        return productList;
    }
}