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
            <a href="<%=request.getContextPath()%>/captialMain/captialMain.action">系统首页</a>
            <span> > </span>
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
                                        <button type="button" class="btn btn-danger" id="updateInformation">编辑</button>
                                    </div>
                                </div>
                                <div class="row">
                                        <table class="table table_one">
                                            <tbody>
                                            <tr>
                                                <td style="width: 20%;" class="text-right">企业身份：</td>
                                                <td class="text-left">
                                                    <%--0采购方、1贸易方、2资方--%>
                                                <c:if test="${information.entIdentity == 0}">采购方
                                                    
                                                </c:if>
                                                <c:if test="${information.entIdentity == 1}">贸易方
                                                   
                                                </c:if>
                                                <c:if test="${information.entIdentity == 2}">资方
                                                  
                                                </c:if>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">企业名称：</td>
                                                <td class="text-left">
                                                    <span>${information.entName}</span>
                                                    <c:if test="${information.certificationStatus == 0}">
                                                        <a href="#"><span class="drz" id="zlrz">待认证</span></a>
                                                    </c:if>
                                                    <c:if test="${information.certificationStatus == 1}">
                                                        <span class="drzs">已认证</span>
                                                    </c:if>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">社会统一信用代码：</td>
                                                <td class="text-left">${information.entCreditCode}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">工商登记注册号：</td>
                                                <td class="text-left">${information.registrationNumber}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">税务登记号：</td>
                                                <td class="text-left">${information.taxRegistrationNumber}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">组织机构代码：</td>
                                                <td class="text-left">${information.institutionCode}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">法定代表人：</td>
                                                <td class="text-left">${information.representative}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">法定代表人证件类型：</td>
                                                <%--0居民身份证、1护照、2港澳居民来往内地通行证、3台湾居民来往大陆通行证--%>
                                                <td class="text-left">
                                                    <c:if test="${information.representativeType==0}">
                                                        居民身份证
                                                    </c:if>
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
                                                <td class="text-right">法定代表人证件号码：</td>
                                                <td class="text-left">${information.representativeNum}</td>
                                            </tr><tr>
                                                <td class="text-right">固定电话：</td>
                                                <td class="text-left">${information.telephone}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">省市区域：</td>
                                                <td class="text-left">${information.municipality}${information.city}${information.county}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">详细地址：</td>
                                                <td class="text-left">${information.address}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">企业联系人：</td>
                                                <td class="text-left">${information.businessContact}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">企业联系人手机：</td>
                                                <td class="text-left">${information.mobilePhone}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">联系人电子邮件：</td>
                                                <td class="text-left">${information.emailAddress}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">邮编：</td>
                                                <td class="text-left">${information.zipCode}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">网址：</td>
                                                <td class="text-left">${information.webSite}</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                </div>
                            </div>
                            <div class="jbxx jbxx1">
                                <div class="row jbxx_row">
                                    <div class="col-xs-8">
                                        <h5>高级资料</h5>
                                    </div>
                                </div>
                                <div class="row">
                                        <table class="table table_one">
                                            <tbody>
                                            <tr>
                                                <td style="width: 20%;" class="text-right">注册资本：</td>
                                                <td class="text-left">${information.webSite}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">主要股东：</td>
                                                <td class="text-left"><span>张先生 | 李先生 | 王女士${information.majorShareholder}</span></td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">经营范围：</td>
                                                <td class="text-left">${information.businessScope}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">登记机关：</td>
                                                <td class="text-left">${information.registrationAuthority}</td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">社会统一信用代码电子档：</td>
                                                <td class="text-left"><img src="<%=request.getContextPath()%>/js/static/images/no_img.png" class="img-responsive jbxx_img"></td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">工商登记注册电子档：</td>
                                                <td class="text-left"><img src="<%=request.getContextPath()%>/js/static/images/no_img.png" class="img-responsive jbxx_img"></td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">税务登记号电子档：</td>
                                                <td class="text-left"><img src="<%=request.getContextPath()%>/js/static/images/no_img.png" class="img-responsive jbxx_img"></td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">组织机构代码电子档：</td>
                                                <td class="text-left"><img src="<%=request.getContextPath()%>/js/static/images/no_img.png" class="img-responsive jbxx_img"></td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">法人身份证明正面：</td>
                                                <td class="text-left"><img src="<%=request.getContextPath()%>/js/static/images/no_img.png" class="img-responsive jbxx_img"></td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">法人身份证明背面：</td>
                                                <td class="text-left"><img src="<%=request.getContextPath()%>/js/static/images/no_img.png" class="img-responsive jbxx_img"></td>
                                            </tr>
                                            <tr>
                                                <td class="text-right">开户许可证电子档：</td>
                                                <td class="text-left"><img src="<%=request.getContextPath()%>/js/static/images/no_img.png" class="img-responsive jbxx_img"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                </div>
                            </div>
                        </div>
                        <!--基本资料 结束-->
                        <!--账户安全 开始-->
                        <div class="tab-pane" id="profile">
                            <%--<h5>修改密码</h5>--%>
                            <h5></h5>
                            <div class="row">
                                <div class="col-xs-10">
                                    <form class="form-horizontal" role="form" id ="f">
                                        <div class="form-group">
                                            <label class="col-xs-2 control-label"><span class="xingxing">*</span>验证码：</label>
                                            <div class="col-xs-8 senCode">
                                                <%--<input type="text" class="form-control col-xs-4" id="phone" name="phone" placeholder="输入手机号">--%>
                                                <input type="text" id="senCode" placeholder="输入验证码" class="form-control col-xs-4" name="senCode" size="6"/>
                                                <input id="btnSendCode" type="button" value="发送验证码" onclick="sendMessage()" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="newpwd" class="col-xs-2 control-label"><span class="xingxing">*</span>新密码：</label>
                                            <div class="col-xs-8">
                                                <input type="password" class="form-control" id="newpwd" name="newpwd">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="confirm" class="col-xs-2 control-label"><span class="xingxing">*</span>确认密码：</label>
                                            <div class="col-xs-8">
                                                <input type="password" class="form-control" id="confirm" name="confirm">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-xs-2"></div>
                                            <div class="col-xs-8">
                                                <button type="button" class="btn  btn-danger aq_qr_but" id="upda">确认</button>
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
                                <form class="form-inline khh_form khh_form1" id="informationForm">
                                    <div class="form-group form-group1">
                                        <label for="tripartiteDepositBank">开户行</label>
                                        <input type="text" class="form-control" name="tripartiteDepositBank" id="tripartiteDepositBank">
                                    </div>
                                    <div class="form-group form-group1">
                                        <label for="entName">户主</label>
                                        <input type="email" class="form-control" name="entName" id="entName">
                                    </div>
                                    <button type="button" class="btn  btn-danger" onclick="search()">查询</button>
                                    <button type="button" class="btn  btn-default" onclick="reset()">重置</button>
                                </form>
                            </div>
                            <!--三方账户 开户行结束-->
                            <!--三方账户 分页开始-->
                            <div class="panel-body" style="padding-bottom:0px;">
                                <table id="incormationTable" class="cj_table"></table>
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

    $('#updateInformation').click(function(){
        $('#load').load('<%=request.getContextPath()%>/captialMain/updateInformation.action')
    })
    $('#zlrz').click(function(){
        $('#load').load('<%=request.getContextPath()%>/captialMain/zlrz.action')
    })

    var InterValObj; //timer变量，控制时间
    var count = 60; //间隔函数，1秒执行
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
            $("#btnSendCode").val( + curCount + "秒后重新获取验证码");
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
            $("#btnSendCode").val( curCount + "秒秒后重新获取验证码");
        }
    }

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


    $(function() {
        $("#upda").click(function () {
            $.ajax({
                url: "<%=request.getContextPath()%>/password/changePwd.action",
                type: 'post',
                data: $("#f").serialize(),
                dataType: "json",
                success: function (data) {
                    alert(data);
                    setTimeout("$('#load').load('<%=request.getContextPath()%>/captialMain/messages.action')",500);
                }
            });
        });
    })

    //授信分页查询
    $(function(){
        $("#incormationTable").bootstrapTable({
            columns:[
                {field:'tripartiteDepositBank',title:'开户行'},
                {field:'entName',title:'户主（采购方）'},
                {field:'tripartiteAccountNumber',title:'账号'},
                {field:'tripartiteBalance',title:'余额（元）'},
                {field:'tripartiteAvailableBalance',title:'可用余额（元）'},
                {field:'tripartiteAccountOpentime',title:'账号开通时间',
                    formatter:function(value,row,index){
                        return ConvertToDate(value)
                    }
                },
                {field:'tripartiteAccountOpenpeople',title:'账号开通人'},
                {field:'tripartiteAmountCreateTime',title:'创建时间',
                    formatter:function(value,row,index){
                        return ConvertToDate(value)
                    }
                },
                {field:'tripartiteAmountCreatePeople',title:'创建人'}
            ],
            url:'<%=request.getContextPath()%>/captialTripartite/tripartiteSelect.action',
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
            entName:$("#entName").val()
        };
        return temp;
    }
    //搜索
    function search(){
        $("#incormationTable").bootstrapTable('refresh');
    }
    //重置查询
    function reset(){
        $("#informationForm").form('reset');
        crownSearch();
    }

    function ConvertToDate(datestr) {
        var date=new Date(datestr);
        var year=date.getFullYear();
        var month=date.getMonth()+1;
        if(month < 10){
            month = "0"+month
        }else{
            month = ''+month
        }
        var day=date.getDate();
        if(day < 10){
            day = "0"+day
        }else{
            day = ''+day
        }
        var hours = date.getHours()
        if(hours < 10){
            hours = "0"+hours
        }else{
            hours = ''+hours
        }
        var minutes = date.getMinutes(); //获取当前分钟数(0-59)
        if(minutes < 10){
            minutes = "0"+minutes
        }else{
            minutes = ''+minutes
        }
        var seconds = date.getSeconds();
        if(seconds < 10){
            seconds = "0"+seconds
        }else{
            seconds = ''+seconds
        }
        return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
    }

</script>


</html>