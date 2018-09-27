package org.cam.classdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		test1(resp);
	}

	private void test1(HttpServletResponse resp) throws FileNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		String path = this.getServletContext().getRealPath("X:/Wallpapers/images/x-men.jpg");
		String filename = path.substring(path.lastIndexOf("\\") + 1);

		resp.setHeader("content-disposition", "attachment;filename=" + filename);

		FileInputStream fi = null;
		PrintWriter pw = null;

		try {
			fi = new FileInputStream(path);
			int len = 0;
			byte[] buff = new byte[1024];
			pw = resp.getWriter();
			while ((len = fi.read(buff)) != -1) {
				System.out.print((char)len);
			}
		} finally{
			if (fi != null) {
				try {
					fi.close();
					fi = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pw != null) {
				try {
					pw.close();
					pw = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
