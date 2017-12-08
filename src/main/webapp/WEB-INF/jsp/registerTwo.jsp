<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="overflow: auto;">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/static/css/bootstrap.css"/>
    <script src="<%=request.getContextPath()%>/js/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/static/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/static/css/index.css">
    <style>
        .rsg1{
            width: 500px;
            height: 350px;
            background: #ffffff;
            box-shadow: 1px 1px 14px 0px #C7C7C7;
            margin-top:100px;
            padding-top:10px;
            box-sizing: border-box;
        }
        .rsg_copy{
            margin-top:30px;
        }
        .registeredIdentity{
            margin-top:30px;
            width:80%;
            height:30px;
        }
        .registeredIdentity div button{
            width:120px;
            height:40px;
        }
         .rsg_one{
            position: relative;
         }
        .return{
           position: absolute;
            right:10px;
            top:-20px;
            cursor: pointer;
        }
        .rsg_one_xx{
            width:80%;
            box-sizing: border-box;
            margin-top:40px;
            padding-left: 30px;
        }
        .rsg_one_xx div{
            margin-bottom:10px !important;
        }
        .rsg_one_xx div label{
            font-weight: normal;
            font-size: 14px;
            line-height:40px;
        }
        .rsg_one_xx div input{
            height:40px;
            width:220px !important;
        }
        #next_bu{
            margin-top:30px;
            width:100px;
        }
    </style>
</head>
<body style="padding: 0;margin: 0;overflow: auto;">
<div class="container-fluid login-top">
    <div class='container container-logo'>
        <img src='<%=request.getContextPath()%>/js/static/images/logo1.3@1x.png'>
    </div>
    <div class='rsg rsg1 center-block'>
        <div class="rsg_one">
            <h3 class="text-center">新用户申请</h3>
            <a href="#" id="colseRegister"><img src='<%=request.getContextPath()%>/js/static/images/return.png' class="return"></a>
            <form class='form-inline center-block rsg_one_xx'>
                <div class="row">
                    <label class="col-xs-4 text-center">账号</label>
                    <input id="rsg_zh" type="text" class="form-control" placeholder="请输入账号">
                </div>
                <div class="row">
                    <label class="col-xs-4 text-center">密码</label>
                    <input id="rsg_mm" type="password" class="form-control" placeholder="请输入密码">
                </div>
                <div class="row">
                    <label class="col-xs-4 text-center">确认密码</label>
                    <input id="rsg_qrmm" type="password" class="form-control" placeholder="请确认输入密码">
                </div>
            </form>
            <a id="tz"><button class="btn center-block btn-primary" id="next_bu">下一步</button></a>
        </div>

    </div>
    <p class='text-center rsg_copy'>Copyright © 2017 美创互联科技有限公司版权所有 &nbsp; 京ICP备17069390号-1</p>
</div>
</body>
<script>
$("#colseRegister").click(function(){
	window.location="<%=request.getContextPath()%>/captialMain/login.action";
})
    var rsg_mm=$('#rsg_mm').val()
    var rsg_qrmm=$('#rsg_qrmm').val()
    $(document).on('click','#next_bu',function(){
        if($('#rsg_qrmm').val()!=$('#rsg_mm').val()){
            alert('请输入相同密码')
        }else{
            $(this).text('注册成功')
        }
    })
</script>
</html>