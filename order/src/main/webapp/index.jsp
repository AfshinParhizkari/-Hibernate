<html>
<body>
<h2>Welcome to order projects</h2>
<form action="Dispatcher" method="get">
    Select Form:
    <select name="entity">
        <option value="Employee">Employee</option>
        <option value="Payment">Payment</option>
        <option value="Productline">Productline</option>
        <option value="Product" selected="Product">Product</option>
        <option value="User">User</option>
    </select>
<input type="submit" value="Show Form">
</form>
<!--<input type="button" value="Show Employees" onclick="location.href='WEB-INF/views/Employee.jsp';"/>-->

</body>
</html>
