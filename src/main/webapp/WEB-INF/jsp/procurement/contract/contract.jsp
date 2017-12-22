<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta HTTP-EQUIV="Pragma" content="no-cache">
    <meta HTTP-EQUIV="Expires" content="-1">
    <title>合同签约</title>
    <style>
        body{width:100%;}
        #tb{width:100%;border-top:1px solid #ccc;border-right:1px solid #ccc;}
        #tb td{border:0.05rem solid #ccc;border-right:0;border-top:0;height:2rem;text-align:center;font-size:0.7rem;
            height:35px;padding:10px;}
        #bt>td{background:#eee;text-align:center;font-size:0.9rem;padding: 20px;}
        /*page set*/
        .page{margin:0 auto;padding:20px 0 10px 0;width:100%;height:auto;font-size:0;overflow:hidden;}
        .page>div,.page>ul{display:inline-block;height:auto;}
        .page>div{width:30%;text-align:left;font-size:12px;}
        .page>div>span{padding:0 3px 0 3px;color:#f00;}
        .page>ul{width:70%;text-align:right;}
        .page>ul>li{padding:0 10px 0 10px;list-style:none outside;display:inline-block;height:26px;line-height:26px;background:#fff;border:1px solid #ddd;border-right:0;font-size:12px;cursor:pointer;overflow:hidden;}
        .page>ul>li:hover,.page>ul>li.current{background:#DC143C;color:#fff;}
        .page>ul>li:last-of-type{border-right:1px solid #ddd;}
        .span{
            width:0;
            height:0;
            border-left:5px solid transparent;
            border-right:5px solid transparent;
            border-top:8px solid red;
            display: inline-block;
            margin-left:20px;
        }
        .fy_bg div span{
            /*background: #ddd;*/
            float: left;
            padding: 6px 10px;
            border:1px solid #ddd;
            cursor: pointer;
            color: #337AB7;
        }
        .fy_bg div span:hover{
            background: #f5f5f5;
        }
        .page_tbs>span,.page_tbw>span{
            border-radius: 3px;
        }
        .page_all{
            width:150px;
            float: left;
            margin-right:10px;
        }
        .fy_bg p .tiao{
            float: left;
            padding: 6px 10px;
        }
        #jumpWhere{
            float: left;
        }
        #jumpWhere li{
            cursor: pointer;
            float: left;
            list-style: none;
            border: 1px solid #ddd;
            padding: 6px 15px;
            cursor: pointer;
            color: #337AB7;
        }
        #jumpWhere li:hover{
            background: #f5f5f5;
        }
        .right{
            float: right;
            width: 400px;
        }
        #bt{
            font-size: 16px;
            height:30px;
            font-weight: bold;
        }
        .lj a{
            margin-right:10px;
        }
        .cg_xzht{
            margin:20px 0px;
        }
        #xzht2{
            margin-right:-15px;
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
            <a href="#">合同管理</a>
        </div>
        <!--订单管理 头部 end-->
        <div class="col-xs-12">
            <!--合同签约 状态-->
            <div class="khh">
                <form class="form-inline khh_form khh_form1" id="orderform">
                    <div class="form-group">
                        <label>合同状态：</label>
                        <select class="form-control select" id="orderStatus">
                            <option value="">全部</option>
                            <option value="0">待领取</option>
                            <option value="1">正常</option>
                            <option value="2">已终止</option>
                            <option value="3">驳回</option>
                            <option value="4">历史</option>
                        </select>
                    </div>
                    <div class="form-group form-group1">
                        <label>合同执行期：</label>
                        <input class="form-control"  readonly="readonly"  id="creatTime" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})" placeholder="开始日期"/>至
                        <input  class="form-control"  readonly="readonly"  id="endTime" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'creatTime\')}'})" placeholder="结束日期"/>
                    </div>
                    <div class="form-group">
                        <label>签约方：</label>
                        <input type="text" class="form-control" id="procurementEntName">
                    </div>
                    <%--<div class="form-group">--%>
                    <%--<label>合同</label>--%>
                    <%--<input type="text" class="form-control" id="contractName">--%>
                    <%--</div>--%>
                    <button type="button" class="btn btn-danger btn-default" onclick="search()">查询</button>
                    <button type="button" class="btn btn-danger btn-default" onclick="reset()">重置</button>
                </form>
            </div>

            <div style="margin-left: -15px;margin-right: -15px;margin-top: 30px;">
                    <table id="tb" cellpadding="0" cellspacing="0">
                        <tr id="bt">
                            <td>合同编号</td>
                            <td>合同名称</td>
                            <td>合同状态</td>
                            <td>辅合同</td>
                            <td>签约方</td>
                            <td>合同执行期</td>
                            <td>合同创建</td>
                            <td>合同扫描件</td>
                            <td>申请融信</td>
                            <td>操作</td>
                        </tr>
                    </table>
                    <div class="page">
                        <div>共<span></span>条，共<span></span>页</div>
                        <ul>
                            <li>首页</li>
                            <li>上一页</li>
                            <li>下一页</li>
                            <li>尾页</li>
                        </ul>
                    </div>
            </div>

            <!--领取订单 模态框-->
            <div class="modal fade bs-example-modal-sm lqdd_fh" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="panel-body text-center">
                            确定领取合同吗？
                        </div>
                        <div class="modal-footer">
                            <button id="lqdd" type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--领取订单 模态框-->

            <!--领取订单 模态框-->
            <div class="modal fade bs-example-modal-sm_bh lqdd_fh" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button   type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">请输入驳回理由：</h4>
                        </div>
                        <form id="bohuireason">
                            <div class="panel-body text-center">
                                <textarea  name="rejectReason" class="form-control" rows="3" width="200px"></textarea>
                            </div>
                        </form>
                        <div class="modal-footer">
                            <button type="button" id="ddbh" class="btn btn-default" data-dismiss="modal">确定</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--领取订单 模态框-->

            <!--配置发货 模态框-->
            <div class="modal fade bs-example-modal-pzfh" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <form  id="formId" method="post" >
                        <div class="modal-content">
                            <div class="modal-header">
                                <button   type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">配置发货</h4>
                            </div>
                            <div class="modal-body">
                                <div class="table-responsive text-center">
                                    <table class="table table-bordered bj_table">
                                        <tbody id="wyb">

                                        </tbody>
                                    </table>
                                </div>

                                <div class="table-responsive">
                                    <%--<form id="pzfh"  action="<%=request.getContextPath()%>/tradeOrder/pzfh.action"  method="post" enctype="multipart/form-data">--%>

                                    <table class="table htbg pzfh">
                                        <tbody>
                                        <tr>
                                            <div class="row">
                                                <td class="col-xs-3"><span class="xingxing">*</span>货运单位：</td>
                                                <td class="col-xs-8">
                                                    <div class="row pzfh_row">
                                                        <div class="col-xs-5 pzfh_row_div">
                                                            <select class="form-control" id="pzfh_select" name="freightName">
                                                            </select>
                                                        </div>
                                                        <div class="col-xs-5">
                                                            <button  id="orderFreight" type="button" data-dismiss="modal" class="btn btn-danger btn-default">管理货运单位</button>
                                                        </div>
                                                    </div>
                                                </td>
                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="row">
                                                <td class="col-xs-3"><span class="xingxing">*</span>货运编号:</td>
                                                <td class="col-xs-8">
                                                    <div class="row row_ddje">
                                                        <div class="col-xs-5 row_ddje_div">
                                                            <input type="text" name="freightUnit" class="form-control">
                                                        </div>
                                                        <div class="col-xs-6 row_ddje_con">
                                                            暂未查询到货运单位，请检查
                                                        </div>
                                                    </div>
                                                </td>
                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="row">
                                                <td class="col-xs-3"><span class="xingxing">*</span>发票号:</td>
                                                <td class="col-xs-8">
                                                    <div class="row row_ddje">
                                                        <div class="col-xs-5 row_ddje_div">
                                                            <input type="text" name="invoiceNo class="form-control">
                                                        </div>
                                                    </div>
                                                </td>
                                            </div>
                                        </tr>
                                        <tr>
                                            <div class="row">
                                                <td class="col-xs-3"><span class="xingxing">*</span>上传发票：</td>
                                                <td class="col-xs-9 text-left">
                                                    <div class="row" style="margin-right:0;">
                                                        <div class="col-xs-2">
                                                            <div id="inputBox" class="inputBox1 inputBox2">
                                                                <input type="file" title="请选择图片" id="file" multiple accept="image/png,image/jpg,image/gif,image/JPEG"/>
                                                                <span class="jiahao jaihao1">+</span>
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-8">
                                                            <div id="imgBox"></div>
                                                        </div>
                                                    </div>
                                                </td>
                                            </div>
                                        </tr>

                                        </tbody>
                                    </table>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-default" data-dismiss="modal" id="pzfh">确认</button>
                                        <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                                    </div>
                    </form>
                </div>

            </div>

        </div><!-- /.modal-content -->

    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!--配置发货 模态框-->
