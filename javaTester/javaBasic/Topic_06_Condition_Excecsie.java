package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Excecsie {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	
	public void TC_01() {
		int number = scanner.nextInt();
	
		
		if (number % 2 == 0) {
			System.out.println("Số : " + number + "là số chẵn");
		}else {
			System.out.println("Số : " + number + "là số lẻ");
		}
		
		
	}
	
	public void TC_02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		if (numberA > numberB) {
			System.out.println(numberA + " lớn hơn " + numberB);
			
		}else if (numberA == numberB){
			System.out.println(numberA + " bằng với " + numberB);
		}else {
			System.out.println(numberA + " nhỏ hơn " + numberB);
		}
			
	}
	
	public void TC_03() {
		String nameA = scanner.nextLine();
		String nameB = scanner.nextLine();
		
		if (nameA.equals(nameB)) {
			System.out.println(nameA + " trùng với tên của " + nameB);
			
		}else {
			System.out.println(nameA + " khác với tên của " + nameB);
		}
			
	}
	public void TC_04() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
		
		if (numberA > numberB && numberA > numberC ) {
			System.out.println(numberA + " là số lớn nhất ");
		} else if(numberB > numberC && numberB > numberA) {
			System.out.println(numberB + " là số lớn nhất ");
		} else {
			System.out.println(numberC + " là số lớn nhất ");
		}
		
	}
	public void TC_05() {
		int number = scanner.nextInt();
		
		if (10< number && number<100) {
			System.out.println(number + " nằm trong khoảng 10 đến 100");
		} else {
			System.out.println(number + " nằm ngoài khoảng 10 đến 100");
		}
	}
	public void TC_06() {
		float number = scanner.nextFloat();
		
		if (5 > number ) {
			System.out.println(number + " là điểm D ");
		} else if(5 <= number && number < 7.5 ) {
			System.out.println(number + " là điểm C ");
		}if (7.5 <= number && number < 8.5) {
			System.out.println(number + " là điểm B ");
		} else if (8.5 <= number && number <= 10) {
			System.out.println(number + " là điểm A ");
		} {

		}
	}
	@Test
	public void TC_07() {
		int month = scanner.nextInt();
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("Tháng này có 31 ngày");
		} else if(month ==2) {
			System.out.println("Tháng này có 28 ngày");
		}else if(month == 4 || month == 6 || month == 9 || month == 11	 ) {
			System.out.println("Tháng này có 30 ngày");
		}
	
	}
}
