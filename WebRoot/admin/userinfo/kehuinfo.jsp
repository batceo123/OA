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
	    <base target="_self"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        
        <script language="javascript">
			function check()
			{
				if(document.formAdd.bianhao.value == "")
				{
					alert("编号不能为空!");
					return false;
				}
				if(document.formAdd.mingcheng.value == "")
				{
					alert("名称不能为空!");
					return false;
				}
				if(document.formAdd.dizhi.value == "")
				{
					alert("地址不能为空!");
					return false;
				}
				document.formAdd.submit();
			}
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form action="<%=path %>/kehuEditMe.action" name="formAdd" method="post">
				     <table width="98%" align="right" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span>&nbsp;</span></td>
					    </tr>
						<tr align='right' bgcolor="#FFFFFF" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						      客户编号：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="bianhao" style="width: 240px;" 
						        value="${sessionScope.kehu.bianhao }" readonly="readonly"/>(编号只读)
						    </td>
						</tr>
						<tr align='right' bgcolor="#FFFFFF" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						      客户名称：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="mingcheng" style="width: 240px;" value="${sessionScope.kehu.mingcheng }"/>
						    </td>
						</tr>
						<tr align='right' bgcolor="#FFFFFF" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						       客户地址：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="dizhi" style="width: 240px;" value="${sessionScope.kehu.dizhi }"/>
						    </td>
						</tr>
						<tr align='right' bgcolor="#FFFFFF" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						        联系方式：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="dianhua" style="width: 240px;" value="${sessionScope.kehu.dianhua }"/>
						    </td>
						</tr>
						<tr align='right' bgcolor="#FFFFFF" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						        客户邮箱：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="youxiang" style="width: 240px;" value="${sessionScope.kehu.youxiang }"/>
						    </td>
						</tr>
						<tr align='right' bgcolor="#FFFFFF" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						        默认密码：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="mima" style="width: 240px;" value="${sessionScope.kehu.mima }"/>
						    </td>
						</tr>						
						<tr align='right' bgcolor="#FFFFFF" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						       <input type="hidden" name="id" value="${sessionScope.kehu.id }"/>
						       <input type="button" value="提交" onclick="check();"/> 
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
