<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2021 - 01 - 23
  @Time        1:15 AM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  Jasper Report
--%>
<%@ page import="com.afshin.Entity.Payment" %>
<%@ page import="com.afshin.General.GregorianDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" media="all" href="/statics/JalaliJSCalendar-master/skins/calendar-blue.css" title="winter" />
    <script type="text/javascript" src="/statics/JalaliJSCalendar-master/jalali.js"></script>
    <script type="text/javascript" src="/statics/JalaliJSCalendar-master/calendar.js"></script>
    <script type="text/javascript" src="/statics/JalaliJSCalendar-master/calendar-setup.js"></script>
    <script type="text/javascript" src="/statics/JalaliJSCalendar-master/lang/calendar-fa.js"></script>
    <!-- helper script that uses the calendar -->
    <script type="text/javascript">
        var oldLink = null;
        // code to change the active stylesheet
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
<%--_____________________________________________________________________________________________--%>
    <title>Payment Report</title>
</head>
<body>
<form action="Dispatcher" method="get">
    <input type="hidden" name="entity" value="Payment">
    <input type="submit" value="Back">
</form>
<form action="PaymentAct" method="get">
    FromDate: <span id="display_area_1" style="cursor: pointer;" class="display_area">Choose Date</span>
    <input id="date_input_1" type="hidden" name="fdate"/>
    <script type="text/javascript">
        Calendar.setup({
            inputField     : "date_input_1",   // id of the input field
            displayArea    : "display_area_1",
            ifFormat       : "%Y-%m-%d",       // format of the input field
            dateType	   : 'jalali',
            ifDateType	   : 'gregorian',
            weekNumbers    : false
        });
    </script><br>
    ToDate: <span id="display_area_2" style="cursor: pointer;" class="display_area">Choose Date</span>
    <input id="date_input_2" type="hidden" name="tdate"/>
    <script type="text/javascript">
        Calendar.setup({
            inputField     : "date_input_2",   // id of the input field
            displayArea    : "display_area_2",
            ifFormat       : "%Y-%m-%d",       // format of the input field
            dateType	   : 'jalali',
            ifDateType	   : 'gregorian',
            weekNumbers    : false
        });
    </script>
   <p>Please select your gender:</p>
        <input type="radio" name="exporttype" value="web" checked="checked">View
        <input type="radio" name="exporttype" value="pdf">PDF
        <input type="radio" name="exporttype" value="xml">XML
    <input name="crud" type="hidden" value="report">
   <input type="submit" value="PaymentReport">
</form>
</body>
</html>