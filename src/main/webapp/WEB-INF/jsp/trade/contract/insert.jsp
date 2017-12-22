<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>合同签约</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--合同签约 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a id="htqy3" href="#">合同签约</a>
            <span>></span>
            <a href="#">新增合同</a>
        </div>
        <!--合同签约 头部 end-->
        <div class="col-xs-12">
            <!--合同签约 状态-->
            <div class="khh">
                <form class="form-inline khh_form">
                    <div class="form-group">
                        <label>状态：</label>
                        <select class="form-control select">
                            <option value="">请选择</option>
                            <option value="0">待领取</option>
                            <option value="1">正常</option>
                            <option value="2">已终止</option>
                            <option value="3">驳回</option>
                            <option value="4">历史</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>合同执行期：</label>
                        <input type="text" readonly="readonly" name="birthday" id="birthday1" class="form-control" value="03/18/2013" />--
                        <input type="text" readonly="readonly" name="birthday" id="birthday" class="form-control" value="03/18/2013" />
                    </div>
                    <div class="form-group">
                        <label>签约方：</label>
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
                </div>
            </div>
            <!--合同分页 eng-->
            <!--合同表格 开始-->
            <div class="table-responsive text-center" style="margin:0 -15px">
                <table class="table table-bordered text-center htbg">
                    <tbody>
                    <tr class="active">
                        <td>序号</td>
                        <td>合同编号</td>
                        <td>合同名称</td>
                        <td>合同状态</td>
                        <td>辅合同</td>
                        <td>签约方</td>
                        <td>合同执行期</td>
                        <td>共同创建</td>
                        <td>合同扫描件</td>
                        <td>融信申请</td>
                        <td>操作</td>

                    </tr>
                    <tr>
                        <td>1</td>
                        <td>
                            <select class="form-control">
                                <option>123123123</option>
                                <option>全部1</option>
                                <option>全部2</option>
                                <option>全部3</option>
                                <option>全部4</option>
                            </select>
                        </td>
                        <td><a id="htbj3" href="#">xxx合同</a></td>
                        <td><span>正常</span></td>
                        <td>1</td>
                        <td>采购企业名称</td>
                        <td>2017/09/02<br>2017/12/21</td>
                        <td>采方企业名称<br>2017-10-12 20:15:30</td>
                        <td>13</td>
                        <td>x</td>
                        <td>
                            <a id="htbj2" href="#" class="btn btn-sm">编辑</a>
                            <a id="htbj" href="#" class="btn btn-primary btn-sm">新增</a>
                            <a class="btn btn-primary btn-sm" data-toggle="modal" data-target=".bs-example-modal-sm">申请融信</a>
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
    $('#birthday').daterangepicker({ singleDatePicker: true }, function(start, end, label) {
        console.log(start.toISOString(), end.toISOString(), label);
    });
    $('#birthday1').daterangepicker({ singleDatePicker: true }, function(start, end, label) {
        console.log(start.toISOString(), end.toISOString(), label);
    });

    $('#htbj').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/htbj.action')
    })
    $('#htbj2').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/htbj.action')
    })
    $('#htbj3').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/htbj.action')
    })
    $('#htqy3').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/htqy.action')
    })
</script>
</html>

