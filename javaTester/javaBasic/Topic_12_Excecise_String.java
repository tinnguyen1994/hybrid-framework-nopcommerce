package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_Excecise_String {
	String courseName = "Automation Testing Advancde 20 21 22 2";

	public void TC_01() {
		char courseNameArr[] = courseName.toCharArray();
		int countNumber = 0;
		int countLower = 0;
		int countUpper = 0;

		for (char charactor : courseNameArr) {
			if (charactor >= 'A' && charactor <= 'Z') {
				countUpper++;
			}
			if (charactor >= 'a' && charactor <= 'z') {
				countLower++;
			}
			if (charactor >= '0' && charactor <= '9') {
				countNumber++;
			}

		}
		System.out.println("Sum of nubmer = " + countNumber);
		System.out.println("Sum of lower = " + countLower);
		System.out.println("Sum of upper = " + countUpper);
	}

	
	public void TC_02() {
		char courseNameArr[] = courseName.toCharArray();
		int count = 0;
		for (char c : courseNameArr) {
			if (c == 'a') {
				count++;
			}

		}
		System.out.println(count);
		System.out.println("Co chua Testing = " + courseName.contains("Testing"));
		System.out.println("Bat dau bang Automation = " + courseName.startsWith("Automation"));
		System.out.println("Ket thuc bang Online = " + courseName.endsWith("Online"));
		System.out.println("Lay vi tri cua tu 'Advancde' = " + courseName.indexOf("Advancde"));
		System.out.println("Thay the chuoi' = " + courseName.replace("Advancde", "Online"));

	}
	@Test
	public void TC_03() {
		char courseNameArr[] = courseName.toCharArray();
		for (int i = courseNameArr.length - 1; i>0 ;i--) {
			System.out.print(courseNameArr[i]);
		}
		
	}
}
