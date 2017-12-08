<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--财务管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
            <span>></span>
            <a href="#">财务管理</a>
        </div>
        <!--财物管理 头部 end-->
        <div class="col-xs-12">
            <!--合同签约 状态-->
            <div class="khh">
                <form class="form-inline khh_form khh_form1 cwgl_input">
                    <div class="form-group">
                        <label>财务类型</label>
                        <select class="form-control select" id="financialType">
                            <option value="">请选择</option>
                            <option value="0">转入</option>
                            <option value="1">转出</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>发生时间</label>
                        <input type="text" readonly="readonly"  name="birthday" id="billTime" class="form-control"  />--
                        <input type="text" readonly="readonly"  name="birthday" id="billTime" class="form-control"  />
                    </div>
                    <div class="form-group">
                        <label>发生方</label>
                        <input type="text" class="form-control" id="payer">
                    </div>
                    <div class="form-group">
                        <label>银行账户</label>
                        <input type="text" id="bankcardaccount" class="form-control">
                    </div>
                    <button type="button" class="btn btn-danger btn-default" onclick="search()">查询</button>
                    <button type="button" class="btn btn-danger btn-default" onclick="reset()">重置</button>
                </form>
            </div>
            <div class="panel-body" style="padding-bottom:0px;">
            <table id="tb_departments" class="cj_table"></table>
            </div>
            <!--合同分页 start-->
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
    $(function(){
        $("#tb_departments").bootstrapTable({
            columns:[
                {field:'financialNumbers',title:'财务编号',width:100},
                {field:'amount',title:'金额(￥万元)',width:100},
                {field:'billTime',title:'发生时间',width:100,
                	formatter:function(value,row,index){
                        return ConvertToDate(value)
                    }	
                },
                {field:'financialType',title:'财务类型',width:100,
                	formatter: function(value,row,index){
                        if(value == '0') {
                            return "转入";
                        } else if(value == '1') {
                            return "转出";
                        }
                    }
                },
                {field:'belongOrder',title:'所属订单',width:100},
                {field:'payer',title:'发生方',width:100},
                {field:'bankcardaccounttype',title:'发生银行账户类型',width:100,
                	formatter: function(value,row,index){
                        if(value == '0') {
                            return "三方账户";
                        } 
                    }	
                },
                {field:'bankcardaccount',title:'发生银行账户',width:100},
            ],
            url:'<%=request.getContextPath()%>/tradefinance/pmtradefinance.action',
            method:'post',
            queryParamsType:'',
            queryParams: queryParams,//传递参数（*）
            //【其它设置】
            locale:'zh-CN',//中文支持
            pagination: true,//是否开启分页（*）
            pageNumber:1,//初始化加载第一页，默认第一页
            pageSize: 3,//每页的记录行数（*）
            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
            //发送到服务器的数据编码类型  {order: "asc", offset: 0, limit: 5}
            contentType:'application/x-www-form-urlencoded;charset=UTF-8'   //数据编码纯文本  offset=0&limit=5
        });
    });
    //得到查询的参数
    function queryParams (params) {
        var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageNumber: params.pageNumber,
            pageSize: params.pageSize,
            financialType:$("#financialType").val(),
            billTime:$("#billTime").val(),
            payer:$("#payer").val(),
            bankcardaccount:$("#bankcardaccount").val(),
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