<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <title>注册页面</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <style>
        body {
            background-color: #EEEEE0;
        }

        .box {
            text-align: center;
            height: 350px;
            margin-top: 10%;
        }

        .row {
            margin-bottom: 30px;
            height: 40px;
        }

        .row input {
            width: 320px;
            height: 40px;
            padding: 0 15px;
            border-radius: 5px;
            border: 1px solid #acacac;
        }

        .row button {
            width: 352px;
            height: 42px;
            background-color: #409eff;
            color: white;
            border-radius: 5px;
            border: 0;
        }

        .row button:hover {
            background-color: teal;
            cursor: pointer;
        }

        .row button:active {
            background-color: green;
            cursor: pointer;
        }

        .lastrow {
            font-size: 14px;
            color: gray;
        }

        .lastrow a {
            text-decoration: none;
            color: #409eff;
        }
    </style>
</head>

<body>

<div class="box">
    <div class="row">
        <h1>注册</h1>
    </div>
    <div class="row">
        <input id="account" type="text" placeholder="输入新的账号"/>
    </div>
    <div class="row">
        <input id="password" type="password" placeholder="输入新的密码"/>
    </div>
    <div class="row">
        <button id="rebtn">注 册</button>
    </div>
    <div class="row lastrow">
        已有账号?
        <a href="/index">登录</a>|
        <a href="#">找回密码</a>
    </div>
</div>
</body>

<script>
    $(function () {

        $("#rebtn").on("click", function () {
            var account = $("#account").val();
            var password = $("#password").val();
            if (account == "" || password == "") {
                alert("输入正确信息");
                return;
            }
            //提交表单
            $.ajax({
                url: "/register/valid",
                type: "post",
                dataType: "json",
                data: {
                    loginname: account,
                    password: password
                },
                success: function (result) {
                    console.log(result);
                    if (result.code == 200) {
                        window.location.href = "resuces";
                    } else {
                        alert(result.message);
                    }
                }
            })
        })
    })
</script>

</html>
