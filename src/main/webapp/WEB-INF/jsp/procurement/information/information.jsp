<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资料维护</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String name = request.getParameter("name");//用request得到
    %>
</head>
<body>
<div class='col-xs-12'>
    <div class='row row_zhxx'>
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
            <span>></span>
            <a href="#">资料维护</a>
        </div>
        <!--bootstrap tab 切换 开始-->
        <div class="col-xs-12">
            <div class="row row_dh">
                <!--tab 导航 开始-->
                <ul class="nav nav-tabs col-xs-12" id="myTab">
                    <li class="active"><a href="#home">基本资料</a></li>
                    <li><a href="#profile">账户安全</a></li>
                    <li><a href="#messages">银行账户</a></li>
                    <li><a href="#settings">三方账户</a></li>
                    <li><a href="#settings1">货运管理</a></li>
                    <li><a href="#recieverAddress">收获地址</a></li>
                </ul>
                <!--tab 导航 结束-->
                <!--tab 内容 开始-->
                <div class="row row_tab_con">
                    <div class="tab-content col-xs-12">
                        <!--基本资料 开始-->
                        <div class="tab-pane active" id="home">
                            <div class="jbxx">
                                <div class="row jbxx_row">
                                    <div class="col-xs-8">
                                        <h5>基本资料</h5>
                                    </div>
                                    <div class="col-xs-4 text-right">
                                        <button type="button" class="btn btn-danger" id="updateInformation">编辑</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-7 col-xs-offset-1">
                                        <table class="table table_one">
                                            <tbody>
                                            <tr>
                                                <td>企业身份:</td>
                                                <td>
                                                    <%--0采购方、1贸易方、2资方--%>
                                                <c:if test="${information.entIdentity == 0}">   采购方
                                                 
                                                </c:if>
                                                <c:if test="${information.entIdentity == 1}">贸易方
                                                    
                                                </c:if>
                                                <c:if test="${information.entIdentity == 2}">资方
                                                    
                                                </c:if>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>企业名称:</td>
                                                <td><span>${information.entName}</span><span class="drz">待认证</span></td>
                                            </tr>
                                            <tr>
                                                <td>社会统一信用代码:</td>
                                                <td>${information.entCreditCode}</td>
                                            </tr>
                                            <tr>
                                                <td>工商登记注册号：</td>
                                                <td>${information.registrationNumber}</td>
                                            </tr>
                                            <tr>
                                                <td>税务登记号：</td>
                                                <td>${information.taxRegistrationNumber}</td>
                                            </tr>
                                            <tr>
                                                <td>组织机构代码：</td>
                                                <td>${information.institutionCode}</td>
                                            </tr>
                                            <tr>
                                                <td>法定代表人</td>
                                                <td>${information.representative}</td>
                                            </tr>
                                            <tr>
                                                <td>法定代表人证件类型：</td>
                                                <%--0居民身份证、1护照、2港澳居民来往内地通行证、3台湾居民来往大陆通行证--%>
                                                <td>
                                                    <c:if test="${information.representativeType==1}">护照
                                                       
                                                    </c:if>
                                                    <c:if test="${information.representativeType==2}">港澳居民来往内地通行证
                                                      
                                                    </c:if>
                                                    <c:if test="${information.representativeType==3}">台湾居民来往大陆通行证
                                                        
                                                    </c:if>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>组织机构代码：</td>
                                                <td>${information.institutionCode}</td>
                                            </tr>
                                            <tr>
                                                <td>法定代表人证件号码：</td>
                                                <td>${information.representativeNum}</td>
                                            </tr><tr>
                                                <td>固定电话：</td>
                                                <td>${information.telephone}</td>
                                            </tr>
                                            <tr>
                                                <td>省市区域：</td>
                                                <td>${information.municipality}${information.city}${information.county}</td>
                                            </tr>
                                            <tr>
                                                <td>详细地址：</td>
                                                <td>${information.address}</td>
                                            </tr>
                                            <tr>
                                                <td>企业联系人：</td>
                                                <td>${information.businessContact}</td>
                                            </tr>
                                            <tr>
                                                <td>企业联系人手机：</td>
                                                <td>${information.mobilePhone}</td>
                                            </tr>
                                            <tr>
                                                <td>联系人电子邮件：</td>
                                                <td>${information.emailAddress}</td>
                                            </tr>
                                            <tr>
                                                <td>邮编：</td>
                                                <td>${information.zipCode}</td>
                                            </tr>
                                            <tr>
                                                <td>网址：</td>
                                                <td>${information.webSite}</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--基本资料 结束-->
                        <!--账户安全 开始-->
                        <div class="tab-pane" id="profile">
                            <h5>修改密码</h5>
                            <div class="row">
                                <div class="col-xs-10">
                                    <form class="form-horizontal" role="form" id ="f">
                                        <div class="form-group">
                                            <label class="col-xs-2 control-label">验证码</label>
                                            <div class="senCode col-xs-8">
                                                <%--<input type="text" class="form-control col-xs-4" id="phone" name="phone" placeholder="输入手机号">--%>
                                                <input type="text" id="senCode" placeholder="输入验证码" class="form-control col-xs-4" name="senCode" size="6"/>
                                                <input id="btnSendCode" type="button" value="发送验证码" onclick="sendMessage()" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="newpwd" class="col-xs-2 control-label">新密码</label>
                                            <div class="col-xs-8">
                                                <input type="password" class="form-control" id="newpwd" name="newpwd">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="confirm" class="col-xs-2 control-label">确认密码</label>
                                            <div class="col-xs-8">
                                                <input type="password" class="form-control" id="confirm" name="confirm">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-offset-3 col-xs-8">
                                                <button type="button" class="btn  btn-danger aq_qr_but" id="upda">确认</button>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                        <!--账户安全 结束-->
                        <!--银行账户 开始-->
                        <div class="tab-pane" id="messages">
                            <button type="button" class="btn   btn-danger btn-default tjyhk">添加银行卡</button>
                            <div class="row">
                                <div class="col-xs-8 col-xs-offset-1">
                                    <ul class="media-list">
                                        <li class="media media_btn">
                                            <div class="media-left">
                                                <div class="yhzh_yhk yhzh_yhk1">
                                                    <div class="panel-body">
                                                        <div class="yhk_logo clearfix">
                                                            <img src="<%=request.getContextPath()%>/js/static/images/logo_minsheng@1x.png" class="img-responsive">
                                                            <p>中国民生银行<br>储蓄卡</p>
                                                            <div class="moren">
                                                                <img src="<%=request.getContextPath()%>/js/static/images/default_white@1x.png">
                                                                <span>默认</span>
                                                            </div>
                                                        </div>
                                                        <p class="yhkh">**** &nbsp **** &nbsp **** &nbsp 5719</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn  btn-danger btn-default">设为默认</button>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn  btn-danger btn-default">删除</button>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul class="media-list">
                                        <li class="media media_btn">
                                            <div class="media-left">
                                                <div class="yhzh_yhk yhzh_yhk2">
                                                    <div class="panel-body">
                                                        <div class="yhk_logo clearfix">
                                                            <img src="<%=request.getContextPath()%>/js/static/images/logo_nongye@1x.png" class="img-responsive">
                                                            <p>中国民生银行<br>储蓄卡</p>
                                                            <!--<div class="moren">-->
                                                            <!--<img src="<%=request.getContextPath()%>/js/static/images/default_white@1x.png">-->
                                                            <!--<span>默认</span>-->
                                                            <!--</div>-->
                                                        </div>

                                                        <p class="yhkh">**** &nbsp **** &nbsp **** &nbsp 5719</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn   btn-danger btn-default">设为默认</button>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn   btn-danger btn-default">删除</button>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul class="media-list">
                                        <li class="media media_btn">
                                            <div class="media-left">
                                                <div class="yhzh_yhk yhzh_yhk3">
                                                    <div class="panel-body">
                                                        <div class="yhk_logo clearfix">
                                                            <img src="<%=request.getContextPath()%>/js/static/images/logo_zhaoshang@1x.png" class="img-responsive">
                                                            <p>中国民生银行<br>储蓄卡</p>
                                                            <!--<div class="moren">-->
                                                            <!--<img src="<%=request.getContextPath()%>/js/static/images/default_white@1x.png">-->
                                                            <!--<span>默认</span>-->
                                                            <!--</div>-->
                                                        </div>

                                                        <p class="yhkh">**** &nbsp **** &nbsp **** &nbsp 5719</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn   btn-danger btn-default">设为默认</button>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn   btn-danger btn-default">删除</button>
                                            </div>
                                        </li>
                                    </ul>

                                </div>
                            </div>
                        </div>
                        <!--银行账户 结束-->
                        <!--三方账户 开始   -->
                        <div class="tab-pane" id="settings">
                            <!--三方账户 开户行开始-->
                            <div class="khh sfzh">
                                <form class="form-inline khh_form khh_form1">
                                    <div class="form-group form-group1">
                                        <label for="exampleInputName2">开户行</label>
                                        <input type="text" class="form-control" id="tripartiteDepositBank">
                                    </div>
                                    <div class="form-group form-group1">
                                        <label for="exampleInputEmail2">户主</label>
                                        <input type="email" class="form-control" id="tripartiteCreditHolderTrade">
                                    </div>
                                    <button type="button" class="btn btn-danger btn-default" onclick="crownSearch()">查询</button>
                                    <button type="button" class="btn btn-danger btn-default" onclick="reset()">重置</button>
                                </form>
                            </div>
                            <div class="panel-body" style="padding-bottom:0px;">
                                <table id="tb_departments" class="cj_table"></table>
                            </div>
                        </div>
                        <!--三方账户 结束   -->
                        <!--运货单位 开始-->
                        <div class="tab-pane" id="settings1">
                            <h5>运货单位</h5>
                            <div class="row">
                                <div class="col-xs-9 col-xs-offset-1">
                                    <ul class="media-list">
                                        <li class="media hy_hygl1">
                                            <div class="media-left hygl clearfix">
                                                <div class="hygl_left">
                                                    <div class="panel-body">
                                                        <p>货运单位名称：德邦物流</p>
                                                        <p>货运方联系人：王二</p>
                                                        <p>联系人手机：13914319412</p>
                                                    </div>
                                                </div>
                                                <div class="hygl_right">
                                                    <div class="panel-body">
                                                        <div class="mored hy_moren">
                                                            <img src="<%=request.getContextPath()%>/js/static/images/default_blue@1x.png"><span>默认</span>
                                                        </div>
                                                        <div class="hy_logo">
                                                            <img src="<%=request.getContextPath()%>/js/static/images/logo_debang@1x.png">
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn btn-danger btn-default">设为默认</button>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn btn-danger btn-default" >删除</button>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul class="media-list">
                                        <li class="media hy_hygl1">
                                            <div class="media-left hygl clearfix">
                                                <div class="hygl_left">
                                                    <div class="panel-body">
                                                        <p>货运单位名称：德邦物流</p>
                                                        <p>货运方联系人：王二</p>
                                                        <p>联系人手机：13914319412</p>
                                                    </div>
                                                </div>
                                                <div class="hygl_right">
                                                    <div class="panel-body">
                                                        <!--<div class="mored hy_moren">-->
                                                        <!--<img src="<%=request.getContextPath()%>/js/static/images/default_blue@1x.png"><span>默认</span>-->
                                                        <!--</div>-->
                                                        <div class="hy_logo">
                                                            <img src="<%=request.getContextPath()%>/js/static/images/logo_shentong@1x.png">
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn btn-danger btn-default">设为默认</button>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn btn-danger btn-default">删除</button>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul class="media-list">
                                        <li class="media hy_hygl1">
                                            <div class="media-left hygl clearfix">
                                                <div class="hygl_left">
                                                    <div class="panel-body">
                                                        <p>货运单位名称：德邦物流</p>
                                                        <p>货运方联系人：王二</p>
                                                        <p>联系人手机：13914319412</p>
                                                    </div>
                                                </div>
                                                <div class="hygl_right">
                                                    <div class="panel-body">
                                                        <div class="hy_logo">
                                                            <img src="<%=request.getContextPath()%>/js/static/images/logo_yuantong@1x.png">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn btn-danger btn-default">设为默认</button>
                                            </div>
                                            <div class="media-body">
                                                <button type="button" class="btn btn-danger btn-default">删除</button>
                                            </div>
                                        </li>
                                    </ul>
                                    <button type="button" class="btn  btn-danger  btn-default tjhydw" data-toggle="modal" data-target="#exampleModal11">添加货运单位</button>
                                </div>
                            </div>
                            <!--货运单位 蒙泰框-->
                            <form id="h" method="post">
                            <div class="modal fade" id="exampleModal11" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title">选择收获地址11</h4>
                                        </div>
                                        <div class="modal-header sh_div">
                                            <div class="row">
                                                <div class="col-xs-3"><span class="xingxing xx1">*</span>货运单位名称</div>
                                                <div class="col-xs-9"><input type="text" class="form-control sh_input" name="freightName"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-3"><span class="xingxing xx1">*</span>货运方联系人</div>
                                                <div class="col-xs-9"><input type="text" class="form-control sh_input" name="freightContactPerson"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-3"><span class="xingxing xx1">*</span>货运方联系人手机号</div>
                                                <div class="col-xs-9"><input type="text" class="form-control sh_input" name="freightContactPhone"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-3"><span class="xingxing xx1">*</span>设为默认</div>
                                                <div class="col-xs-9">
                                                    <label class="radio-inline">
                                                        <input type="radio" name="freightDefaultAddress" checked> 是
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input type="radio" name="freightDefaultAddress"> 否
                                                    </label>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" id="Addfreigft">确认</button>
                                            <button type="button" class="btn btn-primary">取消</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </form>
                            <!--货运单位 蒙泰框 结束-->
                            
                        </div>
                        <!--运货单位 结束-->
                        <!--收获地址 开始-->
                        <div class="tab-pane" id="recieverAddress">
                            <button type="button" class="btn btn-danger btn-default tjyhk" data-toggle="modal" data-target="#exampleModal">添加收获地址</button>
                            <div class="row row_shdz">
                                <div class="col-xs-7 shdz">
                                    <div class="panel-body">
                                        <div class="col-xs-9">
                                            <p>收获地址: nbsp 北京市大兴区亦庄</p>
                                            <p>收货地: nbsp 亦庄文化园国际企业文化园西园</p>
                                            <p>邮政编码: nbsp 100176</p>
                                            <p>收货人: &nbsp 王二</p>
                                            <p>收货人手机号: &nbsp 13914319412</p>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="radio center-block">
                                                <label>
                                                    <input type="radio" name="optionsRadios" checked value="option1">设为默认
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-5">
                                    <button type="button" class="btn btn-danger btn-default shanchu">删除</button>
                                </div>
                            </div>
                            <div class="row row_shdz">
                                <div class="col-xs-7 shdz">
                                    <div class="panel-body">
                                        <div class="col-xs-9">
                                            <p>收获地址: nbsp 北京市大兴区亦庄</p>
                                            <p>收货地: nbsp 亦庄文化园国际企业文化园西园</p>
                                            <p>邮政编码: nbsp 100176</p>
                                            <p>收货人: &nbsp 王二</p>
                                            <p>收货人手机号: &nbsp 13914319412</p>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="radio center-block">
                                                <label>
                                                    <input type="radio" name="optionsRadios" value="option1">设为默认
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-5">
                                    <button type="button" class="btn btn-danger btn-default shanchu" id="deladdress">删除</button>
                                </div>
                            </div>
                            <!--收获地址 蒙泰框-->
                            
                            
                           <!--  添加收货地址 -->
                           <form  action="" id="d" method="post">
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="exampleModalLabel">选择收获地址</h4>
                                        </div>

                                        <div class="modal-header sh_div">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <span class="xingxing xx1">*</span>收货区域
                                                </div>
                                                <div class="col-xs-9">
                                                    <div class="row sjld ">
                                                        <select class="col-xs-3 form-control" id="seachprov" name="rAddressArea" onChange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');"></select>
                                                        <select style="margin-left:20px;" class="col-xs-3 form-control" id="seachcity" name="rAddressArea" onChange="changeCity(this.value,'seachdistrict','seachdistrict');"></select>
                                                        <span class="col-xs-3"  id="seachdistrict_div">
                                                            <select class="form-control" id="seachdistrict" name="rAddressArea"></select>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-3"><span class="xingxing xx1">*</span>收货地址</div>
                                                <div class="col-xs-9"><input type="text" class="form-control sh_input" name="rAddressAddress"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-3"><span class="xingxing xx1">*</span>邮政编码</div>
                                                <div class="col-xs-9"><input type="text" class="form-control sh_input" name="rAddressZipcode"></div>
                                            </div>
                                             <div class="row">
                                                <div class="col-xs-3"><span class="xingxing xx1">*</span>收货人</div>
                                                <div class="col-xs-9"><input type="text" class="form-control sh_input" name="rAddressPerson"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-3"><span class="xingxing xx1">*</span>收货人手机号</div>
                                                <div class="col-xs-9"><input type="text" class="form-control sh_input" name="rAddressPhone"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-xs-3"><span class="xingxing xx1">*</span>设为默认</div>
                                                <div class="col-xs-9">
                                                    <label class="radio-inline">
                                                        <input type="radio" name="rAddressDefault" checked value="0"> 是
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input type="radio" name="rAddressDefault"  value="1"> 否
                                                    </label>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" id="getAddress">确认</button>
                                            <button type="button" class="btn btn-primary">取消</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </form>
                            <!--收获地址 蒙泰框 结束-->
                        </div>
                        <!--收获地址 开始-->
                    </div>
                </div>
                <!--tab 内容 结束-->
            </div>
        </div>
        <!--bootstrap tab 切换 结束-->

    </div>
