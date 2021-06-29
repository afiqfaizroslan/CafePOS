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
 * Servlet implementation class StaffDelete
 */
@WebServlet("/ProSaleD")
public class ProductSalesDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	{ 
					String Deleteid = (request.getParameter("Deleteid"));
					String Productid = (request.getParameter("Productid"));
					PrintWriter out = response.getWriter();  
					ProductBean ProBean = new ProductBean();
					ProBean = ProductDAO.Find(Productid);
					if(ProductDAO.updateStock(ProBean.getStock()+1, ProBean.getID()))
					{

						response.setContentType("text/html");  
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Product Deleted');"); 
						out.println("window.location.href ='Sales.jsp';");  
						out.println("</script>");
						SalesDAO.DeleteProduct(Deleteid);
					}

	
		}
		

	}
