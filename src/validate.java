import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String url = "jdbc:mysql://localhost:3306/hotelBooking";
		String user = "root";
		String password = "route";
		Connection Con = null;
		Statement Stmt = null;
		ResultSet RS = null;
		String msg= new String();
		try  {
			Con = DriverManager.getConnection(url, user, password);
			Stmt = Con.createStatement();
			String fname = request.getParameter("firstname");
			String lname = request.getParameter("lastname");
			String text = request.getParameter("mail");
			String creationDate = java.time.LocalDate.now().toString();
			String typeUsers = request.getParameter("typeofusers");
			RS = Stmt.executeQuery("SELECT * FROM Clients WHERE Clientmail='" + text + "'");
			if (RS.next() == true) {
				} else {
				RS = Stmt.executeQuery("SELECT * FROM Admins WHERE Adminmail='" + text + "'");
				if (RS.next() == true) {
				response.getWriter().write("User already exists");
				} else if (typeUsers.equals("Client")) {
					Stmt.executeUpdate("INSERT INTO Clients (Clientfname,Clientlname,Clientmail,ClientCreationDate) "
							+ "VALUES('" + fname + "'," + "'" + lname + "'," + "'" + text + "'," + "'" + creationDate
							+ "')");
				} else {
					Stmt.executeUpdate("INSERT INTO Admins (Adminfname,Adminlname,Adminmail,AdminCreationDate) "
							+ "VALUES('" + fname + "'," + "'" + lname + "'," + "'" + text + "'," + "'" + creationDate
							+ "')");
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