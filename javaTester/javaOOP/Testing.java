package javaOOP;

public class Testing {

	public static void main(String[] args) {
		Topic_06_Getter_Setter topic = new Topic_06_Getter_Setter();
		
//		topic.setPersonName("John");
//		System.out.println(topic.getPersonName());
//		topic.setPersonName("");
//		System.out.println(topic.getPersonName());
		topic.setPersonAge(2);
		System.out.println(topic.getPersonAge());
		topic.setPersonAge(0);
		System.out.println(topic.getPersonAge());
	}

}
