<%--@Project     order
@Author      Afshin Parhizkari
@Date        2020 - 12 - 16
@Time        7:08 PM
Created by   IntelliJ IDEA
Email:       Afshin.Parhizkari@gmail.com
Description: JSTL
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Productline form</title>
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
<table border="1px">
    <tr>
        <td>productLine</td>
        <td>textDescription</td>
        <td>htmlDescription</td>
        <td>image</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:if test="${requestScope.products ne null}">
        <c:forEach var="proline" items="${requestScope.products}">
            <c:if test="${not empty proline}">
                <tr>
                    <td><c:out value="${proline.productLine}"></c:out></td>
                    <td><c:out value="${proline.textDescription}"></c:out></td>
                    <td><c:out value="${proline.htmlDescription}"></c:out></td>
                    <td><c:if test="${not empty proline.image}">
                            <img src="data:image/jpg+jpeg+png+gif;base64,${proline.photo}" width="200" height="200">
                        </c:if>
                    </td>
                    <td><a href="/ProductlineAct?proline=${proline.productLine}&crud=edit">edit</a></td>
                    <td><a href="/ProductlineAct?proline=${proline.productLine}&crud=delete">delete</a></td>
                </tr>
            </c:if>
        </c:forEach>
    </c:if>
</table>
</body>
</html>