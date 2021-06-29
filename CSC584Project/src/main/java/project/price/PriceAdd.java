package project.price;

import java.io.PrintWriter;
import java.util.ArrayList;

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
				ArrayList<PriceBean> list = PriceDAO.getAll();
				int index = 0;
				for(int i=0;i<list.size();i++)
				{
					if(list.get(i).getID().substring(0, 3).equalsIgnoreCase(id))
					{
					   index++;
					   if(index!=Integer.parseInt(list.get(i).getID().substring(3, 6)))
					   {
						   index--;
						   break;   
					   }
					}
				}
				
				String newID = id.toUpperCase()+String.format("%03d", index+1);		
				
				Double value = Double.parseDouble(request.getParameter("value"));
				Double discount = Double.parseDouble(request.getParameter("discount"));
				PriceBean Bean = new PriceBean(newID,value,discount);
				PrintWriter out = response.getWriter();  
				
				
				if(PriceDAO.add(Bean))
				{
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Price Added');"); 
					out.println("window.location.href ='Price.jsp';");  
					out.println("</script>");
				
				}
				else
				{
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Price failed to add');"); 
					out.println("window.location.href ='Price.jsp';");  
					out.println("</script>");
				}

	}
}

