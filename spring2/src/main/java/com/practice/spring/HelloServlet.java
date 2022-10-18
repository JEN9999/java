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
		//������ �ʱ�ȭ�ɶ� �ڵ� ȣ��Ǵ� �޼���
		//1. ������ �ʱ�ȭ �۾� ���
		System.out.println("[HelloSerlvet] init()");
	}
	
	@Override// ȣ��� ������ �ݺ������� �����.
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. �Է�
					// 2. ó�� 
					// 3. ���
					System.out.println("[HelloSerlvet] service()");
	}

	@Override
	public void destroy() {
		// ������ �۾� - ������ ����(unload)�� ��, �� �ѹ��� �����.
					System.out.println("[HelloSerlvet] destroy()");  
	}


}
