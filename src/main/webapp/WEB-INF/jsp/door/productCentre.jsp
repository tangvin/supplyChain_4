<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/static/css/css.css">
</head>
<body>
<div class="home_wrap">
    <!--top 开始-->
    <div class="home_top">
        <div class="home_width clearfix">
            <!--头部左边 logo 开始-->
            <div class="home_top-left">
                <div class="hone_top_logo">
                    <img src="<%=request.getContextPath()%>/js/static/images/images1/logo-topbar.png">
                </div>
            </div>
            <!--头部左边 logo 结束-->
            <!--头部中间 导航 开始-->
            <div class="home_top_center">
                <ul class="home_top_nav clearfix">
                    <li><a href="<%=request.getContextPath()%>/captialMain/homeDoor.action">首页</a></li>
                    <li><a href="<%=request.getContextPath()%>/captialMain/productCentre.action">产品中心</a></li>
                    <li><a href="<%=request.getContextPath()%>/captialMain/solution.action">解决方案</a></li>
                    <li><a href="<%=request.getContextPath()%>/captialMain/partner.action">合作伙伴</a></li>
                    <li><a href="<%=request.getContextPath()%>/captialMain/about.action">关于我们</a></li>
                </ul>
            </div>
            <!--头部中间 导航 结束-->
            <!--头部右边 登录注册 开始-->
            <div class="home_top_right">
                <div class="home_login clearfix">
                    <a href="<%=request.getContextPath()%>/captialMain/login.action">登录</a>
                    <a href="<%=request.getContextPath()%>/captialMain/register.action">免费注册</a>
                </div>
            </div>
            <!--头部右边 登录注册 结束-->
        </div>
    </div>
    <!--top 结束-->
    <!--banner 开始-->
    <div class="home_banner cpzx_banner"></div>
    <!--banner 结束-->

    <div class="cpzx_main">
        <div class="home_width">
            <p class="home_main_title clearfix">
                <span class="home_xian"></span>
                <span class="home_cpzx">产品中心</span>
                <span class="home_xian"></span>
            </p>
            <div class="cpzx_xtjs">
                <p>系统介绍</p>
                <span>企业凭信用良好的交易订单，金融机构为其经营提供融资。</span>
                <span>主要适用于需通过资金融通满足优质订单生产需求，且具有较强资信实力和生产能力的客户。</span>
                <span>订单阶段性融资又可分为：订单融资阶段和交货后融资阶段。</span>
                <div class="xtsy_div"></div>
            </div>

            <div class="cpzx_xtjs">
                <p>业务流程</p>
                <div class="xtsy_div"></div>
            </div>

            <div class="cpzx_xtjs">
                <p>系统使用</p>
                <div class="xtsy_div"></div>
            </div>

        </div>
    </div>

    <!--home 底部 开始-->
    <div class="home_footer">
        <div class="home_footer_top">
            <div class="home_width clearfix">
                <img src="<%=request.getContextPath()%>/js/static/images/images1/logo_footer.png">
                <div class="home_footer_lxdh">
                    <p class="home_footer_fwrx">服务热线</p>
                    <p class="home_footer_fwrxdh">400-888-6660</p>
                </div>
                <ul class="home_footer_lxwm">
                    <li><a href="#">联系我们 </a></li>
                    <li class="wyb"><a href="#">公司地址：北京市朝阳区朝阳北路1008号</a></li>
                    <li class="wyb"><a href="#">业务邮箱：service@cnfinatech.com</a></li>
                    <li class="wyb"><a href="#">业务咨询：010-88660066</a></li>
                </ul>
            </div>
        </div>
        <div class="home_footer_bottom">
            <p>copyright © 2017 版权所有 All Rights Reseved.</p>
            <p>京ICP备17069390号-1</p>
        </div>

    </div>
    <!--home 底部 结束-->
</div>
</body>
</html>