package java_ch07;


public class LMSTest {
	public static void main(String[] args) {
		Employee e = new Employee("홍길동", 22, "세일즈");
		Professor p = new Professor("김푸름", 52, "딥러닝");
		Student s = new Student("강감찬", 44, "고려");
		
		/*
		 * e.setName("오정임"); e.setAge(52); e.setDept("입학처");
		 * 
		 * p.setName("김푸름"); p.setAge(52); p.setSubject("빅데이터");
		 */
		
		System.out.println(e.toString());
		System.out.println(p.toString());
		System.out.println(s.toString());
	}

}
