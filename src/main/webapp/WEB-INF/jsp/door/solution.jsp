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

    <!--解决方案 开始-->
    <div class="jjfa_main">
        <div class="jjfa_ywxz">
            <p class="home_main_title clearfix">
                <span class="home_xian"></span>
                <span class="home_cpzx">产品中心</span>
                <span class="home_xian"></span>
            </p>
            <div class="jjfa_ywxz_main clearfix">
                <img src="<%=request.getContextPath()%>/js/static/images/images1/yetaixianzhuang1.png">
                <img src="<%=request.getContextPath()%>/js/static/images/images1/yetaixianzhuang3.png">
                <img src="<%=request.getContextPath()%>/js/static/images/images1/yetaixianzhuang5.png">
                <img src="<%=request.getContextPath()%>/js/static/images/images1/yetaixianzhuang2.png">
                <img src="<%=request.getContextPath()%>/js/static/images/images1/yetaixianzhuang4.png">
            </div>
        </div>
        <div class="jjfa_rhyd">
            <div class="home_width">
                <p class="home_main_title clearfix">
                    <span class="home_xian"></span>
                    <span class="home_cpzx">如何应对</span>
                    <span class="home_xian"></span>
                </p>
                <ul class="jjfa_rhyd_list clearfix">
                    <li>
                        <div></div>
                        <p class="jjfa_rhyd_list_con">唯品会 - 全球精选，正品特卖！都是傲娇的品牌，只卖呆萌的价格！商品囊括了时尚女装、童装、美妆、美鞋、男装、居...</p>
                    </li>
                    <li>
                        <div></div>
                        <p class="jjfa_rhyd_list_con">唯品会 - 全球精选，正品特卖！都是傲娇的品牌，只卖呆萌的价格！商品囊括了时尚女装、童装、美妆、美鞋、男装、居...</p>
                    </li>
                    <li>
                        <div></div>
                        <p class="jjfa_rhyd_list_con">唯品会 - 全球精选，正品特卖！都是傲娇的品牌，只卖呆萌的价格！商品囊括了时尚女装、童装、美妆、美鞋、男装、居...</p>
                    </li>
                </ul>
            </div>
        </div>
        <div class="jjfa_jjfa">
            <div class="home_width">
                <p class="home_main_title clearfix">
                    <span class="home_xian"></span>
                    <span class="home_cpzx">解决方案</span>
                    <span class="home_xian"></span>
                </p>
                <div class="jjfa_jjfa_div">
                    <button>立即体验</button>
                </div>
            </div>
        </div>
    </div>
    <!--解决方案 结束-->

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