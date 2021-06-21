package project.staff;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class StaffDelete
 */
@WebServlet("/StaffU")
public class StaffUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 	
				String name = (request.getParameter("name"));
				String phone = (request.getParameter("phone"));
				String outlet = (request.getParameter("outlet"));
				String password = (request.getParameter("password"));
				StaffBean staff = new StaffBean();
				PrintWriter out = response.getWriter();  
				
				HttpSession session = request.getSession(true); 
				staff = (StaffBean) session.getAttribute("Current");
				
				staff.setName(name);
				staff.setPhone(phone);
				staff.setOutlet_ID(outlet);
				staff.setPassword(password);
				
				if(StaffDAO.update(staff))
				{
					response.setContentType("text/html");  
					out.println("<html><body><center>"); 				
					out.println("<h2>Data Updated</h2>");
					out.println("<input type='button' onclick='window.close();' value='OKAY'>"); 
					out.println("</center></body></html>");
				}
				else
				{
					response.setContentType("text/html");  
					out.println("<html><body><center>"); 				
					out.println("<h2>Data update failed</h2>");
					out.println("<input type='button' onclick='window.close();' value='OKAY'>"); 
					out.println("</center></body></html>");
				}

	}
}

