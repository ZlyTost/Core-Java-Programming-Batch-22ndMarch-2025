package Day9;
//static variable
public class p4 {
 static int count = 0;
 p4(){
	 count++;
 }
 
 static int getcount()
 {
	 return count;
 }
	public static void main(String[] args) {
		new p4();
		new p4();
		new p4();
		new p4();
		new p4();
		new p4();
		System.out.println(p4.getcount());

	}

}
