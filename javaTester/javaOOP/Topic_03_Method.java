package javaOOP;

public class Topic_03_Method {
	
	void showCarName() {
		System.out.println("Huyndai Tucson");
	}
	static void showCarColor() {
		System.out.println("Blue");
	}

	public static void main(String[] args) {
		showCarColor();
		Topic_03_Method carName= new Topic_03_Method();
		carName.showCarName();
		Topic_03_Method.showCarColor(); 
	}

}
