$(function () {
    // 定义easyui.datagrid默认属性
    $.extend($.fn.datagrid.defaults, {
        method:'post',//请求远程数据的请求方法
        fit : true, //当此属性为true时所有列会均匀的充满datagrid的宽度,True 就会自动扩大或缩小列的尺寸以适应表格的宽度并且防止水平滚动
        fitColumns : true,
        border : false,
        idField : 'id',//标识字段,主键的字段
        striped:'true',//为true就是隔行变色
        loadMsg:'正在加载数据,请稍等...',//从远处加载数据，正在加载的提示信息
        pagination:true,//为true时显示分页工具栏在datagrid 底部,默认为false
        rownumbers:true,//显示数据表格的行号，默认为false
        pageNumber:1,
        pageSize : 15,      // 默认一页显示X条
        pageList : [ 15, 20, 30, 40, 50 ],
        singleSelect:true,
        enableHeaderClickMenu: false,
        enableHeaderContextMenu: false,
        enableRowContextMenu: false,
        toolbar:'#tb'
    });
    
    //自定义验证
    $.extend($.fn.validatebox.defaults.rules, {
    	//1、联系号码验证
		phoneRex: {
			validator : function(value) {
				var rex = /^1[3-8]+\d{9}$/;
				var rex2 = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
				if (rex.test(value) || rex2.test(value)) {
					return true;
				} else {
					return false;
				}

			},
			message : '请输入正确电话或手机格式'
		},
		//2、手机号码验证
		 mobile: {
             validator: function (value) {
                 return /^(13|15|18)\d{9}$/i.test(value);
             },
             message: '手机号码格式不正确'
         },
		//3、身份证号验证
		idcard: {
            validator: function (value) {
                return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
            },
            message: '身份证号码格式不正确'
        }
	});
});

/**
 * 日期格式化
 * @param value
 */
function formatDate(value) {
    return $.format.date(value, "yyyy-MM-dd HH:mm:ss");
}

function formatDateToYMD(value) {
    return $.format.date(value, "yyyy-MM-dd");
}