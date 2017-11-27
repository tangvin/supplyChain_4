<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a href="#">我的设置</a>
        </div>
        <!--财物管理 头部 end-->
        <div class="col-xs-12" style="padding: 30px 0 0 100px">
            <p>消息通知方式（至少选择一项）</p>
            <div style="margin-left:100px;margin-top: 30px;margin-bottom: 30px;">
               	
                
                <label class="checkbox-inline" id="shortMessage2">
                <input type="checkbox" id="shortMessage" name="shortMessage" value="1" >手机短信通知            
                </label>
                 
                <label class="checkbox-inline" id="email2" >
               <input type="checkbox" id="email1" value="1"/> 邮箱通知 
              
               
              
                    
                </label>
            </div>
            <button type="button" id="save" class="btn btn-danger btn-default" style="margin-left:100px; width: 100px;height: 30px;">保存</button>
        </div>
    </div>
</div>
<script>
	 /* $(function () {
		var shortMessage=$("#shortMessage").val();
		var email=$("#email").val();
		console.log(email)
		//alert(shortMessage);
		if(shortMessage == 1){
			
			$("#shortMessage2 input[type='checkbox']").prop("checked",true);
		}else {
			$("#shortMessage2 input[type='checkbox']").prop("checked",false);
		}
		if(email == 1){
			
			$("#email2 input[type='checkbox']").prop("checked",true);
		}else {
			$("#email2 input[type='checkbox']").prop("checked",false);
		}
	}) 
	 */
	// console.log($('#shortMessage').val())
	$(function(){
		$.ajax({
			url:'<%=request.getContextPath()%>/setting/settingByUserId.action',
			type:'post',
			success:function(data){
				if($('#shortMessage').val()==data.setting.shortMessage){
					$('#shortMessage').attr('checked',true)
				}
				if($('#email1').val()==data.setting.email){
					$('#email1').attr('checked',true)
				}				
			}
		});
		
	})
	$(function(){
		
			$("#save").click(function(){
			
				var shortMessage=$("#shortMessage").val();
				var email=$("#email1").val();
			
				if($("#shortMessage").prop("checked") == true){
					shortMessage=1	
				}
				if($("#shortMessage").prop("checked") == false){
					shortMessage=0	
				}
			
				if($("#email1").prop("checked") == true){
					email=1	
				}
				if($("#email1").prop("checked") == false){
					email=0	
				}
			//alert(shortMessage);
			//alert(email);
				if($("#shortMessage").prop("checked") == false && $("#email1").prop("checked") == false){
					alert("请至少选择一项");
					return;
				}
			$.ajax({
				url:'<%=request.getContextPath()%>/setting/update.action',
				data:{
					shortMessage:shortMessage,
					email:email
					},
				type:'post',
				success:function(data){
					if(data.success){
						alert("保存成功");
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