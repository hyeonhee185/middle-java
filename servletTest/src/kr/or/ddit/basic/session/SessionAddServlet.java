package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionAdd.do")
public class SessionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session 저장하기 
		
		// 1. Session객체 생성 또는 현재 세션 가져오기
		// 형식) request객체.getSession(); 또는 request객체.getSession(true); 
		// 		==> 현재 세션이 존재하면 현재 세션을 반환하고, 
		//			존재하지 않으면 새로운 세션을 생성해서 반환한다.
		// 형식) request객체.getSession(false);
		// 		==> 현재 세션이 존재하면 현재 세션을 반환하고, 
		//			존재하지 않으면 새로운 세션을 생성하지 않고 null을 반환한다.
		HttpSession session = request.getSession();
		
		// 2. setAttribute()메서드를 사용해서 session값을 저장한다.
		// 형식) session객체.setAttribute("key값", session값);
		// 		==> 'key값'은 문자열, 'session값'모든 데이터를 사용할 수 있다.
		session.setAttribute("testSession", "연습용 세션입니다.");
		session.setAttribute("userName", "홍길동");
		session.setAttribute("age", 33);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'");
		out.println("<title>Session 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Session 데이터가 저장 되었습니다.</h2><br><br>");
		out.println("<a href='" 
				+ request.getContextPath()
				+ "/basic/04/sessionTest.jsp'>시작 문서로 가기</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}















