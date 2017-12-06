
var pathName=window.document.location.pathname;
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var a = '+<%=request.getContextPath()%>+';
// alert(a)
// alert(projectName)
// alert(pathName)
$(function(){
    $.ajax({cache: false});
    //采购方
    $('#one').click(function(){
        $('#load').load('/procurementMain/zhxx.action')
    })
    $('#xtsy').click(function(){
        $('#load').load('/procurementMain/xtsy.action')
    })
    $('#syxgl').click(function(){
        $('#load').load('/procurementMain/syxgl.action')
    });
    $(document).on('click','#htqy',function(e){
        $('#load').load('/procurementMain/htqy.action?rd='+new Date().getTime());
    });
    // $('#htqy').click(function(){
    //     $('#load').load(projectName+'/procurementMain/htqy.action?rd='+time());
    // })
    $('#ddgl').click(function(){
        $('#load').load('/procurementMain/ddgl.action')
    })
    $('#cwgl').click(function(){
        $('#load').load('/procurementMain/cwgl.action')
    })
    $('#fpgl').click(function(){
        $('#load').load('/procurementMain/fpgl.action')
    })
    $('#setting').click(function(){
        $('#load').load('/procurementMain/setting.action')
    })
    $('#ukeyZs').click(function(){
        $('#load').load('/procurementMain/ukeyZs.action')
    })

    //贸易方
    $('#one2').click(function(){
        $('#load').load('/captialMain/zhxx.action')
    })
    $('#xtsy2').click(function(){
        $('#load').load('/tradeMain/xtsy.action')
    })
    $('#syxgl2').click(function(){
        $('#load').load('/tradeMain/syxgl.action')
    })
    $('#htqy2').click(function(){
        $('#load').load('/tradeMain/htqy.action')
    })
    $('#ddgl2').click(function(){
        $('#load').load('/tradeMain/ddgl.action')
    })
    $('#cwgl2').click(function(){
        $('#load').load('/tradeMain/cwgl.action')
    })
    $('#fpgl2').click(function(){
        $('#load').load('/tradeMain/fpgl.action')
    })
    $('#setting2').click(function(){
        $('#load').load('/tradeMain/setting.action')
    })
    $('#ukeyZs2').click(function(){
        $('#load').load('/tradeMain/ukeyZs.action')
    })

    //资方
    $('#one3').click(function(){
        $('#load').load('/captialMain/zhxx.action')
    })
    $('#xtsy3').click(function(){
        $('#load').load('/captialMain/xtsy.action')
    })
    $('#syxgl3').click(function(){
        $('#load').load('/captialMain/syxgl.action')
    })
    $('#cwgl3').click(function(){
        $('#load').load('/captialMain/cwgl.action')
    })
    $('#setting3').click(function(){
        $('#load').load('/captialMain/setting.action')
    })
    $('#ukeyZs3').click(function(){
        $('#load').load('/captialMain/ukeyZs.action')
    })
    $('#dkgl3').click(function(){
        $('#load').load('/captialMain/dkgl.action')
    })
    $('#hkgl3').click(function(){
        $('#load').load('/captialMain/hkgl.action')
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






