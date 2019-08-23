
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类型管理</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/user.js">
    </script>
</head>
<body>
<!--制作工具栏-->
<div id="ToolBar3">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:TypeSelect()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:DeleteType()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">批量删除</a>
        名称:<input type="text" id="inputname"  name="name"/>
        电话:<input type="text" id="inputtel"  name="telephone"/>
        <a id="btn" href="javascript:userSearch();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
    </div>
</div>
<!--显示所有类型-->
<table id="ry"></table>
</body>
</html>
