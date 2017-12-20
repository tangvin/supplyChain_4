<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增订单</title>
    <style>
        .xzdd{
            /*margin-top:40px;*/
        }
        .bj_table tbody tr td input{
            width:200px;
            font-size: 12px;
        }
        .xzdd_hx_table tr td input{
            width:300px!important;
        }
        #id{
            width:20px;
        }
        .redio{
            width:20px!important;
        }
        .glshxx{
            margin-left:20px;
            display:block;
            background:#ddd;
            padding: 10px 10px;
            width:100px;
           color:#000000;
           border-radius: 4px;
        }
        .next{
          width: 120px;
          height: 40px;
          font-size: 16px;
            margin-top:20px;
        }
        #glshxx{
            text-decoration: none;
        }

        #span{
            display: block;
            float: right;
            margin-top: 1px;
        }
        .xzdd_hx_table tr td input{
            border: none;
            outline: none;
        }
        #ddd,#eee{
            width:100px;
        }
        #glht,#principalOrderId{
            height:30px;
            font-size: 12px;
        }




        .select-span{
            margin:0;
            padding:0;
            position:relative;
            width:auto;
            height:auto;
            display:block;
        }
        .select-span>input,.select-span>select{
            box-sizing:border-box;
        }
        .select-span>input{
            margin:0;
            padding:0 5px 0 5px;
            width:200px;
            height:34px;
            line-height:34px;
            vertical-align:middle;
            background:#fff;
            border:1px solid #ddd;
            outline:none;
            font-size:12px;
            overflow:hidden;
        }
        .select-span>select{
            position:absolute;
            margin:0;
            padding:0;
            top:35px;
            left:0;
            width:200px;
            min-height:102px;
            height:100%;
            background:#fff;
            border:1px solid #ddd;
            font-size:12px;
            outline:none;
        }
        .select-span>select>option{
            margin:0;
            padding:3px 5px;
            width:200px;
            height:auto;
            background:#fff;
            font-size:12px;
            color:#000;
        }
        .select-span>select>option[for=no-con]{
            color:#f00;
        }
        .select-span>select>option:hover{
            background:#ddd;
            cursor:pointer;
        }
        .select-span>select>option[for=no-con]:hover{
            background:#fff;
            cursor:default;
        }
    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--合同签约 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
            <span>></span>
            <a  id="ddglOrder" href="#">订单管理</a>
            <span>></span>
            <a href="#">新增订单</a>
        </div> 
         <!--合同签约 头部 end-->
        <div class="col-xs-12 xzdd">
             <!--合同编辑表格 start-->
            <div class="table-responsive text-center" style="margin-right:-15px;margin-left:-15px;">
            <form method="post">
                <table class="table table-bordered bj_table">
                    <tbody>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同签约方：</td>
                            <td class="col-xs-9 text-left">
                                    <span class="select-span">
                                        <input type="text" name="orderCreatorTrade" class="form-control" autocomplete="off" id="orderCreatorTrade" placeholder="模糊检索匹配"/>
                                        <select name="input-select"  id="input-select" size="10" style="display:none;"></select>
                                     </span>
                            </td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>关联到合同：</td>
                            <td class="col-xs-9 text-left">
                                <div class="form-inline">
                                    <div class="btn btn-danger" id="glht"  data-toggle="modal" data-target="#myModalGlht">管理合同</div>
                                    <input type="text" class="form-control" readonly="readonly" id="principalOrderId">
                                    <input type="hidden" readonly="readonly" id="readonlyId" name="id">
                                </div>
                            </td>
                        <%--<input type="text" id="principalOrderId" class="form-control" placeholder="模糊检索匹配">--%>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>货物商品：</td>
                            <td class="col-xs-9 text-left"><input type="text" id="goods" class="form-control"></td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>订单金额：</td>
                            <td class="col-xs-8 text-left"><input type="text" id="orderAmount" class="form-control" placeholder="￥万元"></td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>申请用信：</td>
                            <td class="col-xs-9 text-left">
                                <div class="form-inline">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" id="id"> <span id="span">是</span>
                                        </label>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" id="applicationletter" class="form-control" disabled>￥万元
                                    </div>
                                </div>
                            </td>
                    </tr>
                    <tr>
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>收货信息：</td>
                            <td class="col-xs-8 text-left">
	                            <span class="qwer">
                                    <span style="padding-right: 10px">收货地址：</span>
	                                <span id="address"></span>
	                            </span>
                                    <input id="receivingAddressId" type="hidden">
                                    <a class="glshxx" id="glshxx">
                                        <div class="gl">管理收货信息</div>
                                    </a>
                            </td>
                    </tr>
                    <tr class="qwer">
                            <td class="col-xs-3 text-right"></td>
                            <td class="col-xs-9 text-left">
                                <div class="text-left"><span style="padding-right: 25px">收货人：</span><span id="rAddressPerson"></span></div>
                            </td>
                    </tr>
                    <tr class="qwer">
                            <td class="col-xs-3 text-right"></td>
                            <td class="col-xs-9 text-left">
                                <div class="text-left"><span style="padding-right: 25px">手机号：</span><span id="rAddressPhone"></span></div>
                            </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            </div>

            <button id="bbb" type="button" class="btn btn-danger btn-lg col-xs-offset-3 next" data-toggle="modal" data-target="#myModal">下一步</button>
            </form>
             <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <form method="post" id="order"> 
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-body">
                            <div class="table-responsive text-center">
                            
                                <table class="table table-bordered bj_table xzdd_hx_table">
                                    <tbody>
                                    <tr>
                                            <td class="col-xs-3 text-right">合同签约方：</td>
                                            <td class="col-xs-9 text-left"><input  readonly="readonly" style="border: none;outline: none;" id="aaa" name="contractTraderId"></td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right">关联到合同：</td>
                                            <td class="col-xs-9 text-left">
                                                <input readonly="readonly" id="fff" name="principalOrderId"><!-- <span>编号：2636464774376    名称：xxxx合同</span> -->
                                                <input readonly="readonly" id="contractId" name="readonlyId" type="hidden">
                                            </td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right">货物商品：</td>
                                            <td class="col-xs-9 text-left"><input readonly="readonly" id="ccc" name="goods"></td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right">订单金额：</td>
                                            <td class="col-xs-9 text-left"><input readonly="readonly" id="ddd" name="orderAmount">￥万元</td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right">申请用信：</td>
                                            <td class="col-xs-9 text-left">
                                                <form class="form-inline">
                                                    <div class="checkbox">
                                                            <input id="eee" readonly="readonly"  name="applicationletter">￥万元
                                                    </div>
                                                </form>
                                            </td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right">收货信息：</td>
                                            <td class="col-xs-9 text-left"><span style="padding-right: 15px">收货地址：</span><input id="sss" readonly="readonly" name="receivingAddress"><input id="zzz" type="hidden" name="receivingAddressId"></td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right"></td>
                                            <td class="col-xs-9 text-left">
                                                <span><span style="padding-right: 25px">收货人：</span><input readonly="readonly" id="mmm" name="ogisticsName"></span>
                                            </td>
                                    </tr>
                                    <tr>
                                            <td class="col-xs-3 text-right"></td>
                                            <td class="col-xs-9 text-left">
                                                <span><span style="padding-right: 25px">手机号：</span><input readonly="readonly" id="ppp" name="contactPhone"></span>
                                            </td>
                                    </tr>
                                    </tbody>
                                </table>
                                 <input type="hidden" value="0" name="orderStatus">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal" id="confirm">确定</button>
                            <button type="button" class="btn" data-dismiss="modal">取消</button>
                        </div>
                       
                    </div>
                </div>
                </form>
            </div>
            <%--合同管理模态框--%>
            <div class="modal fade" id="myModalGlht" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabelLetter">详情</h4>
                        </div>
                        <div class="modal-body">
                            <div class="panel-body">
                                <div class="khh">
                                    <form class="form-inline khh_form">
                                        <div class="form-group">
                                            <label>订单时间：</label>
                                            <input class="form-control"  readonly="readonly"  id="creatTime" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})" placeholder="开始日期"/>至
		                   					<input class="form-control"  readonly="readonly"  id="endTime" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'creatTime\')}'})" placeholder="结束日期"/>
                                        </div>
                                        <button type="button" style="height: 30px;font-size: 12px" class="btn btn-danger btn-default" onclick="crownSearch()">查询</button>
                                        <button type="button" style="height: 30px;font-size: 12px" class="btn btn-danger btn-default" onclick="reset()">重置</button>
                                    </form>
                                </div>
                                <div id="qweqwe">
                                  <table id="tb_departments" class="cj_table"></table>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="item_info_btn_do" class="btn btn-default" data-dismiss="modal">确定</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </div>
                </div>
            </div>
            <%--合同管理模态框结束--%>
        </div>

    </div>
