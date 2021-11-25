package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// JDBC드라이버를 로딩하고 Connection객체를 생성하여 반환하는 메서드로 구성된 class이다.
public class DBUtil {
	// 인스턴스 초기화 블럭 : {}
	// static 초기화 블럭 : static {}
	static { // static 초기화 블럭
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 오라클만 가능
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
		               "jdbc:oracle:thin:@localhost:1521:xe",
		               "JHH94", "java");
		} catch (SQLException e) {
			System.out.println("오라클 DB 연결 실패~~~");
			return null;
		}
	}
	
	
	
}
