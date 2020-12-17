<%@ page import="com.afshin.Entity.Productline" %>
<%@ page import="java.util.Base64" %><%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 16
  @Time        11:11 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Productline Add or Update</title>
</head>
<body>
<form action="/Dispatcher" method="get">
    <input type="hidden" name="entity" value="Productline">
    <input type="submit" value="Back">
</form>
</br>
<form action="/ProductlineAct" method="post" enctype="multipart/form-data">
    <%
        Productline productline = (Productline) request.getAttribute("productline");
        if(productline ==null){
    %>
    Product code: <input type="text" name="proline"><br>
    Description: <input type="text" name="txtDesc"><br>
    Url: <input type="text" name="htmDesc"><br>
    Select Image: <input type="file" name="img" size="50"><br>
    <input type="hidden" value="add" name="crud">
    <input type="submit" value="Add">
    <%}else{%>
    <input type="hidden" name="proline" value="<%=productline.getProductLine()%>"><br>
    Description: <input type="text" name="txtDesc" value="<%=productline.getTextDescription()%>"><br>
    Url: <input type="text" name="htmDesc" value="<%=productline.getHtmlDescription()%>"><br>
    Image: <img src="data:image/jpg+jpeg+png+gif;base64,<%=Base64.getEncoder().encodeToString(productline.getImage())%>" width="200" height="200"><br>
    Change Image: <input type="file" name="img" size="50"><br>
    <input type="hidden" value="update" name="crud">
    <input type="submit" value="Update">
    <%}%>
</form>

</body>
</html>
