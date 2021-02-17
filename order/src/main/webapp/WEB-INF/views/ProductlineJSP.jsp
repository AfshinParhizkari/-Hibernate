<%--@Project     order
@Author      Afshin Parhizkari
@Date        2020 - 12 - 16
@Time        7:08 PM
Created by   IntelliJ IDEA
Email:       Afshin.Parhizkari@gmail.com
Description: JSP
--%>

<%@ page import="com.afshin.Entity.Productline" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Productline JSP form</title>
</head>
<body>
<form action="/Dispatcher" method="get">
    <input type="button" value="Home" onclick="location.href='index.jsp';">
    <input type="hidden" name="entity" value="ProductlineMerge">
    <input type="submit" value="Add">
</form>
<form action="/ProductlineAct" method="post">
    Productline : <input type="text" name="prolineNum">
    <input type="hidden" name="crud" value="read">
    <input type="submit" value="ShowProductline">
</form>
<%
    String msg = (String) request.getAttribute("message");
    if(msg!=null)
        out.print(msg);
%>
<table border="1px">
    <tr>
        <td>productLine</td>
        <td>textDescription</td>
        <td>htmlDescription</td>
        <td>image</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <%
        List<Productline> productlineList = (List<Productline>) request.getAttribute("products");
        if (productlineList != null){
        for (Productline productline : productlineList){
            if (productline != null){
    %>
    <tr>
        <td><%=productline.getProductLine()%></td>
        <td><%=productline.getTextDescription()%></td>
        <td><%=productline.getHtmlDescription()%></td>
        <td>
        <%if(productline.getImage()!=null){%>
            <img src="data:image/jpg+jpeg+png+gif;base64,<%=Base64.getEncoder().encodeToString(productline.getImage())%>" width="200" height="200">
        <%}%>
        </td>
        <td><a href="/ProductlineAct?proline=<%=productline.getProductLine()%>&crud=edit">edit</a></td>
        <td><a href="/ProductlineAct?proline=<%=productline.getProductLine()%>&crud=delete">delete</a></td>
    </tr>
    <%}}}%>
</table>
</body>
</html>