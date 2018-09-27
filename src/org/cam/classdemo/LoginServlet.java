package org.cam.classdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		List<User> list = Dd.getList();
		for(User user:list){
			if (user.getUsername().equals(username)&&user.getPassword().equals(password)) {
				req.getSession().setAttribute("user", user);
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
				return;
			}
		}
		pw.println("用户名或者密码错误");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}

class Dd {
	private static List list = new ArrayList();
	static{
		list.add(new User("aaa", "123"));
		list.add(new User("bbb", "456"));
		list.add(new User("ccc", "789"));
	}
	public static List getList(){
		return list;
	}
}