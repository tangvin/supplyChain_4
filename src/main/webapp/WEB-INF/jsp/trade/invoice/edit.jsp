<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
   <script type="text/javascript" src="<%=request.getContextPath()%>/js/static/js/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/static/js/jquery.form.js"></script> 
</head>

<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--财物管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a id="fpgl1" href="#">发票管理</a>
            <span>></span>
            <a href="#">编辑发票</a>
        </div>
        <!--财物管理 头部 end-->
        
        <div class="col-xs-12" style="margin-top: 40px;">
            <div class="tab-pane" id="profile">
                <div class="row">
                
                    <div class="col-xs-6">
                    <form id="invoiceForm" onsubmit="return checkInvoiceForm();" action="<%=request.getContextPath()%>/traInvoice/update.action" method="post" enctype="multipart/form-data" class="form-horizontal" role="form" >
                   
                           <input type="hidden" class="form-control" name="id" id="id" value="${invoiceRecord.id }">
                            <div class="form-group">
                                <label for="firstname" class="col-xs-4 control-label"><span class="xingxing">*</span>发票号</label>
                                <div class="col-xs-8">
                                    <input type="text" class="form-control" name="invoiceNo" id="invoiceNo" value="${invoiceRecord.invoiceNo }"><span id="checkInvoiceNo" class="requireSpan" style="color:red;"></span></input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastname" class="col-xs-4 control-label"><span class="xingxing">*</span>开票人</label>
                                <div class="col-xs-8">
                                    <input type="text" class="form-control" id="drawer" name="drawer" value="${invoiceRecord.drawer }" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastname" class="col-xs-4 control-label"><span class="xingxing">*</span>收票人</label>
                                <div class="col-xs-8">
                                    <input type="text" class="form-control" id="checkTaker" name="checkTaker"  value="${invoiceRecord.checkTaker }" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastname" class="col-xs-4 control-label"><span class="xingxing">*</span>所属订单</label>
                                <div class="col-xs-8">
                                    <input type="text" class="form-control" id="orderNumber" name="orderNumber" value="${invoiceRecord.orderNumber }" readonly="readonly">
                                </div>
                            </div>
                            
                            <div class="from-group">
                                    <label for="lastname" class="col-xs-4 control-label"><span class="xingxing">*</span>上传发票</label>
									<div class="col-xs-8">
										<input type="file" name="uploadFile" onchange="checkImages();" /> 
										<input type="hidden" name="attachmentUrl" value="${invoiceRecord.attachmentUrl }" /> 
										<input type="hidden" id="invoiceFileAttachment" name="invoiceFileAttachment" value="${invoiceRecord.invoiceFileAttachment }" />
										<img src="${invoiceRecord.attachmentUrl }" style="width: 200px; height: 100px;" /><br>
										 <span id="checkImages" class="requireSpan" style="color: red;"></span>
									</div>
							<%-- <img id="headimg" src="${invoiceRecord.attachmentUrl }" style="cursor:pointer;" height="100px;" width="200px;">
                    <input id="headurladd" type="file" name="headUrl1" onchange="readFile(this)" style="display: none;" />
                    <input type="hidden" name="headUrl" id="logo" value="${invoiceRecord.attachmentUrl }" />
                    <input type="hidden" id="attId" name="image" value="${invoiceRecord.invoiceFileAttachment }" /> --%>
                            </div>
                            </form>
							<div class="form-group">
                                <div class="col-xs-offset-4 col-xs-8">
                                    <button id="upBtn" type="button" class="btn  btn-danger aq_qr_but">确认</button>
                                </div>
                            </div>

                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
$(function(){
	$("#upBtn").click(function(){
		$("#invoiceForm").submit();
	});
	
	$("#invoiceNo").blur(function(){
		
		var invoiceNo = $("#invoiceNo").val();
		//不能为空且长度不能超过25
		if(invoiceNo == ""){
			$("#checkInvoiceNo").text("发票号不能为空！");
		}else if(invoiceNo.length > 25){
			$("#checkInvoiceNo").text("发票号长度不能超过25！");
		}else{
			$("#checkInvoiceNo").text("");
		}
	});
})
	function checkImages(){
	//获取图片控件
	var imageElts = $("input[name='uploadFile']");
	//验证图片后缀名称
	var regExp = /(.*).(jpg|bmp|gif|jpeg|png)$/;
	//遍历图片控件
	$.each(imageElts,function(i,n){
		//判断控件值是否为空：为空不验证，保留之前的图片，不为空，更新此图片需要进行验证
		if($(n).val() != ""){
			if(!regExp.test($(n).val())){
				$("#checkImages").text("图片仅支持以下 jpg|bmp|gif|jpeg|png 格式！");
				return false;
			}else{
				$("#checkImages").text("");
			}
		}
	})
}


    $('#fpgl1').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/fpgl.action')
	})
</script>
</html>