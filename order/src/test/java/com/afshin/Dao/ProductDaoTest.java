package com.afshin.Dao;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 01
 * @Time 3:36 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Entity.Product;
import com.afshin.Dao.ProductDao;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class ProductDaoTest {
    ProductDao dao=new ProductDao();
    @Test
    public void findallTest() {
        List<Product> productList=dao.findall();
        for(Product product:productList) System.out.println(product);
    }
    @Test
    public void findbyidTest() {
        Product product=dao.findbyid("S18_1589");
        System.out.println(product);
    }
    @Test
    public void someColumnTest(){
        List<Object[]> someatribute=dao.someColumn();
        for(int i=0;i<someatribute.size();i++)
            System.out.println("productCode: "+someatribute.get(i)[0]+" , productName: "+someatribute.get(i)[1]+
                    " , productLine:"+someatribute.get(i)[2]);
    }
    @Test
    public void wherClauseTest(){
        List<Object[]> someatribute=dao.whereClause("Sup");
        for(int i=0;i<someatribute.size();i++)
            System.out.println("productCode: "+someatribute.get(i)[0]+" , productName: "+someatribute.get(i)[1]+
                    " , productLine:"+someatribute.get(i)[2]);
    }
    @Test
    public void aggregationTest(){
        List<Object[]> someatribute=dao.aggregation();
        for(int i=0;i<someatribute.size();i++)
            System.out.println("productLine: "+someatribute.get(i)[0]+" , Count: "+someatribute.get(i)[1]+
                    " , Sum:"+someatribute.get(i)[2]);

    }
    @Test
    public void JoinQueryTest(){
        List<Object[]> someatribute=dao.joinedQuery();
        for(int i=0;i<someatribute.size();i++)
            System.out.println("productCode: "+someatribute.get(i)[0]+" , productLine: "+someatribute.get(i)[1]+
                    " , textDescription:"+someatribute.get(i)[2]);

    }
    @Test
    public void subqueryTest() {
        List<Product> productList=dao.subQuery();
        for(Product product:productList) System.out.println(product);
    }
    @Test
    public void insertTest(){
        Product product=new Product();
        product.setProductCode("S72_3213");
        product.setProductName("1950 Paykan IKCO");
        product.setProductLine("Classic Cars");
        product.setProductScale("1:72");
        product.setProductVendor("Iran Musium Car vendor");
        product.setProductDescription("nicht besonders");
        product.setQuantityInStock(321);
        product.setBuyPrice(new BigDecimal("23.12"));
        product.setMSRP(new BigDecimal("30.41"));
        dao.insert(product);
    }
    @Test
    public void updateTest(){
        Product product=dao.findbyid("S72_3213");
        product.setProductName("1970 peyote  GLX");
        product.setProductLine("Classic Cars");
        product.setProductScale("1:72");
        product.setProductVendor("Qazvin Musium Car vendor");
        product.setProductDescription("update fur nicht besonders");
        product.setQuantityInStock(123);
        product.setBuyPrice(new BigDecimal("12.23"));
        product.setMSRP(new BigDecimal("41.30"));
        dao.update(product);
    }
    @Test
    public void deleteTest(){
        Product product=dao.findbyid("S72_3213");
        dao.delete(product);
    }
}