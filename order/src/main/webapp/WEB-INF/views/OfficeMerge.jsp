<%@ page import="com.afshin.Entity.Office" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 31
  @Time        6:19 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<html>
<head>
    <title>Add or Update Office</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/api/Dispatcher" method="get">
    <input type="hidden" name="entity" value="Office">
    <input type="submit" value="Back">
</form>
</br>
<form action="${pageContext.request.contextPath}/api/OfficeAct" method="post">
    <%
        Office office = (Office) request.getAttribute("office");
        if(office ==null){
    %>
    OfficeCode: <input type="text" name="offcode" required="required"><br>
    City: <input type="text" name="city" required="required"><br>
    Phone: <input type="tofficesext" name="phone" required="required"><br>
    AddressLine1: <input type="text" name="addl1" required="required"><br>
    AddressLine2: <input type="text" name="addl2"><br>
    State: <input type="text" name="state"><br>
    Country: <input type="text" name="coun" required="required"><br>
    PostalCode: <input type="text" name="pcode" required="required"><br>
    Territory: <input type="text" name="ter" required="required"><br><br>
    <input type="hidden" value="add" name="crud">
    <input type="submit" value="Add">
    <%}else{%>
    <input type="hidden" value="<%=office.getOfficeCode()%>" name="offcode">
    City: <input value="<%=office.getCity()%>" type="text" name="city" required="required"><br>
    Phone: <input value="<%=office.getPhone()%>" type="text" name="phone" required="required"><br>
    AddressLine1: <input value="<%=office.getAddressLine1()%>" type="text" name="addl1" required="required"><br>
    AddressLine2: <input value="<%=office.getAddressLine2()%>" type="text" name="addl2"><br>
    State: <input value="<%=office.getState()%>" type="text" name="state"><br>
    Country: <input value="<%=office.getCountry()%>" type="text" name="coun" required="required"><br>
    PostalCode: <input value="<%=office.getPostalCode()%>" type="text" name="pcode" required="required"><br>
    Territory: <input value="<%=office.getTerritory()%>" type="text" name="ter" required="required"><br><br>
    <input type="hidden" value="update" name="crud">
    <input type="submit" value="Update">
    <%}%>
</form>

</body>
</html>
