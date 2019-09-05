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
            function qingjiaShenhe(id)
            {
                var strUrl = "<%=path %>/admin/qingjia/qingjiaShenhe.jsp?id="+id;
                var ret = window.showModalDialog(strUrl,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
                window.location.reload();
            }
            
            function qingjiaDel(id)
            {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/qingjiaDel.action?id="+id;
               }
            }
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
					
					<td width="10%">开始日期</td>
					<td width="10%">结束时间</td>
					<td width="10%">请假事由</td>
					<td width="10%">状态</td>
					
					<td width="10%">审核时间</td>
					<td width="10%">回复信息</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.qingjiaList" id="qingjia" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#qingjia.yuangong.yuangongName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#qingjia.kaishishijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#qingjia.jieshushijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#qingjia.shiyou"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#qingjia.zt"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#qingjia.shenheshijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#qingjia.huifuxinxi"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="审核" onclick="qingjiaShenhe(<s:property value="#qingjia.id"/>)"/>
						<input type="button" value="删除" onclick="qingjiaDel(<s:property value="#qingjia.id"/>)"/>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
