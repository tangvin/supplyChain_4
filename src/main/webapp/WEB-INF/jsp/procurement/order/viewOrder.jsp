<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增合同1</title>
    <style>
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
            background: #f6f6f6
        }
        #span{
            display: block;
            float: right;
            margin-top: 1px;
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
            <a id="ddgla" style="cursor: pointer">订单管理</a>
            <span>></span>
            <a href="#">查看订单</a>
        </div>
        <!--合同签约 头部 end-->
        <div class="col-xs-12">
                <div class="row ckdd">
                    <div class="col-xs-8">
                        <h5>订单信息</h5>
                    </div>
                </div>
                <!--合同编辑表格 start-->
                <div class="table-responsive text-center" style="margin-left:-15px;margin-right:-15px;">
                    <table class="table table-bordered bj_table">
                        <tbody>
                        <tr>
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
                                <td class="col-xs-9 text-left"><span>${order.orderCreatorId}</span></td>
                        </tr>
                        <tr>
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>关联到合同：</td>
                                <td class="col-xs-9 text-left"><span>编号：${contract.contractNumber}    名称：${contract.contractName} </span></td>
                        </tr>
                        <tr>
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>货物商品：</td>
                                <td class="col-xs-9 text-left"><span>${order.goods}</span></td>
                        </tr>
                        <tr>
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单编号：</td>
                                <td class="col-xs-8 text-left"><span>${order.orderNumber}</span></td>
                        </tr>
                        <tr>
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单金额：</td>
                                <td class="col-xs-8 text-left"><span>${order.orderAmount}</span></td>
                        </tr>
                        <tr>
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>发票：</td>
                                <td class="col-xs-8 text-left"><img src="images/card_minsheng@1x.png"></td>
                        </tr>
                        <tr>
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单状态：</td>
                                <td class="col-xs-8 text-left">
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
                                    <form class="form-inline">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" id="id" checked="checked"><span id="span">是</span>
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <span >${order.applicationletter}</span>￥万元
                                        </div>
                                    </form>
                                </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!--合同编辑表格 end-->
        </div>
		
        <div class="col-xs-12" id="open">
            <div class="row ckdd">
                <div class="col-xs-8">
                    <h5>货运信息</h5>
                </div>
            </div>
            <!--合同编辑表格 start-->
            <div class="table-responsive text-center" style="margin-left:-15px;margin-right:-15px;">
                <table class="table table-bordered bj_table">
                    <tbody>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>发货人：</td>
                            <td class="col-xs-9 text-left"><span>${order.orderCreatorTradeId}</span></td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>货运单位：</td>
                            <td class="col-xs-9 text-left"><span>${freight.freightName}</span></td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>货运单号：</td>
                            <td class="col-xs-9 text-left"><span>${freight.freightNumber}</span><button class="btn" style="margin-left: 30px">查询物流信息</button></td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right">联系收货人：</td>
                            <td class="col-xs-9 text-left">
                                <span style="float: left;margin-top: 5px;">${freight.freightContactPerson}</span>
                            </td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right">联系人手机号：</td>
                            <td class="col-xs-9 text-left">
                                <span>${freight.freightContactPhone}</span>
                            </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!--合同编辑表格 end-->
        </div>
        <div class="col-xs-12">
            <div class="row ckdd">
                <div class="col-xs-8">
                    <h5>收货信息</h5>
                </div>
            </div>
            <!--合同编辑表格 start-->
            <div class="table-responsive text-center" style="margin-left:-15px;margin-right:-15px;">
                <table class="table table-bordered bj_table">
                    <tbody>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
                            <td class="col-xs-9 text-left"><span>${order.orderCreatorId}</span></td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>收货信息：</td>
                            <td class="col-xs-9 text-left"><span>${receivingAddress.rAddressArea}${receivingAddress.rAddressAddress}</span></td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>收货人：</td>
                            <td class="col-xs-9 text-left">
                                <span>${receivingAddress.rAddressPerson}</span>
                            </td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>联系人手机号：</td>
                            <td class="col-xs-9 text-left">
                               <%--  <span>${receivingAddress.rAddressPhone}</span> --%>
                            	 <span>${receivingAddress.rAddressPhone}</span>
                            </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!--合同编辑表格 end-->
        </div>
    </div>
</div>
</body>
<script>
$('#ddgla').click(function(){
    $('#load').load('<%=request.getContextPath()%>/procurementMain/ddgl.action')
})


    $('#id').click(function(){
        if($('#id').is(':checked')){
            $('#id1').removeAttr("disabled");
        }else{
            $('#id1').attr("disabled","disabled");
        }
    })
    //    $('#qd').click(function(){
    //
    //    })
$(function(){
    if(${order.orderStatus}==3||${order.orderStatus}==4){
        $('#open').css('display','block')
    }else{
        $('#open').css('display','none')
    }
})



</script>
</html>
