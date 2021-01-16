import java.sql.*;
import java.util.Vector;

public class DBConnection {
	 private static String url="jdbc:mysql://localhost:3306/office_hours_management";
	 private static String user="root";
	 private static String password="route";
	 private static Connection current_connection=null;
	 private static Statement current_statement = null;

	public String get_email(int id)
	{
		String email = null;
		ResultSet rs=null;
		try 
		{
			current_connection = DriverManager.getConnection(url,user,password);
			current_statement = current_connection.createStatement();
			String sql="select * from student where StudentID="+id;
			rs=current_statement.executeQuery(sql);
			while(rs.next())
			{
				email=rs.getString("StudentEmail");
			}
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Error with execution..");
		}
		
		return email;
	}
	
	//unused
	public int get_student_id_email(String email)
	{
		int id = 0;
		ResultSet rs=null;
		try 
		{
			current_connection = DriverManager.getConnection(url,user,password);
			current_statement = current_connection.createStatement();
			current_statement = current_connection.createStatement();
			String sql="select * from student where StudentEmail="+email+" ';";
			rs=current_statement.executeQuery(sql);
			while(rs.next())
			{
				id=rs.getInt("StudentID");
			}
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Error with execution of get StudentID with StudentEmail..");
		}
		
		return id;
	}
	
	//used
	public boolean add_student_password(int p,String email) 
	{
		int result = 0;
		String pass=String.valueOf(p);
		try 
			{
				current_connection = DriverManager.getConnection(url,user,password);
				current_statement = current_connection.createStatement();
				result=current_statement.executeUpdate("Update student SET Studentpwd='"+pass+"'"+"WHERE StudentEmail='"+email+"'");
			}
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		if(result==1)
		{
			return true;
		}
		return false;
	}
	//used
	public boolean add_member_password(int p,String email) 
	{
		int result = 0;
		String pass=String.valueOf(p);
		try 
			{
			current_connection = DriverManager.getConnection(url,user,password);
			current_statement = current_connection.createStatement();
			result=current_statement.executeUpdate("Update staff_member SET Mmberpwd='"+pass+"'"+"WHERE MemberEmail='"+email+"'");
			}
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		if(result==1)
		{
			return true;
		}
		return false;
	}
	

	
	
	
	
	
	public Appointment get_appointment(int id)
	{
		Appointment current_appointment=new Appointment();
		ResultSet rs=null;
		try 
		{
			current_connection = DriverManager.getConnection(url,user,password);
			current_statement = current_connection.createStatement();
			rs = current_statement.executeQuery("SELECT * FROM appointment WHERE AppointmentID = '" +id + "'");

			/*String sql="select * from appointment where AppointmentID="+id;
			rs=current_statement.executeQuery(sql);*/
			while(rs.next())
			{
				current_appointment.setAppointmentDate(rs.getString("AppointmentDate"));
				current_appointment.setAppointmentID(rs.getInt("AppointmentID"));
				current_appointment.setAppointmentSlot(rs.getString("AppointmentSlot"));
				current_appointment.setAppointmentSubject(rs.getString("AppointmentSubject"));
				current_appointment.setMemberID(rs.getInt("MemberID"));
				current_appointment.setStudentID(rs.getInt("StudentID"));
				System.out.println(current_appointment.getStudentID());
			}
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Error with execution..");
		}
		
		return current_appointment;
	}
	
	
	public StaffMember get_staff_member(int member_id)
	{
		StaffMember member =new StaffMember();
		ResultSet rs=null;
		try 
		{
			current_connection = DriverManager.getConnection(url,user,password);
			current_statement = current_connection.createStatement();
			String sql="select * from staff_member where MemberID="+member_id;
			rs=current_statement.executeQuery(sql);
			while(rs.next())
			{
				member.setMemberEmail(rs.getString("MemberEmail"));
				System.out.println(member.getMemberName());
				member.setMemberName(rs.getString("MemberUsername"));
				member.setMemberPassword(rs.getString("Mmberpwd"));
				member.setMemberRole(rs.getString("MemberRole"));
			}
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Error with execution..");
		}
		
		return member;
	}
	
	
	public Student get_student(int student_id)
	{
		Student student=new Student();
		ResultSet rs=null;
		try 
		{
			current_connection = DriverManager.getConnection(url,user,password);
			current_statement = current_connection.createStatement();
			String sql="select * from student where StudentID="+student_id;
			rs=current_statement.executeQuery(sql);
			while(rs.next())
			{
				student.setStudentEmail(rs.getString("StudentEmail"));
				student.setStudentName(rs.getString("StudentFName")+" "+rs.getString("StudentLName"));
				student.setStudentPassword(rs.getString("Studentpwd"));
				student.setStudentID(student_id);
				System.out.println(student.getStudentName());
			}
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Error with execution..");
		}
		
		return student;
	}
	
	
	public boolean delete_appointment(int AppointmentID)
	{
		
		ResultSet RS=null;
		
		////////////////////////////////////////
		try {
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
			} 
			catch (ClassNotFoundException e2) 
			{
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}	
			current_connection = DriverManager.getConnection(url,user,password);
			current_statement = current_connection.createStatement();
			RS = current_statement.executeQuery("DELETE FROMappointment WHERE AppointmentID= '"+AppointmentID+"';");

			if (RS.next()) {
				return true;
				
			}
			else
			{
				return false;	
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	public static void main(String[] args) {
		
	}
}