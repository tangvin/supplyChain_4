<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%String contextPath = request.getContextPath();%>

    
<!-- 引入 CSS -->
<link rel="stylesheet" type="text/css" href="/js/easyui1.4.5/themes/icon.css">
<!-- 主题 css -->
<link   style="text/css" href="<%=request.getContextPath() %>/js/easyui1.4.5/themes/default/easyui.css" rel="stylesheet"   />
<!-- 图标 css  -->
<link   style="text/css" rel="stylesheet"  href="<%=request.getContextPath() %>/js/easyui1.4.5/themes/icon.css"  />

<!-- css渲染页面效果  -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/uploadify/uploadify.css">
<link href="<%=request.getContextPath() %>/js/easyui1.4.5/icons/icon-all.css" rel="stylesheet" style="text/css" />
<!-- 引入JQuery -->
<!-- 引入JQuery 库-->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/easyui1.4.5/jquery.min.js"></script>


<!-- uploadify库 -->
<script src="<%=request.getContextPath()%>/js/uploadify/jquery.uploadify.min.js"></script>

<!-- 引入my97 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/my97/WdatePicker.js"></script>



<!-- 引入EasyUI库-->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/easyui1.4.5/jquery.easyui.min.js"></script>
<!-- 引入EasyUI语言库-->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/easyui1.4.5/locale/easyui-lang-zh_CN.js"></script>


<%-- 引入扩展图标 --%>
<link rel="stylesheet" href="<%=contextPath%>/style/extIcon.css" type="text/css">

<%-- 引入自定义样式 --%>
<link rel="stylesheet" href="<%=contextPath%>/style/extCss.css" type="text/css">
    




<script type="text/javascript">
var sys = sys || {};
sys.contextPath = '<%=contextPath%>';
sys.basePath = '<%=basePath%>';
</script>

