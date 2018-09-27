package org.cam.classdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.print("<a href='/Cam/cookieDemo2'>清除上次访问时间</a><br />");
		pw.print("上次访问时间：");
		
		Cookie[] cookies = req.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("lastAccessTime")) {
				long cookiesValue = Long.parseLong(cookies[i].getValue());
				Date date = new Date(cookiesValue);
//				pw.print(date.toLocaleString());
//				
//				date.toString()位国际事件显示方式，不适合我们查看
//				date.toLocaleString()方法已过时，替换方法如下
				pw.print(DateFormat.getDateTimeInstance().format(date));
			}
		}
		
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis() + "");
		cookie.setMaxAge(1 * 24 * 3600);
		cookie.setPath("/Cam");
		resp.addCookie(cookie);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
