<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type"content="text/html; charset=windows-1256">
	<style>
	div 
	{
		text-align: center;
	}
	
	table 
	{
 		margin-left: auto;
 	 	margin-right: auto;
		border:0px
	}
	</style>
	<head>
		<title>login - cafe Point of Sales System</title>
	</head>
	<body>
	<div>
			<h2>Cafe Point of Sales System </h2>
			<form action="logins" method="post">
				<table>
					<tr>
						<td>Staff ID</td>
						<td>: <input type="text" name="ID"> </td>
					</tr>
					<tr>
						<td>Password</td>
						<td>: <input type="password" name="Password"><br>
					</tr>			
				</table>
				<br>
				<input type="submit" value="login">				
			</form>
	</div>

	</body>
</html>