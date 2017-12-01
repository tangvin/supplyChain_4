<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class='col-xs-12'>
    <div class='row row_zhxx'>
        <div class="col-xs-12 zlxx_top">
            <a href="<%=request.getContextPath()%>/procurementMain/procurementMain.action">系统首页</a>
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
                                        <option>全部</option>
                                        <option>全部1</option>
                                        <option>全部2</option>
                                        <option>全部3</option>
                                        <option>全部4</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>社会同意信用代码：</td>
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
                                <td>社会同意信用代码：</td>
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
                                <td>社会同意信用代码：</td>
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
                                <td>社会同意信用代码：</td>
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
                                <td>社会同意信用代码：</td>
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
                                <td>企业证件类型:</td>
                                <td>
                                    <select class="form-control qyrz_select">
                                        <option>全部</option>
                                        <option>全部1</option>
                                        <option>全部2</option>
                                        <option>全部3</option>
                                        <option>全部4</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>社会同意信用代码：</td>
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
                                <td>社会同意信用代码：</td>
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
                                <td>社会同意信用代码：</td>
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
        $('#load').load('<%=request.getContextPath()%>/procurementMain/zhxx.action')
    })

</script>
</html>