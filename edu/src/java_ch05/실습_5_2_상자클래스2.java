package java_ch05;

 class Box1 {
    // 필드 (속성)
    private double width;  // 가로
    private double height; // 세로
    private double depth;  // 높이
    
    //게터,세터
	
    public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getDepth() {
		return depth;
	}
    
    
    // 부피 계산 메소드
    double getVolume() {
        return width * height * depth;
    }

	

	public void setDepth(double depth) {
		this.depth = depth;
	}

	// 둘레 길이 계산 메소드
    double getPerimeter() {
    	return (width + height)*4;  
    }
    
    // 박스 크기 조정 (메소드 오버로딩)
    void resize(double newWidth, double newHeight, double newDepth) { //위의 생성자 재정의
        this.width=newWidth;
        this.height=newHeight;
        this.depth=newDepth;
        
    }

    void resize(double scale) {
    	width*= scale;
    	height*=scale;
    	depth*= scale;
        //박스의 가로,세로,높이를 scale 비율로 변경
    }
    
    void show() {
    	System.out.println(toString()); // toString값 실행
    }
    
    @Override
	public String toString() { //'public String toString'에서 하나도 빠지면 안됨
       return "width="+width+ ", height = " + height + ", depth = " + depth;
    }
 }


public class 실습_5_2_상자클래스2 {
	public static void main(String[] args) {
        // 박스 객체 생성
		
        Box1 box1 = new Box1();
        
        box1.setWidth(10);
        box1.setHeight(5);
        box1.setDepth(3);
        

        // 박스 정보 출력
        box1.show(); //위에 메쏘드 호출해서 보여줌
        //System.out.println(box1);
        System.out.println("\r box1 부피 \r" + box1.getVolume());
        // 박스 크기 변경
        System.out.println("\r >box1 크기 변경");
        box1.resize(15, 8, 5);
        box1.show();
        System.out.println(box1.getPerimeter());
        // 박스를 2배 확대
        System.out.println("\r >box1를 2배 확대");
        box1.resize(0.5);
        box1.show();
        
        Box box2 = new Box(4, 7, 3);
        System.out.println(box2);
        //box2.show();
        
     // 박스 크기 변경
        System.out.println("\r >box2 크기 변경");
        box2.resize(9, 3, 8);
        System.out.println(box2);
        //box2.show();

        System.out.println("\r >box2를 2배 확대");
        box2.resize(1.5);
        System.out.println(box2);
        //box2.show();
        
    }
}

