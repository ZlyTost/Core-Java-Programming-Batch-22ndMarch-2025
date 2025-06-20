package Day11;
//static variable
public class d4 {
 static int count = 0;
 d4(){
	 count++;
 }
 
 static int getcount()
 {
	 return count;
 }
	public static void main(String[] args) {
		new d4();
		new d4();
		new d4();
		new d4();
		new d4();
		new d4();
		System.out.println(d4.getcount());

	}

}
