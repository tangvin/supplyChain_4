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
        .rsg{
            width: 500px;
            height: 400px;
            background: #ffffff;
            box-shadow: 1px 1px 14px 0px #C7C7C7;
            margin-top:60px;
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
        .rsg_one_xx{
            width:80%;
            box-sizing: border-box;
            margin-top:40px;
            padding-left: 30px;
            
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
        #btnSendCode{
            width:100px!important;
            height:40px;
        }
        #checkCode{
            width:100px!important;
            margin-left: 0px;
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
    <div class='rsg center-block'>
        <div class="rsg_one">
            <a href="#" id="colseRegister"><img src='<%=request.getContextPath()%>/js/static/images/return.png' class="return"></a>
            <h3 class="text-center">新用户申请</h3>  
            <div class="registeredIdentity center-block row">
                <div class="col-xs-4"><button name="button" value="0" class="btn center-block">采购商</button></div>
                <div class="col-xs-4"><button name="button" value="1" class="btn center-block">供应商</button></div>
                <div class="col-xs-4"><button name="button" value="2" class="btn center-block">资方</button></div>
            </div>
            <!-- method="post" action="customer/register.do" id="J_phone" -->
            <form  class='form-inline center-block rsg_one_xx'>
                <div class="row">
                    <label class="col-xs-4 text-center">联系人</label>
                    <input id="reg_sjh" type="text" class="form-control" placeholder="姓名" value="">
                </div>
                <div class="row">
                    <label class="col-xs-4 text-center">手机号</label>
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="输入手机号">
                </div>
                <div class="row">
                    <label class="col-xs-4 text-center">验证码</label>
                    <input type="text" id="checkCode" placeholder="输入验证码" class="form-control col-xs-4" name="checkCode"/>
                    <input id="btnSendCode" class="btn" type="button" value="获取验证码" onclick="sendMessage()" />
                </div>
            </form>
            <a class="btn center-block btn-primary" id="next_bu" >下一步</a>
        </div>

    </div>
    <p class='text-center rsg_copy'>Copyright © 2017 版权所有 </p>
    <p class='text-center'><a target="_blank" href="http://www.miitbeian.gov.cn/">京ICP备17069390号-1</a></p>
</div>
</body>
<script>

$("#colseRegister").click(function(){
	window.location="<%=request.getContextPath()%>/captialMain/login.action";
})

    //    alert($('.registeredIdentity div button[class$=btn-danger]').text())
    $(".registeredIdentity>div").click(function(){
    	
        $(this).children('button').addClass('btn-danger');
        $(this).siblings().children('button').removeClass('btn-danger');
//        alert( $(this).children('button').text())
    })
    $('#checkCode').attr('disabled',true)
    var InterValObj; //timer变量，控制时间
    var count = 10; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    var code = ""; //验证码
    var codeLength = 6;//验证码长度
    
    
	/* $(function(){
		var arr = document.getElementsByTagName('button');
		var accountType;
		for(var i = 0;i<arr.length;i++){
			arr[i].onclick = function(){
				accountType=this.value;	
			}
			
		}
	}) */
	
     $("#next_bu").click(function(){
    	 if($('#reg_sjh').val()==''){
             alert('请输入姓名')
         }else if($('#phone').val()==''||!myreg.test($('#phone').val())){
             alert('请输入正确手机号')
         }else if($('#checkCode').val()==''){
             alert('请输入验证码')
         }else if(!$('.registeredIdentity div button').hasClass('btn-danger')){
             alert('请选择注册身份')
         }else{
        	 $(this).attr('href','<%=request.getContextPath()%>/captialMain/registerTwo.action')
         }
    	<%-- alert("111") 
    	 $(this).attr('href','<%=request.getContextPath()%>/captialMain/registerTwo.action')
    	$.ajax({
    		url:'<%=request.getContextPath()%>/register2/first.action',
    		type:'post',
    		success:function(data) {
    			$('#tz').attr('href','<%=request.getContextPath()%>/captialMain/registerTwo.action')
    			alert(data)
    		}
    	}) --%>
    }) 
    
    var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
    function next_bus(){
      if($('#reg_sjh').val()==''){
            alert('请输入姓名')
        }else if($('#phone').val()==''||!myreg.test($('#phone').val())){
            alert('请输入正确手机号')
        }else if($('#checkCode').val()==''){
            alert('请输入验证码')
        }else if(!$('.registeredIdentity div button').hasClass('btn-danger')){
            alert('请选择注册身份')
        }else{ 
        	$(this).attr('href','<%=request.getContextPath()%>/captialMain/registerTwo.action')
        	<%-- $.ajax({
        		url : '<%=request.getContextPath()%>/register/first.action',
        		type:'post',
        		success:function(data) {
        			$('#tz').attr('href','<%=request.getContextPath()%>/captialMain/registerTwo.action')
        		}
        	})
        	var userPhone=$("#phone").val();//手机号码
            var userLinkman=$('#reg_sjh').val();//联系人
            var checkCode=$('#checkCode').val();//验证码
            var accountType = $('.registeredIdentity div button[class$=btn-danger]').val();
            
        	$.ajax({
				
				url : '<%=request.getContextPath()%>/register/first.action', 
				data : {
					accountType:accountType,
					userLinkman:userLinkman,
					userPhone:userPhone,
					checkCode:checkCode
				},
				type:'post',
				success : function(data) {
					if (data.success) {
						$('#tz').attr('href','<%=request.getContextPath()%>/captialMain/registerTwo.action')
					}else{
						alert("验证码错误");
					}
				}
			}); --%>
        } 
    }
    function sendMessage() {
        curCount = count;
        var phone=$("#phone").val();//手机号码
        var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if(phone == ""){
            alert("手机号码不能为空！");
        }else if(phone.length !=11){
            alert('请输入有效的手机号码');
        }else if(!myreg.test(phone)){
            alert('请输入有效的手机号码11');
        } else{
            $('#checkCode').attr('disabled',false)
            //产生验证码
            for (var i = 0; i < codeLength; i++) {
                code += parseInt(Math.random() * 9).toString();
            }
            //设置button效果，开始计时
            $("#btnSendCode").attr("disabled", "true");
            $("#btnSendCode").val( + curCount + "秒");
            InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
            
        }
    }
    //timer处理函数
    function SetRemainTime() {
        if (curCount == 0) {
            $('#checkCode').attr('disabled',true)
            window.clearInterval(InterValObj);//停止计时器
            $("#btnSendCode").removeAttr("disabled");//启用按钮
            $("#btnSendCode").val("获取验证码");
            code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效
        }
        else {
            curCount--;
            $("#btnSendCode").val( curCount + "秒");
        }
    }

</script>
</html>