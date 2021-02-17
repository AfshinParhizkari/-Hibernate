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
        Product code : <input type="text" name="proNum" required="required"><br>
        Product Name : <input type="text" name="proNam" required="required"><br>
        Product Line : <input type="text" name="proLin" required="required"><br>
        Product Scale: <input type="text" name="proScal" required="required"><br>
        Product Vendor: <input type="text" name="proVendor" required="required"><br>
        Product Desc: <input type="text" name="proDesc" required="required"><br>
        Quantity stock: <input type="number" name="qntityStok" required="required"><br>
        Buy Price: <input type="number" name="buyPric" required="required"><br>
        MSRP : <input type="number" name="msrp" required="required"><br>
        <input type="hidden" name="crud" value="add">
        <input type="submit" value="Add">
    </c:if>
    <c:if test="${product ne null}">
        Product code : <input type="hidden" name="proNum" value="${product.productCode}"><br>
        Product Name : <input type="text" name="proNam" value="${product.productName}" required="required"><br>
        Product Line : <input type="text" name="proLin" value="${product.productLine}" required="required"><br>
        Product Scale: <input type="text" name="proScal" value="${product.productScale}" required="required"><br>
        Product Vendor: <input type="text" name="proVendor" value="${product.productVendor}" required="required"><br>
        Product Desc: <input type="text" name="proDesc" value="${product.productDescription}" required="required"><br>
        Quantity stock: <input type="number" name="qntityStok" value="${product.quantityInStock}" required="required"><br>
        Buy Price: <input type="number" name="buyPric" value="${product.buyPrice}" required="required"><br>
        MSRP : <input type="number" name="msrp" value="${product.MSRP}" required="required"><br>
        <input type="hidden" value="update" name="crud">
        <input type="submit" value="Update">
    </c:if>
</form>
</body>
</html>