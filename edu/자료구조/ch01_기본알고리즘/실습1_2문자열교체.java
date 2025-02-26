package ch01_기본알고리즘;

public class 실습1_2문자열교체 {

    // 서브스트링을 추가하는 함수
	/*
	 * concat(substring)
	 * replaceAll(target, replacement)
	 */
    public static String addSubstring(String s, String date) {	//static? > 객체를 안만들고 부를려고( = 객체만들고 참조변수.메서드명 안하려고)
    		return s.concat(date);	//concat() #새로운 문자열 추가 p.418
    }
    
    public static String replaceString(String news, String fir, String sec) {
    	if (news.contains(fir)){
    		return news.replaceAll(fir, sec);
    	}
		return null;
    }

    public static void main(String[] args) {
        String s = "자바 코딩, 파이썬 코딩, C 코딩, C# 코딩"; 
        
        // 서브스트링 추가
        String newString = addSubstring(s, " PCCP 시험: 11월 23일");
        
        // 문자열 교체(코딩>프로그래밍 스킬)
        String finalString = replaceString(newString, "코딩", "프로그래밍 스킬");
        
        // 결과 출력
        System.out.println(finalString);
    }
}

