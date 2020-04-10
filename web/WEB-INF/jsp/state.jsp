<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=request.getContextPath()%>/css/state.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/common.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
    <title>空位查询</title>
</head>
<body class="body">
<div class="head">
    杭州XX停车场收费管理系统-空位查询
</div>
<div id="displaydate"></div>
<div id="displaytime"></div>
<table>
    <tr>
        <c:forEach items="${stateList}" begin="0" end="19" var="state">
            <td class="Park ${empty state.carno}">
                <span>${state.carno}</span>${state.parkno}
            </td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${stateList}" begin="20" end="39" var="state">
            <td class="Park ${empty state.carno}">
                <span>${state.carno}</span>${state.parkno}
            </td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${stateList}" begin="40" end="59" var="state">
            <td class="Park ${empty state.carno}">
                <span>${state.carno}</span>${state.parkno}
            </td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${stateList}" begin="60" end="79" var="state">
            <td class="Park ${empty state.carno}">
                <span>${state.carno}</span>${state.parkno}
            </td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${stateList}" begin="80" end="99" var="state">
            <td class="Park ${empty state.carno}">
                <span>${state.carno}</span>${state.parkno}
            </td>
        </c:forEach>
    </tr>
</table>
<a href="<%=request.getContextPath()%>/index">返回首页</a>
</body>
</html>