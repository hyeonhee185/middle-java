package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IJdbcBoardService;
import service.JdbcBoardServiceImpl;
import vo.JdbcBoardVO;



@WebServlet("/boardUpdate.do")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/board/jdbcBoard/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int boardId = Integer.parseInt(request.getParameter("idx"));
		
		JdbcBoardVO boardVo = new JdbcBoardVO();
		
		boardVo.setBoard_no(boardId);
		boardVo.setBoard_title(title);
		boardVo.setBoard_content(content);
		
		IJdbcBoardService service = JdbcBoardServiceImpl.getInstance();
		service.updateBoard(boardVo);
		
		response.sendRedirect(request.getContextPath() + "/boardList.do");
		
	}

}
