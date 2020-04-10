<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=request.getContextPath()%>/css/common.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/in.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/load.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/sweetalert.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/sweetalert-dev.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <title>车辆入库</title>
</head>
<body class = "body">
<script type="text/javascript">
    function error() {
        var car_no = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
        if(car_no.test($("#carno").val())){
            $.post({
                url:"<%=request.getContextPath()%>/CarInServlet",
                data:{"carno":$("#carno").val()},
                success:function (data) {
                    if(data === "full"){
                        $("#error_message").html("抱歉当前车库已满！");
                    }
                    else if(data === "exist"){
                        $("#error_message").html("您的车已在车库中！");
                    }
                    else{
                        $("#error_message").html("");
                    }
                }
            });
        }
        else {
            $("#error_message").html("您的车牌号不正确！");
        }
    }

    function test() {
        $("#loading").css("visibility","visible");
        $("#preloader_2").css("visibility","visible");
        if($("input[name='cartype']:checked").val() == null){
            swal("","请选择您的车型！","error");
            $("#loading").css("visibility","hidden");
            $("#preloader_2").css("visibility","hidden");
            return false;
        }
        else if($("#carno").val() == ""){
            swal("","请输入您的车牌！","error");
            $("#loading").css("visibility","hidden");
            $("#preloader_2").css("visibility","hidden");
            return false;
        }
        else if($("#error_message").text() != ""){
            swal("","您的车暂时无法入库，请稍后重试！","error");
            $("#loading").css("visibility","hidden");
            $("#preloader_2").css("visibility","hidden");
            return false;
        }
        else{
            return true;
        }
    }
</script>
<div class="head">
    杭州XX停车场收费管理系统-车辆入库
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
<form class="form" method="post" action="<%=request.getContextPath()%>/in">
    <div class="div1">车牌号码<input onblur="error()" id = "carno" name="carno" class="carno" type="text"/></div>
    <div class="div2">车辆类型</div>
    <div class="div">
        <div class="div3"><input name="cartype" type="radio" class="cartype" value="1">小型汽车</div>
        <div class="div3"><input name="cartype" type="radio" class="cartype" value="2">大型客车</div>
        <div class="div3"><input name="cartype" type="radio" class="cartype" value="3">载货卡车</div><br>
        <div class="div3"><input name="cartype" type="radio" class="cartype" value="4">施工挂车</div>
        <div class="div3"><input name="cartype" type="radio" class="cartype" value="5">小型轿车</div>
        <div class="div3"><input name="cartype" type="radio" class="cartype" value="6">小型客车</div>
    </div>
    <input class="in" type="submit" value="车辆入库" onclick="return test()"/>
</form>
<a href="<%=request.getContextPath()%>/Skip?action=index">返回首页</a>
</body>
</html>
