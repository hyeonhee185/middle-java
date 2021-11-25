package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberInsert.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// form에서 입력한 데이터 받아오기
		String memId = request.getParameter("mem_id");
		String memPass = request.getParameter("mem_pass");
		String memName = request.getParameter("mem_name");
		String memTel = request.getParameter("mem_tel");
		String memAddr = request.getParameter("mem_addr");

		// 받아온 데이터를 VO객체에 담기
		MemberVO memvo = new MemberVO();
		memvo.setMem_id(memId);
		memvo.setMem_pass(memPass);
		memvo.setMem_name(memName);
		memvo.setMem_tel(memTel);
		memvo.setMem_addr(memAddr);

		IMemberService service = MemberServiceImpl.getInstance();
		service.insertMember(memvo); // DB에 insert

		// 회원목록 이동
		response.sendRedirect(request.getContextPath() + "/member/memberList.do");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
