<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="overflow: auto;">
<%@ include file="/common/include.jsp"%>
<head>
    <meta charset="UTF-8">
    <title>金融链供应平台</title>

</head>
<body style="padding: 0;margin: 0;overflow: auto;">
<div class="container-fluid login-top">
    <div class='container container-logo'>
        <img src='<%=request.getContextPath()%>/js/static/images/logo@1x.png'>
    </div>
    <img src='<%=request.getContextPath()%>/js/static/images/img@1x.png' class='img-responsive center-block' >
    <div class='form_div center-block' id="div" >
        <form class='form-inline form center-block' id="f">
            <!-- 账号 -->
            <div class="input-group col-xs-12 login-input">
                <input  id="name"  type="text" name="userName" class="form-control" placeholder="账号">
                <img src="<%=request.getContextPath()%>/js/static/images/account@1x.png" class='img-responsive img_dw'>
            </div>
            <div> ${sessionScope.errorMessage}</div>
            <!-- 密码 -->
            <div class="input-group col-xs-12 login-input">
                <input   id="pwd" type="password" name="userPwd" class="form-control" placeholder="密码">
                <img src="<%=request.getContextPath()%>/js/static/images/password@1x.png" class='img-responsive img_dw'>
            </div>
            <!-- 验证码 -->
            <div class="input-group col-xs-12 login-input clearfix">
                <input id="code" type="text" name="imageCode" class="form-control yzm_con" placeholder="验证码">
                <div class='yzm_img'>
                    <img alt="验证码" src="<%=request.getContextPath()%>/imageCode" title="点击更换" id="imgcoode" onclick="getImageCode(this)" style="height:60px;width:128px;"/>
                </div>
            </div>
            <!-- 登录 -->
            <div class="input-group col-xs-12">
                <input  id="account" type="button" onclick="login()" class="form-control btn btn-danger" value="登录"  style="height: 60px;font-size: 24px;">
            </div>
            <!-- 申请 -->
            <p class="text-right apply_for"><a href='#'>新用户申请</a></p>
        </form>

    </div>
    <p class='text-center copy'>Copyright © 2017 美创互联科技有限公司版权所有</p>

</div>
<script>
    <%--function login(){--%>
        <%--location.href="<%=request.getContextPath()%>/account/login.action";--%>
    <%--}--%>
    $(function(){
        var countdown=10;
        //随机生成验证码图片
        function getImageCode(val){
            if (countdown == 0) {
                var thisDate =  new Date();
                //区分当前请求和上一次请求
                document.getElementById("imgcoode").src="<%=request.getContextPath()%>/imageCode?sjNum="+thisDate.getTime();

                $(val).attr("disabled",false);
                $(val).val("免费获取验证码");
                countdown = 10;
            } else {
                $(val).attr("disabled", true);
                $(val).val('重新发送('+countdown+')');
                countdown--;
                setTimeout(function() {
                    getImageCode(val)
                },1)
            }
        }
    })
    //加载完页面
//    $(function () {
        //判断用户输入的账号和密码
        $("#account").click(function () {
            var a=$("#name").val();
            var b=$("#pwd").val();
            var c=$("#code").val();
            console.log(a);
            console.log(b);
            console.log(c);
            if(a==""||b==""){  //判断输入的账号密码是否为空
                alert("账号和密码不能为空");
                return false;
            }else{
                $.ajax({
                    url:"<%=request.getContextPath()%>/account/login.action",
                    type:'post',
                    dataType:"json",
                    data:$("#f").serialize(),
                    success:function (date) {//服务器返回的数据
                        if(date.success){
                                if(date.type == 0){
                                //采购方页面
                                window.location.href="<%=request.getContextPath()%>/account/loginProcurement.action"
                            }else if(date.type==1){
                                //贸易方页面
                                window.location.href="<%=request.getContextPath()%>/account/loginTrade.action"
                            }else if(date.type==2){
                                //资金方页面
                                window.location.href="<%=request.getContextPath()%>/account/loginCapital.action"
                            }
                        }else {
                            if(a!=date.userName){
                                alert(date.msg);
                                return false;
                            }
                            if(b!=date.userPwd){
                                alert(date.msg);
                                return false;
                            }
                            if(c!=date.imageCode){
                                alert(date.msg);
                                return false;
                            }
                        }
                    }

                })

            }
        })
//    })
</script>
</body>
</html>