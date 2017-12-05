<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/js/static/js/jquery.min.js"></script>
 --%><head>
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
            margin-bottom:15px;
        }
        #eid1,#eid2{
          display:none;
        }
    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--合同签约 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="gyl_index.html">系统首页</a>
            <span>></span>
            <a href="gyl_index.html?t=ddgl">订单管理</a>
            <span>></span>
            <a href="#">新增订单</a>
        </div>
     </div>
        <!--合同签约 头部 end-->
        
        
       	<form method="post" id="updateForm">
	       	<!-- //合同编辑 start -->
	       	<div id="eid1">
		        <div class="col-xs-12">
		            <div class="row jbxx_row ckdd">
		                    <div class="col-xs-8">
		                        <h5>订单信息1212312</h5>
		                    </div>
		            </div>
		            <div class="table-responsive text-center col-xs-12">
		                    <input type="hidden" value="${order.orderId}" name="orderId">
		                    <table class="table table-bordered bj_table">
		                        <tbody>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
		                                <td><input type="text" value="${order.orderCreator}" name="orderCreator"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>关联到合同：</td>
		                                <td class="col-xs-9 text-left"><input type="text" value="${contract.contractNumber}  name="contractName"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>货物商品：</td>
		                                <td class="col-xs-9 text-left"><input type="text" value="${order.goods}" name="goods"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单编号：</td>
		                                <td class="col-xs-8 text-left"><input type="text" disabled="disabled" value="${order.orderNumber}" name="orderNumber"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单金额：</td>
		                                <td class="col-xs-8 text-left"><input type="text" value="${order.orderAmount}" name="orderAmount"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>发票：</td>
		                                <td class="col-xs-8 text-left"><img src="images/card_minsheng@1x.png"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单状态：</td>
		                                <td class="col-xs-8 text-left"><input type="text" disabled='disabled' value="${order.orderStatus}" name="orderStatus"><span></span></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>申请用信：</td>
		                                <td class="col-xs-9 text-left">
		                                        <div class="checkbox">
		                                            <label>
		                                                <input type="checkbox" id="id" checked="checked"> 是
		                                            </label>
		                                        </div>
		                                        <div class="form-group">
		                                        <input type="text" value="${order.applicationletter}" name="applicationletter">￥万元
		                                        </div>
		                                </td>
		                            </div>
		                        </tr>
		                        </tbody>
		                    </table>
		            </div>
		        </div>
		        <div class="col-xs-12">
		            <div class="row jbxx_row ckdd">
		                <div class="col-xs-8">
		                    <h5>收货信息</h5>
		                </div>
		            </div>
		            <div class="table-responsive text-center col-xs-12">
	                <table class="table table-bordered bj_table">
	                    <tbody>
	                    <tr>
	                        <div class="row">
	                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
	                            <td class="col-xs-9 text-left"> <input type="text"  value="${order.orderCreator}"></td>
	                        </div>
	                    </tr>
	                    <tr>
	                        <div class="row">
	                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>收货信息：</td>
	                            <td class="col-xs-8 text-left"> <input type="text" value="${ra.rAddressArea}${ra.rAddressAddress}"
	                            	name="rAddressArea"
	                            ></td>
	                        </div>
	                    </tr>
	                    <tr>
	                        <div class="row">
	                            <td class="col-xs-3 text-right">收货人：</td>
	                            <td class="col-xs-8 text-left">
	                            <input type="text" value="${ra.rAddressPerson}" name="rAddressPerson">
	                            </td>
	                        </div>
	                    </tr>
	                    <tr>
	                        <div class="row">
	                            <td class="col-xs-3 text-right">联系人手机号：</td>
	                            <td class="col-xs-8 text-left">
	                            <input type="text" value="${ra.rAddressPhone}" name="rAddressPhone">
	                            </td>
	                        </div>
	                    </tr>
	                    </tbody>
	                </table>
	            </div>
	            </div>
		    </div>
		    
		    <div id="eid2">
		        <div class="col-xs-12">
		            <div class="row jbxx_row ckdd">
		                    <div class="col-xs-8">
		                        <h5>订单信息232434345</h5>
		                    </div>
		                </div>
		            <div class="table-responsive text-center col-xs-12">
		                <input type="hidden" value="${order.orderId}" name="orderId">
		                    <table class="table table-bordered bj_table">
		                        <tbody>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
		                                <td><input type="text" disabled='disabled' value="${order.orderCreator}" name="orderCreator"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>关联到合同：</td>
		                                <td class="col-xs-9 text-left"><input type="text" disabled='disabled' value="${contract.contractNumber}  name="contractName"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>货物商品：</td>
		                                <td class="col-xs-9 text-left"><input type="text" disabled='disabled' value="${order.goods}" name="goods"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单编号：</td>
		                                <td class="col-xs-8 text-left"><input type="text" disabled='disabled' value="${order.orderNumber}" name="orderNumber"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单金额：</td>
		                                <td class="col-xs-8 text-left"><input type="text" disabled='disabled' value="${order.orderAmount}" name="orderAmount"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>发票：</td>
		                                <td class="col-xs-8 text-left"><img src="images/card_minsheng@1x.png"></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单状态：</td>
		                                <td class="col-xs-8 text-left"><input type="text" disabled='disabled' value="${order.orderStatus}" name="orderStatus"><span></span></td>
		                            </div>
		                        </tr>
		                        <tr>
		                            <div class="row">
		                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>申请用信：</td>
		                                <td class="col-xs-9 text-left">
		                                        <div class="checkbox">
		                                            <label>
		                                                <input type="checkbox" id="id" checked="checked"> 是
		                                            </label>
		                                        </div>
		                                        <div class="form-group">
		                                        <input type="text" value="${order.applicationletter}" name="applicationletter">￥万元
		                                        </div>
		                                </td>
		                            </div>
		                        </tr>
		                        </tbody>
		                    </table>
		                </div>
		        </div>
		        <div class="col-xs-12">
	            <div class="row jbxx_row ckdd">
	                <div class="col-xs-8">
	                    <h5>收货信息</h5>
	                </div>
	            </div>
	            <div class="table-responsive text-center col-xs-12">
	                <table class="table table-bordered bj_table">
	                    <tbody>
	                    <tr>
	                        <div class="row">
	                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
	                            <td class="col-xs-9 text-left"><input type="text" disabled='disabled' value="${order.orderCreator}"></td>
	                        </div>
	                    </tr>
	                    <tr>
	                        <div class="row">
	                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>收货信息：</td>
	                            <td class="col-xs-8 text-left"> <input type="text" value="${ra.rAddressArea}${ra.rAddressAddress}"
	                            	name="rAddressArea">
	                            	<select id="s">
	                            		<option value="">--请选择--</option>
	                            	</select>
	                            </td>
	                        </div>
	                    </tr>
	                    <tr>
	                        <div class="row">
	                            <td class="col-xs-3 text-right">收货人：</td>
	                            <td class="col-xs-8 text-left">
	                            <input type="text" value="${ra.rAddressPerson}" name="rAddressPerson">
	                            </td>
	                        </div>
	                    </tr>
	                    <tr>
	                        <div class="row">
	                            <td class="col-xs-3 text-right">联系人手机号：</td>
	                            <td class="col-xs-8 text-left">
	                            <input type="text" value="${ra.rAddressPhone}" name="rAddressPhone">
	                            </td>
	                        </div>
	                    </tr>
	                    </tbody>
	                </table>
	            </div>
	        </div>
		    </div>  
       
        </form>
</body>
<script type="text/javascript">
$(function(){
	$('#id').click(function(){
        if($('#id').is(':checked')){
            $('#id1').removeAttr("disabled");
        }else{
            $('#id1').attr("disabled","disabled");
        }
    })
    
   $("#sureUpdate").click(function(){
	   	 $.ajax({
	            url:'<%=request.getContextPath()%>/pmorder/updateOrder.action',
	            data:$("#updateForm1").serialize(),
	            type:'post',
	            dataType:'json',
	            success:function(data){
	           	 alert("编辑成功")
	            }
	        });
   });
	
	if(${order.orderStatus}==0 || ${order.orderStatus}==6){
		$('#eid1').css('display','block')
	}else{
		$('#eid2').css('display','block')
	}
	
	
	
});

</script>
</html>
