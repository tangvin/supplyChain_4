<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<%=request.getContextPath()%>/js/uploadify/uploadify.css" rel="stylesheet" >

<script type="text/javascript" src="<%=request.getContextPath() %>/js/uploadify/jquery.uploadify.min.js"></script>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row row_zhxx'>
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/captialMain/captialMain.action">系统首页</a>
            <span>></span>
            <a href="#" id="zhxx">资料维护</a>
            <span>></span>
            <a href="#">企业认证</a>
        </div>
        <div class="col-xs-12">
            <div class="jbxx">
                <div class="row jbxx_row jbxx_zlbj">
                    <div class="col-xs-8">
                        <h5>企业证明资料</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-7 col-xs-offset-1">
                        <table class="table table_one">
                            <tbody>
                            <tr>
                                <td>企业证件类型:</td>
                                <td>
                                    <select class="form-control qyrz_select">
                                        <option value="">全部</option>
                                        <option value="0">三证合一</option>
                                        <option value="1">非三证合一</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>社会统一信用代码：</td>
                                <td>
                                    <form>
                                        <div style="float: left;" class="uploadForm" enctype='multipart/form-data'>
                                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                                    <img style="width: 100%;height: auto;" src="<%=request.getContextPath()%>/js/static/images/card_minsheng@1x.png" alt="" />
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                <div style="float: right;margin: 10px 20px;">

                                                    <div id="fileQueue" style="width:500px;">
                                                    </div>
                                                    <input type="file" id="userImg" name="userImg"/>
                                                    <div id="showImg">
                                                        <img src="D://uploadImgPath//4e09b79c-ab4f-473b-9f9b-2c68606b6931_.jpg" style='width:100px'/>
                                                    </div>

                                                <span class="btn btn-primary btn-file">
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
                                <td>工商登记注册号电子档：</td>
                                <td>
                                    <form>
                                        <div style="float: left;" class="uploadForm" enctype='multipart/form-data'>
                                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                                    <img style="width: 100%;height: auto;max-height: 140px;" src="<%=request.getContextPath()%>/js/static/images/card_minsheng@1x.png" alt="" />
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                <div style="float: right;margin: 10px 20px;">
                                                    <span class="btn btn-primary btn-file">
                                                        <span class="fileinput-new">选择文件</span>
                                                        <span class="fileinput-exists">换一张</span>
                                                        <input type="file" name="pic1" class="picID" accept="image/gif,image/jpeg,image/x-png"/>
                                                    </span>
                                                    <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                                                </div>
                                            </div>
                                        </div>
                                    </form>

                                </td>
                            </tr>
                            <tr>
                                <td>税务登记号电子档：</td>
                                <td>
                                    <form>
                                        <div style="float: left;" class="form-group" class="uploadForm" enctype='multipart/form-data'>
                                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                                    <img style="width: 100%;height: auto;" src="<%=request.getContextPath()%>/js/static/images/card_minsheng@1x.png" alt="" />
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                <div style="float: right;margin: 10px 20px;">
                                                <span class="btn btn-primary btn-file">
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
                                <td>组织机构代码电子档：</td>
                                <td>
                                    <form>
                                        <div style="float: left;" class="form-group" class="uploadForm" enctype='multipart/form-data'>
                                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                                    <img style="width: 100%;height: auto;" src="<%=request.getContextPath()%>/js/static/images/card_minsheng@1x.png" alt="" />
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                <div style="float: right;margin: 10px 20px;">
                                                <span class="btn btn-primary btn-file">
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
                                <td>开户许可证电子档：</td>
                                <td>
                                    <form>
                                        <div style="float: left;" class="form-group" class="uploadForm" enctype='multipart/form-data'>
                                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                                    <img style="width: 100%;height: auto;" src="<%=request.getContextPath()%>/js/static/images/card_minsheng@1x.png" alt="" />
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                <div style="float: right;margin: 10px 20px;">
                                                <span class="btn btn-primary btn-file">
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
            </div>


            <div class="jbxx">
                <div class="row jbxx_row jbxx_zlbj">
                    <div class="col-xs-8">
                        <h5>法定代表人证明资料</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-7 col-xs-offset-1">
                        <table class="table table_one">
                            <tbody>
                            <tr>
                                <td>法定代表人证件类型:</td>
                                <td>
                                    <%--0居民身份证、1护照、2港澳居民来往内地通行证、3台湾居民来往大陆通行证--%>
                                    <select class="form-control qyrz_select">
                                        <option value="">全部</option>
                                        <option value="0">居民身份证</option>
                                        <option value="1">护照</option>
                                        <option value="2">港澳居民来往内地通行证</option>
                                        <option value="3">台湾居民来往大陆通行证</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>法人身份证明正面：</td>
                                <td>
                                    <form>
                                        <div style="float: left;" class="uploadForm" enctype='multipart/form-data'>
                                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                                    <img style="width: 100%;height: auto;" src="<%=request.getContextPath()%>/js/static/images/card_minsheng@1x.png" alt="" />
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                <div style="float: right;margin: 10px 20px;">
                                                <span class="btn btn-primary btn-file">
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
                                <td>法人身份证明背面：</td>
                                <td>
                                    <form>
                                        <div style="float: left;" class="uploadForm" enctype='multipart/form-data'>
                                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                                    <img style="width: 100%;height: auto;max-height: 140px;" src="<%=request.getContextPath()%>/js/static/images/card_minsheng@1x.png" alt="" />
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                <div style="float: right;margin: 10px 20px;">
                                                    <span class="btn btn-primary btn-file">
                                                        <span class="fileinput-new">选择文件</span>
                                                        <span class="fileinput-exists">换一张</span>
                                                        <input type="file" name="pic1" class="picID" accept="image/gif,image/jpeg,image/x-png"/>
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
            </div>
        </div>
        <button type="button" id="uploadSubmit" class="btn btn-info col-xs-offset-4">提交</button>
    </div>
