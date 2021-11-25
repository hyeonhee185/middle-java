package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionRead.do")
public class SessionReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장된 Session 읽어오기
		
		// 1. Session객체 생성 또는 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'");
		out.println("<title>Session 연습</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Session 데이터 확인하기</h2>");
		
		out.println("<h3>Session 데이터를 낱개로 확인하기</h3>");
		// 2. getAttribute()메서드로 Session값을 읽어온다.
		//	형식) session객체.getAttribute("key값");
		
		// 저장된 세션의 key값을 정확히 알고 있을 때 사용하는 방법
		String sessionValue = 
				(String) session.getAttribute("testSession");
		if(sessionValue==null) {
			out.println("<h3>testSession의 세션값은 없습니다.</h3>");
		}else {
			out.println("<h3>testSession값 : " + sessionValue + "</h3>");
		}
		out.println("<hr>");
		
		//세션에 저장된 모든 key값은 getAttributeNames()메서드를 통해서 구할 수 있다.
		out.println("<h3>전체 세션 데이터 확인하기</h3>");
		out.println("<ol>");
		Enumeration<String> sessionNames = session.getAttributeNames();
		int cnt = 0;
		while(sessionNames.hasMoreElements()) {
			cnt++;
			String sessionKey = sessionNames.nextElement();
			out.println("<li>" + sessionKey + " : "
					+ session.getAttribute(sessionKey) + "</li>");
		}
		if(cnt==0) {
			out.println("<li>세션 데이터가 하나도 없습니다.</li>");
		}
		out.println("</ol>");
		out.println("<hr>");
		
		out.println("<a href='" + request.getContextPath() 
				+ "/basic/04/sessionTest.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
