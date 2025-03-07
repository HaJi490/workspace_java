package java_ch13제너릭;

import java.util.Arrays;

/*
interface Comparable<T>{
	public int compareTo(T o);	//추상메서드 //언제 사용하는지 이해(자료구조 : 정렬)
*/
class Student2 implements Comparable<Student2>{
	String sno;
	String sname;
	
	public Student2(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}
	
	@Override	//왜 재정의하는지 알아야함
	public int compareTo(Student2 s2) {	//정수로 리턴
		return sname.compareTo(s2.sname) ;
	}
	
	@Override
	public String toString(){
		return "[" + sno + ", " + sname + "]";
	}
	
}

public class 객체배열정렬_1_실습과제 {

	static void swap(Student2[] data, int i, int j) {
		
	}
	static void sortStudent(Student2[]data) {//자바 과목에서는 어렵다 
		//Arrays.sort(data); //data는 Studen객체의 배열-> sort #student를 비교해서 정렬(compareTo 메서드를 이용 > Comparable의 목적)
		//Arrays.sort(null, null); //comparator 사용
		for(int i = 0 ; i <data.length; i++)
			for(int j= i+1 ; j <data.length ; j++) {
				swap(data, i, j);
			}
	}
	
	public static void main(String[] args) {
		Student2 [] data = {
				new Student2("512", "길동"),
				new Student2("7121", "이길순"),
				new Student2("213", "박길춘"),
				new Student2("39", "나길홍")
		};
		sortStudent(data);
		//Arrays.sort(data);//이게 문제(?)가 있어서 sortStudent()를 구현> 무슨 문제인지를 알아야
		for (Student2 st: data)
			System.out.println(" " + st); //.toString()이 자동적으로 호출
	}

}

