package org.cam.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemoTest extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	test3(resp);
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String vivan = "vivan";
		String vPassword = "123456";
		if ((vivan.equals(username))&&((vPassword.equals(password)))) {
			resp.setCharacterEncoding("UTF-8");
			resp.setHeader("Content-type", "text/html;chatset=UTF-8");
			resp.setHeader("refresh", "3;url='/Cam/succeed.jsp'");
			resp.getWriter().write("¹§Ï²ÄãµÇÂ½³É¹¦£¡");
		}else {
			resp.setCharacterEncoding("UTF-8");
			resp.setHeader("Content-type", "text/html;chatset=UTF-8");
			resp.setHeader("refresh", "3;url='/Cam/exception.jsp'");
			resp.getWriter().write("µÇÂ½Ê§°Ü£¡");
		}
	}

//	private void test3(HttpServletResponse resp) throws IOException{
		// TODO Auto-generated method stub
//		resp.setCharacterEncoding("UTF-8");
//		resp.setHeader("Content-type", "text/html;chatset=UTF-8");
//		resp.setHeader("refresh", "3;url='/Cam/succeed.jsp'");
//		resp.getWriter().write("¹§Ï²ÄãµÇÂ½³É¹¦£¡");
		
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
