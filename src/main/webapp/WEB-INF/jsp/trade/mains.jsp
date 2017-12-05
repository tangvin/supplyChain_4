<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>贸易方首页</title>
</head>
<body>
<!-- 右边的主题内容 col-xs-10 开始 -->
        <div class='row row_xtsy_zjzh'>
            <!-- 中精众和投资管理有限公司 开始 -->
            <div class='col-xs-12 row_xtsy_zjzh_div'>
                <div class='row zjzh_wrap'>
                    <div class='panel-body'>
                        <div class='col-xs-6'>
                            <ul class="nav zjzh_title">
                                <li class='col-xs-8'>
                                    <h3>${information.entName}</h3>
                                </li>
                                <li class='col-xs-1 zjzh_logo_sm'>
                                    <img src='<%=request.getContextPath()%>/js/static/images/identify1@1x.png'>
                                </li>
                                <li class='col-xs-3 yrz'>|<span>已认证</span>|</li>
                            </ul>

                            <div class='row'>
                                <div class='col-xs-4'>
                                    <div class='zjzh_logo'>
                                        <%--${information.entLogo}--%>
                                        <img src='<%=request.getContextPath()%>/js/static/images/CompanyLogo@1x.png' class='center-block img-responsive img-circle'>
                                    </div>
                                </div>

                                <div class='col-xs-8'>
                                    <ul class='nav zjzh_list'>
                                        <li>企业信用评级:</li>
                                        <li>地址：${information.municipality}${information.city}${information.county}${information.address}</li>
                                        <li>固定电话：${information.telephone}</li>
                                        <li>管理员姓名：${information.businessContact}</li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                        <div class='col-xs-6 text-right'>
                            <div class='zjzh_button'>
                                <a id="zhanghu" href="#"><button type="button" class="btn btn1 btn-danger">账号安全</button></a>
                                <a id="ziliao" href="#"><button type="button" class="btn  btn-danger">基础资料</button></a>
                                <a id="zijin" href="#"><button type="button" class="btn  btn-danger btnn">资金帐户</button></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 中精众和投资管理有限公司 结束 -->
</div>
<script>
    $('#zhanghu').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/messages.action')
    })
    $('#ziliao').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/ziliao.action')
    })
    $('#zijin').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/zijin.action')
    })
</script>

</body>
</html>