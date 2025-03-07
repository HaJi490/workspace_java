package java_ch07;

public class Person {
	// 필드
	private String name;
	private int age;
	
	//생성자
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person() {}

//	//컴파일러가 자동으로 생성하는 생성자 형태 = default 생성자
//	public Person() {
//		name = null;
//		age=0;
//	}

	// 메서드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return name + " : " + age ;
	}

	
}
