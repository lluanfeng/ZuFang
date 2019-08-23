$(function(){
    //使用datagrid绑定数据库
    $('#ry').datagrid({
        url:'user1',
        striped:true,
        pagination:true,
        pageSize:3,
        toolbar:"#ToolBar3",
        checkbox:true,
        pageList:[3,6,9],
        nowrap: true,//数据长度超出列宽时将会自动截取。
        fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动。
        title:"<center>用户信息</center>",
        columns:[[
            {field:"cb",checkbox:"true"},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'姓名',width:100},
            {field:'telephone',title:'电话',width:100},
            {field:'s',title:'操作',width:100,
                formatter: function(value,row,index){
                    var str="<a href='javascript:delType("+row.id+")'>删除</a>"
                    return str;
                }
            }
        ]]
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
function userSearch(){
    var name = $("#inputname").val();
    var telephone = $("#inputtel").val();
    $('#ry').datagrid('load',{
        name: name,
        telephone: telephone
    });
}