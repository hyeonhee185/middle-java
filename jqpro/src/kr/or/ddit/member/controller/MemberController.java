package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/Member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//요청데이터 받기
		String mId = request.getParameter("mId");
		
		//service객체 얻어오기
		IMemberService service = MemberServiceImpl.getService();
		
		//service 메소드 호출 - 값 얻기
		String idCheck = service.idCheck(mId);
		
		//jsp로 값 전달하기 - forward
		request.setAttribute("idCheck", idCheck);
		RequestDispatcher disp = request.getRequestDispatcher("0709/idCheck.jsp");
		disp.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청데이터 받기 - 9개 data를 받아서 처리
		MemberVO vo = new MemberVO();
		try {
			BeanUtils.populate(vo, req.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//service객체 얻어오기
		IMemberService service = MemberServiceImpl.getService();

		//service 메소드 호출 - 값 얻기
		String insert = service.insertMember(vo);
		if(insert == "success") {
			req.setAttribute("uId", vo.getMem_id());
		}else{
			req.setAttribute("uId", null);
		}
		//jsp로 값 전달하기 - forward
		req.getRequestDispatcher("0709/insert.jsp").forward(req, resp);
	}

	
	

}
