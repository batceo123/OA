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
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script language="JavaScript" src="<%=path %>/js/popup_shuaxin.js" type="text/javascript"></script>
		
        <script language="javascript">
           
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="14" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="10%">员工</td>
					<td width="10%">日期</td>
					
					<td width="10%">上班时间</td>
					<td width="10%">属性</td>
					<td width="10%">下班时间</td>
					<td width="10%">属性</td>
		        </tr>	
				<c:forEach items="${requestScope.qiandaoList}" var="qiandao" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${qiandao.yuangong.yuangongName}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${qiandao.riqi}
					</td>
					
					
					<td bgcolor="#FFFFFF" align="center">
						 ${qiandao.shijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${qiandao.shuxing}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${qiandao.qiantuishi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${qiandao.qiantuishuxing}
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
