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
        <!--财物管理 头部-->
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a id="fpgl1" href="#">发票管理</a>
            <span>></span>
            <a href="#">添加发票</a>
        </div>
        <!--财物管理 头部 end-->
        <div class="col-xs-12" style="margin-top: 40px;">
            <div class="tab-pane" id="profile">
                <div class="row">
                    <div class="col-xs-6">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="firstname" class="col-xs-4 control-label">原密码</label>
                                <div class="col-xs-8">
                                    <input type="text" class="form-control" id="firstname">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastname" class="col-xs-4 control-label">新密码</label>
                                <div class="col-xs-8">
                                    <input type="text" class="form-control" id="lastname">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastname" class="col-xs-4 control-label">确认密码</label>
                                <div class="col-xs-8">
                                    <input type="text" class="form-control" id="lastname1">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-offset-4 col-xs-8">
                                    <button type="button" class="btn  btn-danger aq_qr_but">确认</button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>

    $('#fpgl1').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/fpgl.action')
    })
</script>
</html>