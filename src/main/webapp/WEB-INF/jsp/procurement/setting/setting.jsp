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
                    <input type="checkbox" id="shortMessage" value="1"> 手机短信通知
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" id="email" value="1"> 邮箱通知
                </label>
            </div>
            <button type="button" id="save" class="btn btn-danger btn-default" style="margin-left:100px; width: 100px;height: 30px;">保存</button>
        </div>
    </div>
</div>

<script>
	
	$(function(){
		$.ajax({
			url:'<%=request.getContextPath()%>/proSetting/settingByUserId.action',
			type:'post',
			success:function(data){
				if($('#shortMessage').val()==data.setting.shortMessage){
					$('#shortMessage').attr('checked',true)
				}
				if($('#email').val()==data.setting.email){
					$('#email').attr('checked',true)
				}				
			}
		});
		
	})
	$(function(){
		
			$("#save").click(function(){
			
				var shortMessage=$("#shortMessage").val();
				var email=$("#email").val();
			
				if($("#shortMessage").prop("checked") == true){
					shortMessage=1	
				}
				if($("#shortMessage").prop("checked") == false){
					shortMessage=0	
				}
			
				if($("#email").prop("checked") == true){
					email=1	
				}
				if($("#email").prop("checked") == false){
					email=0	
				}
			//alert(shortMessage);
			//alert(email);
				if($("#shortMessage").prop("checked") == false && $("#email").prop("checked") == false){
					alert("请至少选择一项");
					return;
				}
			$.ajax({
				url:'<%=request.getContextPath()%>/proSetting/update.action',
				data:{
					shortMessage:shortMessage,
					email:email
					},
				type:'post',
				success:function(data){
					if(data.success){
						alert("保存成功");
						setTimeout("$('#load').load('<%=request.getContextPath()%>/procurementMain/setting.action')",500);
					}else{
						alert("保存失败");					
					}
				}
			})
			
		})
	})
    </script>
</body>
</html>