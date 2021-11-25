package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		Cookie[] cookies = request.getCookies();
		int count = 0;	// 카운트에 사용할 변수 선언 및 초기화
		// 쿠키변수 : count
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				String name = cookie.getName();	// 쿠키변수 구하기
				if("count".equals(name)) {
					String value = cookie.getValue();	//쿠키 값 구하기
					count = Integer.parseInt(value);
				}
			}
		}
		
		count++;	// 카운트 증가
		
		// 증가된 count가 저장된 쿠키객체 생성
		Cookie countCookie = new Cookie("count", String.valueOf(count));
		
		response.addCookie(countCookie);	 // 쿠키 저장
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'");
		out.println("<title>Cookie Count 연습</title></head>");
		out.println("<body>");
		out.println("<h2>어서오세요. 당신은" + count + "번째 방문입니다.</h2>");
		out.println("<br><br><br>");
		out.println("<a href='" + request.getContextPath()
			+ "/cookieCountServlet.do'>카운트 증가하기</a>");
		out.println("<a href='" + request.getContextPath()
			+ "/basic/03/cookieTest02.jsp'>시작문서로 이동하기</a>");
		out.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
