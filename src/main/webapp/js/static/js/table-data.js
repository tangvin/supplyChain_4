
var pathName=window.document.location.pathname;
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
$(function(){

	/*
	 * ajax 读取数据
	*/
	var data_page = function(page_size,page_num){
		//处理分页显示
		var page_view = function(){
			//这里写样式
			$('page_tb').html('<span onlick="data_page(30,1)">上一页');
		}


		$.ajax({
		    url:projectName+'/letter.letterSelect.action',
		    type:'post',
		    data:{'page_size':page_size,'page_num':page_num},
		    success:function(data){
				/*
				 * ajax-data view
				*/
			
				//对数据进行排序
				data.rows = data.rows.sort(function(a,b){  
					return a - b;
				});

				$('#tb').attr('data',data.rows.length);

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
						// console.log($("#tb tr[for^='arr_']").length)

						var cr_i = i;
						$.each(v.fu,function(index,value) {
							//需要创建的内容
							var data_con = '<tr class="arr_'+i+'" style="display:none;">';
							    data_con += '<td>'+(index+1)+'</td>';
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

	data_page(30,1);

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
		alert('111')
		var this_for = $(this).parent().attr('for');
		if($(this).parent().nextAll('tr[class='+this_for+']').is(':hidden')){
			$(this).parent().nextAll('tr[class='+this_for+']').css('display','');
		}
		else{
			$(this).parent().nextAll('tr[class='+this_for+']').css('display','none');
		}
	});

	//$(document).on('click','table#tb',function(){
		//console.log($('table#tb').attr('data'));
	//});

	//$('table#tb').trigger('click',function(){
		//console.log($('table#tb').attr('data'));
	//});


});