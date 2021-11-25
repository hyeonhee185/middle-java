package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.zip.vo.ZipVO;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getDao();
	}
	
	public static IMemberService getService() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public String idCheck(String id) {
		
		String mId = null;
		try {
			mId = dao.idCheck(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mId;
	}

	@Override
	public List<ZipVO> searchCode(String dong) {
		
		List<ZipVO> list = null;
		
		try {
			list = dao.searchCode(dong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String insertMember(MemberVO vo) {
	
		String a = null;
		
		try {
			dao.insertMember(vo);
			a = "success"; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			a = "error";
		}
		return a;
	}

}
