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
import com.afshin.General.Logback;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductAct",urlPatterns = {"/api/ProductAct"})
public class ProductCon extends HttpServlet {
    List<Product> products = new ArrayList<>();
    ProductDao dao = new ProductDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {if (!SecurityAPI.isLogin(req)) {req.getRequestDispatcher("/index.jsp").forward(req, resp);return;}
            products.clear();
            String action = req.getParameter("crud");
            if (action.equals("read")) {
                String productCode = req.getParameter("proNum");
                if (productCode.isEmpty()) products = dao.findall();
                else products.add(dao.findbyid(productCode));
                if(products.isEmpty() || products.get(0)==null)
                    req.setAttribute("message", "There is no record");
                else
                    req.setAttribute("message", "record(s) is fetched");
            }
            if (action.equals("add")) {
                Product product = new Product();
                product.setProductCode(req.getParameter("proNum"));
                product.setProductName(req.getParameter("proNam"));
                product.setProductLine(req.getParameter("proLin"));
                product.setProductScale(req.getParameter("proScal"));
                product.setProductVendor(req.getParameter("proVendor"));
                product.setProductDescription(req.getParameter("proDesc"));
                product.setQuantityInStock(Integer.parseInt(req.getParameter("qntityStok")));
                product.setBuyPrice(new BigDecimal(req.getParameter("buyPric")));
                product.setMSRP(new BigDecimal(req.getParameter("msrp")));
                String status=dao.insert(product);
                if(status.equals(product.getProductCode())) req.setAttribute("message", "record is Added");
                else req.setAttribute("message", "record is not Added");
                products.add(dao.findbyid(status));
            }
            if (action.equals("update")) {
                Product product = new Product();
                product.setProductCode(req.getParameter("proNum"));
                product.setProductName(req.getParameter("proNam"));
                product.setProductLine(req.getParameter("proLin"));
                product.setProductScale(req.getParameter("proScal"));
                product.setProductVendor(req.getParameter("proVendor"));
                product.setProductDescription(req.getParameter("proDesc"));
                product.setQuantityInStock(Integer.parseInt(req.getParameter("qntityStok")));
                product.setBuyPrice(new BigDecimal(req.getParameter("buyPric")));
                product.setMSRP(new BigDecimal(req.getParameter("msrp")));
                String status=dao.update(product);
                if(status.equals(product.getProductCode())) req.setAttribute("message", "record is Updated");
                else req.setAttribute("message", "record is not Updated");
                products.add(dao.findbyid(status));
            }
            req.setAttribute("products", products);
            req.getRequestDispatcher("/WEB-INF/views/Product.jsp").forward(req, resp);
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|Exception:UUID-{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            req.setAttribute("ErrorKey", UUID);
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {if (!SecurityAPI.isLogin(req)) {req.getRequestDispatcher("/index.jsp").forward(req, resp);return;}
            products.clear();
            String action = req.getParameter("crud");
            if (action.equals("delete")) {
                Integer status = dao.delete(dao.findbyid(req.getParameter("proNum")));
                if(status==1) {
                    req.setAttribute("message", "record is deleted");
                    req.getRequestDispatcher("/WEB-INF/views/Product.jsp").forward(req, resp);
                }else{
                    req.setAttribute("message", "record is not deleted");
                    req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
                }
            }
            if (action.equals("edit")) {
                Product product = dao.findbyid(req.getParameter("proNum"));
                req.setAttribute("product", product);
                req.getRequestDispatcher("/WEB-INF/views/ProductMerge.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            String UUID= java.util.UUID.randomUUID().toString();
            Logback.logger.error("{}.{}|Exception:UUID-{}", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            e.printStackTrace();
            req.setAttribute("ErrorKey", UUID);
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
        }
    }
}