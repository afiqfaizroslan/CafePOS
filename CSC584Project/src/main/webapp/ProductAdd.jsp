<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="project.staff.StaffBean"%>
<%@page import="project.price.*"%>
<%@page import="java.util.ArrayList"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Update</title>
</head>
<body>
<% 
ArrayList<PriceBean> List = new ArrayList<>();
List = PriceDAO.getAll();
StaffBean Cur = (StaffBean) session.getAttribute("Current");
if (Cur!= null)
{
%>
<h2>Add</h2>
<p><em><small>*ID is not case-sensitive<br>*only put first 3 letter of product ID i.e (CFE,cfe,Cfe)</small></em></p>
	<form action="ProductA" method="post">
		<table style = "border:0;">
		<tr>
			<td>ID</td>
			<td>: <input type="text" id="id" name="id"  required></td>
		</tr>
		<tr>
			<td>Product name</td>
			<td>: <input type="text" id="name" name="name" required></td>
		</tr>
		<tr>
			<td>Details</td>
			<td>: <input type="text" id="details" name="details" required></td>
		</tr>
		<tr>
			<td>Stock</td>
			<td>: <input type="text" id="stock" name="stock" required></td>
		</tr>
		<tr>
			<td><label for="price">Price id</label></td>
			<td>:
			<select id="priceID" name= "priceID" required>
			 <%for (int i = 0; i < List.size(); i++) { %>
			  <option value="<%= List.get(i).getID()%>"><%= List.get(i).getID()%></option>
			  <% } %>
			</select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Add"></td>
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
	<body>
	<div>
		<h2>Please login first!</h2>
		<br><br>	
		<a href='Login.jsp'>Login</a>
	</div>
 	</body>
<%}%>
</html>