</div>


</body>
<script>
    $('#myTab a:first').tab('show');

    $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    })

    $('#updateInformation').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/updateInformation.action')
    })
    $('#zlrz').click(function(){
        $('#load').load('<%=request.getContextPath()%>/procurementMain/zlrz.action')
    })

    $(function (){
        initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array, '44', '0', '0');
    });
    console.log('${messages}')
    switch ('${messages}'){
        case 'profile':
            $('#myTab a[href="#profile"]').tab('show')
            break;
        case 'home':
            $('#myTab a[href="#home"]').tab('show')
            break;
        case 'settings':
            $('#myTab a[href="#settings"]').tab('show')
            break;
    }

    var InterValObj; //timer变量，控制时间
    var count = 3; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    var code = ""; //验证码
    var codeLength = 6;//验证码长度
    function sendMessage() {
        curCount = count;
        var phone=$("#phone").val();//手机号码
        var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
//        if(phone == ""){
//            alert("手机号码不能为空！");
//        }else if(phone.length !=11){
//            alert('请输入有效的手机号码');
//        }else if(!myreg.test(phone)){
//            alert('请输入有效的手机号码11');
//        } else{
        //产生验证码
//            for (var i = 0; i < codeLength; i++) {
//                code += parseInt(Math.random() * 9).toString();
//            }
        //设置button效果，开始计时
        $("#btnSendCode").attr("disabled", "true");
        $("#btnSendCode").val("请在" + curCount + "秒内输入验证码");
        InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
        //向后台发送处理数据
        $.ajax({
            type: "POST", //用POST方式传输
            dataType: "text", //数据格式:JSON
            url: '<%=request.getContextPath()%>/captialHomes/sendMsg.action', //目标地址
//                data: "phone=" + phone + "&code=" + code,
            error: function (XMLHttpRequest, textStatus, errorThrown) { },
            success: function (msg){ }
        });
//        }
    }
    //timer处理函数
    function SetRemainTime() {
        if (curCount == 0) {
            window.clearInterval(InterValObj);//停止计时器
            $("#btnSendCode").removeAttr("disabled");//启用按钮
            $("#btnSendCode").val("重新发送验证码");
            code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效
        }
        else {
            curCount--;
            $("#btnSendCode").val( curCount + "秒内输入验证码");
        }
    }

	$(function(){
		$("#upda").click(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/password/changePwd.action",
				type:'post',
				data:$("#f").serialize(),
				dataType:"json",
				success:function(data){
					alert(data);
				}
			});
		});
		/* 添加收获地址 */
		$("#getAddress").click(function(){
			var ra = $("#d").serialize();
			$.ajax({
				url:"<%=request.getContextPath()%>/PmReceivingAddress/getaddress.action",
				type:'post',
				data:$("#d").serialize(),
				dataType:"json",
				success:function(data){
					alert("添加完成");
				}
			});
		});
	});
	/* 三方账户展示 */
	 $(function(){
	        $("#tb_departments").bootstrapTable({
	            columns:[
	                { //field: 'Number',//可不加
	                    title: '序号',//标题  可不加
	                    width:100,
	                    formatter: function (value, row, index) {
	                        return index+1;
	                    }
	                },
	                {field:'tripartiteDepositBank',title:'开户行',width:100},
	                {field:'tripartiteCreditHolderPurchaser',title:'户主（采购方	）',width:100},
	                {field:'tripartiteAccountNumber',title:'账号',width:100},
	                {field:'tripartiteBalance',title:'余额（元）',width:100},
	                {field:'tripartiteAvailableBalance',title:'可用余额',width:100},
	                {field:'tripartiteAmountCreateTime',title:'账号开通时间',width:100},
	                {field:'tripartiteAccountOpenpeople',title:'账号开通人',width:100},
	                {field:'tripartiteAmountCreateTime',title:'创建时间',width:100},
	                {field:'tripartiteAmountCreatePeople',title:'创建人',width:100},
	            ],
	            url:'<%=request.getContextPath()%>/tripartite/pmtripartite.action',
	            method:'post',
	            queryParamsType:'',
	            queryParams: queryParams,//传递参数（*）
	            //【其它设置】
	            locale:'zh-CN',//中文支持
	            pagination: true,//是否开启分页（*）
	            pageNumber:1,//初始化加载第一页，默认第一页
	            pageSize: 3,//每页的记录行数（*）
	            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
	            //发送到服务器的数据编码类型  {order: "asc", offset: 0, limit: 5}
	            contentType:'application/x-www-form-urlencoded;charset=UTF-8'   //数据编码纯文本  offset=0&limit=5
	        });
	    });
	    //得到查询的参数
	    function queryParams (params) {
	        var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	            pageNumber: params.pageNumber,
	            pageSize: params.pageSize,
	            tripartiteDepositBank:$("#tripartiteDepositBank").val(),
	            tripartiteCreditHolderPurchaser:$("#tripartiteCreditHolderPurchaser").val(),
	        };
	        return temp;
	    }
	    //授信搜索
	    function crownSearch(){
	        $("#tb_departments").bootstrapTable('refresh');
	    }
	    //授信重置查询
	    function reset(){
	        $("#crownForm").form('reset');
	        crownSearch();
	    }

</script>
</html>