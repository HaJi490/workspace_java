package java_ch07_추상클래스;

public class MessengerTest {
	public static void main(String[] args) {
		IPhoneMessenger iphone = new IPhoneMessenger();
		iphone.getMessage();
		iphone.setMessage("좋아요");
	}

}
