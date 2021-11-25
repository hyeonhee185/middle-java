package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdController
 */
@WebServlet("/Prod.do")
public class ProdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0. 요청 데이터 가져오기 - gu
		String gu = request.getParameter("gu");
		
		//1. Service클래스 객체 얻어오기
		IProdService service = ProdServiceImpl.getService();
		
		//2. Service클래스 메소드 호출하기 - 결과 값 리턴 받기
		List<ProdVO> list = service.prodNames(gu);
		
		// json형태의 응답데이터 생성 -을 jsp로 위임하기 - 결과 값 보내기
		//3. 결과 값을 request에 저장하기
		request.setAttribute("listValue", list);
		
		//4. jsp로 포워딩 - Servlet의 request객체 변수를 jsp에서 공유한다
		RequestDispatcher disp = request.getRequestDispatcher("0707/prodNames.jsp");
		disp.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//0. 요청 데이터 가져오기 - id
		String pId = req.getParameter("id");
				
		//1. Service클래스 객체 얻어오기
		IProdService service = ProdServiceImpl.getService();
		
		//2. Service클래스 메소드 호출하기 - 결과 값 리턴 받기
		ProdVO vo = service.prodDetail(pId);
		
		// json형태의 응답데이터 생성 -을 jsp로 위임하기 - 결과 값 보내기
		//3. 결과 값을 request에 저장하기
		req.setAttribute("voValue", vo);
		
		//4. jsp로 포워딩 - Servlet의 request객체 변수를 jsp에서 공유한다
		RequestDispatcher disp = req.getRequestDispatcher("0707/prodDetail.jsp");
		disp.forward(req, resp);
	}

	
	
	

}
