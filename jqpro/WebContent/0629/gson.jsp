<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonParser"%>
<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>Insert title here</title>
</head>
<body>
<% 
//json데이터를 문자열로 parsing
String str = "[{\"NO\" : 1, \"NAME\" : \"APPLE\", \"KOR\" : \"사과\", \"PRICE\" : \"1000\"},"
			+ "{\"NO\" : 2, \"NAME\" : \"BANANA\", \"KOR\" : \"바나나\", \"PRICE\" : \"500\"},"
			+ "{\"NO\" : 3, \"NAME\" : \"MELON\", \"KOR\" : \"메론\", \"PRICE\" : \"2000\"} ]";

//파싱을 위해 JsonParser객체 생성
JsonParser jsonParser = new JsonParser();

//JsonArray선언하고 JsonParser로 문자열을 파싱
JsonArray jsonArray = (JsonArray)jsonParser.parse(str);

//loop돌며 jsonArray안의 object를 빼내어 값 추출 (jsonArray의 크기는 object의 수)
for(int i=0; i<jsonArray.size(); i++){
	JsonObject obj = (JsonObject)jsonArray.get(i);
	
	String no = obj.get("NO").getAsString();
	String name = obj.get("NAME").getAsString();
	String kor = obj.get("KOR").getAsString();
	String price = obj.get("PRICE").getAsString();
%>
<p>NO : <%=no + " NAME : " + name + " KOR : " + kor %> ,가격은 <%=price %> 입니다 </p>
<%
// 	System.out.println(no);
// 	System.out.println(name);
// 	System.out.println(kor);
// 	System.out.println(price);
}//for문 end


//ObjcetArray에 key가 있는 경우
str = "{\"fruit\" : [{\"NO\" : 1, \"NAME\" : \"APPLE\", \"KOR\" : \"사과\", \"PRICE\" : \"1000\"},"
				+ "{\"NO\" : 2, \"NAME\" : \"BANANA\", \"KOR\" : \"바나나\", \"PRICE\" : \"500\"},"
				+ "{\"NO\" : 3, \"NAME\" : \"MELON\", \"KOR\" : \"메론\", \"PRICE\" : \"2000\"} ],"
	+	"\"animal\" : [{\"NO\" : 1, \"NAME\" : \"CAT\", \"KOR\" : \"고양이\", \"AGE\" : \"3\"},"
					+ "{\"NO\" : 2, \"NAME\" : \"DOG\", \"KOR\" : \"개\", \"AGE\" : \"5\"},"
					+ "{\"NO\" : 3 \"NAME\" : \"TIGER\", \"KOR\" : \"호랑이\", \"AGE\" : \"30\"} ]}";

//파싱을 위해 JsonParser객체 생성
JsonParser parser = new JsonParser();

//JsonParser를 Object로 먼저 파싱
JsonObject jsonObj = (JsonObject)parser.parse(str);

//object에서 key를 get하여 Array에 담는다
JsonArray arr = (JsonArray)jsonObj.get("fruit");

for(int i=0; i<arr.size(); i++){
	
	JsonObject obj = (JsonObject)arr.get(i);
	
	System.out.println("번호 : " + obj.get("NO"));
	System.out.println("이름 : " + obj.get("NAME"));
	System.out.println("한글 : " + obj.get("KOR"));
	System.out.println("가격 : " + obj.get("PRICE"));
	System.out.println();
	
}


%>

</body>
</html>