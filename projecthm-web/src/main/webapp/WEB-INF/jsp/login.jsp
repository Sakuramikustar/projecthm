<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <title>登陆页面</title>
    <script type="text/javascript" src=" ../../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/layui/layui.all.js" ></script>
    <script type="text/javascript" src="../../static/layui/css/layui.css" ></script>
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

<%--<div class="box">--%>
<%--    <div class="row">--%>
<%--        <h1>登陆</h1>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <input id="account" type="text" placeholder="输入账号"/>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <input id="password" type="password" placeholder="输入密码"/>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <button id="loginbtn" class="btn btn-primary" data-loading-text="loading......">登 录</button>--%>
<%--    </div>--%>
<%--    <div class="row lastrow">--%>
<%--        还没账号?--%>
<%--        <a href="/register">注册</a>--%>
<%--        <a href="#">找回密码</a>--%>
<%--    </div>--%>
<%--</div>--%>
<div class="layui-container">
    <div class="layui-row">
        <h1>登录</h1>
    </div>
    <div class="layui-row">
        <input id="account" type="text" placeholder="输入账号"/>
    </div>

    <div class="layui-row">
        <input id="password" type="password" placeholder="输入密码"/>
    </div>

    <div class="layui-row">
        <button id="loginbtn" class="layui-btn layui-btn-warm" data-loading-text="loading......">登 录</button>
    </div>

</div>

</body>



<script>
    $(function () {

        $("#loginbtn").on("click", function () {
            var account = $("#account").val();
            var password = $("#password").val();
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
                    password: password
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
