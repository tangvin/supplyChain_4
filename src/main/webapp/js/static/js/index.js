
var pathName=window.document.location.pathname;
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);

$(function(){
    //采购方
    $('#one').click(function(){
        $('#load').load(projectName+'/procurementMain/zhxx.action')
    })
    $('#xtsy').click(function(){
        $('#load').load(projectName+'/procurementMain/xtsy.action')
    })
    $('#syxgl').click(function(){
        $('#load').load(projectName+'/procurementMain/syxgl.action')
    })
    $('#htqy').click(function(){
        $('#load').load(projectName+'/procurementMain/htqy.action')
    })
    $('#ddgl').click(function(){
        $('#load').load(projectName+'/procurementMain/ddgl.action')
    })
    $('#cwgl').click(function(){
        $('#load').load(projectName+'/procurementMain/cwgl.action')
    })
    $('#fpgl').click(function(){
        $('#load').load(projectName+'/procurementMain/fpgl.action')
    })
    $('#setting').click(function(){
        $('#load').load(projectName+'/procurementMain/setting.action')
    })
    $('#ukeyZs').click(function(){
        $('#load').load(projectName+'/procurementMain/ukeyZs.action')
    })

    //贸易方
    $('#one2').click(function(){
        $('#load').load(projectName+'/tradeMain/zhxx.action')
    })
    $('#xtsy2').click(function(){
        $('#load').load(projectName+'/tradeMain/xtsy.action')
    })
    $('#syxgl2').click(function(){
        $('#load').load(projectName+'/tradeMain/syxgl.action')
    })
    $('#htqy2').click(function(){
        $('#load').load(projectName+'/tradeMain/htqy.action')
    })
    $('#ddgl2').click(function(){
        $('#load').load(projectName+'/tradeMain/ddgl.action')
    })
    $('#cwgl2').click(function(){
        $('#load').load(projectName+'/tradeMain/cwgl.action')
    })
    $('#fpgl2').click(function(){
        $('#load').load(projectName+'/tradeMain/fpgl.action')
    })
    $('#setting2').click(function(){
        $('#load').load(projectName+'/tradeMain/setting.action')
    })
    $('#ukeyZs2').click(function(){
        $('#load').load(projectName+'/tradeMain/ukeyZs.action')
    })

    //资方
    $('#one3').click(function(){
        $('#load').load(projectName+'/captialMain/zhxx.action')
    })
    $('#xtsy3').click(function(){
        $('#load').load(projectName+'/captialMain/xtsy.action')
    })
    $('#syxgl3').click(function(){
        $('#load').load(projectName+'/captialMain/syxgl.action')
    })
    $('#cwgl3').click(function(){
        $('#load').load(projectName+'/captialMain/cwgl.action')
    })
    $('#setting3').click(function(){
        $('#load').load(projectName+'/captialMain/setting.action')
    })
    $('#ukeyZs3').click(function(){
        $('#load').load(projectName+'/captialMain/ukeyZs.action')
    })
    $('#dkgl3').click(function(){
        $('#load').load(projectName+'/captialMain/dkgl.action')
    })
    $('#hkgl3').click(function(){
        $('#load').load(projectName+'/captialMain/hkgl.action')
    })
    // $('#exit3').click(function(){
    //     $('#load').load(projectName+'/account/exitAccount.action')
    // })
})



//alert(document.documentElement.clientHeight)



//console.log(document.getElementById("mm2").clientHeight,document.getElementById("mm1").clientHeight)
////
//if(document.getElementById("mm2").clientHeight<document.getElementById("mm1").clientHeight){
//
//    document.getElementById("mm1").style.height=document.getElementById("mm2").offsetHeight+"px";
//
//}
//else if(document.getElementById("mm2").clientHeight>document.getElementById("mm1").clientHeight){
//    document.getElementById("mm2").style.height=document.getElementById("mm1").offsetHeight+"px";
//}
//else{
//    document.getElementById("mm1").style.height=document.getElementById("mm2").offsetHeight+"px";
//}

//function $(id){
//    return document.getElementById(id)
//}
//function getHeight() {
//    if ($("wyb_left").offsetHeight>=$("wyb_right").offsetHeight){
//        $("wyb_right").style.height=$("wyb_left").offsetHeight + "px";
//    }
//    else{
//        $("wyb_left").style.height=$("wyb_right").offsetHeight + "px";
//    }
//
//}
//window.onload = function() {
//    getHeight();
//}






