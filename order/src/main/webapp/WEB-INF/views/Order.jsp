<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="afy" uri="http://afshin.com" %>
<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 31
  @Time        6:17 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<html>
<head>
    <title>Customer form</title>
</head>
<body>
<form action="/Dispatcher" method="get">
    <input type="button" value="Home" onclick="location.href='index.jsp';">
    <input type="hidden" name="entity" value="OrderMerge">
    <input type="submit" value="Add">
</form>
<form action="OrderAct" method="post">
    Productline : <input type="text" name="ordnum">
    <input type="hidden" name="crud" value="read">
    <input type="submit" value="ShowOrder">
</form>
<table border="1px">
    <tr>
        <td>OrderNumber</td>
        <td>OrderDate</td>
        <td>RequiredDate</td>
        <td>ShippedDate</td>
        <td>Status</td>
        <td>Comments</td>
        <td>CustomerNumber</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:if test="${requestScope.orders ne null}">
        <c:forEach var="order" items="${requestScope.orders}">
            <c:if test="${not empty order}">
            <tr>
                <td><c:out value="${order.orderNumber}"></c:out></td>
                <td>${afy:shamsiStr(order.orderDate)}</td>
                <td>${afy:shamsiStr(order.requiredDate)}</td>
                <td>${afy:shamsiStr(order.shippedDate)}</td>
                <td><c:out value="${order.status}"></c:out></td>
                <td><c:out value="${order.comments}"></c:out></td>
                <td><c:out value="${order.customerNumber}"></c:out></td>
                <td><a href="/OrderAct?onum=${order.orderNumber}&crud=edit">edit</a></td>
                <td><a href="/OrderAct?onum=${order.orderNumber}&crud=delete">delete</a></td>
            </tr>
            </c:if>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
