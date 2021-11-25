package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDelete.do")
public class SessionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session 삭제하기
		
		// 1. Session객체 생성 또는 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		// 2. removeAttribute()메서드로 'Session값' 삭제하기
		//		==> Session자체는 삭제되지 않고 개별적인 세션값만 삭제된다.
		// 형식) session객체.removeAttribute("key값");
		//session.removeAttribute("testSession");
		
		// 3. invalidate()메서드로 Session자체 삭제하기
		// 형식) session객체.invalidate();
		session.invalidate();
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'");
		out.println("<title>Session 연습</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Session 삭제하기</h2><hr>");
		
		out.println("<a href='" + request.getContextPath() 
			+ "/basic/04/sessionTest.jsp'>시작문서로 가기</a>");
		
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
