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
		resp.getWriter().write("��ϲ���½�ɹ��������������3�����ת����ҳ�����û�з�Ӧ������<a href='http://localhost:8080/Cam/index.jsp'>������</a>");
		
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
