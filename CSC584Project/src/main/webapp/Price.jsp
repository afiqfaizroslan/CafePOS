<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.staff.StaffBean"%>
<%@page import="project.price.*"%>



<html>
	<head>
	
		<meta http-equiv="Content-Type"content="text/html; charset=windows-1256">
		<style>
		.btn
		{
		  background-color: #8C9291;
		  border: none;
		  color: white;
		  padding: 10px 24px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 10px;
		  margin: 4px 2px;
		  cursor: pointer;
		}
		.btn:link, .btn:visited
		{
		  background-color: #8C9291;
		  color: white;
		  padding: 10px 15px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		}
		.btn:hover, .btn:active
		{
		  background-color: #7A7E7D;
		}
		.onpage
		{
		background-color: #7A7E7D;
		}
		.content 
		{
			padding:20px;
			margin-top:40px;
			background-color:#FFFFFF;
			height:100%;
			margin-left: 200px;
		}
		
		
		table,th,td 
		{
			border-bottom: 1px solid #ddd;
			border-collapse: collapse;
			padding:5px;
			text-align: left;
		}
		table{width: 70%;}
		
		body {padding:10px;}
		</style>

		
	
	<head>
		<title>Staff - cafe Point of Sales System</title>
	</head>
<% 
StaffBean Cur = (StaffBean) session.getAttribute("Current");
ArrayList<PriceBean> List = new ArrayList<>();
List = PriceDAO.getAll();
if (Cur!= null)
{
%>
	<body>

		<h2>Price</h2>
		<table>
			  <tr>
			    <th>ID</th>
			    <th>Value</th>    
			    <th>Discount</th>
			    <th colspan ="2"></th>
			  </tr>
			   <%for (int i = 0; i < List.size(); i++) { %>
			   <tr>
			    <td><%= List.get(i).getID()%></td>
			    <td><%= List.get(i).getValue()%></td> 
			    <td><%= List.get(i).getDiscount()%></td>
			    <td> <button class="btn" onclick="document.location='PriceUpdate.jsp?id=<%= List.get(i).getID()%>'">Update</button><br></td>
			    <td>
			     <form action="PriceD" method="post">
			      <input type="hidden" id="Deleteid" name="Deleteid" value="<%=List.get(i).getID()%>">
			      <input type="submit" value="Delete" class="btn">	
			      </form> </td>
			  </tr>
    		 <% } %>
	    </table>
	    <br> <br> <br>
     	<a class="btn" href="#add" onclick="window.open('PriceAdd.jsp','Add','width=400,height=300')">Add Pricing</a>

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
