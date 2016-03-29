<%--
  Created by IntelliJ IDEA.
  User: haoruitao
  Date: 16-2-2
  Time: 上午1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/hackday/test_1.css" />
    <script src="<%=request.getContextPath() %>/hackday/jquery-2.2.0.js"></script>
    <script src="<%=request.getContextPath() %>/hackday/test_1.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
<div id="header">
    <img id="logo" src="<%=request.getContextPath() %>/hackday/picture/logo.png" >
</div>
<div id="next">
        <span id="active">
            <a href="<%=request.getContextPath() %>/hackday/Start_activity.jsp">发起活动</a>
        </span>
        <span id="creat">
            <a href="<%=request.getContextPath() %>/hackday/check.jsp">我的活动</a>
        </span>

    <div style="color:red;margin:15px" id="err">
        <%=request.getAttribute("err") %>
    </div>
</div>


</body>

</html>