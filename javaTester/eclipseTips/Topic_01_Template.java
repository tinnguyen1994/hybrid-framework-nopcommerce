package eclipseTips;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_01_Template {
	Scanner scanner = new Scanner(System.in);

	public void TC_01_For() {
		int number = scanner.nextInt();

		for (int i = number; i < 100; i++) {
			if (i % 8 == 0) {
				System.out.println("Những số chia hết cho 2 = " + i);
			}
		}

	}

	public void TC_02_While() {
		int number = scanner.nextInt();

		while (number < 100) {
			if (number % 8 == 0) {
				System.out.println("Những số chia hết cho 8 = " + number);

			}
			number++;
		}

	}

	public void TC_03_Do_While() {
		int number = scanner.nextInt();
		
		do {
			if (number % 8 == 0) {
				System.out.println("Những số chia hết cho 8 = " + number);
			}
			number++;
		} 
			while (number < 100);{
				
			}
			
		}
	
	public void TC_04_Do_While() {
		int numberA = scanner.nextInt();
		int numberB= scanner.nextInt();
		
		while (numberA < numberB) {
			if (numberA %3==0 && numberB %5 == 0) {
				System.out.println("Số chia hết 3 và 5 = " + numberA );
			}numberA++;
			
		}
		
	}
	public void TC_05_While() {
		int numberA = scanner.nextInt();
		int i = 0;
		while (numberA > 0) {
			if (numberA %2 != 0 ) {
				System.out.println(numberA);
				i += numberA;
				
			}numberA--;
			System.out.println(i);
		}
		
		
	}
	@Test
	public void TC_06_While() {
		int numberA = scanner.nextInt();
		int i = 1;
		while (numberA > 1) {
			if (numberA *2 != 0 ) {
				System.out.println(numberA);
				i *= numberA;
				
			}numberA--;
			System.out.println(i);
		}
	}
	
	}


