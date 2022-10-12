package javaOOP.overriding;

public class Student extends Person implements Iwork {
	public void eat() {
		System.out.println("Suất cơm 15.000VND");
	}

	@Override
	public void sleep() {
		System.out.println("Ngủ 8 tiếng 1 ngày");
	}

	@Override
	public void workingTime() {
		System.out.println("Học 5 tiếng/ ngày");
	}
}
