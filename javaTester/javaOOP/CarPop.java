package javaOOP;

public class CarPop {
	static String carCompany;
	static String carModel;
	static String fuelType;
	static float milesAge;
	static double carPrice;

	public static void main(String[] args) {
		carCompany = "Honda";
		carModel = "Civic";
		fuelType = "Diesel";
		milesAge = 150;
		carPrice = 20000;
		System.out.println("Car company : " + carCompany );
		System.out.println("Car Model : " + carModel );
		System.out.println("Fuel Type : " + fuelType );
		System.out.println("Miles Age : " + milesAge );
		System.out.println("Price : " + carPrice );
	}

}
