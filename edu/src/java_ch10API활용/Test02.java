package java_ch10API활용;

import java.util.ArrayList;
import java.util.Iterator;

public class Test02 {
	public static void main(String[] args) {
		//p.479
		ArrayList<String> list = new ArrayList<String>(); //<String>?
		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");
		
		for(int i = 0 ; i < list.size() ; i++) {	//list.size()?
			System.out.println(list.get(i));
		}
		
		System.out.println("============");
		
		Iterator<String> iter = list.iterator(); // list를 상속받아서 씀, 근데 for루프를 더 많이 씀
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
