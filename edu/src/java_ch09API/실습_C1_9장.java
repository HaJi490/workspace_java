package java_ch09API;

import java.util.Arrays;

/*
도서 관리 시스템은 다양한 책을 관리하고, 고객이 도서를 대여하거나 반납할 수 있게 하는 기능을 제공합니다. 또한, 고객의 대여 기록을 관리하고, 특정 조건에 맞는 책을 검색하거나 필터링하는 기능도 구현합니다.

1단계: 기본 클래스 및 컬렉션 사용
목표: Book 클래스 생성 및 기본 컬렉션 사용
설계:
Book 클래스: 제목, 저자, 출판 연도, ISBN 등을 속성으로 가짐
Library 클래스: 도서 목록을 관리하는 기능 (책 추가, 책 목록 출력)
과제:
Book 클래스를 작성하고 도서 정보를 담는 객체를 생성하세요.
Library 클래스를 작성해 ArrayList를 사용하여 도서를 관리하고, 도서 목록을 출력하세요.
 */
// Book 클래스
class Book {
	private String title;
	private String author;
	private int publicationYear;
	private String ISBN;

	public Book(String title, String author, int publicationYear, String ISBN) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String isbn) {
		this.ISBN = ISBN;
	}

	@Override
	public String toString() {
		// System.out.println();
		return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s", // %s 변수값을 찍음, format을 이용하여 식 완성
				title, author, publicationYear, ISBN);
	}

}

// Library 클래스
class Library {
	static final int CAPACITY = 20;
	private Book[] books;// 필드가 배열일때 생성자 //몇개의 books을 저장할건지 정해야됨
	private int top; // 배열의 몇번째인지

	public Library() { // 받을건 없음 = 매개변수 없음
		books = new Book[CAPACITY];
		top = 0;
	}

	public boolean addBook(Book book) {
		if (top >= CAPACITY) {
			return false;
		}
		books[top++] = book;
		// top++;
		return true;
	}

	public void printBooks(String msg) {
//		System.out.println(msg + ":" + Arrays.toString(books));
		System.out.println(msg);
		for (int i = 0; i < top ; i++) { // 내가한
			System.out.println(books[i].toString());
		}
	}

	public void sortBooksByTitle() {
		// String의 compareTo() 사용
		// Array #자바의 클래스# .sort() #static메서드# books, 0, top, #배열의 시작과 끝 > 정렬# (b1, b2) # books에 담겨진 객체, 앞에 메서드명 생략됨, 안에 있는 내용을 2개씩 호출해서 비교# ->뒤에있는건 #람다식#
		// Arrays.sort(books, 0, top, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));//9.3.3 Arrays 클래스 

		int last = top - 1;
		while (true) {
			for (int i = 0; i < last ; i++) {
				if (books[i].getTitle().compareTo(books[i + 1].getTitle()) > 0) {
					// swap(1. 값만 바꿈)
//				String str = books[i].getTitle();
//				books[i].setTitle(books[i+1].getTitle());
//				books[i+1].setTitle(str);

					Book b = books[i]; // 2. 객체 자체를 바꿈
					books[i] = books[i + 1];
					books[i + 1] = b;
				}
			}
			if(--last == 1) break;	//--last > top이 1이되면 break, top이 1일때 for문이 진행안하고 끝? 아님 안하고끝?
		}
	}

	public void sortBooksByISBN(){
		//String의 compareTo() 사용
		//Arrays.sort(books, 0, top, (b1, b2) -> Integer.parseInt(b1.getISBN()) - Integer.parseInt(b2.getISBN()));//9.3.3 Arrays 클래스
		for(int i = 0 ; i < top ; i++) {
			for(int j =i+1; j < top ; j++) {
				int inum = Integer.parseInt(books[i].getISBN()); //Sting값을 정수로 바꾸기!!!!!!!!!
				int jnum = Integer.parseInt(books[j].getISBN());
				if(inum > jnum) {
				swap(books, i, j); //swap i열과 j열을 바꿈
				}
			}
		}
	}
	
	static void swap (Book[] books, int i, int j) {
			Book temp = books[i];
			books[i] = books[j];
			books[j] = temp;
	}

	public Book searchBookByTitle(String title) { // 받은 제목을 저장된 책들과 비교
		for (Book b : books) {
			if (b.getTitle().equals(title)) 
			return b;
		}
		return null;	//안찾아졌을때 보낼값!!!!!!!
	}
}

public class 실습_C1_9장 {
	public static void main(String[] args) {
		Library library = new Library();
		String st = "java";
		String st2 = "java";// string interning
		// the process of storing one unique instance of each distinct string value in a
		// pool to optimize memory,
		// so that multiple references to the same string literal point to the same
		// memory location.
		if (st.equals(st2))
			System.out.println("st == st2");

		// 5개의 Book 객체 초기화
		// 5개의 책 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("C++", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		// 책 추가
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);

		// 도서 목록 출력
		library.printBooks("\n" + "-".repeat(30) + "제목정렬전" + "-".repeat(30));

		// 도서 목록 정렬
		library.sortBooksByTitle();
		// 정렬된 도서 목록 출력
		library.printBooks("\n" + "-".repeat(30) + "제목정렬후" + "-".repeat(30));

		// 특정 제목으로 도서 검색
		library.printBooks("\n" + "-".repeat(30) + "ISBN정렬전" + "-".repeat(30));

		// 도서 목록 정렬
		library.sortBooksByISBN();
		// 정렬된 도서 목록 출력
		library.printBooks("\n" + "-".repeat(30) + "ISBN정렬후" + "-".repeat(30));

		// 특정 제목으로 도서 검색
		String searchTitle = "자바";
		Book foundBook = library.searchBookByTitle(searchTitle);
		if (foundBook == null)
			System.out.println("\n자바 책이 없다");
		else
			System.out.println("\n도서명으로 검색한 도서" + foundBook.toString());
	}
}
