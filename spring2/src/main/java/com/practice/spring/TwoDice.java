package com.practice.spring;   
//ctrl shift o  는 자동 import

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
// 동적리소스: 실행시마다 결과가변함 TwoDice.java  , 스트리밍 , 프로그램
//정적리소스 : dice1.jpg  , js.css.html
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
		int idx1 = (int)(Math.random()*6)+1;
		int idx2 = (int)(Math.random()*6)+1;
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice"+idx1+".jpg'>");
		out.println("<img src='resources/img/dice"+idx2+".jpg'>");
		out.println("</body>");
		out.println("</html>");
	}
}
