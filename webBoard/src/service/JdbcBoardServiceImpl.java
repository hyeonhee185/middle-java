package service;

import java.util.List;

import dao.IJdbcBoardDao;
import dao.JdbcBoardDaoImpl;
import vo.JdbcBoardVO;

public class JdbcBoardServiceImpl implements IJdbcBoardService {
	
	private IJdbcBoardDao boardDao;
	
	private static JdbcBoardServiceImpl service;
	
	private JdbcBoardServiceImpl() {
		boardDao = JdbcBoardDaoImpl.getInstance();
	}
	
	public static JdbcBoardServiceImpl getInstance() {
		if(service==null) service = new JdbcBoardServiceImpl();
		
		return service;
	}
	

	@Override
	public int insertBoard(JdbcBoardVO boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return boardDao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
		return boardDao.updateBoard(boardVo);
	}

	@Override
	public List<JdbcBoardVO> getAllBoardList() {
		return boardDao.getAllBoardList();
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
		return boardDao.getBoard(boardNo);
	}

	@Override
	public List<JdbcBoardVO> getSearchBoardList(String title) {
		return boardDao.getSearchBoardList(title);
	}

	@Override
	public int setCountIncrement(int boardNo) {
		return boardDao.setCountIncrement(boardNo);
	}

}
