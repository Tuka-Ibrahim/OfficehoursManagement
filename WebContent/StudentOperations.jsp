<%@page import="java.sql.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
				<form action="StudentOperations.jsp">
				<table cellspacing="5" border="0">
				<tr>
            	<td><input type="text" name="subjectname" id="subjectname"></td>
            	<td><input type=submit name="submit" value="View Subject staff team"></input></td>
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
			ArrayList <String> staffNames = new ArrayList<>();
			ArrayList <String> staffRole = new ArrayList<>();
			Con=DriverManager.getConnection(url,user,password);
			Stmt=Con.createStatement();
			String staffname=request.getParameter("staffname");
			session.setAttribute("staffname", staffname);
			String Subjectname=request.getParameter("subjectname");
			RS=Stmt.executeQuery("SELECT * FROM staff_member WHERE SubjectName='"+Subjectname+"'");
			while (RS.next()){
			/*staffNames.add(RS.getString("MemberUsername"));
			staffRole.add(RS.getString("MemberRole"));
			int subjectid=Integer.parseInt(RS.getString("SubjectID"));
			RS=Stmt.executeQuery("SELECT SubjectID FROM staff_member WHERE SubjectID='"+subjectid+"'");*/
			
			/*int id2=Integer.parseInt(RS.getString("Member_2_ID"));
			int id3=Integer.parseInt(RS.getString("Member_3_ID"));
			int id4=Integer.parseInt(RS.getString("Member_4_ID"));
			int id5=Integer.parseInt(RS.getString("Member_5_ID"));
			String[] Staff = new String[]{id1,id2,id3,id4,id5};
			RS=Stmt.executeQuery("SELECT * FROM staff_member WHERE MemberID='"+StaffID[i]+"'");
			while (RS.next()){
				*/
			%>
			<table cellspacing="5" border="0">
			<tr>
				<td><%out.println("Mmeber role:"+RS.getString("MemberRole")+"Member name:"+RS.getString("MemberUsername"));%></td>
				
				</tr>
			</table>
			<%	}
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

