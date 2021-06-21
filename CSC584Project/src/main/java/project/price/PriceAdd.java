package project.price;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class StaffDelete
 */
@WebServlet("/PriceA")
public class PriceAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 	
				String id = (request.getParameter("id"));
				Double value = Double.parseDouble(request.getParameter("value"));
				Double discount = Double.parseDouble(request.getParameter("discount"));
				PriceBean Bean = new PriceBean(id,value,discount);
				PrintWriter out = response.getWriter();  
				
				
				if(PriceDAO.add(Bean))
				{
				response.setContentType("text/html");  
				out.println("<html><body><center>"); 				
				out.println("<h2>Price Added</h2>");
				out.println("<input type='button' onclick='window.close();' value='OKAY'>"); 
				out.println("</center></body></html>");
				}
				else
				{
					response.setContentType("text/html");  
					out.println("<html><body><center>"); 				
					out.println("<h2>Adding Price failed</h2>");
					out.println("<input type='button' onclick='window.close();' value='OKAY'>"); 
					out.println("</center></body></html>");
				}

	}
}

