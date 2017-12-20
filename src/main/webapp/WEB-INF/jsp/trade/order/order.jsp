<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--订单管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a href="#">订单管理</a>
        </div>
        <!--订单管理 头部 end-->
        <div class="col-xs-12">
            <!--合同签约 状态-->
            <div class="khh">
                <form class="form-inline khh_form khh_form1" id="orderform">
                    <div class="form-group">
                        <label>状态：</label>
                        <select class="form-control select" id="orderStatus">
                            <option value="">全部</option>
                            <option value="0">待确认</option>
                            <option value="1">待付款</option>
                            <option value="2">待发货</option>
                            <option value="3">待收货</option>
                            <option value="4">已完成</option>
                            <option value="5">已关闭</option>
                        </select>
                    </div>
                    <div class="form-group form-group1">
                        <label>订单时间：</label>
                        <select class="form-control" id="custom">
                            <option value="">自定义时间</option>
                            <option value="">请选择</option>
                            <option value="0">一月内</option>
                            <option value="1">三月内</option>
                            <option value="2">六月内</option>
                            <option value="3">一年内</option>
                        </select>
                        <input class="form-control"  readonly="readonly"  id="creatTime" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})" placeholder="开始日期"/>至
                        <input  class="form-control"  readonly="readonly"  id="endTime" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'creatTime\')}'})" placeholder="结束日期"/>
                    </div>
                    <div class="form-group">
                        <label>签约方：</label>
                        <input type="text" class="form-control" id="procurementEntName">
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<label>合同</label>--%>
                        <%--<input type="text" class="form-control" id="contractName">--%>
                    <%--</div>--%>
                    <button type="button" class="btn btn-danger btn-default" onclick="search()">查询</button>
                    <button type="button" class="btn btn-danger btn-default" onclick="reset()">重置</button>
                </form>
            </div>

                <table id="tb_departments" class="cj_table"></table>

            <!--领取订单 模态框-->
            <div class="modal fade bs-example-modal-sm lqdd_fh" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="panel-body text-center">
                            确定领取订单吗？
                        </div>
                        <div class="modal-footer">
                            <button id="lqdd" type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--领取订单 模态框-->

            <!--领取订单 模态框-->
            <div class="modal fade bs-example-modal-sm_bh lqdd_fh" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button   type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">请输入驳回理由：</h4>
                        </div>
                        <form id="bohuireason">
                        <div class="panel-body text-center">
                            <textarea  name="rejectReason" class="form-control" rows="3" width="200px"></textarea>
                        </div>
                        </form>
                        <div class="modal-footer">
                            <button type="button" id="ddbh" class="btn btn-default" data-dismiss="modal">确定</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--领取订单 模态框-->

            <!--配置发货 模态框-->
            <div class="modal fade bs-example-modal-pzfh" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <form  id="formId" method="post" >
                    <div class="modal-content">
                        <div class="modal-header">
                            <button   type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">配置发货</h4>
                        </div>
                        <div class="modal-body">
                            <div class="table-responsive text-center">
                                <table class="table table-bordered bj_table">
                                    <tbody id="wyb">

                                    </tbody>
                                </table>
                            </div>

                            <div class="table-responsive">
                            <%--<form id="pzfh"  action="<%=request.getContextPath()%>/tradeOrder/pzfh.action"  method="post" enctype="multipart/form-data">--%>

                            <table class="table htbg pzfh">
                                <tbody>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3"><span class="xingxing">*</span>货运单位：</td>
                                            <td class="col-xs-8">
                                                <div class="row pzfh_row">
                                                    <div class="col-xs-5 pzfh_row_div">
                                                        <select class="form-control" id="pzfh_select" name="freightName">
                                                        </select>
                                                    </div>
                                                    <div class="col-xs-5">
                                                    <button  id="orderFreight" type="button" data-dismiss="modal" class="btn btn-danger btn-default">管理货运单位</button>
                                                    </div>
                                                </div>
                                            </td>
                                        </div>
                                    </tr>
                                <tr>
                                    <div class="row">
                                        <td class="col-xs-3"><span class="xingxing">*</span>货运编号:</td>
                                        <td class="col-xs-8">
                                            <div class="row row_ddje">
                                                <div class="col-xs-5 row_ddje_div">
                                                    <input type="text" name="freightUnit" class="form-control">
                                                </div>
                                            <div class="col-xs-6 row_ddje_con">
                                                暂未查询到货运单位，请检查
                                            </div>
                                            </div>
                                        </td>
                                    </div>
                                </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3"><span class="xingxing">*</span>发票号:</td>
                                            <td class="col-xs-8">
                                                <div class="row row_ddje">
                                                    <div class="col-xs-5 row_ddje_div">
                                                        <input type="text" name="invoiceNo class="form-control">
                                                    </div>
                                                </div>
                                            </td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3"><span class="xingxing">*</span>上传发票：</td>
                                            <td class="col-xs-9 text-left">
                                                <div class="row" style="margin-right:0;">
                                                    <div class="col-xs-2">
                                                        <div id="inputBox" class="inputBox1 inputBox2">
                                                            <input type="file" title="请选择图片" id="file" multiple accept="image/png,image/jpg,image/gif,image/JPEG"/>
                                                            <span class="jiahao jaihao1">+</span>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-8">
                                                        <div id="imgBox"></div>
                                                    </div>
                                                </div>
                                            </td>
                                        </div>
                                    </tr>

                                </tbody>
                            </table>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-default" data-dismiss="modal" id="pzfh">确认</button>
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                                </div>
                            </form>
                            </div>

                        </div>

                    </div><!-- /.modal-content -->

                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!--配置发货 模态框-->
            <!--合同表格 结束-->
        </div>
    </div>
