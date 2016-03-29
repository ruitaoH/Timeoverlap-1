<%--
  Created by IntelliJ IDEA.
  User: haoruitao
  Date: 16-2-2
  Time: 上午3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/hackday/test_4.css">
    <script src="<%=request.getContextPath()%>/hackday/test_4.js"></script>
    <script src="jquery-2.2.0.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Time-overlap</title>
</head>
<body>
<div id="main">
    <div id="header">
        <div id="div_img">
            <img id="logo" src="<%=request.getContextPath()%>/logo.png" >
        </div>
    </div>
    <div id="next">
        <div id="div1">
            <p>请输入提取密钥:</p>
        </div>
        <form action="<%=request.getContextPath() %>/my_cl_activity" name="send_secret" method="post">
            <p id="p_secret">
                <input class="secret" type="text" name="a" />
                <input class="secret" type="text" name="b" />
                <input class="secret" type="text" name="c" />
                <input class="secret" type="text" name="d" />
            </p>
            <div id="send">
                <input type="submit" value="确认" style="width:100%;height:100%;background: #11a9fb" />
            </div>
        </form>
    </div>

</div>

</body>
</html>
