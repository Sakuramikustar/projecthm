<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>ITAEM</title>
    <!--    表示链接样式文档-->
    <link rel="stylesheet" href="../../static/layui/css/layui.css" type="text/css"/>

    <script type="text/javascript" src=" ../../static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="../../static/layui/layui.all.js" ></script>
    <script type="text/javascript" src="../../static/layui/layui.js" ></script>
</head>

<body>
<!--<input type="button" id="btn" value="凯通杯" class="layui-btn layui-btn-warm" />-->
<button type="button" id="btn" class="layui-btn layui-btn-warm">凯通杯</button>
<script type="text/javascript">
    //use引入所需模块
    layui.use('layer', function() {
        var layer = layui.layer;
        //获取元素
        var btn = document.getElementById("btn");
        btn.onclick = function() {
            //确认框
            layer.confirm('你参加过2017凯通杯Java程序设计决赛吗', {
                //按钮1、按钮1
                btn: ['参加过', '没参加'],
                //确认框图标
                icon: 3
                //按钮事件1
            }, function() {
                //按钮事件1信息
                layer.msg('恭喜你，你的人生经历又丰富了', {
                    //事件1图标
                    icon: 1
                });
                //按钮事件2
            }, function() {
                //按钮事件2信息
                layer.msg('可惜了，下次记得参加', {
                    //事件2图标
                    icon: 6
                });
            });
        }
    });
</script>
</body>

</html>