<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .select{
            width: 160px !important;
            height:30px;
            font-size:12px;
        }
        .htbg tbody tr td{
            vertical-align: middle;
        }
        .pzfh tbody tr td{
            border:none;
        }
        .fpgl{
            margin-right:0;
        }
    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--财物管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
            <span>></span>
            <a href="#">发票管理</a>
        </div>
        <!--财物管理 头部 end-->
        <div class="col-xs-12">
            <!--合同签约 状态-->
            <div class="khh" style="margin-top: 10px;">
                <form class="form-inline khh_form khh_form1" style="margin-left:-15px;">
                    <div class="form-group">
                        <label>发票编号</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>开票人</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>创建时间</label>
                        <input type="text" class="form-control">
                    </div>
                    <button type="button" class="btn btn-danger btn-default">查询</button>
                    <button type="button" class="btn btn-danger btn-default">重置</button>
                </form>
            </div>
            <!--合同签约 状态-->
            <!--合同分页 start-->
            <div class="fy">
                <div class="row fy_row">
                    <div class="col-xs-4">
                        <p class="fy_con">共计3条数据，共1页</p>
                    </div>
                    <div class="col-xs-6">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">首页</span>
                                    </a>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li>
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">末页</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-xs-2 text-right sqbf_btn">
                        <a  href="#"><button type="button" class="btn btn-danger btn-default" id="tjfp">添加发票</button></a>
                    </div>
                </div>
            </div>
            <!--合同分页 eng-->
            <!--合同表格 开始-->
            <div class="table-responsive text-center">
                <table class="table table-bordered text-center htbg fpgl">
                    <tbody>
                    <tr class="active">
                        <td>序号</td>
                        <td>发票编号</td>
                        <td>发票号</td>
                        <td>开票人</td>
                        <td>所属订单</td>
                        <td>创建时间</td>
                        <td>操作</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>727792893232</td>
                        <td>342342354325</td>
                        <td>张光云</td>
                        <td>12312314</td>
                        <td>2017-12-28 19:20:39</td>
                        <td>
                            <div class="row" style="margin-right:0;">
                                <div class="col-xs-6 col-xs-offset-1">
                                    <img src="<%=request.getContextPath()%>/js/static/images/invoice.png">
                                </div>
                                <div class="col-xs-4">
                                    <button type="button" class="btn btn-danger btn-default bj_btn">编辑</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                    </tr>
                    <tr>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                        <td>Table cell</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!--合同表格 结束-->
            <!--合同分页 start-->
            <div class="fy">
                <div class="row fy_row">
                    <div class="col-xs-4">
                        <p class="fy_con">共计3条数据，共1页</p>
                    </div>
                    <div class="col-xs-8">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">首页</span>
                                    </a>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li>
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">末页</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!--合同分页 eng-->
        </div>
    </div>
</div>
</body>
<script>
    //    $('#tjfp').click(function(){
    //        $('#load').load('tjfp.html')
    //    })
    $('#tjfp').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/tjfp.action')
    })
</script>
</html>