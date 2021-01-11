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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = "jdbc:mysql://localhost:3306/hotelBooking";
        String user = "root";
        String password = "route";
        Connection Con = null;
        Statement Stmt=null;
        ResultSet RS=null;
        try {
        	PrintWriter out = response.getWriter();
			Con=DriverManager.getConnection(url,user,password);
			Stmt=Con.createStatement();
			String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String mail  = request.getParameter("email"); 
            String creationDate = java.time.LocalDate.now().toString();
            String typeUsers = request.getParameter("typeUsers");
            RS=Stmt.executeQuery("SELECT * FROM Clients WHERE Clientmail='"+mail+"'");
			if (RS.next()==true) {
				out.print("User already exists");
			}
			/*String fname = request.getSession().getAttribute("fname").toString();
            String lname = request.getSession().getAttribute("lname").toString();
            String mail =  request.getSession().getAttribute("email").toString();*/
			else {
			Stmt.executeUpdate("INSERT INTO Clients (Clientfname,Clientlname,Clientmail,ClientCreationDate) "+"VALUES('"+fname+"',"+"'"+lname+"',"+"'"+mail+"',"+"'"+creationDate+"')");	
			response.sendRedirect("Home.html");
			Con.close();
			Stmt.close();
			}
        }
        catch (Exception e) {
			System.out.println("Excepetion is : "+e);
		}
        
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}