package javaOOP;

public abstract class Computer {
	
	//Normal class
	public void showComputerPerformance() {
		System.out.println("Show computer performance");
	}
	//Abtract Method
	//khung để cho các Class con kế thừa nó phải override lại(implement)
	public abstract void showComputerRam();
}
