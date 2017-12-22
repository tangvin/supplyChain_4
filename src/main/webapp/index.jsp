<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link type="image/x-icon" rel="icon" href="<%=request.getContextPath()%>/js/static/images/favicon.ico" />
    <link type="image/x-icon" rel="shortcut icon" href="<%=request.getContextPath()%>/js/static/images/favicon.ico" />
    <meta charset="UTF-8">
    <title>飞迅金服 - 打破局限、创造价值、值得信赖</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/static/css/css.css">
</head>
<body>
<%
    cn.com.edzleft.entity.SessionInfo sessionInfo=(cn.com.edzleft.entity.SessionInfo) session.getAttribute("sessionInfo");
    if(sessionInfo!=null){//session中有值  登陆成功
        if(sessionInfo.getAdmin().getAccountType() == 0){//采购方
            response.sendRedirect(request.getContextPath()+"/procurementMain/procurementMain.action");
        }
        if(sessionInfo.getAdmin().getAccountType() == 1){//贸易方
            response.sendRedirect(request.getContextPath()+"/tradeMain/tradeMain.action");
        }
        if(sessionInfo.getAdmin().getAccountType() == 2){//资方
            response.sendRedirect(request.getContextPath()+"/captialMain/captialMain.action");
        }
    }
%>
<div class="home_wrap">
    <!--top 开始-->
    <div class="home_top">
        <div class="home_width">
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
                    <li><a href="<%=request.getContextPath()%>/" class="home_top_nav_class">首页</a></li>
                    <li><a href="<%=request.getContextPath()%>/productCentre.action">产品中心</a></li>
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
    <div class="home_banner">
        <div class="home_width">
            <img src="<%=request.getContextPath()%>/js/static/images/images1/banner_main.png">
        </div>
        <div id="rightArrow">
            咨询热线：400 - 888 - 6660
        </div>
    </div>
    <!--banner 结束-->
    <!--home 主体 开始-->
    <div class="home_main">
        <!--home 产品介绍 开始-->
        <div class="home_cpjs">
            <div class="home_width">
                <p class="home_main_title clearfix">
                    <span class="home_xian"></span>
                    <span class="home_cpzx">产品中心</span>
                    <span class="home_xian"></span>
                </p>
                <p class="home_cpjs_con">飞迅金服供应链金融系统，通过将供应链上的相关企业作为一个整体，根据交易中构成的链条关系和行业特点设定融资方案，对供应链上单个企业或上下游多个企业提供的全面金融系统支撑；同时飞讯金服金融资产账户 管理系统，实现业务系统与资产端的交互，为整个供应链条提供资金账户、资金流向、账目明细等资产端服务， 助力企业快速打造供应链金融生态圈</p>
                <div class="home_cpjs_img">
                    <img src="<%=request.getContextPath()%>/js/static/images/images1/home-ico-1.png">
                </div>
            </div>
        </div>
        <!--home 产品介绍 结束-->
        <!--home 业务模式 开始-->
        <div class="home_cpjs home_ywms">
            <div class="home_width">
                <p class="home_main_title clearfix">
                    <span class="home_xian"></span>
                    <span class="home_cpzx">业务模式</span>
                    <span class="home_xian"></span>
                </p>
                <ul class="home_ywms_list clearfix">
                    <li>
                        <div class="home_ywms_list_left">
                            <div class="home_ywms_list_img">
                                <img src="<%=request.getContextPath()%>/js/static/images/images1/icon_shoukuan.png">
                            </div>
                        </div>
                        <div class="home_ywms_list_right">
                            <p class="home_ywms_list_right_title">应收账款融资模式</p>
                            <p class="home_ywms_list_right_con">金融机构与卖方签订应收账款融资合同约定，卖方将未到期应收账款债权出质给金融机构，金融机构支付卖方一定比例的融资款项，
                                并作为应收账款债权质权人直接向买方收取应收账款
                                。应收账款融资包括：应收账款质押、国内保理。</p>
                        </div>
                    </li>
                    <li class="home_ywms_list_ou">
                        <div class="home_ywms_list_left">
                            <div class="home_ywms_list_img">
                                <img src="<%=request.getContextPath()%>/js/static/images/images1/icon_kuanchi.png">
                            </div>
                        </div>
                        <div class="home_ywms_list_right">
                            <p class="home_ywms_list_right_title">应收账款池融资模式</p>
                            <p class="home_ywms_list_right_con">在卖方对（多个）特定买方的贸易关系稳定、应收账款保持在一定余额之上，卖方将日常分散的应收账款汇聚起来，形成应收账款余额“池”并转让给金融机构，金融机构按一定比例提供融资的业务模式。包含：国内保理池融资、应收账款池融资。</p>
                        </div>
                    </li>
                    <li>
                        <div class="home_ywms_list_left">
                            <div class="home_ywms_list_img">
                                <img src="<%=request.getContextPath()%>/js/static/images/images1/icon_dingdan.png">
                            </div>
                        </div>
                        <div class="home_ywms_list_right">
                            <p class="home_ywms_list_right_title">订单融资模式</p>
                            <p class="home_ywms_list_right_con">企业凭信用良好的买方订单，在较强的发货能力和有效担保的条件下，金融机构为企业生产经营提供融资。主要适用于需通过资金融通满足优质订单生产需求，且具有较强资信实力和生产能力的客户。可分为订单融资阶段和交货后融资阶段。</p>
                        </div>
                    </li>
                    <li class="home_ywms_list_ou">
                        <div class="home_ywms_list_left">
                            <div class="home_ywms_list_img">
                                <img src="<%=request.getContextPath()%>/js/static/images/images1/icon_danbao.png">
                            </div>
                        </div>
                        <div class="home_ywms_list_right">
                            <p class="home_ywms_list_right_title">担保提货模式</p>
                            <p class="home_ywms_list_right_con">商品买方交纳一定比例的保证金，从金融机构取得授信并支付给贸易项下的卖方，在买方确认金融机构提货要求后，卖方凭金融机构签发的提货通知给买方发货。如果授信到期时买方未能按时赎完货物，卖方按约定向金融机构退还相应的款项。</p>
                        </div>
                    </li>
                    <li>
                        <div class="home_ywms_list_left">
                            <div class="home_ywms_list_img">
                                <img src="<%=request.getContextPath()%>/js/static/images/images1/icon_car.png">
                            </div>
                        </div>
                        <div class="home_ywms_list_right">
                            <p class="home_ywms_list_right_title">汽车先票/款后货模式</p>
                            <p class="home_ywms_list_right_con">企业从金融机构取得授信专项用于向上游卖方支付货款，上游卖方按照购销合同以及协议书的约定发运货物，到货后企业直接赎货或转为现贷抵/质押的业务。卖方如在约定的发货期内未能全部发货，应按约定向金融机构承担未发货部分的退款。</p>
                        </div>
                    </li>
                    <li class="home_ywms_list_ou">
                        <div class="home_ywms_list_left">
                            <div class="home_ywms_list_img">
                                <img src="<%=request.getContextPath()%>/js/static/images/images1/icon_cunhuo.png">
                            </div>
                        </div>
                        <div class="home_ywms_list_right">
                            <p class="home_ywms_list_right_title">存货质押模式</p>
                            <p class="home_ywms_list_right_con">企业以自由的动产为质押物，金融机构基本对企业质押的商品实行监管并予以资金融通的模式。</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <!--home 业务模式 结束-->
        <!--home 产品功能 开始-->
        <div class="home_cpjs home_cpgn">
            <div class="home_width">
                <p class="home_main_title clearfix">
                    <span class="home_xian"></span>
                    <span class="home_cpzx">产品功能</span>
                    <span class="home_xian"></span>
                </p>
                <div class="home_xsxx">
                    <p>线上线下结合</p>
                    <img src="<%=request.getContextPath()%>/js/static/images/images1/home-ico-2.png">
                </div>
                <div class="home_xsxx">
                    <p>系统框架</p>
                    <img src="<%=request.getContextPath()%>/js/static/images/images1/home-ico-3.png">
                </div>
            </div>
        </div>
        <!--home 产品功能 开始-->
    </div>
</div>
<!--home 主体 结束-->
<!--home 底部 开始-->
<div class="home_footer">
    <div class="home_footer_top">
        <div class="home_width">
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
        <div class="home_width">
            <p>copyright © 2017 版权所有 All Rights Reseved.</p>
            <p><a target="_blank" href="http://www.miitbeian.gov.cn/">京ICP备17069390号-1</a></p>
        </div>
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