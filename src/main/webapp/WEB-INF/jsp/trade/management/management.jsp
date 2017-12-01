<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>授用信管理</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row row_zhxx'>
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/captialMain/captialMain.action">系统首页</a>
            <span>></span>
            <a href="#">授用信管理</a>
        </div>
        <!--bootstrap 授用信 切换 开始-->
        <div class="col-xs-12">
            <div class="row">
                <!--授用信导航 开始-->
                <ul class="nav nav-tabs col-xs-12" id="myTab">
                    <li class="active"><a href="#creditExtension">授信</a></li>
                    <li><a href="#WithTheLetter" >用信</a></li>
                </ul>
                <!--授用信导航 结束-->
                <!--授用信主体内容 开始-->
                <div class="row row_tab_con">
                    <div class="tab-content col-xs-12">
                        <div class="tab-pane active" id="creditExtension">
                            <!--授信编号 开始-->
                            <div class="khh">
                                <form class="form-inline khh_form khh_form1" id="crownForm">
                                    <div class="form-group form-group1">
                                        <label for="creditNumber">授信编号</label>
                                        <input type="text" class="form-control" id="creditNumber">
                                    </div>
                                    <div class="form-group form-group1">
                                        <label for="creditGrantor">授信方</label>
                                        <input type="email" class="form-control" id="creditGrantor">
                                    </div>
                                    <div class="form-group form-group1">
                                        <label for="creditStatus">状态</label>
                                        <select class="form-control select" id="creditStatus">
                                            <option value="">全部</option>
                                            <option value="0">已审核</option>
                                            <option value="1">待审核</option>
                                        </select>
                                    </div>
                                    <div class="form-group form-group1">
                                        <label for="creditApplicant">申请人</label>
                                        <input type="email" class="form-control" id="creditApplicant">
                                    </div>
                                    <button type="button" class="btn btn-danger btn-default" onclick="crownSearch()">查询</button>
                                    <button type="button" class="btn btn-danger btn-default" onclick="reset()">重置</button>
                                </form>
                            </div>
                            <!--测试 开始-->
                            <div class="panel-body" style="padding-bottom:0px;">
                                <table id="tb_departments" class="cj_table"></table>
                            </div>
                            <!--测试 结束-->
                        </div>
                        <div class="tab-pane" id="WithTheLetter">
                            <!--用信编号 开始-->
                            <div class="khh">
                                <form class="form-inline khh_form khh_form1" id="lefferForm">
                                    <div class="form-group form-group1">
                                        <label>用信编号</label>
                                        <input type="text" class="form-control" id="letterNumber">
                                    </div>
                                    <div class="form-group form-group1">
                                        <label>所属授信</label>
                                        <input type="text" class="form-control" id="belongCredit">
                                    </div>
                                    <div class="form-group form-group1">
                                        <label for="letterStatus">状态</label>
                                        <select class="form-control select" id="letterStatus">
                                            <option value="">全部</option>
                                            <option value="0">已审核</option>
                                            <option value="1">待审核</option>
                                        </select>
                                    </div>
                                    <div class="form-group form-group1">
                                        <label>申请人</label>
                                        <input type="text" class="form-control" id="applicant">
                                    </div>
                                    <button type="button" class="btn btn-danger btn-default" onclick="search()">查询</button>
                                    <button type="button" class="btn btn-danger btn-default" onclick="reset()">重置</button>
                                </form>
                            </div>
                            <!--用信编号 结束-->
                            <!--授信分页 开始-->
                            <div class="panel-body" style="padding-bottom:0px;">
                                <table id="letter" class="cj_table"></table>
                            </div>
                            <!--用信分页 结束-->
                        </div>
                    </div>
                </div>
                <!--授用信主体内容 结束-->
            </div>
        </div>
        <!--bootstrap 授用信 切换 开始-->
    </div>
