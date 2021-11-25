package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.zip.vo.ZipVO;

public interface IMemberService {

	//id 중복체크
	public String idCheck(String id);

	//우편번호검색
	public List<ZipVO> searchCode(String dong);

	//회원정보 입력
	public String insertMember(MemberVO vo);
	
}
