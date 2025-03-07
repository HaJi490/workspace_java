package java_ch05;

import java.util.Random;
import java.util.Scanner;

class Student {
	int sno;

	public void setSno(int num) {// 2. 넘겨준 '11'=num : 함수 parameter(호출을 당했을 때)
		String name = "HongGilDong"; // local 변수(vs. global변수)는 stack에 저장, 변수의 범위 : scope
		sno = num;
		
	}
	

}

public class Armor {			// Armor라는 클래스
	public static void main(String[] args) {
		Student st = new Student(); // 'st'는 참조변수
		st.sno = 99;		//필드 sno값을 99로 설정
		st.setSno(11);// 1. 위에 클래스에서 함수호출해서 '11'을 넘겨줌 : 함수 argument(호출해서 보낼 때)
	}

	/*
	 * private String name; // 필드 public int height;
	 * 
	 * public void takeOff() { // 메소드
	 * 
	 * } //{}는 함수 body라고 한다
	 */
	Scanner sc = new Scanner(System.in);
	Random rnd = new Random();

}
