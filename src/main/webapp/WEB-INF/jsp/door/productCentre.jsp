<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link type="image/x-icon" rel="icon" href="<%=request.getContextPath()%>/js/static/images/favicon.ico" />
    <link type="image/x-icon" rel="shortcut icon" href="<%=request.getContextPath()%>/js/static/images/favicon.ico" />
    <meta charset="UTF-8">
    <title>产品中心 - 飞迅金服</title>
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
                    <a href="<%=request.getContextPath()%>/"><img src="<%=request.getContextPath()%>/js/static/images/images1/logo-topbar.png"></a>
                </div>
            </div>
            <!--头部左边 logo 结束-->
            <!--头部中间 导航 开始-->
            <div class="home_top_center">
                <ul class="home_top_nav clearfix">
                    <li><a href="<%=request.getContextPath()%>/">首页</a></li>
                    <li><a href="<%=request.getContextPath()%>/productCentre.action" class="home_top_nav_class">产品中心</a></li>
                    <li><a href="<%=request.getContextPath()%>/solution.action">解决方案</a></li>
                    <li><a href="<%=request.getContextPath()%>/partner.action">合作伙伴</a></li>
                    <li><a href="<%=request.getContextPath()%>/about.action">关于我们</a></li>
                </ul>
            </div>
            <!--头部中间 导航 结束-->
            <!--头部右边 登录注册 开始-->
            <div class="home_top_right">
                <div class="home_login clearfix">
                    <a href="<%=request.getContextPath()%>/login.action">登录</a>
                    <a href="<%=request.getContextPath()%>/register.action">免费注册</a>
                </div>
            </div>
            <!--头部右边 登录注册 结束-->
        </div>
    </div>
    <!--top 结束-->
    <!--banner 开始-->
    <div class="home_banner cpzx_banner">
        <div class="home_width">
            <img src="<%=request.getContextPath()%>/js/static/images/images1/banner_23.png">
        </div>
        <div id="rightArrow">
            咨询热线：400 - 888 - 6660
        </div>
    </div>
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
                <div class="xtsy_div">
                    <img src="<%=request.getContextPath()%>/js/static/images/images1/product-ico-1.png">
                </div>
            </div>

            <div class="cpzx_xtjs">
                <p>业务流程</p>
                <div class="xtsy_div">
                    <img src="<%=request.getContextPath()%>/js/static/images/images1/product-ico-2.png">
                </div>
            </div>

            <div class="cpzx_xtjs">
                <p>系统使用</p>
                <div class="xtsy_div">
                    <img src="<%=request.getContextPath()%>/js/static/images/images1/product-ico-3.png">
                </div>
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
                    <li>联系我们</li>
                    <li class="wyb">公司地址：北京市丰台区南四环西路186号汉威国际广场2号楼5层</li>
                    <li class="wyb">业务邮箱：service@cnfinatech.com</li>
                    <li class="wyb">业务咨询：010-88660066</li>
                </ul>
            </div>
        </div>
        <div class="home_footer_bottom">
            <p>copyright © 2017 版权所有 All Rights Reseved.</p>
            <p><a target="_blank" href="http://www.miitbeian.gov.cn/">京ICP备17069390号-1</a></p>
        </div>

    </div>
    <!--home 底部 结束-->
</div>
<a href="#0" class="cd-top">Top</a>
</body>
<script src="<%=request.getContextPath()%>/js/static/js/jquery.min.js"></script>
<script>
    $(document).ready(function($){

        var offset = 300,
            offset_opacity = 1200,
            scroll_top_duration = 700,
            $back_to_top = $('.cd-top');
        $(window).scroll(function(){
            ( $(this).scrollTop() > offset ) ? $back_to_top.addClass('cd-is-visible') : $back_to_top.removeClass('cd-is-visible cd-fade-out');
        });
        $back_to_top.on('click', function(event){
            event.preventDefault();
            $('body,html').animate({
                    scrollTop: 0 ,
                }, scroll_top_duration
            );
        });

    });
</script>
</html>