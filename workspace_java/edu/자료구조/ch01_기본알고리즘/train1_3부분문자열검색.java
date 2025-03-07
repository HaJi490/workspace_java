package ch01_기본알고리즘;

import java.util.ArrayList;
import java.util.List;

/*
 * 주어진 긴 문자열 text에서 패턴 문자열 pattern이 등장하는 모든 시작 인덱스를 찾으세요.
 *
 * 입력: text = "abxabcabcabyabcaby", pattern = "abcaby"
 * 출력: [6,12]
 * 
 * 패턴이 나타나는 인덱스를 반환
 */
public class train1_3부분문자열검색 {
	
	static void searchSubstring(String t, String p) {
		//List를 상속받은게 ArrayList
		//앞엔 인터페이스인 List를 쓰고 뒤엔 내가 쓸 buffer파일 > 관례
		//원하는 결과가 인덱스니까 결과값은 int(String으로 계산해서 변환하면 복잡함)
		List<Integer> result = new ArrayList<Integer>();
		//if문에서 i+j를 하니 어느순간 text의 총길이를 넘어서 터질 수 있음 > pattern의 길이만큼 빼줌
		for(int i = 0 ; i < t.length()-p.length() ; i++) {
			int j;
			for( j = 0 ; j < p.length() ; j++) {
				
				if(t.charAt(i+j) != p.charAt(j)) {
					break;
				}
			}
			//j가 pattern의 길이와 같다면 i값을 result배열에 추가
			if(j == p.length()) {
				result.add(i);
			}
		}
		System.out.println(result);
	}
	
	
	 public static void main(String[] args) {
	        String text = "ababcabcabababd";
	        String pattern = "ababd";
	        searchSubstring(text, pattern);
	        System.out.println("=".repeat(30));
	        
	        text = "abxabcabcabyabcaby";
	        pattern = "abcaby";
	        searchSubstring(text, pattern);
	
	 }

}