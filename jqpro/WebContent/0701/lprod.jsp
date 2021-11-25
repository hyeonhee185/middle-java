<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//1. Driver Class 로딩 -> 객체생성 -> DriverManager에 등록
//Class.forName() 메소드를 통해 DriverManager 생성
Class.forName("oracle.jdbc.driver.OracleDriver");

//2. Connection객체 -> DB Connection연결
//DriverManager클래스 : JDBC드라이버를 통해 Connection을 만드는 역할
String url = "jdbc:oracle:thin:@localhost:1521:XE";
Connection con = DriverManager.getConnection(url, "sem", "java");

//3. sql문장을 실행하기 위한 객체 - Statement
//실제 DB에 쿼리를 보내기 위해 필요한 객체
//이 객체는 Connection객체의 연결정보를 가져와 DB에 접근하므로 이 객체의 사용전에 Connection객체가 먼저 존재해야 함
Statement stmt = con.createStatement();

//4. sql문 작성
String sql = "select * from lprod";

//5. 실행 - ResultSet으로 리턴
//executeQuery(String sql)을 통해 쿼리를 실행하면 ResultSet타입으로 반환해 결과값을 저장 - select문 실행시 사용
ResultSet rs = stmt.executeQuery(sql);

//6. 결과 가져오기

%>
[
<%
int i=0;

while(true){
	if(!rs.next()) break;
	String id = rs.getString("lprod_id");
	String gu = rs.getString("lprod_gu");
	String nm = rs.getString("lprod_nm");
	
	//json데이터 생성
	if(i > 0) out.print(",");
%>	
	{
		"id"	: "<%=id %>",
		"gu"	: "<%=gu %>",
		"nm"	: "<%=nm %>"
	}
<%	
	i++;
}//while end
%>
]


