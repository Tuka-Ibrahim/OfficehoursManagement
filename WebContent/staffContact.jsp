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
<form action="staffContact.jsp">
				<table>
				<tr>
           		<td><input type="text" name="staffname" id="staffname"></td>
           		<td><input type=submit name="submit" value="View staff member contact "></input></td>
				</tr>
				</table>
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
			String staffName=request.getParameter("staffname");
			RS=Stmt.executeQuery("SELECT MemberEmail FROM staff_member WHERE MemberUsername='"+staffName+"'");
			while (RS.next()){
			%>
			<table cellspacing="5" border="0">
			<tr>
				<td><%out.println("Member email is :"+RS.getString("MemberEmail"));%></td>
					</tr>
			</table>
			<% }
     }catch (Exception e) {
			System.out.println("Excepetion is : "+e);
		}
RS.close();
Stmt.close();
Con.close();	
%>
</body>
</html>