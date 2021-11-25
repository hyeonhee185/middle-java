package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {

	//게시글 저장
	public int insertBoard(BoardVO vo);

	//전체 글 갯수 조회
	public int countList();

	//게시글 조회
	public List<BoardVO> boardList(Map<String, Integer> map);

	//댓글 저장
	public int insertReply(ReplyVO vo);

	//댓글 조회
	public List<ReplyVO> replyList(int bonum); 
	
}
