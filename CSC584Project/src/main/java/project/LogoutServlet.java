package project;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/logoutS") 
public class LogoutServlet extends HttpServlet 
{  private static final long serialVersionUID = 1L;


		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
              
            request.getRequestDispatcher("Login.jsp").include(request, response);  
              
            HttpSession session=request.getSession();  
            session.invalidate();  
              
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Succesfully logout');"); 
			out.println("window.location.href ='Login.jsp';");  
			out.println("</script>");
              
            out.close();  
		}  
}  