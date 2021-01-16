<%@page import="java.sql.*"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
</head>  
<body>
		<div class="body">
		<ul>
		 <li><a href="#Contact">Contact</a></li>
		 <li><a href="#Support">Support</a></li>
		 <li><a href="#Why US"> Why us </a></li>
		 <li><a id="about" href="about" onclick="load()">about us</a></li>
		 <li><a href="AdminMessages.jsp">Messages</a></li>
		 <li><a href="AdminInbox.html">Inbox</a></li>
		 <li><a href="UpdateProfileForm.html">Profile</a></li>
		 <li><a href="#Home">Home</a></li>
		 <li style="float:left; padding: 10px 10px 10px 50px;"><a style="font-size:30px;" href="#OnlineLearning">OfficeHourManagement.com</a></li>
		</ul>
		</div>
			<h1 style="color:white; font-family:'Times new roman'; ;float:center;">Welcome to our Office Hour Management web site where you can manage your time</h1>
			<h2 style="color:white; font-family:'Times new roman'; ;float:center;">Where you can make progress</h2>
			  <form action="AdminMain.jsp" method="get">
			  <table cellspacing="5" border="0">
			  <tr>
				<td>Welcome Admin! Please before we proceed Enter your enroll subject:</td>
				<td><input type="text" name="subjectname"></td>
				<tr>
				<td><br><input type="submit" value="enroll"></td>
				</tr>
				<tr>
				<td><a href="studentSearch.jsp">Search for a student</a></td>
				</tr>
				<tr>			
				<td><a href="">View and reply to students’ messages</a></td>
				</tr>
				<tr>
				<td><a href="">Message subject team (other Doctors And Teacher assistants Of the subject)</a></td>
				</tr>
				<tr>
				<td><a href="viewReservationForm.html">View reservation on a specific office hours slot</a></td>
				</tr>
				</table>
				</form>	
				<script>
function load() {
	 var goto = new XMLHttpRequest();
	 goto.onreadystatechange = function() {
	 if (this.readyState == 4 && this.status == 200) {
	 document.getElementById("about").innerHTML = this.responseText;
	 	}
	 };
	 goto.open("GET", "about.jsp", true);
	 goto.send();
	}
</script>	
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
	String subject = request.getParameter("subjectname");
	String studentEName= request.getParameter("studentname");
	session.setAttribute("studentname", studentEName);
	String staffmail=request.getSession().getAttribute("Username").toString();
	Stmt.executeUpdate("Update staff_member SET SubjectName='"+subject+"'"+"WHERE MemberEmail='"+staffmail+"'");
}catch(Exception e){
	System.out.print("Exception is"+e);
}
%>
</body>
</html>
