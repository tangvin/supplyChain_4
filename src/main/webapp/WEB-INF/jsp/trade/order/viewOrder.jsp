<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <style>
        .xzdd{
            margin-top:40px;
        }
        .bj_table{
            margin-left: -15px;
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
    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--新增订单 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a href="#" id="ddgl">订单管理</a>
            <span>></span>
            <a href="#">订单详情</a>
        </div>
        <!--合同签约 头部 end-->
        <div class="col-xs-12">
                <div class="row jbxx_row ckdd">
                    <div class="col-xs-8">
                        <h5>订单信息</h5>
                    </div>
                </div>
                <%--<div class="col-xs-12" style="background: red"></div>--%>
            <!--合同编辑表格 start-->
            <table class="table table-bordered bj_table">
                <tbody>
                <tr>
                    <td class="col-xs-3  text-right"><span class="xingxing">*</span>合同签约方：</td>
                    <td class="col-xs-9 text-left"><span>${order.orderCreator}</span></td>
                </tr>
                <tr>
                    <td class="col-xs-3 text-right"><span class="xingxing">*</span>关联到合同：</td>
                    <td class="col-xs-9 text-left"><span>合同编号：${contract.contractNumber}       合同名称：${contract.contractName}</span></td>
                </tr>
                <tr>
                    <td class="col-xs-3 text-right"><span class="xingxing">*</span>货物商品：</td>
                    <td class="col-xs-9 text-left"><span>${order.goods}</span></td>
                </tr>
                <tr>
                    <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单编号：</td>
                    <td class="col-xs-9 text-left"><span>${order.orderNumber}</span></td>
                </tr>
                <tr>
                    <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单金额：</td>
                    <td class="col-xs-9 text-left"><span>${order.orderAmount}</span></td>
                </tr>
                <tr>
                    <td class="col-xs-3 text-right"><span class="xingxing">*</span>发票：</td>
                    <td class="col-xs-9 text-left">${order.invoiceNum}<img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                </tr>
                <tr>
                    <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单状态：</td>
                    <td class="col-xs-9 text-left">
                                    <span>
                                        <c:if test="${order.orderStatus==0}">
                                            待确认
                                        </c:if>
                                        <c:if test="${order.orderStatus==1}">
                                            待付款
                                        </c:if>
                                        <c:if test="${order.orderStatus==2}">
                                            待发货
                                        </c:if>
                                        <c:if test="${order.orderStatus==3}">
                                            待收货
                                        </c:if>
                                        <c:if test="${order.orderStatus==4}">
                                            已完成
                                        </c:if>
                                        <c:if test="${order.orderStatus==5}">
                                            已关闭
                                        </c:if>
                                        <c:if test="${order.orderStatus==6}">
                                            已驳回
                                        </c:if>
                                    </span>
                    </td>
                </tr>
                <tr>
                    <td class="col-xs-3 text-right"><span class="xingxing">*</span>申请用信：</td>
                    <td class="col-xs-9 text-left">
                        <form class="form-inline">
                            <div class="form-group">
                                <input name="creditAmount" type="text" class="form-control" id="id1" disabled VALUE="${order.orderAmount}">￥万元
                            </div>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
            <!--合同编辑表格 end-->
        </div>

        <div class="col-xs-12" id="open">
            <div class="row jbxx_row ckdd">
                <div class="col-xs-8">
                    <h5>货运信息</h5>
                </div>
            </div>
            <!--合同编辑表格 start-->
            <div class="table-responsive text-center col-xs-12">
                <table class="table table-bordered bj_table">
                    <tbody>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>发货人：</td>
                            <td class="col-xs-9 text-left"><span>${order.orderCreatorTrade}</span></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>货运单位：</td>
                            <td class="col-xs-9 text-left"><span>${freight.freightName}</span></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>货运单号：</td>
                            <td class="col-xs-9 text-left"><span>${freight.freightNumber}</span></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right">联系收货人：</td>
                            <td class="col-xs-9 text-left">
                                <span style="float: left;margin-top: 5px;">${freight.freightContactPerson}</span>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right">联系人手机号：</td>
                            <td class="col-xs-8 text-left">
                                <span>${freight.freightContactPhone}</span>
                            </td>
                        </div>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!--合同编辑表格 end-->
        </div>




        <div class="col-xs-12">
            <div class="row jbxx_row ckdd">
                <div class="col-xs-8">
                    <h5>收货信息</h5>
                </div>
            </div>
            <!--合同编辑表格 start-->
            <div class="table-responsive text-center col-xs-12">
                <table class="table table-bordered bj_table">
                    <tbody>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
                            <td class="col-xs-9 text-left"><span>${order.orderCreator}</span></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>收货信息：</td>
                            <td class="col-xs-8 text-left"><span>收货地址：${receivingAddress.rAddressArea}${receivingAddress.rAddressAddress} ${receivingAddress.rAddressAddress}（默认收货信息）</span></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right">收货人：</td>
                            <td class="col-xs-8 text-left">
                                <span style="float: left;margin-top: 5px;">${receivingAddress.rAddressPerson}</span>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right">联系人手机号：</td>
                            <td class="col-xs-8 text-left">
                                <span>${receivingAddress.rAddressPhone}</span>
                            </td>
                        </div>
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

    $('#ddgl').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/ddgl.action')
    })

    $('#id').click(function(){
        if($('#id').is(':checked')){
            $('#id1').removeAttr("disabled");
        }else{
            $('#id1').attr("disabled","disabled");
        }
    })

$(function(){
        if(${order.orderStatus}==3||${order.orderStatus}==4){
            $('#open').css('display','block')
        }else{
            $('#open').css('display','none')
        }
    })






</script>
</html>

