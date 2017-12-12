<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<%-- <% request.setAttribute("webPath", request.getContextPath());%> --%>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .select{
            width: 160px !important;
            height:30px;
            font-size:12px;
        }
        .htbg tbody tr td{
            vertical-align: middle;
        }
        .pzfh tbody tr td{
            border:none;
        }
        .fpgl{
            margin-right:0;
        }
     
    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--财物管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a href="#">发票管理</a>
        </div>
        <!--财物管理 头部 end-->
        <div class="col-xs-12">
            <!--合同签约 状态-->
            <div class="khh" style="margin-top: 10px;">
                <form id="invoiceForm" class="form-inline khh_form khh_form1">
                    <div class="form-group">
                        <label>发票编号</label>
                        <input type="text" class="form-control" id="invoiceNumber">
                    </div>
                    <div class="form-group">
                        <label>开票人</label>
                        <input type="text" class="form-control" id="drawer">
                    </div>
                    
                    <button type="button" class="btn btn-danger btn-default" onclick="search()">查询</button>
                    <button type="button" class="btn btn-danger btn-default" onclick="reset()">重置</button>
                </form>
            </div>
            <!--合同签约 状态-->
            <!--合同分页 start-->
           
            <!--合同分页 eng-->
            <!--合同表格 开始-->
            <table id="tb_invoice" class="cj_table"></table>
            <!--合同表格 结束-->
            <!--合同分页 start-->
            
            <!--合同分页 eng-->
        </div>
    </div>
</div>
</body>
<!-- <button id="edit" class="btn btn-danger bg_btn" href="#" value="3" >编辑</button> -->

<script>
    
    $(function(){
    	
    	$("#tb_invoice").bootstrapTable({
            columns:[
            	
                {field:'invoiceNumber',title:'发票编号',width:100},
                {field:'invoiceNo',title:'发票号',width:100},
                {field:'drawer',title:'开票人',width:100},
                {field:'checkTaker',title:'收票人',width:100},
                {field:'orderNumber',title:'所属订单',width:100} ,
                {field:'createTime',title:'创建时间',width:100,
                	formatter: function (value, row, index) {
                        return changeDateFormat(value)
                    }
                	
                },
                {field:'attachmentUrl',title:'操作',width:100,
                	formatter:function(value,row){
                    var str = '';
                        str += '<img src=\"'+value+'\" style="height:50px;width:100px;">';
                     //   str += '<button id="editBtn" class="btn btn-danger bg_btn" href="#" value="编辑" onclick="edit(\''+row.id+'\')" >编辑</button>';
                        <%--  onclick="'$("#load").load("<%=request.getContextPath()%>/proInvoice/edit.action)'" --%>
                        //<img src=\"'+value+'\">
                        //onclick='window.location.href=\"crm/clue/edit.do?id="+obj.id+"\";'
                 //alert($("#edit").val());
                    return str;
                }
                	
                },
            ],
            url:'<%=request.getContextPath()%>/proInvoice/invoiceList.action',
    							method : 'post',
    							queryParamsType : '',
    							queryParams : queryParams,//传递参数（*）
    							//【其它设置】
    							locale : 'zh-CN',//中文支持
    							pagination : true,//是否开启分页（*）
    							pageNumber : 1,//初始化加载第一页，默认第一页
    							pageSize : 3,//每页的记录行数（*）
    							sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
    							//发送到服务器的数据编码类型  {order: "asc", offset: 0, limit: 5}
    							contentType : 'application/x-www-form-urlencoded;charset=UTF-8' //数据编码纯文本  offset=0&limit=5
    						});
        
        
    	});
    	function changeDateFormat(cellval) {
            var dateVal = cellval + "";
            if (cellval != null) {
                var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
                var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
                var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
                
                var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
                var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
                var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
                
                return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
            }
        }
    
    	//得到查询的参数
    	function queryParams(params) {
    		
    		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
    			pageNumber : params.pageNumber,
    			pageSize : params.pageSize,
    			//userId : userId,
    			invoiceNumber : $("#invoiceNumber").val(),
    			drawer : $("#drawer").val()
    		}
    		return temp;
    	};
    	//授信搜索
    	function search() {
    		$("#tb_invoice").bootstrapTable('refresh');
    	}
    	//授信重置查询
    	function reset() {
    		$("#invoiceForm").form('reset');
    		search();
    	}
    	function edit(id) {
    		<%-- var a = ("<%=request.getContextPath()%>"); --%>
    		//alert(a);
    		//toAction('${webPath}/advert/toUpdate?id=${wz.id}');
    		//toAction("${webPath}/proInvoice/edit?id=" + id);
    		//toAction("${webPath}/proInvoice/edit.action");
    		$('#load').load('${webPath}/proInvoice/edit.action?id='+id);
    	}
    	<%--  $('#editBtn').click(function(){
    		//var id = $("#edit").val();
    		alert(123);
    		$('#load').load('<%=request.getContextPath()%>/proInvoice/edit.action?id=id')
    	})  --%>
    	 
    
</script>
<!--  <div class="table-responsive text-center">
                <table id="tb_invoice" class="table table-bordered text-center htbg fpgl">
                    
                </table>
</div> -->
</html>