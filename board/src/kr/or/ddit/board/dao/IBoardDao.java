package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {

	//게시글 저장
	public int insertBoard(BoardVO vo) throws SQLException;
	
	//전체 글 갯수 조회
	public int countList() throws SQLException;
	
	//게시글 조회
	public List<BoardVO> boardList(Map<String, Integer> map) throws SQLException;
	
	//댓글 저장
	public int insertReply(ReplyVO vo) throws SQLException;
	
	//댓글 조회
	public List<ReplyVO> replyList(int bonum) throws SQLException;
}
