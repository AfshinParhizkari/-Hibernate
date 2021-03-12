<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:if test="${sessionScope.message eq null}">
    <label>You have not login. please login to order projects</label>
</c:if>
<c:if test="${sessionScope.message ne null}">
    <label>${sessionScope.message}</label>
</c:if>

<form action="${pageContext.request.contextPath}/api/Dispatcher" method="post">
    <br>User name:<input name="usrnam" type="text"><br>
    Password: <input name="paswrd" type="password"><br>
    <input name="crud" type="hidden" value="login"><br>
    <input type="submit" value="Login">
</form>
<form action="${pageContext.request.contextPath}/api/Dispatcher" method="post">
    <input name="crud" type="hidden" value="logout">
    <input type="submit" value="Logout">
</form>
<form action="${pageContext.request.contextPath}/api/Dispatcher" method="post">
    <input type="button" value="Call User Service" onclick="location.href='rest/user/all';">
    <input name="crud" type="hidden" value="test">
    <input type="submit" value="Test">
</form>

<form action="${pageContext.request.contextPath}/api/Dispatcher" method="get">
    <br>Select Form:
    <select name="entity">
        <option value="Employee">Employee</option>
        <option value="Customer" selected="Customer">Customer</option>
        <option value="Order" >Order</option>
        <option value="Orderdetail">Orderdetail</option>
        <option value="Payment">Payment</option>
        <option value="Productline">Productline</option>
        <option value="Product">Product</option>
        <option value="Office" >Office</option>
        <option value="User">User</option>
    </select>
<input type="submit" value="Show Form">
</form>
</body>
</html>
