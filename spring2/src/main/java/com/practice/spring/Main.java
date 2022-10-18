package com.practice.spring;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//hello 클래스의 Class 객체(클래스의 정보를 담고있는객체)를 얻어온다.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance();
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); //private인 main 을 호출가능하게 한다.
		
		main.invoke(hello); // hello.main() 이랑 같다.
	}

}
