<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 31
  @Time        6:18 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<html>
<head>
    <title>Customer form</title>
</head>
<body>
<form action="Dispatcher" method="get">
    <input type="button" value="Home" onclick="location.href='index.jsp';">
    <input type="hidden" name="entity" value="OrderdetailMerge">
    <input type="submit" value="Add">
</form>
<form action="OrderdetailAct" method="post">
    Order Number: <input type="number" name="ordnum">
    Product Code: <input type="text" name="procode">
    <input type="hidden" name="crud" value="read">
    <input type="submit" value="ShowOrderdetail">
</form>
<c:if test="${requestScope.message ne null}">
    <c:out value="${requestScope.message}"></c:out>
</c:if>
<table border="1px"><table border="1px" style="color: #00aa00">
    <tr>
        <td>OrderNumber</td>
        <td>ProductCode</td>
        <td>QuantityOrdered</td>
        <td>PriceEach</td>
        <td>OrderLineNumber</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
<c:if test="${requestScope.orderdetails ne null}">
    <c:forEach items="${requestScope.orderdetails}" var="orderdetail">
        <c:if test="${orderdetail ne null}">
        <tr>
            <td><c:out value="${orderdetail.orderNumber}"></c:out></td>
            <td><c:out value="${orderdetail.productCode}"></c:out></td>
            <td><c:out value="${orderdetail.quantityOrdered}"></c:out></td>
            <td><c:out value="${orderdetail.priceEach}"></c:out></td>
            <td><c:out value="${orderdetail.orderLineNumber}"></c:out></td>
            <td><a href="OrderdetailAct?ordnum=${orderdetail.orderNumber}&procode=${orderdetail.productCode}&crud=edit">edit</a></td>
            <td><a href="OrderdetailAct?ordnum=${orderdetail.orderNumber}&procode=${orderdetail.productCode}&crud=delete">delete</a></td>
        </tr>
        </c:if>
    </c:forEach>
</c:if>
</table>
</body>
</html>