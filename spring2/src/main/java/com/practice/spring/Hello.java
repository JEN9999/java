package com.practice.spring;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. ���� ȣ�Ⱑ���� ���α׷����� ���
@Controller
public class Hello {
	int iv = 10; //�ν��Ͻ� ����
	static int cv = 20; //static ����
	//2. url�� �޼��带 ����
	@RequestMapping("/hello")
	public void main() {   //�ν��Ͻ� �޼���� �ϴ� ����. 
		System.out.println("hellooooo");
		int[] arr = {3,2,0,1,4};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
