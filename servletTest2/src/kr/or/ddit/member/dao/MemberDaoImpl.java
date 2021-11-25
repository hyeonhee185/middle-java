package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	// 1번
	private static MemberDaoImpl dao;
	private SqlMapClient smc; // iBatis객체가 저장될 변수 선언

	// 2번
	private MemberDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}

	// 3번
	public static MemberDaoImpl getInstance() {
		if (dao == null)
			dao = new MemberDaoImpl();

		return dao;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("member.insertMember", memVo);
			if (obj == null)
				cnt = 1;

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			cnt = smc.delete("member.deleteMember", memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt = 0;

		try {
			cnt = smc.update("member.updateMember", memVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memList = new ArrayList<>();

		try {
			memList = smc.queryForList("member.getAllMember");
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}

		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		int count = 0; // 회원ID개수가 저장될 변수

		try {
			count = (int) smc.queryForObject("member.getMemberCount", memId);
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int memberUpdate2(Map<String, String> paramMap) {
		// Key값 정보 ==> 회원ID(memId), 수정할컬럼명(field), 수정할데이터(data)
		int cnt = 0;
		try {
			cnt = smc.update("member.memberUpdate2", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public MemberVO getMember(String memId) {
		MemberVO memvo = null;

		try {
			memvo = (MemberVO) smc.queryForObject("member.getMember", memId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memvo;
	}

}
