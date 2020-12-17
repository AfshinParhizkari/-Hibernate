<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 16
  @Time        4:53 AM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .calender-icon {
        position: absolute !important;
        margin-top: -5px !important;
        margin-right: -5px !important;
    }
</style>
<link rel="stylesheet" href="/statics/JalaliJSCalendar-master/skins/aqua/theme.css">
<html>
<head>
    <title>Add or Update Payment</title>
</head>
<body>
<form action="/Dispatcher" method="get">
    <input type="hidden" name="entity" value="Payment">
    <input type="submit" value="Back">
</form>
<form action="/PatmentAct" method="post">
    Customer Number: <input name="custNum" type="number"></br>
    Check Number: <input name="checkNum" type="checkNumber"></br>
    <div>
        Payment date : <input name="payDate">
        <i class="fa fa-calendar calender-icon" id="date_btn" aria-hidden="true"></i>
    </div>
    Amount : <input name="turnOver" type="number"></br>
    <input name="crud" type="hidden" value="add">
    <input type="submit" value="AddPayment">
</form>
</body>
</html>