package java_ch12입출력;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test01 {
	
	public static void main(String[] args) {
		
		//b.txt가 있는지 확인하고(스캐너) 있으면 덮어쓸건지 물어보고
		//Yes를 응답하면 아래 코드를 실행하고
		//No를 응답하면 프로그램 종료
		
		//File, Scanner
		//b.txt가 존재합니다. 덮어쓸까요?[Y/N]
		
		File file = new File("b.txt");
		if (file.exists()) { //if문 else넣을 필요xx
			
			System.out.println(file.getAbsolutePath()); //파일경로 출력
			
			System.out.println("'b.txt'가 존재합니다. 덮어쓸까요?");
			try(Scanner sc = new Scanner(System.in)){ //*return 안해도 닫아줌
			String ans = sc.next();
			if(ans.equalsIgnoreCase("no")) { //equalsIgnoreCase : 대소문자 무시하고 비교
				System.out.println("종료");
				return;	//*안하면 계속 아래로 진행됨
			}
		}
		}
		
		try(FileInputStream fi = new FileInputStream("a.txt");	//try-with-resource문 //~InputStream 1byte씩  읽음
			FileOutputStream fo = new FileOutputStream("b.txt");){
//		try(FileReader fi = new FileReader("a.txt");){ //~Reader 텍스트단위로 읽음
			int c = 0;		
			while((c = fi.read()) != -1) {	//변수 c는 정수, 아스키코드로 저장
				//fo.write(c);
				//System.out.println((char)c);
			}
			
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("파일이 저장되었습니다");
	}

}
