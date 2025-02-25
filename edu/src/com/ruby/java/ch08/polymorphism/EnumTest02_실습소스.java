package com.ruby.java.ch08.polymorphism;
/*
 * enum 클래스에 대하여 아래 코드를 학습하는 것이 중요하다
 * 자료구조 코딩을 위해 사전 학습으로 꼭 필요
 * enum 클래스의 생성자는 언제 호출되는가? 이해가 필요 
 */
import java.util.Scanner;

//자료구조시에 사용
enum Mandarin {	//클래스와 유사
	//인스턴스
	금귤(600), 한라봉(500), 레드향(300), 천혜향(400), 황금향(800);		//enum을 통해 각객체를 순서대로 0, 1, 2...로 넘어감

	private int price;
	//enum의 생성자: enum 상수마다 생성자를 호출하여 초기화한다 
	//- enum 객체가 처음 만들어질 때 호출된다
	Mandarin(int p) {	//금귤 ~ 황금향까지 자동 생성
		price = p;
		System.out.println("enum 생성자 실행:: price = " + price);
	}
	
	//메서드
	int getPrice() {
		return price;
	}
	
	static Mandarin MandarinAt(int idx) {
		for (Mandarin m : Mandarin.values())	//1. 확장형 for문 2.'.values'>> enum을 생성할때 자바가 자동으로 생성, {금귤, 한라봉..}을 나타냄
			if (m.ordinal() == idx)
				return m;	//m= Mandarin 객체
		return null;
	}
}



public class EnumTest02_실습소스 {
	static Scanner stdIn = new Scanner(System.in);
	Mandarin m[] = Mandarin.values();//Mandarin의 생성자를 호출하고 각 값을 생성자 함수에 전달한다.
	//values()는 static 함수로 열거된 모든 원소를 배열로 리턴
	static Mandarin selectMenu() {
		int key;
		do {
		for (Mandarin m : Mandarin.values()) {//Mandarin m[] = Mandarin.values();와 의미가 같다 
			System.out.print(m.ordinal()+ ".");	//루프를 돌아 메뉴를 보여줌
			System.out.println(" " + m + "(" + m.getPrice()+ ")");
		}
		System.out.println("선택: ");
		key = stdIn.nextInt();
		} while(key < Mandarin.금귤.ordinal() || key > Mandarin.황금향.ordinal());
		
		return Mandarin.MandarinAt(key);
	}

	public static void main(String[] args) {
		Mandarin m;		//생성자를 호출하지 않는다
		//Mandarin m2 = new Mandarin(100);	//생성자를 호출할 수 없다 - 주의점
		//*
		Mandarin ma = Mandarin.한라봉;	//enum 클래스 *생성자가 호출*된다 >>제일 어려움		//enum 생성자 실행 :: 
		//ma.toString();
		System.out.println(ma.toString());		//한라봉
		System.out.println("===enum 객체 생성전===");
		System.out.println("황금향과 비교: "+ ma.compareTo(Mandarin.레드향));
		Mandarin m2	= Mandarin.금귤;
		Mandarin ma2 = Mandarin.valueOf("레드향");
		System.out.println(ma2);

		Mandarin list[] = Mandarin.values();
		System.out.println("== 귤의 종류 ==");
		for (Mandarin m3 : list)
			System.out.println(m3 + ":" + m3.getPrice());
			
			//*/
		Mandarin mSelected = selectMenu();
		System.out.println(mSelected + ":selectedMenu:" + mSelected.getPrice());
	}
}
