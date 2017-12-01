<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <style>
       .xzdd{
          margin-right:40px;
       }
    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--订单管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
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
             <div class="xzht xzdd text-right" id="insertOrder">
                 <a href="#"><button class="btn btn-primary btn-sm text-right">新增订单</button></a>
             </div>
            <div class="panel-body" style="padding-bottom:0px;">
               <table id="tb_departments" class="cj_table"></table>
            </div>
           
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
    
    $('#insertOrder').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/insertOrder.action')
    })
    
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
                        if(row.orderStatus == 1){
                            str += '<button class="btn btn-default bg_btn" href="#" value="取消" onclick="showUserAttach(\''+row.id+'\')">取消</button>';
                            str += '<button class="btn btn-default bg_btn" href="#" value="申请用信" onclick="showUserAttach(\''+row.id+'\')">申请用信</button>';
                        } else if(row.orderStatus == 0){
                            str +='<button class="btn btn-warning bg_btn" href="#" value="取消" onclick="showUserAttach(\''+row.id+'\')">取消</button>';
                            str +='<button class="btn btn-warning bg_btn" href="#" value="提醒确认" onclick="showUserAttach(\''+row.id+'\')">提醒确认</button>';
                        } else if(row.orderStatus == 2){
                            str +='<button class="btn btn-info bg_btn" href="#" value="查看" onclick="showUserAttach(\''+row.id+'\')">查看</button>';
                            str +='<button class="btn btn-info bg_btn" href="#" value="提醒发货" onclick="showUserAttach(\''+row.id+'\')">提醒发货</button>';
                        } else if(row.orderStatus == 3){
                            str +='<button class="btn btn-success bg_btn" href="#" value="查看" onclick="showUserAttach(\''+row.id+'\')">查看</button>';
                            str +='<button class="btn btn-success bg_btn" href="#" value="确认收货" onclick="showUserAttach(\''+row.id+'\')">确认收货</button>';
                        } else if(row.orderStatus == 4){
                            str +='<button class="btn btn-primary bg_btn" href="#" value="查看" onclick="showUserAttach(\''+row.id+'\')">查看</button>';
                        } else if (row.orderStatus == 5){
                        	 str +='<button class="btn btn-primary bg_btn" href="#" value="查看" onclick="showUserAttach(\''+row.id+'\')">查看</button>';
                        }
                        return str;
                    }
                }
            ],
            url:'<%=request.getContextPath()%>/pmorder/pmgetorder.action',
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
            orderCreatorTrade:$("#orderCreatorTrade").val(),
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
</script>
</html>