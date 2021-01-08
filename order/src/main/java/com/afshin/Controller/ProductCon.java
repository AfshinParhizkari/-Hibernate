package com.afshin.Controller;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 31
 * @Time 6:11 PM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.afshin.Dao.ProductDao;
import com.afshin.Entity.Product;
import com.afshin.General.GeneralFunc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductAct",urlPatterns = {"/ProductAct"})
public class ProductCon extends HttpServlet {
    List<Product> products=new ArrayList<>();
    ProductDao dao=new ProductDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        products.clear();
        String action =req.getParameter("crud");
        if(action.equals("read")) {
            String productCode =req.getParameter("proNum");
            if(productCode.isEmpty()) products =dao.findall();
            else products.add(dao.findbyid(productCode));
        }
        if(action.equals("add")) {
            Product product =new Product();
            product.setProductCode(req.getParameter("proNum"));
            product.setProductName(req.getParameter("proNam"));
            product.setProductLine(req.getParameter("proLin"));
            product.setProductScale(req.getParameter("proScal"));
            product.setProductVendor(req.getParameter("proVendor"));
            product.setProductDescription(req.getParameter("proDesc"));
            product.setQuantityInStock(Integer.parseInt(req.getParameter("qntityStok")));
            product.setBuyPrice(new BigDecimal(req.getParameter("buyPric")));
            product.setMSRP(new BigDecimal(req.getParameter("msrp")));
            dao.insert(product);
            products.add(product);
        }
        if(action.equals("update")) {
            Product product =dao.findbyid(req.getParameter("proNum"));
            product.setProductName(req.getParameter("proNam"));
            product.setProductLine(req.getParameter("proLin"));
            product.setProductScale(req.getParameter("proScal"));
            product.setProductVendor(req.getParameter("proVendor"));
            product.setProductDescription(req.getParameter("proDesc"));
            product.setQuantityInStock(Integer.parseInt(req.getParameter("qntityStok")));
            product.setBuyPrice(new BigDecimal(req.getParameter("buyPric")));
            product.setMSRP(new BigDecimal(req.getParameter("msrp")));
            dao.update(product);
            products.add(product);
        }
        req.setAttribute("products",products);
        req.getRequestDispatcher("WEB-INF/views/Product.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        products.clear();
        String action =req.getParameter("crud");
        if(action.equals("delete")){
            dao.delete(dao.findbyid(req.getParameter("proNum")));
            req.getRequestDispatcher("WEB-INF/views/Product.jsp").forward(req,resp);
        }
        if(action.equals("edit")){
            Product product=dao.findbyid(req.getParameter("proNum"));
            req.setAttribute("product",product);
            req.getRequestDispatcher("WEB-INF/views/ProductMerge.jsp").forward(req,resp);
        }
    }
}
