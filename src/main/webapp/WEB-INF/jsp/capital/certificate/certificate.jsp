<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--Ukey与证书 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/captialMain/captialMain.action">系统首页</a>
            <span>></span>
            <a href="#">Ukey与证书</a>
        </div>
        <!--财物管理 头部 end-->
        <div class="col-xs-12">
            <!--合同签约 状态-->
            <div class="khh">
                <form class="form-inline khh_form khh_form1">
                    <div class="form-group">
                        <label>颁发人</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>状态</label>
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
                        <button type="button" class="btn btn-danger btn-default">申请颁发</button>
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
                        <td>类型</td>
                        <td>颁发人</td>
                        <td>颁发时间</td>
                        <td>状态</td>
                        <td>操作</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>--</td>
                        <td>平台名称</td>
                        <td>2017-12-28 19:20:39</td>
                        <td>正常</td>
                        <td>证书名一</td>
                    </tr>
                    <tr>
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
</script>
</html>