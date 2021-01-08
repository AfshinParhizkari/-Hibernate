<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 31
  @Time        6:18 PM
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
    <input type="hidden" name="entity" value="Orderdetail">
    <input type="submit" value="Back">
</form>
</br>
<form action="OrderdetailAct" method="post">
    <c:if test="${requestScope.orderdetail == null}">
       OrderNumber: <input type="number" name="ordnum"><br>
       ProductCode: <input type="text" name="procode"><br>
       QuantityOrdered: <input type="number" name="qord"><br>
       PriceEach: <input type="number" name="pe"><br>
       OrderLineNumber: <input type="number" name="oln"><br><br>
       <input type="hidden" name="crud" value="add">
       <input type="submit" value="Add">
    </c:if>
    <c:if test="${requestScope.orderdetail != null}">
        <input type="hidden" value="${requestScope.orderdetail.orderNumber}" name="ordnum">
        <input type="hidden" value="${requestScope.orderdetail.productCode}" name="procode">
        QuantityOrdered: <input type="number" value="${requestScope.orderdetail.quantityOrdered}" name="quanord">
        PriceEach: <input type="number" value="${requestScope.orderdetail.priceEach}" name="peach">
        OrderLineNumber: <input type="number" value="${requestScope.orderdetail.orderLineNumber}" name="ordlnum">
        <input type="hidden" value="update" name="crud">
        <input type="submit" value="Update">
    </c:if>
</body>
</html>
