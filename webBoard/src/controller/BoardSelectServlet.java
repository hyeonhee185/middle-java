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

@WebServlet("/boardSelect.do")
public class BoardSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IJdbcBoardService service = JdbcBoardServiceImpl.getInstance();
		
		int boardId = Integer.parseInt(request.getParameter("idx"));
		
		JdbcBoardVO boardVo = (JdbcBoardVO) service.getBoard(boardId);
		
		service.setCountIncrement(boardId);
		
		request.setAttribute("boardVo", boardVo);
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/WEB-INF/board/jdbcBoard/boardView.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
