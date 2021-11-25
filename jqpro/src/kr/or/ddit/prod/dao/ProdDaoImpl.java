package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.BuildedSqlMapClient;
import kr.or.ddit.prod.vo.ProdVO;

/*
 * sql구문을 실행하기 위한 class
 * SqlMapClient객체가 필요하다
 * 
 * daoImpl클래스는 serviceImpl클래스에서 사용한다
 * ㄴ자신의 객체를 생성해서 리턴하는 메소드 -getXX  
 * 
 */

public class ProdDaoImpl implements IProdDao {

	private SqlMapClient smc;
	private static ProdDaoImpl dao;
	
	//생성자 -private함으로서 다른 서비스에 객체 생성(new)하지 않는다 => 싱글톤 방식
	private ProdDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static IProdDao getDao(){
		if(dao == null) dao = new ProdDaoImpl();
		return dao;
	}
	
	@Override
	public List<ProdVO> prodNames(String prod_lgu) throws SQLException {

//		List prodList = smc.queryForList("namespace.id", prod_lgu);
//		return prodList;
		return smc.queryForList("prod.prodNames", prod_lgu);
	}

	@Override
	public ProdVO prodDetail(String pId) throws SQLException {
		return (ProdVO) smc.queryForObject("prod.prodDetail", pId);
	}

}
