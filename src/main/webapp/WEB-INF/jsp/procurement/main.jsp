<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/include.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>采购方首页</title>
</head>
<body>
<!--top 开始-->
<div class="top">
    <div class="navbar navbar-default">
        <div class='row row_top'>
            <div class='col-xs-7'>
                <ul class="nav navbar-nav navbar-left">
                    <li>
                        <a class="navbar-brand"><img src="<%=request.getContextPath()%>/js/static/images/logo@1x.png" alt="Brand" class='img-responsive' /></a>
                    </li>
                </ul>
            </div>
            <div class='col-xs-5'>
                <ul class="nav navbar-nav navbar-right">
                    <li class="navbar-text">
                        <img src="<%=request.getContextPath()%>/js/static/images/message1@1x.png" />
                    </li>
                    <li class="navbar-text">
                        ${information.entName}
                    </li>
                    <li>
                        <div class="dropdown">
                            <p class="dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
                               ${account.userName}
                                <span class="caret"></span>
                            </p>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li class='text-center' id="one"><a href="#">资料维护</a></li>
                                <li class='text-center'><a href="<%=request.getContextPath()%>/account/exitAccount.action">退出登录</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--top 结束-->
<div class="con">
    <!--列表 左侧导航 开始-->
    <div class="index_left">
        <div class="page-sidebar">
            <ul class="nav panel-group sidebar-menu">
                <li class="panel" id="xtsy">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_home_selected@1x.png'>
                        <span class="menu-text">系统首页</span>
                    </a>
                </li>
                <li class="panel" >
                    <a href="#" id="htqy">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_contract_selected@1x.png'>
                        <span class="menu-text">合同签约</span>
                    </a>
                </li>
                <li class="panel" id="ddgl">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_order_selected@1x.png'>
                        <span class="menu-text">订单管理</span>
                    </a>
                </li>
                <li class="panel" id="syxgl">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_credit_selected@1x.png'>
                        <span class="menu-text">授用信管理</span>
                    </a>
                </li>
                <li class="panel" id="cwgl">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_finance_selected@1x.png'>
                        <span class="menu-text">财务管理</span>
                    </a>
                </li>
                <li class="panel" id="fpgl">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_invoice_selected@1x.png'>
                        <span class="menu-text">发票管理</span>
                    </a>
                </li>
                <li class="panel" id="ukeyZs">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_ukey_selected@1x.png'>
                        <span class="menu-text">Ukey与证书</span>
                    </a>
                </li>
                <li class="panel" id="setting">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_setting_selected@1x.png'>
                        <span class="menu-text">我的设置</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <!--列表 左侧导航 结束-->
    <!--列表 右侧内容 开始-->
    <div class="index_right" id="load">
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
    </div>
    <!--列表 右侧内容 结束-->
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
    $('#xtsy').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/xtsy.action')
    })
</script>
</body>
</html>