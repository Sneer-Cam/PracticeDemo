<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <form name="myform" action="/Cam/servlet4/servlettestdemo1" method="post">
    	用户名：<input type="text" name="username" /><br />
    	密码：<input type="password" name="password" /><br />
    	性别：<input type="radio" name="gender" value="male" />男<input type="radio" name="gender" value="female" />女<br />
		所在地：<select name="city">
			  	<option name="beijing">北京</option>
			  	<option name="shanghai">上海</option>
			  	<option name="changsha">长沙</option>
			  </select><br />
		爱好：<input type="checkbox" name="likes" value="sing" />唱歌
			 <input type="checkbox" name="likes" value="dance" />跳舞
			 <input type="checkbox" name="likes" value="basketball" />篮球
			 <input type="checkbox" name="likes" value="football" />足球<br />
		备注：<textarea rows="5" cols="60" name="desciption"></textarea><br />
		照片：<input type="file" name="image" /><br />
		<input type="hidden" name="id" value="123456" />
		<input type="submit" value="提交" />	
    </form>
  </body>
</html>
