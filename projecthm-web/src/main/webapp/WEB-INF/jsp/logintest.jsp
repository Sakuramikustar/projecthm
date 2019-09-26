<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>绿色农场系统登录</title>
    <meta name="keywords" content="绿色农场">
    <meta name="description" content="绿色农场场">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="../../static/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="../../static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="../../static/css/animate.min.css" rel="stylesheet">
    <link href="../../static/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name"><img src="../../static/img/logo-lin.png"></h1>

        </div>
        <h3>欢迎使用绿色农场</h3>

        <form class="m-t" role="form" >
            <div class="form-group">
                <input id="account" type="text" class="form-control" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input id="password" type="password" class="form-control" placeholder="密码" required="">
            </div>
            <button id="loginbtn" type="submit" class="btn btn-primary block full-width m-b"
                    data-loading-text="loading......">登 录</button>


            <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="#">注册一个新账号</a>
            </p>

        </form>
    </div>
</div>
<script src="../../static/js/jquery.min.js?v=2.1.4"></script>
<script src="../../static/js/bootstrap.min.js?v=3.3.5"></script>
</body>

<script>
    $(function () {
        $("#loginbtn").on("click", function () {
            var account = $("#account").val();
            var password = $("#password").val();
            var idcard = 1;
            if (account == "" || password == "") {
                alert("输入正确信息");
                return;
            }
            //提交表单
            $.ajax({
                url: "/login",
                type: "post",
                dataType: "json",
                data: {
                    loginname: account,
                    password: password,
                    idcard:idcard
                },
                success: function (result) {
                    console.log(result);
                    if (result.code == 200) {
                        window.location.href = "success";
                    } else {
                        alert(result.message);
                    }
                }
            })
        })
    })
</script>
</html>