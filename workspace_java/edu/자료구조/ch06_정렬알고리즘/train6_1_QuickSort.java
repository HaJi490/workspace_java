package ch06_정렬알고리즘;

import java.util.ArrayList;
import java.util.List;


//stack 1개를 사용한 non-recursve QuickSort() 구현
class Stack3{
	private List<Point> data;
	private int capacity;
	private int top;
	
	public Stack3(int capacity) {
		data = new ArrayList<Point>(capacity);
		this.capacity = capacity;
		top = 0;
	}
	
	public class EmptyGenericStackException extends Exception {
		// 추가
		public EmptyGenericStackException(String msg) {
			System.out.println(msg);
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		// 추가
		public OverflowGenericStackException(String msg) {
			System.out.println(msg);
		}
	}
	
	// --- 스택에 x를 푸시 ---//
	public boolean push(Point x) throws OverflowGenericStackException {
		// 구현
		if(isFull()) {
			throw new OverflowGenericStackException("push : stack overflow");
		}
		data.add(x);
		top++;
		return true;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		// 구현
		if(isEmpty()) {
			throw new EmptyGenericStackException("pop : stack empty");
		}
		return data.remove(--top);
	}

	//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		// 구현
		if(isEmpty()) {
			throw new EmptyGenericStackException("peek : stack empty");
		}
		return data.get(top-1);
	}

	//--- 스택을 비움 ---//
	public void clear() {
		for(int i = 0 ; i < top ; i++ ) {
			data.remove(i);
		}
		top = 0;
	}

	//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		// 구현
		for(int i = 0 ;i < top ; i++)
		if(data.get(i) == x) {
			return i;
		}
		return -1;
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		//true/false 리턴됨
		return top <= 0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		//true/false 리턴됨
		return top >= capacity;
	}

//--- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() {
		// 구현
		for(Point num : data) {
			System.out.println(num);
		}
	}
	
}

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}
public class train6_1_QuickSort {


//퀵 정렬(비재귀 버전)

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) {
		//p232-233 참고
		//Stack3 st = new Stack3(10);
		Stack3 lstack = new Stack3(right - left + 1);
		Stack3 rstack = new Stack3(right - left + 1);
		Point pt = new Point(left, right);
		//st.push(pt);
		lstack.push(pt);
		

	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[10];
		for (int ix = 0; ix < 10; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
