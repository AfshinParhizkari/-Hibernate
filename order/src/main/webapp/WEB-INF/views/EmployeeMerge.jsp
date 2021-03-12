<%@ page import="com.afshin.Entity.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 15
  @Time        4:44 AM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<html>
<head>
    <title>Add or Update Employee</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/api/Dispatcher" method="get">
    <input type="hidden" name="entity" value="Employee">
    <input type="submit" value="Back">
</form>
</br>
<form action="EmployeeAct" method="post">
    <%
        Employee employee = (Employee) request.getAttribute("employee");
        if(employee ==null){
    %>
    EmployeeNumber: <input type="number" name="empnum" required="required"><br>
    LastName: <input type="text" name="lname" required="required"><br>
    FirstName: <input type="text" name="fname" required="required"><br>
    Extension: <input type="text" name="exten" required="required"><br>
    Email: <input type="text" name="email" required="required"><br>
    OfficeCode: <input type="text" name="offcode" required="required"><br>
    Reportto: <input type="number" name="repto" required="required"><br>
    JobTitle: <input type="text" name="jobtit" required="required"><br><br>
    <input type="hidden" value="add" name="crud">
    <input type="submit" value="Add">
    <%}else{%>
    <input type="hidden" value="<%=employee.getEmployeeNumber()%>" name="empnum">
    LastName: <input value="<%=employee.getLastName()%>" name="lname" required="required"><br>
    FirstName: <input value="<%=employee.getFirstName()%>" name="fname" required="required"><br>
    Extension: <input value="<%=employee.getExtension()%>" name="exten" required="required"><br>
    Email: <input value="<%=employee.getEmail()%>" name="email" required="required"><br>
    OfficeCode: <input value="<%=employee.getOfficeCode()%>" name="offcode" required="required"><br>
    Reportto: <input value="<%=employee.getReportsTo()%>" name="repto" required="required"><br>
    JobTitle: <input value="<%=employee.getJobTitle()%>" name="jobtit" required="required"><br><br>
    <input type="hidden" name="crud" value="update">
    <input type="submit" value="Update">
    <%}%>
</form>
</body>
</html>