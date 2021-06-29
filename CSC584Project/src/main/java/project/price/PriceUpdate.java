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
@WebServlet("/PriceU")
public class PriceUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 	
				String id = (request.getParameter("id"));
				Double value = Double.parseDouble(request.getParameter("value"));
				Double discount = Double.parseDouble(request.getParameter("discount"));
				PriceBean Bean = new PriceBean(id,value,discount);
				PrintWriter out = response.getWriter();  
						

				if(PriceDAO.update(Bean))
				{
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Price Updated');"); 
					out.println("window.location.href ='Price.jsp';");  
					out.println("</script>");
				}
				else
				{
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Update Failed');"); 
					out.println("window.location.href ='Price.jsp';");  
					out.println("</script>");
				}

	}
}