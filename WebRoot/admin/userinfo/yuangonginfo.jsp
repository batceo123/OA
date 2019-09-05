<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
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
        
        <script type="text/javascript">
		    function onClickTreeNode(nodeId)
		    {
		        document.getElementById("yuangongOrgId").value=nodeId
		    }
		    
		    function orgShow()
		    {
		        document.getElementById("divOrg").style.display="block";
		    }
		    
		    function check()
		    {
		        if(document.getElementById("yuangongOrgId").value==0)
		        {
		            alert("请选择部门");
		            return false;
		        }
		        if(document.getElementById("yuangongName").value=="")
		        {
		            alert("请输入员工姓名");
		            return false;
		        }
		        if(document.getElementById("yuangongGonghao").value=="")
		        {
		            alert("请输入工号");
		            return false;
		        }
		    } 
		</script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/images/allbg.gif'>
			<form action="<%=path %>/yuangongEditMe.action" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/images/wbg.gif" class='title'><span>&nbsp;</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						         姓名：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="yuangongName" id="yuangongName" size="40" 
						        value="${sessionScope.yuangong.yuangongName }"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						        性别：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <input type="radio" name="yuangongSex" value="男" checked="checked"/>男
						        &nbsp;&nbsp;&nbsp;&nbsp;
						        <input type="radio" name="yuangongSex" value="女"/>女
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						         年龄：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						         <input type="text" name="yuangongAge" id="yuangongAge" size="40"
						         value="${sessionScope.yuangong.yuangongAge }" onkeyup="value=value.replace(/[^\d]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						         学历：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <select name="yuangongXueli" style="width: 200px;">
						           <option value="博士">博士</option>
						           <option value="硕士">硕士</option>
						           <option value="本科">本科</option>
						           <option value="专科">专科</option>
						        </select>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						         住址：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="yuangongAddress" id="yuangongAddress" size="40"
						        value="${sessionScope.yuangong.yuangongAddress }"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						         电话：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="yuangongTel" id="yuangongTel" size="40"
						        value="${sessionScope.yuangong.yuangongTel }"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						         邮箱：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						         <input type="text" name="yuangongEmail" id="yuangongEmail" size="40"
						         value="${sessionScope.yuangong.yuangongEmail }"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						         工号：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						         <input type="text" name="yuangongGonghao" id="yuangongGonghao" size="40"
						         value="${sessionScope.yuangong.yuangongGonghao }"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						         密码：
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						         <input type="text" name="yuangongMima" id="yuangongMima" size="40"
						         value="${sessionScope.yuangong.yuangongMima }"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="10%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="90%" bgcolor="#FFFFFF" align="left">
						       <input type="hidden" name="yuangongId" value="${sessionScope.yuangong.yuangongId }"/>
						       <input type="submit" value="提交" onclick="return check()"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
