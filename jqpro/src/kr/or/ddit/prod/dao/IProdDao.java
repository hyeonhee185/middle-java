package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdDao {

	/*prod목록 리스트 검색*/
	public List<ProdVO> prodNames(String prod_lgu) throws SQLException;
	
	/*prod상세정보 검색*/
	public ProdVO prodDetail(String pId) throws SQLException;
	
}
