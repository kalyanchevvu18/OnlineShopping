<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<center>
	<div> 
			<font face="Georgia" color="#FFFAFA" size="7" style="text-decoration:underline;"><b>
				Admin LogIn
				</b></font>
		</div>	

<div> 
		
			<form action="login">
				<table>
					<tr>	
						<td> <b> Enter Admin Id : </b></td>
						<td>  <input type="text" name="id" required="required"> </td>
					</tr>
					<tr>	
						<td> <b>Enter Admin Password : </b> </td>
						<td> <b><input type="text" name="password" required="required"> </b></td>
					</tr>
				</table><br> 
				<input type="submit">
			</form>
		</div>
		</center>
</body>
</html>