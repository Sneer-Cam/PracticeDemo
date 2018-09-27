<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
  		String username = request.getParameter("username");
		String password = request.getParameter("password");
	%>	
	<%!
		String cam = "cam";
		String cPassword = "8787";
	%>
	<%
		if ((cam.equals(username))&&((cPassword.equals(password)))) {
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-type", "text/html;chatset=UTF-8");
			response.setHeader("refresh", "3;url='/Cam/JSPTest/Welcome.jsp'");
			response.getWriter().write("恭喜你登陆成功！");
		}else {
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-type", "text/html;chatset=UTF-8");
			response.setHeader("refresh", "3;url='/Cam/JSPTest/Up.jsp'");
			response.getWriter().write("登陆失败！");
		}
  	 %>
  </body>
</html>
