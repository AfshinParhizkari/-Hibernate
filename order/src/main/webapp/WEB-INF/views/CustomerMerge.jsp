<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
    <title>Customer Add or Update</title>
</head>
<body>
<form action="/Dispatcher" method="get">
    <input type="hidden" name="entity" value="Customer">
    <input type="submit" value="Back">
</form>
</br>
<form action="CustomerAct" method="post">
    <c:if test="${requestScope.customer == null}">
        CustomerNumber: <input type="number" name="custnum" required="required"><br>
        CustomerName: <input type="text" name="custname" required><br>
        ContactLastName: <input type="text" name="conlname" required="required"><br>
        ContactFirstName: <input type="text" name="confname" required="required"><br>
        Phone: <input type="text" name="phone" required="required"><br>
        AddressLine1: <input type="text" name="addl1" required="required"><br>
        AddressLine2: <input type="text" name="addl2"><br>
        City: <input type="text" name="city" required="required"><br>
        State: <input type="text" name="state"><br>
        PostalCode: <input type="text" name="poscode"><br>
        Country: <input type="text" name="count" required="required"><br>
        SalesRepEmployeeNumber: <input type="number" name="srempnum"><br>
        CreditLimit: <input type="number" name="credlim"><br><br>
        <input type="hidden" name="crud" value="add">
        <input type="submit" value="Add">
    </c:if>
    <c:if test="${requestScope.customer != null}">
        <input type="hidden" value="${requestScope.customer.customerNumber}" name="custnum">
        CustomerName: <input value="${requestScope.customer.customerName}" type="text" name="custname" required="required"><br>
        ContactLastName: <input value="${requestScope.customer.contactLastName}" type="text" name="conlname" required="required"><br>
        ContactFirstName: <input value="${requestScope.customer.contactFirstName}" type="text" name="confname" required="required"><br>
        Phone: <input value="${requestScope.customer.phone}" type="text" name="phone" required="required"><br>
        AddressLine1: <input value="${requestScope.customer.addressLine1}" type="text" name="addl1" required="required"><br>
        AddressLine2: <input value="${requestScope.customer.addressLine2}" type="text" name="addl2"><br>
        City: <input value="${requestScope.customer.city}" type="text" name="city" required="required"><br>
        State: <input value="${requestScope.customer.state}" type="text" name="state"><br>
        PostalCode: <input value="${requestScope.customer.postalCode}" type="text" name="poscode"><br>
        Country: <input value="${requestScope.customer.country}" type="text" name="count" required="required"><br>
        SalesRepEmployeeNumber: <input value="${requestScope.customer.salesRepEmployeeNumber}" type="number" name="srempnum"><br>
        CreditLimit: <input value="${requestScope.customer.creditLimit}" type="number" name="credlim"><br><br>
        <input type="hidden" name="crud" value="update">
        <input type="submit" value="Update">
    </c:if>
</form>
</body>
</html>