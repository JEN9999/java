package com.practice.spring;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//hello Ŭ������ Class ��ü(Ŭ������ ������ ����ִ°�ü)�� ���´�.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance();
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); //private�� main �� ȣ�Ⱑ���ϰ� �Ѵ�.
		
		main.invoke(hello); // hello.main() �̶� ����.
	}

}
