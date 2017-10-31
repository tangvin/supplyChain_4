var url;
$(document).ready(function(){		
	$('#dlg').dialog('close');
	$('#pwd').dialog('close');
	$('#hp').dialog('close');
});

function reloadgrid()  {
	var searchInfo = $("#searchInfo").val();
	var startTime = $("input[name=startTime]").val();
	var endTime = $("input[name=endTime]").val();
    //查询参数直接添加在url中         
    /* var url =$('#test').datagrid('options').url;
       url = "http://127.0.0.1:8080/web/AppAndRemoveServer.server?state=" +stateVal;   
	//重新赋值url 属性
     $('#test').datagrid('options').url=url;
     $("#test").datagrid('reload'); 
     */
     //查询参数直接添加在queryParams中    
     var queryParams = $('#dg').datagrid('options').queryParams;  
     queryParams.searchInfo = searchInfo;  
     queryParams.startTime = startTime; 
     queryParams.endTime = endTime; 
     $('#dg').datagrid('options').queryParams=queryParams;        
     $("#dg").datagrid('reload'); 
 }
		
		/*********************************弹出框相关 开始********************************************/

		/*********************************弹出框相关 结束********************************************/
		
		
		/*********************************数据编辑相关 开始********************************************/
		var editIndex = undefined;
		function update() {
		    //选中一行进行编辑
		    var rows = $("#dg").datagrid('getSelected');
		    if (rows) {
		    	$('#dlg').dialog('open');
		    	getOrganUser(rows.userId);
		    }else{
		    	alert("请选择需要修改的数据！");
		    }
		    /*
            if (rows.length == 1) {//选中一行的话触发事件
                if (editIndex != undefined) {
                    $("#dg").datagrid('endEdit', editIndex);//结束编辑，传入之前编辑的行
                    var index = $("#dg").datagrid('getRowIndex', rows[0]);//获取选定行的索引
                    $("#dg").datagrid('beginEdit', index);//开启编辑并传入要编辑的行
                    editIndex = index;
                }
                if (editIndex == undefined) {
                    var index = $("#dg").datagrid('getRowIndex', rows[0]);//获取选定行的索引
                    $("#dg").datagrid('beginEdit', index);//开启编辑并传入要编辑的行
                    editIndex = index;
                }
            }*/
		}
		
		//通过用户编号获取机构用户信息
		function getOrganUser(userId){
	    	$.ajax({  
	            url:url+"/organUser/select.json",
	            contentType:"application/json",
	            data:{
	            	"userId":userId,
	            	"data":new Date()
	            },
	            success:function(data){  
	            	$("#headphoto").attr("src",data.headphoto);
	                $('#ff').form('load',{
		                userId: data.userId,
						loginName: data.loginName,
						email:data.email,
						mobilePhone:data.mobilePhone,
						status:data.status,
						idcard:data.idcard,
						userName: data.userName,
						sex: data.sex,
						birthday:data.birthday!=null ? (new Date(parseFloat(data.birthday))).format("yyyy-MM-dd"):"",
						certType:data.certType,
						realName:data.realName,
						sign:data.sign,
						habit:data.habit,
						speciality:data.speciality,
						homeAddress : data.homeAddress,
						officeAddress : data.officeAddress,
						jobNum : data.jobNum,
						jobTitle : data.jobTitle
					});
	           	}  
	       });  
	    }

		//用户编辑或添加提交
		  function submit(){
			  var userId = $("input[name='userId']").val();
			  if(userId!=null&&userId!=""&&userId!=undefined){
				  turnOnValidate();
				  updateUserCore()
			  }else{
				  turnOnValidate();
				  insertUserCore();
			  }
		  }
		  
		  //添加机构用户
		  function insertUserCore(){
				var isValid = $('#ff').form('validate');//所有字段有效返回true
				if(!isValid){
					return;
				}
		    	$.ajax({
		            url:url+"/organUser/insertOrganizationUser.json",
		            contentType:"application/json",
		            data:{
						"loginName" : $("input[name='loginName']").val(),
						"userName" : $("input[name='userName']").val(),
						"birthday" : $("input[name='birthday']").val()+" 00:00:00",
						"age" : $("input[name='age']").val(),
						"email" : $("input[name='email']").val(),
						"mobilePhone" : $("input[name='mobilePhone']").val(),
						"sex" : $("input[name='sex']").val(),
						"sign" : $("input[name='sign']").val(),
						"habit" : $("input[name='habit']").val(),
						"speciality" : $("input[name='speciality']").val(),
						"level" : $("input[name='level']").val(),
						"realName" : $("input[name='realName']").val(),
						"certType" : $("input[name='certType']").val(),
						"homeAddress" : $("input[name='homeAddress']").val(),
						"officeAddress" : $("input[name='officeAddress']").val(),
						"jobNum" : $("input[name='jobNum']").val(),
						"jobTitle" : $("input[name='jobTitle']").val(),
						"headphoto" : $("#headphoto").attr("src"),
						"date" : new Date()
		            },
		            success:function(data){
		            	if(data.head.rtnCode=="000000"){
		            		$("#password").html(data.body);
			            	$('#pwd').dialog('open');
	                   	 	$('#ff').form('clear');
	                   	 	$('#dlg').dialog('close');
	                   	 	turnOffValidate();
	                   		$("#dg").datagrid({
	                   			url: url+"/organUser/list.json",
					        });
	                    }else{
	                    	turnOffValidate();
	                   	 	alert(data.head.rtnMsg);
	                    }
		           	}  
		       });  
		    }
		  
		  //更新机构用户
		  function updateUserCore(){
			var isValid = $('#ff').form('validate');//所有字段有效返回true
			if(!isValid){
				return;
			}
	    	$.ajax({
	            url:url+"/organUser/updateOrganizationUser.json",
	            contentType:"application/json",
	            data:{
	            	"userId" : $("input[name='userId']").val(),
	            	"loginName" : $("input[name='loginName']").val(),
					"userName" : $("input[name='userName']").val(),
					"birthday" : $("input[name='birthday']").val()+" 00:00:00",
					"age" : $("input[name='age']").val(),
					"email" : $("input[name='email']").val(),
					"mobilePhone" : $("input[name='mobilePhone']").val(),
					"sex" : $("input[name='sex']").val(),
					"sign" : $("input[name='sign']").val(),
					"habit" : $("input[name='habit']").val(),
					"speciality" : $("input[name='speciality']").val(),
					"level" : $("input[name='level']").val(),
					"realName" : $("input[name='realName']").val(),
					"certType" : $("input[name='certType']").val(),
					"idcard" : $("input[name='idcard']").val(),
					"homeAddress" : $("input[name='homeAddress']").val(),
					"officeAddress" : $("input[name='officeAddress']").val(),
					"jobNum" : $("input[name='jobNum']").val(),
					"headphoto" : $("#headphoto").attr("src"),
					"jobTitle" : $("input[name='jobTitle']").val(),
					"date" : new Date()
	            },
	            success:function(data){  
	            	if(data.head.rtnCode=="000000"){
                   	 $('#ff').form('clear');
                   	 $('#dlg').dialog('close');
                   	 turnOffValidate();
               		 $("#dg").datagrid({
               			url: url+"/organUser/list.json",
			         });
                    }else{
                    	alert(data.head.rtnMsg);
                    	turnOffValidate();
                    }
	           	}  
	       });  
	    }
		
		function endEditing() {
			if (editIndex == undefined) {
				return true;
			}
			if ($('#dg').datagrid('validateRow', editIndex)) {
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickRow(index) {
			if (editIndex != index) {
				if (endEditing()) {
					$('#dg').datagrid('selectRow', index).datagrid('beginEdit',
							index);
					editIndex = index;
				} else {
					$('#dg').datagrid('selectRow', editIndex);
				}
			}
		}
		function append() {
			$('#dlg').dialog('open');
			
			/*if (endEditing()) {
				editIndex = $('#dg').datagrid('getRows').length - 1;
				$('#dg').datagrid('selectRow', editIndex).datagrid('beginEdit',
						editIndex);
			}*/
		}
		function removeit() {
			if (editIndex == undefined) {
				return
			}
			$('#dg').datagrid('cancelEdit', editIndex).datagrid('deleteRow',
					editIndex);
			editIndex = undefined;
		}
		function accept() {
			if (endEditing()) {
				$('#dg').datagrid('acceptChanges');
			}
		}
		function reject() {
			$('#dg').datagrid('rejectChanges');
			editIndex = undefined;
		}
		function getChanges() {
			var rows = $('#dg').datagrid('getChanges');
			alert(rows.length + ' rows are changed!');
		}
		
		/*********************************数据编辑相关 结束********************************************/
		
		/*********************************分页相关 开始********************************************/
		
		$(function() {
			//设置分页控件 
			var p = $("#dg").datagrid("getPager");
			$(p).pagination({
				/* beforePageText : '第',//页数文本框前显示的汉字 
				afterPageText : '页    共 {pages} 页',
				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录', */
				onBeforeRefresh : function() {
					alert('before refresh');
				},
				onRefresh : function(pageNumber, pageSize) {
					$("#dg").datagrid({
				         url: url+"/organUser/list.json",
				         pageList : [ 10, 15, 20 ],//可以设置每页记录条数的列表 
				         pageNumber: pageNumber,
				         pageSize: pageSize
				        });
				},
				onChangePageSize : function(pageSize) {
					$("#dg").datagrid({
				         url: url+"/organUser/list.json",
				         pageList : [ 10, 15, 20 ],//可以设置每页记录条数的列表 
				         pageSize: pageSize
				        });
				},
				onSelectPage : function(pageNumber, pageSize) {
					$("#dg").datagrid({
				         url: url+"/organUser/list.json",
				         pageList : [ 10, 15, 20 ],//可以设置每页记录条数的列表 
				         pageNumber: pageNumber,
				         pageSize: pageSize
				        });
				}
			});
		}); 
		/*********************************分页相关 结束********************************************/
		
		
		function turnOnValidate(){
			$('#ff').form('enableValidation').form('validate');
		}
	  
	  function turnOffValidate(){
		    $('#ff').form('disableValidation').form('validate');
		}
		
		/*********************************timestamp格式转换 开始********************************************/
		Date.prototype.format = function(format) {
			   var o = {
			       "M+": this.getMonth() + 1,
			       // month
			       "d+": this.getDate(),
			       // day
			       "h+": this.getHours(),
			       // hour
			       "m+": this.getMinutes(),
			       // minute
			       "s+": this.getSeconds(),
			       // second
			       "q+": Math.floor((this.getMonth() + 3) / 3),
			       // quarter
			       "S": this.getMilliseconds()
			       // millisecond
			   };
			   if (/(y+)/.test(format) || /(Y+)/.test(format)) {
			       format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
			   }
			   for (var k in o) {
			       if (new RegExp("(" + k + ")").test(format)) {
			           format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
			       }
			   }
			   return format;
		};
		
		/*********************************timestamp格式转换 结束********************************************/
		
		/*********************************日期选择器格式修改相关 开始********************************************/
		 function myformatter(date){
			 var y = date.getFullYear();
			 var m = date.getMonth()+1;
			 var d = date.getDate();
			 return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
			 }
		  function myparser(s){
			  if (!s) return new Date();
			  var ss = (s.split('-'));
			  var y = parseInt(ss[0],10);
			  var m = parseInt(ss[1],10);
			  var d = parseInt(ss[2],10);
			  if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
			  return new Date(y,m-1,d);
			  }else{
			  return new Date();
			  }
			 }
		  /*********************************日期选择器格式修改相关 结束********************************************/
		
		/*
		 * 列宽百分比显示控制方法
		 */
		function fixWidth(percent) {
			return document.body.clientWidth * percent; //这里你可以自己做调整  
		}