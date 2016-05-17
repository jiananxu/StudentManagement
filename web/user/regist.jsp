<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>regist</h1>
<p style="color: red;size: 18px;;"> ${msg}</p>
<%--${pageContext.request.contextPath}/RegistServlet--%>
<form action="<c:url value="/com/java/user/web/servlet/RegistServlet"/>" method="post">
   用户名： <input type="text" name="username" value="${user.getUsername()}"/><br/>
   密 码 ： <input type="password" name="password" value="${user.getPassword()}"/> <br/>
   验证码：  <input type="text" name="VerifyCode" value="${user.getVerifyCode}" size="4"><br/>
    <img id="verifycode" src="<c:url value="/com/java/user/web/servlet/RegistServlet" />"/>
    <a href="javascript:_change() ">换一张</a>
    <input type="submit" name="注册" />

</form>
</body>
</html>
