<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=request.getContextPath()%>/css/out.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/load.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/common.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/sweetalert.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/sweetalert-dev.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <title>车辆出库结算</title>
</head>
<script type="text/javascript">
    function error() {
        var car_no = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
        if (car_no.test($("#carno").val())) {
            $.post({
                url: "<%=request.getContextPath()%>/park/getOutCheck",
                data: {"carno": $("#carno").val()},
                success: function (data) {
                    if (data === "false") {
                        $("#error_message").html("您的车不在车库中！");
                    } else {
                        $("#error_message").html("");
                    }
                }
            });
        } else {
            $("#error_message").html("您的车牌号不正确！");
        }
    }

    function test() {
        $("#loading").css("visibility","visible");
        $("#preloader_2").css("visibility","visible");
        if($("#carno").val() == ""){
            swal("","请输入您的车牌！","error");
            $("#loading").css("visibility","hidden");
            $("#preloader_2").css("visibility","hidden");
            return false;
        }
        else if($("#error_message").text() != ""){
            swal("","您的车暂时无法出库，请稍后重试！","error");
            $("#loading").css("visibility","hidden");
            $("#preloader_2").css("visibility","hidden");
            return false;
        }
        else {
            return true;
        }
    }
</script>
<body class="body">
<div class="head">
    杭州XX停车场收费管理系统-车辆出库
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
<form class="form" action="<%=request.getContextPath()%>/park/getOut" method="post">
    <div class="div">车牌号码<input name="carno" id="carno" onblur="error()" class="carno" type="text"/></div>
    <input type="submit" class="out" onclick="return test()" value="出库结算"/>
</form>
<a href="<%=request.getContextPath()%>/index">返回首页</a>
</body>
</html>
