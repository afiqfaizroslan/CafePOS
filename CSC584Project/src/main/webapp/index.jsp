<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="project.staff.*"%>

<html>
	<head>
	
		<meta http-equiv="Content-Type"
			content="text/html; charset=windows-1256">
		<style>
		.content 
		{
			text-align: center;
			padding:20px;
			margin-top:40px;
			background-color:#FCE9B5; 
			height:100%;
			margin-left: 200px;
		}
		.bg 
		{
  			background-image: url("cafebg.jpg");
  			height: 100%; 
  			background-position: center;
  			background-repeat: no-repeat;
  			background-size: cover;
		}
		div 
		{
			text-align: center;
		}
		
		table,th,td 
		{
	 		margin-left: auto;
	 	 	margin-right: auto;
			border:1px solid black;
			border-collapse: collapse;
		}
		table{width: 50%;}
		
		body {margin:0;}

		.topbar {
		  list-style-type: none;
		  margin: 0;
		  padding: 0;
		  overflow: auto;
		  background-color: #AF7E65;
		  position: fixed;
		  top: 0;
		  width: 100%;
		}
		
		/* profile */
		.profile 
		{
  			text-align: left;
 			width: 30px;
  			height: 30px;
  			border-radius: 40%;
		}
		
		.sidebar
		{
		list-style-type: none;
 		margin: 0;
 		padding: 10px;
 		width: 10%;
  		background-color:  #AF7E65;
  		 color: black;
  		position: fixed;
  		height:100%;
  		overflow: auto;
		}
		
		li a, li 
		{
		  display: block;
		  color: black;
		  text-align: center;
		  padding: 8px 16px;
		  text-decoration: none;
		}
		li a
		{
		  
		  border-bottom: 1px solid #555;
		}
		
		li a:hover:not(.active) {
		  background-color: #F8E8C9;
		}
		
		.active {
		  background-color: #DB1619;
				}
		.topbtn
			{
			  color: black;
			  text-align: center;
			}
			/* The grid container */
		.grid-container {
		  background-color: #FCE9B5;
		  display: grid;
		  grid-gap: 50px 50px;
		  grid-template-columns: auto auto auto;
		  padding: 30px;
		  margin-left: auto;
	 	  margin-right: auto;
		}
		
		.grid-item {
		  background-color: #AF7E65;
		  border: 0;
		  padding: 40px;
		  font-size: 30px;
		  text-align: center;
		  height: 100px;
		}
		.grid-item:hover:not(.active) {
		  background-color: #F8E8C9;
		}
					
		</style>
	
	<head>
		<title>Home - cafe Point of Sales System</title>
	</head>
<% 

StaffBean Cur = (StaffBean) session.getAttribute("Current");
if (Cur!= null)
{
%>
	
	<body style="background: #FCE9B5">
	<div class="topbar">
		<h2 class="topbtn">Cafe Point of Sales System </h2>
		</div>
		
		<ul class="sidebar">
			<li style ="padding-top:20px;"><h4>Welcome</h4></li>
			<li><img src="profile.jpg" alt="profile" class="profile" /></li>
			<li style ="padding-top:20px;padding-bottom:100px;"><%=Cur.getName()%></li>
		  	<li><a href='Sales.jsp'>Sales</a></li>
			<li><a href='Staff.jsp'>Staff</a></li>
			<li><a href='Outlet.jsp'> Outlet</a></li>
			<li><a href='Product.jsp'> Product</a></li>
			<li><a href='SalesReport.jsp'> Sales Report</a></li>
			<li style="border-bottom:0"><a class="active" href="logoutS">Logout</a></li>
		</ul>

		
		<div class="content">
		<br><br>
		<h2>Home</h2>
		<div class="grid-container">
		  <div class="grid-item" onclick="location.href='Sales.jsp';" style="cursor: pointer;"> Sales</div>
		  <div class="grid-item" onclick="location.href='Staff.jsp';" style="cursor: pointer;">Staff</div>
		  <div class="grid-item" onclick="location.href='Outlet.jsp';" style="cursor: pointer;">Outlet</div>  
		  <div class="grid-item" onclick="location.href='Product.jsp';" style="cursor: pointer;">Product</div>
		  <div class="grid-item" onclick="location.href='SalesReport.jsp';" style="cursor: pointer;">Sales Report</div>
		</div>
		</div>
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
<% 
}
%>
</html>
