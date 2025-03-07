package com.ruby.java.ch08.polymorphism;

interface WorkFile {					//인터페이스 => 추상메서드
	public void fileUpload();
	public void fileDownload();
}

interface Messenger {
	public String getMessage();
	public void setMessage(String msg);
	public default void setLogin(boolean login) {
		if (login) {
			System.out.println("login");
		}
		else {
			System.out.println("logout");
		}
	}
	public static void getConnection() {
		System.out.println("network 연결");
	}
}
class GraphicIOS {
	public void draw_textBox() {
		System.out.println("텍스트 상자");
	}
	public void draw_submitButton() {
		System.out.println("전송버튼");
	}

}
class IPhoneMessenger extends GraphicIOS implements Messenger  {   //extends(상속)을 먼저 기술
	public String getMessage() {
		return "iPhone";

	}

	public void setMessage(String msg) {
		System.out.println("메시지" + msg);
	}
	public void clearMessage() {
		System.out.println("문자열 지우기");
	}

}
class GalaxyMessenger implements Messenger, WorkFile {
	@Override
	public String getMessage() {
		return "galaxy";
	}
	@Override
	public void setMessage(String msg) {
		System.out.println("galaxy 메시지 설정" + msg);
	}
	@Override
	public void fileUpload() {
		System.out.println("file uploaded");
	}
	@Override
	public void fileDownload() {
		System.out.println("file downloaded");
	}

}
public class 실습_익명클래스 {
public static void main(String[] args) {
	IPhoneMessenger iphone = new IPhoneMessenger();			//Messenger(인터페이스명) iphone = new IPhoneMessenger();도 가능한 이유 >>Messenger 인터페이스가 IPhoneMessenger 클래스의 상위클래스여서(상속할 때 부모클래스명 참조변수 = new 자식클래스명();이 가능한 원리
	
	GalaxyMessenger galaxy = new GalaxyMessenger(); //1.= new 클래스명
	iphone.draw_submitButton();
	iphone.draw_textBox();
	galaxy.getMessage();
	galaxy.setMessage("갤럭시");
	Messenger test = new Messenger() {		//익명클래스, 2.= new 인터페이스명
		public String getMessage() {
			return "test 메시지";

		}
		public void setMessage(String msg) {
			System.out.println("test 메시지: " + msg);
		}
	};										//익명클래스 끝( '}'이후에 ';'찍어야함)
	System.out.println(test.getMessage());
	test.setMessage("익명클래스");
}
}

