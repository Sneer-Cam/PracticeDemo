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
		
		pw.print("<a href='/Cam/cookieDemo2'>����ϴη���ʱ��</a><br />");
		pw.print("�ϴη���ʱ�䣺");
		
		Cookie[] cookies = req.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("lastAccessTime")) {
				long cookiesValue = Long.parseLong(cookies[i].getValue());
				Date date = new Date(cookiesValue);
//				pw.print(date.toLocaleString());
//				
//				date.toString()λ�����¼���ʾ��ʽ�����ʺ����ǲ鿴
//				date.toLocaleString()�����ѹ�ʱ���滻��������
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
