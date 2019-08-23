<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%
 Object o=session.getAttribute("userInfo");
 if(o==null)
     out.print("<script>alert('你没有登入，或者登入时间失效，请登入！给老子滚起走，请登入');location.href='login.jsp';</script>");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">

<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
<DIV class=search><span style="color:red; font-size: 24px;">欢迎:${sessionScope.userInfo.name}</span><LABEL class="ui-green searchs"><a href="#" title="">房屋审核页面</a></LABEL>
<LABEL class=ui-green><INPUT onclick='document.location="login.jsp"' value="退       出" type=button name=search></LABEL>
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
    <TABLE class=house-list>
        <TBODY>
        <c:forEach items="${houses}" var="h">
            <TR>
                <TD class=house-thumb><SPAN><A href="details.jsp" target="_blank"><img src="http://localhost:80/${h.path}" width="100" height="75" alt=""></A></SPAN></TD>
                <TD>
                    <DL>
                        <DT><A href="details.jsp" target="_blank">${h.title}</A></DT>
                        <DD>${h.dname}=${h.sname},${h.floorage}平米<BR>联系方式：${h.contact},类型:${h.tname} </DD></DL></TD>
                <TD class=house-type><LABEL class=ui-green><INPUT value="${h.ispass==0?'未审核':'已审核'}" type=button name=search></LABEL></TD>
                <TD class=house-price><LABEL class=ui-green><INPUT value="审核" type=button onclick="aa(${h.ispass},${h.id})" name=search></LABEL></TD>
            </TR>
        </c:forEach>
        </TBODY></TABLE></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY>
<script>
    function aa(a,b){
        if(a==0){
            location.href="exHouse?id=b&ispass=1";
        }
    }
</script>
</HTML>
