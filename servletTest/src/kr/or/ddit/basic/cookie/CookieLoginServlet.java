package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// userid, pass, checkid 값 받아오기
		String userId = request.getParameter("userid");
		String pass = request.getParameter("pass");
		String chkid = request.getParameter("checkid");
		
		// 우선 쿠키 생성하기
		Cookie cookie = new Cookie("userId", userId);
		
		//System.out.println("checkbox 체크 여부 : " + chkid);
		
		// 체크박스의 체크 여부에 따라 쿠키 저장하기
		if(chkid!=null) { // 체크박스가 체크되었을 때
			response.addCookie(cookie);	// 쿠키 저장
		}else {	// 체크박스가 체크가 안되었을 때
			cookie.setMaxAge(0);	// 쿠키의 유지 시간을 0으로 설정한 후 저장
			response.addCookie(cookie);
		}
		
		if(userId!=null && pass!=null) {
			if(userId.equals("test") && pass.equals("1234")) {
				response.sendRedirect(
						request.getContextPath() + "/basic/03/cookieMain.jsp");
			}else {
				response.sendRedirect(
						request.getContextPath() + "/basic/03/cookieLogin.jsp");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


