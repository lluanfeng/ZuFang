$(function(){
    //使用datagrid绑定数据库
    $('#dg').datagrid({
        url:'district2',
        striped:true,
        pagination:true,
        pageSize:3,
        toolbar:"#ToolBar",
        checkbox:true,
        pageList:[3,6,9],
        nowrap: true,//数据长度超出列宽时将会自动截取。
        fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动。
        title:"<center>区域信息</center>",
        columns:[[
            {field:"cb",checkbox:"true"},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'区域名称',width:100},
            {field:'s',title:'操作',width:100,
                formatter: function(value,row,index){
                    var str="<a href='javascript:deldistrict("+row.id+")'>删除</a>|<a href='javascript:DistrictSelect()'>修改</a>|<a href='javascript:StreetSelect("+row.id+")'>查看街道</a>"
                    return str;
                }
            }
        ]]
    });
    $('.dd').validatebox({
        required: true,
        missingMessage:"该输入项为必填",
        validType: 'string'
    });
});
/*删除单条*/
function deldistrict(id){
    $.messager.confirm('<center>提示</center>','确定删除吗？',function(r){
        if(r){
            $.post("deleteDistrict",{"id":id},function(){
                $('#dg').datagrid('reload');//刷新
            });
        }else {
            $.messager.alert('<center>提示</center>','删除失败！','info');
        }
    });
}
function Add(){
    //alert("我要添加区域");
    $('#AddDialog').window('setTitle',"添加区域");
    $('#AddDialog').window('open');
}
//关闭添加对话框
function CloseDialog(id){
    $('#'+id).window('close'); //关闭
}
function SaveDistrict(){
    $("#form1").form("submit",{
        url:"addDistrict",
        success:function(data){
            data=$.parseJSON(data);
            if(data.result>0){
                $.messager.alert('<center>提示</center>','添加成功！','info');
                $('#AddDialog').window('close');
                $('#dg').datagrid('reload');//刷新
            }else {
                $.messager.alert('<center>提示</center>','添加失败！','error');
                $('#AddDialog').window('close');
            }
        }
    });
}
function DistrictSelect(){
    var SelectRows = $("#dg").datagrid('getSelections');
    if(SelectRows.length==1){
        $('#updateDialog').window('setTitle',"编辑区域");
        $('#updateDialog').window('open');
        $.post("getOneDistrict",{"id":SelectRows[0].id},function(data){
            $("#form2").form('load',data);
        });
    }else {
        $.messager.alert('<center>提示</center>','你没有选择行或者选择多行，给我小心点!','warn');
    }
}
function updateDistrict(){
    $("#form2").form("submit",{
        url:"updateDistrict",
        success:function(data){
            data=$.parseJSON(data);
            if(data.result==1){
                $('#updateDialog').window('close');
                $('#dg').datagrid('reload');//刷新
                $.messager.alert('<center>提示</center>','修改成功！','info');
            }else {
                $.messager.alert('<center>提示</center>','修改失败！','error');
                $('#updateDialog').window('close');
            }
        }
    });
}
//批量删除
function DeleteDidtrict() {
    var SelectRows = $("#dg").datagrid('getSelections');
    var SelectIndexArr = [];
    for( var i = 0 ; i < SelectRows.length; i++ ){
        SelectIndexArr.push(SelectRows[i].id);
    }
    var SelectIndexToString = SelectIndexArr.join(",");
    $.messager.confirm("系统提示", "你确定要删除吗?", function(r){
        if(r){
            if (SelectRows.length > 0) {
                $.post("deleteDistrictAll", {ids:SelectIndexToString}, function (data) {
                    if (data.result > 0) {
                        $.messager.alert('<center>提示</center>', "删除成功");
                        $('#updateDialog').window('close');
                        $("#dg").datagrid('reload');
                    } else {
                        $.messager.alert('<center>提示</center>', "<font color=red>删除失败</font>");
                    }
                }, "json");
            } else {
                $.messager.alert('<center>提示</center>','选择要删除的选项！','warn');
            }
        }
    });
}
function StreetSelect(did){
    $('#StreetDialog').window('setTitle',"街道信息");
    $('#StreetDialog').window('open');
    $('#streetid').val(did)
    $(function(){
        //使用datagrid绑定数据库
        $('#dgStreet').datagrid({
            url:'Street?did='+did,
            striped:true,
            pagination:true,
            pageSize:3,
            toolbar:"#ToolBar3",
            checkbox:true,
            pageList:[3,6,9],
            nowrap: true,//数据长度超出列宽时将会自动截取。
            fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动。
            title:"<center>街道信息</center>",
            columns:[[
                {field:"cb",checkbox:"true"},
                {field:'id',title:'编号',width:100},
                {field:'name',title:'街道名称',width:100,
                    formatter: function(value,row,index){
                        var str="<input type='text' id='inputName' value='"+value+"'>";
                        return str;}},
                {field:'s',title:'操作',width:100,
                    formatter: function(value,row,index){
                        var str="<a href='javascript:delStreet("+row.id+")'>删除</a>|<a href='javascript:updateStreet("+row.id+")'>修改</a>"
                        return str;
                    }
                }
            ]]
        });
    });
}
function streetAdd(){
    $("#form3").form("submit",{
        url:"addStreet",
        success:function(data){
            data=$.parseJSON(data);
            if(data.result==1){
                $('#dgStreet').datagrid('reload');//刷新
                $.messager.alert('<center>提示</center>','添加成功！','info');
            }else {
                $.messager.alert('<center>提示</center>','添加失败！','error');
            }
        }
    });
}
function delStreet(id) {
    $.messager.confirm('<center>提示</center>','确定删除吗？',function(r){
        if(r){
            $.post("delStreet",{"id":id},function(){
                $('#dgStreet').datagrid('reload');//刷新
            });
        }else {
            $.messager.alert('<center>提示</center>','删除失败！','info');
        }
    });
}
function updateStreet(id){
        $.post("updateStreet",{"id":id,"name":$("#inputName").val()},function(data){
            if(data.result==1){
                $('#dgStreet').datagrid('reload');//刷新
            }else {
                $.messager.alert('<center>提示</center>','修改失败','info');
        }
    },"json");
}