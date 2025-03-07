package java_ch09API;

import java.util.Arrays;

public class Test19_실습대상 {

	public static void main(String[] args) {
		String title = "**** 2018 Olympic ****";
		//447페이지 표: *는 메타 문자 > \*는 * 문자를 나타냄 > 함수에 \* 전달하려면 \\* 필요
		title = title.replaceAll("\\*", "%");	//reaplaceAll : 다 바꿔라
		System.out.println(title);
		
		// \w는 교재 446 표: 메타 문자 > \\w+는 1번 이상 반복
		title = title.replaceAll("\\w+", "Winter"); //숫자를 winter로 바꿈
		System.out.println(title);
		title = title.replaceAll("Winter", "Olympic");
		System.out.println(title);

		title = title.replaceAll("[^a-z]", "ZA");// 소문자가 아닌 것을 ZA로 교체
		System.out.println(title);

		String str = "1, 2, 3, 4, 5, 6   7,, 8";
		String[] result = str.split("[\\s,]+");// \s는 공백, escape로 인식을 위해 \추가, 공백과 ','를 split, +는 여러개
		System.out.println(Arrays.toString(result));

		String temp = "-20";
		temp = temp.replaceFirst("\\W", "+");
		System.out.println(temp);
	}
}