package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.zip.vo.ZipVO;

public interface IMemberDao {

	//id 중복체크
	public String idCheck(String id) throws SQLException;
	
	//우편번호검색
	public List<ZipVO> searchCode(String dong) throws SQLException;
	
	//회원정보 입력
	public String insertMember(MemberVO vo) throws SQLException;
}
