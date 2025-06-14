package Day10;
//Method overriding

class Animal{
	void speak(){
		System.out.println("All Animal can speak");
	}
}

class Dog extends Animal{
void speak(){
		System.out.println("Dogs can Bark...");
	}
}

class Cat extends Animal{
void speak(){
		System.out.println("Cat can Meow");
	}
}

public class Polymorphism_3 {

	public static void main(String[] args) {
		/*Animal a = new Animal();
		Dog d = new Dog();
		Cat c = new Cat();
		
		System.out.println("\nAnimal -->\n");
		a.speak();
		System.out.println("\nDog -->\n");
		d.speak();
		System.out.println("\nCat -->\n");
		c.speak();*/
		
		//perform method overriding
		
		//parents class references
		Animal a = new Animal();
		System.out.println("\nAnimal -->\n");
		a.speak();
		
		
		a = new Dog();//refers to dogs object
		System.out.println("\nDog -->\n");
		a.speak();//calls dogs speak()
		
		
		a = new Cat();//refers to cat object
		System.out.println("\nCat -->\n");
		a.speak();//calls cats speak()
	}

}
