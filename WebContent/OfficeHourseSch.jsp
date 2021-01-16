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
<form action="OfficeHoursSch.jsp">
				<table>
				<tr>
           		<td><input type="text" name="staffname" id="staffname"></td>
           		<td><input type=submit name="submit" value="View staff member contact "></input></td>
				</tr>
				<tr>
				<td><a href="http://localhost:9090/IS3_20180073_20180311_20180240/OfficeHourseSch.jsp"><button>View the office hours schedule for the staff member</button></a></td>
				</tr>
				<tr>
				<td><a href="Home.jsp"><button>Go Home</button></a></td>
				</tr>
				</table>
            </form>
<% 
String url = "jdbc:mysql://localhost:3306/bank_system";
String user = "root";
String password = "route";
Connection Con = null;
Statement Stmt=null;
ResultSet RS=null;
	 try {
			Con=DriverManager.getConnection(url,user,password);
			Stmt=Con.createStatement();
			String staffName=request.getParameter("staffName");
			RS=Stmt.executeQuery("SELECT * FROM staff_member WHERE MemberUsername='"+staffName+"'");
			String memberID=RS.getString("MemberID");
			RS=Stmt.executeQuery("SELECT * FROM office_hours WHERE MemberID='"+memberID+"'");
			ArrayList <Integer> offhrs=new ArrayList<>();
			ArrayList <String> avaliableDays = new ArrayList<>();
			ArrayList <String> avaliableTimes=new ArrayList <>();
			Integer officeIDs=Integer.parseInt(RS.getString("OfficeHourID"));
			while (RS.next()){
			offhrs.add(officeIDs);
				for (int i=0; i<offhrs.size(); i++){
				avaliableDays.add(RS.getString("AvailableDay"));
				avaliableTimes.add(RS.getString("AvailableTime"));
			%>
			<table cellspacing="5" border="0">
			<tr>
				<td><%out.println("Avaliable Days is :"+avaliableDays);%></td>
				<td><%out.println("Avaliable Times is :"+avaliableTimes);%></td>
					</tr>
			</table>
			<% 
			}
				}
			RS.close();
			Stmt.close();
			Con.close();	
     }
	 catch (Exception e) {
			System.out.println("Excepetion is : "+e);
		}

%>
</body>
</html>