package java_ch07;

public class Professor extends Person{
	//필드
	private String subject;
	
	//생성자
	public Professor(String name, int age, String subject) {
//		super.setName(name);
//		super.setAge(age);
		super(name, age);
		this.subject = subject;
	}
	
	//메서드
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String toString() {
		return super.toString()  + " : " +  subject;
	}

}
