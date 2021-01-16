public class Appointment 
{
	private int AppointmentID ;
	private String AppointmentDate;
	private String AppointmentSlot;
	private String AppointmentSubject;
	private int MemberID;
	private int StudentID;
	
	
	public Appointment(){}
	public int getAppointmentID() {
		return AppointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		AppointmentID = appointmentID;
	}
	public String getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	public String getAppointmentSlot() {
		return AppointmentSlot;
	}
	public void setAppointmentSlot(String appointmentSlot) {
		AppointmentSlot = appointmentSlot;
	}
	public int getMemberID() {
		return MemberID;
	}
	public void setMemberID(int memberID) {
		MemberID = memberID;
	}
	public int getStudentID() {
		return StudentID;
	}
	public void setStudentID(int studentID) {
		StudentID = studentID;
	}
	public String getAppointmentSubject() {
		return AppointmentSubject;
	}
	public void setAppointmentSubject(String appointmentSubject) {
		AppointmentSubject = appointmentSubject;
	}
}
