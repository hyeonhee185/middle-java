package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/List")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한글데이터 포함시 characterset
		request.setCharacterEncoding("utf-8");
	
		//0. 요청데이터 받기 - page
		int spage = 1; //현재 페이지
		spage = Integer.parseInt(request.getParameter("page"));
		
		//한 화면에 표시되는 페이지의 갯수
		int perPage = 2;
		
		//한 페이지에 출력할 글의 갯수
		int perList = 5;
		
		//1. 서비스객체 얻기
		IBoardService service = BoardServiceImpl.getService();
		
		//전체 글 갯수 조회
		int count = service.countList();
		
		//전체 페이지 수 = 전체 글 갯수 / perList
		int totalPage = (int) Math.ceil(count/perList);
		
		//각 페이지 별 게시글의 start, end
		//현재 한페이지의 개시글(perList) 갯수 : 5
		//if 현재 페이지 1일때 : (1-1)*5 + 1= 1
		//if 현재 페이지 2일때 : (2-1)*5 + 1= 6
		//if 현재 페이지 3일때 : 11 / 4일때 16 / 5일때 21 ...
		int start = (spage-1)*perList + 1;
		
		//if 현재 페이지 1일때 : 1+5-1 = 5
		//if 현재 페이지 2일때 : 6+5-1 = 10
		//if 현재 페이지 3일때 : 11+5-1 = 15...
		int end  = start + perList - 1;
		if(end>count) end = count;
		
		//페이지의 번호
		//if 현재 페이지 1일때 : ((1-1)/2*2)+1 = 1
		//if 현재 페이지 2일때 : ((2-1)/2*2)+1 = 1
		//if 현재 페이지 3일때 : ((3-1)/2*2)+1 = 3
		//if 현재 페이지 4일때 : ((4-1)/2*2)+1 = 3 ...
		int startPage = ((spage-1)/perPage * perPage)+1;
		//if 현재 페이지 1일때 : 1+2-1=2
		//if 현재 페이지 2일때 : 1+2-1=2
		//if 현재 페이지 3일때 : 3+2-1=4
		//if 현재 페이지 4일때 : 3+2-1=4 ...
		int endPage = startPage + perPage - 1;
		if(endPage>totalPage)endPage = totalPage;
		
		//2. 서비스 메소드 호출 - 결과 값 받기
		Map<String, Integer>map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list = service.boardList(map);
		
		//3. 결과 값 request에 저장하고 forward
		request.setAttribute("list", list);
		
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPage", totalPage);
		
		request.getRequestDispatcher("board/list.jsp").forward(request, response);
	
	}

}
