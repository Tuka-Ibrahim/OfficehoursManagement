import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class validate
 */
@WebServlet("/validate")
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public validate() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/office_hours_management";
		String user = "root";
		String password = "route";
		Connection Con = null;
		Statement Stmt = null;
		ResultSet RS = null;
		try  {
			Con = DriverManager.getConnection(url, user, password);
			Stmt = Con.createStatement();
			String fname = request.getParameter("firstname");
			String lname = request.getParameter("lastname");
			String email = request.getParameter("mail");
			String creationDate = java.time.LocalDate.now().toString();
			String username=fname+lname;
			String typeUsers = request.getParameter("typeofusers");
			RS = Stmt.executeQuery("SELECT * FROM student WHERE StudentEmail='" + email + "'");
			if (RS.next() == true) {
				response.getWriter().write("User already exists");
			} else {
			RS = Stmt.executeQuery("SELECT * FROM staff_member WHERE MemberEmail='" + email + "'");
			if (RS.next() == true) {
			//out.println("User already exists");
			response.getWriter().write("User already exists");
			} else if (typeUsers.equals("Student")) {
				Stmt.executeUpdate("INSERT INTO student (StudentFName,StudentLName,StudentEmail,StudentUsername) "
						+ "VALUES('" + fname + "'," + "'" + lname + "'," + "'" + email + "'," + "'" +username+"')");
				
			} else {
				Stmt.executeUpdate("INSERT INTO staff_member (MemberRole,MemberfName,MemberlName,MemberEmail,MemberUsername) "	
					+ "VALUES('" +typeUsers+"',"+ "'"+ fname + "'," + "'" + lname + "'," + "'" + email + "',"+"'"+username+"')");
				/*Stmt.executeUpdate("INSERT INTO subject_staff (MemberID) "+ "VALUES ('"+username+"')");

					for (int i=1; i<6; i++) {
						//int subjectID=Integer.parseInt(RS.getString("SubjetID"));
						//subjectID=1;
						Stmt.executeUpdate("INSERT INTO staff_member (MemberID) "+ "VALUES ('"+i+"')");
					}
					subjectID++;
					*/
			}
		}
		Con.close();
		Stmt.close();
	} catch (Exception e) {
		System.out.println("Excepetion is : " + e);
	}

}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);

}
}