<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@ include file="/common/include.jsp"%> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增订单</title>
    <style>
        .xzdd{
            /*margin-top:40px;*/
        }
        .bj_table tbody tr td input{
            width:200px;
        }
        .xzdd_hx_table tr td input{
            width:300px!important;
        }
        #id{
            width:20px;
        }
        .redio{
            width:20px!important;
        }
        .glshxx{
            margin-left:20px;
            display:block;
            background:#ddd;
            padding: 10px 10px;
            width:100px;
           color:#000000;
           border-radius: 4px;
        }
        .next{
          width: 120px;
          height: 40px;
          font-size: 16px;
            margin-top:20px;
        }
        #glshxx{
            text-decoration: none;
        }

        #span{
            display: block;
            float: right;
            margin-top: 1px;
        }
        .xzdd_hx_table tr td input{
            border: none;
            outline: none;
        }
        #ddd,#eee{
            width:100px;
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
            <div class="table-responsive text-center" style="margin-right:-15px;margin-left:-15px;">
            <form method="post">
                <table class="table table-bordered bj_table">
                    <tbody>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
                            <td class="col-xs-9 text-left"><input type="text" id="orderCreatorTrade"  class="form-control" placeholder="模糊检索匹配"></td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>关联到合同：</td>
                            <td class="col-xs-9 text-left"><input type="text" id="principalOrderId" class="form-control" placeholder="模糊检索匹配"></td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>货物商品：</td>
                            <td class="col-xs-9 text-left"><input type="text" id="goods" class="form-control"></td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单金额：</td>
                            <td class="col-xs-8 text-left"><input type="text" id="orderAmount" class="form-control" placeholder="￥万元"></td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>申请用信：</td>
                            <td class="col-xs-9 text-left">
                                <div class="form-inline">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" id="id"> <span id="span">是</span>
                                        </label>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" id="applicationletter" class="form-control" disabled>￥万元
                                    </div>
                                </div>
                            </td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>收货信息：</td>
                            <td class="col-xs-8 text-left">
	                            <span class="qwer">
                                    <span style="padding-right: 10px">收货地址：</span>
	                                <span id="address"></span>
	                            </span>
                                    <input id="receivingAddressId" type="hidden">
                                    <a class="glshxx" id="glshxx">
                                        <div class="gl">管理收货信息</div>
                                    </a>
                            </td>
                    </tr>
                    <tr class="qwer">
                            <td class="col-xs-3 text-right"></td>
                            <td class="col-xs-9 text-left">
                                <div class="text-left"><span style="padding-right: 25px">收货人：</span><span id="rAddressPerson"></span></div>
                            </td>
                    </tr>
                    <tr class="qwer">
                            <td class="col-xs-3 text-right"></td>
                            <td class="col-xs-9 text-left">
                                <div class="text-left"><span style="padding-right: 25px">手机号：</span><span id="rAddressPhone"></span></div>
                            </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            </div>

            <button id="bbb" type="button" class="btn btn-primary btn-lg col-xs-offset-3 next" data-toggle="modal" data-target="#myModal">下一步</button>
            </form>
             <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <form method="post" id="order"> 
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-body">
                            <div class="table-responsive text-center">
                            
                                <table class="table table-bordered bj_table xzdd_hx_table">
                                    <tbody>
                                    <tr>
                                            <td class="col-xs-3 text-right">合同签约方：</td>
                                            <td class="col-xs-9 text-left"><input  readonly="readonly" style="border: none;outline: none;" id="aaa" name="orderCreatorTrade"></td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right">关联到合同：</td>
                                            <td class="col-xs-9 text-left"><input readonly="readonly" id="fff" name="principalOrderId"><!-- <span>编号：2636464774376    名称：xxxx合同</span> --></td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right">货物商品：</td>
                                            <td class="col-xs-9 text-left"><input readonly="readonly" id="ccc" name="goods"></td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right">订单金额：</td>
                                            <td class="col-xs-9 text-left"><input readonly="readonly" id="ddd" name="orderAmount">￥万元</td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right">申请用信：</td>
                                            <td class="col-xs-9 text-left">
                                                <form class="form-inline">
                                                    <div class="checkbox">
                                                            <input id="eee" readonly="readonly" name="applicationletter">￥万元
                                                    </div>
                                                </form>
                                            </td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right">收货信息：</td>
                                            <td class="col-xs-9 text-left"><span style="padding-right: 15px">收货地址：</span><input id="sss" readonly="readonly" name="receivingAddress"><input id="zzz" type="hidden" name="receivingAddressId"></td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right"></td>
                                            <td class="col-xs-9 text-left">
                                                <span><span style="padding-right: 25px">收货人：</span><input readonly="readonly" id="mmm" name="ogisticsName"></span>
                                            </td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right"></td>
                                            <td class="col-xs-9 text-left">
                                                <span><span style="padding-right: 25px">手机号：</span><input readonly="readonly" id="ppp" name="contactPhone"></span>
                                            </td>
                                    </tr>
                                    </tbody>
                                </table>
                                 <input type="hidden" value="0" name="orderStatus">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal" id="confirm">确定</button>
                            <button type="button" class="btn" data-dismiss="modal">取消</button>
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
	$("#glshxx").click(function(){
		$('#load').load('<%=request.getContextPath()%>/procurementMain/glshxx.action')
	});
	$(function(){
		$.post(
			"<%=request.getContextPath()%>/pmorder/insetOrder.action",
			function(obj){
				/* //2有数据 */
				if(obj.receivingAddressId==null){
					$('#glshxx').show()
					$('.qwer').hide()
					$('#address').val('')
				}else if(obj.receivingAddressId!=null){
					$('#glshxx').hide()
					$('.qwer').show()
				}
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
		var orderCreatorTradeId=$("#aaa").val();
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
				orderCreatorTradeId:orderCreatorTradeId,
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
                setTimeout("$('#load').load('<%=request.getContextPath()%>/procurementMain/ddgl.action')",500);
			}
		}); 
	});
    
    
</script>
</html>