</div>
</body>
<script>
    $('#uploadSubmit').click(function () {
        var aaa=$('.fileinput-preview>img')
        for(var i=0;i<aaa.length;i++){
            console.log(i,aaa[i].src)
        }


//        $.ajax({
//            url: 'xxx/xxx',
//            type: 'POST',
//            data: data,
//            async: false,
//            cache: false,
//            contentType: false,
//            processData: false,
//            success: function (data) {
//                console.log(data);
//                if(data.status){
//                    console.log('upload success');
//                }else{
//                    console.log(data.message);
//                }
//            },
//            error: function (data) {
//                console.log(data.status);
//            }
//        });
    });

    $('#zhxx').click(function(){
        $('#load').load('<%=request.getContextPath()%>/captialMain/zhxx.action')
    })


$(function(){

    /*上传相册*/
    $("#userImg").uploadify({
        //前台请求后台的url 不可忽略的参数
        'uploader' :"<%=request.getContextPath()%>/captialInformation/upLoInsert.action",
        //插件自带 不可忽略的参数
        'swf' : '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
        //撤销按钮的图片路径
        //    'cancelImg' : '<%=request.getContextPath() %>/js/uploadify/uploadify-cancel.png',
        //如果为true 为自动上传 在文件后 为false 那么它就要我们自己手动点上传按钮
        'auto' : true,
        //可以同时选择多个文件 默认为true 不可忽略
        'multi' : true,
        //向后台传递的参数
        //'formDate':{'flag':1},
        'method':'POST',
        //允许同时上传文件的最大数量
        'uploadLimit':10,
        //给div的进度条加背景 不可忽略
        'queueID' : 'fileQueue',
        //给上传按钮设置文字
        'buttonText' : '选取相册',
        //上传后队列是否消失
        'removeCompleted' : true,
        'removeTimeout' : 1,
        // action中接收文件的全局变量名  与 input标签的name属性一致
        'fileObjName' : 'userImg',
        //上传文件的类型
        'fileTypeExts' : '*.jpg;*.jpge;*.gif;*.png',
        //文件类型描述
        'fileTypeDesc':'只允许上传图片',
        //struts2上传文件默认2MB
        'fileSizeLimit' : '16MB',
        //   文件上传成功后调用的函数
        'onUploadSuccess' : function(file, data, response) {
            alert(data)
            //data 文件存放路径+上传文件名称
            var src = 'D:/uploadImgPath/'+data;
//            var src = sys.contextPath+"/"+data;
            $("#showImg").append("<img src='"+src+"' style='width:100px'/>");
        },
        //   文件上传失败后调用的函数
        'onUploadError' : function(file, data, response) {
            alert("上传失败");
        },
        //当用户选择的文件不符合规定时触发
        'onSelectError':function(file, errorCode, errorMsg){
            //alert(errorCode+"---"+errorMsg);
            if (errorCode == -100) {
                //alert("选择文件个数超过10个，上传失败");
                this.queueData.errorMsg = "选择文件个数超过10个，上传失败";
            }
            if (errorCode == -130) {
                this.queueData.errorMsg = "选择文件类型不匹配，上传失败";
            }
        }
    });

});


</script>
</html>