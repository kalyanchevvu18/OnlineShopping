<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div style="padding-top: 10px; padding-left:17cm; text-align: center"> 

<fieldset style="width: 380px; height: 300px; border-radius: 10px; border: solid 2px black;">
	<form action ="paidBill">		
	
	<h2><input type="hidden" name="ProductNo" value="${c.getProductNo()}">Product id : ${c.getProductNo()}</h2>
	<h2><input type="hidden" name="quantity" value="${c.getQuantity()}">Quantity : ${c.getQuantity()}</h2>
	
	<h2><input type="hidden" name="grandTotal" value="${c.getGrandtotal()}">Grand Total : ${c.getGrandtotal()}</h2>
	<h2><input type="hidden" name="totalDiscount" value="${c.getTotdiscount()}">Discount on Total : ${c.getTotdiscount()}</h2>
	<h2><input type="hidden" name="payamount" value="${c.getPayamount()}">Payable Amount : ${c.getPayamount()}</h2> 
	
	<center><input type="submit"></center>
	
</form>
	</fieldset>
	</div>

</body>
</html>