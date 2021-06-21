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
@WebServlet("/StaffA")
public class StaffAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 	
				String id = (request.getParameter("id"));
				String name = (request.getParameter("name"));
				String phone = (request.getParameter("phone"));
				String outlet = (request.getParameter("outlet"));
				String password = (request.getParameter("password"));
				StaffBean staff = new StaffBean();
				PrintWriter out = response.getWriter();  
				
				staff.setID(id);
				staff.setName(name);
				staff.setPhone(phone);
				staff.setOutlet_ID(outlet);
				staff.setPassword(password);
				
				if(StaffDAO.add(staff))
				{
				response.setContentType("text/html");  
				out.println("<html><body><center>"); 				
				out.println("<h2>Staff Added</h2>");
				out.println("<input type='button' onclick='window.close();' value='OKAY'>"); 
				out.println("</center></body></html>");
				}
				else
				{
					response.setContentType("text/html");  
					out.println("<html><body><center>"); 				
					out.println("<h2>Adding Staff failed</h2>");
					out.println("<input type='button' onclick='window.close();' value='OKAY'>"); 
					out.println("</center></body></html>");
				}

	}
}

