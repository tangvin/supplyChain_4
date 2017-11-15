<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<body>
<%
    cn.com.edzleft.entity.SessionInfo sessionInfo=(cn.com.edzleft.entity.SessionInfo) session.getAttribute("sessionInfo");
    if(sessionInfo!=null){//session中有值  登陆成功
        response.sendRedirect(request.getContextPath()+"/main/signingInfo.action");
    }else{
        response.sendRedirect(request.getContextPath()+"/main/login.action");
    }
%>
</body>
</html>
