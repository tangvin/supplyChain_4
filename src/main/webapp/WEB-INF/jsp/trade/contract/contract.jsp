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
                            <option value="">请选择</option>
                            <option value="0">待领取</option>
                            <option value="1">正常</option>
                            <option value="2">已终止</option>
                            <option value="3">驳回</option>
                            <option value="4">历史</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>合同执行期</label>
                        <input class="form-control"  readonly="readonly"  id="creatTime" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})" placeholder="开始日期"/>至
                        <input  class="form-control"  readonly="readonly"  id="endTime" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'creatTime\')}'})" placeholder="结束日期"/>
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
                    <%--<div class="col-xs-2 xzht text-right">--%>
                        <%--<a id="xzht2" href="#" class="btn btn-primary btn-sm">新增合同</a>--%>
                    <%--</div>--%>
                </div>
            </div>
            <!--合同分页 eng-->
            <!--合同表格 开始-->
            <div class="table-responsive text-center">
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
                                <option value="">请选择</option>
                                <option value="0">待领取</option>
                                <option value="1">正常</option>
                                <option value="2">已终止</option>
                                <option value="3">驳回</option>
                                <option value="4">历史</option>
                            </select>
                        </td>
                        <td><a id="htbj" href="#">xxx合同</a></td>
                        <td><span>正常</span></td>
                        <td>1</td>
                        <td>采购企业名称</td>
                        <td>2017/09/02<br>2017/12/21</td>
                        <td>采方企业名称<br>2017-10-12 20:15:30</td>
                        <td>13</td>
                        <td>x</td>
                        <td>
                            <a id="htxq" href="#" class="btn btn-sm">查看</a>
                            <a id="htxq2" href="#" class="btn btn-primary btn-sm">驳回</a>
                            <a class="btn btn-primary btn-sm" data-toggle="modal" data-target=".bs-example-modal-sm">认领</a>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>
                            <select class="form-control">
                                <option value="">请选择</option>
                                <option value="0">待领取</option>
                                <option value="1">正常</option>
                                <option value="2">已终止</option>
                                <option value="3">驳回</option>
                                <option value="4">历史</option>
                            </select>
                        </td>
                        <td><a id="htbj" href="#">xxx合同</a></td>
                        <td><span>正常</span></td>
                        <td>1</td>
                        <td>采购企业名称</td>
                        <td>2017/09/02<br>2017/12/21</td>
                        <td>采方企业名称<br>2017-10-12 20:15:30</td>
                        <td>13</td>
                        <td>x</td>
                        <td>
                            <a id="htxq" href="#" class="btn btn-sm">查看</a>
                            <a id="htxq2" href="#" class="btn btn-primary btn-sm">驳回</a>
                            <a class="btn btn-primary btn-sm" data-toggle="modal" data-target=".bs-example-modal-sm">认领</a>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>
                            <select class="form-control">
                                <option value="">请选择</option>
                                <option value="0">待领取</option>
                                <option value="1">正常</option>
                                <option value="2">已终止</option>
                                <option value="3">驳回</option>
                                <option value="4">历史</option>
                            </select>
                        </td>
                        <td><a id="htbj" href="#">xxx合同</a></td>
                        <td><span>正常</span></td>
                        <td>1</td>
                        <td>采购企业名称</td>
                        <td>2017/09/02<br>2017/12/21</td>
                        <td>采方企业名称<br>2017-10-12 20:15:30</td>
                        <td>13</td>
                        <td>x</td>
                        <td>
                            <a id="htxq" href="#" class="btn btn-sm">查看</a>
                            <a id="htxq2" href="#" class="btn btn-primary btn-sm">驳回</a>
                            <a class="btn btn-primary btn-sm" data-toggle="modal" data-target=".bs-example-modal-sm">认领</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!--合同认领 模态框-->
            <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="panel-body">
                            12312312
                        </div>
                    </div>
                </div>
            </div>
            <!--合同认领 模态框-->
            <!--合同表格 结束-->
            
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
    $('#xzht2').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/xzht.action')
    });
    $('#htxq').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/htxq.action')
    });
    $('#htxq2').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/htxq.action')
    });
    $('#htbj').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/htbj.action')
    })
</script>
</html>