</div>
</body>
<script>
    $('#birthday').daterangepicker({ singleDatePicker: true }, function(start, end, label) {
        console.log(start.toISOString(), end.toISOString(), label);
    });
    $('#birthday1').daterangepicker({ singleDatePicker: true }, function(start, end, label) {
        console.log(start.toISOString(), end.toISOString(), label);
    });

   $('#orderFreight').click(function () {
       setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/hygl.action')",500);
   });

    imgUpload({
        inputId:'file', //input框id
        imgBox:'imgBox', //图片容器id
        buttonId:'btn', //提交按钮id
        upUrl:'',  //提交地址
        data:'file1',//参数名
    })

    /* 订单列表展示 */
    $(function(){
        $("#tb_departments").bootstrapTable({
            //隔行变色
//            striped:true,
            columns:[
                {field:'orderNumber',title:'订单编号',formatter:operateFormatter,events:operateEvents1},
                {field:'orderStatus',title:'订单状态',
                    formatter: function(value,row,index){
                        if( value == '0') {
                            return "待确认";
                        } else if(value == '1') {
                            return "待付款";
                        } else if(value == '2') {
                            return "待发货";
                        } else if(value == '3') {
                            return "待收货";
                        } else if(value == '4') {
                            return "已完成";
                        } else if(value == '5') {
                            return "已关闭";
                        }else if(value==6){
                            return "已驳回";
                        }else if(value==7){
                            return "历史";
                        }
                    }
                },
                {field:'orderAmount',title:'订单金额（￥万元）'},
                {field:'orderConfirmationTime',title:'订单相关时间',
                    formatter:function(value,row,index){
                        return ConvertToDate(value)
                    }
                },
                {field:'orderCreatTime',title:'订单创建时间',
                    formatter:function(value,row,index){
                        var str='';
                        str+='<p>'+row.procurementEntName+'</p><p>'+ConvertToDate(value)+'</p>'
                        return str
                    }
                },

                {field:'contractName',title:'合同'},
                {field:'procurementEntName',title:'签约方'},
                {field:'applicationletter',title:'用信情况&nbsp;￥万元'},
                {field:'amount',title:'发票'},
                {field:'freightName',title:'货运及单号',
                    formatter:function(value,row,index){
                    console.log(row)
                        var str='';
                        str+='<p>'+row.freightName+'</p><p>'+row.freightUnit+'</p>'
                        return str
                    }
                },
                {
                    title:'操作',
                    field:'action',
                    formatter:function(value , row){
                        var str = '';
                        if(row.orderStatus ==0){//待确认
                            str += '<button  class="btn  btn-primary bg_btn qran" data-toggle="modal" data-target=".bs-example-modal-sm" href="#" value="待确认" onclick="showUserAttach(\''+row.orderId+'\',1)">领取订单</button>';
                            str += '<button  class="btn btn-warning bg_btn" data-toggle="modal" data-target=".bs-example-modal-sm_bh" href="#" value="待确认" onclick="showUserAttache(\''+row.orderId+'\',2)">驳回</button>';
                        } else if(row.orderStatus ==1){//待付款
                            str+='--';
                        } else if(row.orderStatus ==2){//待发货
                            str +='<button  id="pz" class="btn-danger btn-sm" data-toggle="modal" data-target=".bs-example-modal-pzfh" href="#" value="待发货" onclick="showUserAttachs(\''+row.orderId+'\',4)">配置发货</button>';
                        } else if(row.orderStatus ==3){//待收货
                            str+='--';
                        } else if(row.orderStatus ==4){//已完成
                            str+='--';
                        } else if (row.orderStatus ==5){//已取消
                            str+='--';
                        } else  if(row.orderStatus ==6){//已驳回
                            str+='--';
                        }
                        return str;
                    }
                }
            ],
            url:'<%=request.getContextPath()%>/tradeOrder/orderSelect.action',
            method:'post',
            queryParamsType:'',
            queryParams: queryParamss,//传递参数（*）
//            queryParams: function queryParams(params) {
//                var param = {
//                    pageNumber: params.pageNumber,
//                    pageSize: params.pageSize
//                };
//                return param;
//            },
            //【其它设置】
            locale:'zh-CN',//中文支持
            pagination: true,//是否开启分页（*）
            pageNumber:1,//初始化加载第一页，默认第一页
            pageSize: 3,//每页的记录行数（*）
//            pageList: [2,3,4],//可供选择的每页的行数（*）
            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
            //发送到服务器的数据编码类型  {order: "asc", offset: 0, limit: 5}
            contentType:'application/x-www-form-urlencoded;charset=UTF-8'   //数据编码纯文本  offset=0&limit=5
        });
    });
    //得到查询的参数
    function queryParamss (params) {
        var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageNumber: params.pageNumber,
            pageSize: params.pageSize,
            orderStatus:$("#orderStatus").val(),
            orderCreatTime:$("#creatTime").val(),
            orderConfirmationTime:$("#endTime").val(),
            procurementEntName:$("#procurementEntName").val(),
            contractName:$("#contractName").val(),
            custom:$("#custom").val()
        };
        return temp;
    }
    //搜索
    function search() {
        $("#tb_departments").bootstrapTable('refresh');
    }
    <%--<%=request.getContextPath()%>/tradeMain/ddck.action--%>
    //重置查询
    function reset(){
        $("#orderform").form('reset');
        search();
    }
    function operateFormatter(value,index,row) {
        var le=''
        le='<a id="butt">'+value+'</a>'
        return le
    }

    window.operateEvents1={
        'click #butt':function (e,value,index,row) {
            $('#load').load('<%=request.getContextPath()%>/tradeMain/ddck.action?value='+value)
            //console.log('<%=request.getContextPath()%>/tradeMain/ddck.action?value='+value)
        }
    }


    //驳回按钮
    function showUserAttache(w,e){
        $("#ddbh").click(function () {
            $.ajax({
                url:'<%=request.getContextPath()%>/tradeOrder/bohui.action?id='+w+'&&flag='+e,
                type:'post',
                dataType:"json",
                 data:$("#bohuireason").serialize(),
                success:function (data) {
                    setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/ddgl.action')",500);
                }
            })

        })
    }

   //领取订单按钮
    function showUserAttach(w,e){
        $("#lqdd").click(function () {

            $.ajax({
                url:'<%=request.getContextPath()%>/tradeOrder/lqdd.action?id='+w+'&&flag='+e,
                type:'post',
                dataType:"json",
                data:$("#bohuireason").serialize(),
                success:function (data) {
                    setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/ddgl.action')",500);
                }
            })

        })
    }


    var abc=''
    //配置发货数据回显
    function showUserAttachs(w,e){
            $.ajax({
            url:"<%=request.getContextPath()%>/tradeOrder/orderSelect.action",
            data:{ pageNumber:1, pageSize: 10},
            type:"POST",
            dataType:"json",
            success: function(data){
                for(var i=0;i<data.rows.length;i++){
                    $('#wyb').empty()
                    if(data.rows[i].orderId==w){
                        var data_con = '<tr><td class="col-xs-4">订单编号：</td> <td class="col-xs-4">'+data.rows[i].orderNumber+'</td></tr>';
                        data_con += '<tr><td class="col-xs-4">订单金额：</td> <td class="col-xs-4">'+data.rows[i].orderAmount+'</td></tr>';
                    }
                }
                $('#wyb').append(data_con);
                $.ajax({
                    url:'<%=request.getContextPath()%>/freight/freightSelect.action',
                    type:'POST',
                    dataType:'json',
                    success:function (data) {
                        value=data;
                        //console.log(data);
                        if(data==''){
                         $('#pzfh_select').hide()
                         }else if(data!=''){
                            var option='';
                            for(var i=0;i<data.length;i++){
                                option +='<option  value='+data[i].freightDefaultAddress+' id='+data[i].freightId+'>'+data[i].freightName+'</option>';
                                //console.log(option)
                            }
                         }
                        $('#pzfh_select').append(option);
                        var aaa= $('#pzfh_select')[0];
                         for(var i=0;i<aaa.children.length;i++){
                            if(aaa.children[i].value==1){
                              aaa.children[i].selected='selected'
                            }
                         }
                        $('#pzfh_select').change(function () {
                            abc=$(this).children('option:selected').attr("id")
                        })
                    }
                })

            }
        });
        /**
         * 配置发货表单提交
         */


        $("#pzfh").click(function () {
            $.ajax({
                url: '<%=request.getContextPath()%>/tradeOrder/pzfh.action?id=' + w + '&&flag=' + e+'&&val=' + abc,
                type: 'post',
                dataType: 'json',
                data: $('#formId').serialize(),
                success: function (data) {
                    setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/ddgl.action')", 500);
                }
            })
        })
    }

// 定义时间格式
    function ConvertToDate(datestr) {
        var date=new Date(datestr);
        var year=date.getFullYear();
        var month=date.getMonth()+1;
        if(month < 10){
            month = "0"+month
        }else{
            month = ''+month
        }
        var day=date.getDate();
        if(day < 10){
            day = "0"+day
        }else{
            day = ''+day
        }
        var hours = date.getHours()
        if(hours < 10){
            hours = "0"+hours
        }else{
            hours = ''+hours
        }
        var minutes = date.getMinutes(); //获取当前分钟数(0-59)
        if(minutes < 10){
            minutes = "0"+minutes
        }else{
            minutes = ''+minutes
        }
        var seconds = date.getSeconds();
        if(seconds < 10){
            seconds = "0"+seconds
        }else{
            seconds = ''+seconds
        }
        return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
    }

</script>
</html>