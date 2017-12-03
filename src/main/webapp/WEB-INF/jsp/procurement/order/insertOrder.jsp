<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/include.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增订单</title>
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
    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--合同签约 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
            <span>></span>
            <a  id="ddglOrder" href="#">订单管理</a>
            <span>></span>
            <a href="#">新增订单</a>
        </div> 
         <!--合同签约 头部 end-->
        <div class="col-xs-12 xzdd">
             <!--合同编辑表格 start-->
             
            <div class="table-responsive text-center">
            <form action="pmgetorder/insertOrder" method="post">
                <table class="table table-bordered bj_table">
                    <tbody>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
                            <td class="col-xs-9 text-left"><input type="text" id="orderCreatorTrade" class="form-control" placeholder="模糊检索匹配"></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>关联到合同：</td>
                            <td class="col-xs-9 text-left"><input type="text" id="principalOrderId" class="form-control" placeholder="模糊检索匹配"></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>货物商品：</td>
                            <td class="col-xs-9 text-left"><input type="text" id="goods" class="form-control"></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><spain class="xingxing">*</span>订单金额：</td>
                            <td class="col-xs-8 text-left"><input type="text" id="orderAmount" class="form-control" placeholder="￥万元"></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>申请用信：</td>
                            <td class="col-xs-9 text-left">
                                <form class="form-inline">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" id="id"> 是
                                        </label>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" id="applicationletter" class="form-control" disabled>￥万元
                                    </div>
                                </form>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>收货信息：</td>
                            <td class="col-xs-8 text-left">收货地址:<span id="address"></span><input id="receivingAddressId" type="hidden"><button class="btn glshxx">管理收货信息</button></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"></td>
                            <td class="col-xs-8 text-left">
                            	<div class="col-xs-8 text-left">收货人:<span id="rAddressPerson"></div>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"></td>
                            <td class="col-xs-8 text-left">
                                <div class="col-xs-8 text-left">收货人手机:<span id="rAddressPhone"></span></div>
                            </td>
                        </div>
                    </tr>
                    </tbody>
                </table>
            </div>
            
            <button id="bbb" type="button" class="btn btn-primary btn-lg col-xs-offset-4 next" data-toggle="modal" data-target="#myModal">
               下一步
               
            </button>
            
            </form>
            
            
             <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <form method="post" id="order"> 
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-body">
                            <div class="table-responsive text-center">
                            
                                <table class="table table-bordered bj_table">
                                    <tbody>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3 text-right">合同签约方：</td>
                                            <td class="col-xs-9 text-left"><input  id="aaa" name="orderCreatorTrade"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3 text-right">关联到合同：</td>
                                            <td class="col-xs-9 text-left"><input id="fff" name="principalOrderId"><span>编号：2636464774376    名称：xxxx合同</span></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3 text-right">货物商品：</td>
                                            <td class="col-xs-9 text-left"><input id="ccc" name="goods"><span>XXXXX货物</span></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3 text-right">订单金额：</td>
                                            <td class="col-xs-8 text-left"><input id="ddd" name="orderAmount"><span>200 ￥万元</span></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>申请用信：</td>
                                            <td class="col-xs-9 text-left">
                                                <form class="form-inline">
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" class="redio"><input id="eee" name="applicationletter"><span>￥200万元</span>
                                                        </label>
                                                    </div>
                                                </form>
                                            </td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3 text-right">收货信息：</td>
                                            <td class="col-xs-8 text-left"><input id="sss" name="receivingAddress"><input id="zzz" type="hidden" name="receivingAddressId"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3 text-right"></td>
                                            <td class="col-xs-8 text-left">
                                                <span>收货人:<input id="mmm" name="ogisticsName"></span>
                                            </td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3 text-right"></td>
                                            <td class="col-xs-8 text-left">
                                                <span>联系人手机号:<input id="ppp" name="contactPhone"></span>
                                            </td>
                                        </div>
                                    </tr>
                                    </tbody>
                                </table>
                                 <input type="hidden" value="0" name="orderStatus">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal" id="confirm">确定</button>
                            <button type="button" class="btn btn-primary">取消</button>
                        </div>
                       
                    </div>
                </div>
                </form>
            </div>
        </div>

    </div>
</div>
</body>
<script>
	$(function(){
		$.post(
			"<%=request.getContextPath()%>/pmorder/insetOrder.action",
			function(obj){
				$("#address").append(obj.address);
				$("#rAddressPerson").append(obj.rAddressPerson);
				$("#rAddressPhone").append(obj.rAddressPhone);
				$("#receivingAddressId").val(obj.receivingAddressId);
			},"json"
		);
	});


	$("#bbb").click(function(){
		var a=$("#orderCreatorTrade").val();
		$("#aaa").val(a);
		var b=$("#principalOrderId").val();
		$("#fff").val(b);
		var c=$("#goods").val();
		$("#ccc").val(c);
		var d=$("#orderAmount").val();
		$("#ddd").val(d);
		var e=$("#applicationletter").val();
		$("#eee").val(e);
		//var s=$("#address").append("收货地址：'"+obj.address+"'（默认收货信息）").val();
		$("#sss").val($("#address").html());
		$("#zzz").val($("#receivingAddressId").val());
		$("#mmm").val($("#rAddressPerson").html());
		$("#ppp").val($("#rAddressPhone").html());
	});

    $('#id').click(function(){
        if($('#id').is(':checked')){
            $('#applicationletter').removeAttr("disabled");
        }else{
            $('#applicationletter').attr("disabled","disabled");
        }
    })


	$('#ddglOrder').click(function(){
	    $('#load').load('<%=request.getContextPath()%>/procurementMain/ddgl.action')
	})
	
	/*确认新增订单*/
	$("#confirm").click(function(){
		var telephone=$("#ppp").val();
		var orderCreatorTrade=$("#aaa").val();
		var goods=$("#ccc").val();
		var orderAmount=$("#ddd").val();
		var applicationletter=$("#eee").val();
		var principalOrderId=$("#fff").val();
		var receiver=$("#mmm").val();
		//var address=$("#sss").val();
		var receivingAddressId=$("#zzz").val();
		$.ajax({
			url:"<%=request.getContextPath()%>/pmorder/confirmOder.action",
			type:'post',
			data:{
				receiver:receiver,
				telephone:telephone,
				orderCreatorTrade:orderCreatorTrade,
				goods:goods,
				orderAmount:orderAmount,
				applicationletter:applicationletter,
				principalOrderId:principalOrderId,
				//address:address,
				receivingAddressId:receivingAddressId,
				},
			dataType:"json",
			success:function(data){
				alert("添加完成");
			}
		}); 
	});

</script>
</html>