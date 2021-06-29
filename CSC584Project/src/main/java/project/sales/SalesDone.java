package project.sales;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SalesDone
 */
@WebServlet("/SalesD")
public class SalesDone extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 
					int Salesid = Integer.parseInt(request.getParameter("sales"));
					PrintWriter out = response.getWriter();  
					SalesBean sale = new SalesBean();
					sale = SalesDAO.Find(Salesid);
					sale.setSales_Total(SalesDAO.getTotalPrice(sale.getID()));
					if(SalesDAO.updateTotal(sale))
					{
						
						response.setContentType("text/html");  
						out.println("<script type=\"text/javascript\">");  
						out.println("window.open('Receipt.jsp?id="+sale.getID()+"','Update','width=400,height=700');"); 
						out.println("window.location.replace('Sales.jsp');"); 
						out.println("</script>");

					}
					

					

	
		}
   

}
