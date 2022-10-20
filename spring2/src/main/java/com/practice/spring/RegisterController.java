package com.practice.spring;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class,"hobby",new StringArrayPropertyEditor("#"));
//		binder.setValidator(new UserValidator()); setvalidator를쓰면 글로벌validator를안씀
//		binder.addValidators(new UserValidator());
		// UserValidator를 Webdator의 로컬validator로 등록
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList ="+validatorList);
	}
	
	@RequestMapping(value="/add", method={RequestMethod.GET,RequestMethod.POST})
//	@RequestMapping("/register/add") //get post 둘다허용  신규회원가입화면
//	@GetMapping("/register/add")
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
//		
	} //  <view-controller path="/register/add" view-name="registerForm" /> 랑똑같음
	
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/add")
	public String save(@Valid User user,BindingResult result, Model m) throws Exception {
		
		//수동 검증 = Validator를 직접 생성하고 validate()를 직접 호출
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); // BindingResult는 Error의 자손
		
		//자동검증 22번재줄
		
		
		//User 객체를 검증한 결과 에러가 있으면 registerForm을 이용하여 에러를 보여줌
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		//1. 유효성검사            바인딩할 객체 바로뒤에와야함
//		if(!isValid(user)){
			//1.               
//			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");			
//			return "redirect:/register/add?msg="+msg;
		
			//2.메시지를 모델에 저장하는법	
//			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");
//			m.addAttribute("msg", msg);
//			return "redirect:/register/add";
		
		//2. DB에 신규회원정보를 저장
		return "registerInfo";
	}

private boolean isValid(User user) {
	// TODO Auto-generated method stub
	return true;
}
}
