package project.product;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class StaffDelete
 */
@WebServlet("/ProductA")
public class ProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 	
				String id = (request.getParameter("id"));
				String name = (request.getParameter("name"));
				String details = (request.getParameter("details"));
				int stocks = Integer.parseInt(request.getParameter("stock"));
				String priceID = (request.getParameter("priceID"));
				ProductBean Bean = new ProductBean(id,name,details,stocks,priceID);
				PrintWriter out = response.getWriter();  
				
				
				if(ProductDAO.add(Bean))
				{
				response.setContentType("text/html");  
				out.println("<html><body><center>"); 				
				out.println("<h2>Added</h2>");
				out.println("<input type='button' onclick='window.close();' value='OKAY'>"); 
				out.println("</center></body></html>");
				}
				else
				{
					response.setContentType("text/html");  
					out.println("<html><body><center>"); 				
					out.println("<h2>Adding Product failed</h2>");
					out.println("<input type='button' onclick='window.close();' value='OKAY'>"); 
					out.println("</center></body></html>");
				}

	}
}

