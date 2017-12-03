<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta HTTP-EQUIV="Pragma" content="no-cache">
    <meta HTTP-EQUIV="Expires" content="-1">
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
            <div class="text-right cg_xzht">
                <button class="btn btn-primary" id="xzht2">新增合同</button>
            </div>
            <!--合同分页 eng-->
            <!--合同表格 开始-->
            <div class="table-responsive text-center">
                <table class="table table-bordered text-center htbg" id="tb">
                        <thead>
                            <tr id="bt" class="active">
                                <td>序号</td>
                                <td>id</td>
                                <td>用户名</td>
                                <td>权限</td>
                                <td>操作</td>
                            </tr>
                        </thead>
                </table>
            </div>
            <!--申请融信 模态框-->
            <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="panel-body">
                            <div class="panel-body text-center">
                                <form class="form-inline khh_form">
                                    <div class="form-group">
                                        <label>申请融信:</label>
                                        <input style="width: 100px;" type="text" class="form-control">  ￥万元
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--申请融信 模态框-->
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
</html>


