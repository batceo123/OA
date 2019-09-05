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
			//导航切换
			$(".menuson .header").click(function(){
				var $parent = $(this).parent();
				$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
				
				$parent.addClass("active");
				if(!!$(this).next('.sub-menus').size()){
					if($parent.hasClass("open")){
						$parent.removeClass("open").find('.sub-menus').hide();
					}else{
						$parent.addClass("open").find('.sub-menus').show();	
					}
					
					
				}
			});
			
			// 三级菜单点击
			$('.sub-menus li').click(function(e) {
		        $(".sub-menus li.active").removeClass("active")
				$(this).addClass("active");
		    });
			
			$('.title').click(function(){
				var $ul = $(this).next('ul');
				$('dd').find('.menuson').slideUp();
				if($ul.is(':visible')){
					$(this).next('.menuson').slideUp();
				}else{
					$(this).next('.menuson').slideDown();
				}
			});
		})	
     </script>
  </head>

<c:if test="${sessionScope.userType==0}"> 
<body >
	<div class="lefttop"><span></span>导航菜单</div>
    <dl class="leftmenu">
   
   
   
   <%--  <dd>
    <div class="title">
    <span><img src="<%=path %>/images/leftico02.png" /></span>修改登陆密码
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/admin/userinfo/userPw.jsp" target="rightFrame">修改登陆密码</a><i></i></li>
        </ul>     
    </dd>  --%>
    
    
    
    
    
    <dd><div class="title"><span></span>部门信息管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/orgMana.action" target="rightFrame">部门信息管理</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span></span>员工信息管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/yuangongMana.action" target="rightFrame">员工信息管理</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/admin/yuangong/yuangongAdd.jsp" target="rightFrame">添加员工信息</a><i></i></li>
    </ul>
    </dd>
    
    
    <dd><div class="title"><span></span>考勤信息模块</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/chuqinTongji.action" target="rightFrame">查看员工考勤</a><i></i></li>
    </ul>
    </dd>
    
    
    <dd><div class="title"><span></span>工资信息管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/gongziMana.action" target="rightFrame">工资信息管理</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/admin/gongzi/gongziAdd.jsp" target="rightFrame">添加工资信息</a><i></i></li>
    </ul>
    </dd>
    
    
    
    
    
    <dd><div class="title"><span><img src="<%=path %>/images/leftico04.png" /></span>留言信息管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/liuyanMana.action" target="rightFrame">留言信息管理</a><i></i></li>
    </ul>
    </dd>
    
    
    <dd><div class="title"><span><img src="<%=path %>/images/leftico04.png" /></span>请假管理模块</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/qingjiaMana.action" target="rightFrame">请假管理模块</a><i></i></li>
    </ul>
    </dd> 
    
    
    
    
    <%-- <dd><div class="title"><span><img src="<%=path %>/images/leftico04.png" /></span>11</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/" target="rightFrame">11</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/" target="rightFrame">11</a><i></i></li>
    </ul>
    </dd>
    
    <dd><div class="title"><span><img src="<%=path %>/images/leftico04.png" /></span>11</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/" target="rightFrame">11</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/" target="rightFrame">11</a><i></i></li>
    </ul>
    </dd>    --%>
    
    </dl>
</body>
</c:if>



























<c:if test="${sessionScope.userType==2}"> 
<body style="background:#fff3e1;">
	<div class="lefttop"><span></span>导航菜单</div>
    <dl class="leftmenu">
   
   
   
    <dd>
    <div class="title">
    <span><img src="<%=path %>/images/leftico02.png" /></span>查看我的信息
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/admin/userinfo/yuangonginfo.jsp" target="rightFrame">查看我的信息</a><i></i></li>
        </ul>     
    </dd> 
    
    
    
    <dd><div class="title"><span><img src="<%=path %>/images/leftico04.png" /></span>上班签到打卡</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/admin/qiandao/qiandaoAdd.jsp" target="rightFrame">上班签到打卡</a><i></i></li>
    </ul>
    </dd>
    
    
    <dd><div class="title"><span><img src="<%=path %>/images/leftico04.png" /></span>下班签退打卡</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/admin/qiantui/qiantuiAdd.jsp" target="rightFrame">下班签退打卡</a><i></i></li>
    </ul>
    </dd>
    
    
    <dd><div class="title"><span><img src="<%=path %>/images/leftico04.png" /></span>我的考勤信息</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/chuqinMine.action" target="rightFrame">我的考勤信息</a><i></i></li>
    </ul>
    </dd>
    
    
    <dd><div class="title"><span><img src="<%=path %>/images/leftico04.png" /></span>查看我的工资</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/gongziMine.action" target="rightFrame">查看我的工资</a><i></i></li>
    </ul>
    </dd>
    
    
    
    <dd><div class="title"><span><img src="<%=path %>/images/leftico04.png" /></span>我的请假信息</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/qingjiaMine.action" target="rightFrame">我的请假信息</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/admin/qingjia/qingjiaAdd.jsp" target="rightFrame">提交请假信息</a><i></i></li>
    </ul>
    </dd>
    
    
    <dd><div class="title"><span><img src="<%=path %>/images/leftico04.png" /></span>留言信息模块</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/liuyanAll.action" target="rightFrame">留言信息模块</a><i></i></li>
    </ul>
    </dd>
    
    
    <%-- <dd><div class="title"><span><img src="<%=path %>/images/leftico04.png" /></span>11</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/" target="rightFrame">11</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/" target="rightFrame">11</a><i></i></li>
    </ul>
    </dd>    --%>
    
    </dl>
</body>
</c:if>





</html>
