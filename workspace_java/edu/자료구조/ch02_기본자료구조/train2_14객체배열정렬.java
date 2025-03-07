package ch02_기본자료구조;

/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
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
	public String toString() {// Object 클래스 상속
		return " ";
	}

	public int compareTo(PhyscData p) {
//		int result = 0;
//		if(this.name.compareTo(p.name) > 0) {
//			return 1;
//		}else if (this.name.compareTo(p.name) < 0){
//			return -1;
//		} else {//키로 비교
//			if(this.height > p.height) {
//				return 1;
//			}else if(this.height < p.height){
//				result = -1;
//			}else {//시력으로 비교
//				if(this.vision > p.vision) {
//					result = 1;
//				}else if(this.vision < p.vision) {
//					result = -1;
//				}
//			}
//		}
//		return result;
		
		//무조건 구현해야하는 메서드 7가지가 있음 > 안하면 DB입력안됨
		//동등비교 넣기(문자열 ㅂㅣ교는 equals) 
		//그값의 레퍼런스가 같은게 아니라 속성이 같아야한다
		//== 메모리 위치가 같아야되는게 아니라 안에들어있는 내용이 같아야한다
		int result = this.name.compareTo(p.name);
		if(result == 0) {
			int result2 = this.height - p.height;
			if(result2 == 0) {
				return (int)(this.vision - p.vision);
			}else return result2;
			
		}else return result;
		
	}

	public boolean equals(Object ob) {// Object 클래스 상속
		//바로 타입캐스팅 하면  최상위객체인 Object에서 가져와서 비용이 많이 든다
		//형변환이 되려면 상속하거나 구현객체(인터페이스)여야함
		//형변환하면 박싱언박싱을 하게됨 무조건
		//PhyscData p = (PhyscData) ob; 
		
		//작은거에서 큰거로 넣기
		//1. 같은 객체인지 확인
		if(this == ob)
			return true;
		
		//객체 동등성 확보(범위가 크면 차이가 큼)
		//2. 객체타입 확인
		if(!(ob instanceof PhyscData)) return false;
		PhyscData p = (PhyscData) ob;		
		return p.getHeight() == this.height;
	}

}

public class train2_14객체배열정렬 {
	
	static void showData(String msg, PhyscData[] dt) {
		System.out.println(msg);
		for(int i = 0 ; i<dt.length ; i++) {
			System.out.println("이름 :" + dt[i].name + ", 키 :" + dt[i].height + ", 시력 : " + dt[i].vision);
		}
		
	}
	
//	swap() {
//		
//	}

	static void sortData(PhyscData[] dt) {//객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로 
		//compareTo()를 사용하여 구현
		Arrays.sort(dt);
//		for(int i = 0 ; i<dt.length ; i++) {
//			if(dt[i].compareTo(dt[i+1]) > 0){
//				PhyscData temp = dt[i];
//				dt[i]= dt[i+1];
//				dt[i+1] = temp;
//			}
//		}
//		return dt;
	}
	
	//binaryfamily 중요!!!!
	static int binarySearch(PhyscData[] dt, String key) {
		//if (data[i].equals(key)) ***으로 구현
		//equals이용할때 compareTo로 비교되니까ㅏㅏ
		int pl = 0;
		int pr = dt.length - 1;
		
		while(pl<= pr) {
			int pc = (pl+pr)/2;
			
			if (dt[pc].equals(key) == true) {
				return pc;
			}else if(dt[pc].name.compareTo(key) > 0) {
				pr = pc-1;
			}else if(dt[pc].name.compareTo(key) < 0) {
				pl = pc+1;
			}
		}
		return -1;
	}
		
//		int pl = 0;
//		int pr = dt.length - 1;
//		
//		while(pl<=pr) {
//			int pc = (pl + pr)/2;
//			int result = dt[pc].name.compareTo(key);
//			
//			if(result == 0) {
//				return pc;
//			}else if(result < 0) {
//				pl = pc+1;
//			}else {
//				pr = pc-1;
//			}
//		}
//		return -1;
//			
	 // equals()를 사용하여 구현

	
	static PhyscData[] insertObject(PhyscData[] dt, PhyscData nnew) {
		PhyscData[] new2 = new PhyscData[dt.length+1];
		for(int i = 0 ; i< dt.length ; i++) {
			new2[i] = dt[i];
		}
		new2[dt.length] = nnew;
		sortData(new2);
		return new2;
	}

	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), 
							new PhyscData("이기자", 164, 1.3),
							new PhyscData("나가자", 162, 0.7), 
							new PhyscData("사이다", 172, 0.3), 
							new PhyscData("신정신", 182, 0.6),
							new PhyscData("원더풀", 167, 0.2), 
							new PhyscData("다정해", 169, 0.5), };

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);

		int resultIndex = binarySearch(data, "사이다");
		if (resultIndex >= 0)
			System.out.println("\n사이다가 존재하면 인덱스 = " + resultIndex);
		else
			System.out.println("사이다가 존재하지 않는다");
		PhyscData[] newData = insertObject(data, new PhyscData("소주다", 179, 1.5));// 배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰
																					// 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);

	}

}
