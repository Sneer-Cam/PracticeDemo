package org.cam.classdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo3 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		
		//输出所有商品信息
		pw.print("本网站有如下商品：<br />");
		Map<String, Book> map = Db.getAll();
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Book> entry = (Entry<String, Book>) it.next();
			Book book = entry.getValue();
			pw.print("<a target=\"_blank\"href='/Cam/cookieDemo4?id="+book.getId()+"'>"+book.getName()+"</a><br />");
		}
		//显示用户查看过的商品
		pw.print("<br />你曾经看过的商品<br />");
		Cookie[] cookies = req.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("bookHistory")) {
				String[] ids = cookies[i].getValue().split("\\,");
				for(String id:ids){
					Book book = (Book) Db.getAll().get(id);
					pw.print("<a target=\"_blank\"href='/Cam/cookieDemo4?id="+book.getId()+"'>"+book.getName()+"</a><br />");
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}

class Db{
	private static Map<String, Book> map = new LinkedHashMap<String, Book>();
	static{
		map.put("1", new Book("1","Liam","我莉","不争气"));
		map.put("2", new Book("2","Zayn","我渣","单飞"));
		map.put("3", new Book("3","Naill","奶儿","乡村奶"));
		map.put("4", new Book("4","Harry","卷妈","摇滚卷"));
		map.put("5", new Book("5","Louis","丝丝","电音丝"));
	}
	public static Map getAll(){
		return map;
	}
}

class Book{
	private String id;
	private String name;
	private String author;
	private String decoretion;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String id, String name, String author, String decoretion) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.decoretion = decoretion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDecoretion() {
		return decoretion;
	}

	public void setDecoretion(String decoretion) {
		this.decoretion = decoretion;
	}
}