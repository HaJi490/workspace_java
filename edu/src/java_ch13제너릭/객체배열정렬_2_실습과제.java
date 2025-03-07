package java_ch13제너릭;

/*
 * 구글: [Java] 내가 만든 클래스 객체 배열 정렬하기 (comparable,
 * 티스토리, 22.1.9
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Student3 {
	String sno;
	String sname;

	public Student3(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}
	
	@Override
	public String toString() {
		return "(" + sno + ", " + sname + ")";
	}

}

class SnoComparator implements Comparator<Student3> { // Comparator #매번 정렬하는 방식을 다르게하고싶다면
	public int compare(Student3 s1, Student3 s2) {
		return s1.sno.compareTo(s2.sno);
	}
}

class SnameComparator implements Comparator<Student3> { // Comparator #매번 정렬하는 방식을 다르게하고싶다면
	public int compare(Student3 s1, Student3 s2) {
		return s1.sname.compareTo(s2.sname);
	}
}

public class 객체배열정렬_2_실습과제 {

	static void swap(Student3[] data, int i, int j) {

	}

	static void sortStudent(Student3[] data) {// 자바 과목에서는 어렵다

	}

	public static void main(String[] args) {
		SnoComparator snocom = new SnoComparator();
		SnameComparator snamecom = new SnameComparator();

		Student3[] data = { 
				new Student3("12", "이길동"), 
				new Student3("121", "길순"), 
				new Student3("213", "나길춘"),
				new Student3("9", "너길홍") };
		//sortStudent(data);
		//Arrays.sort(data);// 이게 문제(?)가 있어서 sortStudent()를 구현> 무슨 문제인지를 알아야
		Arrays.sort(data, snamecom); //이름 정렬
		//Collections.sort() ; //리스트o, 배열은 안됨
		for (Student3 st : data)
			System.out.print(" " + st);
		Arrays.sort(data, snocom);	//학번 정렬
		System.out.println("\n정렬후");
		for (Student3 st : data)
			System.out.print(" " + st);
	}

}
