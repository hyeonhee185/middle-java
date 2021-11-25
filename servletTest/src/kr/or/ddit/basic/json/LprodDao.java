package kr.or.ddit.basic.json;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.DBUtil;

public class LprodDao {
	public List<LprodVO> getLprodList(){
		Connection con = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		List<LprodVO> lprodList = new ArrayList<LprodVO>();
		try {
			con = DBUtil.getConnection();
			String sql = "select * from lprod";
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				LprodVO lvo = new LprodVO();
				lvo.setLprod_id(rs.getInt("lprod_id"));
				lvo.setLprod_gu(rs.getString("lprod_gu"));
				lvo.setLprod_nm(rs.getString("lprod_nm"));
				lprodList.add(lvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
			if(con!=null) try {con.close();}catch(SQLException e) {}
		}
		
		return lprodList;
	}
}
