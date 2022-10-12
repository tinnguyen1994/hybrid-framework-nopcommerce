package javaAccModifierFirst;

public class MainClass {

	public static void main(String[] args) {
		 Student std = new Student();
		 
		std.setAge(15);
		System.out.println(std.getAge());
		std.setAge(-15);
		System.out.println(std.getAge());
	}

}
