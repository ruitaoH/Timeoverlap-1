<%--
  Created by IntelliJ IDEA.
  User: haoruitao
  Date: 16-2-1
  Time: 下午6:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/hackday/test_3.css">
    <script src="<%=request.getContextPath()%>/hackday/test_3.js"></script>
    <script src="jquery-2.2.0.js"></script>
    <title>Time-overlap</title>
    <script>
        function send(){
            var name = document.getElementById("people_name_input");
            var xmlhttprequest = new XMLHttpRequest();
            xmlhttprequest.open("POST","/test/attend_cl_activity?choice=" + color_ + "&name=" + name.value,true);
            xmlhttprequest.onreadystatechange = function(){
            if (xmlhttprequest.readyState == 4 && xmlhttprequest.status == 200) {
                document.getElementById("main").innerHTML = "提交成功";
            }
        }
        xmlhttprequest.send();
    }
    </script>
</head>
<body>

<%
    String subject = (String)request.getAttribute("主题");
    String name = (String)request.getAttribute("发起人");
    String phone = (String)request.getAttribute("联系电话");
    String place = (String)request.getAttribute("地点");
    String dead = (String)request.getAttribute("提交截止时间");
    String  date = (String)request.getAttribute("时间");
    String [] dates = date.split(";");
    System.out.print(date);
%>

<div id="main">
    <div id="header">
        <img id="logo" src="<%=request.getContextPath()%>/logo.png">
    </div>

    <div id="up">

            <span id="subject">主题:
                    <span id="subject_1"><%=subject %></span>
            </span>



        <p><span id="people">发起人:
                    <span id="people_1"><%=name %></span>
            </span>
            <span id="tel">联系电话:
                <span id="tel_1">
                        <%
                            if(phone == null){
                        %>
                        无
                        <%
                        }else{
                        %>
                        <%=phone %>
                        <%
                            }
                        %>
                    </span>
            </span>
        </p>




        <p>    <span id="area">地点:
                        <span id="area_name">
                            <%
                                if(place == null){
                            %>
                            无
                            <%
                            }else{
                            %>
                            <%=place %>
                            <%
                                }
                            %>
                        </span>
                   </span>
        </p>





                <span id="dead_time">提交截止时间:
                    <span id="dead_time_1"><%=dead %></span>
                </span>
        <img id="mail" src="<%=request.getContextPath()%>/hackday/musion/mail_已确认时间.png">
    </div>

    <div id="down">
        <p id="people_name"/>
        <span id="people_name_span">姓名:</span>
        <input id="people_name_input" type="text" name="people_name" />

        </p>
        <div id="spare_time">
            <span id="red"></span>
            <span id="must">确认空闲时间</span>
            <span id="blue"></span>
            <span id="may">可能空闲时间</span>
        </div>
        <div id="unknown">
            <div class="may_date"><%=dates[0] %></div>
            <div class="may_date"><%=dates[1] %></div>
            <div class="may_date"><%=dates[2] %></div>
            <div class="may_date"><%=dates[3] %></div>
            <div class="may_date"><%=dates[4] %></div>
        </div>
        <div id="little_time">
            <div id="morning" class="four">
                <p class="p1">上</p>
                <p class="p2">午</p>
            </div>
            <div id="moon" class="four">
                <p class="p1">中</p>
                <p class="p2">午</p>
            </div>
            <div id="afternoon" class="four">
                <p class="p1">下</p>
                <p class="p2">午</p>
            </div>
            <div id="evening" class="four">
                <p class="p1">晚</p>
                <p class="p2">上</p>
            </div>
        </div>

        <div id="choose">
            <div id="choose1" class="click" onclick="change_color1()">

            </div>
            <div id="choose2" class="click" onclick="change_color2()">

            </div>
            <div id="choose3" class="click" onclick="change_color3()">

            </div>
            <div id="choose4" class="click" onclick="change_color4()">

            </div>
            <div id="choose5" class="click" onclick="change_color5()">

            </div>
            <div id="choose6" class="click" onclick="change_color6()">

            </div>
            <div id="choose7" class="click" onclick="change_color7()">

            </div>
            <div id="choose8" class="click" onclick="change_color8()">

            </div>
            <div id="choose9" class="click" onclick="change_color9()">

            </div>
            <div id="choose10" class="click" onclick="change_color10()">

            </div>
            <div id="choose11" class="click" onclick="change_color11()">

            </div>
            <div id="choose12" class="click" onclick="change_color12()">

            </div>
            <div id="choose13" class="click" onclick="change_color13()">

            </div>
            <div id="choose14" class="click" onclick="change_color14()">

            </div>
            <div id="choose15" class="click" onclick="change_color15()">

            </div>
            <div id="choose16" class="click" onclick="change_color16()">

            </div>
            <div id="choose17" class="click" onclick="change_color17()">

            </div>
            <div id="choose18" class="click" onclick="change_color18()">

            </div>
            <div id="choose19" class="click" onclick="change_color19()">

            </div>
            <div id="choose20" class="click" onclick="change_color20()">

            </div>











        </div>
        <div id="send" onclick="send()">提交修改</div>
    </div>
</div>
</body>
</html>
