<%@ page import="com.afshin.Entity.Payment" %>
<%@ page import="com.afshin.General.GregorianDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  @Project     order
  @Author      Afshin Parhizkari
  @Date        2020 - 12 - 16
  @Time        4:53 AM
  Created by   IntelliJ IDEA
  Email:       Afshin.Parhizkari@gmail.com
  Description:  
--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/statics/JalaliJSCalendar-master/skins/calendar-blue.css" title="winter" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/JalaliJSCalendar-master/jalali.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/JalaliJSCalendar-master/calendar.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/JalaliJSCalendar-master/calendar-setup.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/JalaliJSCalendar-master/lang/calendar-fa.js"></script>
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
    <title>Add or Update Payment</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/api/Dispatcher" method="get">
    <input type="hidden" name="entity" value="Payment">
    <input type="submit" value="Back">
</form>
<form action="${pageContext.request.contextPath}/api/PaymentAct" method="post">
    <%
        Payment payment = (Payment) request.getAttribute("payment");
        if(payment ==null){
    %>
                Customer Number: <input name="custNum" type="number" required="required"></br>
                Check Number: <input name="checkNum" type="text" required="required"></br>
                Amount : <input name="turnOver" type="text" required="required"></br>

                <div class="example">
                    Payment date :
                    <input id="date_input_1" type="text" name="payDate"  required="required"/><img id="date_btn_1" src="${pageContext.request.contextPath}/statics/JalaliJSCalendar-master/examples/cal.png" style="vertical-align: top;" />
                    <script type="text/javascript">
                        Calendar.setup({
                            inputField     :    "date_input_1",   // id of the input field
                            button         :    "date_btn_1",   // trigger for the calendar (button ID)
                            ifFormat       :    "%Y-%m-%d",       // format of the input field
                            dateType	   :	'jalali',
                            weekNumbers    : false
                        });
                    </script>
                </div>
                    <input name="crud" type="hidden" value="add"></br>
                <input type="submit" value="AddPayment">
        <%}else{%>
                <input name="custNum" type="hidden" value="<%=payment.getCustomerNumber()%>">
                <input name="checkNum" type="hidden" value="<%=payment.getCheckNumber()%>">
                Amount : <input name="turnOver" type="text" value="<%=payment.getAmount()%>" required="required"></br>
                <%request.setAttribute("persianDate", GregorianDate.shamsiStr(GregorianDate.miladi2shamsi(payment.getPaymentDate())));%>
                <div class="example">
                    Payment date :
                    <input id="date_input_2" type="text" name="payDate" value="<%=request.getAttribute("persianDate")%>" required="required"/><img id="date_btn_2" src="${pageContext.request.contextPath}/statics/JalaliJSCalendar-master/examples/cal.png" style="vertical-align: top;" />
                    <script type="text/javascript">
                        Calendar.setup({
                            inputField     :    "date_input_2",   // id of the input field
                            button         :    "date_btn_2",   // trigger for the calendar (button ID)
                            ifFormat       :    "%Y-%m-%d",       // format of the input field
                            dateType	   :	'jalali',
                            weekNumbers    : false
                        });
                    </script>
                </div>
                <input name="crud" type="hidden" value="update"></br>
                <input type="submit" value="UpdatePayment">
        <%}%>
</form>
</body>
</html>