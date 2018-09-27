package org.cam.classdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet
{
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String c_checkcode = req.getParameter("checkcode");
		String s_checkcode = (String)req.getSession().getAttribute("checkcode");
		
		if (c_checkcode!=null&&c_checkcode.equals(s_checkcode)) {
			System.out.println("处理注册请求！！");
		}else {
			System.out.println("验证码输入错误！！");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
