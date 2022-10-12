package javaAccModifierFirst;

public class Student {
	private int age ;
	String name;
	
	public void setAge(int enterAge) {
		if (enterAge > 0) {
			this.age = enterAge;
		}else {
			System.out.println("Enter age is invalid");
		}
	}
	public int getAge() {
		return this.age;
	}
}
