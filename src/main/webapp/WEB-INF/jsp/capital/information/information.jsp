<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
            <a href="<%=request.getContextPath()%>/captialMain/captialMain.action">系统首页</a>
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
                    <li><a href="#settings">三方账户</a></li>
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
                                        <button type="button" class="btn btn-danger">编辑</button>
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
                                                <c:if test="${information.entIdentity == 0}">
                                                    采购方
                                                </c:if>
                                                <c:if test="${information.entIdentity == 1}">
                                                    贸易方
                                                </c:if>
                                                <c:if test="${information.entIdentity == 2}">
                                                    资方
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
                                                    <c:if test="${information.representativeType==1}">
                                                        护照
                                                    </c:if>
                                                    <c:if test="${information.representativeType==2}">
                                                        港澳居民来往内地通行证
                                                    </c:if>
                                                    <c:if test="${information.representativeType==3}">
                                                        台湾居民来往大陆通行证
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
                            <div class="jbxx jbxx1">
                                <div class="row jbxx_row">
                                    <div class="col-xs-8">
                                        <h5>高级资料</h5>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-7 col-xs-offset-1">
                                        <table class="table table_one">
                                            <tbody>
                                            <tr>
                                                <td>注册资本:</td>
                                                <td>${information.webSite}</td>
                                            </tr>
                                            <tr>
                                                <td>主要股东:</td>
                                                <td><span>张先生 | 李先生 | 王女士${information.majorShareholder}</span></td>
                                            </tr>
                                            <tr>
                                                <td>经营范围:</td>
                                                <td>${information.businessScope}</td>
                                            </tr>
                                            <tr>
                                                <td>登记机关：</td>
                                                <td>${information.registrationAuthority}</td>
                                            </tr>
                                            <tr>
                                                <td>社会统一信用代码电子档：</td>
                                                <td><img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                                            </tr>
                                            <tr>
                                                <td>工商登记注册电子档：</td>
                                                <td><img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                                            </tr>
                                            <tr>
                                                <td>税务登记号电子档：</td>
                                                <td><img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                                            </tr>
                                            <tr>
                                                <td>组织机构代码电子档：</td>
                                                <td><img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                                            </tr>
                                            <tr>
                                                <td>法人身份证电子档：</td>
                                                <td><img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                                            </tr>
                                            <tr>
                                                <td>开户许可证电子档：</td>
                                                <td><img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
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
                        <!--账户安全 结束-->
                        <!--三方账户 开始   -->
                        <div class="tab-pane" id="settings">
                            <!--三方账户 开户行开始-->
                            <div class="khh sfzh">
                                <form class="form-inline khh_form khh_form1">
                                    <div class="form-group form-group1">
                                        <label for="exampleInputName2">开户行</label>
                                        <input type="text" class="form-control" id="exampleInputName2">
                                    </div>
                                    <div class="form-group form-group1">
                                        <label for="exampleInputEmail2">户主</label>
                                        <input type="email" class="form-control" id="exampleInputEmail2">
                                    </div>
                                    <button type="button" class="btn  btn-danger">查询</button>
                                    <button type="button" class="btn  btn-default">重置</button>
                                </form>
                            </div>
                            <!--三方账户 开户行结束-->
                            <!--三方账户 分页开始-->
                            <div class="fy">
                                <div class="row fy_row">
                                    <div class="col-xs-4">
                                        <p class="fy_con">共计3条数据，共1页</p>
                                    </div>
                                    <div class="col-xs-8">
                                        <nav aria-label="Page navigation">
                                            <ul class="pagination">
                                                <li>
                                                    <a href="#" aria-label="Previous">
                                                        <span aria-hidden="true">首页</span>
                                                    </a>
                                                    <a href="#" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="#">1</a></li>
                                                <li><a href="#">2</a></li>
                                                <li>
                                                    <a href="#" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                    <a href="#" aria-label="Previous">
                                                        <span aria-hidden="true">末页</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                            <!--三方账户 分页结束-->
                            <!--三方账户 表格开始-->
                            <div class="table-responsive text-center">
                                <table class="table table-bordered text-center">
                                    <tbody>
                                    <tr class="active">
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                    </tr>
                                    <tr>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                    </tr>
                                    <tr>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                    </tr>
                                    <tr>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                        <td>Table cell</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!--三方账户 表格结束-->
                            <!--三方账户 分页开始-->
                            <div class="fy">
                                <div class="row fy_row">
                                    <div class="col-xs-4">
                                        <p class="fy_con">共计3条数据，共1页</p>
                                    </div>
                                    <div class="col-xs-8">
                                        <nav aria-label="Page navigation">
                                            <ul class="pagination">
                                                <li>
                                                    <a href="#" aria-label="Previous">
                                                        <span aria-hidden="true">首页</span>
                                                    </a>
                                                    <a href="#" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="#">1</a></li>
                                                <li><a href="#">2</a></li>
                                                <li>
                                                    <a href="#" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                    <a href="#" aria-label="Previous">
                                                        <span aria-hidden="true">末页</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                            <!--三方账户 分页结束-->
                        </div>
                        <!--三方账户 结束   -->
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

//    $(function (){
//        initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array, '44', '0', '0');
//    });


</script>


</html>