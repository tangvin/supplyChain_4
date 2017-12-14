<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String w=request.getParameter("w");
	String e=request.getParameter("e");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <style>
       .xzdd{
          /*margin-right:40px;*/
           margin-right:-15px;
       }
        #butt{
            cursor: pointer;
        }
    </style>

</head>
<body>
<div class='col-xs-12'>
<div class="row">
<!--订单管理 头部-->
	<div class="col-xs-12 zlxx_top">
		<a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
		<span>></span>
		<a id="ddglyy">订单管理</a>
	</div>
<!--订单管理 头部 end-->
<div class="col-xs-12">
		   <div class="khh">
			   <form class="form-inline khh_form khh_form1" id="ordersform">
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
			          <div class="form-group">
			               <label>订单时间：</label>
			               <select class="form-control select" id="aa">
			                   <option value="">自定义时间</option>
			                   <option value="0">一月内</option>
			                   <option value="1">三月内</option>
			                   <option value="2">六月内</option>
			                   <option value="3">一年内</option>
			               </select>
			               <input class="form-control"  readonly="readonly"  id="creatTime" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})" placeholder="开始日期"/>至
		                   <input  class="form-control"  readonly="readonly"  id="endTime" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'creatTime\')}'})" placeholder="结束日期"/>
		               </div>

			           <div class="form-group">
			               <label>订单签约方：</label>
			               <input type="text" class="form-control" id="entname">
			           </div>

			           <button type="button" class="btn btn-danger btn-default" onclick="search()">查询</button>
			           <button type="button" class="btn btn-danger btn-default" onclick="reset()">重置</button>
			       </form>
         </div>
</div>
<!-- 订单开户行 开始 -->

<div class="col-xs-12 text-right">
    <button style="margin-right:-15px" class="btn btn-primary" id="insertOrder">新增订单</button>
</div>
<!-- 订单开户行 结束 -->
<!-- 订单表格 开始    -->
<div class="col-xs-12">
	<table id="tb_departments" class="cj_table">

	</table>
</div>
<!-- 订单表格 结束    -->

<!--领取订单 模态框-->
    <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
		  <div class="modal-dialog modal-sm" role="document">
		       <div class="modal-content">
		            <div class="panel-body text-center">
		                                                     确定执行此操作吗？
		            </div>
		            <div class="modal-footer">
		                  <button id="lqdd" type="button" class="btn btn-default" data-dismiss="modal">确定</button>
		                  <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
		             </div>
		         </div>
		    </div>
     </div>
<!--领取订单 模态框 结束-->
<div class="modal fade bs-example-modal-sm_sq" id="myModalLetter" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabelLetter">申请用信</h4>
                            </div>
                            <div class="modal-body">
                                <div class="table-responsive text-center">
                                	<form class="form-inline khh_form" id="orderForm">
	                                    <table class="table table-bordered bj_table" >
	                                        <tbody id="wybLetter">
	
	                                        </tbody>
	                                    </table>
                                    </form>
                                </div>
                            </div>
                          
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal" id="orderClike">确认</button>
                            </div>
                        </div>
                    </div>
<!--申请融信 模态框-->

