package org.cam.classdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo2 extends HttpServlet
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
		resp.setContentType("text/html;charset=UTF-8");
		String data = "�й�";
		PrintWriter pw = resp.getWriter();
		pw.write(data);
	}

//	private void test1(HttpServletResponse resp) throws IOException{
//		// TODO Auto-generated method stub
//		resp.setCharacterEncoding("GBK");
//		resp.setHeader("conntent-type", "text/html,charset=GBK");
//		String data = "��ɽ������";
//		PrintWriter pw = resp.getWriter();
//		pw.write(data);
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
