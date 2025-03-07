package java_ch11예외처리;

import java.util.ArrayList;
import java.util.Arrays;

//Overflow 예외 클래스 p.553
class OverflowException extends RuntimeException { 
	public OverflowException() {
		super("도서관의 용량을 초과하여 책을 추가할 수 없습니다."); //왜 super?
	}
}

//Underflow 예외 클래스
class UnderflowException extends RuntimeException {
	public UnderflowException() {
		super("삭제할 도서가 없습니다.");
	}
}

//Book 클래스
class Book implements Comparable<Book> {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
	

	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString() {
		return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s", title, author, publicationYear, isbn);
	}

	@Override
	public int compareTo(Book o) {//?
		// TODO Auto-generated method stub
		return 0;
	}
}

class Library {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<Book> books;


	// 책 추가 (용량 초과 시 OverflowException 발생)
	public void addBook(Book book) throws Exception {
		books.add(book);
	}

	// 책 삭제 (빈 목록에서 삭제 시 UnderflowException 발생)
	public Book removeBook() throws Exception{
		books.remove(0);
		return null;
	}

	public void printBooks(String msg) {
		System.out.println(msg + books.toString());
	}

	public void sortBooksByTitle() {
//		for(int i = 0 ; i<books.size() ; i++)
//			for(int j = i+1 ; j<books.size() ; j++) {
//				if ()
//			}
	}

	public void sortBooksByISBN() {
		
	}

	public Book searchBookByTitle(String title) {
		for(Book b : books) {
			if(b.getTitle().equals(title)) return b;
		}
//		if(books.contains(title)== true) {
//			return title;
//		}
		return null;

	}
}

public class 실습_C3_11장_예외처리 {
	public class 실습11_C3_예외처리_과제 {
		public static void main(String[] args) throws Throwable {
			
			try {
				String s = new String("java");
				System.out.println(s.length());
				s = null;	//연결된 값을 가리키는 포인터가 사라짐
				System.out.println(s.length());	//null pointer error #가리킬 값이 없음
				int[] arr = new int[2];
				arr[2] = 10;
			
			} catch (ArrayIndexOutOfBoundsException e1) {// 교재534
				System.out.println("***배열 색인 예외 발생");
				System.out.println(e1.getMessage());
			
			} catch (NullPointerException e2) {
				System.out.println("***널 포인터 예외 발생");
				e2.printStackTrace();
			
			} catch (Exception e) {
				System.out.println("***예외 발생");
			
			} finally {
				System.out.println("***모든 것이 ok\n\n");// 교재 543
				// 할당된 자원을 자동으로 해제가 아니고 close(file)을 포함해야 한다
			}

			Library library = new Library();

			// 5개의 Book 객체 초기화
			Book book1 = new Book("자바", "강감찬", 1995, "12");
			Book book2 = new Book("파이썬", "이순신", 2008, "9");
			Book book3 = new Book("C#", "을지문덕", 2008, "8");
			Book book4 = new Book("자료구조", "연개소문", 1994, "45");
			Book book5 = new Book("리액트", "김춘추", 1999, "7");
			Book book6 = new Book("스프링", "홍길동", 2025, "99");
			
			// 예외 처리를 적용한 책 추가 및 삭제
			try {
				library.addBook(book1);
				library.addBook(book2);
				library.addBook(book3);
				library.addBook(book4);
				library.addBook(book5);
				library.addBook(book6);
			// 도서관의 용량을 초과하여 책을 추가 (예외 발생)
			} catch (OverflowException e1) {	//ArrayList는 자동으로 확장아닌가?
				e1.printStackTrace();
			}finally {
				System.out.println("OK");
			}

			// 도서 목록 출력
			library.printBooks("\n\n현재 도서 목록:");
			try {
				// 빈 도서관에서 책을 삭제 (예외 발생)
				library.removeBook(); //참조변수없어도 실행? > remove메서드에서 인덱스0인걸 삭제하도록 설정됨

			} catch (UnderflowException e2) {
				e2.printStackTrace();
			}finally {
				System.out.println("OK");
			}

			// 최종 도서 목록 출력
			library.printBooks("\n최종 도서 목록:");
		}
	}

}
