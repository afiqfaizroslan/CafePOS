package project.sales;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SalesAdd
 */
@WebServlet("/SalesA")
public class SalesAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
		public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
		{ 	
			SalesProductBean Bean = new SalesProductBean();		
			Bean.setSales_ID(request.getParameter("sales"));
			Bean.setProduct_ID(request.getParameter("product"));
			PrintWriter out = response.getWriter();  
					
					if(SalesDAO.Add(Bean))
					{
						response.setContentType("text/html");  
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Product Added');"); 
						out.println("window.location.href ='Sales.jsp';");  
						out.println("</script>");
					}
					else
					{
						response.setContentType("text/html");  
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('adding product fail');"); 
						out.println("window.location.href ='Sales.jsp';");  
						out.println("</script>");
					}

		}

}
