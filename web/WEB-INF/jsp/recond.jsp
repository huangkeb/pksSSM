<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>记录查询</title>
    <link href="<%=request.getContextPath()%>/css/recond.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/common.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/load.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/sweetalert.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/sweetalert-dev.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body class="body">
<script type="text/javascript">
    function check() {
        $("#loading").css("visibility","visible");
        $("#preloader_2").css("visibility","visible");
        if($("#carno").val() == ""){
            swal("","请输入您的车牌！","error");
            $("#loading").css("visibility","hidden");
            $("#preloader_2").css("visibility","hidden");
            return false;
        }
        else if($("#time").val() == ""){
            swal("","请输入开始时间！","error");
            $("#loading").css("visibility","hidden");
            $("#preloader_2").css("visibility","hidden");
            return false;
        }
        else if($("#time1").val() == ""){
            swal("","请输入结束时间！","error");
            $("#loading").css("visibility","hidden");
            $("#preloader_2").css("visibility","hidden");
            return false;
        }
        else if($("#time").val().toString() > $("#time1").val().toString()){
            swal("","开始时间晚于结束时间！","error");
            $("#loading").css("visibility","hidden");
            $("#preloader_2").css("visibility","hidden");
            return false;
        }
        else if($("#error_message").text() != ""){
            swal("","车牌号有误，无法查询！","error");
            $("#loading").css("visibility","hidden");
            $("#preloader_2").css("visibility","hidden");
            return false;
        }
        else{
            return true;
        }
    }

    function car_no() {
        var car = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
        if(!car.test($("#carno").val())){
            $("#error_message").html("您的车牌号不正确！");
        }
        else {
            $("#error_message").html("");
        }

    }
</script>
<div class="head">
    杭州XX停车场收费管理系统-记录查询
</div>
<div id="displaydate"></div>
<div id="displaytime"></div>
<div id="error_message"></div>
<div id="preloader_2">
    <span></span>
    <span></span>
    <span></span>
    <span></span>
</div>
<div id="loading"></div>
<form method="post" action="<%=request.getContextPath()%>/recond" onSubmit = "return check()">
    <div class="div1">车牌号码<input name="carno" onblur="car_no()" id="carno" class="carno" type="text"/></div>
    <div class="div1">开始时间<input name="begintime" id="time" class="carno" type="datetime-local"/></div>
    <div class="div1">结束时间<input name="endtime" id="time1" class="carno" type="datetime-local"/></div>
    <input type="submit" class="search" value="记录查询"/>
</form>
<a href="<%=request.getContextPath()%>/Skip?action=index">返回首页</a>
</body>
</html>