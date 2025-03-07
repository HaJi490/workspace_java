package java_ch07;

public class Employee extends Person { //extends 부모클래스명
	//필드
	private String dept;
	
	public Employee(String name, int age, String dept) {
		//this.name = name;			//private이어서 Person class의 field 사용못함
		super(name,age);			//superclass의 생성자 호출
		this.dept = dept;
	}
	
	/*
	 * //default 생성자 public Employee() { // name = null; (x) // age = 0; (x)
	 * super(); //person class에서 생성자 불러옴 dept = null; }
	 */
	
	//메서드
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String toString() {
		//return getName() + " : " + getAge() + " : " +  dept; 		//super.getName(), this.getName() 둘다가능/ 보통 생략되어있으면 this.임
		return super.toString() + " : "+ dept;
	}

}
