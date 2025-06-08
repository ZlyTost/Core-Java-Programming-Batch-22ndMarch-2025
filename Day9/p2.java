package Day9;
//invoking other constructor
public class p2 {
int height;
int width;

//constructor-1
 p2(int height,int width)
 {
	 this.height=height;
	 this.width=width;
 }
//constructor-2
 p2(int side)
 {
	 this(side,side);//calling constructor-1
 }
 
 public int area()
 {
	 return height*width;
 }
	public static void main(String[] args) {
		p2 obj = new p2(5);
		
		System.out.println("Area is  : "+obj.area());

	}

}
