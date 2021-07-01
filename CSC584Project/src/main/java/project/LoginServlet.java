package project;
import project.sales.SalesBean;
import project.staff.*;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/logins")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 
		try 
		{ 
				StaffBean Staff = new StaffBean();
				SalesBean Sales = new SalesBean();
				Staff.setID(request.getParameter("ID"));
				Staff.setPassword(request.getParameter("Password"));
				Staff = StaffDAO.login(Staff);
	
				if (Staff.isValid()) 
				{ // logged-in page
					HttpSession session = request.getSession(true); 
					session.setAttribute("Current",Staff);
					session.setAttribute("sales", Sales);
	
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				} 
				else 
					{
						PrintWriter out = response.getWriter();  
						response.setContentType("text/html");  
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Invalid Staff');"); 
						out.println("window.location.href ='Login.jsp';");  
						out.println("</script>");
					
					}
		}
		
		catch(Throwable theException)
		{
			System.out.println(theException);
		}
	}
}
