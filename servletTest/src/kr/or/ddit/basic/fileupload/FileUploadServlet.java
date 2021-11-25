package kr.or.ddit.basic.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/*
 	- Servlet 3.0이상에서 파일 업로드를 하려면 서블릿에 @MultipartConfig 애노테이션을 
 	  설정해야 한다.
 	- @MultipartConfig 애노테이션에서 설정할 변수
 		1) location : 업로드한 파일이 임시적으로 저장될 경로 지정(기본값: "")
 		2) fileSizeThreshold : 이 속성에 지정한 값보다 실제 파일 크기가 크면
 				location에 지정한 경로에 저장한다.
 				(단위:byte, 기본값:0(무조건 임시디렉토리에 저장하기))
 		3) maxFileSize : 1개의 파일의 최대 크기 지정(단위:byte, 기본값: -1(무제한))
 		4) maxRequestSize : 서버로 전송되는 Request 전체의 최대 크기 지정
 					(단위:byte, 기본값: -1(무제한))
 				
*/
@WebServlet("/fileUpload.do")
@MultipartConfig(
		fileSizeThreshold=1024*1024*10, maxFileSize = 1024*1024*30,
		maxRequestSize=1024*1024*50 )
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 한 파일이 실제 저장될 서버쪽의 경로 설정
		String uploadPath = "d:/D_Other/uploadFile";
		
		// 저장될 폴더가 없으면 생성한다.
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		request.setCharacterEncoding("utf-8");
		
		// 파일이 아닌 데이터는 getParameter()메서드나 getParameterValues()메서드를
		// 이용해서 구한다.
		String memId = request.getParameter("memid");
		System.out.println("일반 파라미터 데이터: " + memId);
		
		String fileName = "";	// 파일명이 저장될 변수명
		
		// 업로드한 파일 정보가 저장될 List객체
		List<UploadDetail> fileList = new ArrayList<>();
		
		/*
		 Servlet 3.0이상에 새롭게 추가된 Upload용 메서드
		 1) request.getParts(); ==> 전체 Part객체가 저장된 컬렉션 객체를 반환한다.
		 2) request.getPart("part이름"); ==> 지정된 이름을 가진 Part객체를 반환한다.
		 */
		for(Part part : request.getParts()) {
			// Part영역에서 파일명 구하기
			fileName = extractFileName(part);
			
			// 구한 파일명이 공백("")이면 이것은 파일 데이터가 아닌 일반 파라미터라는 의미이다.
			if(!"".equals(fileName)) {
				// 1개의 업로드 파일 정보를 저장할 객체 생성
				UploadDetail detail = new UploadDetail();
				
				detail.setFileName(fileName);
				// part.getSize() ==> 업로드된 파일의 크기를 byte단위로 반환한다.
				detail.setFileSize((int)Math.ceil( part.getSize()/1024.0));
				
				try {
					// 파일 내용을 지정한 경로 및 파일명으로 저장한다.
					part.write(uploadPath + File.separator + fileName);
					
					detail.setUploadStatus("Success");
					
				} catch (IOException e) {
					detail.setUploadStatus("Fail : " + e.getMessage());
				}
				fileList.add(detail);
			}
			
		}	// for문 끝..
		
		request.setAttribute("memId", memId);
		request.setAttribute("uploadFileList", fileList);
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("/basic/fileupload/uploadFiles.jsp");
		rd.forward(request, response);
		
		
	}	// doPost()메서드 끝...
	
	// Part에서 읽어올 '파일명'을 찾아 반환하는 메서드
	/*
	1) 파일이 아닐 때(즉, 일반 파라미터 일 경우)
	----------verysfslk1232156132		  ==> 각 Part를 구분하는 구분선
	Content-Disposition: form-data; name='memid'	==> 파라미터명
										  ==> 빈줄
	a001								  ==> 파라미터 값
	 
	2) 파일일 경우
	----------verysfslk1232156132		  ==> 각 Part를 구분하는 구분선
	Content-Disposition: form-data; name='uploadFile1'; filename="text1.txt"	==> 파일 정보
	Content-Type: text/plain			  ==> 파일 종류
										  ==> 빈줄
	abcd1234가나다라						  ==> 파일 내용
	
	*/
	private String extractFileName(Part part) {
		String fileName = "";
		
		// Content-Disposition 헤더 값 구하기
		String contentDisposition = part.getHeader("Content-disposition");
		String[] items = contentDisposition.split(";");
		for(String item: items) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		
		
		return fileName;
	}
}

