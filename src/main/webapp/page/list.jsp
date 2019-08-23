<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript" type="text/javascript" src="../scripts/jquery-1.8.3.js"></script>
  <script language="JavaScript">
    $(function(){  //加载事件
      $.post("getType",null,function(data){  //发送异步请求
        for(var i=0;i<data.length;i++){
          var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
          //追加节点
          $("#type_id").append(node);
        }
          //设置选中项
          $("#type_id").val(${condition.tid});
      },"json");
      $.post("getdistricts",null,function(data){  //发送异步请求
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
            $.post("getAllStreets",{"did":did},function(data){  //发送异步请求
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
    //带条件的分页
    function goPage(pageNum){
        //1.将页码设置到表单
        $("#setPage").val(pageNum);
        //2.提交表单
        $("#sform").submit();   //js提交表单，相当于点击了提交按钮
    }
  </script>

<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action="getHouseSearch">
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
    <input type="submit" value="搜索" name="search">
 </FORM></DL></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${houseBySerch.list}" var="h">
  <TR>
    <TD>
      <DL>
        <DT><A href="details.jsp" target="_blank">${h.title}</A></DT>
        <DD>${h.dname}${h.sname},${h.floorage}<BR>联系方式：${h.contact} </DD></DL></TD>
    <TD class=house-type>${h.tname}</TD>
    <TD class=house-price><SPAN>${h.price}</SPAN>元/月</TD></TR>
  </c:forEach>
  </TBODY>
</TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:goPage(1)">首页</A></LI>
  <LI><A href="javascript:goPage(${houseBySerch.prePage==0?1:houseBySerch.prePage})">上一页</A></LI>
  <LI><A href="javascript:goPage(${houseBySerch.nextPage==0?houseBySerch.pages:houseBySerch.nextPage})">下一页</A></LI>
  <LI><A href="javascript:goPage(${houseBySerch.pages})">末页</A></LI></UL><SPAN
class=total>${houseBySerch.pageNum}/${houseBySerch.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
