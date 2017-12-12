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
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
            <span>></span>
            <a href="#" id="zhxx">资料维护</a>
            <span>></span>
            <a href="#">资料编辑</a>
        </div>
        <div class="col-xs-12">
            <form id="updateForm">
            <%-- <input type="hidden" value="${information.id}" name="id"> --%>
                <div class="jbxx">
                    <div class="row jbxx_row jbxx_zlbj">
                        <div class="col-xs-8">
                            <h5>基本资料</h5>
                        </div>
                    </div>
                    <div class="row">
                            <table class="table table_one">
                                <tbody>
                                <tr>
                                    <input type="hidden" name="id" value="${information.id }">
                                    <td style="width: 20%;" class="text-right">企业身份：</td>
                                    <td class="mys">
                                           <%--0采购方、1贸易方、2资方--%>
                                                <c:if test="${account.accountType == 0}">采购方
                                                 
                                                </c:if>
                                                <c:if test="${account.accountType == 1}">贸易方
                                                    
                                                </c:if>
                                                <c:if test="${account.accountType == 2}">资方
                                                    
                                                </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">企业名称：</td>
                                    <td>
                                        <c:if test="${information.entName != null}">
                                            <input type="text" class="form-control" name="entName" disabled value="${information.entName}" >
                                        </c:if>
                                        <c:if test="${information.entName == null}">
                                            <input type="text" class="form-control" name="entName" value="${information.entName}" >
                                        </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">企业证件类型：</td>
                                    <%--<td>--%>
                                        <%--<select class="form-control zlbj_select" id="three_certificates" name="entDocumentType">--%>
                                            <%--&lt;%&ndash;0三证合一，1非三证合一&ndash;%&gt;--%>
                                            <%--<option value="">全部</option>--%>
                                            <%--<option value="0" <c:if test="${'0' eq information.entDocumentType}">selected</c:if> >三证合一</option>--%>
                                            <%--<option value="1" <c:if test="${'1' eq information.entDocumentType}">selected</c:if> >非三证合一</option>--%>
                                        <%--</select>--%>
                                    <%--</td>--%>
                                    <td>
                                        <%--                         <select class="form-control zlbj_select" name="entDocumentType" id="three_certificates">
                                                                     &lt;%&ndash;0三证合一，1非三证合一&ndash;%&gt;
                                                                     <option value="0" <c:if test="${'0' eq information.entDocumentType}">selected</c:if> >三证合一</option>
                                                                     <option value="1" <c:if test="${'1' eq information.entDocumentType}">selected</c:if> >非三证合一</option>
                                                                 </select>--%>
                                        <c:if test="${information.entDocumentType == 0}">三证合一
                                            <input type="hidden" class="form-control" name="entDocumentType"  value="${information.entDocumentType}" >
                                        </c:if>
                                        <c:if test="${information.entDocumentType == 1}">非三证合一
                                            <input type="hidden" class="form-control" name="entDocumentType"  value="${information.entDocumentType}" >
                                        </c:if>
                                    </td>
                                </tr>
		                                 <tr class="three_no_certificates">
		                                    <td  class="text-right">社会统一信用代码：</td>
		                                    <td><input type="text" name="entCreditCode" class="form-control" value="${information.entCreditCode}">
		                                    </td>
		                                </tr>
                                <tr class="three_certificates">
                                    <td class="text-right">工商登记注册号：</td>
                                    <td><input type="text" class="form-control" value="${information.registrationNumber}" name="registrationNumber" ></td>
                                </tr>
                                <tr class="three_certificates">
                                    <td class="text-right">税务登记号：</td>
                                    <td><input type="text" class="form-control" value="${information.taxRegistrationNumber}" name="taxRegistrationNumber"></td>
                                </tr>
                                <tr  class="three_certificates">
                                    <td class="text-right">组织机构代码：</td>
                                    <td><input type="text" class="form-control" value="${information.institutionCode}" name="institutionCode"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">法定代表人：</td>
                                    <td><input type="text" class="form-control" value="${information.representative}" name="representative"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">法定代表人证件类型：</td>
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
                                    <td class="text-right">法定代表人证件号码：</td>
                                    <td><input type="text" class="form-control" name="representativeNum" value="${information.representativeNum}"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">固定电话：</td>
                                    <td><input type="text" class="form-control" name="telephone" value="${information.telephone}"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">省直辖市：</td>
                                    <td>
                                        <div class="sjld" style="margin-left:0 ;">
                                            <select class="col-xs-3 form-control" id="seachprov" name="municipality"
                                                    onChange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');"></select>
                                            <select style="margin-left:20px;" class="col-xs-3 form-control" id="seachcity"
                                                    name="city"
                                                    onChange="changeCity(this.value,'seachdistrict','seachdistrict');"></select>
                                            <div class="col-xs-2" id="seachdistrict_div">
                                                <select class="form-control" id="seachdistrict"
                                                        name="county"></select>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">详细地址：</td>
                                    <td><input type="text" class="form-control" name="address" value="${information.address}"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">企业联系人：</td>
                                    <td><input type="text" class="form-control" name="businessContact" value="${information.businessContact}"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">企业联系人手机：</td>
                                    <td><input type="text" class="form-control" name="mobilePhone" value="${information.mobilePhone}"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">联系人电子邮件：</td>
                                    <td><input type="text" class="form-control" name="emailAddress" value="${information.emailAddress}"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">邮编：</td>
                                    <td><input type="text" class="form-control" name="zipCode" value="${information.zipCode}"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">网址：</td>
                                    <td><input type="text" class="form-control" name="webSite" value="${information.webSite}"></td>
                                </tr>
                                </tbody>
                            </table>
                    </div>
                </div>
                <div class="jbxx">
                    <div class="row jbxx_row jbxx_zlbj">
                        <div class="col-xs-8">
                            <h5>高级资料</h5>
                        </div>
                    </div>
                    <div class="row">
                            <table class="table table_one">
                                <tbody>
                                <tr>
                                    <td style="width: 20%;" class="text-right">注册资本:</td>
                                    <td><input type="text" class="form-control" name="registeredCapital" value="${information.registeredCapital}"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">主要股东:</td>
                                    <td><input type="text" class="form-control" name="majorShareholder" value="${information.majorShareholder}"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">经营范围:</td>
                                    <td><input type="text" class="form-control" name="businessScope" value="${information.businessScope}"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">登记机关:</td>
                                    <td><input class="form-control" name="registrationAuthority"  value="${information.registrationAuthority}" type="text"></td>
                                </tr>
                                <tr class="three_no_certificates">
                                    <td class="text-right">社会统一信用代码电子档：</td>
                                    <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/no_img.png" class="img-responsive jbxx_img"></td>
                                </tr>
                                <tr  class="three_certificates">
                                    <td class="text-right">工商登记注册号电子档：</td>
                                    <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/no_img.png" class="img-responsive jbxx_img"></td>
                                </tr>
                                <tr  class="three_certificates">
                                    <td class="text-right">税务登记号电子档：</td>
                                    <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/no_img.png" class="img-responsive jbxx_img"></td>
                                </tr>
                                <tr  class="three_certificates">
                                    <td class="text-right">组织机构代码电子档：</td>
                                    <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/no_img.png" class="img-responsive jbxx_img"></td>
                                </tr>
                                <tr>
                                    <td class="text-right">法人身份证明正面：</td>
                                    <td>
                                        <form>
                                            <div style="float: left;" class="form-group" class="uploadForm" enctype='multipart/form-data'>
                                                <div class="fileinput fileinput-new" data-provides="fileinput">
                                                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                                        <img style="width: 100%;height: auto;" src="<%=request.getContextPath()%>/js/static/images/no_img.png" alt="" />
                                                    </div>
                                                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                    <div style="float: right;margin: 10px 20px;">
                                                <span class="btn btn-primary btn-file btn-danger">
                                                    <span class="fileinput-new">选择文件</span>
                                                    <span class="fileinput-exists">换一张</span>
                                                    <input type="file" class="imgfile" name="pic1" class="picID" accept="image/gif,image/jpeg,image/x-png"/>
                                                </span>
                                                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>

                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">法人身份证明背面：</td>
                                    <td>
                                        <form>
                                            <div style="float: left;" class="form-group" class="uploadForm" enctype='multipart/form-data'>
                                                <div class="fileinput fileinput-new" data-provides="fileinput">
                                                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                                        <img style="width: 100%;height: auto;" src="<%=request.getContextPath()%>/js/static/images/no_img.png" alt="" />
                                                    </div>
                                                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                    <div style="float: right;margin: 10px 20px;">
                                                <span class="btn btn-primary btn-file btn-danger">
                                                    <span class="fileinput-new">选择文件</span>
                                                    <span class="fileinput-exists">换一张</span>
                                                    <input type="file" class="imgfile" name="pic1" class="picID" accept="image/gif,image/jpeg,image/x-png"/>
                                                </span>
                                                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>

                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-right">开户许可证电子档：</td>
                                    <td>
                                        <form>
                                            <div style="float: left;" class="form-group" class="uploadForm" enctype='multipart/form-data'>
                                                <div class="fileinput fileinput-new" data-provides="fileinput">
                                                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                                        <img style="width: 100%;height: auto;" src="<%=request.getContextPath()%>/js/static/images/no_img.png" alt="" />
                                                    </div>
                                                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                    <div style="float: right;margin: 10px 20px;">
                                                <span class="btn btn-primary btn-file btn-danger">
                                                    <span class="fileinput-new">选择文件</span>
                                                    <span class="fileinput-exists">换一张</span>
                                                    <input type="file" class="imgfile" name="pic1" class="picID" accept="image/gif,image/jpeg,image/x-png"/>
                                                </span>
                                                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>

                                    </td>
                                </tr>
                                </tbody>
                            </table>
                    </div>
                </div>
                <button class="btn btn-danger col-xs-offset-3" style="width: 120px;" onclick="updateInformation()">确定</button>
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
        $('#load').load('<%=request.getContextPath()%>/procurementMain/zhxx.action')
    })



    function updateInformation(){
        $.ajax({
            url:'<%=request.getContextPath()%>/procurementMain/cupdateInformation.action',
            type:'post',
            dataType:'json',
            data:$("#updateForm").serialize(),
            success:function(data){
            	alert("修改成功")
            	setTimeout("$('#load').load('<%=request.getContextPath()%>/procurementMain/zhxx.action')",500);
            },
        });
    }
    var   szhy = '${information.entDocumentType}'
    if(szhy==0){
        $('.three_no_certificates').show();
        $('tr.three_no_certificates>td>input:last-of-type').attr('disabled',true);
        $('.three_certificates').hide();

    }else if(szhy==1){
        $('.three_no_certificates').hide();
        $('.three_certificates').show();
        $('tr.three_certificates>td>input:last-of-type').attr('disabled',true);
    }
</script>
</html>
