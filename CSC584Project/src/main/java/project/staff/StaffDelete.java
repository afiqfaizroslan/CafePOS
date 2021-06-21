package project.staff;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class StaffDelete
 */
@WebServlet("/StaffD")
public class StaffDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 
				String IDDelete = (request.getParameter("IDDelete"));
				String IDSesion = (request.getParameter("IDSession"));
				PrintWriter out = response.getWriter();  
				
				if(IDDelete.equals(IDSesion))
				{
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Cannot delete your self');"); 
					out.println("window.location.href ='Staff.jsp';");  
					out.println("</script>");
				}
				else
				{
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Staff Data Deleted');"); 
					out.println("window.location.href ='Staff.jsp';");  
					out.println("</script>");
					StaffDAO.Delete(IDDelete);
					
					
				}
	
		}
		

	}

