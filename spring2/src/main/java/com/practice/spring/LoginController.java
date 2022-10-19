package com.practice.spring;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//1. ������ ����
		session.invalidate();
		
		//2. Ȩ���� �̵�
		return "redirect:/";
	}
	
	@PostMapping("login")
	public String login(String id, String pwd,String toURL, boolean rememberId,HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("rememberId="+rememberId);
		//1. id�� pwd�� Ȯ��
		if(!loginCheck(id, pwd)) {
			//2-1. ��ġ���� ������ loginForm���� �̵�
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			
			return "redirect:/login/login?msg="+msg;
		}
		//2-2. ��ġ�ϸ� ,
		// ���� ��ü�� ������
		HttpSession session = request.getSession();
		//���� ��ü�� id�� ����
		session.setAttribute("id",id);
		
		if(rememberId) {
			//1.��Ű����
			Cookie cookie = new Cookie("id",id);
			//    2. ���信 ����
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("id",id);
			//��Ű�� ����
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
	
		//    3. Ȩ���� �̵�
		toURL = toURL==null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:"+toURL;
	}

	private boolean loginCheck(String id, String pwd) {
		// TODO Auto-generated method stub
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}