<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.staff.StaffBean"%>
<%@page import="project.product.*"%>
<%@page import="project.price.*"%>
<%@page import="project.staff.*"%>
<%@page import="project.sales.*"%>
<%@page import="project.outlet.*"%>

<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=windows-1256">
<title>Receipt</title>
<style type="text/css">
@media print 
{
  #printPageButton 
	  {
	    display: none;
	  }
}

body
{
	text-align: center
}
table
{
	text-align: left; 
	width:100%; 
	padding: 10px;
}
tr
{
	padding: 10px
}
.end
{
	text-align: right;
}
</style>
</head>
<%
int id = Integer.parseInt(request.getParameter("id")); 
SalesBean Sales = SalesDAO.Find(id);
StaffBean Staff = StaffDAO.Find(Sales.getStaff_ID());
OutletBean Outlet = OutletDAO.Find(Staff.getOutlet_ID());
ArrayList<SalesProductBean> ProductList = new ArrayList<>();
ProductList = SalesDAO.getProduct(Sales.getID());
%>
<body>
<h1>Receipt</h1>
<h3><%=Outlet.getName() %>(<%=Outlet.getID() %>)</h3>
<h4><%=Staff.getName()%></h4>
<h4>Customer ID = <%=Sales.getID() %></h4>

<table >
<tr>
	<td>Date:</td>
	<td colspan="2"><%=Sales.getDate()%></td>
</tr>

<tr>
	<th>No</th>
	<th>Items</th>
	<th class="end">Price(RM)</th>
</tr>

  <%for (int i = 0; i < ProductList.size(); i++) {%>
			   <tr>
			    <td><%= i+1%></td>
			    <td><%= ProductList.get(i).getProduct_ID()%> - <%=ProductDAO.Find(ProductList.get(i).getProduct_ID()).getName()%></td>
			    <td class="end"><%= PriceDAO.Find(ProductDAO.Find(ProductList.get(i).getProduct_ID()).getPrice_ID()).getValue()%></td> 
</tr > <%}%>

<tr>
	<th></th>
	<th>Total</th>
	<th class="end"><%=Sales.getSales_Total() %></th>
</tr>
</table>
<br><br><br><br>
<button  id="printPageButton" onclick="window.print()">Print</button>

</body>
</html>