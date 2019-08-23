$(function(){
    //使用datagrid绑定数据库
    $('#shn').datagrid({
        url:'sHouse?ispass=0',
        striped:true,
        pagination:true,
        pageSize:3,
        toolbar:"#sheng1",
        checkbox:true,
        pageList:[3,6,9],
        nowrap: true,//数据长度超出列宽时将会自动截取。
        fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动。
        title:"<center>已审核房屋信息</center>",
        columns:[[
            {field:"ab",checkbox:"true"},
            {field:'id',title:'编号',width:100},
            {field:'title',title:'房屋名称',width:100},
            {field:'dname',title:'所在地区',width:100},
            {field:'sname',title:'所在街道',width:100},
            {field:'tname',title:'户型',width:100},
            {field:'floorage',title:'房屋面积',width:100},
            {field:'contact',title:'联系电话',width:100},
            {field:'price',title:'月租金',width:100},
            {field:'s',title:'操作',width:100,
                formatter: function(value,row,index){
                    var str="<a href='javascript:sheng3("+row.id+")'>审核</a>"
                    return str;
                }
            }
        ]]
    });
});
function sheng3(id) {
    $.post("sHouseGo",{"id":id,"ispass":1},function (data) {
        if(data.result>0){
            $.messager.alert('<center>提示</center>','操作成功！','info');
        }else {
            $.messager.alert('<center>提示</center>','操作失败！','info');
        }
        $('#shn').datagrid('reload');//刷新
    },"json")
}
function fromShow()
{
    $("#formShow").form("submit",{
        url:"#",
    });
}