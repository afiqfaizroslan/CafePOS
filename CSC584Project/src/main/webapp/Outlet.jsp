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
		  background-color: #936147;
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
		  background-color: #936147;
		  color: white;
		  padding: 10px 15px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		}
		.btn:hover, .btn:active
		{
		  background-color: #936147;
		}
		.onpage
		{
		background-color: #936147;
		}
		.content 
		{
			padding:20px;
			padding-bottom:200px;
			margin-top:40px;
			background-color:#FCE9B5;
			height:90%;
			margin-left: 200px;
		}
		
		/* profile */
		.profile 
		{
  			text-align: left;
 			width: 30px;
  			height: 30px;
  			border-radius: 40%;
		}
		
		.grid-container {
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
		
		table,th,td 
		{
			border-bottom: 1px solid #936147;
			border-collapse: collapse;
			padding:5px;
			text-align: left;
		}
		table{width: 70%;}
		
		body 
		{
			background-image: url('cafebg.jpg');
			background-repeat: no-repeat;
			background-attachment: fixed;
			background-size: cover;
			margin:0;
		}

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
		.sidebar
		{
		list-style-type: none;
 		margin: 0;
 		padding: 10px;
 		width: 10%;
  		background-color:  #AF7E65;
  		 color: white;
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
	 	<title>Outlet-cafe Point of Sales System </title>
	</head>
<% 
StaffBean Cur = (StaffBean) session.getAttribute("Current");
ArrayList<OutletBean> List = new ArrayList<>();

if (Cur!= null)
{
	List = OutletDAO.getAll();
%>
	<body>
		<div class="topbar">
		<h2 class="topbtn">Cafe Point of Sales System </h2>
		</div>
		
		<ul class="sidebar">
			<li style ="padding-top:20px;"><h4>Welcome</h4></li>
			<li><img src="profile.jpg" alt="profile" class="profile" /></li>
			<li style ="padding-top:20px;padding-bottom:100px;"><%=Cur.getName()%></li>
			<li><a href='index.jsp'>Home</a></li>
		  	<li><a href='Sales.jsp'>Sales</a></li>
			<li><a href='Staff.jsp'> Staff</a></li>
			<li><a href='Outlet.jsp' class="onpage"> Outlet</a></li>
			<li><a href='Product.jsp'> Product</a></li>
			<li><a href='SalesReport.jsp'> Sales Report</a></li>
			<li style="border-bottom:0"><a class="active" href="logoutS">Logout</a></li>
		</ul>

		
		<div class="content" align="center">
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
			    <form action="OutletD" method="post" onsubmit="return confirm('Do you really want to delete this outlet?All data of outlet include staff will be deleted');">
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
	<body style="background: #EBCCB1">
	<div>
		<h2>Please login first!</h2>
		<br><br>	
		<a href='Login.jsp'>Login</a>
	</div>
 	</body>
<%}%>

</html>
