package javaOOP.Exception;

public class TryCatchException {

	public static void main(String[] args) {
//		int number =10;
//		number = number/10;
//		System.out.println(number);
//		try {
//			//đúng chạy hết đoạn code qua try
//			//sai-gặp exception nhảy qua catch
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		String[] browsewrName= {"Chrome", "Safari","Firefox"};
//		try {
//			browsewrName[1] = "Edge";
//			browsewrName[3] = "IE";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		for (String browser : browsewrName) {
//			System.out.println(browser);
//		}
		
		
		try {
			int array[] = new int[10];
			array[11] = 30/1;
		} catch (ArithmeticException e) {
			System.out.println("Không thể chia cho 0");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index vượt qua độ dài của mảng");
		}
	}

}
