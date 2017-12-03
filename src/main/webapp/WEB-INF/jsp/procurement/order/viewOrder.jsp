<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增合同1</title>
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
        <!--合同签约 头部 end-->
        <div class="col-xs-12">
                <div class="row jbxx_row ckdd">
                    <div class="col-xs-8">
                        <h5>订单信息</h5>
                    </div>
                </div>
                <!--合同编辑表格 start-->
                <div class="table-responsive text-center col-xs-12">
                    <table class="table table-bordered bj_table">
                        <tbody>
                        <tr>
                            <div class="row">
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
                                <td class="col-xs-9 text-left"><span>贸易商企业名称</span></td>
                            </div>
                        </tr>
                        <tr>
                            <div class="row">
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>关联到合同：</td>
                                <td class="col-xs-9 text-left"><span>编号：2636464774376    名称：xxxx合同</span></td>
                            </div>
                        </tr>
                        <tr>
                            <div class="row">
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>货物商品：</td>
                                <td class="col-xs-9 text-left"><span>xxxxxx</span></td>
                            </div>
                        </tr>
                        <tr>
                            <div class="row">
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单编号：</td>
                                <td class="col-xs-8 text-left"><span>123243242342</span></td>
                            </div>
                        </tr>
                        <tr>
                            <div class="row">
                                <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单金额：</td>
                                <td class="col-xs-8 text-left"><span>200 ￥万元</span></td>
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
                                <td class="col-xs-8 text-left"><span>代发货</span></td>
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
                                            <input type="text" class="form-control" id="id1" disabled>￥万元
                                        </div>
                                    </form>
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
                            <td class="col-xs-9 text-left"><span>贸易商名称</span></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>货运单位：</td>
                            <td class="col-xs-9 text-left"><span>货运单位名称</span></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>货运单号：</td>
                            <td class="col-xs-9 text-left"><span>hejwezjdfsd</span><button class="btn" style="margin-left: 30px">查询物流信息</button></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right">联系收货人：</td>
                            <td class="col-xs-8 text-left">
                                <span style="float: left;margin-top: 5px;">某某</span>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right">联系人手机号：</td>
                            <td class="col-xs-8 text-left">
                                <span>14797359645</span>
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
                            <td class="col-xs-9 text-left"><span>贸易商企业名称</span></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>收货信息：</td>
                            <td class="col-xs-8 text-left"><span>收货地址：北京  北京市  丰台区  汉威国际广场4区2号楼  （默认收货信息）</span></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right">收货人：</td>
                            <td class="col-xs-8 text-left">
                                <span style="float: left;margin-top: 5px;">某某</span>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right">联系人手机号：</td>
                            <td class="col-xs-8 text-left">
                                <span>14797359645</span>
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


</script>
</html>

