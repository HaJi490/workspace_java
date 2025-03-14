package ch05_재귀알고리즘;
/*
 * 미로 찾기 문제
 * plato(LMS)의 미로 찾기 문제 설명 자료 학습
 * int input[12][15] 테이블에서 입구는 (0,0)이며 출구는 (11,14)임
 * 미로 테이블 (12,15)을 상하좌우 울타리를 친 maze[14][17]을 만들고 입구는 (1,1)이며 출구는(12,15)
 * stack을 사용한 backtracking 구현
 */

//23.2.16 수정
//23.2.24: 객체 배열 초기화, static 사용, 내부 클래스와 외부 클래스 사용 구분을 못하는 문제 => 선행 학습 필요

//열거형 클래스 {상수명1(고정값), 상수명2(고정값)...} //public static final 데이터타입 상수명1 = 고정값;
//enum 값 가져오기: 클래스명.상수명
enum Directions {N, NE, E, SE, S, SW, W, NW};


class Items {
	int x;
	int y;
	int dir;	//다음 이동방향
}

//이동후 위치가 maze[g][h]인 값 
class Offsets {
	int a;
	int b;
}
//offsets move[8];
////q는 0 ~ 7 값을 가짐
//g = i + move[q].a; h = j + move[q].b;


public class train5_7_3미로찾기과제 {

	static Offsets[] moves = new Offsets[8];//static을 선언하는 이유를 알아야 한다
	int maze[14][17];
	int mark[14][17];

	static void path(int maze[][], int mark[][], int m, int p){//m = 12, p = 15
	//출발점 (1,1), 이동 방향 dir = 2(2는 동쪽) 을 스택에 push
		
	//initialize stack to the maze entrance coordinates and direction east;
	while (stack is not empty) {
		//(i,j,dir) = coordinates(좌표) and direction deleted from top of stack;
		//현재 위치 (i,j)에 대하여 mark[][]을 1로 설정
	   while (there are more moves){//8가지 방향중에서 남은 방향에 대하여
	      (g,h) = coordinates of next move;//현재 위치 (i,j)에 대하여 이동 방향 계산 //(g, h)는 다음위치
	      if ((g == m) && (h == p)) {
	    	  //success;
	    	  //(i,j)와 (g,h)에 대하여 mark 표시
	    	  return;
	      }
	      if ((!maze[g][h]) //legal move
	         && (!mark[g][h]) {//haven't been here before
	      
	         mark[g][h] = 1;
	         dir = next direction to try;
	         add (i,j,dir) to top of stack;
	         i = g; j = h; dir = N;
	      }
	      else
	          d++; //try next direction
	   }
	   (i,j) //현위치에 대한 mark를 취소
	}
	cout << "No path found" << endl;

	}
	
	static void show(String str, int[][] arr) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];
		
		//울타리는 1로 감싸둬야함
		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		for (int ia = 0; ia < 8; ia++)
			//moves[ia] 배열을 Offsets 객체가 가짐 -> 중요
			//Offset은 객체에 대한 생성자
			moves[ia]  = new Offsets(0, 0);//배열에 offsets 객체를 치환해야 한다.
		moves[0].a = -1;	moves[0].b = 0;
		moves[1].a = -1;	moves[1].b = 1;
		moves[2].a = 0;		moves[2].b = 1;
		moves[3].a = 1;		moves[3].b = 1;
		moves[4].a = 1;		moves[4].b = 0;
		moves[5].a = 1;		moves[5].b = -1;
		moves[6].a = 0;		moves[6].b = -1;
		moves[7].a = -1;	moves[7].b = -1;
		Directions d; //이동방향 8가지 선언, qsms 0-7의 값을 가짐
		d = Directions.N;
//		move[d]값으로 d의 값으로 다음 위치를 이동한다
		//d = d + 1;//java는 지원안됨
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				//input[][]을 maze[][]로 복사

			}
		}

		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

		path(maze, mark, 12, 15);
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);
		
	}
}

