<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.staff.StaffBean"%>
<%@page import="project.outlet.*"%>



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
		
		body {margin:0;}

		.topbar {
		  list-style-type: none;
		  margin: 0;
		  padding: 0;
		  overflow: auto;
		  background-color: #333;
		  position: fixed;
		  top: 0;
		  width: 100%;
		}
		.sidebar
		{
		list-style-type: none;
 		margin: 0;
 		padding: 10px;
 		width: 10%;
  		background-color:  #333;
  		 color: white;
  		position: fixed;
  		height:100%;
  		overflow: auto;
		}
		
		li a, li 
		{
		  display: block;
		  color: white;
		  text-align: center;
		  padding: 8px 16px;
		  text-decoration: none;
		}
		li a
		{
		  
		  border-bottom: 1px solid #555;
		}
		
		li a:hover:not(.active) {
		  background-color: #111;
		}
		
		.active {
		  background-color: #DB1619;
				}
		.topbtn
			{
			  color: white;
			  text-align: center;
			}
		</style>
	
	<head>
		<title>Staff - cafe Point of Sales System</title>
	</head>
<% 
StaffBean Cur = (StaffBean) session.getAttribute("Current");
ArrayList<OutletBean> List = new ArrayList<>();
List = OutletDAO.getAll();
if (Cur!= null)
{
%>
	<body>
		<div class="topbar">
		<h2 class="topbtn">Cafe Point of Sales System </h2>
		</div>
		
		<ul class="sidebar">
			<li style ="padding-top:20px;">Welcome</li>
			<li style ="padding-top:20px;padding-bottom:100px;"><%=Cur.getName()%></li>
			<li><a href='index.jsp'>Home</a></li>
		  	<li><a href='Sales.jsp'>Sales</a></li>
			<li><a href='Staff.jsp'> Staff</a></li>
			<li><a href='Outlet.jsp' class="onpage"> Outlet</a></li>
			<li><a href='Product.jsp'> Product</a></li>
			<li><a href='SalesReport.jsp'> Sales Report</a></li>
			<li style="border-bottom:0"><a class="active" href="logoutS">Logout</a></li>
		</ul>

		
		<div class="content">
		<br><br>
		<h2>Outlet administration </h2>
		<table>
			  <tr>
			    <th>Outlet ID</th>
			    <th>Outlet Name</th> 
			    <th>Details</th>
			    <th></th>
			  </tr>
			   <%for (int i = 0; i < List.size(); i++) { %>
			   <tr>
			    <td><%= List.get(i).getID()%></td>
			    <td><%= List.get(i).getName()%></td> 
			    <td><%= List.get(i).getDetails()%></td>
			    <td Style="text-align:center;"> 
			    <form action="OutletD" method="post">
			      <input type="hidden" id="Currentid" name="Currentid" value="<%=Cur.getOutlet_ID() %>">
			      <input type="hidden" id="Deleteid" name="Deleteid" value="<%=List.get(i).getID()%>">
			      <input type="submit" value="Delete" class="btn">	
			      </form>
			     </td>
			  </tr>
    		 <% } %>
	    </table>
	    <br> <br> <br>
     	<a class="btn" href="#Update" onclick="window.open('OutletUpdate.jsp','Update','width=400,height=300')">Update  </a>
     	<a class="btn" href="#add" onclick="window.open('OutletAdd.jsp','Add','width=400,height=300')">Add</a>
		</div>
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
