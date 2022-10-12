package javaAccModifierFirst;

public class Computer {
	private int ssdSize;
	
	private void setSsdSize(int ssd_Size) {
		ssdSize = ssd_Size;
	}
	
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.ssdSize= 500;
		
	}
}
