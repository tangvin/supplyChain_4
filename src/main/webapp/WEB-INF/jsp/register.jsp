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
         .rsg_one_bu{
            position: relative;
         }
        .return{
           position: absolute;
            right:10px;
            top:-20px;
            cursor: pointer;
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
        .rsg_one,.rsg_two{
            display: none;
        }
    </style>
</head>
<body style="padding: 0;margin: 0;overflow: auto;">
<div class="container-fluid login-top">
    <div class='container container-logo'>
        <img src='<%=request.getContextPath()%>/js/static/images/logo1.3@1x.png'>
    </div>
    <div class="col-xs-12 rsg_one">
    <div class='rsg center-block'>
        <div class="rsg_one_bu">
            <a href="#" class="colseRegister"><img src='<%=request.getContextPath()%>/js/static/images/return.png' class="return"></a>
            <h3 class="text-center">新用户申请</h3>
            <div class="registeredIdentity center-block row">
                <div class="col-xs-4"><button name="button" value="0" class="btn center-block">采购商</button></div>
                <div class="col-xs-4"><button name="button" value="1" class="btn center-block">供应商</button></div>
                <div class="col-xs-4"><button name="button" value="2" class="btn center-block">资方</button></div>
            </div>
            <form  class='form-inline center-block rsg_one_xx' id="formRegist">
                <div class="row">
                    <label class="col-xs-4 text-center">联系人</label>
                    <input id="reg_sjh" type="text" class="form-control" name="userLinkman" placeholder="姓名">
                </div>
                <div class="row">
                    <label class="col-xs-4 text-center">手机号</label>
                    <input type="text" class="form-control" id="phone" name="userPhone" placeholder="输入手机号">
                </div>
                <div class="row">
                    <label class="col-xs-4 text-center">验证码</label>
                    <input type="text" id="checkCode" placeholder="输入验证码" class="form-control col-xs-4" name="checkCode"/>
                    <input id="btnSendCode" class="btn" type="button" value="获取验证码" onclick="sendMessage()" />
                </div>
            </form>
            <button class="btn center-block btn-primary" id="next_bu_one" >下一步</button>
        </div>
    </div>
    <p class='text-center rsg_copy'>Copyright © 2017 版权所有 </p>
    <p class='text-center'><a target="_blank" href="http://www.miitbeian.gov.cn/">京ICP备17069390号-1</a></p>
    </div>
    <div class="col-xs-12 rsg_two">
        <div class='rsg rsg1 center-block'>
            <div class="rsg_two_bu rsg_one_bu">
	            <a href="#" class="colseRegister1"><img src='<%=request.getContextPath()%>/js/static/images/return.png' class="return"></a>
	                <h3 class="text-center">新用户申请</h3>
	                <form class='form-inline center-block rsg_one_xx'>
	                    <div class="row">
	                        <label class="col-xs-4 text-center">账号</label>
	                        <input id="rsg_zh" type="text" class="form-control" placeholder="字母开头，4-16位">
	                    </div>
	                    <div class="row">
	                        <label class="col-xs-4 text-center">密码</label>
	                        <input id="rsg_mm" type="password" class="form-control" placeholder="6-21位字母和数字">
	                    </div>
	                    <div class="row">
	                        <label class="col-xs-4 text-center">确认密码</label>
	                        <input id="rsg_qrmm" type="password" class="form-control" placeholder="请与密码保持一致">
	                    </div>
	                </form>
	                <a id="tz"><button class="btn center-block btn-primary" id="next_bu_two">下一步</button></a>
            </div>
        </div>
        <p class='text-center rsg_copy'>Copyright © 2017 版权所有 </p>
    <p class='text-center'><a target="_blank" href="http://www.miitbeian.gov.cn/">京ICP备17069390号-1</a></p>
    </div>
</div>
</body>
<script>
$(".colseRegister").click(function(){
	window.location="<%=request.getContextPath()%>/captialMain/login.action";
})
$(".colseRegister1").click(function(){
	window.location="<%=request.getContextPath()%>/captialMain/login.action";
})
	
    /* $(document).on('click','#next_bu_two',function(){
        if($('#rsg_qrmm').val()!=$('#rsg_mm').val()){
            alert('请输入相同密码')
        }else{
            $(this).text('注册成功')
        }
    }) */
    
    $("#rsg_zh").blur(function(){
    	  $.ajax({
    		  url:'<%=request.getContextPath()%>/account/findByName.action',
    		  data:{
    			userName:$('#rsg_zh').val()
    			  },
    		  type:'post',
    		  success:function (data) {
    			  if (data.success) {
					alert("该账号已被注册");
					$("#next_bu_two").attr('disabled',true);
				}else{
					$("#next_bu_two").attr('disabled',false);
				}
    		  }
    	  })
    	});
    	
    	$("#next_bu_two").click(function(){
    		var userName=$('#rsg_zh').val();
    		var userPwd=$('#rsg_mm').val();
    	    var rsg_qrmm=$('#rsg_qrmm').val();
    	   var myum = /^[A-Za-z][A-Za-z0-9_]{3,15}$/;
    	   var mypw = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,21}$/;
    	   var userPhone=$("#phone").val();//手机号码
           var userLinkman=$('#reg_sjh').val();//联系人
          
           var accountType = $('.registeredIdentity div button[class$=btn-danger]').val();
    		if (userName=='') {
    			 alert('请输入账号');
			}else if(!myum.test(userName)){
				alert("账号必须由字母开头，4-16位");
			}else if(userPwd==''){
				alert("请输入密码");
			}else if(!mypw.test(userPwd)){
				alert("密码必须由6-21位字母和数字组成");
			}else if(userPwd!=rsg_qrmm){
				alert('请输入相同密码');
			}else{
				$.ajax({
					url:'<%=request.getContextPath()%>/register11/registerTwo.action',
					data:{
						userName:userName,
						userPwd:userPwd,
						userPhone:userPhone,
						userLinkman:userLinkman,
						accountType:accountType
					},
					type:'post',
					success:function (data){
						
						if (data.success) {
							alert("注册成功");
							window.location="<%=request.getContextPath()%>/captialMain/login.action";
						}else{
							alert("注册失败");
						}
						
					}
					
				});
			}
    	})
    
	$('#next_bu_one').click(function(){
		 if($('#reg_sjh').val()==''){
	            alert('请输入姓名')
	        }else if($('#phone').val()==''||!myreg.test($('#phone').val())){
	            alert('请输入正确手机号')
	        }else if($('#checkCode').val()==''){
	            alert('请输入验证码')
	        }else if(!$('.registeredIdentity div button').hasClass('btn-danger')){
	            alert('请选择注册身份')
	        }else{
	        	var userPhone=$("#phone").val();//手机号码
	            var userLinkman=$('#reg_sjh').val();//联系人
	            var checkCode=$('#checkCode').val();//验证码
	            var accountType = $('.registeredIdentity div button[class$=btn-danger]').val(); 
	          //  alert($("#formRegist").serialize())
            $.ajax({
            	url:'<%=request.getContextPath()%>/register11/registerOne.action',
//            	dataType:'json',
            	type:'POST',
            	/* data:{
            		account:$("#formRegist").serialize(),
            		accountType : $('.registeredIdentity div button[class$=btn-danger]').val()
				}, */
				data:{
					userPhone:userPhone,
					userLinkman:userLinkman,
					checkCode:checkCode,
					accountType:accountType
				},
           		success:function (data) {
           			//alert(data.userPhone)
           			//alert(data.userLinkman)
           			//alert(data.accountType)
					//alert(data.success);
					//alert(data)
               	 	if(data.success){
                		 $('.rsg_one').css('display','none')
                    	 $('.rsg_two').css('display','block')
                	}else{
                		alert("验证码错误");
                	}
                

           		 }
            });
           
        }
    });
	
	
    $('.rsg_one').css('display','block')
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
    var phone=$("#phone").val();//手机号码
    var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
    var userName=$('#rsg_zh').val();
	var userPwd=$('#rsg_mm').val();
    var rsg_qrmm=$('#rsg_qrmm').val();
    function next_bu(){
//        if($('.registeredIdentity div button').hasClass('btn-danger')){
//            alert('111')
//        }else{
//            alert('222')
//        }
//        if(!$('.registeredIdentity div button').hasClass('btn-danger')){
//            alert('请选择注册身份')
//        }else if($('#reg_sjh').val()==''){
//            alert('请输入姓名')
//        }else if($('#phone').val()==''||!myreg.test($('#phone').val())){
//            alert('请输入正确手机号')
//        }else if($('#checkCode').val()==''){
//           alert('请输入验证码')
//        }else if(!$('.registeredIdentity div button').hasClass('btn-danger')){
//                alert('请选择注册身份')
//        }else{
//           $('#tz').attr('href','rsg_two.html')
//        }

        $('.rsg_one').css('display','none')
        $('.rsg_two').css('display','block')
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
            $('#checkCode').val('')
            //产生验证码
            for (var i = 0; i < codeLength; i++) {
                code += parseInt(Math.random() * 9).toString();
            }
            //设置button效果，开始计时
            $("#btnSendCode").attr("disabled", "true");
            $("#btnSendCode").val( + curCount + "秒");
            InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
            //向后台发送处理数据
//            $.ajax({
//                type: "POST", //用POST方式传输
//                dataType: "text", //数据格式:JSON
//                url: '', //目标地址
//                data: "phone=" + phone + "&code=" + code,
//                error: function (XMLHttpRequest, textStatus, errorThrown) { },
//                success: function (msg){ }
//            });
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