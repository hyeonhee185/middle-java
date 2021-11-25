package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseRedirectTest
 */
@WebServlet("/ResponseRedirect.do")
public class ResponseRedirectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("username");
		String tel = request.getParameter("tel");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Response Redirect연습</title></head>");
		out.println("<body>");
		out.println("<h2>Response Redirect 결과</h2><hr>");
		out.println("<ul>");
		out.println("<li>이 름 : " + userName + "</li>");
		out.println("<li>전화번호 : " + tel + "</li>");
		out.println("</ul>");
		out.println("</body></html>");
	}

	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      // TODO Auto-generated method stub
		      doGet(request, response);
		   }

}