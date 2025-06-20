package Day11;
//invoking other constructor
public class d2 {
int height;
int width;

//constructor-1
 d2(int height,int width)
 {
	 this.height=height;
	 this.width=width;
 }
//constructor-2
 d2(int side)
 {
	 this(side,side);//calling constructor-1
 }
 
 public int area()
 {
	 return height*width;
 }
	public static void main(String[] args) {
		d2 obj = new d2(5);
		
		System.out.println("Area is  : "+obj.area());

	}

}
