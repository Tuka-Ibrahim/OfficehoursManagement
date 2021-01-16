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
<%
		String url = "jdbc:mysql://localhost:3306/office_hours_management";
		String user = "root";
		String password = "route";
		Connection Con = null;
		Statement Stmt=null;
		ResultSet RS=null;
		int affected=0;
		try {
			Con=DriverManager.getConnection(url,user,password);
			Stmt=Con.createStatement();
			String staffID = request.getSession().getAttribute("staffID").toString();
			RS=Stmt.executeQuery("SELECT MemberEmail FROM staff_member WHERE MemberID='"+staffID+"'");
			String emailReciver=RS.getString("MemberEmail");
			RS=Stmt.executeQuery("SELECT * FROM messages WHERE messageReciveremail='"+emailReciver+"'");
			String MessageID=RS.getString("messageID");
			while (RS.next()){
			String senderEmail=RS.getString("messageSenderemail");
			String content=RS.getString("messageContent");
			String date=RS.getString("senddate");
			%>
			<table cellspacing="5" border="0">
			<tr>
				<td><%out.println("Sender email::"+senderEmail);%></td>
				<td><%out.println("Message is: "+content);%></td>
				<td><%out.println("Send date:"+date);%></td>
				<td><a href="Home.jsp"><button>Go Home</button></a></td>
				</tr>
			</table>
			<form action="AdminInbox.jsp">
            <label>Reply</label> 
            <input type="text" name="reply">
           	<input type="submit" name="Send" value="Send">
</form>
<%
String reply=request.getParameter("reply");
Stmt.executeUpdate("Update messages SET reply='"+reply+"'"+"WHERE MessageID='"+MessageID+"'");
%>
			<%
			}
		RS.close();
		Con.close();
		Stmt.close();
		}
		catch (Exception e)
			{
			System.out.println("Excepetion is : "+e);
			} 
			%>
</body>
</html>
