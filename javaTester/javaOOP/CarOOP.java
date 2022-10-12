package javaOOP;

public class CarOOP {
	private String carCompany;
	private String carModel;
	private String fuelType;
	private float milesAge;
	private double carPrice;
	public CarOOP(String carCompany, String carModel, String fuelType, Float milesAge, Double carPrice) {
		this.carCompany = carCompany;
		this.carModel = carModel;
		this.fuelType = fuelType;
		this.milesAge = milesAge;
		this.carPrice = carPrice;
	}
	
	public static void  main(String[] args) {
		CarOOP honda = new CarOOP("Honda", "City", "Petrol", 200f, 300000d);
		
		honda.showCarInfor();
		
		
		CarOOP toyota = new CarOOP("Toyota", "Camry", "Diesel", 300f, 30000d);
		
		toyota.showCarInfor();
		
	}



	private String getCarCompany() {
		return carCompany;
	}

	private void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	private String getCarModel() {
		return carModel;
	}

	private void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	private String getFuelType() {
		return fuelType;
	}

	private void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	private float getMilesAge() {
		return milesAge;
	}

	private void setMilesAge(float milesAge) {
		this.milesAge = milesAge;
	}

	private double getCarPrice() {
		return carPrice;
	}

	private void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	public void showCarInfor() {
		System.out.println("Car company : " + getCarCompany());
		System.out.println("Car company : " + getCarModel());
		System.out.println("Car company : " + getFuelType());
		System.out.println("Car company : " + getMilesAge());
		System.out.println("Car company : " + getCarPrice());
	}
	
	
}
