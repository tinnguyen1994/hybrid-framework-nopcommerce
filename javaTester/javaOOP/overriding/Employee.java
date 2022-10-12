package javaOOP.overriding;

public class Employee extends Person implements Iwork {
	
	

	public void eat() {
		System.out.println("Suất cơm 25.000VND");
	}
	@Override
	public void sleep() {
		System.out.println("Ngủ 12 tiếng 1 ngày");
	}
	@Override
	public void workingTime() {
		System.out.println("Làm 7 tiếng /ngày");
	}

}
