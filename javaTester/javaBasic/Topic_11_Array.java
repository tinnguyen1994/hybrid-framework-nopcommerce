package javaBasic;

public class Topic_11_Array {
	int id ;
	String name;
	int age;
	double point;
	

	public Topic_11_Array(int id,String name, int age,double point ) {
		this.id = id;
		this.name = name;
		this.age = age;		
		this.point = point;
	}
	public void display() {
		System.out.println("ID = " + id);
		System.out.println("Name =" + name);
		System.out.println("Age = " + age);
		System.out.println("Point = " + point);
		
	}
	
	public static void main(String[] args) {
		Topic_11_Array[] students = new Topic_11_Array[5];
		students[0] = new Topic_11_Array(01, "Tin", 28, 9.7);
		students[1] = new Topic_11_Array(02, "Long", 28, 7.2);
		students[2] = new Topic_11_Array(03, "Uyen", 28, 8.1);
		students[3] = new Topic_11_Array(04, "John", 28, 6.2);
		students[4] = new Topic_11_Array(05, "Selena", 28, 4.4);
		
		
		for (int i = 0; i < students.length; i++) {
			students[i].display();
		}
	}

}
