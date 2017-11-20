<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2017/10/30
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/include.jsp"%>
<html>
<head>
    <title>资方</title>
</head>
<body>
    <form class="form-inline" id="f">
        <div class="form-group">
            <label for="contractStatus">合同状态：</label>
            <select class="form-control" id="contractStatus" style="width: 93.5px;" >
                <option value="">请选择</option>
                <option value="0">待确认</option>
                <option value="1">执行期</option>
                <option value="2">已终止</option>
                <option value="3">历史</option>
            </select>&nbsp;&nbsp;
        </div>
        <div class="form-group">
            <label for="creatTime">合同时间：</label>
            <input class="form-control " id="creatTime" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})" placeholder="开始日期"/>至
            <input  class="form-control " id="endTime" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'creatTime\')}'})" placeholder="结束日期"/><br/>
            &nbsp;&nbsp;
        </div>
        <div class="form-group">
            <label for="deptName">签约方：</label>
            <input type="text" name="deptName" id="deptName" class="form-control" placeholder="签约方"/>
            &nbsp;&nbsp;
        </div>
        <%--<button type="button" class="btn btn-success" onclick="searchs()">搜索</button>--%>
        <%--<button type="button" class="btn btn-success" onclick="reset()">重置</button>--%>
        <%--<a href="javascript:search()"  >查询</a>&nbsp;--%>
        <input type="button" class="btn btn-primary btn_search" value="搜索" onclick="serach()"/>
    </form>


<table id="listSelect"></table>

<script>
    //分页查询
    $(function(){
        $("#listSelect").bootstrapTable({
            //隔行变色
            striped:true,
            columns:[
                {field:'contractId',title:'序号',width:50},
                /* {//将id和复选框关联起来方便进行批量删除时使用
                 field:'id',
                 checkbox:true   }, */
                {field:'contractNumber',title:'合同编号',width:100},
                {field:'contractStatus',title:'合同状态',width:100,
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
                    }
                },
                {field:'buyerSignatory',title:'采购商',width:100},
                {field:'serviceContent',title:'资方',width:100},
                {field:'serviceLevel',title:'合同执行期',width:100},
                {field:'soCreatetime',title:'合同扫描件页数',width:100},
                {
                    title:'操作',
                    field:'action',
                    width:25,
                    formatter:function(value , row){
                        var str = '';
                        str += '<input class="easyui-button" type="button" href="#" value="查看" onclick="showUserAttach(\''+row.serviceId+'\')"/>';
                        return str;
                    }
                }
            ],
            url:'<%=request.getContextPath()%>/signing/signingSelect.action',
            method:'post',
            queryParamsType:'',
            queryParams: queryParams,//传递参数（*）
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
            pageList: [2,3,4],//可供选择的每页的行数（*）
            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
            //发送到服务器的数据编码类型  {order: "asc", offset: 0, limit: 5}
            contentType:'application/x-www-form-urlencoded;charset=UTF-8'   //数据编码纯文本  offset=0&limit=5
        });
    });
//    function search(){
//        $("#listSelect").bootstrapTable('load',{
//            contractStatus:$("#contractStatus").val(),
//            "whereMap['creatTime']":$("#creatTime").val(),
//            "whereMap['endTime']":$("#endTime").val()
//        })
//    }
    //得到查询的参数
    function queryParams (params) {
        var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageNumber: params.pageNumber,
            pageSize: params.pageSize,
            contractStatus:$("#contractStatus").val()
        };
        return temp;
    }
    //搜索
    function serach() {
        $("#listSelect").bootstrapTable('refresh');
    }
    //重置查询
    function reset(){
        $("#f").form('reset');
        search();
    }
</script>

</body>
</html>
