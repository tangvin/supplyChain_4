<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>合同管理</title>
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
    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--订单管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
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
                        <select class="form-control select" id="contractStatus" name="contractStatus">
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
                        <input class="form-control"  readonly="readonly" name="creatTime"  id="creatTime" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'creatTime\')}'})" placeholder="开始日期"/>至
                        <input  class="form-control"  readonly="readonly" name="endTime" id="endTime" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'endTime\')}'})" placeholder="结束日期"/>
                    </div>
                    <div class="form-group">
                        <label>签约方：</label>
                        <input type="text" name="procurementEntName" class="form-control" id="procurementEntName">
                    </div>
                    <button type="button" class="btn btn-danger btn-default" id="search">查询</button>
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

            <!--领取合同 模态框-->
            <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="panel-body text-center">
                            确定领取合同吗？
                        </div>
                        <div class="modal-footer">
                            <button id="lqht" type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--领取合同 模态框-->

            <!--驳回理由 模态框-->
            <div class="modal fade bs-example-modal-bohui" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel" style="font-size: 14px;">输入驳回理由</h4>
                        </div>
                        <form id="contractReject">
                        <div class="panel-body text-center">
                            <textarea name="rejectReason" style="resize: none" class="form-control" rows="3"></textarea>
                        </div>
                        </form>
                        <div class="modal-footer">
                            <button  id="contractBohui" type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--驳回理由 模态框-->

            <!--终止合同 模态框-->
            <div class="modal fade bs-example-modal-zhongzhi" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_zhongzhi">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="panel-body text-center">
                           确认终止合同吗？
                        </div>
                        <div class="modal-footer">
                            <button id="stopContract" type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--终止合同 模态框-->



        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
