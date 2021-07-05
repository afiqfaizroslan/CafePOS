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
if (Cur!= null)
{
%>
<h2>Add Outlet</h2>
<p><em><small>*ID is not case-sensitive<br>*only put first 3 letter of product ID i.e (CFE,cfe,Cfe)</small></em></p>
	<form action="PriceA" method="post">
		<table style = "border:0;">
		<tr>
			<td>ID</td>
			<td>: <input type="text" id="id" name="id" required></td>
		</tr>
		<tr>
			<td>Value (RM)</td>
			<td>: <input type="text" id="value" name="value" required></td>
		</tr>
		<tr>
			<td>Discount</td>
			<td>: <input type="text" id="discount" name="discount" required></td>
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
	<body style="background: #EBCCB1">
	<div>
		<h2>Please login first!</h2>
		<br><br>	
		<a href='Login.jsp'>Login</a>
	</div>
 	</body>
<%}%>
</html>