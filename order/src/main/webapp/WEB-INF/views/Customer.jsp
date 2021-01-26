<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 31
  @Time        6:17 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  JSTL
--%>
<html>
<head>
    <title>Customer form</title>
</head>
<body>
<form action="/Dispatcher" method="get">
    <input type="button" value="Home" onclick="location.href='index.jsp';">
    <input type="hidden" name="entity" value="CustomerMerge">
    <input type="submit" value="Add">
</form>
<form action="CustomerAct" method="post">
    Productline : <input type="text" name="custnum">
    <input type="hidden" name="crud" value="read">
    <input type="submit" value="ShowCustomer">
</form>
<form action="CustomerAct" method="get">
    <input type="hidden" name="crud" value="report">
    <input type="submit" value="Report - Allcustomer">
</form>
<table border="1px" style="color: darkgreen">
    <tr>
        <td>customerNumber</td>
        <td>customerName</td>
        <td>contactLastName</td>
        <td>contactFirstName</td>
        <td>phone</td>
        <td>addressLine1</td>
        <td>addressLine2</td>
        <td>city</td>
        <td>state</td>
        <td>postalCode</td>
        <td>country</td>
        <td>salesRepEmployeeNumber</td>
        <td>creditLimit</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:if test="${requestScope.customers ne null}">
        <c:forEach items="${requestScope.customers}" var="customer">
            <c:if test="${customer ne null}">
            <tr>
                <td><c:out value="${customer.customerNumber}"></c:out></td>
                <td><c:out value="${customer.customerName}"></c:out></td>
                <td><c:out value="${customer.contactLastName}"></c:out></td>
                <td><c:out value="${customer.contactFirstName}"></c:out></td>
                <td><c:out value="${customer.phone}"></c:out></td>
                <td><c:out value="${customer.addressLine1}"></c:out></td>
                <td><c:out value="${customer.addressLine2}"></c:out></td>
                <td><c:out value="${customer.city}"></c:out></td>
                <td><c:out value="${customer.state}"></c:out></td>
                <td><c:out value="${customer.postalCode}"></c:out></td>
                <td><c:out value="${customer.country}"></c:out></td>
                <td><c:out value="${customer.salesRepEmployeeNumber}"></c:out></td>
                <td><c:out value="${customer.creditLimit}"></c:out></td>
                <td><a href="/CustomerAct?custnum=${customer.customerNumber}&crud=edit" >edit</a></td>
                <td><a href="/CustomerAct?custnum=${customer.customerNumber}&crud=delete">delete</a></td>
            </tr>
            </c:if>
        </c:forEach>
    </c:if>
</table>
</body>
</html>