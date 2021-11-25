package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdService {

	//메소드 선언
	
	/*prod목록 리스트 검색*/
	public List<ProdVO> prodNames(String prod_lgu);

	/*prod상세정보 검색*/
	public ProdVO prodDetail(String pId);
	
	
}
