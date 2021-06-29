<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="project.staff.*"%>
<%@page import="project.product.*"%>
<%@page import="project.price.*"%>
<%@page import="project.sales.*"%>



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
			padding-bottom:200px;
			margin-top:40px;
			background-color:#FFFFFF;
			height:90%;
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
			
		.float{
					position:fixed;
					width:60px;
					height:60px;
					bottom:140px;
					right:140px;
					background-color:#0C9;
					color:#FFF;
					border-radius:50px;
					text-align:center;
					box-shadow: 2px 2px 3px #999;
				}
		</style>
	
	<head>
		<title>Staff - cafe Point of Sales System</title>
	</head>
<% 
StaffBean Cur = (StaffBean) session.getAttribute("Current");
SalesBean sales = (SalesBean) session.getAttribute("sales");
ArrayList<SalesBean> List = new ArrayList<>();
ArrayList<SalesBean> Listall = new ArrayList<>();
ArrayList<HashMap<String, String>> ListPro = new ArrayList<>();
ArrayList<HashMap<String, String>> ListP= new ArrayList<>();

if (Cur!= null)
{
	Listall =SalesDAO.getAll();
	List = SalesDAO.getByStaff();
	ListPro =SalesDAO.getByProduct();
	ListP =SalesDAO.getProductlist();
%>
	<body>
		<div class="topbar">
		<h2 class ="topbtn">Cafe Point of Sales System </h2>
		</div>
		
		<ul class="sidebar">
			<li style ="padding-top:20px;">Welcome</li>
			<li style ="padding-top:20px;padding-bottom:100px;"><%=Cur.getName()%></li>
			<li><a href='index.jsp'>Home</a></li>
		  	<li><a href='Sales.jsp' >Sales</a></li>
			<li ><a href='Staff.jsp'> Staff</a></li>
			<li><a href='Outlet.jsp'> Outlet</a></li>
			<li><a href='Product.jsp'> Product</a></li>
			<li><a href='SalesReport.jsp' class="onpage"> Sales Report</a></li>
			<li style="border-bottom:0"><a class="active" href="logoutS">Logout</a></li>
		</ul>

		
		<div class="content">
		
		<h2 id="All">All Sales</h2>
		<table>
		<tr>
		<th>Sales ID</th>
		<th>Staff ID</th>
		<th>Date</th>
		<th>Total sales</th>
		</tr>
		  <%for (int i = 0; i < Listall.size(); i++) {%>
			   <tr>
			    <td><%= Listall.get(i).getID()%></td>
			    <td><%= Listall.get(i).getStaff_ID()%></td>
			    <td><%= Listall.get(i).getDate()%></td>
			    <td><%= Listall.get(i).getSales_Total()%></td> 
			  </tr>
    		 <% } %>
		</table>

	<br><br><br><br>
	
		<h2 id="ByStaff" >Sales by staff</h2>
		<table>
		<tr>
		<th>Outlet</th>
		<th>Staff ID</th>
		<th>Staff Name</th>
		<th>Total sales</th>
		</tr>
		  <%for (int i = 0; i < List.size(); i++) {%>
			   <tr>
			    <td><%= StaffDAO.Find(List.get(i).getStaff_ID()).getOutlet_ID()%></td>
			    <td><%= List.get(i).getStaff_ID()%></td>
			    <td><%= StaffDAO.Find(List.get(i).getStaff_ID()).getName()%></td>
			    <td><%= List.get(i).getSales_Total()%></td> 
			  </tr>
    		 <% } %>
		</table>
		
		<br><br><br><br>
		
		<h2 id="ByProduct">Sales by Product</h2>
		<table>
		<tr>
		<th>Product</th>
		<th>Quantity Sold</th>
		</tr>
		  <%
		  for (int i = 0; i < ListP.size(); i++) {
		  %>
			   <tr>
			    <td><%= ListP.get(i).get("Product")%></td>
			    <td><%= ListP.get(i).get("Total")%></td> 
			  </tr>
    		 <% } %>
		</table>
		<h4>Details</h4>
		<table>
		<tr>
		<th>Outlet</th>
		<th>Staff ID</th>
		<th>Staff Name</th>
		<th>Product ID</th>
		<th>Quantity sold</th>
		</tr>
		  <%for (int i = 0; i < ListPro.size(); i++) {%>
			   <tr>
			    <td><%= StaffDAO.Find(ListPro.get(i).get("Staff")).getOutlet_ID()%></td>
			    <td><%= ListPro.get(i).get("Staff")%></td>
			    <td><%= StaffDAO.Find(ListPro.get(i).get("Staff")).getName()%></td>
			    <td><%= ListPro.get(i).get("Product")%></td>
			    <td><%= ListPro.get(i).get("Total")%></td> 
			  </tr>
    		 <% } %>
		</table>
		
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
