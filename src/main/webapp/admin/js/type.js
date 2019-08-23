$(function(){
    //使用datagrid绑定数据库
    $('#lx').datagrid({
        url:'type1',
        striped:true,
        pagination:true,
        pageSize:3,
        toolbar:"#ToolBar2",
        checkbox:true,
        pageList:[3,6,9],
        nowrap: true,//数据长度超出列宽时将会自动截取。
        fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动。
        title:"<center>房屋类型</center>",
        columns:[[
            {field:"cb",checkbox:"true"},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'类型名称',width:100},
            {field:'s',title:'操作',width:100,
                formatter: function(value,row,index){
                    var str="<a href='javascript:delType("+row.id+")'>删除</a>|<a href='#'>修改</a>"
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
function delType(id){
    $.messager.confirm('<center>提示</center>','确定删除吗？',function(r){
        if(r){
            $.post("deleteType",{"id":id},function(){
                $('#lx').datagrid('reload');//刷新
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
function SaveType(){
    $("#form1").form("submit",{
        url:"addType",
        success:function(data){
            data=$.parseJSON(data);
            if(data.result>0){
                $.messager.alert('<center>提示</center>','添加成功！','info');
                $('#AddDialog').window('close');
                $('#lx').datagrid('reload');//刷新
            }else {
                $.messager.alert('<center>提示</center>','添加失败！','error');
                $('#AddDialog').window('close');
            }
        }
    });
}
function TypeSelect(){
    var SelectRows = $("#lx").datagrid('getSelections');
    if(SelectRows.length==1){
        $('#updateDialog').window('setTitle',"编辑区域");
        $('#updateDialog').window('open');
        $.post("getOneType",{"id":SelectRows[0].id},function(data){
            $("#form2").form('load',data);
        });
    }else {
        $.messager.alert('<center>提示</center>','你没有选择行或者选择多行，给我小心点!','warn');
    }
}
function updateType(){
    $("#form2").form("submit",{
        url:"updateType",
        success:function(data){
            data=$.parseJSON(data);
            if(data.result==1){
                $('#updateDialog').window('close');
                $('#lx').datagrid('reload');//刷新
                $.messager.alert('<center>提示</center>','修改成功！','info');
            }else {
                $.messager.alert('<center>提示</center>','修改失败！','error');
                $('#updateDialog').window('close');
            }
        }
    });
}
//批量删除
function DeleteType() {
    var SelectRows = $("#lx").datagrid('getSelections');
    var SelectIndexArr = [];
    for( var i = 0 ; i < SelectRows.length; i++ ){
        SelectIndexArr.push(SelectRows[i].id);
    }
    var SelectIndexToString = SelectIndexArr.join(",");
        if (SelectRows.length == 0) {
                $.messager.alert('<center>提示</center>','选择要删除的选项！','warn');
                } else {
                    $.messager.confirm("系统提示", "你确定要删除吗?", function(r){
                    if(r){
                    $.post("deleteTypeAll", {ids:SelectIndexToString}, function (data) {
                    if (data.result > 0) {
                        $.messager.alert('<center>提示</center>', "删除成功");
                        $('#updateDialog').window('close');
                        $("#lx").datagrid('reload');
                    } else {
                        $.messager.alert('<center>提示</center>', "<font color=red>删除失败</font>");
                    }
                }, "json");
            }
                    });
        }

}