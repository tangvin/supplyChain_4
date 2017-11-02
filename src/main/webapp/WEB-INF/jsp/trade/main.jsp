<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2017/10/30
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/include.jsp"%>
<html>
<head>
    <title>贸易商系统首页</title>
</head>
<body>
<div id="mainLayout" class="easyui-layout hidden" data-options="fit: true">
    <div id="northPanel" data-options="region: 'north',title:' ', border: false" style="height: 100px; overflow: hidden;">
        <div id="topbar" class="top-bar">
            <div class="top-bar-left">
                <h1 style="margin-left: 10px; margin-top: 10px">贸易商<span style="color: #3F4752">管理系统</span></h1>
            </div>
            <div class="top-bar-right">
                <div id="timerSpan"></div>
                <div id="themeSpan">
                    <%--<a id="btnHideNorth" class="easyui-linkbutton" data-options="plain: true, iconCls: 'layout-button-up'"></a>--%>
                </div>
            </div>
        </div>
    </div>

    <div data-options="region:'west',title:'菜单导航栏',split:true, iconCls: 'icon-standard-map',minWidth: 200, maxWidth: 400" style="width: 220px; padding: 1px;"></div>
    <div data-options="region:'center'">
        <div id="mainTabs" class="easyui-tabs" data-options="fit: true, border: false, showOption: true, enableNewTabMenu: true, tools: '#mainTabs_tools', enableJumpTabMenu: true">
            <div id="homePanel" data-options="title: '主页', iconCls: 'icon-hamburg-home'">
                <div class="easyui-layout" data-options="fit: true">
                    <div data-options="region: 'north', split: false, border: false" style="height: 33px;">
                        首页内容
                    </div>
                    <div data-options="region: 'center', border: false" style="overflow: hidden;">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
