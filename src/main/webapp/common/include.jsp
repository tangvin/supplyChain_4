<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();%>
<%String contextPath = request.getContextPath();%>

<!-- 引入bootstrap的css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/static/css/bootstrap.min.css">
<link  href="<%=request.getContextPath()%>/js/static/css/bootstrap.css" rel="stylesheet" >
<link href="<%=request.getContextPath()%>/js/static/css/index.css" rel="stylesheet" >
<link href="<%=request.getContextPath()%>/js/static/css/bootstrap-table.css" rel="stylesheet" >
<link href="<%=request.getContextPath()%>/js/static/css/bootstrap-fileinput.css" rel="stylesheet" >
<link href="<%=request.getContextPath()%>/js/static/css/bootstrap-dialog.css" rel="stylesheet" >
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/js/static/css/daterangepicker-bs3.css" />



<!-- css渲染页面效果  -->
<%--<link rel="stylesheet" href="<%=request.getContextPath()%>/js/uploadify/uploadify.css">--%>



<!-- 引入bootstrap-treeview的css -->
<%--<link  href="<%=request.getContextPath()%>/js/bootstrap/treeview/bootstrap-treeview.min.css" rel="stylesheet" >--%>
<!-- 引入bootstrap-addTabs的css -->
<%--<link  href="<%=request.getContextPath()%>/js/bootstrap/addTabs/addTabs.css" rel="stylesheet" >--%>
<!-- 引入bootstrap-table的css -->
<%--<link  href="<%=request.getContextPath()%>/js/bootstrap/table/bootstrap-table.min.css" rel="stylesheet" >--%>

<%--<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/js/bootstrap/css/daterangepicker-bs3.css" />--%>

<!-- 引入JQuery -->
<!-- 引入JQuery 库-->


<!-- uploadify库 -->
<%--<script src="<%=request.getContextPath()%>/js/uploadify/jquery.uploadify.min.js"></script>--%>

<!-- 引入my97 -->
<%--<script type="text/javascript" src="<%=request.getContextPath() %>/js/my97/WdatePicker.js"></script>--%>
<!-- 引入bootstrap的js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/static/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/static/js/moment.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/static/js/daterangepicker.js"></script>
<script  src="<%=request.getContextPath() %>/js/static/js/Area.js"></script>
<script src="<%=request.getContextPath() %>/js/static/js/AreaData_min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/static/js/index.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/static/js/uploadImg.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/static/js/bootstrap-table.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/static/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/static/js/bootstrap-fileinput.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/static/js/bootstrap-dialog.js"></script>
<!-- 引入my97 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/my97/WdatePicker.js"></script>
<!-- 引入bootstrap的js-->
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/treeview/bootstrap-treeview.min.js"></script>--%>
<%--<!-- 引入bootstrap的js-->--%>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/addTabs/addTabs.js"></script>--%>
<%--<!-- 引入bootstrap-table的js-->--%>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/table/bootstrap-table.min.js"></script>--%>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/table/locale/bootstrap-table-zh-CN.min.js"></script>--%>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/table/bootstrap-table-locale-all.js"></script>--%>

<%--<!-- 引入bootbox.js -->--%>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/bootbox/bootbox.js"></script>--%>


<script type="text/javascript">
var sys = sys || {};
sys.contextPath = '<%=contextPath%>';
sys.basePath = '<%=basePath%>';
</script>

