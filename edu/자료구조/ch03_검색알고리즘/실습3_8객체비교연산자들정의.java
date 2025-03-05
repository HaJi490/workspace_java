package ch03_검색알고리즘;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 3장 4번 실습과제 - 객체 배열의 정렬과 이진검색 - Comparator 구현
 * 3장 실습 3-8를 수정하여 객체 배열의 정렬 구현
 */

class PhyscData3 {
	String name;
	int height;
	double vision;
	
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

}

class NameHeightVision implements Comparator<PhyscData3>{
	@Override
	public int compare(PhyscData3 o1, PhyscData3 o2) {
		int result = o1.name.compareTo(o2.name);
		if(result == 0) {
			int result2 = o1.height - o2.height;
			if(result2 == 0) {
				return (int)(o1.vision - o2.vision);
			}else {
				return result2;
			}
		}else {
			return result;
		}
	}
}
class NameOrder implements Comparator<PhyscData3>{ //이름으로 비교
	//String은 compareTo로 비교
	@Override
	public int compare(PhyscData3 o1, PhyscData3 o2) {
		if(o1.name.compareTo(o2.name) < 0) {	 //o1이 o2보다 작음
			return -1;
		} else if (o1.name.compareTo(o2.name) > 0) {	//o1이 o2보다 큼
			return 1;
		}
		return 0;
	}
}
class HeightOrder implements Comparator<PhyscData3>{ //키로 비교

	@Override
	public int compare(PhyscData3 o1, PhyscData3 o2) {
		if(o1.height < o2.height) {	 //o1이 o2보다 작음
			return -1;
		} else if (o1.height > o2.height) {	//o1이 o2보다 큼
			return 1;
		}
		return 0;
	}
}

class VisionOrder implements Comparator<PhyscData3>{ //시력으로 비교
	
	@Override
	public int compare(PhyscData3 o1, PhyscData3 o2) {
		if(o1.vision < o2.vision) {	 //o1이 o2보다 작음
			return -1;
		} else if (o1.vision> o2.vision) {	//o1이 o2보다 큼
			return 1;
		}
		return 0;
	}
}
public class 실습3_8객체비교연산자들정의 {	
	static final Comparator<PhyscData3> HEIGHT_ORDER = new HeightOrder();
	//static NameHeightVision nhv = new NameHeightVision();
	
	static void showData(String msg, PhyscData3[] dt) {
		System.out.println(msg);
		for(int i = 0 ; i < dt.length ; i++) {
			System.out.println
			("이름 : " + dt[i].name + ", 키: " + dt[i].height + ", 시력: " + dt[i].vision);
		}
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
		Arrays.sort(data, HEIGHT_ORDER); //이름으로 정렬하려면 바꿔주면 됨	
		showData("height로 정렬후 객체 배열", data);
		
		PhyscData3 key = new PhyscData3("길동", 167, 0.2);
		
		int idx = Arrays.binarySearch(data, key, HEIGHT_ORDER);
		System.out.println("\nArrays.binarySearch(data, key, HEIGHT_ORDER): result = " + idx + "\n");
		
		Arrays.sort(data, new VisionOrder());
		showData("vision로 정렬후 객체 배열", data);
		
		//람다식
		Arrays.sort(data,(a1, a2) ->  a1.getName().compareTo(a2.getName()));
		
//		Arrays.sort(data, new Comparator<PhyscData3>() {
//			@Override
//			public int compare(PhyscData3 a1, PhyscData3 a2) {
//				return a1.getName().compareTo(a2.getName());
//			}
//		});
		showData("name로 정렬후 객체 배열", data);
	}

}
