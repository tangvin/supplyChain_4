<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%String path=request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Crazy</title>
    <style type="text/css">
        #ubody{
            width:80%;
            height:100%;
            margin:0px auto;
            border:red solid 1px;
            text-align:center;
        }
    </style>
</head>
<body>
<div id="ubody">
    <h1>Hello World!</h1>
    <a href="<%=path %>/user/addUser.action">dddd</a>
    <form action="<%=path %>/web/user/addUser.action" method="post">
        <input type="text" name="uname" placeholder="请输入用户名" />
        <input type="password" name="uname" placeholder="请输入密码" />
        <input type="text" name="uname" placeholder="请输入用户信息" />
        <input type="submit" value="添加用户">
    </form>
    <a href="<%=path %>/user/addUser.action">用户列表</a>
    <p style="color:red">${addmess }  ${upmess }  ${delmess }</p>
    <c:forEach var="user" items="${list}" varStatus="status">
        <p>
                ${user.uname }&nbsp;&nbsp;&nbsp;
                ${user.umessage }&nbsp;&nbsp;&nbsp;
            <fmt:formatDate value='${user.utime }' type='both' pattern='yyyy-MM-dd HH:mm:ss' />&nbsp;&nbsp;&nbsp;
            <a href="<%=path %>/user/delUser.do?uid=${user.uid}">删除用户</a>
        </p>
    </c:forEach>
</div>
</body>
</html>