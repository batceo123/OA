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
		
        <script language="javascript">
           function yuangongDel(yuangongId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/yuangongDel.action?yuangongId="+yuangongId;
               }
           }
           
           
           function yuangongAdd()
           {
                 var url="<%=path %>/admin/yuangong/yuangongAdd.jsp";
				 window.location.href=url;
           }
           
           
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
		        
		        
		    } 
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="14" background="<%=path %>/images/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="8%">部门</td>
					<td width="8%">姓名</td>
					<td width="8%">性别</td>
					
					<td width="8%">出生日期</td>
					<td width="8%">学历</td>
					<td width="8%">住址</td>
					
					<td width="8%">电话</td>
					<td width="12%">邮箱</td>
					<td width="8%">工号</td>
					<td width="8%">密码</td>
					
					<td width="8%">职位</td>
					<td width="8%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.yuangongList}" var="yuangong" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${yuangong.org.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${yuangong.yuangongName}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${yuangong.yuangongSex}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						${yuangong.yuangongAge}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${yuangong.yuangongXueli}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${yuangong.yuangongAddress}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						${yuangong.yuangongTel}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   ${yuangong.yuangongEmail}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   ${yuangong.yuangongGonghao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   ${yuangong.yuangongMima}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					   ${yuangong.quanxian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="yuangongDel(${yuangong.yuangongId})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 11px;">
			  <tr>
			    <td>
			      <input type="button" value="添加员工信息" style="width: 120px;" onclick="yuangongAdd()" />
			    </td>
			  </tr>
		    </table>
		   
	</body>
</html>
