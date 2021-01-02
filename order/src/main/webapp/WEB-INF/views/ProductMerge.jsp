<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 31
  @Time        6:16 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Product Add or Update</title>
</head>
<body>
<form action="/Dispatcher" method="get">
    <input type="hidden" name="entity" value="Product">
    <input type="submit" value="Back">
</form>
<br>
<form action="/ProductAct" method="post">
    <c:if test="${empty product}">
        Product code : <input type="text" name="proNum"><br>
        Product Name : <input type="text" name="proNam"><br>
        Product Line : <input type="text" name="proLin"><br>
        Product Scale: <input type="text" name="proScal"><br>
        Product Vendor: <input type="text" name="proVendor"><br>
        Product Desc: <input type="text" name="proDesc"><br>
        Quantity stock: <input type="number" name="qntityStok"><br>
        Buy Price: <input type="number" name="buyPric"><br>
        MSRP : <input type="number" name="msrp"><br>
        <input type="hidden" name="crud" value="add">
        <input type="submit" value="Add">
    </c:if>
    <c:if test="${product ne null}">
        Product code : <input type="text" name="proNum" value="${product.productCode}"><br>
        Product Name : <input type="text" name="proNam" value="${product.productName}"><br>
        Product Line : <input type="text" name="proLin" value="${product.productLine}"><br>
        Product Scale: <input type="text" name="proScal" value="${product.productScale}"><br>
        Product Vendor: <input type="text" name="proVendor" value="${product.productVendor}"><br>
        Product Desc: <input type="text" name="proDesc" value="${product.productDescription}"><br>
        Quantity stock: <input type="number" name="qntityStok" value="${product.quantityInStock}"><br>
        Buy Price: <input type="number" name="buyPric" value="${product.buyPrice}"><br>
        MSRP : <input type="number" name="msrp" value="${product.MSRP}"><br>
        <input type="hidden" value="update" name="crud">
        <input type="submit" value="Update">
    </c:if>
</form>
</body>
</html>