</div>
</body>
<script>
	$("#glshxx").click(function(){
		$('#load').load('<%=request.getContextPath()%>/procurementMain/glshxx.action')
	});


    $('#glht').click(function () {
    	$("#tb_departments").bootstrapTable(
				"refresh",
				{
					url:"<%=request.getContextPath()%>/pmorder/getInforIdContract.action"
				}
			)
    	var glhtId=$('#input-select').children('option:selected').attr('id');
        if($('#orderCreatorTrade').val()==''||$('#orderCreatorTrade').val()==undefined){
            alert('请先选择合同签约人')
        }else{
        		$("#tb_departments").bootstrapTable({
        		      columns:[
        		          {checkbox: true},
        		          {field:'contractNumber',title:'合同编号'},
        		          {field:'contractName',title:'合同名称'},
        		          {field:'contractNumber',title:'辅合同'},
        		          {field:'contractCreateTime',title:'合同执行期',
        		        	  formatter:function(value,row,index){
        	                		var str = '';
        	                		if(row.contractCreateTime==null){
        	                			str = '--'
        	                		}else{
        	                			 var str='';
        	                      		 str +='<p>'+ConvertToDate(value)+'</p>';
        	                              return str;
        	                		}

        	                     }
        		          },
        		          {field:'contractFounder',title:'合同创建人'}
        		      ],
        		      url:'<%=request.getContextPath()%>/pmorder/getInforIdContract.action',
        		      method:'post',
        		      queryParamsType:'',
        		      singleSelect : true,
        		      queryParams: queryParam,//传递参数（*）
        		      //【其它设置】
        		      locale:'zh-CN',//中文支持
        		      pagination: true,//是否开启分页（*）
        		      pageNumber:1,//初始化加载第一页，默认第一页
        		      pageSize: 3,//每页的记录行数（*）
        		      sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        		      //发送到服务器的数据编码类型  {order: "asc", offset: 0, limit: 5}
        		      contentType:'application/x-www-form-urlencoded;charset=UTF-8'   //数据编码纯文本  offset=0&limit=5
        		  });
        		  //创建面板
        		  $('#item_info_btn_do').click(function(){
        	        var selectContent = $("#tb_departments").bootstrapTable('getSelections')[0];
        	        if(typeof(selectContent) == 'undefined') {
        	            /* toastr.wraning('请选择数据') */
        	            return false;
        	        }else{
        	            var readonly=selectContent.contractName;
        	            var readonlyId=selectContent.contractId;
        	            $('#principalOrderId').val(readonly);
        	            $('#readonlyId').val(readonlyId);
        	            $('#item_project_modal').modal('show');   // 项目立项面板
        	        }
        	    });
        		  function queryParam (params) {
        		      var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        		         // aid: $('#input-select').children('option:selected').attr('id'),
        		          aid: $('#input-select').children('option:selected').attr('id'),
        		      	  pageNumber: params.pageNumber,
        	              pageSize: params.pageSize,
        	              creatTime:$("#creatTime").val(),
        	              endTime:$("#endTime").val(),
        		      };
        		      console.log(temp.aid)
        		      return temp;

        		  }


        }
    })

    $(function(){
        var select = $('#input-select'),TempArr;//取得select的当前对象
        $.ajax({
            url:'http://192.168.17.228:8080/supplyChain/pmorder/getMohujs.action',
            type:'post',
            dataType:'json',
            timeout:5000,
            success:function (data) {
                console.log(data.data)
                var data=data.data;
                TempArr = data;
                $.each(data,function(k,v){
                    var option = '<option id='+v.id+' value='+v.id+'>'+v.entName+'</option>';
                    select.append(option);
                    //TempArr[k] = v.entName;
                });

            },
            error:function(){
                select.html('');
                var option = '<option for=no-con>获取数据失败，请重试</option>';
                select.append(option);
            }
        });

        $(document).on({
            focus:function(){
                select.css('display','');
            },
            input:function(){
                select.html('');
                var this_val = $(this).val();
                $.each(TempArr,function(k,v){
                    //若找到option中包含input的内容，添加对应的option
                    if(new RegExp(this_val).test(v.entName)){
                        //var option = $('<option></option>').text(TempArr[k]);
                        var option = '<option id='+v.id+' value='+v.entName+'>'+v.entName+'</option>';
                        select.append(option);
                    }
                });
                //取总共匹合的数量
                if(!select.find('option').length){
                    var option = '<option for=no-con>暂无数据</option>';
                    select.append(option);
                }
            }
        },'#orderCreatorTrade');

        $(document).on('click', function(e){
            var e = e || window.event; //浏览器兼容
            var elem = e.target || e.srcElement;
            while (elem){ //循环判断至根节点
                if(elem.id && (elem.id == 'input-select' || elem.id == 'orderCreatorTrade')){
                    return;
                }
                elem = elem.parentNode;
            }
            select.css('display','none');
        });

        /**
         * input op
         */


        /**
         * select op
         */
        $(document).on('change','#input-select',function(){
            if($(this).children('option').attr('for')=='no-con'){return false;}
            $(this).prev('input').val($(this).find('option:selected').text());
            $(this).css('display','none');
        });


    });

	$(function(){
		$.post(
			"<%=request.getContextPath()%>/pmorder/insetOrder.action",
			function(obj){
				/* //2有数据 */
				if(obj.receivingAddressId==null){
					$('#glshxx').show()
					$('.qwer').hide()
					$('#address').val('')
				}else if(obj.receivingAddressId!=null){
					$('#glshxx').hide()
					$('.qwer').show()
				}
				$("#address").append(obj.address);
				$("#rAddressPerson").append(obj.rAddressPerson);
				$("#rAddressPhone").append(obj.rAddressPhone);
				$("#receivingAddressId").val(obj.receivingAddressId);
			},"json"
		);
	});


	$("#bbb").click(function(){
		var a=$("#orderCreatorTrade").val();
		$("#aaa").val(a);
		var b=$("#principalOrderId").val();
		$("#fff").val(b);
		var id = $("#readonlyId").val();
		$("#contractId").val(id);
		var c=$("#goods").val();
		$("#ccc").val(c);
		var d=$("#orderAmount").val();
		$("#ddd").val(d);
		var e=$("#applicationletter").val();
		$("#eee").val(e);
		//var s=$("#address").append("收货地址：'"+obj.address+"'（默认收货信息）").val();
		$("#sss").val($("#address").html());
		$("#zzz").val($("#receivingAddressId").val());
		$("#mmm").val($("#rAddressPerson").html());
		$("#ppp").val($("#rAddressPhone").html());
	});

    $('#id').click(function(){
        if($('#id').is(':checked')){
            $('#applicationletter').removeAttr("disabled");
        }else{
            $('#applicationletter').attr("disabled","disabled");
        }
    })


	$('#ddglOrder').click(function(){
	    $('#load').load('<%=request.getContextPath()%>/procurementMain/ddgl.action')
	})



	/*确认新增订单*/
	$("#confirm").click(function(){
		var telephone=$("#ppp").val();
		var orderCreatorTradeId=$("#aaa").val();
		var goods=$("#ccc").val();
		var orderAmount=$("#ddd").val();
		var applicationletter=$("#eee").val();
		var principalOrderId=$("#fff").val();
		var contractId=$("#contractId").val();
		var receiver=$("#mmm").val();
		//var address=$("#sss").val();
		var receivingAddressId=$("#zzz").val();
		$.ajax({
			url:"<%=request.getContextPath()%>/pmorder/confirmOder.action",
			type:'post',
			data:{
				receiver:receiver,
				telephone:telephone,
				orderCreatorTradeId:orderCreatorTradeId,
				goods:goods,
				orderAmount:orderAmount,
				applicationletter:applicationletter,
				principalOrderId:principalOrderId,
				//address:address,
				receivingAddressId:receivingAddressId,
                contractId:contractId
				},
			dataType:"json",
			success:function(data){
				if(data.success){
					alert(data.msg);
					setTimeout("$('#load').load('<%=request.getContextPath()%>/procurementMain/ddgl.action')",500);
				}else{
					alert(data.msg);
				}
			}
		}); 
	});
</script>
</html>