</body>
<script>

    $(function(){
        var page_size = 2,page_num = 1,obj = null,obj_values = {};

        /*
         * ajax 读取数据
         */
        var data_page = function(page_size,page_num,obj){

            //显示数据
            $.ajax({
                //url:projectName+'/letter.letterSelect.action',
                url: '<%=request.getContextPath()%>/contract/contractShow.action',
                type: 'post',
                data: {'pageSize': page_size, 'pageNumber': page_num,'obj':obj},
                cache:false,
                success:function(data){
                    //清除垃圾数据
                    $('#bt').nextAll().remove();
                    /*
                     * ajax-data view
                     */
                    //对数据进行排序
                    data.rows = data.rows.reverse();
                    console.log(data);

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
                            //i+pn = (i+pn)>Math.ceil(data.total/page_size);
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
                        data_con += '<td>' + v.procurementEntName + '</td>';
                        data_con += '<td><span>' + ConvertToDate(v.creatTime )+ '</span><p>' + ConvertToDate(v.endTime )+ '</p></td>';
                        data_con += '<td><span>' + v.buyerSignatory + '</span><p>' + ConvertToDate(v.signingTime )+ '</p></td>';
                        data_con += '<td>' + v.attachmentAmount + '</td>';
                        data_con += '<td><span id="letterApply"></span></td>';
                        data_con += '<td><div id="anniu"></div></td>';
                        data_con += '</tr>';
                        //是否有下级数据
                        if (data.rows[i].assistContractList.length > 0) {
                            var cr_i = i;
                            $.each(v.assistContractList, function (index, value){
                                //需要创建的内容(辅合同)
                                var data_con = '<tr class="arr_' + i + '" style="display:none;">';
                                data_con += '<td>' + value.contractNumber + '</td>';
                                data_con += '<td>' + value.assistName + '</td>';
                                data_con += '<td id="fu_start">' + value.assistStatus + '</td>';
                                data_con += '<td>--</td>';
                                data_con += '<td>' + value.buyerEntName + '</td>';
                                data_con += '<td><span>' + ConvertToDate(value.assistCreatTime )+ '</span><p>' + ConvertToDate(value.assistEndTime )+ '</p></td>';
                                data_con += '<td><span>'+value.buyerName+'</span><p>' + ConvertToDate(value.assistCreatTime ) + '</p></td>';
                                data_con += '<td>' + value.assistAttachmentAmount + '</td>';
                                data_con += '<td><span id="assistLetterApply"></span></td>';
                                data_con += '<td><div id="fu_anniu"></div></td>';
                                data_con += '</tr>';
                                $('#bt').after(data_con);
                                //辅合同按钮
                                if(v.assistContractList[index].assistStatus==0){
                                    $('#fu_anniu').html('<button data-toggle="modal" data-target=".bs-example-modal-sm" onclick="qweShowAssist(\''+v.assistContractList[index].assistId+'\',1)">认领</button><button data-toggle="modal" data-target=".bs-example-modal-bohui" onclick="RejectAssistContract(\''+v.assistContractList[index].assistId+'\',2)">驳回</button>');
                                    $('#fu_start').html('待领取')
                                }else if(v.assistContractList[index].assistStatus==1){
                                    $('#fu_anniu').html('<button data-toggle="modal" data-target=".bs-example-modal-zhongzhi" onclick="qweUserAttachAssist(\''+v.assistContractList[index].assistId+'\',3)">终止</button>');
                                    $('#fu_start').html('正常')
                                }else if(v.assistContractList[index].assistStatus==3){
                                    $('#fu_anniu').html('---');
                                    $('#fu_start').html('驳回')
                                } else if(v.assistContractList[index].assistStatus==2){
                                    $('#fu_anniu').html('---');
                                    $('#fu_start').html('已终止')
                                }else if(v.assistContractList[index].assistStatus==4){
                                    $('#fu_anniu').html('---');
                                    $('#fu_start').html('历史')
                                }
                                if(v.assistContractList[index].assistLetterApply==0){
                                    $('#assistLetterApply').html('否')
                                }else if(v.assistContractList[index].assistLetterApply==1){
                                    $('#assistLetterApply').html('是')
                                }
                            });
                        }
                        $('#bt').after(data_con);
                        //给产生后续循环的数据创建一个图标样式并为构造做准备
                        $('.for_arr_' + cr_i).css({'background': '#eee', 'cursor': 'pointer'});
                        $('.for_arr_' + cr_i).attr('for', 'arr_' + cr_i);
                        $('.for_arr_' + cr_i + '>td:nth-of-type(2)').append('<span class="span"></span>')
                        //主合同按钮开始
                        if(data.rows[i].contractStatus==0){
                            $('#anniu').html('<button data-toggle="modal" data-target=".bs-example-modal-sm" onclick="qweShow(\''+data.rows[i].contractId+'\',1)">认领</button><button data-toggle="modal" data-target=".bs-example-modal-bohui" onclick="showReject(\''+data.rows[i].contractId+'\',2)">驳回</button>');
                            $('#start').html('待领取')
                        }else if(data.rows[i].contractStatus==1){
                            $('#anniu').html('<button data-toggle="modal" data-target=".bs-example-modal-zhongzhi" onclick="showUserAttach(\''+data.rows[i].contractId+'\',3)">终止</button>');
                            $('#start').html('正常')
                        }else if(data.rows[i].contractStatus==3){
                            $('#anniu').html('--');
                            $('#start').html('驳回')
                        } else if(data.rows[i].contractStatus==2){
                            $('#anniu').html('--');
                            $('#start').html('已终止')
                        }else if(data.rows[i].contractStatus==4){
                            $('#anniu').html('--');
                            $('#start').html('历史')
                        }
                        if(data.rows[i].letterApply==0){
                            $('#letterApply').html('否')
                        }else if(data.rows[i].letterApply==1){
                            $('#letterApply').html('是')
                        }
                    });
                },
                error: function (data) {
                    //alert('Data error,try again later.');
                }
            });

        }

        //初始数据
        data_page(page_size,page_num,obj);

        //分页处理
        $(document).on('click','.page>ul>li,#search',function(){
            if($(this).attr('id')=='search'){
                obj_temp = $('#orderform').serializeArray();
                for(x in obj_temp){
                    obj_values[obj_temp[x].name] = obj_temp[x].value;
                }
                obj = JSON.stringify(obj_values);
            }
            //处理
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
                    page_num = $(this).attr('for')=='op' ? parseInt($(this).text()) : page_num;
                    break;
            }
            //分页请求
            data_page(page_size,page_num,obj);
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



    //注意：主合同开始啦！！！

    //主合同领取按钮
    function qweShow(w,e){
        $("#lqht").click(function () {
           $.ajax({
                url:'<%=request.getContextPath()%>/contract/lqht.action?id='+w+'&&flag='+e,
                type:'post',
                dataType:"json",
                //data:$("#bohuireason").serialize(),
                success:function (data) {
                    setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/htqy.action')",500);
                }
            })

       })
    }

    //主合同终止按钮
    function showUserAttach(w,e){
        $("#stopContract").click(function () {
            $.ajax({
                url:'<%=request.getContextPath()%>/contract/lqht.action?id='+w+'&&flag='+e,
                type:'post',
                dataType:"json",
               // data:$("#bohuireason").serialize(),
                success:function (data) {
                    setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/htqy.action')",500);
                }
            })

        })
    }


    //主合同驳回按钮
    function showReject(w,e){
        $("#contractBohui").click(function () {
            $.ajax({
                url:'<%=request.getContextPath()%>/contract/bohuiContract.action?id='+w+'&&flag='+e,
                type:'post',
                dataType:"json",
                data:$("#contractReject").serialize(),
                success:function (data) {
                    setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/htqy.action')",500);
                }
            })

        })
    }


    /**
     * 注意：以下是辅合同ajax
     * @param w
     * @param e
     */

    //辅合同领取按钮
    function qweShowAssist(w,e){
        $("#lqht").click(function () {
            $.ajax({
                url:'<%=request.getContextPath()%>/contract/lqAssist.action?id='+w+'&&flag='+e,
                type:'post',
                dataType:"json",
                //data:$("#bohuireason").serialize(),
                success:function (data) {
                    if (data.success){
                        alert(data.message);
                    }else{
                        alert(data.message);
                    }
                    setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/htqy.action')",500);
                }
            })

        })
    }


    //辅合同终止合同按钮
    function qweUserAttachAssist(w,e){
        $("#stopContract").click(function () {
            $.ajax({
                url:'<%=request.getContextPath()%>/contract/lqAssist.action?id='+w+'&&flag='+e,
                type:'post',
                dataType:"json",
                // data:$("#bohuireason").serialize(),
                success:function (data) {
                    if (data.success){
                        alert(data.message);
                    }else{
                        alert(data.message);
                    }
                    setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/htqy.action')",500);
                }
            })

        })
    }


    //辅合同驳回按钮
    function RejectAssistContract(w,e){
        $("#contractBohui").click(function () {
            $.ajax({
                url:'<%=request.getContextPath()%>/contract/rejectAssist.action?id='+w+'&&flag='+e,
                type:'post',
                dataType:"json",
                data:$("#contractReject").serialize(),
                success:function (data) {
                    if (data.success){
                        alert(data.message);
                    }else{
                        alert(data.message);
                    }
                    setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/htqy.action')",500);
                }
            })

        })
    }






    $('#orderFreight').click(function(){
        setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/hygl.action')",500);
    });

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