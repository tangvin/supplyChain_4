<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .yhk_two_form{
            margin-top:40px;
        }
        .yhk_two_form div label{
            line-height: 30px;
            font-weight: normal;
        }
        .yhk_two_form div span{
            line-height: 30px;
        }
        .yhk_two_form div{
            margin-bottom:10px;
        }
        #yhk_next_two_bu{
            margin-top:30px;
            width:120px;
        }
    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row row_zhxx'>
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
            <span>></span>
            <a href="#" id="zhxx">资料维护</a>
            <span>></span>
            <a href="#">添加银行卡</a>
        </div>
    </div>
    <div class="col-xs-12">
        <form class='form-inline yhk_two_form col-xs-10 col-xs-offset-1'>
            <div class="row">
                <label class="col-xs-2 text-center">卡类型：</label>
                <span class="col-xs-4"> 中国民生银行储蓄卡</span>
            </div>
            <div class="row">
                <label class="col-xs-2 text-center">手机号：</label>
                <span class="col-xs-4">18211083457</span>
            </div>
            <div class="row">
                <label class="col-xs-2 text-center">同意<span style="color: blue;margin-left: 5px">服务协议</span></label>
            </div>
        </form>
        <a href="#" id="bankThree"><button class="btn col-xs-offset-2" id="yhk_next_two_bu">下一步</button></a>
    </div>
</div>
</body>
<script>
$('#zhxx').click(function(){
    $('#load').load('<%=request.getContextPath()%>/procurementMain/zhxx.action')
})
$('#bankThree').click(function(){
    $('#load').load('<%=request.getContextPath()%>/procurementMain/bankThree.action')
})

</script>
</html>