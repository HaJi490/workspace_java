package java_ch09API;
/*
 * 교재 397 - 405 실습 코드> 아래 코드를 이해할 수 있어야 한다.
 */
class MyObject {
	int id;
	
	public MyObject() {
		id = 0;
	}
	
	public MyObject(int num) {
		id = num;
	}
	public String toString() {
		return "MyObject";
	}
}
public class Test01_실습대상 {
	public static void main(String[] args) {
		String st = "java coding";
		Object obj1 = new Object(); //Object 기본클래스
		Object obj2 = new Object();
		Object obj3 = new MyObject();
		MyObject mo = new MyObject();
		
		System.out.println("obj1.hashCode()=" + obj1.hashCode());//출력이 정수
		System.out.println(Integer.toHexString(obj1.hashCode()));//Integer 기본데이터타입을 클래스로 바꿔줌
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());

		Class c = obj3.getClass();//c는 객체이고 toString()이 있음
		//obj1.toString();	//toString이 Object에 정의되어 있음
		System.out.println(c);
		System.out.println("객체의 클래스 이름:: " + c.getName());
		if ((c.getName()).compareTo("MyObject2")== 1)//클래스 이름에 패키지 이름도 있으므로
			System.out.println("클래스는 " + c.getName()); 
		System.out.println(obj1);//toString() 결과와 같은 이유는 자동적인 타입 캐스팅 때문임 > 정수를 hexa로 변경한 것
		System.out.println(obj1.toString());//p.399 하단의 클래스 이름이 string
		System.out.println(obj2);
		System.out.println(obj3);//재정의된 toString() 호출

		MyObject obj4 = new MyObject(123);
		System.out.println(obj4);
		MyObject obj5 = new MyObject(123);
		//obj4.equals(obj5) //MyObject의 equals()가 실행됨
		if (obj4.equals(obj5)) {//hashcode가 다르면 다른 객체로 본다 -기준은 hashcode를 갖고 판단한다
			System.out.println("동일 객체이다.");//MyObject 클래스에서 equals()를 재정의한 경우
		} else {
			System.out.println("다른 객체이다.");//Object의 equal() 사용시에는, 403페이지 내용 
		}
		System.out.println(obj4.hashCode() + ":" + obj5.hashCode());
		if (obj4 == obj5) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		System.out.println("obj4 = " + obj4);
		MyObject mo2 = new MyObject();//402페이지의 toString() 오버라이딩
		System.out.println(mo2);
	}
}