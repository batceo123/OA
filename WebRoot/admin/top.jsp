<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

    <link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="<%=path %>/js/jquery.js"></script>
	
	<script type="text/javascript">
		$(function(){	
			$(".nav li a").click(function(){
				$(".nav li a.selected").removeClass("selected")
				$(this).addClass("selected");
			})	
		})	
	</script>
  </head>
  
<body style="background:url(<%=path %>/images/topbg.gif) repeat-x;">
    <div class="topleft">
        <div style="margin-left: 30px;margin-top: 28px;font-family: 微软雅黑;font-size: 26px;color: white;width: 500px;">iwork cloud管理系统</div>
    </div>
        
    <div class="topright">    
	    <ul>
	    <li><a href="#"></a></li>
	    <li>
	        <c:if test="${sessionScope.userType==0}">
	            <a href="<%=path %>/login.jsp" target="_parent">退出</a>
	        </c:if>
	        <c:if test="${sessionScope.userType==2}">
	            <a href="<%=path %>/login.jsp" target="_parent">退出</a>
	        </c:if>
	    </li>
	    </ul>
     
	    <div class="user">
	        <c:if test="${sessionScope.userType==0}">
	            <span>欢迎你：系统管理员</span>
	        </c:if>
	        <c:if test="${sessionScope.userType==2}">
	            <span>欢迎你：${sessionScope.yuangong.yuangongName }</span>
	        </c:if>
	    </div>    
    </div>
</body>
</html>
