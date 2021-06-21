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
@WebServlet("/ProductD")
public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 
					String Deleteid = (request.getParameter("Deleteid"));
					PrintWriter out = response.getWriter();  

					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Product Data Deleted');"); 
					out.println("window.location.href ='Product.jsp';");  
					out.println("</script>");
					ProductDAO.Delete(Deleteid);

	
		}
		

	}
