<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
					
					<td width="10%">工资月份</td>
					<td width="10%">基本工资</td>
					<td width="10%">加班费</td>
					<td width="10%">奖金</td>
					
					<td width="10%">扣除请假费用</td>
					<td width="8%">实发工资</td>
		        </tr>	
				<s:iterator value="#request.gongziList" id="gongzi" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.yuangong.yuangongName"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.yuefen"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#gongzi.jibengongzi"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.jiabanfei"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.jiangjin"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#gongzi.qingjiafei"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.shifagongzi"/>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
