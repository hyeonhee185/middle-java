package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String strNum1 = request.getParameter("num1");
		String op = request.getParameter("op");
		String strNum2 = request.getParameter("num2");
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		double result = 0;
		boolean calcOk = true;
		
		switch(op) {
			case "+" : result = num1 + num2; break; 
			case "-" : result = num1 - num2; break; 
			case "*" : result = num1 * num2; break; 
			case "/" : 
				if(num2==0) {
					calcOk = false;
				}else {
					result = (double)num1 / num2; 
				}
				break;
			case "%" :
				if(num2==0) {
					calcOk = false;
				}else {
				result = num1 % num2; 
				}break; 
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Request객체 연습2</title></head>");
		out.println("<body>");
		
		out.println("<h2>계산 결과</h2>");
		out.printf("%d %s %d = ", num1, op, num2);
		
		if(calcOk==false) {
			out.println("계산 불능(0으로 나눔)");
		}else {
			out.println(result);
		}
		
		out.println("</body></html>");
		
		
		
	}
		
}












