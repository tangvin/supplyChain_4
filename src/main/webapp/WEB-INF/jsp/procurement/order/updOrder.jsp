<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑</title>
    <style>
        .xzdd{
            margin-top:40px;
        }
        .bj_table tbody tr td input{
            width:200px;
        }
        #id{
            width:20px;
        }
        .redio{
            width:20px!important;
        }
        .glshxx{
            margin-left:20px;
        }
        .next{
            width: 120px;
            height: 40px;
            font-size: 16px;
        }
		.ckdd{
			margin-bottom:10px;
		}
		#form1,#form2{
			margin-left: -15px;
			margin-right: -15px;
		}
      #span {
		   display: block;
		   float: right;
		   margin-top: 2px;
	   }
		.bj_table tbody tr td input{
			font-size: 12px;
		}
    </style>
</head>
<body>
<div class='col-xs-12'>
	    <div class='row'>
        <!--合同签约 头部-->
			<div class="col-xs-12 zlxx_top">
				<a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
				<span>></span>
				<a href="#" id="ddgls">订单管理</a>
				<span>></span>
				<a href="#">订单编辑</a>
			</div>
        </div>
        <!--合同签约 头部 end-->
	       	<!-- //合同编辑 start -->
	<%--eid1 开始--%>
	       	<div id="eid1">
	<%--eid1 from 表单 开始--%>
	            <form id="form1" method="post">
					<div class="col-xs-12">
						<div class="row jbxx_row">
							<div style="padding: 0 10px">
							   <h5>订单信息1212312</h5>
							</div>
						</div>
						<div class="table-responsive text-center" style="margin: 0 -15px">
								<input type="hidden" value="${order.orderId}" name="orderId">
								<input type="hidden" value="${order.receivingAddressId}" name="receivingAddressId">
								<table class="table table-bordered bj_table">
									<tbody>
									<tr>
										<td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
										<td class="col-xs-9 text-left"><input class="form-control"  type="text" value="${order.orderCreatorId}" name="orderCreatorId"></td>
									</tr>
									<tr>
										<td class="col-xs-3 text-right"><span class="xingxing">*</span>关联到合同：</td>
										<td class="col-xs-9 text-left"><input class="form-control"  type="text" value="${contract.contractNumber}  name="contractName"></td>
									</tr>
									<tr>
										<td class="col-xs-3 text-right"><span class="xingxing">*</span>货物商品：</td>
										<td class="col-xs-9 text-left"><input class="form-control"  type="text" value="${order.goods}" name="goods"></td>
									</tr>
									<tr>
										<td class="col-xs-3 text-right"><span class="xingxing">*</span>订单编号：</td>
										<td class="col-xs-9 text-left"><input class="form-control"  type="text" disabled="disabled" value="${order.orderNumber}" name="orderNumber"></td>
									</tr>
									<tr>
										<td class="col-xs-3 text-right"><span class="xingxing">*</span>订单金额：</td>
										<td class="col-xs-9 text-left"><input class="form-control"  type="text" value="${order.orderAmount}" name="orderAmount"></td>
									</tr>
									<tr>
										<td class="col-xs-3 text-right"><span class="xingxing">*</span>发票：</td>
										<td class="col-xs-9 text-left"><img src="images/card_minsheng@1x.png"></td>
									</tr>
									<tr>
										<td class="col-xs-3 text-right"><span class="xingxing">*</span>订单状态：</td>
										<td class="col-xs-9 text-left" disabled='disabled'>
												<c:if test="${order.orderStatus == 0}">
		                                            待确认
		                                        </c:if>
		                                        <c:if test="${order.orderStatus == 1}">
		                                           待付款
		                                        </c:if>
		                                        <c:if test="${order.orderStatus == 2}">
		                                          待发货
		                                        </c:if>
		                                        <c:if test="${order.orderStatus == 3}">
		                                          待收货
		                                        </c:if>
		                                        <c:if test="${order.orderStatus == 4}">
		                                          已完成
		                                        </c:if>
		                                        <c:if test="${order.orderStatus == 5}">
		                                          已关闭
		                                        </c:if>
		                                        <c:if test="${order.orderStatus == 6}">
		                                         已驳回
		                                        </c:if>
											
										</td>
									</tr>
									<tr>
										<td class="col-xs-3 text-right"><span class="xingxing">*</span>申请用信：</td>
										<td class="col-xs-9 text-left">
											<div class="form-inline">
													<div class="checkbox">
														<label>
															<input  type="checkbox" id="id" checked="checked">
															<span id="span">是</span>
														</label>
													</div>
													<div class="form-group">
														  <input class="form-control"  type="text" id="id1" value="${order.applicationletter}" name="applicationletter">￥万元
													</div>
											</div>
										</td>
									</tr>
									</tbody>
								</table>
						   </div>
					</div>



					<div class="col-xs-12">
		            <div class="row jbxx_row">
		                <div style="padding: 0 10px;">
		                <!-- 收货信息1是待确认状态 -->
		                    <h5>收货信息</h5>
		                </div>
		            </div>
		            <div class="table-responsive text-center" style="margin: 0 -15px;">
	                <table class="table table-bordered bj_table">
	                    <tbody>
	                    <tr>
	                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
	                            <td class="col-xs-9 text-left"> <input type="text" class="form-control"  value="${order.orderCreatorId}"></td>
	                    </tr>
	                    <tr>
	                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>收货信息1：</td>
	                            <td class="col-xs-9 text-left">
									<div class="form-inline">
										<input type="text" style="width: 200px;" value="" disabled class="xxdz form-control" name="rAddressArea">
										<select class="ss form-control" style="width: 200px;font-size: 12px;margin-left:20px;">

										</select>
									</div>
	                            </td>
	                            <input  type="hidden" name="rAddressId" id="rAddressId" />
	                    </tr>
	                    <tr>
	                            <td class="col-xs-3 text-right">收货人1：</td>
	                            <td class="col-xs-9 text-left">
	                            <input type="text"  value="" disabled name="rAddressPerson" class="shr form-control">
	                            </td>
	                    </tr>
	                    <tr>
	                            <td class="col-xs-3 text-right">联系人手机号1：</td>
	                            <td class="col-xs-9 text-left">
	                            <input type="text"  value="" disabled name="rAddressPhone" class="sjh form-control">
	                            </td>
	                    </tr>
	                    </tbody>
	                </table>
	            </div>
	            </div>


	                <button id="sureUpdate1" class="btn  btn-danger">确定修改</button>
	            </form>
	<%--eid1 from 表单 结束--%>
		    </div>
		    
		    
	<%--eid1 结束--%>
	<%--eid 2 开始--%>
		    <div id="eid2">
				<form id="form2" method="post">
					<div class="col-xs-12">
						<div class="row jbxx_row">
							<div style="padding: 0 10px;">
							    <h5>订单信息76656454</h5>
							</div>
						</div>
						<div class="table-responsive text-center" style="margin: 0 -15px;">
								<input type="hidden" value="${order.orderId}" name="orderId">
								<table class="table table-bordered bj_table">
						            <tbody>
										<tr>
											<td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
											<td class="col-xs-9 text-left"><input class="form-control" type="text" disabled="disabled" value="${order.orderCreatorId}" name="orderCreatorId"></td>
										</tr>
										<tr>
											<td class="col-xs-3 text-right"><span class="xingxing">*</span>关联到合同：</td>
											<td class="col-xs-9 text-left"><input class="form-control" type="text" disabled="disabled" value="${contract.contractNumber}  name="contractName"></td>
										</tr>
										<tr>
											<td class="col-xs-3 text-right"><span class="xingxing">*</span>货物商品：</td>
											<td class="col-xs-9 text-left"><input class="form-control" type="text" disabled="disabled" value="${order.goods}" name="goods"></td>
										</tr>
										<tr>
											<td class="col-xs-3 text-right"><span class="xingxing">*</span>订单编号：</td>
											<td class="col-xs-9 text-left"><input class="form-control" type="text" disabled="disabled" value="${order.orderNumber}" name="orderNumber"></td>
										</tr>
										<tr>
											<td class="col-xs-3 text-right"><span class="xingxing">*</span>订单金额：</td>
											<td class="col-xs-9 text-left"><input class="form-control" type="text" disabled="disabled" value="${order.orderAmount}" name="orderAmount"></td>
										</tr>
										<tr>
											<td class="col-xs-3 text-right"><span class="xingxing">*</span>发票：</td>
											<td class="col-xs-9 text-left"><img src="images/card_minsheng@1x.png"></td>
										</tr>
										<tr>
											<td class="col-xs-3 text-right"><span class="xingxing">*</span>订单状态：</td>
											<td class="col-xs-9 text-left"><input class="form-control" type="text" disabled='disabled' value="${order.orderStatus}" name="orderStatus"><span></span></td>
										</tr>
										<tr>
											<td class="col-xs-3 text-right"><span class="xingxing">*</span>申请用信：</td>
											<td class="col-xs-9 text-left">
												<div class="form-inline">
													<div class="checkbox">
														<label>
															<input type="checkbox" id="id" checked="checked">
															<span id="span">是</span>
														</label>
													</div>
													<div class="form-group">
														 <input type="text" class="form-control" id="id1" value="${order.applicationletter}" name="applicationletter">￥万元
													</div>
												</div>
											</td>
										</tr>
						             </tbody>
						         </table>
						 </div>
					</div>

					<div class="col-xs-12">
						<div class="row jbxx_row">
								<div style="padding: 0 10px;">
										<h5>收货信息</h5>
								 <!-- 收货信息2是待付款状态 -->
								</div>
						</div>
						<div class="table-responsive text-center" style="margin:0 -15px;">
							 <table class="table table-bordered bj_table">
							<tbody>
							<tr>
								<td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
								<td class="col-xs-9 text-left"> <input class="form-control" type="text" disabled value="${order.orderCreatorId}"></td>
							</tr>
							<tr>
								<td class="col-xs-3 text-right"><span class="xingxing">*</span>收货信息2：</td>
								<td class="col-xs-9 text-left">
									<div class="form-inline">
										<input style="width: 200px;" type="text" value="${ra.rAddressAddress}" disabled class="xxdz form-control" name="rAddressArea">
										<select class="ss form-control" id="dd" style="width: 200px;margin-left: 20px;font-size: 12px;">

										</select>
										<input type="hidden" name="rAddressId" id="rAddressId" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="col-xs-3 text-right">收货人2：</td>
								<td class="col-xs-9 text-left">
								<input type="text" value="${ra.rAddressPerson}" disabled name="rAddressPerson" class="shr form-control">
							</td>
							</tr>
							<tr>
								<td class="col-xs-3 text-right">联系人手机号2：</td>
								<td class="col-xs-9 text-left">
								    <input type="text" value="${ra.rAddressPhone}" disabled name="rAddressPhone" class="sjh form-control">
								</td>
							</tr>
						</tbody>
						     </table>
						</div>
					</div>
					<button id="sureUpdate2" class="btn  btn-danger">确定修改</button>
				</form>
			<%--eid2 from 表单 结束--%>
		    </div>


	<%--eid 2 结束--%>
	</div>
