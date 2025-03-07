package java_ch12입출력;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test15 {
	
	public static void main(String[] args) {
		
		UserBean user = new UserBean("purum", "오정임", "010-123-4567", "서울" );
		
		try(ObjectOutputStream out =
				new ObjectOutputStream(new FileOutputStream("user.txt"))){ //바이너리포맷(못읽는거)이 나옴 > 역직렬화로 읽음
			out.writeObject(user);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
