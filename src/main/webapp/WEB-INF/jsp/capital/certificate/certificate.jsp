<!DOCTYPE html>
<%@page import="cn.com.edzleft.entity.SessionInfo"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--Ukey与证书 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/captialMain/captialMain.action">系统首页</a>
            <span>></span>
            <a href="#">Ukey与证书</a>
        </div>
        <!--财物管理 头部 end-->
        <div class="col-xs-12">
            <!--合同签约 状态-->
            <div class="khh">
                <form class="form-inline khh_form khh_form1" id="ukeyForm">
                    <div class="form-group">
                        <label for="issuedPeoples">颁发人</label>
                        <input type="text" class="form-control" id="issuedPeoples">
                    </div>
                    <div class="form-group">
                        <label for="ukeyStatuss">状态</label>
                        <select class="form-control select" id="ukeyStatuss">
                            <option value="">全部</option>
                            <option value="0">正常</option>
                            <option value="1">失效</option>
                        </select>
                    </div>
                    <button type="button" class="btn btn-danger btn-default" onclick="ukeySearch()">查询</button>
                    <button type="button" class="btn btn-danger btn-default" onclick="reset()">重置</button>
                </form>
            </div>
            <div></div>
            <div class="col-xs-2 text-right sqbf_btn" style="float:right">
        	<button type="button" id="apply" class="btn btn-danger btn-default">申请颁发</button>
       		</div>
            <!--ukey表格 开始-->
            <div class="panel-body" style="padding-bottom:0px;">
            	<table id="tb_ukey" class="cj_table"></table>
            </div>
            <!--ukey表格 结束-->
            <!--分页 start-->
            
            <!--分页 end-->
        </div>
        
        
        
    </div>
</div>
</body>
<script>
$(function(){
	apply();
    $("#tb_ukey").bootstrapTable({
        columns:[
            {field:'ukeyType',title:'类型',width:100},
            {field:'issuedPeople',title:'颁发人',width:100},
            {field:'issuedTime',title:'颁发时间',width:100,
            	formatter: function (value, row, index) {
                    return changeDateFormat(value)
                }
            	
            },
            {field:'ukeyStatus',title:'状态',width:100,
                formatter: function(value,row,index){
                    if(value == '0') {
                        return "正常";
                    } else if(value == '1') {
                        return "失效";
                    }
                } 
            },{field:'attachmentName',title:'文件名',width:100} ,
            {field:'attachmentUrl',title:'操作',width:25,
            	 formatter:function(value){
            		 //alert(value);
                     var str = '';
                         str += '<a href=\"'+value+'\">下载</a>';
//                        'window.location.href=\"crm/activity/detail.do?id="+obj.id+"\";' 
                     return str;
                 }
            }
        ],
        url:'<%=request.getContextPath()%>/certificate/ukeyList.action',
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
		
		<%-- var userId=<%=((cn.com.edzleft.entity.SessionInfo) session.getAttribute("sessionInfo")).getAdmin().getUserId() %> --%>
		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			pageNumber : params.pageNumber,
			pageSize : params.pageSize,
			//userId : userId,
			issuedPeople : $("#issuedPeoples").val(),
			ukeyStatus : $("#ukeyStatuss").val()
		};
		return temp;
	};
	//授信搜索
	function ukeySearch() {
		$("#tb_ukey").bootstrapTable('refresh');
	}
	//授信重置查询
	function reset() {
		$("#ukeyForm").form('reset');
		ukeySearch();
	}
	//申请按钮加载
	function apply() {
		$.ajax({
			url:'<%=request.getContextPath()%>/certificate/getByUserId.action',
			type:'post',
			success:function(data){
				//总条数为0，显示按钮
				 if(data.count==0){
					$("#apply").show();
				}else{
					$("#apply").hide();
				} 
				//证书状态有正常的隐藏按钮
				$.each(data.uList,function(index,obj){
					if(0==obj.ukeyStatus){
						$("#apply").hide();
					}else {
						$("#apply").show();
					}
				});
			}
		})
		
		
		
	}
</script>
</html>