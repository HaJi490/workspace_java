package ch03_검색알고리즘;

import java.util.Arrays;
import java.util.Comparator;

class PhyscData3 {
	private String name;
	private int height;
	private double vision;

	public PhyscData3(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getVision() {
		return vision;
	}

	public void setVision(double vision) {
		this.vision = vision;
	}

	@Override
	public String toString() {
		return "PhyscData3 [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}
	

}

public class review3_8객체비교연산자들정의 {	
	//람다로 되는건 람다로(람다식: 인테페이스에 구현 메서드가 1개 일때 사용가능)
	static final Comparator<PhyscData3> HEIGHT_ORDER = (a, b) -> a.getHeight() - b.getHeight();
	static final Comparator<PhyscData3> NAME_ORDER = (a, b) -> a.getName().compareTo(b.getName());//비교 compareTo
	static final Comparator<PhyscData3> VISION_ORDER = (a, b) -> Double.compare(a.getVision(), b.getVision());//1. Double클래스의 compare 
																											  //2. 소숫점이하 n번째자리 올림, 내림, 반올림 설정->소숫점 끝자리때문에 계산이 달라질수 있어서
	
	public static void showData(String msg, PhyscData3[] data) {
		System.out.println(msg + ": ");
		for(PhyscData3 value : data) {
			System.out.println(value + ": ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		PhyscData3[] data = {
				new PhyscData3("홍길동", 162, 0.3),
				new PhyscData3("나가자", 164, 1.3),
				new PhyscData3("다정해", 152, 0.7),
				new PhyscData3("소주다", 172, 0.4),
				new PhyscData3("사이다", 182, 0.6),
				new PhyscData3("신정신", 166, 1.2),
				new PhyscData3("이기자", 167, 1.5),
		};
		
		showData("정렬전 객체 배열", data);
		Arrays.sort(data, HEIGHT_ORDER);	
		showData("height로 정렬후 객체 배열", data);
		
		PhyscData3 key = new PhyscData3("길동", 167, 0.2);
		
		int idx = Arrays.binarySearch(data, key, HEIGHT_ORDER);
		System.out.println("\nArrays.binarySearch(data, key, HEIGHT_ORDER): result = " + idx);
		
		Arrays.sort(data, (a, b) -> Double.compare(a.getVision(), b.getVision()));
		showData("vision로 정렬후 객체 배열", data);
		
		Arrays.sort(data, new Comparator<PhyscData3>() {
			@Override
			public int compare(PhyscData3 a1, PhyscData3 a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		showData("name로 정렬후 객체 배열", data);
	}

}

