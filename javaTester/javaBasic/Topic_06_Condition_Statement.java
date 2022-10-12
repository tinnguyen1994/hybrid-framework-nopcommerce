package javaBasic;

public class Topic_06_Condition_Statement {
	
	public static void main(String[] args) {
		boolean status = 5>3;
		System.out.println(status);
		
		if(status) {
			System.out.println("Go to if");
		}
		
		int studentNumber = 10;
		
		status = (studentNumber != 10);
		System.out.println(status);
	}

}
