package javaOOP;

public class Topic_04_Overloading {
	
	static int plusMethod(int x, int y) {
		return x + y;
		
	}
	
	static double plusMethod(double x, double y) {
		return x + y ;
	}

	public static void main(String[] args) {
		System.out.println(plusMethod(10, 5));
		System.out.println(plusMethod(3, 4));
	}

}