</body>
<script>
$('#ddgls').click(function(){
    $('#load').load('<%=request.getContextPath()%>/procurementMain/ddgl.action')
})

/* 获取下拉框的值 */
$.ajax({
    url:'<%=request.getContextPath()%>/pmorder/addresshx.action',
    type:'post',
    success:function(data){
        function setDiv(item){
            var option='<select>' +
                       '<option value='+item.rAddressId+'>'+item.rAddressArea+''+item.rAddressAddress+'</option>' +
                       '</select>'
            return option;
        }
        function getnoApplicationData111(){
            var html = ''
            for(var i = 0;i<data.data.length;i++){
                html += setDiv(data.data[i]);
            }
            $('.ss').html(html);
        }
        getnoApplicationData111();
        
        var adid = $('.ss').children('option:selected').val();
        $('#rAddressId').attr('value',adid);

        $('.ss').change(function(){
        $('#rAddressId').attr('value',$(this).children('option:selected').val());
	    for(var i=0;i<data.data.length;i++){
	        if($(this).children('option:selected').val()==data.data[i].rAddressId){
	            //console.log(data.data[i])
	            $('.xxdz').val(data.data[i].rAddressArea+data.data[i].rAddressAddress)
	            $('.shr').val(data.data[i].rAddressPerson);
	            $('.sjh').val(data.data[i].rAddressPhone); 
	        }
	    }
      })
       
     
	    var addressId='${order.receivingAddressId}';
	    for(var i=0;i<data.data.length;i++){
        	if(data.data[i].rAddressId==addressId){
        		$('.xxdz').val(data.data[i].rAddressArea+data.data[i].rAddressAddress)
	            $('.shr').val(data.data[i].rAddressPerson);
	            $('.sjh').val(data.data[i].rAddressPhone);
        	}
        }
       
        $(function(){
        	var select=document.querySelectorAll('.ss option')
        	 for(var i=0;i<select.length;i++){
             	if(select[i].value==addressId){
             		$(select[i]).attr('selected',true)
             	}
        	}  	
        })
        
    }
})


