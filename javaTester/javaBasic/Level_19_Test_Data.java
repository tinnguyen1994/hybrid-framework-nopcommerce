package javaBasic;

import java.util.Random;

public class Level_19_Test_Data {

	public static void main(String[] args) {
		System.out.println(getRandomNumber());
	}
	public static int getRandomNumber() {
		int maxNumner = 999;
		int minNumber= 100;
		Random rand= new Random();
		return minNumber + rand.nextInt(maxNumner - minNumber);
	}
	
	
	
}
