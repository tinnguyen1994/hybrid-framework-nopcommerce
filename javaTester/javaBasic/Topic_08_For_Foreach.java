package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
	
	Scanner scanner = new Scanner(System.in);
	
	public void TC_01() {
		
		for (int i = 1; i < 8; i++) {
			
				System.out.println(i);
		
		}
		
		//Mảng(Array/List/Set/Queue) luôn luôn bắt đầu từ 0
		
		String[] cityName = {"Đà Nẵng", "Hà Nội", "Cần Thơ", "Hồ Chí Minh" };
		
		//For kết hợp if : thỏa mản điều kiện mới action
		//Biến đếm - dùng điều kiện để fillter
		for (int i = 0; i < cityName.length; i++) {
			System.out.println(cityName[i]);
			
		}
		
		//Dùng để chạy qua hết tất cả giá trị
		for (String city : cityName) {
			System.out.println(city);
			
		}
	}
	@Test
	public void TC_02() {
		String[] cityName = {"Đà Nẵng", "Hồ Chí Minh","Hà Nội","Hà Tĩnh"};
		
		List<String> cityAddress = new ArrayList<String>();
		
		//Coding
		cityAddress.add("Bắc Ninh");
		cityAddress.add("Quảng Nam");
		cityAddress.add("Cần Thơ");
		cityAddress.add("Kiên Giang");	
		
		//Runtime
		for (String city : cityName) {
				cityAddress.add(city);
		}
		System.out.println(cityAddress.size());
	}

}
