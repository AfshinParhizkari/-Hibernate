<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 31
  @Time        6:16 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  JSTL
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Product form</title>
</head>
<body>
<form action="Dispatcher" method="get">
    <input type="button" value="Home" onclick="location.href='index.jsp';">
    <input type="hidden" name="entity" value="ProductMerge">
    <input type="submit" value="Add">
</form>
<form action="ProductAct" method="post">
    Product : <input type="text" name="proNum">
    <input type="hidden" name="crud" value="read">
    <input type="submit" value="ShowProduct">
</form>
<c:if test="${requestScope.message ne null}">
    <c:out value="${requestScope.message}"></c:out>
</c:if><table border="1px">
<table border="1px">
    <tr>
        <td>productCode</td>
        <td>productName</td>
        <td>productLine</td>
        <td>productScale</td>
        <td>productVendor</td>
        <td>productDescription</td>
        <td>quantityInStock</td>
        <td>buyPrice</td>
        <td>MSRP</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:if test="${requestScope.products !=null}">
        <c:forEach var="product" items="${requestScope.products}">
            <c:if test="${not empty product}">
            <tr>
           <td><c:out value="${product.productCode}"/></td>
           <td><c:out value="${product['productName']}"/></td>
           <td><c:out value="${product.productLine}"/></td>
           <td><c:out value="${product.productScale}"/></td>
           <td><c:out value="${product.productVendor}"/></td>
           <td><c:out value="${product.productDescription}"/></td>
           <td><c:out value="${product.quantityInStock}"/></td>
           <td><c:out value="${product.buyPrice}"/></td>
           <td><c:out value="${product.MSRP}"/></td>
           <td><a href="ProductAct?proNum=${product.productCode}&crud=edit">edit</a></td>
           <td><a href="ProductAct?proNum=${product.productCode}&crud=delete">delete</a></td>
           </tr>
            </c:if>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
