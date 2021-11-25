package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	이 예제는 애노테이션을 이용하여 Servlet을 설정하여 처리하는 예제이다.
 	(애노테이션 이름 : @WebServlet)
 	애노테이션은 servlet버전 3.0이상에서 사용할 수 있다.
*/
/* 
	@WebServlet 애너테이션의 속성들
	1. name : 서블릿 이름을 설정한다.(기본값 : 빈문자열(""))
	2. urlPatterns : 서블릿의 URL패턴의 목록을 설정한다.(기본값 : 빈배열( {} ))
		예) 패턴이 1개일 경우 ==> urlPatterns="/url" 또는 urlPatterns={"/url"}
		예) 패턴이 2개 이상일 경우 ==> urlPatterns={"/url1", "/url2", ...}
	3. value : urlPatterns와 동일한 기능을 한다.
	4. description : 주석 (설명글)을 설정한다.
*/
@WebServlet(urlPatterns= {"/servletTest02.lee"}, 
	description="애노테이션을 이용한 서블릿 설정 예제" )

public class ServletTest02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");  // 응답 문서의 인코딩 방식 지정
		response.setContentType("text/html; charset=utf-8");  // 응답 문서의 ContentType 지정
		
		// 처리한 내용을 응답으로 보내기 위한 PrintWriter객체 생성하기
		PrintWriter out = response.getWriter();
		
		// 처리한 내용을 출력한다.
		// 방법2 : print(), println()메서드 이용하기
		out.print("<html");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>두번째 Servlet연습</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 style='text-align:center; color:red;'>");
		out.println("두번째 Servlet예제 입니다.<br>");
		out.println("이것은 애노테이션으로 설정한 Servlet입니다.");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	
	// doPost()메서드 ==> POST방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
	
	
	
}
