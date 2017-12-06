<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>贷款管理</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--财务管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/captialMain/captialMain.action">系统首页</a>
            <span>></span>
            <a href="#">贷款管理</a>
        </div>
        <!--财物管理 头部 end-->
        <div class="col-xs-12">
            <div class="tab-pane active" id="creditExtension">
                <!--授信编号 开始-->
                <div class="khh">
                    <form class="form-inline khh_form khh_form1" id="loansForm">
                        <div class="form-group form-group1">
                            <label for="lender">贷款方</label>
                            <input type="text" class="form-control" id="lender" name="lender">
                        </div>
                        <div class="form-group form-group1">
                            <label for="loanAmount">贷款金额</label>
                            <input type="email" class="form-control" id="loanAmount" name="loanAmount">
                        </div>
                        <div class="form-group form-group1">
                            <label for="occurrenceTime">到期时间</label>
                            <input class="form-control"  readonly="readonly"  id="occurrenceTime" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'expirationTime\')}'})" placeholder="开始日期"/>至
                            <input  class="form-control"  readonly="readonly"  id="expirationTime" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'occurrenceTime\')}'})" placeholder="结束日期"/>
                        </div>
                        <div class="form-group form-group1">
                            <label for="loanStatus">贷款状态</label>
                            <select class="form-control select" id="loanStatus">
                                <option value="">全部</option>
                                <option value="0">使用中</option>
                            </select>
                        </div>
                        <button type="button" class="btn btn-danger btn-default" onclick="search()">查询</button>
                        <button type="button" class="btn btn-danger btn-default" onclick="reset()">重置</button>
                    </form>
                </div>
                <!--测试 开始-->
                <div class="panel-body" style="padding-bottom:0px;">
                    <table id="loansTable" class="cj_table"></table>
                </div>
                <!--测试 结束-->
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

    //授信分页查询
    $(function(){
        $("#loansTable").bootstrapTable({
            columns:[
                { //field: 'Number',//可不加
                    title: '序号',//标题  可不加
                    width:100,
                    formatter: function (value, row, index) {
                        return index+1;
                    }
                },
                {field:'loanNumber',title:'贷款编号',width:100},
                {field:'lender',title:'贷款方',width:100},
                {field:'creditMasterContractNum',title:'授信合同',width:100},
                {field:'letterOrderNum',title:'用信订单',width:100},
                {field:'loanAmount',title:'授信/用信 ￥万元',width:100},
                {field:'expirationTime',title:'到期时间',width:100,
                    formatter:function(value,row,index){
                        return ConvertToDate(value)
                    }
                },
                {field:'accountType',title:'贷款状态',width:100,
                    formatter: function(value,row,index){
                        if(value == '0') {
                            return "全部还款";
                        }else if(value == '1'){
                            return "部分还款";
                        }
                    }},
                {field:'account',title:'发生账户',width:100}
            ],
            url:'<%=request.getContextPath()%>/captialLoan/loansSelect.action',
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
            lender:$("#lender").val(),
            loanAmount:$("#loanAmount").val(),
            occurrenceTime:$("#occurrenceTime").val(),
            expirationTime:$("#expirationTime").val(),
            loanStatus:$("#loanStatus").val()
        };
        return temp;
    }
    //搜索
    function search(){
        $("#loansTable").bootstrapTable('refresh');
    }
    //重置查询
    function reset(){
        $("#loansForm").form('reset');
        crownSearch();
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
        return year+"-"+month+"-"+day+"-"+hours+":"+minutes+":"+seconds;
    }

</script>
</html>