package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseTest02
 */
@WebServlet("/ResponseTest02.do")
public class ResponseTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	- redirect 
	 	==> 다른 페이지로 넘어가도록 한다.	 (직접 파라미터를 넘길 수 없다.)
	 	==> 응답 시 브라우저에게 '이동할 URL'을 전송하여 브라우저가 해당 URL로
	 		자동으로 이동 시켜주는 방식이다.
	 		이 때 이동은 GET방식으로 요청하기 때문에 URL의 길이에 제한이 있다.
	 	==> redirect는 request객체를 유지하지 못한다.
	 		(이유 : 브라우저에서 새롭게 요청하기 때문에...)
	*/
	// 형식) response.sendRedirect("이동할 URL주소");
	// 		이동할 URL주소는 '전체 URL주소를 기술한다.
		
		String userName = request.getParameter("username");
		
		response.sendRedirect(
				request.getContextPath() + 
				"/ResponseRedirect.do?username=" + userName +
				"&tel=010-9999-8888" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
