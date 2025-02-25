package java_ch10API활용;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test07 {
	public static void main(String[] args) {
		
		HashMap<String, String> dic = new HashMap<>();	//순서를 지키지않음
		//Map<String, String> dic = new HashMap<>();	//=같음

		dic.put("고진감래", "고생 끝에 즐거움이 옴"); //(key, value)
		dic.put("분골쇄신", "몸이 부서질 정도로 노력을 다함");
		dic.put("권토중래", "실패를 발판삼아 재기함");
		dic.put("교학상자", "가르치고 배우면서 서로 성장함"); //HashMap은 null값 저장가능
		dic.put(null, null);

		// 방법1
		Iterator<String> keys = dic.keySet().iterator();
//		=같은 식
//		Set<String> keyset = dic.keySet();
//		Iterator<String> keys = keyset.iterator();
		
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}

		// 방법2
		for (Map.Entry<String, String> elem : dic.entrySet()) {
			System.out.println(String.format("%s : %s", elem.getKey(), elem.getValue()));
		}

		// 방법3(많이씀) 
		for (String key : dic.keySet()) {
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}
	}

}
