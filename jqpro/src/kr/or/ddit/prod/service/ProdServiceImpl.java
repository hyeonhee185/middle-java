package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService{
	//Controller에 의해 호출되어 실제 비지니스 로직과 트랜잭션을 처리한다
	//DAO를 호출하여 DB CRUD처리후 Controller로 반환한다

	private IProdDao dao;
	private static IProdService service;
	
	//생성자
	private ProdServiceImpl(){
		//dao = new ProdDaoImpl() //private상태이기 때문에 호출할 수 없음(=싱글톤)
		dao = ProdDaoImpl.getDao();
	}
	
	public static IProdService getService() {
		
		if(service == null) service = new ProdServiceImpl();
		return service;
	}

	
	@Override
	public List<ProdVO> prodNames(String prod_lgu) {
		
		List<ProdVO> list= null;
		
		try {
			list = dao.prodNames(prod_lgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ProdVO prodDetail(String pId) {
		
		ProdVO vo = null;
		
		try {
			vo = dao.prodDetail(pId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}

	
	
}
