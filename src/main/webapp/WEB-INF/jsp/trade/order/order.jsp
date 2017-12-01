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
                        <label>状态</label>
                        <select class="form-control select" id="orderStatus">
                            <option value="">全部</option>
                            <option value="0">待确认</option>
                            <option value="1">待付款</option>
                            <option value="2">待发货</option>
                            <option value="3">待收货</option>
                            <option value="4">已完成</option>
                            <option value="5">已关闭</option>
                            <option value="6">已关闭</option>
                            <option value="6">历史</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>开户行</label>
                        <input type="text" class="form-control" id="creditGrantor">
                    </div>
                    <div class="form-group form-group1">
                        <label>合同执行期</label>
                        <input type="text" readonly="readonly"  name="birthday" id="birthday1" class="form-control" value="03/18/2013" />--
                        <input type="text" readonly="readonly"  name="birthday" id="birthday" class="form-control" value="03/18/2013" />
                    </div>
                    <div class="form-group">
                        <label>签约方</label>
                        <input type="text" class="form-control" id="orderCreatorTrade">
                    </div>
                    <button type="button" class="btn btn-danger btn-default" onclick="search()">查询</button>
                    <button type="button" class="btn btn-danger btn-default" onclick="reset()">重置</button>
                </form>
            </div>

            <div class="panel-body" style="padding-bottom:0px;">
                <table id="tb_departments" class="cj_table"></table>
            </div>

            <!--领取订单 模态框-->
            <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
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
            <!--配置发货 模态框-->
            <div class="modal fade bs-example-modal-pzfh" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <form   id="hygl"    method="post">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button   type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">配置发货</h4>
                        </div>
                        <div class="modal-body">
                            <div class="table-responsive">
                                <table class="table htbg pzfh">
                                    <tbody>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3">订单编号：</td>
                                            <td class="col-xs-9"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3">订单金额：</td>
                                            <td class="col-xs-9"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3"><span class="xingxing">*</span>货运单位：</td>
                                            <td class="col-xs-8">
                                                <div class="row pzfh_row">
                                                    <div class="col-xs-5 pzfh_row_div">
                                                        <select class="form-control" name="freightUnit">
                                                            <option>123123123</option>
                                                            <option>全部1</option>
                                                            <option>全部2</option>
                                                            <option>全部3</option>
                                                            <option>全部4</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <button type="button" class="btn btn-danger btn-default">管理货运单位</button>
                                                    </div>
                                                </div>
                                            </td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3">订单金额:</td>
                                            <td class="col-xs-8">
                                                <div class="row row_ddje">
                                                    <div class="col-xs-5 row_ddje_div">
                                                        <input type="text" class="form-control">
                                                    </div>
                                                    <div class="col-xs-6 row_ddje_con">
                                                        暂未查询到货运单位，请检查
                                                    </div>
                                                </div>
                                            </td>
                                        </div>
                                    </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button id="pzfh" type="button" class="btn btn-default" data-dismiss="modal">确认</button>
                            <button type="button" class="btn btn-primary">取消</button>
                        </div>
                    </div><!-- /.modal-content -->
                    </form>
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!--配置发货 模态框-->
            <!--合同表格 结束-->
            <!--合同分页 start-->
            <!-- <div class="fy">
                <div class="row fy_row">
                    <div class="col-xs-4">
                        <p class="fy_con">共计3条数据，共1页</p>
                    </div>
                    <div class="col-xs-8">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">首页</span>
                                    </a>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li>
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">末页</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div> -->
            <!--合同分页 eng-->
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

    /* 订单展示 */
    $(function(){
        $("#tb_departments").bootstrapTable({
            //隔行变色
//            striped:true,
            columns:[
                { //field: 'Number',//可不加
                    title: '序号',//标题  可不加
                    width:100,
                    formatter: function (value, row, index) {
                        return index+1;
                    }
                },
                {field:'orderNumber',title:'订单编号',width:100},
                {field:'orderStatus',title:'订单状态',width:100,
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
                {field:'orderAmount',title:'订单金额（￥万元）',width:100},
                {field:'orderConfirmationTime',title:'订单确认时间',width:100},
                {field:'orderCreatTime',title:'订单创建时间',width:100},

                {field:'principalOrder',title:'合同',width:100},
                {field:'creditUse',title:'用信情况&nbsp;￥万元',width:100},
                {field:'invoice',title:'发票',width:100},
                {field:'freightNumber',title:'货运及单号',width:100},
                {
                    title:'操作',
                    field:'action',
                    width:25,
                    formatter:function(value , row){
                        var str = '';
                        if(row.orderStatus ==0){//待确认
                            str += '<button  id="f" class="btn btn-default bg_btn" data-toggle="modal" data-target=".bs-example-modal-sm" id="a" href="#" value="待确认" onclick="showUserAttach(\''+row.orderId+'\',1)">领取订单</button>';
                            str += '<button  class="btn btn-default bg_btn" data-toggle="modal" data-target=".bs-example-modal-sm" href="#" value="待确认" onclick="showUserAttach(\''+row.orderId+'\',2)">驳回</button>';
                        } else if(row.orderStatus ==1){//待付款
                            str+='--';
                        } else if(row.orderStatus ==2){//待发货
                            str +='<button   class="btn-warning btn-sm" data-toggle="modal" data-target=".bs-example-modal-pzfh" href="#" value="待发货" onclick="showUserAttachs(\''+row.orderId+'\',4)">配置发货</button>';
                        } else if(row.orderStatus ==3){//待收货
                            str+='--';
                        } else if(row.orderStatus ==4){//已完成
                            str+='--';
                        } else if (row.orderStatus ==5){//已取消
                            str+='--';
                        } else  if(row.orderStatus ==6){//已驳回
                            str+='--';
                        } else if (row.orderStatus ==7){//历史
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
            orderCreator:$("#orderCreator").val(),
            orderCreatTime:$("#orderCreatTime").val(),
            principalOrder:$("#principalOrder").val(),
        };
        return temp;
    }
    //搜索
    function search() {
        $("#tb_departments").bootstrapTable('refresh');
    }
    //重置查询
    function reset(){
        $("#orderform").form('reset');
        search();
    }


   //待确认状态下按钮触发事件
    function showUserAttach(w,e){
    $("#lqdd").click(function () {
        $.ajax({
            url:'<%=request.getContextPath()%>/tradeOrder/takeOrder.action?id='+w+'&&flag='+e,
            type:'post',
            dataType:"json",
           // data:$("#f").serialize(),
            success:function (data) {
                window.location.reload();
            }
        })

    })
    }

    //待发货状态下按钮
    function showUserAttachs(w,e){
        $("#pzfh").click(function () {
            $.ajax({
                url:'<%=request.getContextPath()%>/tradeOrder/takeOrder.action?id='+w+'&&flag='+e,
                type:'post',
                dataType:"json",
                data:$("#hygl").serialize(),
                success:function (data) {
                    window.location.reload();
                }
            })

        })
    }




</script>
</html>