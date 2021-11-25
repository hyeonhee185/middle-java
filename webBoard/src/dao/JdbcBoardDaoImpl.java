package dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.JdbcBoardVO;

public class JdbcBoardDaoImpl implements IJdbcBoardDao {
	
	private static JdbcBoardDaoImpl dao;
	private SqlMapClient smc;
	
	private JdbcBoardDaoImpl() {
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			Reader rd = 
					Resources.getResourceAsReader("config/sqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static JdbcBoardDaoImpl getInstance() {
		if(dao==null) dao = new JdbcBoardDaoImpl();
		
		return dao;
		
	}


	@Override
	public int insertBoard(JdbcBoardVO boardVo) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("jdbcBoard.insertBoard", boardVo);
			if(obj==null) cnt = 1;
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;
		
		try {
			Object obj = smc.delete("jdbcBoard.deleteBoard", boardNo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
		int cnt = 0;
		
		try {
			Object obj = smc.delete("jdbcBoard.updateBoard", boardVo);
			if(obj==null) cnt = 1;
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<JdbcBoardVO> getAllBoardList() {
		List<JdbcBoardVO> jdbcList = new ArrayList<>();
		try {
			jdbcList = smc.queryForList("jdbcBoard.getAllBoardList");
			
		} catch (SQLException e) {
			jdbcList = null;
			e.printStackTrace();
		}
		
		return jdbcList;
		
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
		JdbcBoardVO jdbcList = null;
		
		try {
			
			jdbcList = (JdbcBoardVO) smc.queryForObject("jdbcBoard.getBoard", boardNo);
			
		} catch (SQLException e) {
			jdbcList = null;
			e.printStackTrace();
		}
		return jdbcList;
	}

	@Override
	public List<JdbcBoardVO> getSearchBoardList(String title) {
		List<JdbcBoardVO> jdbcList = null;
		
		try {
			
			jdbcList = smc.queryForList("jdbcBoard.getSearchBoardList",title);
			
		} catch (SQLException e) {
			jdbcList = null;
			e.printStackTrace();
		}
		return jdbcList;
	}

	@Override
	public int setCountIncrement(int boardNo) {
		int cnt = 0;
		
		try {
			
			Object obj = smc.update("jdbcBoard.setCountIncrement", boardNo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

}
