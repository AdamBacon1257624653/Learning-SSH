<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emplist.jsp' starting page</title>
   
	<script type="text/javascript" src="jses/jquery-1.4.2.js">
	</script>
	<script type="text/javascript" src="jses/emp_init.js"></script>
	<script type="text/javascript" src="jses/namespace.js"></script>
	<script type="text/javascript" src="jses/emp.js"></script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" h ref="styles.css">
	-->
  </head>
  	
  <body>
  	<s:debug></s:debug>
   	<h4>员工信息表</h4>
   	<s:if test="#request.employees==null || #request.employees.size()==0">
   		暂时还没有各部门员工信息
   	</s:if>
   	<s:else>
   		<s:textfield name="lastname" label="lastName" id="lastname"></s:textfield>
		<table border="1" cellspacing="0" cellpadding="10" align="center">
			<thead>
				<tr>
					<th>lastName</th>
					<th>E-mail</th>
					<th>Birthday</th>
					<th>CreateDate</th>
					<th>Dept</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.employees">
					<tr id="${id }">
						<td cellname="lastName">${lastName }</td>
						<td cellname="email">${email }</td>
						<td cellname="birthDay">${birthDay }</td>
						<td class="createdate">${createDate }</td>
						<td class="departmentname">${department.name }</td>
						<td><a href="#" id="deleteEmp">Delete</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:else>
  </body>
</html>
