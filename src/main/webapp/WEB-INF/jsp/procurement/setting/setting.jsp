<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--财物管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
            <span>></span>
            <a href="#">我的设置</a>
        </div>
        <!--财物管理 头部 end-->
        <div class="col-xs-12" style="padding: 30px 0 0 100px">
            <p>消息通知方式（至少选择一项）</p>
            <div style="margin-left:100px;margin-top: 30px;margin-bottom: 30px;">
                <label class="checkbox-inline">
                    <input type="checkbox"  value="option2"> 手机短信通知
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" value="option3"> 邮箱通知
                </label>
            </div>
            <button type="button" class="btn btn-danger btn-default" style="margin-left:100px; width: 100px;height: 30px;">保存</button>
        </div>
    </div>
</div>
</body>
</html>