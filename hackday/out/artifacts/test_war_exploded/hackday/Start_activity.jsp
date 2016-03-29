<%--
  Created by IntelliJ IDEA.
  User: haoruitao
  Date: 16-2-1
  Time: 下午5:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <script src="jquery-2.2.0.js"></script>

    <script type="text/javascript" src="<%=request.getContextPath() %>/hackday/test_2.js"></script>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/hackday/test_2.css">


    <meta charset="UTF-8">
    <title>Time-overlap</title>

    <%--<script>--%>
        <%--function checkAc_code(){--%>
            <%--var ac_code = document.getElementById("ac_code").value;--%>
            <%--var tip = document.getElementById("tip");--%>

            <%--if(ac_code == ""){--%>
                <%--tip.innerHTML = "用户秘钥不能为空";--%>
                <%--document.getElementById("submit").setAttribute("disabled","disabled");--%>
            <%--}else{--%>
                <%--var xmlhttprequest = new XMLHttpRequest();--%>
                <%--xmlhttprequest.open("POST","/test/check?ac_code=" + ac_code,true);--%>
                <%--xmlhttprequest.onreadystatechange = function(){--%>
                    <%--if (xmlhttprequest.readyState == 4 && xmlhttprequest.status == 200) {--%>
                        <%--//回写--%>
                        <%--var result = xmlhttprequest.responseText;--%>
                        <%--if(result == "true"){--%>
                            <%--tip.innerHTML = "该用户秘钥已重复,请重新输入";--%>
                            <%--document.getElementById("submit").setAttribute("disabled","disabled");--%>
                        <%--}else {--%>
                            <%--tip.innerHTML = "";--%>
                            <%--document.getElementById("submit").removeAttribute("disabled");--%>
                        <%--}--%>
                    <%--}--%>
                <%--}--%>
                <%--xmlhttprequest.send();--%>
            <%--}--%>
        <%--}--%>
        <%----%>
    <%--</script>--%>
</head>
<body>
<div id="main">
    <div id="header">

    </div>
    <div id="next">


        <div id="wire">
            <div class="yuan_1" >
                <img src="picture/1.png" style="width: 130%">
            </div>
            <div class="yuan_2" >
                <img src="picture/2.png" style="width: 130%">
            </div>
            <div class="yuan_3">
                <img src="picture/3.png" style="width: 130%">
            </div>
            <div class="yuan_4" >
                <img src="picture/4.png" style="width: 130%">
            </div>
            <div class="yuan_5" >
                <img src="picture/5.png" style="width: 130%">
            </div>
        </div>
        <form action="<%=request.getContextPath() %>/start_cl_activity" method="post">
            <div id="div1">


                <span id="span_subject">主题:</span>
                <input id="subject" type="text" name="subject" />


                <span class="span_date">可能日期:(最多选择七天)</span>
                <div id="date">
                    <input name="month_1" type="text" />
                    <input name="month_2" type="text" />
                    <input name="month_3" type="text" />
                    <input name="month_4" type="text" />
                    <input name="month_5" type="text" />
                </div>

                <span class="p_time">活动时长:</span>
                <select id="select" name="time" size="1" style="height:80px">
                    <option  value="0.5">半小时</option>
                    <option  value="1">一小时</option>
                    <option  value="2">两小时</option>
                </select>

                <span id="deadline">截止时间:</span>
                <input class="year" type="text" name="date_day"  />
                <input class="minute" type="text" name="data_minute"  />

                <span id="from_people">发起人:        </span>

                <input id="people" type="text" name="people" >
    <span id="flip" onclick="length()">
        <img id="imgid" src="musion/more.png" >
        &nbsp&nbsp详细信息(可选)
    </span>



            </div>

            <div id="slide">
                <span class="slide_area">地点:</span><input id="slide_1" type="text" name="else_1" >
                <span class="slide_tel">联系电话:</span><input id="slide_2" type="text" name="else_2" >
            </div>



            <input id="submit" type="submit" name="send_friends" value="发送给好友">
        </form>
    </div>

</div>
</body>
</html>
