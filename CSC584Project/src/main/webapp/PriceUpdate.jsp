<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="project.staff.StaffBean"%>
<%@page import="project.price.*"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Update</title>
</head>
<body style="background: #EBCCB1">
<% 
StaffBean Cur = (StaffBean) session.getAttribute("Current");
String id =request.getParameter("id");
PriceBean Price = PriceDAO.Find(id);
if (Cur!= null)
{
%>
<h2>Update Outlet</h2>
<h4>Id:<%=id%></h4>
	<form action="PriceU" method="post">
	<input type="hidden" id="id" name="id" value="<%=id%>">
		<table style = "border:0;">
		
		<tr>
			<td>Value (RM)</td>
			<td>: <input type="text" id="value" name="value" value="<%=Price.getValue()%>" required></td>
		</tr>
		<tr>
			<td>Discount</td>
			<td>: <input type="text" id="discount" name="discount" value="<%=Price.getDiscount()%>" required> </td>
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