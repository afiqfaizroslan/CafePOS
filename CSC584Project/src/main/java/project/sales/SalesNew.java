package project.sales;


import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class StaffDelete
 */
@WebServlet("/SalesN")
public class SalesNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 	
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date = new Date();
				SalesBean Bean = new SalesBean();
				SalesBean Sales = new SalesBean();
				Bean.setDate(formatter.format(date));
				Bean.setStaff_ID(request.getParameter("staff"));
				PrintWriter out = response.getWriter();  
				
				
				if(SalesDAO.New(Bean))
				{
					Sales = SalesDAO.getLast();
					request.getSession().setAttribute("sales", Sales);
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('New Sales session created');"); 
					out.println("window.location.href ='Sales.jsp';");  
					out.println("</script>");
				}
				else
				{
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('New Sales session failed to be created');"); 
					out.println("window.location.href ='Sales.jsp';");  
					out.println("</script>");
				}

	}
}

