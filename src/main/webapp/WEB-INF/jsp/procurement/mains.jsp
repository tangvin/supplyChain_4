<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link type="image/x-icon" rel="icon" href="<%=request.getContextPath()%>/js/static/images/favicon.ico" />
    <link type="image/x-icon" rel="shortcut icon" href="<%=request.getContextPath()%>/js/static/images/favicon.ico" />
    <meta charset="UTF-8">
    <title>采购方首页</title>
</head>
<body>
<!-- 右边的主题内容 col-xs-10 开始 -->
<div class='row row_xtsy_zjzh'>
    <!-- 中精众和投资管理有限公司 开始 -->
    <div class='col-xs-12 row_xtsy_zjzh_div'>
        <div class='row zjzh_wrap'>
            <div class='panel-body'>
                <ul class="nav zjzh_title">
                    <li>
                        <h3>${information.entName}</h3>
                    </li>
                    <c:if test="${information.certificationStatus == 0}">
                        <a href="#" id="zlrz"><li class='yrzs zjzh_logo_sm'>待认证</li></a>
                    </c:if>
                    <c:if test="${information.certificationStatus == 1}">
                        <li class='zjzh_logo_sm'>
                            <img src='<%=request.getContextPath()%>/js/static/images/identify1@1x.png'>
                        </li>
                        <li class='yrz'>已认证</li>
                    </c:if>
                </ul>
                <div class='col-xs-6'>
                    <div class='row'>
                        <div class='col-xs-4'>
                            <div class='zjzh_logo'>
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
                        <a id="zijin" href="#"><button type="button" class="btn  btn-danger btnn">资金帐户</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 中精众和投资管理有限公司 结束 -->

</div>
<script>
    $('#zhanghu').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/messages.action')
    })
    $('#ziliao').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/ziliao.action')
    })
    $('#zijin').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/zijin.action')
    })
    $('#zlrz').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/zlrz.action')
    })
</script>
</body>
</html>