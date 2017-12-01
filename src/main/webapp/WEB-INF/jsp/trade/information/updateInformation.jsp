<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                <td class="mys">贸易商</td>
                            </tr>
                            <tr>
                                <td>企业名称:</td>
                                <td><input type="text" class="form-control" disabled value="12312"></td>
                            </tr>
                            <tr>
                                <td>企业证件类型:</td>
                                <td>
                                    <select class="form-control zlbj_select">
                                        <option>全部</option>
                                        <option>全部1</option>
                                        <option>全部2</option>
                                        <option>全部3</option>
                                        <option>全部4</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>社会统一信用代码：</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>工商登记注册号：</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>税务登记号：</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>组织机构代码：</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>法定代表人：</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>法定代表人证件类型：</td>
                                <td>
                                    <select class="form-control zlbj_select">
                                        <option>全部</option>
                                        <option>全部1</option>
                                        <option>全部2</option>
                                        <option>全部3</option>
                                        <option>全部4</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>法定代表人证件号码：</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>固定电话：</td>
                                <td><input type="text" class="form-control" value="123-12398-1263"></td>
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
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>企业联系人：</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>企业联系人手机：</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>联系人电子邮件：</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>邮编：</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>网址：</td>
                                <td><input type="text" class="form-control"></td>
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
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>主要股东:</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>社会统一信用代码：</td>
                                <td><input type="text" class="form-control"></td>
                            </tr>
                            <tr>
                                <td>登记机关：</td>
                                <td><textarea style="width: 250px;" class="form-control" rows="3"></textarea></td>
                            </tr>
                            <tr>
                                <td>社会统一信用代码：</td>
                                <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/card_minsheng@1x.png"></td>
                            </tr>
                            <tr>
                                <td>社会统一信用代码：</td>
                                <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/card_minsheng@1x.png"></td>
                            </tr>
                            <tr>
                                <td>社会统一信用代码：</td>
                                <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/card_minsheng@1x.png"></td>
                            </tr>
                            <tr>
                                <td>社会统一信用代码：</td>
                                <td class="mys"><img src="<%=request.getContextPath()%>/js/static/images/card_minsheng@1x.png"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <button class="btn col-xs-offset-3" style="width: 120px;">确定</button>
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
    })
</script>
</html>
