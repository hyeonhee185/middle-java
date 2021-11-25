package kr.or.ddit.basic.fileupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileDownload.do")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘어오는 filename구하기
		String fileName = request.getParameter("filename");
		
		String downloadPath = "d:/D_Other/uploadFile";
		String filePath = downloadPath + File.separator + fileName;
		
		File file = new File(filePath);
		
		if(file.exists()) {	 // 다운로드할 파일이 있는 경우
			// ContentType 설정
			response.setContentType("application/octet-stream; charset=utf-8");
			
			// response 헤더에 Content-Disposition속성을 설정한다.
			String headerKey = "Content-Disposition";
			//String headerValue = "attachment; filename=\"" + fileName + "\";";
			
			String downFilename = getDisposition(fileName, getBrowser(request));
			String headerValue = "attachment; filename=\"" + downFilename + "\";";
			
			response.setHeader(headerKey, headerValue);
			
			// 입출력할 스트림 객체 선언
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				// 출력용 스트림 객체 생성 ==> Response객체 이용
				bos = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				bis = new BufferedInputStream(new FileInputStream(file));
				
				byte[] buffer = new byte[1024];
				int len = -1;
				
				// byte배열을 이용해서 파일 내용을 읽어와 출력용 스트림으로 출력한다.
				while((len = bis.read(buffer)) > 0) {
					bos.write(buffer, 0, len);
				}
				
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(bis!=null) { bis.close(); }
				if(bos!=null) { bos.flush(); bos.close(); }
			}

		}else {	 // 다운로드할 파일이 없는 경우
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>" + fileName + "파일은 존재하지 않습니다.");
		}
		
	}
	
	// 사용자의 브라우저를 알아내는 메서드
	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		System.out.println("User-Agent : " + header);
		if(header.indexOf("MSIE")>-1) {
			return "MSIE";
		}else if(header.indexOf("Chrome")>-1) {
			return "Chrome";
		}else if(header.indexOf("Opera")>-1) {
			return "Opera";
		}else if(header.indexOf("Trident/7.0")>-1) {	// IE 11이상
			return "MSIE";
		}
		return "Firefox";
	}
	
	//브라우저별로 한글 파일명을 인코딩하는 메서드
	private String getDisposition(String filename, String browser) {
		String encodedFilename = null;
		try {
			if(browser.equals("MSIE")) {
				encodedFilename = URLEncoder.encode(filename, "utf-8").replaceAll("\\+","%20");
			}else if (browser.equals("Firefox")) {
				encodedFilename = "\"" + new String(filename.getBytes("utf-8"), "8859_1") + "\"";
			}else if (browser.equals("Opera")) {
				encodedFilename = "\"" + new String(filename.getBytes("utf-8"), "8859_1") + "\"";
			}else if (browser.equals("Chrome")) {
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<filename.length(); i++) {
					char c = filename.charAt(i);
					if(c > '~') {
						sb.append(URLEncoder.encode("" + c, "utf-8"));
					}else {
						sb.append(c);
					}
				}
				encodedFilename = sb.toString();
			}else {
				throw new RuntimeException("지원하지 않는 브라우저입니다."); 
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
		}
		return encodedFilename;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
