package java_ch10API활용;

import java.util.ArrayList; //import는 자동으로 넣어야함(타이핑x)
import java.util.Arrays;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(); //ArrayList 순서(인덱스)o, 중복o //new ArrayList<String> String 삭제가능
		list.add("서울"); list.add("북경"); list.add("상해");
		list.add("서울"); list.add("도쿄"); list.add("뉴욕");

		System.out.println("1 : " + list.toString());
		
		//p.471
		//void add(int index, E element)
		list.add(1, "LA");	//배열 추가
		print(2, list);
		
		//int indexOf(Object o) / int lastIndexOf(Object o)
		System.out.println("3 : " + list.indexOf("서울"));
		System.out.println("4 : " + list.lastIndexOf("서울"));
		
		//boolean remove(Object o)
		list.remove("LA");
		print(5, list);
		
		//E remove(int index)
		list.remove(2);	//두번째 아이템 삭제
		print(6, list);
		
		//boolean contains(Object o)
		System.out.println("7 : " + list.contains("LA"));	//return타입이 boolean // LA를 포함하고있는가
		
		//Object[] toArray()
		Object obj[] = list.toArray();
		System.out.println("8 : " + Arrays.toString(obj));	//ArrayList의 데이터를 Object 타입의 배열로 생성하여 반환
		
		//<T> T[] toArray(T[] a)
		String cities[] = new String[0];
		cities = list.toArray(cities);
		System.out.println("9 : " + Arrays.toString(cities));
		
		//void clear()
		list.clear();
		print(10, list);
		
		//boolean isEmpty()
		System.out.println("11 : " + list.isEmpty());
		
		list.add("파리");
		list.add("방콕");
		list.add("LA");
		
		//Arrays 클래스의 static <T> List<T> asList<T...a> 
		List<String> list2 = Arrays.asList("서울", "뉴욕", "상해");
		print(12, list2);
		
		//boolean addAll(Collectin<? extends E ">c)
		list.addAll(list2);
		print(13, list);
		
		//boolean containAll
		System.out.println("14 : " + list.containsAll(list2));
		
		//boolean retainAll
		list.retainAll(list2);
		print(15, list);
		
		//boolean removeAll
		list.removeAll(list2);
		print(16, list);
	}
	public static void print(int n, List<String> list) {
		System.out.println(n+" : " + list);
		
		
//		p.469
//		1
//		for(int i = 0 ; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
//		2
//		System.out.println("-".repeat(10));	//확장형 for문
//		for(String s : list) {	
//			System.out.println(s);
//		}
//		
//		p.478
//		3
//		list.forEach(s->System.out.println(s));
	}
}
