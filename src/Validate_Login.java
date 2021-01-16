
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validate_Login
 */
@WebServlet("/Validate_Login")
public class Validate_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = "jdbc:mysql://localhost:3306/office_hours_management";
        String user = "root";
        String password = "route";
        Connection Con = null;
        Statement Stmt=null;
        ResultSet RS=null;
        try {
        	Con = DriverManager.getConnection(url, user, password);
			Stmt = Con.createStatement();
			String username= request.getParameter("Username");
			String pass = request.getParameter("password");
			RS = Stmt.executeQuery("SELECT * FROM student WHERE StudentEmail = '" + username + "' AND Studentpwd ='" + pass + "'" );
			if (RS.next()==true) {
				HttpSession session = request.getSession(true);
				session.setAttribute("StudentEmail",username);
				session.setAttribute("StudentPassword",pass);
				session.setAttribute("ID", RS.getString("StudentID"));
				response.sendRedirect("MainHome.html"); // logged-in page
			}
			else
			{
				RS = Stmt.executeQuery("SELECT * FROM staff_member WHERE MemberEmail = '" + username + "' AND Mmberpwd ='" + pass + "'" );
				if (RS.next()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("Username", username);
				session.setAttribute("staffID", RS.getString("MemberID"));
				response.sendRedirect("AdminMain.jsp"); 
				//session.setAttribute("StudentEmail",username);
				session.setAttribute("AdminPassword",pass);
				// logged-in page
			}
			    }
			/*else {
				System.out.println("your data is invalid");
				response.sendRedirect("Home.jsp"); // error page
			}*/
			RS.close();
			Stmt.close();
			Con.close();
        }catch (Exception ex) {
			response.getWriter().print(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
