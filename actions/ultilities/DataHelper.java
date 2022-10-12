package ultilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	Faker dataFaker = new Faker();
	Locale locale = new Locale("en");
	public static DataHelper getdataHelper() {
		return new DataHelper();
	}
	public String getFirstName() {
		return dataFaker.address().firstName();
	}
	public String getLastName() {
		return dataFaker.address().firstName();
	}
	public String getEmailAddress() {
		return dataFaker.internet().emailAddress();
	}
	public String getCityName() {
		return dataFaker.address().city();
	}
	public String getPhoneNumber() {
		return dataFaker.phoneNumber().phoneNumber();
	}
	public String getPassword() {
		return dataFaker.internet().password();
	}

	
}
