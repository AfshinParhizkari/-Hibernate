<%@ page import="com.afshin.Entity.Employee" %><%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 15
  @Time        4:44 AM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/EmployeeAct" method="post">
    <%
        Employee employee = (Employee) request.getAttribute("employee");
        if(employee ==null){
    %>
    EmployeeNumber: <input type="number" name="empnum"><br>
    LastName: <input type="text" name="lname"><br>
    FirstName: <input type="text" name="fname"><br>
    Extension: <input type="text" name="exten"><br>
    Email: <input type="text" name="email"><br>
    OfficeCode: <input type="text" name="offcode"><br>
    Reportto: <input type="number" name="repto"><br>
    JobTitle: <input type="text" name="jobtit"><br><br>
    <input type="submit" value="add">
    <input type="hidden" value="add" name="crud">
    <%}else{%>
    <input type="hidden" value="<%=employee.getEmployeeNumber()%>" name="empnum">
    LastName: <input value="<%=employee.getLastName()%>" name="lname"><br>
    FirstName: <input value="<%=employee.getFirstName()%>" name="fname"><br>
    Extension: <input value="<%=employee.getExtension()%>" name="exten"><br>
    Email: <input value="<%=employee.getEmail()%>" name="email"><br>
    OfficeCode: <input value="<%=employee.getOfficeCode()%>" name="offcode"><br>
    Reportto: <input value="<%=employee.getReportsTo()%>" name="repto"><br>
    JobTitle: <input value="<%=employee.getJobTitle()%>" name="jobtit"><br><br>
    <input type="hidden" name="crud" value="update">
    <input type="submit" value="update">
    <%}%>

</form>
</body>
</html>
