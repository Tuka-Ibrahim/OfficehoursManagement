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
				<form action="staffContact.jsp">
				<table>
				<tr>
           		<td><input type="text" name="staffname" id="staffname"></td>
           		<td><input type=submit name="submit" value="View staff member contact "></input></td>
				</tr>
				</table>
				</form>
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
            
</body>
</html>