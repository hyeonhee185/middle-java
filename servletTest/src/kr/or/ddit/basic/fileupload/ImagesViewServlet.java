package kr.or.ddit.basic.fileupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이미지 파일을 읽어오는 서블릿
@WebServlet("/images/imageView.do")
public class ImagesViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String fileName = request.getParameter("filename");
		
		String downloadPath = "d:/D_Other/uploadFile";
		String filePath = downloadPath + File.separator + fileName;
		
		File file = new File(filePath);
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		if(file.exists()) {
			try {
				// 출력용 스트림 객체 생성
				bos = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				bis = new BufferedInputStream(new FileInputStream(file));
				
				byte[] buffer = new byte[1024];
				int len = -1;
				
				// 파일 내용을 읽어서 출력 스트림으로 출력한다.
				while((len=bis.read(buffer))>0) {
					bos.write(buffer, 0, len);
				}
				
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(bis!=null) { bis.close(); }
				if(bos!=null) { bos.flush(); bos.close(); }
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
