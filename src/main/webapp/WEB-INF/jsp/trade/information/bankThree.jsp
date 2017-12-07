<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .yhk_three{
            margin-top:40px;
            margin-bottom:30px;
        }
    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row row_zhxx'>
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a id="zhxx">资料维护</a>
            <span>></span>
            <a href="#">添加银行卡</a>
        </div>
    </div>
    <div class="col-xs-3 col-xs-offset-2 yhk_three">
        <p>本次操作需要短信确认，请输入189****7365收到的短信校验码</p>
    </div>
    <form class='form-inline col-xs-9 col-xs-offset-1'>
        <div class="row">
            <span>验证码：</span>
            <input type="text" id="checkCode" placeholder="输入验证码" class="form-control" name="checkCode"/>
            <input style="width: 50px;" id="btnSendCode" class="btn" type="button" value="获取验证码" onclick="sendMessage()" />
        </div>
    </form>
    <div class="col-xs-12">
        <button style="margin-top: 40px;width: 120px;" class="btn col-xs-offset-2" id="yhk_next_two_bu">完成</button>
    </div>
</div>
</body>
<script>
    $('#zhxx').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/zhxx.action')
    });
    var InterValObj; //timer变量，控制时间
    var count = 3; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    var code = ""; //验证码
    var codeLength = 6;//验证码长度
    function sendMessage() {
        curCount = count;
        //产生验证码
        for (var i = 0; i < codeLength; i++) {
            code += parseInt(Math.random() * 9).toString();
        }
        //设置button效果，开始计时
        $("#btnSendCode").attr("disabled", "true");
        $("#btnSendCode").val( + curCount + "秒");
        InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次

    }
    //timer处理函数
    function SetRemainTime() {
        if (curCount == 0) {
            window.clearInterval(InterValObj);//停止计时器
            $("#btnSendCode").removeAttr("disabled");//启用按钮
            $("#btnSendCode").val("发送验证码");
            code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效
        }
        else {
            curCount--;
            $("#btnSendCode").val( curCount + "秒");
        }
    }
</script>
</html>