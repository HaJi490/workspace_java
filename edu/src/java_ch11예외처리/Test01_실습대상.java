package java_ch11예외처리;

//catch된 객체를 출력하는 실습
public class Test01_실습대상 {

	public static void main(String[] args) {
		int arr2[] = new int[3];
		//arr2[3] = 0;

		String st = "hello";
		//st = null;
		System.out.println(st.length());

		try {
			String s = new String("java");
			int len = s.length();
			s = null;
			s.length(); // new NullPointerException()
			int arr[] = new int[3];
			arr[3] = 30; // new ArrayIndexOutOfBoundsException()
			System.out.println("OK");
		}
		/*
		 * catch(Exception e) { //unreachable - 상위 클래스로서 모두 여기서 capture하기 때문이다
		 * System.out.println("Exception 처리"); }
		 */
		catch (ArrayIndexOutOfBoundsException e1) {	//ArrayIndexOutOfBoundsException 오류발생시 실행 > 아니면 아래 catch문으로
			e1.printStackTrace();// 교재 542 //스택메모리의 진행순서 추적
			System.out.println(e1.getMessage());// 교재 542
		} catch (NullPointerException e2) {
			e2.printStackTrace();
			System.out.print(e2.getMessage());
			System.out.println();
		} catch (Exception e) {// 순서상 마지막에 와야함. 상위객체여서 아래 catch문들이 실행이 안됨
			System.out.println("오류 발생 : " + e);// e.toString()
		} finally {//
			System.out.println("GOOD");
		}
	}
}
