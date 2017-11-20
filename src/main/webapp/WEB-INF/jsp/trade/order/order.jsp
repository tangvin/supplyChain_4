<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--订单管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a href="#">订单管理</a>
        </div>
        <!--订单管理 头部 end-->
        <div class="col-xs-12">
            <!--合同签约 状态-->
            <div class="khh">
                <form class="form-inline khh_form khh_form1">
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
                        <label>开户行</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-group form-group1">
                        <label>合同执行期</label>
                        <input type="text" readonly="readonly"  name="birthday" id="birthday1" class="form-control" value="03/18/2013" />--
                        <input type="text" readonly="readonly"  name="birthday" id="birthday" class="form-control" value="03/18/2013" />
                    </div>
                    <div class="form-group">
                        <label>签约方</label>
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
            <!--合同表格 开始-->
            <div class="table-responsive text-center">
                <table class="table table-bordered text-center htbg">
                    <tbody>
                    <tr class="active">
                        <td>序号</td>
                        <td>订单编号</td>
                        <td>订单状态</td>
                        <td>订单金额<br>￥万元</td>
                        <td>订单相关事件</td>
                        <td>订单创建</td>
                        <td>合同</td>
                        <td>用信情况</td>
                        <td>发票</td>
                        <td>货运及单号</td>
                        <td>操作</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>727792893232</td>
                        <td>待确认</td>
                        <td>200</td>
                        <td>2017/09/02<br>2017/12/21</td>
                        <td>采方企业名称<br>2017-10-12 20:15:30</td>
                        <td>合同一</td>
                        <td>--</td>
                        <td>--</td>
                        <td>--</td>
                        <td>
                            <a target="_blank" class="btn btn-sm">查看</a>
                            <a target="_blank" class="btn btn-primary btn-sm" data-toggle="modal" data-target=".bs-example-modal-sm">领取订单</a>
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
                        <td>
                            <a target="_blank" class="btn btn-sm">查看</a>
                            <a target="_blank" class="btn btn-warning btn-sm" data-toggle="modal" data-target=".bs-example-modal-pzfh">配置发货</a>
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
                    </tbody>
                </table>
            </div>
            <!--领取订单 模态框-->
            <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="panel-body text-center">
                            确定领取订单吗？
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--领取订单 模态框-->
            <!--配置发货 模态框-->
            <div class="modal fade bs-example-modal-pzfh" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">配置发货</h4>
                        </div>
                        <div class="modal-body">
                            <div class="table-responsive">
                                <table class="table htbg pzfh">
                                    <tbody>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3">订单编号：</td>
                                            <td class="col-xs-9">123123123123</td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3">订单金额：</td>
                                            <td class="col-xs-9">￥200万元</td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3"><span class="xingxing">*</span>货运单位：</td>
                                            <td class="col-xs-8">
                                                <div class="row pzfh_row">
                                                    <div class="col-xs-5 pzfh_row_div">
                                                        <select class="form-control">
                                                            <option>123123123</option>
                                                            <option>全部1</option>
                                                            <option>全部2</option>
                                                            <option>全部3</option>
                                                            <option>全部4</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <button type="button" class="btn btn-danger btn-default">管理货运单位</button>
                                                    </div>
                                                </div>
                                            </td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="row">
                                            <td class="col-xs-3">订单金额:</td>
                                            <td class="col-xs-8">
                                                <div class="row row_ddje">
                                                    <div class="col-xs-5 row_ddje_div">
                                                        <input type="text" class="form-control">
                                                    </div>
                                                    <div class="col-xs-6 row_ddje_con">
                                                        暂未查询到货运单位，请检查
                                                    </div>
                                                </div>
                                            </td>
                                        </div>
                                    </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
                            <button type="button" class="btn btn-primary">取消</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!--配置发货 模态框-->
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
</script>
</html>