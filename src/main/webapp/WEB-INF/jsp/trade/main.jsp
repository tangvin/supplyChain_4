<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/include.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>贸易商</title>
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
                        中精众和投资管理有限公司
                    </li>
                    <li>
                        <div class="dropdown">
                            <p class="dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
                                Dropdown
                                <span class="caret"></span>
                            </p>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li class='text-center' id="ones"><a href="#">资料维护</a></li>
                                <li class='text-center'><a href="#">退出登录</a></li>
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
                <li class="panel" id="xtsys">
                    <a href="javascript:void(0)">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_contract_selected@1x.png'>
                        <span class="menu-text">系统首页</span>
                    </a>
                </li>
                <li class="panel" id="syxgls">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_credit_selected@1x.png'>
                        <span class="menu-text">授用信管理</span>
                    </a>
                </li>
                <li class="panel" id="htqy">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_contract_selected@1x.png'>
                        <span class="menu-text">合同签约</span>
                    </a>
                </li>
                <li class="panel">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_order_selected@1x.png'>
                        <span class="menu-text">订单管理</span>
                    </a>
                </li>
                <li class="panel">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_finance_selected@1x.png'>
                        <span class="menu-text">财务管理</span>
                    </a>
                </li>
                <li class="panel">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_invoice_selected@1x.png'>
                        <span class="menu-text">发票管理</span>
                    </a>
                </li>
                <li class="panel">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_ukey_selected@1x.png'>
                        <span class="menu-text">Ukey与证书</span>
                    </a>
                </li>
                <li class="panel">
                    <a href="#">
                        <img class='img_con' src='<%=request.getContextPath()%>/js/static/images/leftbar_home_selected@1x.png'>
                        <span class="menu-text">我的设置</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <!--列表 左侧导航 结束-->
    <!--列表 右侧内容 开始-->
    <div class="index_right" id="load">
        <div class='row row_xtsy_zjzh'>
            <!-- 中精众和投资管理有限公司 开始 -->
            <div class='col-xs-12' style="padding-right: 0px;">
                <div class='row zjzh_wrap'>
                    <div class='panel-body'>
                        <div class='col-xs-6'>
                            <ul class="nav zjzh_title">
                                <li class='col-xs-8'>
                                    <h3>中精众和投资管理有限公司</h3>
                                </li>
                                <li class='col-xs-1'>
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
                                        <li>地址：北京市海淀区中关村大街12号盘古大厦五层</li>
                                        <li>固定电话：010-88668800-888</li>
                                        <li>管理员姓名：王梦海</li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                        <div class='col-xs-6 text-right'>
                            <div class='zjzh_button'>
                                <button type="button" class="btn btn1 btn-danger">登录账号安全</button>
                                <button type="button" class="btn  btn-danger">基础资料</button>
                                <button type="button" class="btn  btn-danger btnn">资金帐户</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 中精众和投资管理有限公司 结束 -->
            <!-- 中精众和投资管理有限公司 可视化图 -->

            <div class='col-xs-12 index_ksh'>
                <div class='row'>
                    <!-- 圆 开始 -->
                    <div class='col-xs-6 ksh_con'>
                        <h5 class='ksh_con_h5'>授信情况</h5>
                        <div class='yuan'>
                            <h4 class="text-center" style="margin-top: 40px;">可用总额</h4>
                            <h4 class="text-center">6,000,000,00</h4>
                            <div class='yuan_div row'>
                                <div class='col-xs-6 ed_p ed_p1'>
                                    <p class="text-center">已使用</p>
                                    <p class="text-center">2,000,000,00</p>
                                </div>
                                <div class='col-xs-6 ed_p  ed_p2'>
                                    <p class="text-center">已使用</p>
                                    <p class="text-center">2,000,000,00</p>
                                </div>
                            </div>
                            <h5 class="text-center">消费总额：2,000,000,000,00</h5>
                        </div>
                        <div class='yuan_button text-center'>
                            <button type="button" class="btn  btn-danger">登录账号安全</button>
                            <button type="button" class="btn  btn-danger">基础资料</button>
                            <button type="button" class="btn  btn-danger btnn">资金帐户</button>
                        </div>
                    </div>
                    <!-- 圆 结束 -->
                    <!-- 上传发票 开始  -->
                    <div class='col-xs-6' style="border-left:10px solid #ffffff">
                        <div class="row row_yuan">
                            <div class='col-xs-12 rzqk'>
                                <h5>融资情况</h5>
                                <ul class='nav ye_list'>
                                    <li class='navbar-text'>最近一笔融资：<span>2017/12/31</span></li>
                                    <li class='navbar-text'>余额：<span>8000,000.001</span></li>
                                    <li class='navbar-text'>
                                        <button type="button" class="btn btn-danger scfp_btn">上传发票</button>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <div class="row ">
                            <div class='col-xs-12 rzqk'>
                                <h5>融资情况</h5>
                                <ul class='nav ye_list'>
                                    <li class='navbar-text'>最近一笔融资：<span>2017/12/31</span></li>
                                    <li class='navbar-text'>余额：<span>8000,000.001</span></li>
                                    <p class='navbar-text'>逾期：无</p>
                                </ul>

                            </div>
                        </div>
                    </div>
                    <!-- 上传发票 结束  -->
                </div>
            </div>
            <!-- 中精众和投资管理有限公司 可视化图 -->
        </div>
    </div>
    <!--列表 右侧内容 结束-->
</div>
</body>
</html>