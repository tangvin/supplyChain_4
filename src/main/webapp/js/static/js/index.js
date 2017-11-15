
var pathName=window.document.location.pathname;
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);

$(function(){
    //采购方
    $('#one').click(function(){
        $('#load').load(projectName+'/main/zhxx.action')
    })
    $('#xtsy').click(function(){
        $('#load').load(projectName+'/main/xtsy.action')
    })
    $('#syxgl').click(function(){
        $('#load').load(projectName+'/main/syxgl.action')
    })
    $('#htqy').click(function(){
        $('#load').load(projectName+'/main/htqy.action')
    })
    //贸易方
    $('#ones').click(function(){

        $('#load').load(projectName+'/main/tradeZhxx.action')
    });
    $('#xtsys').click(function(){
        $('#load').load(projectName+'${basePath}/main/tradeXtsy.action')
    })
    $('#syxgls').click(function(){
        $('#load').load(projectName+'/main/tradeSyxgls.action')
    })
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






