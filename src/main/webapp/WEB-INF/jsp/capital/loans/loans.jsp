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
                            <label for="creditNumber">贷款方</label>
                            <input type="text" class="form-control" id="creditNumber">
                        </div>
                        <div class="form-group form-group1">
                            <label for="creditGrantor">贷款金额</label>
                            <input type="email" class="form-control" id="creditGrantor">
                        </div>
                        <div class="form-group form-group1">
                            <label for="creatTime">申请人</label>
                            <input class="form-control"  readonly="readonly"  id="creatTime" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})" placeholder="开始日期"/>至
                            <input  class="form-control"  readonly="readonly"  id="endTime" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'creatTime\')}'})" placeholder="结束日期"/>
                        </div>
                        <div class="form-group form-group1">
                            <label for="creditStatus">贷款状态</label>
                            <select class="form-control select" id="creditStatus">
                                <option value="">全部</option>
                                <option value="1">全部1</option>
                                <option value="2">全部2</option>
                                <option value="3">全部3</option>
                                <option value="4">全部4</option>
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
                {field:'creditNumber',title:'贷款编号',width:100},
                {field:'creditGrantor',title:'贷款方',width:100},
                {field:'creditTime',title:'授信合同',width:100},
                {field:'creditMasterContract',title:'用信订单',width:100},
                {field:'creditAmount',title:'授信/用信 ￥万元',width:100},
                {field:'applicationTime',title:'到期时间',width:100},
                {field:'approvalTime',title:'贷款状态',width:100,
                    formatter: function(value,row,index){
                        if(value == '0') {
                            return "未生效";
                        } else if(value == '1') {
                            return "正常";
                        } else if(value == '2') {
                            return "已终止";
                        }else if(value == '3') {
                            return "历史";
                        }
                    }},
                {field:'approvalTime',title:'发生账户',width:100}
            ],
            url:'<%=request.getContextPath()%>/loans/loansSelect.action',
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
            creditNumber:$("#creditNumber").val(),
            creditGrantor:$("#creditGrantor").val(),
            creditStatus:$("#creditStatus").val(),
            applicant:$("#creditApplicant").val()
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
</script>
</html>