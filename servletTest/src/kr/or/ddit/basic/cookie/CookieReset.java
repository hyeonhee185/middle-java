//package kr.or.ddit.basic.cookie;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/CookieReset.do")
//public class CookieReset extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie[] cookieArr = request.getCookies();
//		
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		
//		out.println("<html><head><meta charset='utf-8'>");
//		out.println("<title>Cookie 연습</title></head>");
//		out.println("<body>");
//		out.println("<h2>저장된 cookie 데이터 삭제하기</h2");
//		
//		if(cookieArr==null || cookieArr.length==0) {
//			out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>");
//		}else {
//			for(Cookie cookie : cookieArr) {
//				String name = cookie.getName();
//				if("gender".equals(name)) {
//					cookie.setMaxAge(0);
//					response.addCookie(cookie);
//					out.println("쿠키변수가'" + name + "'인 쿠키를 삭제했습니다.<br>");
//				}
//			}
//		}
//		
//		out.println("<a href='" + request.getContextPath()
//			+ "/basic/03/cookieTest.jsp'>시작문서로 가기</a>");
//		
//		out.println("</body></html>");
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
