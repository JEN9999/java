package com.practice.spring;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 호출가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv = 10; //인스턴스 변수
	static int cv = 20; //static 변수
	//2. url과 메서드를 연결
	@RequestMapping("/hello")
	public void main() {   //인스턴스 메서드로 하는 이유. 
		System.out.println("hellooooo");
		int[] arr = {3,2,0,1,4};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
