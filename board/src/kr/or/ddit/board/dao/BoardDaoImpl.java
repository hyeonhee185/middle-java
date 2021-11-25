package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.BuildedSqlMapClient;

public class BoardDaoImpl implements IBoardDao {
	
	private SqlMapClient client;
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() {
		client = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static IBoardDao getDao() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}

	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		//내부적으로 래퍼 클래스인 피연산자를 오토언박싱하여 기본 타입끼리의 연산을 수행하고 있는 것입니다.
		return (int)client.insert("board.insertBoard", vo);
	}

	@Override
	public int countList() throws SQLException {
		return (int) client.queryForObject("board.countList");
	}

	@Override
	public List<BoardVO> boardList(Map<String, Integer> map) throws SQLException {
		return client.queryForList("board.boardList", map);
	}

	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		return (int) client.insert("board.insertReply", vo);
	}

	@Override
	public List<ReplyVO> replyList(int bonum) throws SQLException {
		return client.queryForList("board.replyList", bonum);
	}

}
