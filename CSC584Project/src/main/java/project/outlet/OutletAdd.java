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
@WebServlet("/OutletA")
public class OutletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 	
				String id = (request.getParameter("id"));
				String name = (request.getParameter("name"));
				String details = (request.getParameter("details"));
				OutletBean Bean = new OutletBean(id,name,details);
				PrintWriter out = response.getWriter();  
				
				
				if(OutletDAO.add(Bean))
				{
				response.setContentType("text/html");  
				out.println("<html><body><center>"); 				
				out.println("<h2>Outlet Added</h2>");
				out.println("<input type='button' onclick='window.close();' value='OKAY'>"); 
				out.println("</center></body></html>");
				}
				else
				{
					response.setContentType("text/html");  
					out.println("<html><body><center>"); 				
					out.println("<h2>Adding Outlet failed</h2>");
					out.println("<input type='button' onclick='window.close();' value='OKAY'>"); 
					out.println("</center></body></html>");
				}

	}
}

