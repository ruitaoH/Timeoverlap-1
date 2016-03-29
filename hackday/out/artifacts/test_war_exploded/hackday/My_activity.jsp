<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.IntSummaryStatistics" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hrt.domain.User" %>
<%@ page import="com.hrt.domain.Activity" %><%--
  Created by IntelliJ IDEA.
  User: haoruitao
  Date: 16-2-1
  Time: 下午5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" charset="UTF-8" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/hackday/css/style_1.css"/>
</head>
<body>

<%
    List<Map.Entry<String,Integer>> real_choice = (List<Map.Entry<String,Integer>>)request.getAttribute("real_choice");
    List<Map.Entry<String,Map<String,String>>> real_people = (List<Map.Entry<String,Map<String,String>>>)request.getAttribute("real_people");
    User user = (User)request.getAttribute("user");
    Activity activity = (Activity)request.getAttribute("activity");
%>

<div id="contain">
    <div id="top">
        <span id="logo">logo</span>
    </div>
    <div id="temp"></div>
    <div id="main">
        <div id="part">
            <div id="info">
                <span>主题: <%=activity.getSubject() %></span>
                <span class="spcl">发起人: <%=user.getName() %></span>
                <span class="spcl" id="inline">联系电话: <%=user.getPhone() %></span>
                <span>地点: <%=activity.getPlace() %></span>
                <%--<span>已确认时间: </span>--%>
            </div>
            <%
                for(int i = 0 ;i < real_choice.size();i++){
                    if(real_choice.get(i).getValue() != 0){
            %>
            <div id="time">
                <span id="day"><%=real_choice.get(i).getKey() %></span>
                <%--<span id="hour">19:30-22:00</span>--%>
                <span id="joinNum"><%=real_choice.get(i).getValue() %>人</span>
                <%
                    for(String key : real_people.get(i).getValue().keySet()){
                %>
                <div>
                    <span><%=key %></span>
                    <span><%=real_people.get(i).getValue().get(key) %></span>
                </div>
                <%
                    }
                %>
            </div>

            <%
                    }
                }
            %>

        </div>
    </div>
</div>
</body>
</html>
