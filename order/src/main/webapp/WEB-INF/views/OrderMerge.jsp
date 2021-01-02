<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="afy" uri="http://afshin.com" %>
<%--<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 31
  @Time        6:18 PM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="all" href="/statics/JalaliJSCalendar-master/skins/calendar-blue.css" title="winter" />
<script type="text/javascript" src="/statics/JalaliJSCalendar-master/jalali.js"></script>
<script type="text/javascript" src="/statics/JalaliJSCalendar-master/calendar.js"></script>
<script type="text/javascript" src="/statics/JalaliJSCalendar-master/calendar-setup.js"></script>
<script type="text/javascript" src="/statics/JalaliJSCalendar-master/lang/calendar-fa.js"></script>
<!-- helper script that uses the calendar -->
<script type="text/javascript">
    var oldLink = null;
    function setActiveStyleSheet(link, title) {
        var i, a, main;
        for(i=0; (a = document.getElementsByTagName("link")[i]); i++) {
            if(a.getAttribute("rel").indexOf("style") != -1 && a.getAttribute("title")) {
                a.disabled = true;
                if(a.getAttribute("title") == title) a.disabled = false;
            }
        }
        if (oldLink) oldLink.style.fontWeight = 'normal';
        oldLink = link;
        link.style.fontWeight = 'bold';
        return false;
    }
</script>
<style type="text/css">
    .calendar {
        direction: rtl;
    }
    #flat_calendar_1, #flat_calendar_2{
        width: 200px;
    }
    #flat_calendar_3{
        width: 230px;
    }
    .example {
        padding: 10px;
    }
    .display_area {
        background-color: #FFFF88
    }
</style>
<head>
    <title>Customer Add or Update</title>
</head>
<body>
<form action="/Dispatcher" method="get">
    <input type="hidden" name="entity" value="Order">
    <input type="submit" value="Back">
</form>
</br>
<form action="OrderAct" method="post">
    <c:if test="${requestScope.order == null}">
        OrderNumber: <input type="number" name="onum"><br>
        OrderDate: <span id="display_area_2" style="cursor: pointer;" class="display_area">New Date</span>
        <input id="date_input_8" type="hidden" name="odate"/>
        <script type="text/javascript">
            Calendar.setup({
                inputField     : "date_input_8",   // id of the input field
                displayArea    : "display_area_2",
                ifFormat       : "%Y-%m-%d",       // format of the input field
                dateType	   : 'jalali',
                ifDateType	   : 'gregorian',
                weekNumbers    : false
            });
        </script><br>
        RequiredDate: <span id="display_area_1" style="cursor: pointer;" class="display_area">New Date</span>
        <input id="date_input_7" type="hidden" name="rdate"/>
        <script type="text/javascript">
            Calendar.setup({
                inputField     : "date_input_7",   // id of the input field
                displayArea    : "display_area_1",
                ifFormat       : "%Y-%m-%d",       // format of the input field
                dateType	   : 'jalali',
                ifDateType	   : 'gregorian',
                weekNumbers    : false
            });
        </script><br>
        ShippedDate: <span id="display_area_3" style="cursor: pointer;" class="display_area">New Date</span>
        <input id="date_input_9" type="hidden" name="sdate" />
        <script type="text/javascript">
            Calendar.setup({
                inputField     : "date_input_9",   // id of the input field
                displayArea    : "display_area_3",
                ifFormat       : "%Y-%m-%d",       // format of the input field
                dateType	   : 'jalali',
                ifDateType	   : 'gregorian',
                weekNumbers    : false
            });
        </script><br>
        Status: <input type="text" name="status"><br>
        Comments: <input type="text" name="com"><br>
        CustomerNumber: <input type="number" name="custnum"><br><br>
        <input type="hidden" name="crud" value="add">
        <input type="submit" value="Add">
    </c:if>
    <c:if test="${requestScope.order != null}">
        <input type="hidden" value="${requestScope.order.orderNumber}" name="ordernum"><br>
        OrderDate: <span id="display_area_2" style="cursor: pointer;" class="display_area">${afy:shamsiStr(requestScope.order.orderDate)}</span>
        <input id="date_input_8" type="hidden" name="odate" />
        <script type="text/javascript">
            Calendar.setup({
                inputField     : "date_input_8",   // id of the input field
                displayArea    : "display_area_2",
                ifFormat       : "%Y-%m-%d",       // format of the input field
                dateType	   : 'jalali',
                ifDateType	   : 'gregorian',
                weekNumbers    : false
            });
        </script><br>
        RequiredDate: <span id="display_area_1" style="cursor: pointer;" class="display_area">${afy:shamsiStr(requestScope.order.requiredDate)}</span>
        <input id="date_input_7" type="hidden" name="rdate" />
        <script type="text/javascript">
            Calendar.setup({
                inputField     : "date_input_7",   // id of the input field
                displayArea    : "display_area_1",
                ifFormat       : "%Y-%m-%d",       // format of the input field
                dateType	   : 'jalali',
                ifDateType	   : 'gregorian',
                weekNumbers    : false
            });
        </script><br>
        ShippedDate: <span id="display_area_3" style="cursor: pointer;" class="display_area">${afy:shamsiStr(requestScope.order.shippedDate)}</span>
        <input id="date_input_9" type="hidden" name="sdate" />
        <script type="text/javascript">
            Calendar.setup({
                inputField     : "date_input_9",   // id of the input field
                displayArea    : "display_area_3",
                ifFormat       : "%Y-%m-%d",       // format of the input field
                dateType	   : 'jalali',
                ifDateType	   : 'gregorian',
                weekNumbers    : false
            });
        </script><br>
        Status: <input value="${requestScope.order.status}" type="text" name="status"><br>
        Comments: <input value="${requestScope.order.comments}" type="text" name="com"><br>
        CustomerNumber: <input value="${requestScope.order.customerNumber}" type="number" name="cusnum"><br><br>
        <input type="hidden" value="update" name="crud">
        <input type="submit" value="Udate">
    </c:if>
</form>
</body>
</html>
