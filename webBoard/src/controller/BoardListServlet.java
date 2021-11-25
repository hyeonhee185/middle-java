package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IJdbcBoardService;
import service.JdbcBoardServiceImpl;
import vo.JdbcBoardVO;

@WebServlet("/boardList.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IJdbcBoardService service = JdbcBoardServiceImpl.getInstance();
		 
		String title = request.getParameter("searchTitle");
		System.out.println(title);
		
		List<JdbcBoardVO> boardList = null;
		
		if(title=="") {
			boardList = service.getAllBoardList();		
			System.out.println("1");
		}else {
			boardList = service.getSearchBoardList(title);
			System.out.println("2");
		}
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/WEB-INF/board/jdbcBoard/boardList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
