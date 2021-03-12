<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.afshin.Entity.Productline" %>
<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page isELIgnored="false" %>
<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 16
  @Time        11:11 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description: JSTL
--%>
<html>
<head>
    <title>Productline Add or Update</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/api/Dispatcher" method="get">
    <input type="hidden" name="entity" value="Productline">
    <input type="submit" value="Back">
</form>
</br>
<form action="${pageContext.request.contextPath}/api/ProductlineAct" method="post" enctype="multipart/form-data">
    <c:if test="${requestScope.productline eq null}">
        Product code: <input type="text" name="proline" required="required"><br>
        Description: <input type="text" name="txtDesc"><br>
        Url: <input type="text" name="htmDesc"><br>
        Select Image: <input type="file" name="img" size="50"><br>
        <input type="hidden" value="add" name="crud">
        <input type="submit" value="Add">
    </c:if>
    <c:if test="${requestScope.productline ne null}">
        <input type="hidden" name="proline" value="${requestScope.productline.productLine}"><br>
        Description: <input type="text" name="txtDesc" value="${requestScope.productline.textDescription}"><br>
        Url: <input type="text" name="htmDesc" value="${requestScope.productline.htmlDescription}"><br>
        <c:if test="${not empty productline.image}">
            Image: <img src="data:image/jpg+jpeg+png+gif;base64,${productline.photo}" width="200" height="200"><br>
        </c:if>
        Change Image: <input type="file" name="img" size="50"><br>
        <input type="hidden" value="update" name="crud">
        <input type="submit" value="Update">
    </c:if>
</form>
</body>
</html>