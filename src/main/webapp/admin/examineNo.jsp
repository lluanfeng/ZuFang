
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核管理</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/shengn.js">
    </script>
</head>
<script>
    $(function(){  //加载事件
        $.post("getTypes",null,function(data){  //发送异步请求
            for(var i=0;i<data.length;i++){
                var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                //追加节点
                $("#type_id").append(node);
            }
            //设置选中项
            $("#type_id").val(${condition.tid});
        },"json");
        $.post("district",null,function(data){  //发送异步请求
            for(var i=0;i<data.length;i++){
                var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                //追加节点
                $("#district_id").append(node);
            }
            //设置选中项
            $("#district_id").val(${condition.did});
            x();
        },"json");
        $("#district_id").change(x);
        function x() {
            var did = $("#district_id").val();
            if(did!="") {
                $("#street_id>option:gt(0)").remove();
                $.post("getAllStreet2",{"did":did},function(data){  //发送异步请求
                    for(var i=0;i<data.length;i++){
                        var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                        //追加节点
                        $("#street_id").append(node);
                    }
                    $("#street_id").val(${condition.sid});
                },"json");
            }
        }
    });
</script>
<body>
<div id="sheng1">
    <div style="height: 70px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:DistrictSelect()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:DeleteDidtrict()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">批量删除</a>
        <DL class="search clearfix">
            <FORM id=formShow method=post action="">
                <input  type="hidden" id="setPage" name="page" value="1"/>
                房屋名称：<input type="text" name="title" value="${condition.title}">
                区域：<select  name="did" id="district_id">
                <option value="">请选择</option>
            </select>
                街道：<select  name="sid" id="street_id">
                <option value="">请选择</option>
            </select>
                类型：<select  name="tid" id="type_id">
                <option value="">请选择</option>
            </select>
                价格区间：<input type="text" size="5" name="startPrice" value="${condition.startPrice}">-<input type="text" size="5" name="endPrice" value="${condition.endPrice}">
                <a href="javascript:fromShow()" class="easyui-linkbutton" iconCls="icon-ok">提交</a>
            </FORM></DL>
    </div>
</div>
<!--显示所有区域-->
<table id="shn"></table>
</body>
</html>
