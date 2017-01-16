<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'empinput.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jses/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="jses/empadd.js"></script>
  </head>
  
  <body>
  	<s:debug></s:debug>
    <s:form action="empsave" method="post">
    	<s:textfield name="lastName" label="LastName"></s:textfield>
    	<s:textfield name="email" label="email"></s:textfield>
    	<s:textfield name="birthDay" label="birthday"></s:textfield>
    	<!-- 注：
    			listKey:option中的value
    			name:param的name
    			listValue：option中的text
    	 -->
		<s:select list="#request.departments"
				  listKey="id"
				  name="department.id"
				  listValue="name"
				  label="Department">
		</s:select>
		<s:submit value="注册"></s:submit>
    </s:form>
  </body>
</html>
