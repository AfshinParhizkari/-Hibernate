package com.afshin.Webservice;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 3/7/21
 * @Time 6:51 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductTest {
    @Test
    public void filter() throws JsonProcessingException {
        Product product = new Product();
        product.setProductCode("S10_1601");
        product.setProductName("1999");
        product.setProductLine("Motorcycles");
        product.setProductScale("1:10");
        product.setProductVendor("Min Min Min");
        product.setProductDescription("wow");
        product.setQuantityInStock(777);
        product.setMSRP(new BigDecimal("110.20"));
        product.setBuyPrice(new BigDecimal("77"));
        FilterProvider filters = new SimpleFilterProvider().addFilter("Productfilter",
                SimpleBeanPropertyFilter.filterOutAllExcept(product.getfilters()));
/*        FilterProvider filters = new SimpleFilterProvider().addFilter("Productfilter",SimpleBeanPropertyFilter.filterOutAllExcept(hash_Set));
        String productJson = (new ObjectMapper()).setFilterProvider(filters).setSerializationInclusion(JsonInclude.Include.ALWAYS)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true)
                .writeValueAsString(productList);*/
        ObjectMapper mapper = new ObjectMapper();
        String productJson = mapper.writer(filters).withDefaultPrettyPrinter().writeValueAsString(product);
        //String productJson = mapper.setFilterProvider(filters).writerWithDefaultPrettyPrinter().writeValueAsString(product);
        System.out.println(productJson);
    }
}