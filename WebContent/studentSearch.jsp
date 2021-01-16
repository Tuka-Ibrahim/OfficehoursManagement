<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="studentSearch.jsp" method="get">
			  <table cellspacing="5" border="0">
			  <tr>
				<td>Enter name:</td>
				<td><input type="text" name="studentname"></td>
				</tr>
				</table>
				</form>
<%
String url = "jdbc:mysql://localhost:3306/office_hours_management";
String user = "root";
String password = "route";
Connection Con = null;
Statement Stmt = null;
ResultSet RS = null;
try{
	Con = DriverManager.getConnection(url, user, password);
	Stmt = Con.createStatement();
	String studentname=request.getParameter("studentname");
	//String studentname=request.getSession().getAttribute("studentname").toString();
	RS = Stmt.executeQuery("SELECT * FROM student WHERE StudentEmail='" + studentname + "'");
	if (RS.next()){%>
	<table cellspacing="5" border="0">
			<tr>
				<td><%out.println("Student ID:"+RS.getString("StudentID")+"Student First name:"+RS.getString("StudentFName"));%></td>
				<td><%out.println("Student Last name :"+RS.getString("StudentID")+"Student Fname:"+RS.getString("StudentLName"));%></td>
				<td><%out.println("Student email :"+RS.getString("StudentEmail"));%></td>
				</tr>
			</table>
<%}
}catch(Exception e){
	System.out.print("Exception is"+e);
}
%>

</body>
</html>