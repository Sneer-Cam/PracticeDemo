package org.cam.classdemo;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		test1(resp);
//		test2(resp);
		test3(resp);
	}

	private void test3(HttpServletResponse resp) throws IOException{
		// TODO Auto-generated method stub
		OutputStream os = resp.getOutputStream();
		os.write((1+"").getBytes());
	}

//	private void test2(HttpServletResponse resp) throws IOException{
//		// TODO Auto-generated method stub
//		String data = "中国";
//		OutputStream os = resp.getOutputStream();
//		os.write("<meta http-equiv='content-type'content='text/html;charset=GBK' />".getBytes());
//		os.write(data.getBytes("GBK"));
//	}

//	private void test1(HttpServletResponse resp) throws IOException{
//		// TODO Auto-generated method stub
//		resp.setHeader("conntent-type", "text/html,charset=GBK");
//		String data = "中国";
//		OutputStream os = resp.getOutputStream();
//		os.write(data.getBytes("GBK"));
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
