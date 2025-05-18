package Day7;
//Object, Class & Method
public class People {
	
	//state
	int age;
	char Gender;
	boolean isMarried;
	
	//Method
	void displayData() {
		System.out.println("\n"
		     	+ "Age : " + age
		     	+"\n"
		     	+ "Gender : " + Gender
		     	+"\n"
		     	+ "isMarried : " + isMarried
				+ "\n");
	}
	
	public static void main(String[] args) {
		//Object-1
		People Kajal = new People();
		Kajal.age=20;
		Kajal.Gender='F';
		Kajal.isMarried=true;
		Kajal.displayData();
		
		//Object-2
		People Anamika = new People();
		Anamika.age=22;
		Anamika.Gender='F';
		Anamika.isMarried=true;
		Anamika.displayData();
		
		//Object-3
		People Vikram = new People();
		Vikram.age=29;
		Vikram.Gender='M';
		Vikram.isMarried=true;
		Vikram.displayData();
		
		//Object-4
		People Aparna = new People();
		Aparna.age=28;
		Aparna.Gender='F';
		Aparna.isMarried=true;
		Aparna.displayData();
		
		//Object-5
		People Darren = new People();
		Darren.age=20;
		Darren.Gender='M';
		Darren.isMarried=true;
		Darren.displayData();
		
	}

}