$(function(){
	$('#id').click(function(){
        if($('#id').is(':checked')){
            $('#id1').removeAttr("disabled");
        }else{
            $('#id1').attr("disabled","disabled");
        }
    })
});  
  		/* 编辑待确认和已驳回 */
    
     $("#sureUpdate1").click(function(){
	   	 $.ajax({
	            url:'<%=request.getContextPath()%>/pmorder/updateOrder.action',
	            data:$("#form1").serialize(),
	            type:'post',
	            dataType:'json',
	            success:function(data){
	            	if(data.success){
	            		alert(data.msg);
		            	setTimeout("$('#load').load('<%=request.getContextPath()%>/procurementMain/ddgl.action')",500);
	            	}else{
	            		alert(data.msg);
	            	}
	            }
	        });
  		 });
		/*编辑待付款*/
    	$("#sureUpdate2").click(function(){
		 $.ajax({
	         url:'<%=request.getContextPath()%>/pmorder/updateOrder.action',
	         data:$("#form2").serialize(),
	         type:'post',
	         dataType:'json',
	         success:function(data){
	         	if(data.success){
            		alert(data.msg);
	            	setTimeout("$('#load').load('<%=request.getContextPath()%>/procurementMain/ddgl.action')",500);
            	}else{
            		alert(data.msg);
            	}
	         }
	     });
 });

	if(${order.orderStatus}==0 || ${order.orderStatus}==6){
		$('#eid2').html('')
	}else{
		$('#eid1').html('')
	}
	
	
	


</script>
</html>