</div>
</body>
<script>
    $('#myTab a:first').tab('show');
    $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    })
    //授信分页查询
    $(function(){
        $("#tb_departments").bootstrapTable({
            columns:[
                { //field: 'Number',//可不加
                    title: '序号',//标题  可不加
                    width:100,
                    formatter: function (value, row, index) {
                        return index+1;
                    }
                },
                {field:'creditNumber',title:'授信编号',width:100},
                {field:'creditAmount',title:'授信额（万元）',width:100},
                {field:'creditGrantor',title:'授信方',width:100},
                {field:'creditTime',title:'授信时间',width:100},
                {field:'creditStatus',title:'状态',width:100,
                    formatter: function(value,row,index){
                        if(value == '0') {
                            return "未生效";
                        } else if(value == '1') {
                            return "正常";
                        } else if(value == '2') {
                            return "已终止";
                        }else if(value == '3') {
                            return "历史";
                        }
                    }
                },
                {field:'creditMasterContract',title:'合同',width:100},
                {field:'applicant',title:'申请人',width:100},
                {field:'applicationTime',title:'申请时间',width:100},
                {field:'approvalTime',title:'批准时间',width:100},
                {
                    title:'操作',
                    field:'action',
                    width:25,
                    formatter:function(value , row){
                        var str = '';
                        if(row.letterStatus == 1){
                            str += '<button class="btn btn-danger bg_btn" href="#" value="查看" onclick="showUserAttach(\''+row.id+'\')">查看</button>';
//                            str += '<button class="btn btn-danger bg_btn" href="#" value="查看" onclick="showUserAttach(\''+row.id+'\')">查看</button>';
//                            str += '<button class="btn btn-danger bg_btn" href="#" value="查看" onclick="showUserAttach(\''+row.id+'\')">查看</button>';
                        }else{
                            str +='';
                        }
                        return str;
                    }
                }
            ],
            url:'<%=request.getContextPath()%>/credit/creditByPage.action',
            method:'post',
            queryParamsType:'',
            queryParams: queryParams,//传递参数（*）
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
    function queryParams (params) {
        var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageNumber: params.pageNumber,
            pageSize: params.pageSize,
            creditNumber:$("#creditNumber").val(),
            creditGrantor:$("#creditGrantor").val(),
            creditStatus:$("#creditStatus").val(),
            applicant:$("#creditApplicant").val()
        };
        return temp;
    }
    //授信搜索
    function crownSearch(){
        $("#tb_departments").bootstrapTable('refresh');
    }
    //授信重置查询
    function reset(){
        $("#crownForm").form('reset');
        crownSearch();
    }


    //用信分页查询
    $(function(){
        $("#letter").bootstrapTable({
            //隔行变色
//            striped:true,
            columns:[
                { //field: 'Number',//可不加
                    title: '序号',//标题  可不加
                    width:100,
                    formatter: function (value, row, index) {
                        return index+1;
                    }
                },
                {field:'letterNumber',title:'用信编号',width:100},
                {field:'letterCredit',title:'用信额（万元）',width:100},
                {field:'belongCredit',title:'所属授信',width:100},
                {field:'letterTime',title:'用信时间',width:100},
                {field:'letterStatus',title:'状态',width:100,
                    formatter: function(value,row,index){
                        if(value == '0') {
                            return "未生效";
                        } else if(value == '1') {
                            return "正常";
                        } else if(value == '2') {
                            return "已终止";
                        }else if(value == '3') {
                            return "历史";
                        }
                    }
                },
                {field:'letterContract',title:'合同',width:100},
                {field:'belongOrder',title:'订单',width:100},
                {field:'applicant',title:'申请人',width:100},
                {field:'applicationTime',title:'申请时间',width:100},
                {field:'approvalTime',title:'批准时间',width:100},
                {
                    title:'操作',
                    field:'action',
                    width:25,
                    formatter:function(value , row){
                        var str = '';
                        if(row.letterStatus == 1){
                            str += '<button class="btn btn-danger bg_btn" href="#" value="查看" onclick="showUserAttach(\''+row.id+'\')">查看</button>';
//                            str += '<button class="btn btn-danger bg_btn" href="#" value="查看" onclick="showUserAttach(\''+row.id+'\')">查看</button>';
//                            str += '<button class="btn btn-danger bg_btn" href="#" value="查看" onclick="showUserAttach(\''+row.id+'\')">查看</button>';
                        }else{
                            str +='';
                        }
                        return str;
                    }
                }
            ],
            url:'<%=request.getContextPath()%>/letter/queryByPage.action',
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
            letterNumber:$("#letterNumber").val(),
            belongCredit:$("#belongCredit").val(),
            letterStatus:$("#letterStatus").val(),
            applicant:$("#applicant").val()
        };
        return temp;
    }
    //搜索
    function search() {
        $("#letter").bootstrapTable('refresh');
    }
    //重置查询
    function reset(){
        $("#lefferForm").form('reset');
        search();
    }
</script>
</html>