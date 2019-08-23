<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>区域管理</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/district.js">
    </script>
</head>
<body>
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:DistrictSelect()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:DeleteDidtrict()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">批量删除</a>
    </div>
</div>
<!--添加对话框-->
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form method="post" action="" id="form1">
        区域名称:<input type="text" name="name" class="dd">
    </form>
</div>
<!--添加对话框的按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveDistrict()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a href="javascript:CloseDialog('AddDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<!--修改对话框-->
<div id="updateDialog" class="easyui-dialog" buttons="#updateDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form method="post" action="" id="form2">
        编&emsp;&emsp;号:<input type="text" readonly name="id" ><br>
        区域名称:<input type="text" name="name" class="dd">
    </form>
</div>
<!--修改对话框的按钮-->
<div id="updateDialogButtons">
    <a href="javascript:updateDistrict()" class="easyui-linkbutton"
       iconCls="icon-ok">修改</a> <a href="javascript:CloseDialog('updateDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<div id="StreetDialog" class="easyui-dialog" buttons="#StreetDialogButtons"
     style="width: 800px; height: 450px; padding: 10px 20px;" closed="true">
    <table id="dgStreet"></table>
    <hr></hr>
    <form method="post" id="form3" name="form3">
        <input type="hidden" name="districtId" id="streetid">
        街道名称:<input type="text" name="name" id="name2">
        <input type="button" onclick="streetAdd()" value="添加">
    </form>
</div>
<!--显示所有区域-->
<table id="dg"></table>
</body>
</html>
