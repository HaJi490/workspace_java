package java_ch10API활용;

/*
Collection Framework : List, Map, Set으로 구성
List > ArrayList, LinkedList
Map > HashMap => 파이썬에서 dictionary : (key, value)
Set > Hashset
*/

import java.util.ArrayList;
import java.util.Arrays;
/*//자바라이브러리에서 제공
interface Comparable{
	public int compareTo();//추상메서드
}*/

//Book 클래스
class Book implements Comparable<Book>{
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
	
	public void setTitle() {
		this.title = title;
		
	}
	
	

	@Override
	public String toString() {
	    return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s \n",
	            title, author, publicationYear, isbn);
	}
	
	@Override
	public int compareTo(Book book) {	//public int는 Comparable 인터페이스를 상속받았기때문에 구현해야함
		return this.title.compareTo(book.title); //클래스의 this.title과 book의 책을 비교
	}


}

class Library {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<Book> books;

	public Library() {
		books = new ArrayList<Book>(CAPACITY);	//생성자는 ()를 넣어줘야함, ArrayList는 배열과 달리 인덱스 자동으로 늘려줌
		//int top = 0; //ArrayList는 size()라는 함수가 있어서 안해도됨
	}
	
	// 책 추가 (용량 초과 시 OverflowException 발생)
	public void addBook(Book book) {
		books.add(book); 
		//top++;
		books.size();
	}

	// 책 삭제 (빈 목록에서 삭제 시 UnderflowException 발생)
	public Book removeBook() {
		return books.remove(0);
	}

	public void printBooks(String msg) {
		System.out.println( msg );
		System.out.println( books.toString() );
	}

	public void sortBooksByTitle() {
		books.sort(null); //왜 되는거지
		
//		for(int i=0; i < books.size() ; i++) 
//			for(int j=i+1; j <= books.size() ; j++) {
//				if(books.get(i).compareTo(books.get(j))>0) {
//					Book temp = books.get(i);
					
//				}
			}
		
	
		//books.sort(); //comperateor 인터페이스 - 자료구조 반복
	//배열 정렬
//		for()
//			for{
//				swap()
//			}
//	

	public void sortBooksByISBN() {
		
	}

	public Book searchBookByTitle(String title) {
		for(Book b :books) {
			if(b.getTitle().equals(title)) return  b;
		}
		return null;
	}
}
public class 실습_C2_10장_컬렉션 {
	
	static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
		
	public static void main(String[] args) {
		
		String[]arr = new String[5];
		arr[0] = "hong"; arr[1] = "ong"; arr[2] = "nong";
		arr[3] = "ng"; arr[4] = "lee";
		
		for(int i = 0 ; i <arr.length ; i++)
			for(int j = i+1 ; j <arr.length ; j++) {
				if(arr[i].compareTo(arr[j]) > 0)
				swap(arr, i, j);
			}
		
		Library library = new Library();

		// 5개의 Book 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("C#", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);

		// 도서 목록 출력
		library.printBooks("\n현재 도서 목록:");
		
		// 도서 목록 정렬
		library.sortBooksByTitle(); 
		// 최종 도서 목록 출력
		library.printBooks("\n\n정렬후 최종 도서 목록:");
		
		// 특정 제목으로 도서 검색
		String searchTitle = "자바";
		// 정렬된 도서 목록 출력
		Book foundBook = library.searchBookByTitle(searchTitle); //객체를 만든게 아니라 있는거에서 찾는거여서?
		
		System.out.println("\n 도서명으로 검색한 도서명: " + foundBook.toString());
		if(foundBook == null) {
			System.out.println("'"+searchTitle + "'가 없습니다.");
		}else {
			System.out.println("'"+searchTitle+"'가 있습니다");
		}

		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		
		// 도서 목록 출력
		library.printBooks("\n\n현재 도서 목록:");
	}
}
