package kr.or.ddit.basic.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/uploadFileList.do")
public class UploadFileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = "d:/D_Other/uploadFile";
		
		// 저장될 폴더가 없으면 생성한다.
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 파일이 저장된 폴더에서 전체 파일목록을 가져와 List에 담아준다
		File[] allFiles = file.listFiles();
		List<UploadDetail> fileList = new ArrayList<>();
		
		for(File f : allFiles) {
			UploadDetail detail = new UploadDetail();
			detail.setFileName(f.getName());
			detail.setFileSize((int)Math.ceil(f.length()/1024.0));
			detail.setUploadStatus("Succeess");
			
			
			fileList.add(detail);
		}
		
		request.setAttribute("uploadFileList", fileList);
		RequestDispatcher rd = 
				request.getRequestDispatcher("/basic/fileupload/uploadFiles.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
