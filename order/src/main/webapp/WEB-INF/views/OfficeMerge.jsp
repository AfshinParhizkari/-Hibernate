<%@ page import="com.afshin.Entity.Office" %><%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 31
  @Time        6:19 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add or Update Office</title>
</head>
<body>
<form action="/Dispatcher" method="get">
    <input type="hidden" name="entity" value="Office">
    <input type="submit" value="Back">
</form>
</br>
<form action="/OfficeAct" method="post">
    <%
        Office office = (Office) request.getAttribute("office");
        if(office ==null){
    %>
    OfficeCode: <input type="text" name="offcode"><br>
    City: <input type="text" name="city"><br>
    Phone: <input type="text" name="phone"><br>
    AddressLine1: <input type="text" name="addl1"><br>
    AddressLine2: <input type="text" name="addl2"><br>
    State: <input type="text" name="state"><br>
    Country: <input type="text" name="coun"><br>
    PostalCode: <input type="text" name="pcode"><br>
    Territory: <input type="text" name="ter"><br><br>
    <input type="hidden" value="create" name="crud">
    <input type="submit" value="Add">
    <%}else{%>
    <input type="hidden" value="<%=office.getOfficeCode()%>" name="offcode">
    City: <input value="<%=office.getCity()%>" type="text" name="city"><br>
    Phone: <input value="<%=office.getPhone()%>" type="text" name="phone"><br>
    AddressLine1: <input value="<%=office.getAddressLine1()%>" type="text" name="addl1"><br>
    AddressLine2: <input value="<%=office.getAddressLine2()%>" type="text" name="addl2"><br>
    State: <input value="<%=office.getState()%>" type="text" name="state"><br>
    Country: <input value="<%=office.getCountry()%>" type="text" name="coun"><br>
    PostalCode: <input value="<%=office.getPostalCode()%>" type="text" name="pcode"><br>
    Territory: <input value="<%=office.getTerritory()%>" type="text" name="ter"><br><br>
    <input type="hidden" value="update" name="crud">
    <input type="submit" value="Update">
    <%}%>
</form>

</body>
</html>
