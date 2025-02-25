package java_ch09API;
//iterator 개념 실습 
import java.util.StringTokenizer;

public class Test14_실습대상 {
	public static void main(String[] args) {

		String msg = "Although the world is full of suffering, it is full also of the overcoming of it.";
		String arrayMessage[] = msg.split(" ");//token : 분리된 결과, split " " : 뛰어쓰기로 분리
		for (String st: arrayMessage)
			System.out.println(st);
		
		StringTokenizer st1 = new StringTokenizer(msg);//st1은 객체임, 배열이 아님
		//st1. //dot 후에 나타나는 메소드를 확인하는 것이 필요함 - 교재 433페이지 표
		st1.
		System.out.println("단어 수 : " + st1.countTokens());
		while (st1.hasMoreTokens()) {	//토큰이 남아있으면
			System.out.print(st1.nextToken() + " + " );	//반복될때마다 그다음꺼
		}
		StringTokenizer st11 = new StringTokenizer(msg, ",. ");//delimiter 사용
		System.out.println("단어 수 : " + st11.countTokens());
		while (st11.hasMoreTokens()) {
			System.out.print(st11.nextToken() + " + " );
		}
		System.out.println("\n================");
		String s = "id=guest&name=Amy&pwd=1004";
		StringTokenizer st2 = new StringTokenizer(s, "&"); // &로 토큰을 자름
		while (st2.hasMoreTokens()) {
			System.out.println("남아있는 토큰 수 : " + st2.countTokens());
			System.out.println(st2.nextToken());
		}

		System.out.println("================");
		StringTokenizer st3 = new StringTokenizer(s, "=&");
		while (st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
	}
}