<!-- easyui的样式主题文件 -->
<link rel="stylesheet" type="text/css" href="../../static/easyui/themes/default/easyui.css">
<!-- easyui的系统图标-->
<link rel="stylesheet" type="text/css" href="../../static/easyui/themes/icon.css">
<!-- easyui依赖的jquery库-->
<script type="text/javascript" src="../../static/easyui/jquery.min.js"></script>
<!-- easyui的插件库-->
<script type="text/javascript" src="../../static/easyui/jquery.easyui.min.js"></script>
<!-- easyui的汉化包 -->
<script type="text/javascript" src="../../static/easyui/locale/easyui-lang-zh_CN.js"></script>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:80px;padding:20px">
</div>

<div data-options="region:'south'" style="height:30px;padding:6px">
    XXX技术有限公司版权所有
</div>

<div data-options="region:'west',title:'Navigator',split:true" style="width:200px;padding:10px">
    <ul id="MenuTree" class="easyui-tree"></ul>
</div>

<div data-options="region:'center'">
    <div id="mainTabs" class="easyui-tabs" data-options="fit:true">
    </div>
</div>

</body>