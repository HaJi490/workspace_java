package java_ch12입출력;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test16 {

	public static void main(String[] args) {

		try (ObjectInputStream in 
				= new ObjectInputStream(new FileInputStream("user.txt"))) {
			UserBean user = (UserBean) in.readObject();
			System.out.println(user); // usetbean클래스에 toString에 추가하면 읽을 수 있음

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
