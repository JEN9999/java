package com.practice.spring;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YoilTellerMVC2 {
    @RequestMapping("/getYoilMVC2") // http://localhost:8080/ch2/getYoilMVC?year=2021&month=10&day=1
    //    public static void main(String[] args) {
//    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
    public ModelAndView main(int year,int month ,int day) throws IOException {
    	
    	ModelAndView mv = new ModelAndView();
    	
    	//1.유효성검사
//    	if(!isValid(year,month,day))
//    		return "yoilError";
    	// 2. 요일계산
        char yoil = getYoil(year, month, day);
        //3.계산한 결과를 model에 저장
        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);
        mv.addObject("yoil", yoil);
        
        //4. 결과를 보여줄 view를 지정
        mv.setViewName("yoil");
        
        return mv;  // /WEB-INF/views/yoil.jsp


    }

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1 : 일요일 2:월요일 ---
        return " 일월화수목금토".charAt(dayOfWeek);
	}
}