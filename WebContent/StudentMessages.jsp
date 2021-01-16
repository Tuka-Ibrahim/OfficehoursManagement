<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
</head>
<body>
<form action="StudentMessages.jsp">
			<label>Staff Member Username</label> 
            <input type="text" name="name"> 
            <br/></br> 
            <label>Enter Message content :</label> 
            <input type="text" name="body">
           	<input type="submit" name="Send" value="Send">
</form>
<%
String url = "jdbc:mysql://localhost:3306/office_hours_management";
String user = "root";
String password = "route";
Connection Con = null;
Statement Stmt=null;
ResultSet RS=null;
try {
	Con=DriverManager.getConnection(url,user,password);
	Stmt=Con.createStatement();
	String creationDate = java.time.LocalDate.now().toString();
	String staffname=request.getParameter("name");
	String content=request.getParameter("body");
	String studentID = request.getSession().getAttribute("ID").toString();
	RS=Stmt.executeQuery("SELECT StudentEmail FROM student WHERE StudentID='"+studentID+"'");
	if(RS.next()){
	String emailSender=RS.getString("StudentEmail");
	RS=Stmt.executeQuery("SELECT MemberEmail FROM staff_member WHERE MemberUsername='"+staffname+"'");
	if (RS.next()){
	String emailReciver=RS.getString("MemberEmail");
	Stmt.executeUpdate("INSERT INTO messages (messageSenderemail,messageReciveremail,messageContent,senddate)" +"VALUES('" +emailSender+"',"+ "'"+ emailReciver + "'," + "'" + content + "'," + "'" + creationDate+"')"); 
		}
	}
RS.close();
Stmt.close();
Con.close();
}	
catch (Exception e)
	{
	System.out.println("Excepetion is : "+e);
	} 

%>
</body>
</html>