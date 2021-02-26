<%@ page import="com.afshin.Entity.User" %><%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 23
  @Time        12:12 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add or Update User</title>
</head>
<body>
<form action="Dispatcher" method="get">
    <input type="hidden" name="entity" value="User">
    <input type="submit" value="Back">
</form>
<form action="UserAct" method="post">
        <%
        User user = (User) request.getAttribute("user");
        if(user ==null){
    %>
        User id: <input name="userid" type="number" required="required"></br>
        Username: <input name="uname" type="text" required="required"></br>
        Password : <input name="pwd" type="text"></br>
        Employeeid : <input name="empid" type="number"></br>
        <input name="crud" type="hidden" value="add"></br>
        <input type="submit" value="AddUser">
    <%}else{%>
       User id: <input name="userid" type="hidden" value="<%=user.getIdusers()%>"></br>
       Username: <input name="uname" type="text" value="<%=user.getUsername()%>" required="required"></br>
       Password : <input name="pwd" type="text" value="<%=user.getPassword()%>"></br>
       Employeeid : <input name="empid" type="number" value="<%=user.getEmployeeid()%>"></br>
       <input name="crud" type="hidden" value="update"></br>
       <input type="submit" value="UserUpdate">
    <%}%>
</form>
</body>
</html>
