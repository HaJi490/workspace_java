package java_ch07;

public class Student extends Person{
		//필드
		private String major;
		
		//생성자
		public Student(String name, int age, String major) {
			super.setName(name);
			super.setAge(age);		
			this.major = major;
		}
		
		//메서드
		public String getMajor() {
			return major;
		}
		public void setMajor(String major) {
			this.major = major;
		}
		
		@Override
		public String toString() {
			return super.toString() + " : " +  major;		
		}

}
