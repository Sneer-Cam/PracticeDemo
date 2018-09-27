package org.cam.classdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo4 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		
		//根据用户带过来的id，显示相对应的详细信息
		String id = req.getParameter("id");
		Book book = (Book) Db.getAll().get(id);
		pw.write(book.getId()+"<br />");
		pw.write(book.getName()+"<br />");
		pw.write(book.getAuthor()+"<br />");
		pw.write(book.getDecoretion()+"<br />");
		
		//创建cookie，回写给浏览器
		String cookieValue = buildCookie(id,req);
		Cookie cookie = new Cookie("bookHistory", cookieValue);
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
	
	private String buildCookie(String id, HttpServletRequest req) {
		// TODO Auto-generated method stub
		String bookHistory = null;
		
		Cookie[] cookies = req.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("bookHistory")) {
				bookHistory = cookies[i].getValue();
			}
		}
		if (bookHistory==null) {
			return id;
		}
		
		List<String> list = Arrays.asList(bookHistory.split("\\,"));
		LinkedList<String> linkedlist = new LinkedList<String>(list);
		if (list.contains(id)) {
			linkedlist.remove(id);
			linkedlist.addFirst(id);
		}else {
			if (list.size()>=3) {
				linkedlist.removeLast();
				linkedlist.addFirst(id);
			}else {
				linkedlist.addFirst(id);
			}
		}
		StringBuffer sb = new StringBuffer();
		for(String bid:linkedlist){
			sb.append(bid+",");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}
}
