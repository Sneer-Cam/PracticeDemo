package org.cam.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemoTest extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("�û���="+req.getParameter("username"));
		System.out.println("����="+req.getParameter("password"));
		System.out.println("�Ա�="+req.getParameter("gender"));
		System.out.println("���ڵ�="+req.getParameter("city"));
		
		String likes[] = req.getParameterValues("likes");
		for(int i=0;likes!=null&&i<likes.length;i++) {
			System.out.println("����="+likes[i]);
		}
		System.out.println("��ע="+req.getParameter("desciption"));
		System.out.println("ID="+req.getParameter("id"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
