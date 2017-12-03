$(function(){

    $.ajaxSetup({
        cache:false//关闭AJAX相应的缓存
    });

    /*
     * ajax 读取数据
     */
    var init_pagesize =3,init_page = 1,init_num = 0,data_page = function(page_size,page_num){

        $.ajax({
            url:'<%=request.getContextPath()%>/letter/newLetterSelect.action',
//                url:'../mainContract.json',
            type:'post',
            cache:false,
//                dataType:'jsonp',
//                callback:'callback',
            data:{'pageSize':page_size,'pageNumber':page_num},
            success:function(data){
                /*
                 * ajax-data view
                 */
                //对数据进行排序

                $('#tb').attr('data',data.rows.length);
                $('div.fy').attr('pages',parseInt(data.total/page_size));

                $.each(data.rows,function(i,v){
                    //需要创建的内容
                    var data_con = '<tr class="for_arr_'+i+'">';
                    data_con += '<td>'+(i+1)+'</td>';
                    data_con += '<td>'+v.id+'</td>';
                    data_con += '<td>'+v.letterName+'</td>';
                    data_con += '<td>'+v.letterTime+'</td>';
                    data_con += '<td class="lj"><a class="btn btn-sm">编辑</a><a  class="btn btn-primary btn-sm">新增</a><a class="btn btn-primary btn-sm" data-toggle="modal" data-target=".bs-example-modal-sm">申请融信</a><a  class="btn btn-warning btn-sm">处理驳回</a></td>';
                    data_con += '</tr>';
                    //是否有下级数据
                    if(data.rows[i].idList==1){
                        var cr_i = i;
                        $.each(v.listContract,function(index,value) {
                            //需要创建的内容
                            var data_con = '<tr class="arr_'+i+'" style="display:none;">';
                            data_con += '<td>'+(cr_i+1)+'--'+(index+1)+'</td>';
                            data_con += '<td>'+value.id1+'</td>';
                            data_con += '<td>'+value.name1+'</td>';
                            data_con += '<td>'+value.age1+'</td>';
                            data_con += '<td class="lj"><a class="btn btn-sm">编辑</a><a  class="btn btn-primary btn-sm">新增</a><a class="btn btn-primary btn-sm" data-toggle="modal" data-target=".bs-example-modal-sm">申请融信</a></td>';
                            data_con += '</tr>';
                            $('#bt').after(data_con);
                        });
                    }
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

                    $('#bt').after(data_con);
                    //给产生后续循环的数据创建一个图标样式并为构造做准备
                    $('.for_arr_'+cr_i).css({'cursor':'pointer'});
                    $('.for_arr_'+cr_i).attr('for','arr_'+cr_i);
                    $('.for_arr_'+cr_i+'>td:nth-of-type(2)').append('<span class="span"></span>');
                    init_num=init_num+1;
                    console.log(init_num);
                });

                $('#tb thead tr').not('#bt').mouseover(function () {
                    $(this).addClass('active')
                })
                $('#tb thead tr').not('#bt').mouseleave(function () {
                    $(this).removeClass('active')
                })
            },
            error:function(data){
                alert('data error,try again later.');
            }
        });
    };

    //data_page(init_pagesize,init_page);
    data_page(3,1);

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
        $('tr#bt').nextAll('tr').remove();
        data_page(ac_data.split(',')[0],ac_data.split(',')[1]);
    });

    $(document).on('click','#jumpWhere li',function(){
        var ac_data1 = $(this).index()+1;
        $('tr#bt').nextAll('tr').remove();
        data_page(init_pagesize,ac_data1);
    });

});