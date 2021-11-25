package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieAdd.do")
public class CookieAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// Cookie 저장하는 방법
		// 1. Cookie객체 생성한다. == '쿠키변수'와 '쿠키값'은 문자열로 지정한다.
		//	형식) Cookie cookie변수 = new Cookie("쿠키변수", "쿠키값");
		//	   ==> '쿠키값'으로 한글을 사용할 경우 URLEncoder.encode()메서드로
		//		   인코딩한 후 사용한다.
		
		// 하나의 쿠키는 4KB(4096byte)까지 저장 가능하다.
		// 총 300개까지 저장할 수 있고, 하나의 도메인에는 20개까지 저장할 수 있다.(무한개 저장은 불가하다~~)
		
		Cookie nameCookie = new Cookie("name", 
						URLEncoder.encode("홍길동", "utf-8"));
		//Cookie ageCookie = new Cookie("age", "30");
		Cookie ageCookie = new Cookie("age", String.valueOf(30) );
		Cookie genderCookie = new Cookie("gender", "male");
		
		/*
		// 2. 쿠키 속성 설정하기
		cookie변수.setPath("적용경로"); ==> 지정한 경로와 그 하위 경로에서 사용 가능하다.
		cookie변수.setMaxAge(유지시간); ==> 단위(초)
									 ==> 음수(기본값):브라우저가 종료되면 바로 삭제되고 
									 ==> 0 : 즉시 삭제된다.
		cookie변수.setDomain("적용도메인명");
			==> 예) ".ddit.or.kr"  ==> www.ddit.or.kr, www2.ddit.or.kr
		cookie변수.setSecure(보안여부);  // true:보안적용, false:보안미적용(기본값)
		*/
		// 3. response객체를 이용하여 쿠키를 웹브라우저로 보내면 웹브라우저가
		//	이 쿠키를 받아서 저장한다.
		// 형식) response.addCookie(1번에서 만든 쿠키변수);
		nameCookie.setMaxAge(-1);
		ageCookie.setMaxAge(-1);
		genderCookie.setMaxAge(-1);
		
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genderCookie);
		
		out.println("<html><head><meta charset='utf-8'");
		out.println("<title>Cookie연습</title></head>");
		out.println("<body>");
		out.println("<h2>Cookie 데이터를 저장했습니다.</h2><br><br>");
		out.println("<a href='" + request.getContextPath() 
				+ "/basic/03/cookieTest.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}











