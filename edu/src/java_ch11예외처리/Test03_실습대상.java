//try - catch - resources
//try-catch-finally를 간단하게 사용하는 방법이다
package java_ch11예외처리;

//try catch resources를 사용하지 않는 경우
import java.io.FileInputStream;
import java.io.IOException;

public class Test03_실습대상 {

	public static void main(String[] args) {
		//FileInputStream fi = null;
		try(FileInputStream fi = new FileInputStream("a.txt")) //try-with-resource문 ㅔ.545
 		{
		// {//try-catch-resources문
		//try {
			fi = new FileInputStream("a.txt"); //1.파일을 열어서
			int c = fi.read();
			fi.read(null);
			System.out.println((char) c);	//2. c 출력
		} catch (IOException e) {
			if (fi != null) {
				try {
					fi.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		}
	}
}

