<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Insert title here</title>
<style>
	h1 
	{
	font-family:Georgia;
	color:"black";
	size:"10";
	align: "center";
	padding-left: 100px;
	} 
</style>

</head>
<body>
<center>

<div style="padding-top: 130px;"> 
 <h1>Add Products</h1>
	<form action="addProduct">
	
	<table>  <br><br><br>
	
			<tr>	
					<td> <b>	Enter The Product Id: </b></td>
			 		<td><input type="text" name="productNo" ></td>
			 </tr> 
			<tr>
				<td> <b>Enter The Product Name :</b></td>
				<td> <input type="text" name="productName" ></td>
			 </tr>
			<tr>
				<td> <b> Enter The Product Price : </b></td>
				<td> <input type="text" name="productPrice" ></td>
			</tr>
			<tr>
				<td><b>	Enter The Quantity :</b></td>
				<td> <input type="text" name="quantity" ></td>
			 </tr>
			<tr>
				<td> <b>Enter The Discount :</b></td> 
				<td> <input type="text" name="discount" ></td>
			</tr>
			
			</table><br>
		<center>	<input type="submit"> </center>	
	
			</form>
	
	</div> 
</center>
</body>
</html>	