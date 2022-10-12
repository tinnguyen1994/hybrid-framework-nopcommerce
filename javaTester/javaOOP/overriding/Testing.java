package javaOOP.overriding;

public class Testing {

	public static void main(String[] args) {
		Student std = new Student();
		std.eat();
		std.sleep();
		std.workingTime();

		Employee emp = new Employee();
		emp.eat();
		emp.sleep();
		emp.workingTime();
		

	}
}
