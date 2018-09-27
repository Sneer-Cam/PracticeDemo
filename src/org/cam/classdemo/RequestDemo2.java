package org.cam.classdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo2 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("用户名="+req.getParameter("username"));
		System.out.println("密码="+req.getParameter("password"));
		System.out.println("性别="+req.getParameter("gender"));
		System.out.println("所在地="+req.getParameter("city"));
		
		String likes[] = req.getParameterValues("likes");
		for(int i=0; likes!=null&&i<likes.length;i++){
			System.out.println("爱好="+likes[i]);
		}
		System.out.println("备注="+req.getParameter("desciption"));
		System.out.println("ID="+req.getParameter("id"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
