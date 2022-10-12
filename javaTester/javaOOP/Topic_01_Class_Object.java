package javaOOP;

public class Topic_01_Class_Object {
	private int studentID;
	private String studentName;
	private Float knowlegePoint;
	private Float practicePoint;
	
//	protected Topic_01_Class_Object(int studentID, String studentName, Float knowlegePoint, Float practicePoint) {
//		this.studentID = studentID;
//		this.studentName = studentName;
//		this.knowlegePoint = knowlegePoint;
//		this.practicePoint = practicePoint;
//	}

	private int getStudentID() {
		return studentID;
	}

	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	private String getStudentName() {
		return studentName;
	}

	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private Float getKnowlegePoint() {
		return knowlegePoint;
	}

	private void setKnowlegePoint(Float knowlegePoint) {
		this.knowlegePoint = knowlegePoint;
	}

	private Float getPracticePoint() {
		return practicePoint;
	}

	private void setPracticePoint(Float practicePoint) {
		this.practicePoint = practicePoint;
	}
	
	private float getAverage() {
		return (this.getKnowlegePoint() + this.getPracticePoint()*2)/3;
	}
	public void showStudentInfor() {
		System.out.println("Student ID : " + getStudentID());
		System.out.println("Student Name : " + getStudentName());
		System.out.println("Student knowlege point : " + getKnowlegePoint());
		System.out.println("Student practice point : " + getPracticePoint());
		System.out.println("Student average point : " + getAverage());
	}
	

	public static void main(String[] args) {
		Topic_01_Class_Object firstStudent = new Topic_01_Class_Object();
		firstStudent.setStudentID(29213);
		firstStudent.setStudentName("Nguyen Van A");
		firstStudent.setKnowlegePoint(7.9f);
		firstStudent.setPracticePoint(8.2f);
		
		firstStudent.showStudentInfor();
	}
}
