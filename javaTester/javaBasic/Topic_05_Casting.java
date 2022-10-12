package javaBasic;

public class Topic_05_Casting {
	public String studentName;
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
		
	}
	public void showStundentName() {
		System.out.println("StudentName =" + studentName);
	}
	
	public static void main(String[] args) {
		Topic_05_Casting firstStudent = new Topic_05_Casting();
		Topic_05_Casting secondStudent = new Topic_05_Casting();
		
		firstStudent.setStudentName("Nguyen Van A");
		secondStudent.setStudentName("Tran Van B");
		
		firstStudent.showStundentName();
		secondStudent.showStundentName();
		
		secondStudent.setStudentName("Nguyen Trung Tin");
		
		firstStudent.showStundentName();
		secondStudent.showStundentName();
	}
	
}

