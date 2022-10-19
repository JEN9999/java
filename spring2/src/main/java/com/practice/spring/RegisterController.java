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
//	@RequestMapping("/register/add") //get post 둘다허용  신규회원가입화면
//	@GetMapping("/register/add")
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
//		
	} //  <view-controller path="/register/add" view-name="registerForm" /> 랑똑같음
	
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user, Model m) throws Exception {
		//1. 유효성검사
		if(!isValid(user)){
			//1.               
//			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");			
//			return "redirect:/register/add?msg="+msg;
			//2.메시지를 모델에 저장하는법
			
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
		}
		//2. DB에 신규회원정보를 저장
		return "registerInfo";
	}

private boolean isValid(User user) {
	// TODO Auto-generated method stub
	return false;
}
}
