<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>财务管理</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--财务管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/captialMain/captialMain.action">系统首页</a>
            <span>></span>
            <a href="#">财务管理</a>
        </div>
        <!--财物管理 头部 end-->
        <div class="col-xs-12">
            <!--合同签约 状态-->
            <div class="khh">
                <form class="form-inline khh_form khh_form1 cwgl_input" id="financingForm">
                    <div class="form-group">
                        <label>财物类型</label>
                        <select class="form-control select">
                            <option>全部</option>
                            <option>全部1</option>
                            <option>全部2</option>
                            <option>全部3</option>
                            <option>全部4</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>发生时间</label>
                        <input type="text" readonly="readonly"  name="birthday" id="birthday1" class="form-control" value="03/18/2013" />--
                        <input type="text" readonly="readonly"  name="birthday" id="birthday" class="form-control" value="03/18/2013" />
                    </div>
                    <div class="form-group">
                        <label>签约方</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>银行账户</label>
                        <select class="form-control">
                            <option>全部</option>
                            <option>全部1</option>
                            <option>全部2</option>
                            <option>全部3</option>
                            <option>全部4</option>
                        </select>
                    </div>
                    <button type="button" class="btn btn-danger btn-default">查询</button>
                    <button type="button" class="btn btn-danger btn-default">重置</button>
                </form>
            </div>
            <!--合同签约 状态-->
            <!--合同分页 start-->
            <div class="panel-body" style="padding-bottom:0px;">
                <table id="financingTable" class="cj_table"></table>
            </div>
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

    //授信分页查询
    $(function(){
        $("#financingTable").bootstrapTable({
            columns:[
                { //field: 'Number',//可不加
                    title: '序号',//标题  可不加
                    width:100,
                    formatter: function (value, row, index) {
                        return index+1;
                    }
                },
                {field:'tripartiteDepositBank',title:'开户行',width:100},
                {field:'tripartiteCreditHolderPurchaser',title:'户主（采购方）',width:100},
                {field:'tripartiteAccountNumber',title:'账号',width:100},
                {field:'tripartiteBalance',title:'余额（元）',width:100},
                {field:'tripartiteAvailableBalance',title:'可用余额（元）',width:100},
                {field:'tripartiteAccountOpentime',title:'账号开通时间',width:100},
                {field:'tripartiteAccountOpenpeople',title:'账号开通人',width:100},
                {field:'tripartiteAmountCreateTime',title:'创建时间',width:100},
                {field:'tripartiteAmountCreatePeople',title:'创建人',width:100}
            ],
            url:'<%=request.getContextPath()%>/captialTripartite/tripartiteSelect.action',
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
            tripartiteDepositBank:$("#tripartiteDepositBank").val(),
            tripartiteCreditHolderPurchaser:$("#tripartiteCreditHolderPurchaser").val()
        };
        return temp;
    }
    //搜索
    function search(){
        $("#financingTable").bootstrapTable('refresh');
    }
    //重置查询
    function reset(){
        $("#financingForm").form('reset');
        crownSearch();
    }

</script>
</html>