<!--合同表格 结束-->
</div>
</div>
</div>
</body>
<script>
    $(function(){
        var page_size = 2,page_num = 1;

        /*
         * ajax 读取数据
         */
        var data_page = function(page_size,page_num){

            //清除垃圾数据
            $('#bt').nextAll().remove();

            //显示数据
            $.ajax({
                //url:projectName+'/letter.letterSelect.action',
                url: '<%=request.getContextPath()%>/pmcontract/contractShow.action',
                type: 'post',
                data: {'pageSize': page_size, 'pageNumber': page_num},
                success:function(data){
                    console.log(data)
                    /*
                     * ajax-data view
                     */
                    //对数据进行排序
                    data.rows = data.rows.reverse();

                    //赋值数据数量和页数
                    $('.page>div>span:first-of-type').html(data.total);
                    $('.page>div>span:last-of-type').html(Math.ceil(data.total/page_size));

                    //处理分页显示
                    var page_view = function(){
                        //初始化分页数据
                        $('.page>ul>li[for*=op]').remove();

                        var fix_num = 6,pn,tempOption='';//显示的数字分页数量

                        fix_num = Math.ceil(data.total/page_size)>fix_num ? fix_num : Math.ceil(data.total/page_size);
                        pn = page_num - 1;



                        for(i=1;i<=fix_num;i++){
                            if((i+pn)>Math.ceil(data.total/page_size)) break;
                            //i+pn = (i+pn)>Math.ceil(data.total/page_size)

                            tempOption+='<li for=op>'+(i+pn)+'</li>';
                        }

                        $('.page>ul>li:nth-of-type(2)').after(tempOption);
                    }
                    //分页显示
                    page_view();

                    $.each(data.rows,function(i,v){
                        //需要创建的内容（主合同）
                        var data_con = '<tr class="for_arr_' + i + '">';
                        data_con += '<td>' + v.contractNumber + '</td>';
                        data_con += '<td>' + v.contractName + '</td>';
                        data_con += '<td><span id="start"></span></td>';
                        data_con += '<td>' + v.assistContractAmount + '</td>';
                        data_con += '<td>' + v.tradeEntName + '</td>';
                        data_con += '<td>' + v.creatTime + '</td>';
                        data_con += '<td>' + v.buyerSignatory + '</td>';
                        data_con += '<td>' + v.attachmentAmount + '</td>';
                        data_con += '<td><span id="letterApply"></span></td>';
                        data_con += '<td><div id="anniu"></div></td>';
                        data_con += '</tr>';
                        //是否有下级数据
                        if (data.rows[i].assistContractList.length > 0) {
                            // console.log($("#tb tr[for^='arr_']").length)
                            var cr_i = i;
                            $.each(v.assistContractList, function (index, value) {
                                //需要创建的内容
                                var data_con = '<tr class="arr_' + i + '" style="display:none;">';
                                data_con += '<td>' + value.contractNumber + '</td>';
                                data_con += '<td>' + value.assistName + '</td>';
                                data_con += '<td id="fu_start">' + value.assistStatus + '</td>';
                                data_con += '<td>--</td>';
                                data_con += '<td>' + value.contractId + '</td>';
                                data_con += '<td>' + value.buyerEntName + '</td>';
                                data_con += '<td>' + value.assistCreatTime + '</td>';
                                data_con += '<td>' + value.assistAttachmentAmount + '</td>';
                                data_con += '<td><span id="assistLetterApply"></span></td>';
                                data_con += '<td><div id="fu_anniu"></div></td>';
                                data_con += '</tr>';
                                $('#bt').after(data_con);
                                if(v.assistContractList[i].assistStatus==0){
                                	$('#fu_start').html('待领取')
                                	$('#fu_anniu').html('<button>编辑</button><button>取消</button>');
                                }else if(v.assistContractList[i].assistStatus==1){
                                	$('#fu_start').html('正常')
                                	$('#fu_anniu').html('<button>终止</button>');
                                }else if(v.assistContractList[i].assistStatus==2){
                                	$('#fu_start').html('已终止')
                                	$('#fu_anniu').html('---');
                                }else if(v.assistContractList[i].assistStatus==3){
                                	$('#fu_start').html('驳回')
                                	$('#fu_anniu').html('<button>编辑</button><button>取消</button>');
                                } else if(v.assistContractList[i].assistStatus==4){
                                	$('#fu_start').html('历史')
                                	$('#fu_anniu').html('---');
                                }


                                if(v.assistContractList[i].assistLetterApply==0){
                                    $('#assistLetterApply').html('否')
                                }else if(v.assistContractList[i].assistLetterApply==1){
                                    $('#assistLetterApply').html('是')
                                }

                            });
                        }

                        $('#bt').after(data_con);
                        //给产生后续循环的数据创建一个图标样式并为构造做准备
                        $('.for_arr_' + cr_i).css({'background': '#eee', 'cursor': 'pointer'});
                        $('.for_arr_' + cr_i).attr('for', 'arr_' + cr_i);
                        $('.for_arr_' + cr_i + '>td:nth-of-type(2)').append('<span class="span"></span>')

                        if(data.rows[i].contractStatus==0){
                        	$('#start').html('待领取')
                        	$('#anniu').html('<button>取消</button><button>编辑</button>');
                        }else if(data.rows[i].contractStatus==1){
                        	$('#start').html('正常')
                        	$('#anniu').html('<button>终止</button>');
                        }else if(data.rows[i].contractStatus==2){
                        	$('#start').html('已终止')
                        	$('#anniu').html('---');
                        }else if(data.rows[i].contractStatus==3){
                        	$('#start').html('驳回')
                        	$('#anniu').html('<button>取消</button><button>编辑</button>');
                        } else if(data.rows[i].contractStatus==4){
                            $('#start').html('历史')
                            $('#anniu').html('---');
                        }

                        if(data.rows[i].letterApply==0){
                            $('#letterApply').html('否')
                        }else if(data.rows[i].letterApply==1){
                            $('#letterApply').html('是')
                        }


                    });

                },
                error: function (data) {
                    alert('Data error,try again later.');
                }
            });

        }

        //初始数据
        data_page(page_size,page_num);

        //分页处理
        $(document).on('click','.page>ul>li',function(){
            switch($(this).text()){
                case '首页':
                    page_num = 1;
                    break;
                case '上一页':
                    page_num = page_num>1 ? (page_num -= 1) : 1;
                    break;
                case '下一页':
                    page_num = (page_num<parseInt($('.page>div>span:last-of-type').text())) ? page_num += 1 : parseInt($('.page>div>span:last-of-type').text());
                    break;
                case '尾页':
                    page_num = parseInt($('.page>div>span:last-of-type').text());
                    break;
                default:
                    page_num = parseInt($(this).text());
                    break;
            }
            //分页请求
            data_page(page_size,page_num);
        });

        //展开折叠数据
        $(document).on('click','#tb tr[for*=arr_]>td:nth-of-type(2)',function(e){
            var this_for = $(this).parent().attr('for');
            if($(this).parent().nextAll('tr[class='+this_for+']').is(':hidden')){
                $(this).parent().nextAll('tr[class='+this_for+']').css('display','');
            }
            else{
                $(this).parent().nextAll('tr[class='+this_for+']').css('display','none');
            }
        });

    });






    $('#orderFreight').click(function () {
        setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/hygl.action')",500);
    });

    imgUpload({
        inputId:'file', //input框id
        imgBox:'imgBox', //图片容器id
        buttonId:'btn', //提交按钮id
        upUrl:'',  //提交地址
        data:'file1',//参数名
    })

    /* 订单列表展示 */
    $(function(){
        $("#tb_departments").bootstrapTable({
            //隔行变色
//            striped:true,
            columns:[
                {field:'contractNumber',title:'合同编号',formatter:operateFormatter,events:operateEvents1},
                {field:'contractName',title:'合同名称',formatter:operateFormatter,events:operateEvents1},
                {field:'contractStatus',title:'合同状态',
                    formatter: function(value,row,index){
                        if( value == '0') {
                            return "待领取";
                        } else if(value == '1') {
                            return "正常";
                        } else if(value == '2') {
                            return "已终止";
                        }else if(value==6){
                            return "驳回";
                        }else if(value==7){
                            return "历史";
                        }
                    }
                },
                {field:'assistContractAmount',title:'辅合同'},
                {field:'procurementEntName',title:'签约方'},
                {field:'contractCreateTime',title:'合同执行期',
                    formatter:function(value,row,index){
                        console.log(row)
                        return ConvertToDate(value)
                    }
                },
                {field:'signingTime',title:'合同创建',
                    formatter:function(value,row,index){
                        var str='';
                        str+='<p>'+row.buyerSignatory+'</p><p>'+ConvertToDate(value)+'</p>'
                        return str
                    }
                },
                {field:'attachmentAmount',title:'合同扫描件'},
                {field:'letterApply',title:'融信申请'},
                {
                    title:'操作',
                    field:'action',
                    formatter:function(value , row){
                        var str = '';
                        if(row.contractStatus ==0){//待确认
                            str += '<button  class="btn  btn-primary bg_btn qran" data-toggle="modal" data-target=".bs-example-modal-sm" href="#" value="待领取" onclick="showUserAttach(\''+row.contractId+'\',1)">认领</button>';
                            str += '<button  class="btn btn-warning bg_btn" data-toggle="modal" data-target=".bs-example-modal-sm_bh" href="#" value="待领取" onclick="showUserAttache(\''+row.contractId+'\',2)">驳回</button>';
                        } else if(row.contractStatus ==0){//待付款
                            str+='--';
                        } else if(row.contractStatus ==1){//待发货
                            str+='--';
                        } else if(row.contractStatus ==2){//待收货
                            str+='--';
                        } else if(row.contractStatus ==3){//已完成
                            str+='--';
                        } else if(row.contractStatus ==4){//已取消
                            str+='--';
                        }
                        return str;
                    }
                }
            ],
            url:'<%=request.getContextPath()%>/contract/contractShow.action',
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
            contractStatus:$("#orderStatus").val(),
            creatTime:$("#creatTime").val(),
            endTime:$("#endTime").val(),
            buyerSignatory:$("#buyerSignatory").val(),
        };
        return temp;
    }
    //搜索
    function search() {
        $("#tb_departments").bootstrapTable('refresh');
    }
    <%--<%=request.getContextPath()%>/tradeMain/ddck.action--%>
    //重置查询
    function reset(){
        $("#orderform").form('reset');
        search();
    }
    function operateFormatter(value,index,row) {
        var le=''
        le='<a id="butt">'+value+'</a>'
        return le
    }

    window.operateEvents1={
        'click #butt':function (e,value,index,row) {
            $('#load').load('<%=request.getContextPath()%>/tradeMain/ddck.action?value='+value)
        }
    }

    // 定义时间格式
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