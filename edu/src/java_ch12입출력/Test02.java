package java_ch12입출력;

import java.io.InputStream;
import java.io.PrintStream;

public class Test02 {

	public static void main(String[] args) {
		try (InputStream keyboard = System.in;	//다형성 
			 PrintStream console = System.out;) {
			int c = 0;
			while ((c = keyboard.read()) != -1) {	//.read는 1byte씩 읽음
				console.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}
	}

}
