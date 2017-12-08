<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加银行卡</title>
    <style>
        .yhk_form{
            margin-top:40px;
        }
        .yhk_form div label{
            line-height: 40px;
            font-weight: normal;
        }
        .yhk_form div{
            margin-bottom:20px;
        }
        .yhk_form div select {
            width:250px!important;
        }
        .yhk_form div input{
            width:250px!important;
        }
    </style>
</head>
<body>
<div class='col-xs-12'>
    <div class='row row_zhxx'>
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/tradeMain/tradeMain.action">系统首页</a>
            <span>></span>
            <a id="zhxx">资料维护</a>
            <span>></span>
            <a href="#">添加银行卡</a>
        </div>
    </div>
    <div class="col-xs-12">
        <form id="bankCardId" class='form-inline yhk_form col-xs-10 col-xs-offset-1'>
            <div class="row">
                <label class="col-xs-2 text-center">银行卡类型</label>
                <select class="selectpicker form-control" name="bankAccountDepositBank">
                    <option>中国邮政银行</option>
                    <option>中国建设银行</option>
                    <option>中国光大银行</option>
                </select>
            </div>
            <div class="row">
                <label class="col-xs-2 text-center">持卡人</label>
                <input type="text" id="ckr" name="bankAccountCreditHolder" class="form-control col-xs-6" placeholder="输入持卡人">
            </div>
            <div class="row">
                <label class="col-xs-2 text-center">卡号</label>
                <!--<input type="text" id="kh" class="form-control" placeholder="请输入卡号">-->
                <input type="text" class="form-control" onkeyup="www_zzjs_net(this)" onkeydown="www_zzjs_net(this)" name="bankAccountNumber" id="account">
            </div>
        </form>
        <button class="btn col-xs-offset-3" id="yhk_next_bu">下一步</button>

    </div>
</div>
</body>
<script>

    //判断银行卡格式
    function www_zzjs_net (BankNo)
    {
        if (BankNo.value == "") return;
        var account = new String (BankNo.value);
        account = account.substring(0,22); /*帐号的总数, 包括空格在内 */
        if (account.match (".[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{7}") == null)
        {
            /* 对照格式 */
            if (account.match (".[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{7}|" + ".[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{7}|" +
                    ".[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{7}|" + ".[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{7}") == null)
            {
                var accountNumeric = accountChar = "", i;
                for (i=0;i<account.length;i++)
                {
                    accountChar = account.substr (i,1);
                    if (!isNaN (accountChar) && (accountChar != " ")) accountNumeric = accountNumeric + accountChar;
                }
                account = "";
                for (i=0;i<accountNumeric.length;i++)
                { /* 可将以下空格改为-,效果也不错 */
                    if (i == 4) account = account + "-"; /* 帐号第四位数后加空格 */
                    if (i == 8) account = account + "-"; /* 帐号第八位数后加空格 */
                    if (i == 12) account = account + "-";/* 帐号第十二位后数后加空格 */
                    account = account + accountNumeric.substr (i,1)
                }
            }
        }
        else
        {
            account = " " + account.substring (1,5) + " " + account.substring (6,10) + " " + account.substring (14,18) + "-" + account.substring(18,25);
        }
        if (account != BankNo.value) BankNo.value = account;
    }
    function checkBankNo (BankNo)
    {
        if (BankNo.value == "") return;
        if (BankNo.value.match (".[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{7}") == null)
        {
            if (BankNo.value.match ("[0-9]{19}") != null)
                www_zzjs_net (BankNo)
        }}
    function checkEnterForFindListing(e){
        var characterCode;
        if(e && e.which){
            e = e;
            characterCode = e.which ;
        }
        else{
            e = event;
            characterCode = e.keyCode;
        }
        if(characterCode == 22){
            document.forms[getNetuiTagName("findListingForm")].submit();
            return false;
        }
        else{
            return true ;
        }}


    $('#yhk_next_bu').click(function () {
        if($.trim($('#ckr').val())==''){
            alert('请输入持卡人')
        }else if($.trim($('#account').val())==''){
            alert('请输入卡号')
        }else{
            $('#load').load('<%=request.getContextPath()%>/tradeMain/bankTwo.action')
        }

    })



    $('#zhxx').click(function(){
        $('#load').load('<%=request.getContextPath()%>/tradeMain/zhxx.action')
    });

    /**
     * 将当前输入的数据存到session作用域
     */
     <%--$("#yhk_next_bu").click(function () {--%>
       <%--$.ajax({--%>
           <%--url:'<%=request.getContextPath()%>/bankAccount/save.action',--%>
           <%--type:'POST',--%>
           <%--dataType:'json',--%>
           <%--data:$("#bankCardId").serialize(),--%>
           <%--success:function (data) {--%>
              <%--alert("请求下一步")--%>
           <%--}--%>
       <%--})--%>

   <%--})--%>

</script>
</html>