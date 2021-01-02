<html>
<body>
<h2>Welcome to order projects</h2>
<form action="Dispatcher" method="get">
    Select Form:
    <select name="entity">
        <option value="Employee">Employee</option>
        <option value="Payment">Payment</option>
        <option value="Productline" selected="Productline">Productline</option>
        <option value="Product">Product</option>
        <option value="Office" >Office</option>
        <option value="User">User</option>
        <option value="ProductlineJSP">Productline JSP</option>
    </select>
<input type="submit" value="Show Form">
</form>
<!--<input type="button" value="Show Employees" onclick="location.href='WEB-INF/views/Employee.jsp';"/>-->

</body>
</html>
