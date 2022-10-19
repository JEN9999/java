package com.practice.spring;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	@RequestMapping(value="/register/add", method={RequestMethod.GET,RequestMethod.POST})
//	
//	@RequestMapping("/register/add") //get post �Ѵ����  �ű�ȸ������ȭ��
//	@GetMapping("/register/add")
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
//		
	} //  <view-controller path="/register/add" view-name="registerForm" /> ���Ȱ���
	
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user, Model m) throws Exception {
		//1. ��ȿ���˻�
		if(!isValid(user)){
			//1.               
//			String msg = URLEncoder.encode("id�� �߸� �Է��ϼ̽��ϴ�.","utf-8");			
//			return "redirect:/register/add?msg="+msg;
			//2.�޽����� �𵨿� �����ϴ¹�
			
			String msg = URLEncoder.encode("id�� �߸� �Է��ϼ̽��ϴ�.","utf-8");
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
		}
		//2. DB�� �ű�ȸ�������� ����
		return "registerInfo";
	}

private boolean isValid(User user) {
	// TODO Auto-generated method stub
	return false;
}
}
