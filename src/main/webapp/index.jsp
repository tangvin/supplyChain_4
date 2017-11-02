<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>供应链登录页</title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/easyui1.4.5/css/bglogin.css"/>
    <!-- 引入JQuery 库-->
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/easyui1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/js/sha1.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            //传递字符串格式json对象到后台（一个json对象）
            //getUserCore();
        });

        function login() {
            $("input[name='j_password']").val(hex_sha1($("input[name='password']").val()));
            $("input[name='j_code']").val($("input[name='j_code']").val());
            $("#loginForm").submit();
        }

        function refreshCaptcha(){
            document.getElementById("img_captcha").src="<%=request.getContextPath() %>/js/images/kaptcha.jpg?t=" + Math.random();
        }
    </script>
</head>
<body>
<div>
    <form id="loginForm" action="<%=request.getContextPath() %>/user/addUser.action" method="post">

        <div class="login_top">
            <div class="login_title">
                供应链登录页
            </div>
        </div>
        <div style="float:left;width:100%;">
            <div class="login_main">
                <div class="login_main_top"></div>
                <div class="login_main_errortip">${error}</div>
                <div class="login_main_ln">								<!-- 禁止输入空格 -->
                    <input type="text" id="username" name="j_username" onkeyup="this.value=this.value.replace(/\s+/g,'')"/>
                </div>
                <div class="login_main_pw">
                    <input type="password" id="password" name="password" onkeyup="this.value=this.value.replace(/\s+/g,'')" onpaste="return false" ondragenter="return false"/>
                    <input type="hidden" name="j_password" />
                </div>
                <%--<div class="login_main_yzm">--%>
                <%--<div>--%>
                <%--<input type="text" id="captcha" name="j_code"/>--%>
                <%--<img alt="验证码" src="<%=request.getContextPath() %>/js/images/kaptcha.jpg" title="点击更换" id="img_captcha" onclick="javascript:refreshCaptcha();" style="height:45px;width:85px;float:right;margin-right:98px;"/>--%>
                <%--</div>--%>
                <%--</div>--%>
                <div class="login_main_remb">
                    <input id="rm" name="rememberMe" type="hidden"/>
                    <%--<label for="rm"><span>记住我</span></label>--%>
                </div>
                <div class="login_main_submit">
                    <button onclick="login()"></button>
                </div>
            </div>
        </div>
    </form>
</div>

<%-- <c:choose>
    <c:when test="${error eq 'com.tianyu.jty.system.utils.CaptchaException'}">
        <script>
            $(".login_main_errortip").html("验证码错误，请重试");
        </script>
    </c:when>
    <c:when test="${error eq 'com.hdzx.base.exception.BusinessException'}">
        <script>
            $(".login_main_errortip").html("帐号或密码错误，请重试");
        </script>
    </c:when>
    <c:when test="${error eq 'org.apache.shiro.authc.IncorrectCredentialsException'}">
        <script>
            $(".login_main_errortip").html("用户名不存在，请重试");
        </script>
    </c:when>
</c:choose> --%>

</body>
</html>