</div>
</div>
</body>
<script>
    
    $('#insertOrder').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/insertOrder.action')
    })
     $('#ddbj_aa').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/ddbjaa.action')
    })
     $('#ddglyy').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/ddbjaa.action')
    })
    /* 订单展示 */
   $(function(){
        $("#tb_departments").bootstrapTable({
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
                		 str +='<p>'+row.username+'</p>'+ConvertToDate(value)+'<p></p>';
                        return str;
                   }
                },
                
                {field:'cName',title:'合同'},
                {field:'entname',title:'合同签约方'},
                {field:'applicationletter',title:'用信情况&nbsp;￥万元'},
                {field:'amount',title:'发票'},
                {field:'freightNumber',title:'货运及单号',
                	formatter:function(value,row,index){
                  	  var str='';
                  		 str +='<p>'+row.fName+'</p>'+row.invoiceNo+'<p></p>';
                          return str;
                     }
                },

                {
                    title:'操作',
                    field:'action',
                    formatter:function(value , row){
                        var str = '';
                        if(row.orderStatus == 0){//待确认
   	                        str += '<button class="btn btn-default bg_btn" data-toggle="modal" data-target=".bs-example-modal-sm"  href="#" value="取消" onclick="showUserAttach(\''+row.orderId+'\',1)">取消</button>';
                            str += '<button class="btn btn-default bg_btn" href="#" value="编辑" onclick="updorder(\''+row.orderId+'\',2)">编 辑</button>';
                        }  else if(row.orderStatus == 1){//待付款
                            str +='<button class="btn btn-warning bg_btn" data-toggle="modal"  data-target=".bs-example-modal-sm" href="#" value="取消" onclick="showUserAttach(\''+row.orderId+'\',3)">取消</button>';
                            str +='<button class="btn btn-warning bg_btn"  href="#" value="编辑" onclick="updorder(\''+row.orderId+'\',4)">编辑</button>';
                           // str +='<button class="btn btn-warning bg_btn"  href="#" value="编辑" onclick="updorder(\''+row.orderId+'\',4)">编辑</button>';
                           if(row.letterStatus == null){
                               str +='<button class="btn btn-warning bg_btn" data-toggle="modal" data-target=".bs-example-modal-sm_sq"   value="申请用信" onclick="sqyx(\''+row.orderId+'\',5)">申请用信</button>';
                           }else if(row.letterStatus == 0){
                               str +='';
                           }
                        } else if(row.orderStatus == 2){//待发货
                            str +='<button class="btn btn-info bg_btn" data-toggle="modal"  data-target=".bs-example-modal-sm" href="#" value="提醒发货" onclick="showUserAttach(\''+row.orderId+'\',6)">提醒发货</button>';
                        } else if(row.orderStatus == 3){//待收货
                            str +='<button class="btn btn-success bg_btn" data-toggle="modal"  data-target=".bs-example-modal-sm" href="#" value="确认收货" onclick="showUserAttach(\''+row.orderId+'\',7)">确认收货</button>';
                        } else if(row.orderStatus == 4){//已完成
                        	str+='--';
                        } else if (row.orderStatus == 5){//已关闭
                             str+='--';
                        } else if (row.orderStatus == 6){//已驳回
                       	 str +='<button class="btn btn-primary bg_btn" data-toggle="modal"  data-target=".bs-example-modal-sm" href="#" value="取消" onclick="showUserAttach(\''+row.orderId+'\',10)">取消</button>';
                    	 str +='<button class="btn btn-primary bg_btn" href="#" value="编辑" onclick="updorder(\''+row.orderId+'\',11)" id="ddbj_aa">编辑</button>';
                    	} else if (row.orderStatus == 7){//历史
                    		str+='--';
                    }
                        return str;
                    }
                }
            ],
            url:'<%=request.getContextPath()%>/pmorder/pmgetorder.action',
            method:'post',
            queryParamsType:'',
            queryParams: queryParamss,//传递参数（*）
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
    function queryParamss (params) {
        var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageNumber: params.pageNumber,
            pageSize: params.pageSize,
            orderStatus:$("#orderStatus").val(),
            orderCreator:$("#orderCreator").val(), 
            entname:$("#entname").val(),
            orderCreatTime:$("#creatTime").val(),
            orderConfirmationTime:$("#endTime").val(),
            aa:$("#aa").val(),

        };
        return temp;
    }
    //搜索
    function search() {
        $("#tb_departments").bootstrapTable('refresh');
    }
    //重置查询
    function reset(){
        $("#ordersform").from('reset');
        search();
    }

    function operateFormatter(value,index,row) {
        var le=''
        le='<a id="butt">'+value+'</a>'
        return le
    }

    window.operateEvents1={
        'click #butt':function (e,value,index,row) {
        	$('#load').load('<%=request.getContextPath()%>/procurementMain/ddck.action?value='+value)
        }
    }

    //待确认状态下按钮触发事件
    function showUserAttach(w,e){
    $("#lqdd").click(function () {
        $.ajax({
            url:'<%=request.getContextPath()%>/pmorder/cancelOrderStatus.action?id='+w+'&&flag='+e,
            type:'post',
            dataType:"json",
            success:function (data) {
            	if(data==1){
                    alert("确认成功");
                    setTimeout("$('#load').load('<%=request.getContextPath()%>/procurementMain/ddgl.action')",500);
            	}
            }
        })
    })
    }
    /* 订单编辑 */
     function updorder(id,flag){
    	$('#load').load('<%=request.getContextPath()%>/pmorder/ddbj.action?orderId='+id);
    }
    
    function sqyx(id,flag){
    	 /* 提交申请用信 */
    	  $("#orderClike").click(function(){
    		  $.ajax({
    			  url: '<%=request.getContextPath()%>/pmorder/commitSqyx.action?id='+id+'&&flag='+flag,
    	          data:$("#orderForm").serialize(),
    	          type:"POST",
    	          dataType:"json",
    	          success: function(data){
    	        	  alert("已申请用信,请等待审核。");
                      setTimeout("$('#load').load('<%=request.getContextPath()%>/procurementMain/ddgl.action')",500);
    	          }
    		  });
    	  });
        $.ajax({
            url:"<%=request.getContextPath()%>/pmorder/pmgetorder.action",
            data:{ pageNumber:1, pageSize: 10},
            type:"POST",
            dataType:"json",
            success: function(data){
                for(var i=0;i<data.rows.length;i++){
                    $('#wybLetter').empty()
                    if(data.rows[i].orderId==id){
                        var data_con = '<tr><td class="col-xs-4">id：</td> <td class="col-xs-4">'+data.rows[i].orderId+'</td></tr>';
                        data_con += '<tr><td class="col-xs-4">用信编号：</td> <td class="col-xs-4">'+data.rows[i].orderNumber+'</td></tr>';
                        data_con += '<tr><td class="col-xs-4">申请用信：</td> <td class="col-xs-4"><input type="text" id="lcj" value="'+data.rows[i].applicationletter+'" name="applicationletter"></td></tr>';
                    }
                    $('#wybLetter').append(data_con);
                }
            }
        });

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