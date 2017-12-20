<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑合同</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <!--合同签约 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
            <span>></span>
            <a id="htqy2" href="#">合同签约</a>
            <span>></span>
            <a href="#">合同编辑</a>
        </div>
        <!--合同签约 头部 end-->
        <div class="col-xs-12">
            <div class="row">
                <div class="panel-body htbh">
                    <p class="col-xs-3">合同编号<span class="htxx">12312312312</span></p>
                    <p class="col-xs-3">合同名称<span class="htxx">xxx合同</span></p>
                </div>
            </div>
            <!--合同编辑表格 start-->
            <div class="table-responsive text-center" style="margin: 0 -15px">
                <table class="table table-bordered bj_table">
                    <tbody>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同编号：</td>
                            <td class="col-xs-9 text-left">12312312312312</td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同名称：</td>
                            <td class="col-xs-9 text-left"><input type="text"></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>签约方：</td>
                            <td class="col-xs-9 text-left">供应商企业名称：</td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同执行期：</td>
                            <td class="col-xs-9 text-left clezrfix htbj_zxq">
                                <input type="text" readonly="readonly"  name="birthday" id="birthday1" class="form-control" value="03/18/2013" />
                                <p>--</p>
                                <input type="text" readonly="readonly"  name="birthday" id="birthday" class="form-control" value="03/18/2013" />
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同状态：</td>
                            <td class="col-xs-9 text-left">
                                <span>正常</span>
                                <button type="button" class="btn btn-danger">终止合同</button>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>申请融信：</td>
                            <td class="col-xs-9 text-left">
                                <form class="form-inline">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" id="id"> 是
                                        </label>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="id1" disabled>￥万元
                                    </div>
                                </form>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>合同扫描件第一页：</td>
                            <td class="col-xs-9 text-left">
                                <input id="file-Portrait1" type="file">
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>驳回记录：</td>
                            <td class="col-xs-9 text-left">2</td>
                        </div>
                    </tr>
                    <tr class="warning">
                        <div class="row">
                            <td class="col-xs-3 text-right"><span class="xingxing">*</span>驳回原因：</td>
                            <td class="col-xs-9 text-left">原因一原因二</td>
                        </div>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!--合同编辑表格 end-->
            <div class="row">
                <button type="button" class="btn  btn-danger col-xs-offset-4" data-toggle="modal" data-target=".bs-example-modal-tj">提交</button>
                <div class="modal fade bs-example-modal-tj" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                    <div class="modal-dialog modal-sm" role="document">
                        <div class="modal-content">
                            <div class="panel-body text-center">
                                一但编辑，合同需要再次领取
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
<script>


    $('#id').click(function(){
        if($('#id').is(':checked')){
            $('#id1').removeAttr("disabled");
        }else{
            $('#id1').attr("disabled","disabled");
        }
    })
    $('#htqy2').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/htqy.action')
    })

</script>
</html>