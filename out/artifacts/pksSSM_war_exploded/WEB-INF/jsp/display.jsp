<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>记录查询</title>
    <link href="<%=request.getContextPath()%>/css/common.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/displayrecond.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/jPages.css">
    <script src="<%=request.getContextPath()%>/js/jPages.js"></script>
</head>
<body class="body">
<div class="head">
    杭州XX停车场收费管理系统-记录查询
</div>
<div id="displaydate"></div>
<div id="displaytime"></div>
<script>
    $(function(){
        $("div.holder").jPages({
            containerID : "movies", //存放表格的窗口标签ID
            previous : "←", //指示首页的按钮
            next : "→",//指示尾页的按钮
            perPage : 5,//每页显示表格的行数
            delay : 20 //分页时动画持续时间，0表示无动画
        });
    });
</script>
<div class="holder"></div>
<table class="table">
    <thead>
    <tr>
        <th>车位号</th>
        <th>车牌号</th>
        <th>车辆类型</th>
        <th>入库时间</th>
        <th>出库时间</th>
        <th>停留时间 / 分</th>
        <th>收费 / 元</th>
    </tr>
    </thead>
    <tbody id="movies">
    <c:forEach var="record" items="${records}">
        <tr>
            <td>${record.parkno}</td>
            <td>${record.carno}</td>
            <td>${record.cartype}</td>
            <td>${record.intime}</td>
            <td>${record.outtime}</td>
            <td>${record.waittime}</td>
            <td>${record.cost}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="back" href="<%=request.getContextPath()%>/index">返回首页</a>
</body>
</html>
