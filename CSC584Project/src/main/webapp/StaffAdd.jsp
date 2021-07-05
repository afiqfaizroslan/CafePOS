<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="project.staff.*"%>
<%@page import="project.outlet.*"%>
<%@page import="java.util.ArrayList"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Update</title>
</head>
<body style="background: #EBCCB1">
<% 
StaffBean Cur = (StaffBean) session.getAttribute("Current");
ArrayList<OutletBean> List = new ArrayList<>();
List = OutletDAO.getAll();
if (Cur!= null)
{
%>
<h2>Add Staff</h2>
	<form action="StaffA" method="post">
		<table style = "border:0;">
		<tr>
			<td>ID</td>
			<td>: <input type="text" id="id" name="id" required></td>
		</tr>
		<tr>
			<td>Name</td>
			<td>: <input type="text" id="name" name="name" required></td>
		</tr>
		<tr>
			<td>Phone</td>
			<td>: <input type="text" id="phone" name="phone" required></td>
		</tr>
		<tr>
		<td><label for="outlet">Outlet</label></td>
			<td>:
			<select id="outlet" name= "outlet" required>
			 <%for (int i = 0; i < List.size(); i++) { %>
			  <option value="<%= List.get(i).getID()%>"><%= List.get(i).getID()%></option>
			  <% } %>
			  <option value="<%=Cur.getOutlet_ID()%>" selected  hidden><%=Cur.getOutlet_ID()%></option>
			</select>
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>: <input type="text" id="password" name="password"required></td>
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