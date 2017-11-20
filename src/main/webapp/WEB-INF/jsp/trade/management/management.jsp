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
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a href="#">授用信管理</a>
        </div>
        <!--bootstrap 授用信 切换 开始-->
        <div class="col-xs-12">
            <div class="row">
                <!--授用信导航 开始-->
                <ul class="nav nav-tabs col-xs-12" id="myTab">
                    <li class="active"><a href="#creditExtension">授信</a></li>
                    <li><a href="#WithTheLetter">用信</a></li>
                </ul>
                <!--授用信导航 结束-->
                <!--授用信主体内容 开始-->
                <div class="row row_tab_con">
                    <div class="tab-content col-xs-12">
                        <div class="tab-pane active" id="creditExtension">
                            <!--授信编号 开始-->
                            <div class="khh">
                                <form class="form-inline khh_form khh_form1">
                                    <div class="form-group form-group1">
                                        <label for="exampleInputName2">授信编号</label>
                                        <input type="text" class="form-control" id="exampleInputName2">
                                    </div>
                                    <div class="form-group form-group1">
                                        <label for="exampleInputEmail2">授信方</label>
                                        <input type="email" class="form-control" id="exampleInputEmail2">
                                    </div>
                                    <div class="form-group form-group1">
                                        <label for="exampleInputEmail2">状态</label>
                                        <select class="form-control select">
                                            <option>全部</option>
                                            <option>全部1</option>
                                            <option>全部2</option>
                                            <option>全部3</option>
                                            <option>全部4</option>
                                        </select>
                                    </div>
                                    <div class="form-group form-group1">
                                        <label for="exampleInputEmail2">申请人</label>
                                        <input type="email" class="form-control" id="exampleInputEmail4">
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-default">查询</button>
                                    <button type="submit" class="btn  btn-danger btn-default">重置</button>
                                </form>
                            </div>
                            <!--授信编号 结束-->
                            <!--授信分页 开始-->
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
                            <!--授信分页 结束-->
                            <!--授信表格 开始-->
                            <div class="table-responsive text-center">
                                <table class="table table-bordered text-center">
                                    <tbody>
                                    <tr class="active">
                                        <td>序号</td>
                                        <td>授信编号</td>
                                        <td>授信额（万元）</td>
                                        <td>授信方</td>
                                        <td>授信时间</td>
                                        <td>状态</td>
                                        <td>合同</td>
                                        <td>申请人</td>
                                        <td>申请时间</td>
                                        <td>批准时间</td>
                                        <td>操作</td>

                                    </tr>
                                    <tr>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
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
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!--授信表格 结束-->
                        </div>
                        <div class="tab-pane" id="WithTheLetter">
                            <!--用信编号 开始-->
                            <div class="khh">
                                <form class="form-inline khh_form khh_form1">
                                    <div class="form-group form-group1">
                                        <label>用新编号</label>
                                        <input type="text" class="form-control">
                                    </div>
                                    <div class="form-group form-group1">
                                        <label>所属授信</label>
                                        <input type="email" class="form-control">
                                    </div>
                                    <div class="form-group form-group1">
                                        <label for="exampleInputEmail2">状态</label>
                                        <select class="form-control select">
                                            <option>全部</option>
                                            <option>全部1</option>
                                            <option>全部2</option>
                                            <option>全部3</option>
                                            <option>全部4</option>
                                        </select>
                                    </div>
                                    <div class="form-group form-group1">
                                        <label>申请人</label>
                                        <input type="email" class="form-control">
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-default">查询</button>
                                    <button type="submit" class="btn btn-danger btn-default">重置</button>
                                </form>
                            </div>
                            <!--用信编号 结束-->
                            <!--授信分页 开始-->
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
                            <!--用信分页 结束-->
                            <!--用信表格 开始-->
                            <div class="table-responsive text-center">
                                <table class="table table-bordered text-center">
                                    <tbody>
                                    <tr class="active">
                                        <td>序号</td>
                                        <td>授信编号</td>
                                        <td>授信额（万元）</td>
                                        <td>授信方</td>
                                        <td>授信时间</td>
                                        <td>状态</td>
                                        <td>合同</td>
                                        <td>申请人</td>
                                        <td>申请时间</td>
                                        <td>批准时间</td>
                                        <td>操作</td>

                                    </tr>
                                    <tr>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
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
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!--用信表格 结束-->
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

</script>
</html>