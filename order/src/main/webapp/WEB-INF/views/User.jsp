<%@ page import="com.afshin.Entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 23
  @Time        12:12 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<html>
<head>
    <title>User form</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/api/Dispatcher" method="get">
    <input type="button" value="Home" onclick="location.href='${pageContext.request.contextPath}/index.jsp';">
    <input type="hidden" name="entity" value="UserMerge">
    <input type="submit" value="Add">
</form>
<form action="${pageContext.request.contextPath}/api/UserAct" method="post">
    Userid : <input type="text" name="userid">
    <input type="hidden" name="crud" value="read">
    <input type="submit" value="ShowUser">
</form>
<%
    String msg = (String) request.getAttribute("message");
    if(msg!=null)
        out.print(msg);
%>
<table border="1px">
    <tr>
        <td>userid</td>
        <td>username</td>
        <td>password</td>
        <td>employeeid</td>
        <td>edit</td>
        <td>delete</td>S10_1678
    </tr>
    <%
        List<User> userList = (List<User>) request.getAttribute("users");
        if (userList != null){
            for (User user : userList){
                if (user != null){
    %>
    <tr>
        <td><%=user.getIdusers()%></td>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getEmployeeid()%></td>
        <td><a href="${pageContext.request.contextPath}/api/UserAct?userid=<%=user.getIdusers()%>&crud=edit">edit</a></td>
        <td><a href="${pageContext.request.contextPath}/api/UserAct?userid=<%=user.getIdusers()%>&crud=delete">delete</a></td>
    </tr>
    <%}}}%>
</table>
</body>
</html>