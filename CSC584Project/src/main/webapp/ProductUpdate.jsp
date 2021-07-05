<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="project.staff.StaffBean"%>
<%@page import="project.product.*"%>
<%@page import="project.price.*"%>
<%@page import="java.util.ArrayList"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Update</title>
</head>
<body style="background: #EBCCB1">
<% 
StaffBean Cur = (StaffBean) session.getAttribute("Current");
ArrayList<PriceBean> List = new ArrayList<>();
String id =request.getParameter("id");

if (Cur!= null)
{
	ProductBean Product = ProductDAO.Find(id);
	String ID = Product.getPrice_ID();
	List = PriceDAO.getAll();
%>
<h2>Update</h2>
<h4>Id:<%=id%></h4>
	<form action="ProductU" method="post">
	<input  id="id" name="id" value="<%=id%>">
		<table style = "border:0;">
		
		<tr>
			<td>Product name</td>
			<td>: <input type="text" id="name" name="name" value="<%=Product.getName()%>" required></td>
		</tr>
		<tr>
			<td>Details</td>
			<td>: <input type="text" id="details" name="details" value="<%=Product.getDetails()%>" required> </td>
		</tr>
		<tr>
			<td>Stocks</td>
			<td>: <input type="text" id="stock" name="stock" value="<%=Product.getStock()%>" required> </td>
		</tr>
		<tr>
			<td><label for="price">Price id</label></td>
			<td>:
			<select id="priceID" name= "priceID" required>
			 <%for (int i = 0; i < List.size(); i++) { %>
			  <option value="<%= List.get(i).getID()%>"><%= List.get(i).getID()%></option>
			  <% } %>
			  <option value="<%= ID%>" selected  hidden><%= ID%></option>
			</select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Update"></td>
			<td></td>
		</tr>
		</table>	
	</form>
</body>
<% 
}
else
{
%>
	<body style="background: #EBCCB1">
	<div>
		<h2>Please login first!</h2>
		<br><br>	
		<a href='Login.jsp'>Login</a>
	</div>
 	</body>
<%}%>
</html>