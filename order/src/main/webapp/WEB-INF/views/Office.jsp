<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 31
  @Time        6:19 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  JSP
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.afshin.Entity.Office" %>

<html>
<head>
    <title>Office form - JSP</title>
</head>
<body>
<form action="/Dispatcher" method="get">
    <input type="button" value="Home" onclick="location.href='index.jsp';">
    <input type="hidden" name="entity" value="OfficeMerge">
    <input type="submit" value="Add">
</form>
<form action="/OfficeAct" method="post">
    Product : <input type="text" name="offcode">
    <input type="hidden" name="crud" value="read">
    <input type="submit" value="ShowProduct">
</form>
<%
    String msg = (String) request.getAttribute("message");
    if(msg!=null)
        out.print(msg);
%><table border="1px">
    <tr>
        <td>OfficeCode</td>
        <td>City</td>
        <td>Phone</td>
        <td>AddressLine1</td>
        <td>AddressLine2</td>
        <td>State</td>
        <td>Country</td>
        <td>PostalCode</td>
        <td>Territory</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <%List<Office> officeList = (List<Office>) request.getAttribute("Offices");
        if (officeList != null){
          for (Office office : officeList){
            if (office != null){
    %>
    <tr>
        <td><%=office.getOfficeCode()%></td>
        <td><%=office.getCity()%></td>
        <td><%=office.getPhone()%></td>
        <td><%=office.getAddressLine1()%></td>
        <td><%=office.getAddressLine2()%></td>
        <td><%=office.getState()%></td>
        <td><%=office.getCountry()%></td>
        <td><%=office.getPostalCode()%></td>
        <td><%=office.getTerritory()%></td>
        <td><a href="/OfficeAct?offcode=<%=office.getOfficeCode()%>&crud=edit">Edit</a></td>
        <td><a href="/OfficeAct?offcode=<%=office.getOfficeCode()%>&crud=delete">Delete</a></td>
    </tr>
    <%}}}%>
</table>
</body>
</html>