package project.outlet;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class StaffDelete
 */
@WebServlet("/OutletD")
public class OutletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 
				String Currentid = (request.getParameter("Currentid"));
				String Deleteid = (request.getParameter("Deleteid"));
				PrintWriter out = response.getWriter();  
				
				if(Currentid.equals(Deleteid))
				{
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Cannot delete your current Outlet');"); 
					out.println("window.location.href ='Outlet.jsp';");  
					out.println("</script>");
				}
				else
				{
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Outlet Data Deleted');"); 
					out.println("window.location.href ='Outlet.jsp';");  
					out.println("</script>");
					OutletDAO.Delete(Deleteid);
					
					
				}
	
		}
		

	}

