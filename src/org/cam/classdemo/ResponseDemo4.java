package org.cam.classdemo;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo4 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		test1(resp);
		test2(resp);
	}

	private void test2(HttpServletResponse resp) throws IOException{
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-type", "text/html;chatset=UTF-8");
		resp.setHeader("refresh", "3;url='/Cam/index.jsp'");
		resp.getWriter().write("恭喜你登陆成功，本浏览器将在3秒后跳转至首页，如果没有反应，请点击<a href='http://localhost:8080/Cam/index.jsp'>超链接</a>");
		
	}

//	private void test1(HttpServletResponse resp) throws IOException{
//		// TODO Auto-generated method stub
//		resp.setHeader("refresh", "3");
//		String data = new Random().nextInt(100000)+"";
//		resp.getWriter().write(data);
//	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
