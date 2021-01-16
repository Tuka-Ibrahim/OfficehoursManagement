<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.sql.*"%>
<%@page import="javax.servlet.http.HttpSession.*"%>
<%@page import=" java.util.Scanner.*"%>
<%@page import=" java.time.LocalDate.*"%>
<%@page import=" java.util.Date.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
</head> 
<body>

<%
Connection Con = null;
Statement Stmt=null;
ResultSet RS=null;
String memberID = request.getParameter("id");
String slot = request.getParameter("slot");
String date = request.getParameter("date");
String studentID = request.getSession().getAttribute("ID").toString();
////////////////////////////////////////
try

{
	String url = "jdbc:mysql://localhost:3306/office_hours_management";
	String user = "root";
	String password = "route";
	Con = DriverManager.getConnection(url, user, password);
	Stmt = Con.createStatement();
	RS = Stmt.executeQuery("SELECT * FROM office_hours WHERE MemberID = '" + memberID + "'");
	if (RS.next()) {
		RS = Stmt.executeQuery("SELECT * FROM appointment WHERE AppointmentSlot = '" + slot + "'");
		if(RS.next()){
			out.print("this slot is served before please enter another slot\n");
			response.sendRedirect("ReservationForm.html");
		}
		else{
			Stmt.executeUpdate("INSERT INTO appointment (AppointmentDate,AppointmentSlot,MemberID,StudentID)" + "VALUES('"
				+ date + "'," + "'" + slot + "'," + "'" + memberID + "'," + "'" + studentID + "')");
		out.print("Reservation Appointment is confirmed successfully\n");
		response.sendRedirect("MainHome.html");}
	}
	else{
		out.print("Reservation Appointment is wrong try again\n");
		response.sendRedirect("ReservationForm.html");
		
}


}catch (SQLException e) 
{
	System.out.println(e.getMessage());
	e.printStackTrace();
}

%>
</body>
</html>