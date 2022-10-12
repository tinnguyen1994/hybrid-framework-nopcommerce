package javaBasic;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Topic_20_Faker {
	public static void main(String[] arrgs) {
		Faker faker = new Faker();
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().lastName());
		System.out.println(faker.business().creditCardNumber());
		
		Faker fakerVi = new Faker(new Locale("vi", "vi"));
		System.out.println(fakerVi.address().firstName());
		System.out.println(fakerVi.address().lastName());
		System.out.println(fakerVi.address().cityName());
	}
}
