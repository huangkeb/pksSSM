<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=request.getContextPath()%>/css/common.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/result.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
    <title>${title}</title>
</head>
<body class = "body">
<div class="head">
    杭州XX停车场收费管理系统-${title}
</div>
<div id="displaydate"></div>
<div id="displaytime"></div>
<div class="message">
    ${message}
</div>
<div>
    <a href="<%=request.getContextPath()%>/index">返回首页</a>
</div>
</body>
</html>
