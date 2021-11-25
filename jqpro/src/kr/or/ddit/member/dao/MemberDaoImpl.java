package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.BuildedSqlMapClient;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.zip.vo.ZipVO;

public class MemberDaoImpl implements IMemberDao {

	private SqlMapClient smc;
	private static MemberDaoImpl dao;
	
	
	private MemberDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static IMemberDao getDao() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	
	@Override
	public String idCheck(String id) throws SQLException {
		return (String) smc.queryForObject("mem.idCheck", id);
	}

	@Override
	public List<ZipVO> searchCode(String dong) throws SQLException {
		return smc.queryForList("mem.searchCode", dong);
	}

	@Override
	public String insertMember(MemberVO vo) throws SQLException {
		return (String) smc.insert("mem.insertMember", vo);
	}

}
