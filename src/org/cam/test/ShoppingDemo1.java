package org.cam.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShoppingDemo1 extends HttpServlet{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
			
			PrintWriter pw = resp.getWriter();
			
			//���������Ʒ��Ϣ
			pw.print("����վ��������ַ��<br />");
			Map<String, Web> map = Db.getAll();
			Set set = map.entrySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				Map.Entry<String, Web> entry = (Entry<String, Web>) it.next();
				Web web = entry.getValue();
				pw.print("<a target=\"_blank\"href='/Cam/shoppingDemo2?id="+web.getId()+"'>"+"<img src='/Cam/images/"
						+ web.getId()
						+ ".jpg' width='120px' height='100px'>"+web.getTitle()+web.getName()+"</a><br />");
			}
			//��ʾ�û��鿴������Ʒ
			pw.print("<br />���������������ַ��<br />");
			Cookie[] cookies = req.getCookies();
			for (int i = 0; cookies != null && i < cookies.length; i++) {
				if (cookies[i].getName().equals("webHistory")) {
					String[] ids = cookies[i].getValue().split("\\,");
					for(String id:ids){
						Web web = (Web) Db.getAll().get(id);
						pw.print("<a target=\"_blank\"href='/Cam/shoppingDemo2?id="+web.getId()+"'>"+"<img src='/Cam/images/"
								+ web.getId()
								+ ".jpg' width='100px' height='80px'>"+web.getTitle()+web.getName()+"</a><br />");
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
		private static Map<String, Web> map = new LinkedHashMap<String, Web>();
		static{
			map.put("1", new Web("1","yd","�й��ƶ�"));
			map.put("2", new Web("2","lt","�й���ͨ"));
			map.put("3", new Web("3","dx","�й�����"));
			map.put("4", new Web("4","jz","�й��������"));
			map.put("5", new Web("5","zf","�й�����"));
		}
		public static Map getAll(){
			return map;
		}
	}

	class Web{
		private String id;
		private String title;
		private String name;
		
		public Web() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Web(String id, String title, String name) {
			super();
			this.id = id;
			this.title = title;
			this.name = name;
		}
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
}
