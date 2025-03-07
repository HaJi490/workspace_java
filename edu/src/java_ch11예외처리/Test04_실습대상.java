//함수에 throw절을 추가하는 경우 - 함수내에서 throw할 수 있고 호출하는 코드에서 예외를 반드시 처리해야 한다
package java_ch11예외처리;

import java.io.FileInputStream;

public class Test04_실습대상 {
	public static void c() throws Exception {
		throw(new Exception()); //예외가 발생하면 throws함
		//System.out.println("c():: 실행");

	}
	public static void b() throws Exception {
		try {
			c();
			
		}catch(Exception e) {
			System.out.println("C():: 예외처리");
		}

	}
	public static void main(String[] args) {
		try {
			FileInputStream fi = new FileInputStream("a.txt");//에러 발생 이유 >>FileInputStream #자바에 내장된 클래스# 메서드에 throws가 있어서 try-catch문으로 받아야됨
			int c = fi.read();
			System.out.println((char) c);
			b();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/*
	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileInputStream fi = new FileInputStream("a.txt");
		int c = fi.read();
		System.out.println((char) c);
	}*/
}
