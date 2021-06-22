<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="project.staff.StaffBean"%>
<%@page import="project.outlet.*"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Update</title>
</head>
<body>
<% 
StaffBean Cur = (StaffBean) session.getAttribute("Current");
if (Cur!= null)
{
	OutletBean Outlet = OutletDAO.Find(Cur.getOutlet_ID());	
%>
<h2>Update Outlet</h2>
<h4>Id:<%=Cur.getOutlet_ID()%></h4>
	<form action="OutletU" method="post">
	<input type="hidden" id="id" name="id" value="<%=Cur.getOutlet_ID()%>">
		<table style = "border:0;">
		
		<tr>
			<td>Oulet name</td>
			<td>: <input type="text" id="name" name="name" value="<%=Outlet.getName()%>" required></td>
		</tr>
		<tr>
			<td>Details</td>
			<td>: <input type="text" id="details" name="details" value="<%=Outlet.getDetails()%>" required> </td>
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
	<body>
	<div>
		<h2>Please login first!</h2>
		<br><br>	
		<a href='Login.jsp'>Login</a>
	</div>
 	</body>
<%}%>
</html>