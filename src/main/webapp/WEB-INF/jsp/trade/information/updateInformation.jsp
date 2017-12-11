<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资料编辑</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row'>
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a href="#" id="zhxx">资料维护</a>
            <span>></span>
            <a href="#">资料编辑</a>
        </div>
        <div class="col-xs-12">
            <form id="formInformation">
                <input type="hidden" value="${information.id}" name="id">
            <div class="jbxx">
                <div class="row jbxx_row jbxx_zlbj">
                    <div class="col-xs-8">
                        <h5>基本资料</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-9 col-xs-offset-1">
                        <table class="table table_one">
                            <tbody>
                            <tr>
                                <td>企业身份:</td>
                                <td class="mys">
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
                                <td><input type="text" name="entName" class="form-control" disabled value=" ${information.entName}">
                                </td>
                            </tr>
                            <tr>
                                <td>企业证件类型:</td>
                                <td>
                                    <select class="form-control zlbj_select" name="entDocumentType">
                                        <%--0三证合一，1非三证合一--%>
                                        <option value="">全部</option>
                                        <option value="0" <c:if test="${'0' eq information.entDocumentType}">selected</c:if> >三证合一</option>
                                        <option value="1" <c:if test="${'1' eq information.entDocumentType}">selected</c:if> >非三证合一</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>社会统一信用代码：</td>
                                <td><input type="text" name="entCreditCode" class="form-control" value="${information.entCreditCode}">
                                </td>
                            </tr>
                            <tr>
                                <td>工商登记注册号：</td>
                                <td><input type="text" name="registrationNumber" class="form-control" value="${information.registrationNumber}">
                                </td>
                            </tr>
                            <tr>
                                <td>税务登记号：</td>
                                <td><input type="text" name="taxRegistrationNumber" class="form-control" value="${information.taxRegistrationNumber}"></td>
                            </tr>
                            <tr>
                                <td>组织机构代码：</td>
                                <td><input type="text" name="institutionCode" class="form-control" value="${information.institutionCode}"></td>
                            </tr>
                            <tr>
                                <td>法定代表人：</td>
                                <td><input type="text" name="representative" class="form-control" value="${information.representative}"></td>
                            </tr>
                            <tr>
                                <td>法定代表人证件类型：</td>
                                <td>
                                    <%--0居民身份证、1护照、2港澳居民来往内地通行证、3台湾居民来往大陆通行证--%>
                                    <select class="form-control zlbj_select" name="representativeType">
                                        <option>全部</option>
                                        <option value="0" <c:if test="${'0' eq information.representativeType}">selected</c:if> >居民身份证</option>
                                        <option value="1" <c:if test="${'1' eq information.representativeType}">selected</c:if> >护照</option>
                                        <option value="2" <c:if test="${'2' eq information.representativeType}">selected</c:if> >港澳居民来往内地通行证</option>
                                        <option value="3" <c:if test="${'3' eq information.representativeType}">selected</c:if> >台湾居民来往大陆通行证</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>法定代表人证件号码：</td>
                                <td><input type="text" name="representativeNum" class="form-control" value="${information.representativeNum}"></td>
                            </tr>
                            <tr>
                                <td>固定电话：</td>
                                <td><input type="text" name="telephone" class="form-control" value="${information.telephone}"></td>
                            </tr>
                            <tr>
                                <td>省直辖市：</td>
                                <td>
                                    <div class="sjld" style="margin-left:0 ;">
                                        <select class="col-xs-3 form-control" id="seachprov" name="seachprov"
                                                onChange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');"></select>
                                        <select style="margin-left:20px;" class="col-xs-3 form-control" id="seachcity"
                                                name="homecity"
                                                onChange="changeCity(this.value,'seachdistrict','seachdistrict');"></select>
                                        <div class="col-xs-2" id="seachdistrict_div">
                                            <select class="form-control" id="seachdistrict"
                                                    name="seachdistrict"></select>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>详细地址：</td>
                                <td><input type="text" name="address" class="form-control" value="${information.address}"></td>
                            </tr>
                            <tr>
                                <td>企业联系人：</td>
                                <td><input type="text" name="businessContact" class="form-control" value="${information.businessContact}"></td>
                            </tr>
                            <tr>
                                <td>企业联系人手机：</td>
                                <td><input type="text" name="mobilePhone" class="form-control" value="${information.mobilePhone}"></td>
                            </tr>
                            <tr>
                                <td>联系人电子邮件：</td>
                                <td><input type="text" name="emailAddress" class="form-control" value="${information.emailAddress}"></td>
                            </tr>
                            <tr>
                                <td>邮编：</td>
                                <td><input type="text" name="zipCode" class="form-control" value="${information.zipCode}"></td>
                            </tr>
                            <tr>
                                <td>网址：</td>
                                <td><input type="text" name="webSite" class="form-control" value="${information.webSite}"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="jbxx">
                <div class="row jbxx_row jbxx_zlbj">
                    <div class="col-xs-8">
                        <h5>基本资料</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-7 col-xs-offset-1">
                        <table class="table table_one">
                            <tbody>
                            <tr>
                                <td>注册资本:</td>
                                <td><input type="text"  name="registeredCapital" class="form-control" value="${information.registeredCapital}"></td>
                            </tr>
                            <tr>
                                <td>主要股东:</td>
                                <td><input type="text" name="majorShareholder" class="form-control" value="${information.majorShareholder}"></td>
                            </tr>

                            <tr>
                                <td>经营范围：</td>
                                <td><textarea style="width: 250px;" name="businessScope" class="form-control" rows="3">${information.businessScope}</textarea></td>
                            </tr>
                            <tr>
                                <td>登记机关：</td>
                                <td><input type="text" name="registrationAuthority" class="form-control" value="${information.registrationAuthority}"></td>
                            </tr>
                            <tr>
                                <td>社会统一信用代码电子档：</td>
                                <td class="mys"> <img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                            </tr>
                            <tr>
                                <td>工商登记注册电子档：</td>
                                <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                            </tr>
                            <tr>
                                <td>税务登记号电子档：</td>
                                <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                            </tr>
                            <tr>
                                <td>组织机构代码电子档：</td>
                                <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                            </tr>
                            <tr>
                                <td>法人身份证电子档：</td>
                                <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                            </tr>
                            <tr>
                                <td>开户许可证电子档：</td>
                                <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/softcopy@1x.png"></td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <button id="update" type="button" class="btn col-xs-offset-3" style="width: 120px;">确定</button>
        </form>
        </div>


    </div>
</div>
</body>
<script>
    $(function (){
        initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array, '44', '0', '0');
    });
    $('#zhxx').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/zhxx.action')
    });
    $("#update").click(function () {
        $.ajax({
            url:'<%=request.getContextPath()%>/information/modifyInformation.action',
            dataType:'json',
            type:'post',
            data:$("#formInformation").serialize(),
            success:function (data) {
                alert("修改成功！！")
                setTimeout("$('#load').load('<%=request.getContextPath()%>/tradeMain/ziliao.action')",500);
    }
        })
    })



</script>
</html>
