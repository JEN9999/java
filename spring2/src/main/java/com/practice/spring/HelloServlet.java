package com.practice.spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		//서블릿이 초기화될때 자동 호출되는 메서드
		//1. 서블릿의 초기화 작업 담당
		System.out.println("[HelloSerlvet] init()");
	}
	
	@Override// 호출될 때마다 반복적으로 수행됨.
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 입력
					// 2. 처리 
					// 3. 출력
					System.out.println("[HelloSerlvet] service()");
	}

	@Override
	public void destroy() {
		// 뒷정리 작업 - 서블릿이 제거(unload)될 때, 단 한번만 수행됨.
					System.out.println("[HelloSerlvet] destroy()");  
	}


}
