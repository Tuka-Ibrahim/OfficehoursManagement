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
 * Servlet implementation class Validate_UpdateProfile
 */
@WebServlet("/Validate_UpdateProfile")
public class Validate_UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate_UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/office_hours_management";
			String user = "root";
			String password = "route";
			Connection Con = null;
			Statement Stmt = null;
			ResultSet RS = null;
			Con = DriverManager.getConnection(url, user, password);
			Stmt = Con.createStatement();
			String name = request.getParameter("name");
			String current_pass = request.getParameter("cur_pass");
			String new_pass = request.getParameter("new_pass");
			String confirm_pass = request.getParameter("confirm_pass");
			RS = Stmt.executeQuery("SELECT * FROM student WHERE Studentpwd = '" +current_pass+"'");
			
			if(RS.next()) {
				if(new_pass.equals(confirm_pass)) {
					String id = (RS.getString("StudentID"));
					Stmt.executeUpdate("UPDATE student SET StudentFName ='"+name+"' where StudentID='" + id +"'");
					Stmt.executeUpdate("UPDATE student SET Studentpwd ='"+current_pass+"' where StudentID='" + id +"'");
					System.out.println("successful Update ");
					response.sendRedirect("MainHome.html");
					
				}
				else {
					System.out.println("Your confirm password is wrong >>>>>> try again");
					response.sendRedirect("UpdateProfileForm.html");
				}
			}
			
		}catch (Exception ex) {
			response.getWriter().print(ex);
		}
		/*try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hotelBooking";
			String user = "root";
			String password = "root";
			Connection Con = null;
			Statement Stmt = null;
			ResultSet RS = null;
			Con = DriverManager.getConnection(url, user, password);
			Stmt = Con.createStatement();
			String name = request.getParameter("name");
			String current_pass = request.getParameter("cur_pass");
			String new_pass = request.getParameter("new_pass");
			String confirm_pass = request.getParameter("confirm_pass");
			RS = Stmt.executeQuery("SELECT * FROM Clients WHERE Clientpwd = '" + current_pass);
			if(RS.next()) {
				if(new_pass==confirm_pass) {
					String id = (RS.getString("ClientID"));
					Stmt.executeUpdate("UPDATE Clients SET Clientfname ='"+name+"' where ClientID='" + id +"'");
					Stmt.executeUpdate("UPDATE Clients SET Clientpwd ='"+current_pass+"' where ClientID='" + id +"'");
					System.out.println("successful Update ");
					response.sendRedirect("MainHome.html");
					
				}
				else {
					System.out.println("Your confirm password is wrong >>>>>> try again");
					response.sendRedirect("UpdateProfileForm.html");
				}
			}
			
		}catch (Exception ex) {
			response.getWriter().print(ex);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

