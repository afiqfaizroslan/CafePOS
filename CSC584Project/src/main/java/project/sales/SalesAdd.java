package project.sales;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.product.ProductBean;
import project.product.ProductDAO;

/**
 * Servlet implementation class SalesAdd
 */
@WebServlet("/SalesA")
public class SalesAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
		public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
		{ 	
			SalesProductBean Bean = new SalesProductBean();		
			ProductBean ProBean = new ProductBean();
			Bean.setSales_ID(request.getParameter("sales"));
			Bean.setProduct_ID(request.getParameter("product"));
			PrintWriter out = response.getWriter();  
			ProBean = ProductDAO.Find(Bean.getProduct_ID());
			if(ProBean.getStock() == 0)
			{
				response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Product Not Available');"); 
				out.println("window.location.href ='Sales.jsp';");  
				out.println("</script>");
			}
			else
			{
					
					if(SalesDAO.Add(Bean))
					{
						if(ProductDAO.updateStock(ProBean.getStock()-1, ProBean.getID()))
						{
							response.setContentType("text/html");  
							out.println("<script type=\"text/javascript\">");  
							out.println("alert('Product Added');"); 
							out.println("window.location.href ='Sales.jsp';");  
							out.println("</script>");
						}
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

}
