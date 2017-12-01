<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>合同签约</title>
    <style>
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

    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--合同签约 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
            <span>></span>
            <a href="#">合同签约</a>
        </div>
        <!--合同签约 头部 end-->
        <div class="col-xs-12">
            <!--合同签约 状态-->
            <div class="khh">
                <form class="form-inline khh_form">
                    <div class="form-group">
                        <label>状态</label>
                        <select class="form-control select">
                            <option>全部</option>
                            <option>全部1</option>
                            <option>全部2</option>
                            <option>全部3</option>
                            <option>全部4</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>合同执行期</label>
                        <input type="text" readonly="readonly" name="birthday" id="birthday1" class="form-control" value="03/18/2013" />--
                        <input type="text" readonly="readonly" name="birthday" id="birthday" class="form-control" value="03/18/2013" />
                    </div>
                    <div class="form-group">
                        <label>签约方</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-group form-group_red_btn">
                        <button type="button" class="btn btn-danger btn-default btn1">查询</button>
                        <button type="button" class="btn btn-danger btn-default">重置</button>
                    </div>
                </form>
            </div>
            <!--合同签约 状态-->
            <!--合同分页 start-->
            <div class="fy">
                <div class="row fy_row">

                </div>
            </div>
            <!--合同分页 eng-->
            <!--合同表格 开始-->
            <div class="table-responsive text-center">
                <table class="table table-bordered text-center htbg" id="tb">
                        <thead>
                            <tr id="bt" class="active">
                                <td>序号</td>
                                <td>用户名</td>
                                <td>权限</td>
                                <td>操作</td>
                            </tr>
                        </thead>
                </table>
            </div>
            <!--合同认领 模态框-->
            <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="panel-body">
                            12312312
                        </div>
                    </div>
                </div>
            </div>
            <!--合同认领 模态框-->
            <!--合同表格 结束-->
            <!--合同分页 start-->
            <div class="fy fy_bg">
                <p class="page_all"></p>
                <div class="right">
                    <div class="page_tbs"></div>
                    <div class="page_tb"></div>
                    <ul id="jumpWhere"></ul>
                    <div class="page_tb1"></div>
                    <div class="page_tbw"></div>
                </div>
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
    $('#xzht2').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/xzht.action')
    });
    $('#htxq').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/htxq.action')
    });
    $('#htxq2').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/htxq.action')
    });
    $('#htbj').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/htbj.action')
    })

    $(function(){
        /*
         * ajax 读取数据
         */
        var data_page = function(page_size,page_num){

            $.ajax({
                url:'<%=request.getContextPath()%>/letter/letterSelect.action',
                type:'post',
//                dataType:'jsonp',
//                callback:'callback',
                data:{'pageSize':page_size,'pageNumber':page_num},
                success:function(data){
                    /*
                     * ajax-data view
                     */
                    //对数据进行排序
                    data.rows = data.rows.sort(function(a,b){
                        return a - b;
                    });

                    $('#tb').attr('data',data.rows.length);
                    $('div.fy').attr('pages',parseInt(data.total/page_size));

                    //处理分页显示
                    var page_view = function(){
                        var tempOption="";
                        for(var i=1;i<=parseInt(data.total/page_size);i++)
                        {
                            tempOption+='<li class="lilist">'+i+'</li>'

                        }
                        $("#jumpWhere").html(tempOption);
                        //这里写样式
                        $('.page_tbs').html('<span for="home" data="'+page_size+','+1+'">首页</span>');
                        $('.page_tb').html('<span for="prev" data="'+page_size+','+(page_num-1)+'">&laquo;</span>');
                        $('.page_tb1').html('<span for="next" data="'+page_size+','+(Number(page_num)+1)+'">&raquo;</span>');
                        $('.page_tbw').html('<span for="end" data="'+page_size+','+parseInt(data.total/page_size)+'">尾页</span>');
                        $('.page_all').html('<span class="tiao">总共:'+parseInt(data.total/page_size)+'页</span><span class="tiao">共'+data.total+'条</span>');
                    }

                    $('.page_tbs').append(page_view);
                    $('.page_tb').append(page_view);
                    $('.page_tb1').append(page_view);
                    $('.page_tbw').append(page_view);
                    $('.page_all').append(page_view);
                    $('#jumpWhere').append(page_view);

                    $.each(data.rows,function(i,v){
                        //需要创建的内容
                        var data_con = '<tr class="for_arr_'+i+'">';
                        data_con += '<td>'+v.id+'</td>';
                        data_con += '<td>'+v.letterName+'</td>';
                        data_con += '<td>'+v.letterTime+'</td>';
                        data_con += '<td>123</td>';
                        data_con += '</tr>';
                        //是否有下级数据
                        if(data.rows[i].id==0){
                            var cr_i = i;
                            $.each(v.fu,function(index,value) {
                                //需要创建的内容
                                var data_con = '<tr class="arr_'+i+'" style="display:none;">';

                                data_con += '<td>'+value.id1+'</td>';
                                data_con += '<td>'+value.name1+'</td>';
                                data_con += '<td>'+value.age1+'</td>';
                                data_con += '<td>123</td>';
                                data_con += '</tr>';
                                $('#bt').after(data_con);
                            });
                        }

                        $('#bt').after(data_con);
                        //给产生后续循环的数据创建一个图标样式并为构造做准备
                        $('.for_arr_'+cr_i).css({'background':'#eee','cursor':'pointer'});
                        $('.for_arr_'+cr_i).attr('for','arr_'+cr_i);
                        $('.for_arr_'+cr_i+'>td:nth-of-type(2)').append('<span class="span"></span>')

                    });
                },
                error:function(data){
                    alert('data error,try again later.');
                }
            });
        }

        data_page(3,1);

        /*
         * 折叠展开事件
         */
        //$(document).on('click','#tb tr[for*=arr_]',function(e){
        //	if($('tr.'+$(this).attr('for')).is(':hidden')){
        //		$('tr.'+$(this).attr('for')).css('display','');
        //	}
        //	else{
        //		$('tr.'+$(this).attr('for')).css('display','none');
        //	}
        //});

        $(document).on('click','#tb tr[for*=arr_]>td:nth-of-type(2)',function(e){
            var this_for = $(this).parent().attr('for');
            if($(this).parent().nextAll('tr[class='+this_for+']').is(':hidden')){
                $(this).parent().nextAll('tr[class='+this_for+']').css('display','');
            }
            else{
                $(this).parent().nextAll('tr[class='+this_for+']').css('display','none');
            }
        });

        $(document).on('click','div.page_tb>span,div.page_tb1>span,div.page_tbs>span,div.page_tbw>span',function(){
            var ac_data = $(this).attr('data'),pages = $('div.fy').attr('pages');
            if(ac_data.split(',')[1]==0 || pages<ac_data.split(',')[1]) return;
            $('tr#bt').nextAll('tr').empty();
            data_page(ac_data.split(',')[0],ac_data.split(',')[1]);
        });
        $(document).on('click','#jumpWhere li',function(){
            var ac_data1 = $(this).index()+1;
            $('tr#bt').nextAll('tr').empty();
            data_page(3,ac_data1);

        });

    });


</script>
</html>

