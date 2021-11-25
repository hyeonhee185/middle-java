package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.zip.vo.ZipVO;

/**
 * Servlet implementation class SearchCode
 */
@WebServlet("/SearchCode")
public class SearchCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); 
		
		//0.요청데이터 가져오기 - dong
		String dong = request.getParameter("dong");
		
		//1.service객체 얻어오기
		IMemberService service = MemberServiceImpl.getService();
		
		//2.service메소드 호출 - 결과 값 받기
		List<ZipVO> list = service.searchCode(dong);
		
		//3.결과 값을 저장- set Attribute 하고 jsp로 보내기 - forward
		request.setAttribute("zipCode", list);
		request.getRequestDispatcher("0709/codeResult.jsp").forward(request, response);
	}

}
